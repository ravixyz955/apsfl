package com.app.apsfl.adapters;

/**
 * Created by User on 05-04-2018.
 */

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apsfl.R;
import com.app.apsfl.activities.MonthlyBulkPaymentAxtivity;

import java.util.ArrayList;
import java.util.Locale;

public class ListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;
    int s;
    CheckBox cbBuy;
    float totalAmount = 0;
    //public static String totalAmount = null;
    public static String result = new String();
    public static boolean checkvalue = false;
    ArrayList<Product> box;
    private ArrayList<Product> arraylist;
    private TextView cafNo = null, mobileANo = null, custName = null;
    ClipboardManager cm = null;
    ClipData myClip = null;

    public ListAdapter(Context context, ArrayList<Product> products) {
        ctx = context;
        objects = products;
        this.arraylist = new ArrayList<Product>();
        this.arraylist.addAll(objects);

        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        cafNo = (TextView) view.findViewById(R.id.cafNo);
        mobileANo = (TextView) view.findViewById(R.id.mobNo);
        custName = (TextView) view.findViewById(R.id.custName);
        final Product p = getProduct(position);

        ((TextView) view.findViewById(R.id.cafNo)).setText(p.cafNo);
        ((TextView) view.findViewById(R.id.dueAmount)).setText(p.price + "");
        ((TextView) view.findViewById(R.id.custName)).setText(p.custName);
        ((TextView) view.findViewById(R.id.mobNo)).setText(p.mobNo + "");
        //((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);

        mobileANo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myClip = ClipData.newPlainText("text", p.mobNo);
                cm.setPrimaryClip(myClip);
                Toast t = Toast.makeText(ctx, "copied \t" + p.mobNo, Toast.LENGTH_SHORT);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    t.getView().setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#6DCC56")));
                }
                t.show();
                return true;
            }
        });

        cafNo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myClip = ClipData.newPlainText("text", p.cafNo);
                cm.setPrimaryClip(myClip);
                Toast t = Toast.makeText(ctx, "copied \t" + p.cafNo, Toast.LENGTH_SHORT);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    t.getView().setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#6DCC56")));
                }
                t.show();
                return true;
            }
        });

        custName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myClip = ClipData.newPlainText("text", p.custName);
                cm.setPrimaryClip(myClip);
                Toast t = Toast.makeText(ctx,
                        "copied \t" + p.custName, Toast.LENGTH_SHORT);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    t.getView().setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#6DCC56")));
                }
                t.show();
                return true;
            }
        });

        cbBuy = (CheckBox) view.findViewById(R.id.ColChk);
        cbBuy.setOnCheckedChangeListener(myCheckChangList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);
        return view;
    }

    Product getProduct(int position) {
        return ((Product) getItem(position));
    }

    public ArrayList<Product> getBox() {
        box = new ArrayList<Product>();
        for (Product p : objects) {
            if (p.box == true) {
                box.add(p);
            }


        }
        return box;
    }


    public ArrayList<Product> removebox() {
        ArrayList<Product> box1 = new ArrayList<Product>();
        for (Product p : objects) {
            if (!p.box) {
                box1.remove(p);
            }
        }
        return box1;
    }

    OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {

            boolean chk = buttonView.isChecked();

            getProduct((Integer) buttonView.getTag()).box = chk;

            if (chk) {

                if (getBox().size() > 0) {
                    result = "";
                    totalAmount = 0;
                    for (Product p : getBox()) {
                        totalAmount += Float.valueOf(p.price);
                        result += p.cafNo + "\n";
                    }
                } else {
                    totalAmount = 0;
                }

            } else {
                if (getBox().size() > 0) {
                    totalAmount = 0;
                    result = "";
                    for (Product p : getBox()) {
                        totalAmount += Float.valueOf(p.price);
                        result += p.cafNo + "\n";
                    }
                } else {
                    totalAmount = 0;
                }
            }
            MonthlyBulkPaymentAxtivity.selectedcafs = result.split("\n");
            MonthlyBulkPaymentAxtivity.totalAmnt.setText((String.valueOf(totalAmount)));
            // Toast.makeText(ctx, "" + totalAmount, Toast.LENGTH_SHORT).show();
            /*for (Product p : getBox()) {

                if (chk) {
                    // .makeText(ctx,""+isChecked,Toast.LENGTH_LONG).show();
                    if(getBox().size()==0) totalAmount=0;
                    checkvalue = true;
                    if (p.box) {
                        result += p.cafNo + "\n";
                        totalAmount += Float.valueOf(p.price);
                        Toast.makeText(ctx, "" + totalAmount, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if(getBox().size()==0) totalAmount=0;
                    totalAmount -= Float.valueOf(p.price);
                    result += p.cafNo + "\n";
                    Toast.makeText(ctx, "" + totalAmount, Toast.LENGTH_SHORT).show();

                }
                //  MonthlyBulkPaymentAxtivity.showResult();

            }*/
        }

            /*if(isChecked==true){
                checkvalue=true;
            }
            else{
                //box.remove(getProduct((Integer) buttonView.getTag()).box);
                checkvalue=false;
            }
*/


        // MonthlyBulkPaymentAxtivity.showResult();


    };


    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        objects.clear();
        if (charText.length() == 0) {
            objects.addAll(arraylist);
        } else {
            for (Product wp : arraylist) {
                if (wp.mobNo.toLowerCase(Locale.getDefault()).contains(charText) || wp.cafNo.toLowerCase(Locale.getDefault()).contains(charText) || wp.custName.toLowerCase(Locale.getDefault()).contains(charText)) {
                    objects.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
