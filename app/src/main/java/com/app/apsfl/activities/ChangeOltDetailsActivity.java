package com.app.apsfl.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apsfl.R;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.app.apsfl.activities.ChangePassword.TAG;

public class ChangeOltDetailsActivity extends AppCompatActivity implements ResponseHandler {
    private CheckBox change_address;
    private LinearLayout checkbox_visibility;
    private TextView update;
    static String caf_num, LMOCODE;
    private RequestHandler requestHandler;
    private Spinner oltserialnumber_spinner, oltportnumber_spinner, level1_slot_spinner, level2_slot_spinner, level3_slot_spinner, district_spinner, mandal_spinner, village_spinner;
    private static String[] values = null, portnum = null, finalPortnums = null, pop_olt_serialno_array = null, finall1SlotListArray = null, finall2SlotListArray = null, finall3SlotListArray = null, district_names = null, district_uid = null, mandal_names = null, mandal_id = null, village_names = null;
    private static String oltSerialNo = null, oltPortNo = null, l1Slot = null, l2Slot = null, l3Slot = null, dist_uid = null, mandalid = null, villageid = null;
    private static boolean isChkBxChecked = false;
    private static EditText address_line1, address_line2, locality, area;
    private static JSONObject requestData1 = null, requestData2 = null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_olt_details);

        change_address = (CheckBox) findViewById(R.id.change_address_checkbox);
        update = (TextView) findViewById(R.id.update);
        oltserialnumber_spinner = (Spinner) findViewById(R.id.olt_serialno);
        oltportnumber_spinner = (Spinner) findViewById(R.id.olt_portno);
        level1_slot_spinner = (Spinner) findViewById(R.id.level1_slot);
        level2_slot_spinner = (Spinner) findViewById(R.id.level2_slot);
        level3_slot_spinner = (Spinner) findViewById(R.id.level3_slot);
        district_spinner = (Spinner) findViewById(R.id.district_spinner);
        mandal_spinner = (Spinner) findViewById(R.id.mandal_spinner);
        village_spinner = (Spinner) findViewById(R.id.village_spinner);
        address_line1 = (EditText) findViewById(R.id.address_line1);
        address_line2 = (EditText) findViewById(R.id.address_line2);
        locality = (EditText) findViewById(R.id.locality);
        area = (EditText) findViewById(R.id.area);

        caf_num = PonChangeActivity.caf_num;
        LMOCODE = MainActivity.mLmoCode;
        requestHandler = new RequestHandler();

        final JSONObject requestData = new JSONObject();
        try {
            requestData.put("caf_num", caf_num);
            requestData.put("lmocode", LMOCODE);
            Utils.showProgress(ChangeOltDetailsActivity.this, "Getting Caf Details..");
            requestHandler.getLmoOlts(ChangeOltDetailsActivity.this, requestData, Constants.GET_LMO_OLTS);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        oltserialnumber_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                    oltportnumber_spinner.setAdapter(null);
                } else {

                    String portnums[] = portnum[position - 1].split(",");
                    oltSerialNo = pop_olt_serialno_array[position];

                    finalPortnums = new String[portnums.length + 1];
                    for (int i = 0; i < finalPortnums.length; i++) {
                        if (i == 0) {
                            finalPortnums[0] = "--Select--";
                        } else {
                            finalPortnums[i] = portnums[i - 1];
                        }
                    }
                    CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, finalPortnums);
                    oltportnumber_spinner.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        oltportnumber_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                } else {
                    String oltSrlNo = oltSerialNo;
                    oltPortNo = finalPortnums[position];
                    JSONObject requestData = new JSONObject();
                    try {
                        requestData.put("oltSrlNo", oltSrlNo);
                        requestData.put("lmoCode", LMOCODE);
                        requestData.put("oltPort", oltPortNo);
                        requestData.put("l1slot", "null");
                        requestHandler.getOLTPortSplitterData(ChangeOltDetailsActivity.this, requestData, Constants.OLT_SPLITTER_DATA);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        level1_slot_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                } else {
                    l1Slot = finall1SlotListArray[position];
                    String oltSrlNo = oltSerialNo;
                    String oltPortNum = oltPortNo;
                    //oltPortNo = finalPortnums[position];
                    JSONObject requestData = new JSONObject();
                    try {
                        requestData.put("oltSrlNo", oltSrlNo);
                        requestData.put("lmoCode", LMOCODE);
                        requestData.put("oltPort", oltPortNum);
                        requestData.put("l1slot", l1Slot);
                        requestHandler.getOLTPortSplitterData(ChangeOltDetailsActivity.this, requestData, Constants.L2_SLOT_DATA);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        district_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                } else {
                    dist_uid = district_uid[position];
                    JSONObject requestData = new JSONObject();
                    try {
                        requestData.put("districtId", dist_uid);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    requestHandler.getMandalsByDistrictId(ChangeOltDetailsActivity.this, requestData, Constants.ALL_MANDALS);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mandal_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //if (village_names[position].equalsIgnoreCase("--Select--")) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                } else {
                    String d_id = dist_uid;
                    mandalid = mandal_id[position];
                    JSONObject requestData = new JSONObject();
                    try {
                        requestData.put("districtId", d_id);
                        requestData.put("mandalId", mandalid);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    requestHandler.getVillagesByDistrictIdAndMandalId(ChangeOltDetailsActivity.this, requestData, Constants.PONCHANGE_GET_ALL_VILLAGES);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        village_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //if (village_names[position].equalsIgnoreCase("--Select--")) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                } else {
                    villageid = village_names[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        level2_slot_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                } else {
                    l2Slot = finall2SlotListArray[position];
                    String l1L2slot = l1Slot + "-" + l2Slot;
                    String oltSrlNo = oltSerialNo;
                    //oltSerialNo = pop_olt_serialno_array[position];
                    String oltPortNum = oltPortNo;
                    JSONObject requestData = new JSONObject();
                    try {
                        requestData.put("oltSrlNo", oltSrlNo);
                        requestData.put("lmoCode", LMOCODE);
                        requestData.put("oltPort", oltPortNum);
                        requestData.put("l1L2slot", l1L2slot);
                        requestHandler.getOLTL3PortSplitterData(ChangeOltDetailsActivity.this, requestData, Constants.L3_SLOT_DATA);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        level3_slot_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.d(TAG, "onItemSelected: " + "Do Nothing");
                } else {
                    l3Slot = finall3SlotListArray[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkbox_visibility = (LinearLayout) findViewById(R.id.checkbox_visibility);
        change_address.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                isChkBxChecked = isChecked;
                if (isChecked) {
                    checkbox_visibility.setVisibility(View.VISIBLE);
                    loadData();
                } else {
                    checkbox_visibility.setVisibility(View.GONE);
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChkBxChecked) {
                    loadAddressData();
                    loadrequestData();
                    requestHandler.updatePonChange(ChangeOltDetailsActivity.this, requestData2, Constants.UPDATE_PONCHANGE);
                    requestHandler.updatePonChangeAddress(ChangeOltDetailsActivity.this, requestData1, Constants.PONCHANGE_ADDRESS_UPDATE);
                } else {
                    loadrequestData();
                    requestHandler.updatePonChange(ChangeOltDetailsActivity.this, requestData, Constants.UPDATE_PONCHANGE);
                }
            }
        });
    }

    private void loadAddressData() {
        requestData1 = new JSONObject();
        Bundle bundle = getIntent().getExtras();
        try {
            requestData1.put("cafNo", bundle.getString("cafNo"));
            requestData1.put("addressLine1", address_line1.getText().toString());
            requestData1.put("addressLine2", address_line2.getText().toString());
            requestData1.put("locality", locality.getText().toString());
            requestData1.put("area", area.getText().toString());
            requestData1.put("village", villageid);
            requestData1.put("mandal", mandalid);
            requestData1.put("district", dist_uid);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void loadrequestData() {
        requestData2 = new JSONObject();
        String ponChangeUrl = "http://172.16.0.48:18080/apf/APFProcessor";
        String splitter = l1Slot + "-" + l2Slot + "-" + l3Slot;
        Bundle bundle = getIntent().getExtras();
                    /*bundle.getString("cafNo");
                    bundle.getString("lmoCode");
                    bundle.getString("oldOltSerialNo");
                    bundle.getString("oldPortId");
                    bundle.getString("ipAddress");
                    bundle.getString("onuId");*/
        try {
            requestData2.put("cafNo", bundle.getString("cafNo"));
            requestData2.put("newOltSerialNo", oltSerialNo);
            requestData2.put("newOltPort", oltPortNo);
            requestData2.put("oltIp", bundle.getString("ipAddress"));
            requestData2.put("oldOltPort", bundle.getString("oldPortId"));
            requestData2.put("ponChangeUrl", ponChangeUrl);
            requestData2.put("onuId", bundle.getString("onuId"));
            requestData2.put("splitter", splitter);
            requestData2.put("oldOltSrlNo", bundle.getString("oldOltSerialNo"));
            requestData2.put("lmoCode", bundle.getString("lmoCode"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        JSONObject requestData = new JSONObject();
        try {
            requestData.put("no_request_data", null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestHandler.getAllDistricts(ChangeOltDetailsActivity.this, requestData, Constants.ALL_DISTRICTS);

    }

    @Override
    public void responseHandler(Object response, int requestType) {
        JSONArray jsonarray = null;
        JSONObject jsonobject = null;
        String pop_olt_serialno = null, pop_oltlabelno = null, portno = null, sample = null, l1SlotList = null;
        String[] l1SlotListArray = null;
        switch (requestType) {
            case Constants.GET_LMO_OLTS:
                if (response != null) {
                    Utils.cancelProgress();
                    sample = response.toString();
                    try {
                        jsonarray = new JSONArray(sample);
                        values = new String[jsonarray.length() + 1];
                        pop_olt_serialno_array = new String[jsonarray.length() + 1];
                        portnum = new String[jsonarray.length()];
                        values[0] = "--Select--";
                        pop_olt_serialno_array[0] = "null";
                        for (int i = 0; i < jsonarray.length(); i++) {
                            jsonobject = jsonarray.getJSONObject(i);
                            pop_olt_serialno = jsonobject.getString("pop_olt_serialno");
                            pop_oltlabelno = jsonobject.getString("pop_oltlabelno");
                            portno = jsonobject.getString("portno");
                            pop_olt_serialno_array[i + 1] = pop_olt_serialno;
                            values[i + 1] = pop_olt_serialno + "(" + pop_oltlabelno + ")";
                            portnum[i] = portno;
                        }
                        CustomSpinnerAdapter adapter1 = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, values);
                        oltserialnumber_spinner.setAdapter(adapter1);
                    } catch (JSONException e) {
                        e.printStackTrace();
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
            case Constants.OLT_SPLITTER_DATA:
                if (response != null) {
                    Utils.cancelProgress();
                    sample = response.toString();
                    try {
                        jsonobject = new JSONObject(sample);
                        l1SlotList = jsonobject.getString("level1SlotList");
                        l1SlotList = l1SlotList.replaceAll("[\\[\\]\"]*", "");
                        l1SlotListArray = l1SlotList.split(",");
                        finall1SlotListArray = new String[l1SlotListArray.length + 1];
                        for (int i = 0; i < finall1SlotListArray.length; i++) {
                            if (i == 0) {
                                finall1SlotListArray[0] = "--Select--";
                            } else {
                                finall1SlotListArray[i] = l1SlotListArray[i - 1];
                            }
                        }

                        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, finall1SlotListArray);
                        level1_slot_spinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
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

            case Constants.L2_SLOT_DATA:
                if (response != null) {
                    Utils.cancelProgress();
                    sample = response.toString();
                    try {
                        jsonobject = new JSONObject(sample);
                        l1SlotList = jsonobject.getString("level2SlotList");
                        l1SlotList = l1SlotList.replaceAll("[\\[\\]\"]*", "");
                        l1SlotListArray = l1SlotList.split(",");
                        finall2SlotListArray = new String[l1SlotListArray.length + 1];
                        for (int i = 0; i < finall2SlotListArray.length; i++) {
                            if (i == 0) {
                                finall2SlotListArray[0] = "--Select--";
                            } else {
                                finall2SlotListArray[i] = l1SlotListArray[i - 1];
                            }
                        }

                        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, finall2SlotListArray);
                        level2_slot_spinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
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

            case Constants.L3_SLOT_DATA:
                if (response != null) {
                    Utils.cancelProgress();
                    sample = response.toString();
                    try {
                        jsonobject = new JSONObject(sample);
                        l1SlotList = jsonobject.getString("level3SlotList");
                        l1SlotList = l1SlotList.replaceAll("[\\[\\]\"]*", "");
                        l1SlotListArray = l1SlotList.split(",");
                        finall3SlotListArray = new String[l1SlotListArray.length + 1];
                        for (int i = 0; i < finall3SlotListArray.length; i++) {
                            if (i == 0) {
                                finall3SlotListArray[0] = "Select";
                            } else {
                                finall3SlotListArray[i] = l1SlotListArray[i - 1];
                            }
                        }

                        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, finall3SlotListArray);
                        level3_slot_spinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
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

            case Constants.ALL_DISTRICTS:
                if (response != null) {
                    Utils.cancelProgress();
                    sample = response.toString();
                    try {
                        JSONArray district_array = new JSONArray(sample);
                        district_names = new String[district_array.length() + 1];
                        district_uid = new String[district_array.length() + 1];
                        district_names[0] = "--Select--";
                        for (int i = 1; i < district_array.length(); i++) {
                            JSONObject district_bject = district_array.getJSONObject(i - 1);
                            district_names[i] = district_bject.getString("districtName");
                            district_uid[i] = district_bject.getString("districtUid");
                        }

                        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, district_names);
                        district_spinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
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

            case Constants.ALL_MANDALS:
                if (response != null) {
                    Utils.cancelProgress();
                    sample = response.toString();
                    try {
                        JSONArray mandal_array = new JSONArray(sample);
                        mandal_names = new String[mandal_array.length() + 1];
                        mandal_id = new String[mandal_array.length() + 1];
                        mandal_names[0] = "--Select--";
                        for (int i = 1; i < mandal_array.length(); i++) {
                            JSONObject mandal_bject = mandal_array.getJSONObject(i - 1);
                            mandal_names[i] = mandal_bject.getString("mandalName");
                            mandal_id[i] = mandal_bject.getString("mandalSlno");
                        }

                        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, mandal_names);
                        mandal_spinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
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

            case Constants.PONCHANGE_GET_ALL_VILLAGES:
                if (response != null) {
                    Utils.cancelProgress();
                    sample = response.toString();
                    try {
                        JSONArray mandal_array = new JSONArray(sample);
                        village_names = new String[mandal_array.length() + 1];
                        //mandal_id = new String[mandal_array.length() + 1];
                        village_names[0] = "--Select--";
                        for (int i = 1; i < mandal_array.length(); i++) {
                            JSONObject mandal_bject = mandal_array.getJSONObject(i - 1);
                            village_names[i] = mandal_bject.getString("villageName");
                            //mandal_id[i] = mandal_bject.getString("mandalSlno");
                        }

                        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ChangeOltDetailsActivity.this, village_names);
                        village_spinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
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

            case Constants.UPDATE_PONCHANGE:
                if (response != null) {
                    Utils.cancelProgress();
                    String ponchange_update = response.toString();
                    Utils.showPonUpdateDialog(ChangeOltDetailsActivity.this, "PonChange Info", ponchange_update, null);
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

            case Constants.PONCHANGE_ADDRESS_UPDATE:
                if (response != null) {
                    Utils.cancelProgress();
                    String ponchange_address_update = response.toString();
                    Utils.showPonAddressUpdateDialog(ChangeOltDetailsActivity.this, "PonChange Address Update Info", ponchange_address_update, null);
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
