package com.app.apsfl.adapters;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.utils.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import io.realm.RealmList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private LayoutInflater mInflater;
    private Fragment mFragment;
    private RealmList<ProductModel> productList;

    public ProductListAdapter(Fragment mFragment, RealmList<ProductModel> productList) {
        this.mInflater = LayoutInflater.from(mFragment.getActivity());
        this.mFragment = mFragment;
        this.productList = productList;
    }

    public void updateData(RealmList<ProductModel> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = mInflater.inflate(R.layout.row_product_list, parent, false);
        return new ProductViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final ProductModel model = productList.get(position);
        holder.productName.setText(model.getProductName());
        holder.productDate.setText(model.getProductDate());
        holder.productCode.setText(model.getProductCode());
        String serviceName = "";

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
                holder.productServiceName.setText(serviceName);
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d("Exception in ->", "Product Adapter");
            }

        holder.serviceLockInPeriod.setText(model.getProductLockInPeriod());
        holder.rentalCharge.setText(model.getProductRecurringCharge());
        holder.activationCharge.setText(model.getProductActivationCharge());
        holder.securityCharge.setText(model.getProductSecurityCharge());
        holder.productTax.setText(model.getProductTax());
        holder.productTotalCharge.setText(String.format("%s + Taxes", model.getProductRecurringCharge()));
        holder.tenantname.setText(model.getProductTenantName());
        if (model.isProductCheckBoxVisible()) {
            holder.productChecked.setVisibility(View.VISIBLE);
        } else {
            holder.productChecked.setVisibility(View.INVISIBLE);
        }
        if (model.isProductChecked()) {
            holder.productChecked.setImageResource(R.drawable.check_on);
        } else {
            holder.productChecked.setImageResource(R.drawable.check_off);
        }
        if (model.isProductInfoShown()) {
            holder.productMoreInfo.setText(mFragment.getActivity().getString(R.string.product_row_hide_info_text));
            holder.productInfoLayout.setVisibility(View.VISIBLE);
        } else {
            holder.productMoreInfo.setText(mFragment.getActivity().getString(R.string.product_row_show_info_text));
            holder.productInfoLayout.setVisibility(View.GONE);
        }
        holder.productMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListSelectionInterface actionInterface = (ListSelectionInterface) mFragment;
                actionInterface.onItemClicked(Constants.PRODUCT_SHOW_MORE, holder.getAdapterPosition());
            }
        });

        holder.productChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListSelectionInterface actionInterface = (ListSelectionInterface) mFragment;
                actionInterface.onItemClicked(Constants.PRODUCT_CHECK, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private TextView productName, productDate, productCode, productMoreInfo,
                securityCharge, activationCharge, rentalCharge,
                productServiceName, serviceLockInPeriod,
                productTax, productTotalCharge,tenantname;
        private LinearLayout productInfoLayout;
        private ImageView productChecked;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.productName);
            productDate = (TextView) itemView.findViewById(R.id.productDate);
            productCode = (TextView) itemView.findViewById(R.id.productCode);
            securityCharge = (TextView) itemView.findViewById(R.id.securityCharge);
            activationCharge = (TextView) itemView.findViewById(R.id.activationCharge);
            rentalCharge = (TextView) itemView.findViewById(R.id.rentalCharge);
            productMoreInfo = (TextView) itemView.findViewById(R.id.productMoreInfo);
            productServiceName = (TextView) itemView.findViewById(R.id.productServiceName);
            serviceLockInPeriod = (TextView) itemView.findViewById(R.id.serviceLockInPeriod);
            productTax = (TextView) itemView.findViewById(R.id.productTax);
            productTotalCharge = (TextView) itemView.findViewById(R.id.productTotalCharge);
            productChecked = (ImageView) itemView.findViewById(R.id.productCheckBox);
            productInfoLayout = (LinearLayout) itemView.findViewById(R.id.productInfoLayout);
            tenantname=(TextView) itemView.findViewById(R.id.tenantname);
        }
    }
}