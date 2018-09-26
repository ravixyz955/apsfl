package com.app.apsfl.activities;

import android.app.Activity;
import android.os.Bundle;

import com.app.apsfl.Ekyc.FormXML;
import com.app.apsfl.Ekyc.RDServiceInfo;
import com.app.apsfl.Ekyc.SplitXML;
import com.app.apsfl.R;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;

public class EkycActivity extends Activity {
    EditText edtFCount = null;
    EditText edtTimeout = null;
    TextView txtResult = null;
    EditText edtLockKey = null;
    Spinner Ftype = null;
    Spinner FingerPos = null;
    Spinner Format = null;
    CheckBox checkBox = null;

    String fCount = "";
    String fType = "";
    String format = "";
    String fingerpos = "";
    String timeout = "";
    String key = "";

    String vendorID = "";
    String productID = "";


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
    String captureRequestXML = null;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pb510);
        edtFCount = (EditText) findViewById(R.id.edtFCount);
        txtResult = (TextView) findViewById(R.id.txtResult);
        Ftype = (Spinner) findViewById(R.id.Ftype);
        FingerPos = (Spinner) findViewById(R.id.FingerPos);
        Format = (Spinner) findViewById(R.id.Format);
        edtTimeout = (EditText) findViewById(R.id.edtTimeout);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        edtLockKey = (EditText) findViewById(R.id.edtLockKey);

        String[] formatarray = getApplicationContext().getResources().getStringArray(R.array.Format);


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, formatarray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Format.setAdapter(spinnerArrayAdapter);

        String[] ftypeArray = getApplicationContext().getResources().getStringArray(R.array.Ftype);
        ArrayAdapter<String> arrayAdapterFtype = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ftypeArray); //selected item will look like a spinner set from XML
        arrayAdapterFtype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Ftype.setAdapter(arrayAdapterFtype);

        String[] fPos = getApplicationContext().getResources().getStringArray(R.array.FPosition);
        ArrayAdapter<String> arrayAdapterFpos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fPos); //selected item will look like a spinner set from XML
        arrayAdapterFpos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FingerPos.setAdapter(arrayAdapterFpos);
    }

    public void CaptureFinger(View view) {
        //overridePendingTransition(0,0);
        txtResult.setText("");
        fCount = "1";//edtFCount.getText().toString();
        if (fCount == null || fCount.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter finger Count", Toast.LENGTH_SHORT).show();
            return;
        }

        int fingerCount = Integer.parseInt(fCount);
        if (fingerCount < 0 || fingerCount > 10) {
            Toast.makeText(getApplicationContext(), "Invalid Fingerprint Count, Please enter valid finger count", Toast.LENGTH_SHORT).show();
            return;
        }
        fType = "FMR";//Ftype.getSelectedItem().toString();
        if (fType.equals("FType")) {
            Toast.makeText(getApplicationContext(), "Please select fingerprint type", Toast.LENGTH_SHORT).show();
            return;
        }
        if (fType.equalsIgnoreCase("FMR")) {
            fType = "0";
        } else if (fType.equalsIgnoreCase("FIR")) {
            fType = "1";
        }
        format = "XML";//Format.getSelectedItem().toString();
        if (format.equals("Format")) {
            Toast.makeText(getApplicationContext(), "Please select format", Toast.LENGTH_SHORT).show();
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

            Toast.makeText(getApplicationContext(), "Please select capture timeout", Toast.LENGTH_SHORT).show();
            return;
        }

        if (checkBox.isChecked())
            FormXML.isUIRequired = false;
        else
            FormXML.isUIRequired = true;

        FormXML.isUIRequired = false;
      /*  key =  edtLockKey.getText().toString();
        if(key != null && !key.isEmpty()){
            FormXML.key = key;
        }*/

       /* Intent sendIntent = new Intent();
        sendIntent.setAction("in.gov.uidai.rdservice.fp.INFO");
        startActivityForResult(sendIntent, INFO_REQUEST);*/
        String connectedDevice = isDeviceConnected();
        if (connectedDevice != null && !connectedDevice.isEmpty()) {
            if (connectedDevice.equals(PB510_SCANNER)) {
                Toast.makeText(getApplicationContext(), "FingerPrintScannerConected", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent("in.gov.uidai.rdservice.fp.INFO");
                sendIntent.setPackage("com.precision.pb510.rdservice");
                startActivityForResult(sendIntent, INFO_REQUEST);
            } else if (connectedDevice.equals(PBABAS_SCANNER)) {
                Toast.makeText(getApplicationContext(), "FingerPrintScannerConected", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent("in.gov.uidai.rdservice.fp.INFO");
                sendIntent.setPackage("com.precision.tcs1s.rdservice");
                startActivityForResult(sendIntent, INFO_REQUEST);
            } else {
                Toast.makeText(EkycActivity.this, "Scanner not connected", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(EkycActivity.this, "Scanner not connected", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String CapturedFingerprintXML = "";
        FormXML formXML = null;
        RDServiceInfo rdServiceInfo = null;
        String dnc = "";
        String dnr = "";
        String strDeviceInfo = "";
        String strRDServiceInfo = "";
        String captureRequestXML = "";
        try {
            if (requestCode == 0) {
                dnc = data.getStringExtra("DNC");
                dnr = data.getStringExtra("DNR");
                strDeviceInfo = data.getStringExtra(DeviceINFO_KEY);
                strRDServiceInfo = data.getStringExtra(RD_SERVICE_INFO);
                if (dnc != null) {
                    txtResult.setText("Device not connected,Please connect the device properly");
                } else if (dnr != null) {
                    txtResult.setText("Device not registered,Please register the device");
                } else if (strRDServiceInfo != null && !strRDServiceInfo.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "RDServiceInfo:" + strRDServiceInfo, Toast.LENGTH_SHORT).show();

                    rdServiceInfo = new SplitXML().SplitRDServiceInfo(strRDServiceInfo);

                    if (rdServiceInfo != null) {
                        if (rdServiceInfo.status.equalsIgnoreCase("Ready")) {
                            txtResult.setText(strRDServiceInfo);


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
                                        Toast.makeText(EkycActivity.this, "Scanner not connected", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                } else {
                                    Toast.makeText(EkycActivity.this, "Scanner not connected", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            }

                        } else
                            txtResult.setText("Device not Ready");
                    }
                } else {
                    txtResult.setText("RD Service information empty");
                }
            } else if (requestCode == 1) {
                CapturedFingerprintXML = data.getStringExtra(PID_DATA);

                txtResult.setText(CapturedFingerprintXML);

                //String no="8008026018";
                //sendSMS(captureRequestXML,no);
                //sendMail(CapturedFingerprintXML);
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


    public void sendMail(String capturedFingerprintXML1) {

        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"chaitanya.jerripothula@xyzinnotech.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "RameshDaata");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, capturedFingerprintXML1);


        emailIntent.setType("message/rfc822");

        try {
            startActivity(Intent.createChooser(emailIntent,
                    "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),
                    "No email clients installed.",
                    Toast.LENGTH_SHORT).show();
        }

    }


    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    private String isDeviceConnected() {
        UsbManager usbmanager = (UsbManager) getSystemService(Context.USB_SERVICE);

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
}

