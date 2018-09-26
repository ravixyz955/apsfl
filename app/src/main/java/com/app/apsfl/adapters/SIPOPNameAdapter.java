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
import com.app.apsfl.models.SIPOPModel;

import io.realm.RealmList;

/**
 * Created by Arbiva on 2/8/2017.
 */

public class SIPOPNameAdapter  extends RecyclerView.Adapter<SIPOPNameAdapter.MandalViewHolder> {

    private Context mContext;
    private RealmList<SIPOPModel> popNameList;
    private Typeface typeface;

    public SIPOPNameAdapter(Context mContext, RealmList<SIPOPModel> popNameList) {
        this.mContext = mContext;
        this.popNameList = popNameList;
        typeface = Typeface.createFromAsset(mContext.getAssets(), "roboto/roboto-medium-webfont.ttf");
    }

    public void updateData(RealmList<SIPOPModel> popNameList) {
        this.popNameList = popNameList;
        notifyDataSetChanged();
    }

    @Override
    public MandalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_pop_name_list, parent, false);
        return new SIPOPNameAdapter.MandalViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(MandalViewHolder holder, int position) {
        SIPOPModel model = popNameList.get(position);
        holder.popName.setText(model.getPopName());
        if (model.isPOPChecked()) {
            holder.popCheckBox.setImageResource(R.mipmap.radio_on);
        } else {
            holder.popCheckBox.setImageResource(R.mipmap.radio_off);
        }
    }

    @Override
    public int getItemCount() {
        return popNameList.size();
    }

    public class MandalViewHolder extends RecyclerView.ViewHolder {

        private TextView popName;
        private ImageView popCheckBox;

        public MandalViewHolder(View itemView) {
            super(itemView);
            popName = (TextView) itemView.findViewById(R.id.popName);
            popCheckBox = (ImageView) itemView.findViewById(R.id.popCheckBox);
            popName.setTypeface(typeface);
        }
    }
}
