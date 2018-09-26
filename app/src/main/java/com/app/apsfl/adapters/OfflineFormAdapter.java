package com.app.apsfl.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.RealmList;

public class OfflineFormAdapter extends RecyclerView.Adapter<OfflineFormAdapter.OfflineFormViewHolder> {

    private LayoutInflater layoutInflater;
    private RealmList<OfflineFormModel> offlineFormList;
    private Context mContext;
    SharedPreferences sharedPreferences= BaseApplication.getSharedPreferences();


    public OfflineFormAdapter(Context mContext, RealmList<OfflineFormModel> offlineFormList) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
        this.offlineFormList = offlineFormList;
    }

    @Override
    public OfflineFormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View offlineRow = layoutInflater.inflate(R.layout.row_offline_form_list, parent, false);
        return new OfflineFormViewHolder(offlineRow);
    }

    @Override
    public void onBindViewHolder(final OfflineFormViewHolder holder, int position) {
        OfflineFormModel formModel = offlineFormList.get(position);
        holder.offlineFormCount.setText(String.format(Locale.getDefault(), "%d", (position + 1)));
        holder.formSubmissionDate.setText(getReadableDate(formModel.getFormTime()));

            if (formModel.isFormUploaded()) {
                holder.formSubmissionStatus.setText(formModel.getStatusMessage());
                holder.formSubmissionImage.setImageResource(R.mipmap.submitted_form);
            } else {
                holder.formSubmissionStatus.setText(formModel.getStatusMessage());
                holder.formSubmissionImage.setImageResource(R.mipmap.pending_form);
            }
        //}

        holder.submitPendingCAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListSelectionInterface actionInterface = (ListSelectionInterface) mContext;
                actionInterface.onItemClicked(Constants.PENDING_CAF_SUBMIT, holder.getAdapterPosition());
            }
        });
        holder.editPendingCAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListSelectionInterface actionInterface = (ListSelectionInterface) mContext;
                actionInterface.onItemClicked(Constants.PENDING_CAF_EDIT, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public long getItemId(int position) {
        if (position < offlineFormList.size()) {
            return offlineFormList.get(position).getFormTime();
        }
        return RecyclerView.NO_ID;
    }

    @Override
    public int getItemCount() {
        return offlineFormList.size();
    }

    private String getReadableDate(long milliseconds) {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy hh:mm a",
                Locale.getDefault());
        return format.format(new Date(milliseconds));
    }

    public class OfflineFormViewHolder extends RecyclerView.ViewHolder {

        private TextView offlineFormCount, formSubmissionDate, formSubmissionStatus,
                submitPendingCAF, editPendingCAF,formCAFNumber,cafheader,trackidHeader;
        private ImageView formSubmissionImage;

        public OfflineFormViewHolder(View itemView) {
            super(itemView);
            offlineFormCount = (TextView) itemView.findViewById(R.id.offlineFormCount);
            formSubmissionDate = (TextView) itemView.findViewById(R.id.formSubmissionDate);
            formSubmissionStatus = (TextView) itemView.findViewById(R.id.formSubmissionStatus);
            submitPendingCAF = (TextView) itemView.findViewById(R.id.submitPendingCAF);
            editPendingCAF = (TextView) itemView.findViewById(R.id.editPendingCAF);
            formSubmissionImage = (ImageView) itemView.findViewById(R.id.formSubmissionImage);
            formCAFNumber= (TextView) itemView.findViewById(R.id.formCAFNumber);
            cafheader= (TextView) itemView.findViewById(R.id.cafheader);
            trackidHeader= (TextView) itemView.findViewById(R.id.trackidHeader);
            if(sharedPreferences.getString(Constants.TENANT_TYPE,"").equals("LMO")){
                formCAFNumber.setVisibility(View.GONE);
                cafheader.setVisibility(View.GONE);
                trackidHeader.setText("Submitted On");

            }
        }
    }

}
