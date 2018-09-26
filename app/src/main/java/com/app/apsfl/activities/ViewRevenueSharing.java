package com.app.apsfl.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apsfl.R;

import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.monthyearpicker.YearMonthPickerDialog;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.app.apsfl.activities.ChangePassword.TAG;

public class ViewRevenueSharing extends AppCompatActivity implements ResponseHandler {
    private RequestHandler requestHandler;
    private ResponseHandler mCallBack;
    private Toolbar mToolbar;
    String reqYear, reqMonth, LMOCODE, monthYear;
    String sino, lmo_code, apsfl_share, mso_share, lmo_share, total_bill, total_colleted, yet_to_collect, total_Prev_Balance;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, selected_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_revenue_sharing);

        t1 = (TextView) findViewById(R.id.lmocode_text);
        t2 = (TextView) findViewById(R.id.msoshare_text);
        t3 = (TextView) findViewById(R.id.apsflshare_text);
        t4 = (TextView) findViewById(R.id.lmoshare_text);
        t5 = (TextView) findViewById(R.id.totalbill_text);
        t6 = (TextView) findViewById(R.id.totalcollected_text);
        t7 = (TextView) findViewById(R.id.yettocollect_text);
        t8 = (TextView) findViewById(R.id.totalprevbalance_text);

        selected_date = (TextView) findViewById(R.id.selecteddate);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);

        requestHandler = new RequestHandler();
        setupToolBar();
        setMonthYear();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return false;
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setMonthYear() {
        Calendar calendar = Calendar.getInstance();
        YearMonthPickerDialog yearMonthPickerDialog = new YearMonthPickerDialog(this,
                calendar,
                new YearMonthPickerDialog.OnDateSetListener() {
                    @Override
                    public void onYearMonthSet(int year, int month) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
                        int monNum = month;
                        calendar.set(Calendar.MONTH, monNum);
                        String month_name = dateFormat.format(calendar.getTime());

                        selected_date.setText("Selected month&year : " + month_name);
                        monthYear = (year + "-" + (month + 1));
                        reqYear = String.valueOf(year);
                        reqMonth = String.valueOf(month + 1);
                        if (!(monthYear == null)) {
                            LMOCODE = MainActivity.mLmoCode;
                            //LMOCODE="LMO11429";
                            Log.d("Code", LMOCODE);
                            makeRevenueSharingRequest();

                        }
                    }
                });
        yearMonthPickerDialog.setMinYear(2016);
        yearMonthPickerDialog.setMaxYear(2018);
        yearMonthPickerDialog.show();
    }

    private void makeRevenueSharingRequest() {
        //Toast.makeText(this, "request generated", Toast.LENGTH_SHORT).show();
        RequestHandler requestHandler = new RequestHandler();
        try {
            JSONObject requestData = new JSONObject();
            requestData.put("year", reqYear);
            requestData.put("month", reqMonth);
            requestData.put("lmocode", LMOCODE);
            Utils.showProgress(this, "Getting Users List..");
            requestHandler.bulkRevenueSharingRequest(this, requestData, Constants.REVENUESHARING_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.REVENUESHARING_REQUEST:
                if (response != null) {
                    Utils.cancelProgress();
                    try {
                        String sample = response.toString();
                        JSONObject jsonObj = new JSONObject(sample);
                        //sino = jsonObj.getString("sino");
                        lmo_code = jsonObj.getString("lmoCode");
                        apsfl_share = jsonObj.getString("apsflShare");
                        mso_share = jsonObj.getString("msoShare");
                        lmo_share = jsonObj.getString("lmoShare");
                        total_bill = jsonObj.getString("totalBill");
                        total_colleted = jsonObj.getString("totalCollected");
                        yet_to_collect = jsonObj.getString("yetToCollect");
                        total_Prev_Balance = jsonObj.getString("totalPrevBalance");

                        t1.setText(lmo_code);
                        t2.setText(mso_share);
                        t3.setText(apsfl_share);
                        t4.setText(lmo_share);
                        t5.setText(total_bill);
                        t6.setText(total_colleted);
                        t7.setText(yet_to_collect);
                        t8.setText(total_Prev_Balance);
                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                    }
                }
        }
    }

}
