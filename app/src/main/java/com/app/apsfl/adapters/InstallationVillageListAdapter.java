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
import com.app.apsfl.models.InstallationVillageModel;

import io.realm.RealmList;

/**
 * Created by Arbiva on 12/14/2016.
 */

public class InstallationVillageListAdapter extends RecyclerView.Adapter<InstallationVillageListAdapter.VillageViewHolder> {

    private Context mContext;
    private RealmList<InstallationVillageModel> villagesList;
    private Typeface typeface;

    public InstallationVillageListAdapter(Context mContext, RealmList<InstallationVillageModel> mandalList) {
        this.mContext = mContext;
        this.villagesList = mandalList;
        typeface = Typeface.createFromAsset(mContext.getAssets(), "roboto/roboto-medium-webfont.ttf");
    }
    public void updateData(RealmList<InstallationVillageModel> villagesList) {
        this.villagesList = villagesList;
        notifyDataSetChanged();
    }

    @Override
    public VillageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_villages_list, parent, false);
        return new VillageViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(VillageViewHolder holder, int position) {
        InstallationVillageModel model = villagesList.get(position);
        holder.villageName.setText(model.getVillageName());
        if (model.isVillageChecked()) {
            holder.villageCheckBox.setImageResource(R.mipmap.radio_on);
        } else {
            holder.villageCheckBox.setImageResource(R.mipmap.radio_off);
        }
    }

    @Override
    public int getItemCount() {
        return villagesList.size();
    }

    class VillageViewHolder extends RecyclerView.ViewHolder {

        private TextView villageName;
        private ImageView villageCheckBox;

        VillageViewHolder(View itemView) {
            super(itemView);
            villageName = (TextView) itemView.findViewById(R.id.villageName);
            villageCheckBox = (ImageView) itemView.findViewById(R.id.villageCheckBox);
            villageName.setTypeface(typeface);
        }
    }
}
