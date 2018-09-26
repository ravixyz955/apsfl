package com.app.apsfl.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apsfl.Ekyc.APIError;
import com.app.apsfl.Ekyc.APIService;
import com.app.apsfl.Ekyc.APIUtils;
import com.app.apsfl.Ekyc.CaptureResponse;
import com.app.apsfl.Ekyc.EkycDetails;
import com.app.apsfl.Ekyc.ErrorUtils;
import com.app.apsfl.Ekyc.FormXML;
import com.app.apsfl.Ekyc.RDServiceInfo;
import com.app.apsfl.Ekyc.SplitXML;
import com.app.apsfl.R;
import com.app.apsfl.activities.MainActivity;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.CPEInfoModel;
import com.app.apsfl.models.CustomerAddressModel;
import com.app.apsfl.models.CustomerInfoModel;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.FormSpinnerModel;
import com.app.apsfl.models.IptvDataModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.TextFilterWithSpace;
import com.app.apsfl.utils.Utils;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import io.realm.Realm;
import io.realm.RealmResults;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerInfoFragment extends Fragment
        implements View.OnClickListener, FragmentBackStackListener,
        AdapterView.OnItemSelectedListener,
        UserActionInterface, ResponseHandler {

    private final String TAG = "CustomerInfoFragment";
    SharedPreferences sharedPreferences;
    private ProgressDialog progressDialog;

    private Calendar calendarInstance;
    private LinearLayout nextLayout;
    private LinearLayout formGenderLayout;
    private RequestHandler requestHandler;
    private Spinner customerTitleSpinner, billFrequencySpinner;
    private EditText formAadhaarEditText,
            firstNameEditText, middleNameEditText, surNameEditText,
            formFatherEditText,
            formEmailEditText, formContactPersonName,
            formPANEditText, formTANEditText;
    private TextView formCAFNumber, formLMOName, formLMOWallet,
            formLMOCreditLimit, formLMORemainingLimit, formCustomerDOB, formContactPersonHeader,
            middleNameHeader, surNameHeader, fatherNameHeader, aadhaarTitle;
    private RadioGroup formGenderRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    private LinearLayout enterpriseCustomerLayout;
    private Button retrieveAadhaarButton;
    private Spinner billCycleSpinner, segmentSpinner, channelSpinner;
    private String enterpriseCustomerCode = null;
    private static Response<EkycDetails> Dupresponse = null;
    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    calendarInstance.set(Calendar.YEAR, year);
                    calendarInstance.set(Calendar.MONTH, monthOfYear);
                    calendarInstance.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    Log.d(TAG, "Year " + year + " month " + monthOfYear + " day " + dayOfMonth);
                    updateCustomerDOB();
                }
            };
    private String cafStatus = "0";
    private boolean isdataFromAadhar = false;
    EditText edtFCount = null;
    EditText edtTimeout = null;
    TextView txtResult = null;
    EditText edtLockKey = null;
    Spinner Ftype = null;
    Spinner FingerPos = null;
    Spinner Format = null;
    CheckBox checkBox = null;
    String finalXml;
    public static String addressSample;
    String fCount = "";
    String fType = "";
    String format = "";
    String fingerpos = "";
    String timeout = "";
    String key = "";

    String vendorID = "";
    String productID = "";

    CaptureResponse captureResponse;

    private int INFO_REQUEST = 0;
    private int CAPTURE_REQUEST = 1;

    private String PB510_SCANNER = "PB510";
    private String PBABAS_SCANNER = "PBABAS400";

    public static int PB510_2000_ProductID = 2000;
    public static int PB510_2000_VendorID = 11576;

    public static int PB510_2010_ProductID = 2010;
    public static int PB510_2010_VendorID = 11576;

    public static int PB400_VendorID = 5246;
    public static int PB400_ProductID = 8214;

    private String DeviceINFO_KEY = "DEVICE_INFO";
    private String RD_SERVICE_INFO = "RD_SERVICE_INFO";
    private String PID_DATA = "PID_DATA";
    private String PID_OPTIONS = "PID_OPTIONS";
    APIService apiService;
    static LayoutInflater Maininflater;
    String captureRequestXML = "";
    String CapturedFingerprintXML;
    String sendxml;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "\t" + "onCreateView()");
        View layoutView = inflater.inflate(R.layout.fragment_customer_info, container, false);
        Maininflater = inflater;
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading Aadhar data...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);

        initViews(layoutView);
        setupToolBar();
        getWalletBalance();
        setSpinnerData();
        registerListeners();
        setData();
        caaptureFingerPrintData();
        apiService = APIUtils.getAPIService();
        return layoutView;
    }

    private void caaptureFingerPrintData() {
        //middleNameHeader.setText("");
        fCount = "1";//edtFCount.getText().toString();
        if (fCount == null || fCount.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter finger Count", Toast.LENGTH_SHORT).show();
            return;
        }

        int fingerCount = Integer.parseInt(fCount);
        if (fingerCount < 0 || fingerCount > 10) {
            Toast.makeText(getActivity(), "Invalid Fingerprint Count, Please enter valid finger count", Toast.LENGTH_SHORT).show();
            return;
        }
        fType = "FMR";//Ftype.getSelectedItem().toString();
        if (fType.equals("FType")) {
            Toast.makeText(getActivity(), "Please select fingerprint type", Toast.LENGTH_SHORT).show();
            return;
        }
        if (fType.equalsIgnoreCase("FMR")) {
            fType = "0";
        } else if (fType.equalsIgnoreCase("FIR")) {
            fType = "1";
        }
        format = "XML";//Format.getSelectedItem().toString();
        if (format.equals("Format")) {
            Toast.makeText(getActivity(), "Please select format", Toast.LENGTH_SHORT).show();
            return;
        }
        if (format.equalsIgnoreCase("XML")) {
            format = "0";
        } else if (fType.equalsIgnoreCase("ProtoBuf")) {
            format = "1";
        }

        fingerpos = "UNKNOWN";//FingerPos.getSelectedItem().toString();
        timeout = "5000";//edtTimeout.getText().toString();
        if (timeout == null || timeout.isEmpty()) {

            Toast.makeText(getActivity(), "Please select capture timeout", Toast.LENGTH_SHORT).show();
            return;
        }

       /* if (checkBox.isChecked())
            FormXML.isUIRequired = false;
        else
            FormXML.isUIRequired = true;
*/
        FormXML.isUIRequired = false;
        String connectedDevice = isDeviceConnected();
        if (connectedDevice != null && !connectedDevice.isEmpty()) {
            if (connectedDevice.equals(PB510_SCANNER)) {
                Toast.makeText(getActivity(), "FingerPrintScannerConected", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent("in.gov.uidai.rdservice.fp.INFO");
                sendIntent.setPackage("com.precision.pb510.rdservice");
                startActivityForResult(sendIntent, INFO_REQUEST);
            } else if (connectedDevice.equals(PBABAS_SCANNER)) {
                Toast.makeText(getActivity(), "FingerPrintScannerConected", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent("in.gov.uidai.rdservice.fp.INFO");
                sendIntent.setPackage("com.precision.tcs1s.rdservice");
                startActivityForResult(sendIntent, INFO_REQUEST);
            } else {
                Toast.makeText(getActivity(), "Scanner not connected", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(getActivity(), "Scanner not connected", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    private void initViews(View view) {
        sharedPreferences = BaseApplication.getSharedPreferences();
        calendarInstance = Calendar.getInstance();
        requestHandler = new RequestHandler();
        LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.mainLayout);
        formGenderLayout = (LinearLayout) mainLayout.findViewById(R.id.formGenderLayout);
        formCAFNumber = (TextView) mainLayout.findViewById(R.id.formCAFNumber);
        customerTitleSpinner = (Spinner) mainLayout.findViewById(R.id.formCustomerTitleSpinner);
        billFrequencySpinner = (Spinner) mainLayout.findViewById(R.id.billFrequencySpinner);
        LinearLayout tenantBalanceLayout = (LinearLayout) mainLayout.findViewById(R.id.tenantBalanceLayout);
        formLMOName = (TextView) tenantBalanceLayout.findViewById(R.id.lmoName);
        formLMOWallet = (TextView) tenantBalanceLayout.findViewById(R.id.lmoWallet);
        formLMOCreditLimit = (TextView) tenantBalanceLayout.findViewById(R.id.lmoCreditLimit);
        formLMORemainingLimit = (TextView) tenantBalanceLayout.findViewById(R.id.lmoRemainingLimit);
        formAadhaarEditText = (EditText) mainLayout.findViewById(R.id.formAadhaarEditText);
        retrieveAadhaarButton = (Button) mainLayout.findViewById(R.id.retrieveAadhaarButton);
        firstNameEditText = (EditText) mainLayout.findViewById(R.id.firstNameEditText);
        middleNameHeader = (TextView) mainLayout.findViewById(R.id.middleNameHeader);
        middleNameEditText = (EditText) mainLayout.findViewById(R.id.middleNameEditText);
        surNameHeader = (TextView) mainLayout.findViewById(R.id.surNameHeader);
        surNameEditText = (EditText) mainLayout.findViewById(R.id.surNameEditText);
        fatherNameHeader = (TextView) mainLayout.findViewById(R.id.fatherNameHeader);
        formFatherEditText = (EditText) mainLayout.findViewById(R.id.formFatherEditText);
        formEmailEditText = (EditText) mainLayout.findViewById(R.id.formEmailEditText);
        formContactPersonHeader = (TextView) mainLayout.findViewById(R.id.formContactPersonHeader);
        formContactPersonName = (EditText) mainLayout.findViewById(R.id.formContactPersonName);
        LinearLayout spinnerLayout = (LinearLayout) mainLayout.findViewById(R.id.spinnerLayout);
        spinnerLayout.setVisibility(View.GONE);
        billCycleSpinner = (Spinner) mainLayout.findViewById(R.id.billCycleSpinner);
        segmentSpinner = (Spinner) mainLayout.findViewById(R.id.segmentSpinner);
        channelSpinner = (Spinner) mainLayout.findViewById(R.id.channelSpinner);
        formGenderRadioGroup = (RadioGroup) mainLayout.findViewById(R.id.formGenderRadioGroup);
        maleRadioButton = (RadioButton) formGenderRadioGroup.findViewById(R.id.maleRadioButton);
        femaleRadioButton = (RadioButton) formGenderRadioGroup.findViewById(R.id.femaleRadioButton);
        formGenderRadioGroup.check(R.id.maleRadioButton);
        formCustomerDOB = (TextView) mainLayout.findViewById(R.id.formCustomerDOB);
        //no need in d6
        //should remove respected code
        enterpriseCustomerLayout = (LinearLayout) mainLayout.findViewById(R.id.enterpriseCustomerLayout);
        enterpriseCustomerLayout.setVisibility(View.GONE);
        formPANEditText = (EditText) enterpriseCustomerLayout.findViewById(R.id.formPANEditText);
        formTANEditText = (EditText) enterpriseCustomerLayout.findViewById(R.id.formTANEditText);
        enterpriseCustomerLayout.setVisibility(View.GONE);
        nextLayout = (LinearLayout) view.findViewById(R.id.nextLayout);
        TextView nextScreenName = (TextView) nextLayout.findViewById(R.id.nextScreenName);
        nextScreenName.setText(R.string.customer_address_screen_name);
        aadhaarTitle = (TextView) mainLayout.findViewById(R.id.aadhaarTitle);

    }

    private void setupToolBar() {
        ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.fragment_customer_info_title);
        }
    }

    private void registerListeners() {

        nextLayout.setOnClickListener(this);
        billFrequencySpinner.setOnItemSelectedListener(this);
        if (Constants.cafType == 1) {
            formCustomerDOB.setOnClickListener(this);
            retrieveAadhaarButton.setOnClickListener(this);
            formAadhaarEditText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
            formAadhaarEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        Utils.hideKeyboard(v);
                        retrieveAadhaarButton.performClick();
                        return true;
                    }
                    return false;
                }
            });

            firstNameEditText.setFilters(new InputFilter[]{new TextFilterWithSpace()});
            middleNameEditText.setFilters(new InputFilter[]{new TextFilterWithSpace()});
            surNameEditText.setFilters(new InputFilter[]{new TextFilterWithSpace()});
            formFatherEditText.setFilters(new InputFilter[]{new TextFilterWithSpace()});
            formContactPersonName.setFilters(new InputFilter[]{new TextFilterWithSpace()});
        }


    }

    private void setData() {
        if (!Constants.cafNumber.equals("")) {
            formCAFNumber.setText(String.format("CAF Number : %s", Constants.cafNumber));
        } else {
            formCAFNumber.setText(String.format("CAF Number : %s", "NA"));
        }
        if (Constants.aadhaarData != null) {
            firstNameEditText.setEnabled(false);
            middleNameEditText.setEnabled(false);
            surNameEditText.setEnabled(false);
            formCustomerDOB.setClickable(false);
            femaleRadioButton.setEnabled(false);
            maleRadioButton.setEnabled(false);

        }
        Realm realm = Realm.getDefaultInstance();
        formLMOName.setText(sharedPreferences.getString(Constants.LMO_NAME, ""));
        switch (Constants.cafType) {
            case 1:
                //formContactPersonHeader.setText(getString(R.string.contact_person_text));
                formContactPersonHeader.setVisibility(View.GONE);
                formContactPersonName.setVisibility(View.GONE);
                enterpriseCustomerLayout.setVisibility(View.GONE);
                formAadhaarEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                break;

            case 2:
                formContactPersonHeader.setText(getString(R.string.contact_person_mandatory_text));

                EnterpriseCustomer enterpriseCustomer = realm.where(EnterpriseCustomer.class)
                        .equalTo("isCustomerChecked", true).findFirst();

                if (enterpriseCustomer != null) {
                    formAadhaarEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

                    formAadhaarEditText.setText(enterpriseCustomer.getRegisterNo().equals("null") ? "" : enterpriseCustomer.getRegisterNo());
                    firstNameEditText.setText(enterpriseCustomer.getOrganizationName().equals("null") ? "" : enterpriseCustomer.getOrganizationName());
                    formContactPersonName.setText(enterpriseCustomer.getContactpersionName().equals("null") ? "" : enterpriseCustomer.getContactpersionName());
                    formEmailEditText.setText(enterpriseCustomer.getEmail().equals("null") ? "" : enterpriseCustomer.getEmail());
                    if (!enterpriseCustomer.getDateOfIncorporation().equals("null")) {
                        Date date = new Date(Long.parseLong(enterpriseCustomer.getDateOfIncorporation()));
                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        formCustomerDOB.setText(formatter.format(date));
                    }
                    billFrequencySpinner.setSelection(getIndex(billFrequencySpinner, enterpriseCustomer.getBillFrequency()));
                   /* formAadhaarEditText.setEnabled(false);
                    firstNameEditText.setEnabled(false);
                    formContactPersonName.setEnabled(false);
                    formCustomerDOB.setEnabled(false);
                    billFrequencySpinner.setEnabled(false);*/
                }
                enterpriseCustomerLayout.setVisibility(View.GONE);
                toggleViewsIfEnterpriseCAF();
                break;
        }
        CustomerInfoModel model = realm.where(CustomerInfoModel.class)
                .equalTo("formTime", Constants.formTime).findFirst();
        if (model != null) {
            customerTitleSpinner.setSelection(model.getCustomerTitle());
            formAadhaarEditText.setText(model.getCustomerAadhaarNumber());
            firstNameEditText.setText(model.getCustomerFirstName());
            middleNameEditText.setText(model.getCustomerMiddleName().equals("null") ? "" : model.getCustomerMiddleName());
            surNameEditText.setText(model.getCustomerLastName());
            formFatherEditText.setText(model.getCustomerFatherName());
            formCustomerDOB.setText(model.getCustomerDOB());
            switch (model.getCustomerGender()) {
                case 0:
                    formGenderRadioGroup.check(R.id.maleRadioButton);
                    break;

                case 1:
                    formGenderRadioGroup.check(R.id.femaleRadioButton);
                    break;
                default:
                    break;
            }
            formEmailEditText.setText(model.getCustomerEmail());
            formContactPersonName.setText(model.getContactPersonName());
            billFrequencySpinner.setSelection(model.getBillFrequencyPosition());
            billCycleSpinner.setSelection(model.getBillCyclePosition());
            segmentSpinner.setSelection(model.getSegmentPosition());
            channelSpinner.setSelection(model.getChannelPosition());
            formPANEditText.setText(model.getCustomerPAN());
            formTANEditText.setText(model.getCustomerTAN());
            cafStatus = model.getCafStatus();
            if (model.isDataFromAadhar()) {
                firstNameEditText.setEnabled(false);
                middleNameEditText.setEnabled(false);
                surNameEditText.setEnabled(false);
                formCustomerDOB.setClickable(false);
                femaleRadioButton.setEnabled(false);
                maleRadioButton.setEnabled(false);
            }
            if (model.getStatus().equals("noedit")) {
                firstNameEditText.setEnabled(false);
                middleNameEditText.setEnabled(false);
                surNameEditText.setEnabled(false);
                formCustomerDOB.setClickable(false);
                femaleRadioButton.setEnabled(false);
                maleRadioButton.setEnabled(false);
                formEmailEditText.setEnabled(false);
                customerTitleSpinner.setEnabled(false);
                formAadhaarEditText.setEnabled(false);
                formFatherEditText.setEnabled(false);
                billFrequencySpinner.setEnabled(false);
                retrieveAadhaarButton.setEnabled(false);
            }
            //Todo
            /*//execute if caf edit is for SI LMO
            if (Constants.isCAFInEditSILMO) {
                String selectedPackages = model.getAllPackagesSILMO();
                Log.d(TAG, "selectedPackages  " + selectedPackages);
                try{

                String[] packagesCodes;

                    packagesCodes = selectedPackages.split(",");
                    for (String eachPackage : packagesCodes) {

                        ProductModel productModel = realm.where(ProductModel.class).equalTo("productCode", eachPackage).findFirst();

                        if (productModel != null) {
                            Log.d(TAG, "productModel after null");
                            realm.beginTransaction();
                            productModel.setProductChecked(true);
                            Log.d(TAG, "productModel " + eachPackage + productModel.toString());
                            realm.copyToRealmOrUpdate(productModel);
                            realm.commitTransaction();


                        }
                    }


                }catch (Exception ex){
                    Log.d(TAG, "productModel exception ");
                    realm.cancelTransaction();
                    realm.close();
                    ex.printStackTrace();
                }

                long value = realm.where(ProductModel.class)
                        .equalTo("isProductChecked", true).count();

                Log.d(TAG, "total products isProductChecked customerinfo " + value);
            }*/
        }

        if (Constants.cafType == 2) {
            formAadhaarEditText.setEnabled(false);
            firstNameEditText.setEnabled(false);
            formContactPersonName.setEnabled(false);
            formCustomerDOB.setEnabled(false);
            billFrequencySpinner.setEnabled(false);
            formEmailEditText.setEnabled(false);
        }
    }

    private void toggleViewsIfEnterpriseCAF() {
        retrieveAadhaarButton.setVisibility(View.GONE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,
                1f);
        layoutParams.setMargins(5, 0, 5, 0);
        formAadhaarEditText.setLayoutParams(layoutParams);
        middleNameHeader.setVisibility(View.GONE);
        surNameHeader.setVisibility(View.GONE);
        fatherNameHeader.setVisibility(View.GONE);
        middleNameEditText.setVisibility(View.GONE);
        surNameEditText.setVisibility(View.GONE);
        formFatherEditText.setVisibility(View.GONE);
        formGenderLayout.setVisibility(View.GONE);
        formContactPersonName.setImeOptions(EditorInfo.IME_ACTION_NEXT);
    }

    private void getWalletBalance() {
        if (Utils.isNetworkAvailable(getActivity())) {
            requestHandler.getWalletBalance(getActivity(), this, Constants.GET_WALLET_BALANCE);
        } else {
            formLMOWallet.setText(String.format("%s", "NA"));
            formLMOCreditLimit.setText(String.format("%s", "NA"));
            formLMORemainingLimit.setText(String.format("%s", "NA"));
        }
    }

    private void setSpinnerData() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<FormSpinnerModel> results = realm.where(FormSpinnerModel.class).findAll();
        String[] titles;
        CustomSpinnerAdapter titleAdapter;
        titles = results.get(0).getCustomerTitles().split(",");
        titleAdapter = new CustomSpinnerAdapter(getActivity(), titles);
        customerTitleSpinner.setAdapter(titleAdapter);
        if (Constants.cafType == 2) {
            customerTitleSpinner.setSelection(getIndex(customerTitleSpinner, "Ms."));
            customerTitleSpinner.setEnabled(false);
        }
        String[] billCycleItems = getResources().getStringArray(R.array.bill_cycle_spinner_items);
        CustomSpinnerAdapter billCycleAdapter = new CustomSpinnerAdapter(getActivity(), billCycleItems);
        billCycleSpinner.setAdapter(billCycleAdapter);

        RealmResults<FormSpinnerModel> spinnerResults = realm.where(FormSpinnerModel.class).findAll();

        String[] segments = spinnerResults.get(0).getCustomerSegments().split(",");
        CustomSpinnerAdapter segmentAdapter = new CustomSpinnerAdapter(getActivity(), segments);
        segmentSpinner.setAdapter(segmentAdapter);

        String[] channels = spinnerResults.get(0).getCustomerChannels().split(",");
        CustomSpinnerAdapter channelAdapter = new CustomSpinnerAdapter(getActivity(), channels);
        channelSpinner.setAdapter(channelAdapter);

        String[] billFrequencies = spinnerResults.get(0).getBillFrequencies().split(",");
        CustomSpinnerAdapter billFrequencyAdapter = new CustomSpinnerAdapter(getActivity(), billFrequencies);
        billFrequencySpinner.setAdapter(billFrequencyAdapter);
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                dateSetListener,
                calendarInstance.get(Calendar.YEAR),
                calendarInstance.get(Calendar.MONTH),
                calendarInstance.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        datePickerDialog.show();
    }

    private void updateCustomerDOB() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        Log.d(TAG, "dob " + format.format(calendarInstance.getTime()));
        formCustomerDOB.setText(format.format(calendarInstance.getTime()));
    }

    private boolean validateFormFields() {
        boolean isValid = false;
        FormValidations.FORM_FIELDS field =
                Constants.cafType == 1 ? FormValidations.FORM_FIELDS.AADHAAR_NUMBER_INDIVIDUAL :
                        FormValidations.FORM_FIELDS.AADHAAR_NUMBER_ENTERPRISE;
        if (Constants.cafType == 2 || FormValidations.isFormEditTextValid(formAadhaarEditText, field))
            // if (FormValidations.isFormSpinnerItemSelected(customerTitleSpinner, FormValidations.SPINNER.CUSTOMER_TITLE))
            if (FormValidations.isFormEditTextValid(firstNameEditText, FormValidations.FORM_FIELDS.FIRST_NAME))
                if (Constants.cafType == 2 || FormValidations.isFormEditTextValid(surNameEditText, FormValidations.FORM_FIELDS.SURNAME))
                    if (Constants.cafType == 1 || FormValidations.isFormEditTextValid(formContactPersonName, FormValidations.FORM_FIELDS.CONTACT_PERSON_NAME))
                        if (Constants.cafType == 2 || !formCustomerDOB.getText().toString().equals(getString(R.string.dob_text_hint))) {
                            if (FormValidations.isFormSpinnerItemSelected(billFrequencySpinner, FormValidations.SPINNER.BILL_FREQUENCY))
                                if (!formEmailEditText.getText().toString().equals("")) {
                                    if (FormValidations.isFormEditTextValid(formEmailEditText, FormValidations.FORM_FIELDS.EMAIL_ID))
                                        if (enterpriseCustomerLayout.getVisibility() == View.VISIBLE) {
                                            if (formPANEditText.getText().toString().equals("") || FormValidations.isFormEditTextValid(formPANEditText, FormValidations.FORM_FIELDS.PAN_NUMBER))
                                                if (formTANEditText.getText().toString().equals("") || FormValidations.isFormEditTextValid(formTANEditText, FormValidations.FORM_FIELDS.TAN_NUMBER))
                                                    isValid = true;
                                        } else {
                                            isValid = true;
                                        }
                                } else {
                                    if (enterpriseCustomerLayout.getVisibility() == View.VISIBLE) {
                                        if (formPANEditText.getText().toString().equals("") || FormValidations.isFormEditTextValid(formPANEditText, FormValidations.FORM_FIELDS.PAN_NUMBER))
                                            if (formTANEditText.getText().toString().equals("") || FormValidations.isFormEditTextValid(formTANEditText, FormValidations.FORM_FIELDS.TAN_NUMBER))
                                                isValid = true;
                                    } else {
                                        isValid = true;
                                    }
                                }
                        } else {
                            Utils.showDialog(getActivity(),
                                    getString(R.string.invalid_dob_title),
                                    getString(R.string.invalid_dob_message), null);
                        }
        return isValid;
    }

    private void saveFormData() {
        Realm realm = Realm.getDefaultInstance();
        try {
            // try {
            realm.beginTransaction();
           /* } catch (Exception ex) {
                Log.d("Exception in -> ", "Realm begain transaction");
                ex.printStackTrace();
            }*/
            CustomerInfoModel model = realm.where(CustomerInfoModel.class)
                    .equalTo("formTime", Constants.formTime)
                    .findFirst();
            if (model == null) {
                model = new CustomerInfoModel();
                model.setFormTime(Constants.formTime);
                model.setDataFromAadhar(isdataFromAadhar);
                model.setStatus("");
            }
            model.setCustomerAadhaarNumber(formAadhaarEditText.getText().toString());
            model.setCustomerTitle(customerTitleSpinner.getSelectedItemPosition());
            model.setCustomerFirstName(firstNameEditText.getText().toString());
            model.setCustomerMiddleName(middleNameEditText.getText().toString());
            model.setCustomerLastName(surNameEditText.getText().toString());
            model.setCustomerFatherName(formFatherEditText.getText().toString());
            model.setCustomerDOB(formCustomerDOB.getText().toString());
            model.setCustomerGender(maleRadioButton.isChecked() ? 0 : 1);
            model.setCustomerEmail(formEmailEditText.getText().toString());
            model.setContactPersonName(formContactPersonName.getText().toString());
            model.setBillFrequencyPosition(billFrequencySpinner.getSelectedItemPosition());
            model.setBillCyclePosition(billCycleSpinner.getSelectedItemPosition());
            model.setSegmentPosition(segmentSpinner.getSelectedItemPosition());
            model.setChannelPosition(channelSpinner.getSelectedItemPosition());
            model.setCustomerTAN(formTANEditText.getText().toString());
            model.setCustomerPAN(formPANEditText.getText().toString());

            realm.copyToRealmOrUpdate(model);

            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            if (offlineFormModel == null) {
                offlineFormModel = new OfflineFormModel();
                offlineFormModel.setFormTime(Constants.formTime);
                //Constants.cafType == 1 ? "INDIVIDUAL" : "ENTERPRISE"
                offlineFormModel.setCafType(Constants.cafType);
                offlineFormModel.setFormCAFData(getFormDataAsJSON(null).toString());
                offlineFormModel.setEnterpriseCustomerCode(enterpriseCustomerCode);
                offlineFormModel.setFormPaymentData("");
                offlineFormModel.setFormUploaded(false);
                offlineFormModel.setIsPaymentDataAvailable(false);
                offlineFormModel.setCpeSerialNoUsed(false);
                offlineFormModel.setCafStatus(cafStatus);
            } else {
                //Todo
                //for status
                offlineFormModel.setFormCAFData(getFormDataAsJSON(offlineFormModel.getFormCAFData()).toString());

                //offlineFormModel.setCafStatus(cafStatus);
            }
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
        } catch (Exception ex) {
            realm.cancelTransaction();
            realm.close();
            Log.d("Exception in -> ", "saveFormData");
            ex.printStackTrace();
        }
    }

    private JSONObject getFormDataAsJSON(String formData) {
        JSONObject formJSON = null;
        try {
            if (formData == null) {
                formJSON = new JSONObject();
            } else {
                formJSON = new JSONObject(formData);
            }
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            formJSON.put("loginId", sharedPreferences.getString(Constants.USER_NAME, ""));
            formJSON.put("lmoCode", sharedPreferences.getString(Constants.LMO_CODE, ""));
            formJSON.put("lmoName", sharedPreferences.getString(Constants.LMO_NAME, ""));
            formJSON.put("ipAddress", Utils.getIPAddress(getActivity()));
            formJSON.put("cafNo", Constants.cafNumber.equals("") ? "" : Long.parseLong(Constants.cafNumber));
            String custType = Constants.cafType == 1 ? "INDIVIDUAL" : "ENTERPRISE";
           /* if (Constants.cafType == 2) {
                Realm realm = Realm.getDefaultInstance();
                EnterpriseCustomer enterpriseCustomer = realm.where(EnterpriseCustomer.class).equalTo("isCustomerChecked", true).findFirst();
                if (enterpriseCustomer != null) {
                    enterpriseCustomerCode = enterpriseCustomer.getCustomerID();
                } else {
                    enterpriseCustomerCode = "";
                }

                Log.d("Enterprise Code", enterpriseCustomerCode);
                formJSON.put("custCode", enterpriseCustomerCode);
            }*/
            formJSON.put("custType", custType);
            formJSON.put("aadharNumber", formAadhaarEditText.getText().toString());
            formJSON.put("panNo", formPANEditText.getText().toString());
            formJSON.put("tanNo", formTANEditText.getText().toString());
            formJSON.put("titleLovName", customerTitleSpinner.getSelectedItem().toString());
            formJSON.put("firstName", firstNameEditText.getText().toString());
            formJSON.put("lastName", surNameEditText.getText().toString());
            formJSON.put("fatherName", formFatherEditText.getText().toString());
            formJSON.put("dob", formCustomerDOB.getText().toString());
            formJSON.put("pocName", formContactPersonName.getText().toString());
            formJSON.put("gender", maleRadioButton.isChecked() ? "M" : "F");
            formJSON.put("emailId", formEmailEditText.getText().toString());
            formJSON.put("billCycle", billFrequencySpinner.getSelectedItem().toString());
            formJSON.put("segment", JSONObject.NULL);
            formJSON.put("channel", JSONObject.NULL);
            //formJSON.put("cafStatus",cafStatus);
        } catch (Exception e) {
            Log.d("Exception in -> ", "getFormDataAsJSON");
            e.printStackTrace();
        }
        return formJSON;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.retrieveAadhaarButton:
                if (Utils.isNetworkAvailable(getActivity())) {
                    if (FormValidations.isFormEditTextValid(formAadhaarEditText, FormValidations.FORM_FIELDS.AADHAAR_NUMBER_INDIVIDUAL)) {
                        Utils.hideKeyboard(v);
                        Utils.showProgress(getActivity(), getString(R.string.getting_details_aadhaar));
                        requestHandler.getDetailsFromAadhaar(getActivity(), this,
                                formAadhaarEditText.getText().toString(), Constants.GET_DETAILS_AADHAAR);
                    }
                } else {
                    Utils.showDialog(getActivity(), getString(R.string.no_internet_title)
                            , getString(R.string.no_internet_message), null);
                }
                break;

            case R.id.formCustomerDOB:
                showDatePickerDialog();
                break;

            case R.id.nextLayout:
                if (validateFormFields()) {


                    saveFormData();

                    CustomerInfoFragment args = new CustomerInfoFragment();
                    Bundle values = new Bundle();

                    //sample = "null";
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, new CustomerAddressFragment())
                            .addToBackStack(CustomerAddressFragment.class.getSimpleName())
                            .commit();

                       /* if(TextUtils.isEmpty(firstNameEditText.getText().toString())||TextUtils.isEmpty(surNameEditText.getText().toString())) {
                            if(TextUtils.isEmpty(firstNameEditText.getText().toString())){
                                firstNameEditText.setError("firstname should be minimum 3characters");

                            }
                            else if(TextUtils.isEmpty(surNameEditText.getText().toString())) {
                                surNameEditText.setError("firstname should be minimum 3characters");

                            }

                        }
                        else{
                            saveFormData();

                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragmentContainer, new CustomerAddressFragment())
                                    .addToBackStack(CustomerAddressFragment.class.getSimpleName())
                                    .commit();
                        }*/
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (Constants.isCAFInEditMode) {
            saveFormData();
            //int editCafType=Constants.cafType;
            Utils.resetStaticVariables();
            //Constants.cafType=editCafType;
            getActivity().finish();
        } else {
            Utils.showUserConfirmationDialog(getActivity(), this,
                    getString(R.string.discard_form_message), Constants.DISCARD_FORM);
        }
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.DISCARD_FORM:
                Log.d(TAG, "DISCARD FORM");
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.where(CustomerInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(CPEInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(IptvDataModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(CustomerAddressModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(OfflineFormModel.class)
                        .equalTo("formTime", Constants.formTime)
                        .findAll().deleteAllFromRealm();
                realm.commitTransaction();
                realm.close();
                Utils.resetStaticVariables();
                startActivity(new Intent(getActivity(), MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {

            case Constants.GET_WALLET_BALANCE:
                if (response != null) {
                    try {
                        JSONObject responseData = (JSONObject) response;
                        String walletBalance = responseData.getString("walletAmount");
                        String creditAmount = responseData.getString("creditAmount");
                        String actualUserAmount = responseData.getString("actualUserAmount");
                        formLMOWallet.setText(String.format("%s", walletBalance));
                        formLMOCreditLimit.setText(String.format("%s", creditAmount));
                        formLMORemainingLimit.setText(String.format("%s", actualUserAmount));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                break;

            case Constants.GET_DETAILS_AADHAAR:
                Utils.cancelProgress();
                if (response != null) {
                    try {
                        firstNameEditText.setText("");
                        middleNameEditText.setText("");
                        surNameEditText.setText("");
                        JSONObject data = (JSONObject) response;
                        Constants.aadhaarData = data;
                        String name = data.getString("name").trim();
                        if (name.contains(" ")) {
                            String[] names = name.split(" ");
                            for (int i = 0; i < names.length; i++) {
                                switch (i) {
                                    case 0:
                                        surNameEditText.setText(names[0]);

                                        if (names[0].length() < 1) {
                                            surNameEditText.setEnabled(true);

                                        } else {
                                            surNameEditText.setEnabled(false);
                                        }
                                        break;

                                    default:
                                        firstNameEditText.append(names[i] + " ");
                                        break;
                                }
                            }
                        } else {
                            firstNameEditText.setText(name);

                        }
                        formFatherEditText.setText(data.getString("careof").trim());
                        String dob = data.getString("dob");
                        formCustomerDOB.setText(dob);

                        if (dob.contains("/")) {
                            int day = Integer.parseInt(dob.split("/")[0]);
                            int month = Integer.parseInt(dob.split("/")[1]);
                            int year = Integer.parseInt(dob.split("/")[2]);
                            calendarInstance.clear();
                            calendarInstance.set(Calendar.YEAR, year);
                            calendarInstance.set(Calendar.MONTH, month);
                            calendarInstance.set(Calendar.DAY_OF_MONTH, day);
                        }
                        String gender_Str = data.getString("gender").toString();
                        if (data.getString("gender").equalsIgnoreCase("M")) {
                            maleRadioButton.setChecked(true);
                        } else {
                            femaleRadioButton.setChecked(true);
                        }


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    /*Realm realm = Realm.getDefaultInstance();
                    CustomerInfoModel model = realm.where(CustomerInfoModel.class)
                            .equalTo("formTime", Constants.formTime).findFirst();
                    if (model == null && Constants.aadhaarData != null) {*/
                    isdataFromAadhar = true;
                    //}

                    firstNameEditText.setEnabled(false);
                    middleNameEditText.setEnabled(false);
                    formCustomerDOB.setClickable(false);
                    maleRadioButton.setEnabled(false);
                    femaleRadioButton.setEnabled(false);

                } else {
                    Utils.showDialog(getActivity(), getString(R.string.no_results_aadhaar_title),
                            getString(R.string.no_results_aadhaar_message), null);
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.billFrequencySpinner:
                switch (position) {
                    case 1:
                        Constants.billFrequencyValue = 1;
                        Constants.billCycle = "MONTHLY";
                        break;

                    case 2:
                        Constants.billFrequencyValue = 3;
                        Constants.billCycle = "QUARTERLY";
                        break;

                    case 3:
                        Constants.billFrequencyValue = 6;
                        Constants.billCycle = "HALFYEARLY";
                        break;

                    case 4:
                        Constants.billFrequencyValue = 12;
                        Constants.billCycle = "YEARLY";
                        break;
                }
                break;
        }
        Log.d("Bill Frequency : ->", "" + Constants.billFrequencyValue);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private int getIndex(Spinner spinner, String myString) {
        int position = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                position = i;
            }
        }
        // Check for this when you set the position.
        //return -1;
        return position;

    }

    private String isDeviceConnected() {
        UsbManager usbmanager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);

        Iterator<UsbDevice> devicelistiterator = usbmanager.getDeviceList()
                .values().iterator();
        long vendorID;
        long productID;

        if (usbmanager.getDeviceList().size() == 0) {
            return null;
        }

        while (devicelistiterator.hasNext()) {
            UsbDevice usbdevice = (UsbDevice) devicelistiterator.next();
            vendorID = usbdevice.getVendorId();
            productID = usbdevice.getProductId();
            if (vendorID == PB510_2000_VendorID && productID == PB510_2000_ProductID) {
                return PB510_SCANNER;
            } else if (vendorID == PB510_2010_VendorID && productID == PB510_2010_ProductID) {
                return PB510_SCANNER;
            } else if (vendorID == PB400_VendorID && productID == PB400_ProductID) {
                return PBABAS_SCANNER;
            }
        }
        return null;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        FormXML formXML = null;
        RDServiceInfo rdServiceInfo = null;
        String dnc = "";
        String dnr = "";
        String strDeviceInfo = "";
        String strRDServiceInfo = "";
        try {


            if (requestCode == 0) {
                dnc = data.getStringExtra("DNC");
                dnr = data.getStringExtra("DNR");
                strDeviceInfo = data.getStringExtra(DeviceINFO_KEY);
                strRDServiceInfo = data.getStringExtra(RD_SERVICE_INFO);
                if (dnc != null) {
                    // middleNameHeader.setText("Device not connected,Please connect the device properly");
                    Toast.makeText(getActivity(), "Device not connected,Please connect the device properly", Toast.LENGTH_SHORT).show();

                } else if (dnr != null) {
                    // middleNameHeader.setText("Device not registered,Please register the device");
                    Toast.makeText(getActivity(), "Device not registered,Please register the device", Toast.LENGTH_SHORT).show();

                } else if (strRDServiceInfo != null && !strRDServiceInfo.isEmpty()) {
                    //Toast.makeText(getActivity(), "RDServiceInfo:" + strRDServiceInfo, Toast.LENGTH_SHORT).show();

                    rdServiceInfo = new SplitXML().SplitRDServiceInfo(strRDServiceInfo);

                    if (rdServiceInfo != null) {
                        if (rdServiceInfo.status.equalsIgnoreCase("Ready")) {
                            // middleNameHeader.setText(strRDServiceInfo);
                            //Toast.makeText(getActivity(), strRDServiceInfo, Toast.LENGTH_SHORT).show();


                            formXML = new FormXML();
                            FormXML.fCount = fCount;
                            FormXML.fType = fType;
                            FormXML.format = format;
                            FormXML.posh = fingerpos;
                            FormXML.timeout = timeout;
                            captureRequestXML = formXML.formCaptureRequestXML();

                            if (captureRequestXML != null && !captureRequestXML.isEmpty()) {
                                /*Intent sendIntent = new Intent();
                                sendIntent.setAction("in.gov.uidai.rdservice.fp.CAPTURE");
                                sendIntent.putExtra(PID_OPTIONS, captureRequestXML);
                                startActivityForResult(sendIntent, CAPTURE_REQUEST);*/

                                String connectedDevice = isDeviceConnected();
                                if (connectedDevice != null && !connectedDevice.isEmpty()) {
                                    if (connectedDevice.equals(PB510_SCANNER)) {
                                        Intent sendIntent = new Intent("in.gov.uidai.rdservice.fp.CAPTURE");
                                        sendIntent.setPackage("com.precision.pb510.rdservice");
                                        sendIntent.putExtra(PID_OPTIONS, captureRequestXML);
                                        startActivityForResult(sendIntent, CAPTURE_REQUEST);

                                    } else if (connectedDevice.equals(PBABAS_SCANNER)) {
                                        Intent sendIntent = new Intent("in.gov.uidai.rdservice.fp.CAPTURE");
                                        sendIntent.setPackage("com.precision.tcs1s.rdservice");
                                        sendIntent.putExtra(PID_OPTIONS, captureRequestXML);
                                        startActivityForResult(sendIntent, CAPTURE_REQUEST);

                                    } else {
                                        Toast.makeText(getActivity(), "Scanner not connected", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                } else {
                                    Toast.makeText(getActivity(), "Scanner not connected", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        } else
                            // middleNameHeader.setText("Device not Ready");
                            Toast.makeText(getActivity(), "Device not Ready", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //middleNameHeader.setText("RD Service information empty");
                    Toast.makeText(getActivity(), "RD Service information empty", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == 1) {
                CapturedFingerprintXML = data.getStringExtra(PID_DATA);
                System.out.println(CapturedFingerprintXML);
                String errInfo = getXmlerrorInfo(CapturedFingerprintXML);
                sendxml = CapturedFingerprintXML;
                sendMail(CapturedFingerprintXML);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                System.out.println("alert" + CapturedFingerprintXML);

                //if (errInfo.equalsIgnoreCase("700")) {
                if (!errInfo.equalsIgnoreCase("Image Capture Success")) {
                    Log.d("TAG", "onActivityResult: error occured");
                    alertDialog.setTitle("AADHAR");
                    alertDialog.setMessage("Finger Print Captured Failed \n Try again");
                    alertDialog.setPositiveButton("RETRY",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    caaptureFingerPrintData();
                                }
                            });

                    alertDialog.setNegativeButton("CANCEL",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                    alertDialog.show();

                } else if (errInfo.equalsIgnoreCase("Image Capture Success")) {
                    Log.d("TAG", "onActivityResult: continue further");
                    View dialogView = Maininflater.inflate(R.layout.custom_aadhar_number, null);

                    final EditText editText = (EditText) dialogView.findViewById(R.id.aadhar_num_dialog);
                    alertDialog.setView(dialogView);
                    //alertDialog.setTitle("AADHAR");
                    //alertDialog.setMessage("Enter Aadhar number");
                   /* String newXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<PidData xmlns=\"http://www.example.org/ekyc\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/ekyc ekyc.xsd \">";
                    if (captureRequestXML.contains("<PidData>")) {
                        //System.out.println("exists");
                        finalXml= captureRequestXML.replace("<PidData>",newXmlString);
                        System.out.println(finalXml);
                    }*/

                    final EditText input = new EditText(getActivity());
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT);
                    input.setLayoutParams(lp);
                    //alertDialog.setView(input);
                    //Toast.makeText(getActivity(), "data" + errInfo, Toast.LENGTH_SHORT).show();
                    // alertDialog.setIcon(R.drawable.aadhar_info);

                    alertDialog.setPositiveButton("YES",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    progressDialog.show();
                                    System.out.println("sample" + CapturedFingerprintXML);
                                    String data = sendxml;
                                    System.out.println("sa" + sendxml);
                                    //String aadhar_num = input.getText().toString();
                                    String aadhar_num = editText.getText().toString();
                                    String newXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                            "<PidData xmlns=\"http://www.example.org/ekyc\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/ekyc ekyc.xsd \">";
                                    if (sendxml.contains("<PidData>")) {
                                        //System.out.println("exists");
                                        finalXml = sendxml.replace("<PidData>", newXmlString);
                                        System.out.println(finalXml);
                                    }
                                    //Toast.makeText(getContext(), "Aadhar:" + aadhar_num, Toast.LENGTH_SHORT).show();
                                    final RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml"), finalXml);
                                    apiService.getEkycInfo(getAuthToken(), requestBody, aadhar_num).enqueue(new Callback<EkycDetails>() {
                                        @Override
                                        public void onResponse(Call<EkycDetails> call, Response<EkycDetails> response) {
                                            if (response.isSuccessful() && !response.equals(" ")) {
                                                progressDialog.dismiss();
                                                Log.d(TAG, "onResponse: " + response.body().getUid());
                                                //Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                                                if (response != null) {
                                                    Dupresponse = response;
                                                    //addressSample = response.body().getHouse() + " " + response.body().getStreet() + " " + response.body().getLc() + " " + response.body().getPincode() + " " + response.body().getPhoneNumber();
                                                    try {
                                                        firstNameEditText.setText("");
                                                        middleNameEditText.setText("");
                                                        surNameEditText.setText("");
                                                        formAadhaarEditText.setText("");
                                                        String name = response.body().getName();
                                                        if (name != null && !name.equalsIgnoreCase("101")) {
                                                            if (name.contains(" ")) {
                                                                String[] names = name.split(" ");
                                                                for (int i = 0; i < names.length; i++) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            surNameEditText.setText(names[0]);
                                                                            formAadhaarEditText.setText(response.body().getUid());
                                                                            addressSample = response.body().getHouse() + " , " + response.body().getStreet() + " , " + response.body().getLc() + " , " + response.body().getPincode() + " , " + response.body().getPhoneNumber();

                                                                            if (names[0].length() < 1) {
                                                                                surNameEditText.setEnabled(true);

                                                                            } else {
                                                                                surNameEditText.setEnabled(false);
                                                                            }
                                                                            break;

                                                                        default:
                                                                            if (names[i].isEmpty()) {
                                                                                firstNameEditText.setText("null");
                                                                            } else {
                                                                                firstNameEditText.append(names[i] + " ");
                                                                            }
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                firstNameEditText.setText(name);
                                                                surNameEditText.setText("null");
                                                                //Toast.makeText(getContext(), "Not a valid Aadhar", Toast.LENGTH_SHORT).show();
                                                                addressSample = " ";
                                                            }
                                                        } else {
                                                            invalidAadhar();
                                                        }
                                                        //formFatherEditText.setText(data.getString("careof").trim());
                                                        if (response.body().getCo().equalsIgnoreCase("101")) {
                                                            formFatherEditText.setText("null");
                                                        } else {
                                                            formFatherEditText.setText(response.body().getCo());
                                                        }
                                                        String dob = response.body().getDob();
                                                        if (dob.equalsIgnoreCase("101")) {
                                                            formCustomerDOB.setText("null");
                                                        } else {
                                                            formCustomerDOB.setText(dob);
                                                            Log.d(TAG, "onResponse: " + dob);
                                                        }

                                                        if (dob.contains("/")) {
                                                            int day = Integer.parseInt(dob.split("/")[0]);
                                                            int month = Integer.parseInt(dob.split("/")[1]);
                                                            int year = Integer.parseInt(dob.split("/")[2]);
                                                            calendarInstance.clear();
                                                            calendarInstance.set(Calendar.YEAR, year);
                                                            calendarInstance.set(Calendar.MONTH, month);
                                                            calendarInstance.set(Calendar.DAY_OF_MONTH, day);
                                                        }
                                                        //String gender_Str = data.getString("gender").toString();
                                                        String gender_Str = response.body().getGender();
                                                        //if (data.getString("gender").equalsIgnoreCase("M")) {
                                                        if (response.body().getGender().equalsIgnoreCase("M")) {
                                                            maleRadioButton.setChecked(true);
                                                        } else {
                                                            femaleRadioButton.setChecked(true);
                                                        }
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    isdataFromAadhar = true;

                                                    firstNameEditText.setEnabled(false);
                                                    middleNameEditText.setEnabled(false);
                                                    formCustomerDOB.setClickable(false);
                                                    maleRadioButton.setEnabled(false);
                                                    femaleRadioButton.setEnabled(false);

                                                } else {
                                                    //progressDialog.dismiss();
                                                    /*Utils.showDialog(getActivity(), getString(R.string.no_results_aadhaar_title),
                                                            getString(R.string.no_results_aadhaar_message), null);*/
                                                    invalidAadhar();
                                                }
                                            } else {
                                                progressDialog.dismiss();
                                                APIError error = ErrorUtils.parseError(response);
                                                Log.d("error message", error.message());
                                                /*Utils.showDialog(getActivity(), getString(R.string.no_results_aadhaar_title),
                                                        getString(R.string.no_results_aadhaar_message), null);*/
                                                invalidAadhar();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<EkycDetails> call, Throwable t) {
                                            progressDialog.dismiss();
                                            Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });

                    alertDialog.setNegativeButton("NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                    alertDialog.show();
                }
            }
        } catch (Exception e) {

        } finally {
            formXML = null;
            rdServiceInfo = null;
            captureRequestXML = null;
            rdServiceInfo = null;
            dnc = null;
            dnr = null;
            strDeviceInfo = null;
            strRDServiceInfo = null;
            captureRequestXML = null;
            CapturedFingerprintXML = null;
        }
    }

    private void invalidAadhar() {
        Utils.showDialog(getActivity(), getString(R.string.no_results_aadhaar_title),
                getString(R.string.no_results_aadhaar_message), null);
    }


    public void sendMail(String capturedFingerprintXML1) {

        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"ravikumar.badavath@gmail.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "FingerPrint Data");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, capturedFingerprintXML1);


        emailIntent.setType("message/rfc822");

        try {
            startActivity(Intent.createChooser(emailIntent,
                    "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(),
                    "No email clients installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private static String getXmlerrorInfo(String capturedFingerprintXML) {
        Document xml = convertStringToDocument(capturedFingerprintXML);
        Node user = xml.getFirstChild();
        String errorInfoKey, errorInfoVal = null;
        NodeList childs = user.getChildNodes();
        Node child;
        for (int i = 0; i < childs.getLength(); i++) {
            child = childs.item(i);
            String key = child.getAttributes().getNamedItem("errInfo").getNodeValue();
            //System.out.println(child.getNodeName());
            //System.out.println(child.getTextContent());
            //errorInfoKey = child.getNodeName();
            if (key.equalsIgnoreCase("Image Capture Success")) {
                errorInfoVal = key;
                break;
                //Log.d("TAG", "getXmlerrorInfo: "+key);
            } else {
                errorInfoVal = key;
                break;
            }
        }
        return errorInfoVal;
    }

    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(
                    xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAuthToken() {
        byte[] data = new byte[0];
        try {
            data = (com.app.apsfl.Ekyc.Constants.DefaultCredentialValues.USER_NAME_VAL + ":" + com.app.apsfl.Ekyc.Constants.DefaultCredentialValues.PASSWORD_VAL).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
