package com.app.apsfl.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.models.VOIPFeatureNameModel;

import java.util.ArrayList;

public class VOIPAdapter extends RecyclerView.Adapter<VOIPAdapter.CustomerViewHolder> {

    private Context mContext;
    private ArrayList<VOIPFeatureNameModel> data;

    public VOIPAdapter(Context mContext, ArrayList<VOIPFeatureNameModel> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_feature_name_list, parent, false);
        return new CustomerViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(CustomerViewHolder holder, int position) {
        VOIPFeatureNameModel nameModel = data.get(position);
        holder.featureCode.setText(nameModel.getFeatureCode());
        if (nameModel.isFeatureFilled()) {
            holder.featureCompleted.setImageResource(R.mipmap.checked);
        } else {
            holder.featureCompleted.setImageDrawable(null);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        private TextView featureCode;
        private ImageView featureCompleted;

        public CustomerViewHolder(View itemView) {
            super(itemView);
            featureCode = (TextView) itemView.findViewById(R.id.featureCode);
            featureCompleted = (ImageView) itemView.findViewById(R.id.featureCompleted);
        }
    }
}