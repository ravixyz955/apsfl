package com.app.apsfl.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.models.IptvDataModel;

import java.util.Locale;

import io.realm.RealmList;

public class SelectedCPEAdapter extends RecyclerView.Adapter<SelectedCPEAdapter.CPEViewHolder> {

    private RealmList<IptvDataModel> iptvDataList;
    private LayoutInflater mInflater;

    public SelectedCPEAdapter(Context mContext, RealmList<IptvDataModel> iptvDataList) {
        this.iptvDataList = iptvDataList;
        mInflater = LayoutInflater.from(mContext);
    }

    public void updateData(RealmList<IptvDataModel> iptvDataList) {
        this.iptvDataList = iptvDataList;
        notifyDataSetChanged();
    }

    @Override
    public CPEViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = mInflater.inflate(R.layout.row_selected_cpe, parent, false);
        return new CPEViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(CPEViewHolder holder, int position) {
        IptvDataModel iptvDataModel = iptvDataList.get(position);
        holder.selectedCPECount.setText(String.format(Locale.getDefault(), "%d", (position + 2)));
        holder.cpeModelName.setText(iptvDataModel.getIptvBoxModel());
        holder.cpeModelType.setText("IPTV/Android Box");
        holder.iptvSerialNo.setText(iptvDataModel.getIpTVSerialNumber());
        holder.iptvMacid.setText(iptvDataModel.getIpTVMacAddress());
        holder.iptvBoxPackages.setText(iptvDataModel.getIptvPkg().equals("--Select--") ?  "" : iptvDataModel.getIptvPkg());

        Double iptvModelTotal = 0.0;
        holder.cpePurchaseCost.setText(iptvDataModel.getUpfrontAmount());
        holder.cpeInstallmentCost.setText("0.00");
        holder.cpeModelTax.setText(String.format("Tax : %s", iptvDataModel.getIptvBoxTax()));
        iptvModelTotal = Double.valueOf(iptvDataModel.getUpfrontAmount()) + Double.valueOf(iptvDataModel.getIptvBoxTax());

       /* switch (iptvDataModel.getStbDevicePurchasePosition()) {
            case 1:   // Purchase
                holder.cpePurchaseCost.setText(iptvDataModel.getIptvPriceForInstallment());
                holder.cpeInstallmentCost.setText("0.00");
                holder.cpeModelTax.setText(String.format("Tax : %s", iptvDataModel.getIptvBoxTax()));
                iptvModelTotal = Double.valueOf(iptvDataModel.getIptvPriceForInstallment()) + Double.valueOf(iptvDataModel.getIptvBoxTax());
                break;

            case 2:   // Installment
                holder.cpePurchaseCost.setText("0.00");
                holder.cpeInstallmentCost.setText(iptvDataModel.getIptvPriceForInstallment());
                holder.cpeModelTax.setText(String.format("Tax : %s", 0.00));
                iptvModelTotal = 0.00;
                break;

            default:
                holder.cpePurchaseCost.setText("0.00");
                holder.cpeInstallmentCost.setText("0.00");
                holder.cpeModelTax.setText(String.format("Tax : %s", 0.00));
                iptvModelTotal = 0.00;
                break;
        }*/

        holder.cpeModelTotalCharge.setText(iptvModelTotal.toString());
    }

    @Override
    public int getItemCount() {
        return iptvDataList.size();
    }

    class CPEViewHolder extends RecyclerView.ViewHolder {

        private TextView selectedCPECount, cpeModelName, cpeModelType,
                cpePurchaseCost, cpeInstallmentCost, cpeModelTax, cpeModelTotalCharge, iptvSerialNo,iptvMacid,iptvBoxPackages;

        CPEViewHolder(View itemView) {
            super(itemView);
            selectedCPECount = (TextView) itemView.findViewById(R.id.selectedCPECount);
            cpeModelName = (TextView) itemView.findViewById(R.id.cpeModelName);
            cpeModelType = (TextView) itemView.findViewById(R.id.cpeModelType);
            cpePurchaseCost = (TextView) itemView.findViewById(R.id.cpePurchaseCost);
            cpeInstallmentCost = (TextView) itemView.findViewById(R.id.cpeInstallmentCost);
            cpeModelTax = (TextView) itemView.findViewById(R.id.cpeModelTax);
            cpeModelTotalCharge = (TextView) itemView.findViewById(R.id.cpeModelTotalCharge);
            iptvSerialNo = (TextView) itemView.findViewById(R.id.iptvSerialNo);
            iptvMacid = (TextView) itemView.findViewById(R.id.iptvMacid);
            iptvBoxPackages = (TextView) itemView.findViewById(R.id.iptvBoxPackages);
        }
    }

}