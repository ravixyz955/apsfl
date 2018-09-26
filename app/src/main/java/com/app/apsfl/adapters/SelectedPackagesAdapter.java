package com.app.apsfl.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.models.IptvDataModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.utils.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmList;

public class SelectedPackagesAdapter extends RecyclerView.Adapter<SelectedPackagesAdapter.SelectedPackagesViewHolder> {


    private Context mContext;
    private RealmList<ProductModel> selectedProductsList;
    private Typeface typeface;
    String lmoType;
    SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
    public SelectedPackagesAdapter(Context mContext, RealmList<ProductModel> selectedProductsList) {
        this.mContext = mContext;
        this.selectedProductsList = selectedProductsList;
        typeface = Typeface.createFromAsset(mContext.getAssets(), "roboto/roboto-medium-webfont.ttf");
    }

    public void updateData(RealmList<ProductModel> productList) {
        this.selectedProductsList = productList;
        notifyDataSetChanged();
    }

    @Override
    public SelectedPackagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_selected_products_services, parent, false);
        return new SelectedPackagesViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(SelectedPackagesViewHolder holder, int position) {
        lmoType=sharedPreferences.getString(Constants.TENANT_TYPE,"");
        ProductModel model = selectedProductsList.get(position);
        Realm realm=Realm.getDefaultInstance();
        float productSelectedCount=realm.where(IptvDataModel.class).equalTo("formTime",Constants.formTime).contains("iptvPkg",model.getProductName()).count();
        if( productSelectedCount == 0){
            productSelectedCount = 1;
        }
        holder.selectedProductsCount.setText(String.format(Locale.getDefault(), "%d", (position + 1)));
        switch (model.getProductType()) {
            case "B":
                holder.selectedPackageType.setText(String.format("%s", "Base"));
                break;

            case "A":
                holder.selectedPackageType.setText(String.format("%s", "Add On"));
                break;

            case "O":
                holder.selectedPackageType.setText(String.format("%s", "One Time"));
                break;
        }
        holder.selectedProductName.setText(model.getProductName());
        String serviceName = "";
        //if(!lmoType.equals("SI")) {
        try {
            JSONArray servicesJSON = new JSONObject(model.getProductData()).getJSONArray("servicesList");
            for (int i = 0; i < servicesJSON.length(); i++) {
                JSONObject eachService = servicesJSON.getJSONObject(i);
                if (i == 0) {
                    serviceName = eachService.getString("serviceName");
                } else {
                    serviceName += "\n" + eachService.getString("serviceName");
                }
            }
            holder.selectedServiceName.setText(serviceName);
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in ->", "Product Adapter");
        }
        /*}else{
            holder.selectedServiceName.setText(model.getSrvcName());
        }*/
        float recurringCharge = Float.parseFloat(model.getProductRecurringCharge());
        float totalTax = Float.parseFloat(model.getProductActivationTax()) * productSelectedCount;
        float activationCharge=Float.parseFloat(model.getProductActivationCharge()) * productSelectedCount;
        float securityCharge=Float.parseFloat(model.getProductSecurityCharge()) * productSelectedCount;
        float totalCharge = (securityCharge * Constants.billFrequencyValue)
                + activationCharge
                + totalTax;
        holder.packageRecurringCharge.setText(String.format(Locale.getDefault(), "%.2f", recurringCharge));
        holder.packageActivationCharge.setText(String.format(Locale.getDefault(), "%.2f", activationCharge));
        holder.packageSecurityCharge.setText(String.format(Locale.getDefault(), "%.2f", securityCharge));
        holder.selectedProductTax.setText(String.format(Locale.getDefault(), "%s :%.2f", "Tax", totalTax));
        holder.selectedProductCharge.setText(String.format(Locale.getDefault(), "%.2f", totalCharge));
    }

    @Override
    public int getItemCount() {
        return selectedProductsList.size();
    }

    class SelectedPackagesViewHolder extends RecyclerView.ViewHolder {

        private TextView selectedProductsCount, selectedPackageType, selectedProductName, selectedServiceName,
                packageRecurringCharge, packageActivationCharge, packageSecurityCharge,
                selectedProductTax, selectedProductCharge;

        SelectedPackagesViewHolder(View itemView) {
            super(itemView);
            selectedProductsCount = (TextView) itemView.findViewById(R.id.selectedProductsCount);
            selectedPackageType = (TextView) itemView.findViewById(R.id.selectedPackageType);
            selectedProductName = (TextView) itemView.findViewById(R.id.selectedProductName);
            selectedServiceName = (TextView) itemView.findViewById(R.id.selectedServiceName);
            packageRecurringCharge = (TextView) itemView.findViewById(R.id.packageRecurringCharge);
            packageActivationCharge = (TextView) itemView.findViewById(R.id.packageActivationCharge);
            packageSecurityCharge = (TextView) itemView.findViewById(R.id.packageSecurityCharge);
            selectedProductTax = (TextView) itemView.findViewById(R.id.selectedProductTax);
            selectedProductCharge = (TextView) itemView.findViewById(R.id.selectedProductCharge);

            selectedProductsCount.setTypeface(typeface);
        }
    }
}
