package com.app.apsfl.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.models.OfflineEditCafModel;
import com.app.apsfl.utils.Constants;

import io.realm.RealmList;

/**
 * Created by Arbiva on 2/6/2017.
 */

public class OfflineFormEditAdapter extends RecyclerView.Adapter<OfflineFormEditAdapter.OfflineEditFormViewHolder> {

    private Context context;
    private RealmList<OfflineEditCafModel> offlineFormList;
    private LayoutInflater layoutInflater;

    public OfflineFormEditAdapter(Context mContext, RealmList<OfflineEditCafModel> offlineFormList) {
        this.context = mContext;
        this.offlineFormList = offlineFormList;
        layoutInflater=LayoutInflater.from(context);
    }
    public void updateData(RealmList<OfflineEditCafModel> offlineFormList) {
        this.offlineFormList = offlineFormList;
        notifyDataSetChanged();
    }
    @Override
    public OfflineEditFormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row=layoutInflater.inflate(R.layout.offline_edit_row,parent,false);
        return new OfflineEditFormViewHolder(row);
    }

    @Override
    public void onBindViewHolder(final OfflineEditFormViewHolder holder, int position) {

        OfflineEditCafModel offlineEditCafModel=offlineFormList.get(position);
        holder.apsflTrackId.setText(offlineEditCafModel.getApsflTrackId());
        holder.customerName.setText(offlineEditCafModel.getOrganizationName());
        holder.cafNumber.setText(offlineEditCafModel.getCafNo());
        holder.ontLocation.setText(offlineEditCafModel.getCpeplace());
        holder.editPendingCAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListSelectionInterface actionInterface = (ListSelectionInterface) context;
                actionInterface.onItemClicked(Constants.PENDING_CAF_SILMO_EDIT, holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return offlineFormList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class OfflineEditFormViewHolder extends RecyclerView.ViewHolder{

        private TextView customerName,cafNumber,ontLocation,editPendingCAF,apsflTrackId;


        public OfflineEditFormViewHolder(View itemView) {
            super(itemView);
            apsflTrackId= (TextView) itemView.findViewById(R.id.editApsflTrackId);
            customerName = (TextView) itemView.findViewById(R.id.customerName);
            cafNumber = (TextView) itemView.findViewById(R.id.cafNumber);
            ontLocation = (TextView) itemView.findViewById(R.id.ontLocation);
            editPendingCAF = (TextView) itemView.findViewById(R.id.editOfflinePendingCAF);
        }
    }
}
