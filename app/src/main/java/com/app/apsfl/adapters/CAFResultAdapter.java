package com.app.apsfl.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.models.CAFResultModel;
import com.app.apsfl.utils.Constants;

import java.util.ArrayList;

public class CAFResultAdapter extends
        RecyclerView.Adapter<CAFResultAdapter.CAFResultViewHolder> {

    SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
    String lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
    private LayoutInflater inflater;
    private ArrayList<CAFResultModel> cafResultList;
    private Context mContext;
    ;


    public CAFResultAdapter(final Context mContext,
                            final ArrayList<CAFResultModel> cafResultList) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.cafResultList = cafResultList;
    }

    @Override
    public CAFResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = inflater.inflate(R.layout.row_caf_results, parent, false);
        return new CAFResultViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final CAFResultViewHolder holder, int position) {
        CAFResultModel resultModel = cafResultList.get(position);
        holder.customerName.setText(resultModel.getCustomerFirstName() + " " + resultModel.getCustomerLastName());
        holder.cafNumber.setText(resultModel.getCafNumber());
        holder.cafResultCPEName.setText(resultModel.getAadhaarNumber());
        holder.cpeID.setText(resultModel.getCpeID());//date

        String PackagesReplace = resultModel.getPackages().replaceAll(",", ", ");

        holder.packages.setText(PackagesReplace);
        holder.status.setText(resultModel.getStatus());
        if (!resultModel.isIndividualCustomer()) {
            holder.HeaderCustomerName.setText("Organization Name");
        }
        holder.allocatedMobileNo.setText(resultModel.getAllocatedMobileNo());
        if (lmoType.equals("SI")) {

            String cpePlaceReplace = resultModel.getCpeplace().replace(",", ", ");

            holder.onuLocation.setText(cpePlaceReplace);
            holder.apsflTrackId.setText(resultModel.getApsflTrackID());
        } else {
            holder.apsflTrackId.setText(resultModel.getContactPersonMobileNo());
        }
        if (resultModel.getStatus().equals("PENDING FOR SELECT PACKAGES")) {
            if (lmoType.equals("SI")) {
                holder.selectPackages.setVisibility(View.GONE);
            } else {
                holder.selectPackages.setVisibility(View.VISIBLE);
            }

            holder.editCAF.setVisibility(View.VISIBLE);

        } else if (resultModel.getStatus().equals("PENDING FOR CAF EDIT")) {
            holder.selectPackages.setVisibility(View.GONE);
            holder.editCAF.setVisibility(View.VISIBLE);
            // Log.d("CAFResultAdapter","PENDING FOR CAF EDIT"+resultModel.getStatus().equals("PENDING FOR CAF EDIT"));
            Constants.isCAFInEditSILMO = true;
        } else {
            holder.selectPackages.setVisibility(View.GONE);
            holder.editCAF.setVisibility(View.GONE);
        }

        holder.selectPackages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListSelectionInterface actionInterface = (ListSelectionInterface) mContext;
                actionInterface.onItemClicked(Constants.SELECT_PACKAGES, holder.getAdapterPosition());
            }
        });
        holder.editCAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListSelectionInterface actionInterface = (ListSelectionInterface) mContext;
                actionInterface.onItemClicked(Constants.PENDING_CAF_EDIT, holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return cafResultList.size();
    }

    class CAFResultViewHolder extends RecyclerView.ViewHolder {

        private TextView customerName, cafNumber, cafResultCPEName, cpeID, packages, status,
                selectPackages, editCAF, apsflTrackId, registrationTitle, onuLocation, allocatedMobileNo, trackidHeader, HeaderCustomerName;
        private LinearLayout onuLocationLayout;

        CAFResultViewHolder(View itemView) {
            super(itemView);
            customerName = (TextView) itemView.findViewById(R.id.cafResultCustomerName);
            cafNumber = (TextView) itemView.findViewById(R.id.cafResultCAFNumber);
            cafResultCPEName = (TextView) itemView.findViewById(R.id.cafResultCPEName);
            cpeID = (TextView) itemView.findViewById(R.id.cafResultCPENumber);
            packages = (TextView) itemView.findViewById(R.id.cafResultPackageName);
            status = (TextView) itemView.findViewById(R.id.cafResultStatus);
            selectPackages = (TextView) itemView.findViewById(R.id.selectPackages);
            apsflTrackId = (TextView) itemView.findViewById(R.id.apsflTrackId);
            registrationTitle = (TextView) itemView.findViewById(R.id.registrationTitle);
            onuLocationLayout = (LinearLayout) itemView.findViewById(R.id.onuLocationLayout);
            onuLocation = (TextView) itemView.findViewById(R.id.onuLocation);
            allocatedMobileNo = (TextView) itemView.findViewById(R.id.allocatedMobileNo);
            trackidHeader = (TextView) itemView.findViewById(R.id.trackidHeader);
            HeaderCustomerName = (TextView) itemView.findViewById(R.id.HeaderCustomerName);
            if (lmoType.equals("SI")) {
                selectPackages.setText("Provide CPE Info");
                registrationTitle.setText("Registration");
            } else {
                trackidHeader.setText("MobileNo");
                onuLocationLayout.setVisibility(View.GONE);
            }
            editCAF = (TextView) itemView.findViewById(R.id.editCAF);
        }
    }
}
