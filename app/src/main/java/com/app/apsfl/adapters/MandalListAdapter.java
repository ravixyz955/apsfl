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
import com.app.apsfl.models.MandalModel;
import com.app.apsfl.models.VillageModel;

import io.realm.RealmList;
import io.realm.RealmResults;

public class MandalListAdapter
        extends RecyclerView.Adapter<MandalListAdapter.MandalViewHolder> {

    private Context mContext;
    private RealmList<VillageModel> mandalList;
    private Typeface typeface;

    public MandalListAdapter(Context mContext, RealmList<VillageModel> mandalList) {
        this.mContext = mContext;
        this.mandalList = mandalList;
        typeface = Typeface.createFromAsset(mContext.getAssets(), "roboto/roboto-medium-webfont.ttf");
    }
    public void updateData(RealmList<VillageModel> mandalList) {
        this.mandalList = mandalList;
        notifyDataSetChanged();
    }
    @Override
    public MandalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_mandals_list, parent, false);
        return new MandalViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(MandalViewHolder holder, int position) {
        VillageModel model = mandalList.get(position);
        holder.mandalName.setText(model.getMandalName());
        if (model.isVillageChecked()) {
            holder.mandalCheckBox.setImageResource(R.mipmap.radio_on);
        } else {
            holder.mandalCheckBox.setImageResource(R.mipmap.radio_off);
        }
    }

    @Override
    public int getItemCount() {
        return mandalList.size();
    }

    public class MandalViewHolder extends RecyclerView.ViewHolder {

        private TextView mandalName;
        private ImageView mandalCheckBox;

        public MandalViewHolder(View itemView) {
            super(itemView);
            mandalName = (TextView) itemView.findViewById(R.id.mandalName);
            mandalCheckBox = (ImageView) itemView.findViewById(R.id.mandalCheckBox);
            mandalName.setTypeface(typeface);
        }
    }
}
