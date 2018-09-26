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
import com.app.apsfl.activities.SelectVillageActivity;
import com.app.apsfl.models.VillageModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class VillageListAdapter
        extends RecyclerView.Adapter<VillageListAdapter.VillageViewHolder> {

    private Context mContext;
    private RealmList<VillageModel> villagesList;
    private List<VillageModel> matchedVillagesList;
    private Typeface typeface;
    ArrayList<String> objects;


    public VillageListAdapter(Context mContext, RealmList<VillageModel> mandalList) {
        this.mContext = mContext;
        this.villagesList = mandalList;
        typeface = Typeface.createFromAsset(mContext.getAssets(), "roboto/roboto-medium-webfont.ttf");
    }

    public VillageListAdapter(Context mContext, List<VillageModel> matchedVillagesList) {
        this.mContext = mContext;
        this.matchedVillagesList = matchedVillagesList;
        typeface = Typeface.createFromAsset(mContext.getAssets(), "roboto/roboto-medium-webfont.ttf");
    }

    @Override
    public VillageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_villages_list, parent, false);
        return new VillageViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(VillageViewHolder holder, int position) {
        //VillageModel model = villagesList.get(position);
        VillageModel model = matchedVillagesList.get(position);
        holder.villageName.setText(model.getVillageName());
        if (model.isVillageChecked()) {
            holder.villageCheckBox.setImageResource(R.mipmap.radio_on);
        } else {
            holder.villageCheckBox.setImageResource(R.mipmap.radio_off);
        }
    }

    @Override
    public int getItemCount() {
        //return villagesList.size();
        return matchedVillagesList.size();
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