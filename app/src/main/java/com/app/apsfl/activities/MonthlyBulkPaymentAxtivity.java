package com.app.apsfl.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apsfl.R;
import com.app.apsfl.adapters.ListAdapter;
import com.app.apsfl.adapters.Product;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.monthyearpicker.YearMonthPickerDialog;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import static com.app.apsfl.activities.ChangePassword.TAG;

/**
 * Created by User on 09-04-2018.
 */

public class MonthlyBulkPaymentAxtivity extends AppCompatActivity implements ResponseHandler {
    private RequestHandler requestHandler;
    ArrayList<HashMap<String, String>> contactList;
    HashMap<String, String> contact;
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Product> search_products = new ArrayList<Product>();
    public static String[] selectedcafs;
    public static final String mypreference = "mypref";
    private Toolbar mToolbar;
    public static ListAdapter boxAdapter, searchBoxAdapter;
    String availLmt, pableLmt, LMOCODE, firstPaymentRequest = "2";
    static String text = null;
    public static TextView totalAmnt;
    TextView availableLimit, paybleLimit, selected_date;
    float totalAmount = 0;
    Product p;
    private ProgressDialog pDialog;
    ListView lvMain;
    static String monthYear;
    Button monthly, nextNum, search_bulk;
    int minteger = 1;
    boolean setValue;
    String date_Text;
    EditText search_et;
    ClipboardManager cm = null;
    ClipData myClip = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulk_payment);
        monthly = (Button) findViewById(R.id.btn_submit);
        nextNum = (Button) findViewById(R.id.btn_next);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        selected_date = (TextView) findViewById(R.id.selecteddate);
        totalAmnt = (TextView) findViewById(R.id.totalAmt);
        availableLimit = (TextView) findViewById(R.id.availLimit);
        paybleLimit = (TextView) findViewById(R.id.paybleAmt);
        lvMain = (ListView) findViewById(R.id.lvMain);
        search_et = (EditText) findViewById(R.id.et_search);
        search_bulk = (Button) findViewById(R.id.search_bulk);

        setupToolBar();
        contactList = new ArrayList<>();
        requestHandler = new RequestHandler();
        setMonthYear();
        //  selsectMonthYear();

        cm = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);


        search_et.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
                int len = arg0.toString().trim().length();
                if (len == 0) {
                    //lvMain.setAdapter(boxAdapter);
                    if (boxAdapter != null) {
                        lvMain.setAdapter(boxAdapter);
                    }
                }
            }
        });

        search_bulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = search_et.getText().toString().toLowerCase(Locale.getDefault());

                JSONObject searchRequestData = new JSONObject();
                try {
                    searchRequestData.put("from", monthYear);
                    searchRequestData.put("tenantCode", LMOCODE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                requestHandler.searchBulkPayment(MonthlyBulkPaymentAxtivity.this, searchRequestData, Constants.SEARCH_BULK_PAYMENT);
            }
        });

        nextNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//
                setValue = ListAdapter.checkvalue;
                if (boxAdapter.getBox().size() > 0) {
                    AlertDialog.Builder adb = new AlertDialog.Builder(MonthlyBulkPaymentAxtivity.this);
                    adb.setTitle("Do you want to continue with out submit payment?");
                    //adb.setIcon(android.R.drawable.ic_dialog_alert);
                    adb.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // nextList();
                            if (!(monthYear == null)) {
                                nextMonthlyPaymentRequest();
                            } else {
                                Toast.makeText(MonthlyBulkPaymentAxtivity.this, "Please select month and year", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                    adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adb.show();

                } else {
                    nextMonthlyPaymentRequest();
                }
            }
        });

        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = new String();
                float totalAmount = 0;

                if (searchBoxAdapter != null) {

                    if (searchBoxAdapter.getBox().size() > 0) {
                        if (totalAmount > Float.valueOf(availLmt)) {
                            Toast.makeText(MonthlyBulkPaymentAxtivity.this, "total amount should be less than available limit.", Toast.LENGTH_LONG).show();
                        } else {
                            if (!(monthYear == null)) {
                                makeMonthlyPayment();
                            } else {
                                Toast.makeText(MonthlyBulkPaymentAxtivity.this, "Please select month and year", Toast.LENGTH_SHORT).show();

                            }
                        }
                    } else {
                        //Toast.makeText(MonthlyBulkPaymentAxtivity.this, "no size", Toast.LENGTH_SHORT).show();
                    }
                }


                if (boxAdapter.getBox().size() > 0) {
                    if (totalAmount > Float.valueOf(availLmt)) {
                        Toast.makeText(MonthlyBulkPaymentAxtivity.this, "total amount should be less than available limit.", Toast.LENGTH_LONG).show();
                    } else {
                        if (!(monthYear == null)) {
                            makeMonthlyPayment();
                        } else {
                            Toast.makeText(MonthlyBulkPaymentAxtivity.this, "Please select month and year", Toast.LENGTH_SHORT).show();

                        }
                    }
                }

            }
        });
    }

    private void setMonthYear() {
        final Calendar calendar = Calendar.getInstance();
        YearMonthPickerDialog yearMonthPickerDialog = new YearMonthPickerDialog(this,
                calendar,
                new YearMonthPickerDialog.OnDateSetListener() {
                    @Override
                    public void onYearMonthSet(int year, int month) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
                        int monNum = month;
                        calendar.set(Calendar.MONTH, monNum);
                        String month_name = dateFormat.format(calendar.getTime());
                        selected_date.setText("Selected month&year : " + month_name);
                        monthYear = (year + "-" + (month + 1));
                        if (!(monthYear == null)) {
                            LMOCODE = MainActivity.mLmoCode;
                            //LMOCODE="LMO11429";
                            Log.d("Code", LMOCODE);
                            makeMonthlyPaymentRequest();

                        }
                    }
                });
        yearMonthPickerDialog.setMinYear(2016);
        yearMonthPickerDialog.setMaxYear(2018);
        yearMonthPickerDialog.show();


    }


    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    private void selsectMonthYear() {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_HOLO_DARK,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {


                        if (monthOfYear + 1 == 1) {

                            date_Text = "January";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 2) {

                            date_Text = "February";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 3) {

                            date_Text = "March";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 4) {

                            date_Text = "April";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 5) {

                            date_Text = "May";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 6) {

                            date_Text = "June";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 7) {

                            date_Text = "July";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 8) {

                            date_Text = "August";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 9) {

                            date_Text = "September";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 10) {

                            date_Text = "October";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);


                        } else if (monthOfYear + 1 == 11) {

                            date_Text = "November";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        } else if (monthOfYear + 1 == 12) {

                            date_Text = "December";
                            selected_date.setText("Selceted year&month : " + year + "-" + date_Text);

                        }
                        monthYear = (year + "-" + (monthOfYear + 1));
                        if (!(monthYear == null)) {
                            LMOCODE = MainActivity.mLmoCode;
                            Log.d("Code", LMOCODE);

                            makeMonthlyPaymentRequest();

                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.setTitle("Select Month And Year");
        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                System.exit(0);
            }
        });

        datePickerDialog.setCancelable(false);
        ((ViewGroup) datePickerDialog.getDatePicker()).findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(View.GONE);
        datePickerDialog.show();

    }


    private void nextMonthlyPaymentRequest() {
        minteger = minteger + 1;
        try {

            JSONObject requestData = new JSONObject();
            requestData.put("tenantCode", LMOCODE);
            //requestData.put("from", "2017-05");
            requestData.put("from", monthYear);
            requestData.put("offset", String.valueOf(minteger));
            Utils.showProgress(this, "Getting Users List..");
            requestHandler.bulkPayment(this, requestData, Constants.BULKPAYMET_NEXT_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void makeMonthlyPayment() {
        try {

            JSONObject requestData = new JSONObject();
            requestData.put("lmoCode", LMOCODE);
            requestData.put("effectiveDate", monthYear);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                requestData.put("bulkcustlist", new JSONArray(selectedcafs));
            }
            Utils.showProgress(this, "Loading");
            requestHandler.bulkPaymentDone(this, requestData, Constants.BULKPAYMET_REQUESTSEND);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void makeMonthlyPaymentRequest() {
        try {

            JSONObject requestData = new JSONObject();
            JSONObject searchRequestData = new JSONObject();
            requestData.put("tenantCode", LMOCODE);
            //requestData.put("from", "2017-05");
            requestData.put("from", monthYear);
            requestData.put("offset", "1");
            searchRequestData.put("from", monthYear);
            searchRequestData.put("tenantCode", LMOCODE);


            Utils.showProgress(this, "Getting Users List..");
            requestHandler.bulkPayment(this, requestData, Constants.BULKPAYMET_REQUEST);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.BULKPAYMET_REQUEST:
                if (response != null) {
                    Utils.cancelProgress();

                    try {
                        //Toast.makeText(this, "bulk response success!", Toast.LENGTH_SHORT).show();

                        String sample = response.toString();
                        JSONObject jsonObj = new JSONObject(sample);
                        availLmt = jsonObj.getString("lmoWalletBalence");
                        pableLmt = jsonObj.getString("creditLimit");
                        availableLimit.setText("WalletBalance =" + availLmt);
                        paybleLimit.setText("CreditLimit=" + pableLmt);

                        // Getting JSON Array node
                        JSONArray contacts = jsonObj.getJSONArray("customerslist");
                        if (contacts.length() > 0 && contacts != null) {
                            lvMain.setAdapter(null);
                            products.clear();
                            totalAmnt.setText("");
                            totalAmount = 0;
                            selectedcafs = null;
                            // looping through All Contacts
                            String id, mobile, name, dueamount;
                            for (int i = 0; i < contacts.length(); i++) {
                                Log.d("lenghth", contacts.length() + "");
                                JSONObject c = contacts.getJSONObject(i);
                                id = c.getString("cafno");
                                name = c.getString("customername");
                                mobile = c.getString("mobile");
                                dueamount = c.getString("dueamount");

                                // tmp hash map for single contact
                                contact = new HashMap<>();
                                // adding each child node to HashMap key => value
                                contact.put("cafno", id);
                                contact.put("customername", name);
                                contact.put("mobile", mobile);
                                contact.put("dueamount", dueamount);
                                // adding contact to contact list
                                contactList.add(contact);
                                products.add(new Product(id, name, mobile, dueamount,
                                        R.drawable.next_layout_bg, false));

                            }
                            boxAdapter = new ListAdapter(MonthlyBulkPaymentAxtivity.this, products);
                            lvMain.setAdapter(boxAdapter);
                            //loadSearchBulkData();
                            //lvMain.setTextFilterEnabled(true);
                            //boxAdapter.notifyDataSetChanged();
                        } else {
                            lvMain.setAdapter(null);
                            products.clear();
                            totalAmnt.setText("");
                            totalAmount = 0;
                            selectedcafs = null;
                            Toast.makeText(MonthlyBulkPaymentAxtivity.this, "no records found", Toast.LENGTH_SHORT).show();
                            nextNum.setEnabled(false);
                            monthly.setEnabled(false);
                        }
                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                               /* Toast.makeText(getApplicationContext(),
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
*/
                            }
                        });

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

            case Constants.BULKPAYMET_REQUESTSEND:
                if (response != null) {
                    Utils.cancelProgress();

                    try {
                        String sample = response.toString();
                        JSONObject jsonObj = new JSONObject(sample);
                        String responseString = jsonObj.getString("flag");

                        //Toast.makeText(this,responseString,Toast.LENGTH_LONG).show();
                        if (responseString.contains("The Monthly Payment Created Successfully.")) {

                            //boxAdapter.notifyDataSetChanged();
                            //*lvMain.setAdapter(null);
                           /* products.clear();
                            totalAmnt.setText("");
                            totalAmount=0;
                            selectedcafs=null;
                           */
                            AlertDialog.Builder adb = new AlertDialog.Builder(this);
                            adb.setTitle(responseString + "Do you want to continue?");
                            //adb.setIcon(android.R.drawable.ic_dialog_alert);
                            adb.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // boxAdapter.getBox().clear();
                                    nextMonthlyPaymentRequest();
                                    //boxAdapter.getBox().removeAll(products);


                                }
                            });


                            adb.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    System.exit(0);
                                    finish();
                                }
                            });
                            adb.show();

                        } else {
                            Toast.makeText(MonthlyBulkPaymentAxtivity.this, "" + responseString, Toast.LENGTH_SHORT).show();
                        }

                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();


                            }
                        });

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

            case Constants.BULKPAYMET_NEXT_REQUEST:
                String k;
                if (response != null) {
                    Utils.cancelProgress();


                    try {
                        String sample = response.toString();
                        JSONObject jsonObj = new JSONObject(sample);
                        availLmt = jsonObj.getString("lmoWalletBalence");
                        pableLmt = jsonObj.getString("creditLimit");
                        availableLimit.setText("WalletBalance =" + availLmt);
                        paybleLimit.setText("CreditLimit=" + pableLmt);

                        // Getting JSON Array node
                        JSONArray contacts = jsonObj.getJSONArray("customerslist");
                        if (contacts.length() > 0 && contacts != null) {
                            lvMain.setAdapter(null);
                            products.clear();
                            totalAmnt.setText("");
                            totalAmount = 0;
                            selectedcafs = null;
                            // looping through All Contacts
                            String id, mobile, name, dueamount;
                            for (int i = 0; i < contacts.length(); i++) {
                                Log.d("lenghth", contacts.length() + "");
                                JSONObject c = contacts.getJSONObject(i);
                                id = c.getString("cafno");
                                name = c.getString("customername");
                                mobile = c.getString("mobile");
                                dueamount = c.getString("dueamount");

                                // tmp hash map for single contact
                                contact = new HashMap<>();
                                // adding each child node to HashMap key => value
                                contact.put("cafno", id);
                                contact.put("customername", name);
                                contact.put("mobile", mobile);
                                contact.put("dueamount", dueamount);
                                // adding contact to contact list
                                contactList.add(contact);
                                products.add(new Product(id, name, mobile, dueamount,
                                        R.drawable.next_layout_bg, false));
                                boxAdapter = new ListAdapter(MonthlyBulkPaymentAxtivity.this, products);
                                lvMain.setAdapter(boxAdapter);
                                boxAdapter.notifyDataSetChanged();
                            }
                        } else {
                            lvMain.setAdapter(null);
                            products.clear();
                            totalAmnt.setText("");
                            totalAmount = 0;
                            selectedcafs = null;
                            Toast.makeText(MonthlyBulkPaymentAxtivity.this, "no records found", Toast.LENGTH_SHORT).show();
                            nextNum.setEnabled(false);
                            monthly.setEnabled(false);
                        }
                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                               /* Toast.makeText(getApplicationContext(),
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
*/
                            }
                        });
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

            case Constants.SEARCH_BULK_PAYMENT:
                if (response != null) {
                    Utils.cancelProgress();
                    InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    //Find the currently focused view, so we can grab the correct window token from it.
                    View view = this.getCurrentFocus();
                    //If no view currently has focus, create a new one, just so we can grab a window token from it
                    if (view == null) {
                        view = new View(this);
                    }
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    try {
                        String sample = response.toString();
                        JSONObject jsonObj = new JSONObject(sample);
                        // Getting JSON Array node
                        JSONArray contacts = jsonObj.getJSONArray("clist");
                        if (contacts.length() > 0 && contacts != null) {
                            //lvMain.setAdapter(null);
                            //products.clear();
                            contactList.clear();
                            search_products.clear();
                            String id, mobile, name, dueamount;
                            for (int i = 0; i < contacts.length(); i++) {
                                Log.d("lenghth", contacts.length() + "");
                                JSONObject c = contacts.getJSONObject(i);
                                id = c.getString("cafno");
                                name = c.getString("customername");
                                mobile = c.getString("mobile");
                                dueamount = c.getString("dueamount");

                                // tmp hash map for single contact
                                contact = new HashMap<>();
                                // adding each child node to HashMap key => value
                                contact.put("cafno", id);
                                contact.put("customername", name);
                                contact.put("mobile", mobile);
                                contact.put("dueamount", dueamount);
                                // adding contact to contact list
                                contactList.add(contact);
                                search_products.add(new Product(id, name, mobile, dueamount,
                                        R.drawable.next_layout_bg, false));

                            }
                            lvMain.setAdapter(null);
                            searchBoxAdapter = new ListAdapter(MonthlyBulkPaymentAxtivity.this, search_products);
                            //Toast.makeText(MonthlyBulkPaymentAxtivity.this, "search response success!" + searchBoxAdapter, Toast.LENGTH_SHORT).show();
                            lvMain.setAdapter(searchBoxAdapter);
                            lvMain.setTextFilterEnabled(true);
                            searchBoxAdapter.notifyDataSetChanged();
                            searchBoxAdapter.filter(text);
                        }
                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Toast.makeText(getApplicationContext(),"Json parsing error: " + e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }

        }


//        availableLimit.setText(availLmt);
//        paybleLimit.setText(pableLmt);

    }

    @Override
    public void onResume() {
        super.onResume();
        // makeMonthlyPaymentRequest();

    }


    public static void showResult() {
        String result = new String();
        float totalAmount = 0;
        for (Product p : boxAdapter.getBox()) {
            if (p.box) {
                //result += "\n" + p.price;
                totalAmount += Float.valueOf(p.price);
                totalAmnt.setText("TotalAmount=" + totalAmount);
            }
            selectedcafs = ListAdapter.result.split("\n");

        }

    }


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //Use the current date as the default date in the date picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog dpd = new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK, this, year, month, day) {
                //DatePickerDialog dpd = new DatePickerDialog(getActivity(),AlertDialog.THEME_HOLO_LIGHT,this,year, month, day){
                // DatePickerDialog dpd = new DatePickerDialog(getActivity(), AlertDialog.THEME_TRADITIONAL,this,year, month, day){
                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    int day = getContext().getResources().getIdentifier("android:id/day", null, null);
                    if (day != 0) {
                        View dayPicker = findViewById(day);
                        if (dayPicker != null) {
                            //Set Day view visibility Off/Gone
                            dayPicker.setVisibility(View.GONE);
                        }
                    }
                }
            };
            return dpd;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            //Set the Month & Year to TextView which chosen by the user
            // TextView tv = (TextView) getActivity().findViewById(R.id.txtMonthYear);

            // String stringOfDate = month + "/" + year;
            //  tv.setText(stringOfDate);
        }

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


    @Override
    public void onBackPressed() {
        //Execute your code here

        super.onBackPressed();
    }
}