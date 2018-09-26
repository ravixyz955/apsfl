package com.app.apsfl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.models.OltPortDetails;

import io.realm.RealmList;

public class OLTPortSpinnerAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private RealmList<OltPortDetails> data;

    public OLTPortSpinnerAdapter(Context context, RealmList<OltPortDetails> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return inflateView(position, R.layout.row_custom_spinner, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return inflateView(position, R.layout.row_spinner_dropdown, parent);
    }

    private View inflateView(int position, int layoutResource, ViewGroup parent) {
        View convertView = inflater.inflate(layoutResource, parent, false);
        TextView spinnerText = (TextView) convertView.findViewById(R.id.spinnerTextView);
        spinnerText.setText(data.get(position).getPortNo());
        return convertView;
    }
}