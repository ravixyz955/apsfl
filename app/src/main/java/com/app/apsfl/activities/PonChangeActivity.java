package com.app.apsfl.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apsfl.R;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import static com.app.apsfl.activities.ChangePassword.TAG;

public class PonChangeActivity extends Activity implements ResponseHandler {

    public static EditText caf_number;
    public static LinearLayout search_caf_layout, caf_details_visibility;
    private TextView change_olt_details_btn, caf_no, customer_name, lmo_code, customer_id, pop_name, district_name, mandal_name, olt_id, ipaddress, port_id, onuid;
    static String caf_num, LMOCODE, cafNo, lmoCode, oldOltSerialNo, ipAddress, oldPortId, onuId;
    private RequestHandler requestHandler;
    private static JSONObject oldReqData = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pon_change);

        caf_number = (EditText) findViewById(R.id.cafnumber_text);
        search_caf_layout = (LinearLayout) findViewById(R.id.search_caf_num);
        caf_details_visibility = (LinearLayout) findViewById(R.id.caf_details_visibility);
        change_olt_details_btn = (TextView) findViewById(R.id.change_olt_details);
        caf_no = (TextView) findViewById(R.id.caf_no);
        customer_name = (TextView) findViewById(R.id.customer_name);
        lmo_code = (TextView) findViewById(R.id.lmo_code);
        customer_id = (TextView) findViewById(R.id.customer_id);
        pop_name = (TextView) findViewById(R.id.pop_name);
        district_name = (TextView) findViewById(R.id.district_name);
        mandal_name = (TextView) findViewById(R.id.mandal_name);
        olt_id = (TextView) findViewById(R.id.olt_id);
        ipaddress = (TextView) findViewById(R.id.ipaddress);
        port_id = (TextView) findViewById(R.id.port_id);
        onuid = (TextView) findViewById(R.id.onuid);
        requestHandler = new RequestHandler();

        //Toast.makeText(this, "In PonChange", Toast.LENGTH_SHORT).show();
        search_caf_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caf_num = caf_number.getText().toString();
                LMOCODE = MainActivity.mLmoCode;
                JSONObject requestData = new JSONObject();
                try {
                    requestData.put("caf_num", caf_num);
                    requestData.put("lmocode", LMOCODE);
                    Utils.showProgress(PonChangeActivity.this, "Getting Caf Details..");
                    requestHandler.searchCafNumber(PonChangeActivity.this, requestData, Constants.SEARCH_CAF_NUMBER);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        change_olt_details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent i = new Intent(PonChangeActivity.this, ChangeOltDetailsActivity.class);
                bundle.putString("cafNo", cafNo);
                bundle.putString("lmoCode", lmoCode);
                bundle.putString("oldOltSerialNo", oldOltSerialNo);
                bundle.putString("oldPortId", oldPortId);
                bundle.putString("ipAddress", ipAddress);
                bundle.putString("onuId", onuId);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.SEARCH_CAF_NUMBER:
                if (response != null) {
                    Utils.cancelProgress();
                    String sample = response.toString();
                    if (sample.length() == 0) {
                        //Toast.makeText(this, "response empty", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "responseHandler: " + "String is empty");
                        Utils.showCafErrorDialog(PonChangeActivity.this, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                    } else {

                        JSONObject jsonObj = null;
                        try {
                            jsonObj = new JSONObject(sample);

                            caf_details_visibility.setVisibility(View.VISIBLE);
                            caf_no.setText(jsonObj.getString("cafno"));
                            cafNo = jsonObj.getString("cafno");
                            customer_name.setText(jsonObj.getString("custname"));
                            lmo_code.setText(jsonObj.getString("lmocode"));
                            lmoCode = jsonObj.getString("lmocode");
                            customer_id.setText(jsonObj.getString("custid"));
                            pop_name.setText(jsonObj.getString("pop_name"));
                            district_name.setText(jsonObj.getString("districtname"));
                            mandal_name.setText(jsonObj.getString("mandalname"));
                            olt_id.setText(jsonObj.getString("olt_id"));
                            oldOltSerialNo = jsonObj.getString("olt_id");
                            ipaddress.setText(jsonObj.getString("oltipaddr"));
                            ipAddress = jsonObj.getString("oltipaddr");
                            port_id.setText(jsonObj.getString("olt_portid"));
                            oldPortId = jsonObj.getString("olt_portid");
                            onuid.setText(jsonObj.getString("olt_onuid"));
                            onuId = jsonObj.getString("olt_onuid");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Log.e(TAG, "Couldn't get json from server.");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Couldn't get json from server. Check LogCat for possible errors!",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
                break;
        }
    }
}
