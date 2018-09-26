package com.app.apsfl.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.InstallationVillageModel;

import io.realm.RealmList;
import io.realm.RealmResults;

public class EnterpriseCustomerAdapter
        extends RecyclerView.Adapter<EnterpriseCustomerAdapter.CustomerViewHolder> {

    private Context mContext;
    private RealmList<EnterpriseCustomer> customerList;
    private Typeface typeface;

    public EnterpriseCustomerAdapter(Context mContext, RealmList<EnterpriseCustomer> customerList) {
        this.mContext = mContext;
        this.customerList = customerList;
        typeface = Typeface.createFromAsset(mContext.getAssets(), "roboto/roboto-medium-webfont.ttf");
    }
    public void updateData(RealmList<EnterpriseCustomer> customerList) {
        this.customerList = customerList;
        notifyDataSetChanged();
    }
    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_enterprise_customers_list, parent, false);
        return new CustomerViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(CustomerViewHolder holder, int position) {
        EnterpriseCustomer model = customerList.get(position);
        holder.customerName.setText(model.getCustomerName());
        if (model.isCustomerChecked()) {
            holder.customerCheckBox.setImageResource(R.mipmap.radio_on);
        } else {
            holder.customerCheckBox.setImageResource(R.mipmap.radio_off);
        }
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        private TextView customerName;
        private ImageView customerCheckBox;

        public CustomerViewHolder(View itemView) {
            super(itemView);
            customerName = (TextView) itemView.findViewById(R.id.enterpriseCustomerName);
            customerCheckBox = (ImageView) itemView.findViewById(R.id.customerCheckBox);
            customerName.setTypeface(typeface);
        }
    }
}
