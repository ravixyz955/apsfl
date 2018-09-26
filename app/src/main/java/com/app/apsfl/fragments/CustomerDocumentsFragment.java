package com.app.apsfl.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.activities.MainActivity;
import com.app.apsfl.activities.WorkOrderActivity;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.CustomerDocumentModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import io.realm.Realm;

public class CustomerDocumentsFragment extends Fragment
        implements View.OnClickListener, ResponseHandler,
        FragmentBackStackListener, UserActionInterface {

    private LinearLayout previousScreenLayout, submitScreenLayout;
    private Calendar calendarInstance;
    private Spinner identityProofSpinner, addressProofSpinner;
    private EditText identityDocNo, identityAuthority, identityPlace, addressDocNo, addressAuthority, addressPlace;
    private TextView identityProofDate, addressProofDate;
    private CheckBox formCustomerDeclaration, formLMODeclaration;
    private int proofType = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_customer_documents, container, false);
        initViews(layoutView);
        registerListeners();
        setData();
        return layoutView;
    }

    private void initViews(View view) {
        calendarInstance = Calendar.getInstance();
        LinearLayout screenLayout = (LinearLayout) view.findViewById(R.id.previousSubmitLayout);
        previousScreenLayout = (LinearLayout) screenLayout.findViewById(R.id.previousScreenLayout);
        submitScreenLayout = (LinearLayout) screenLayout.findViewById(R.id.submitScreenLayout);
        TextView previousScreenName = (TextView) previousScreenLayout.findViewById(R.id.previousScreenName);
        previousScreenName.setText(R.string.customer_address_screen_name);
        LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.mainLayout);
        identityProofSpinner = (Spinner) mainLayout.findViewById(R.id.identityProofSpinner);
        addressProofSpinner = (Spinner) mainLayout.findViewById(R.id.addressProofSpinner);
        identityDocNo = (EditText) mainLayout.findViewById(R.id.identityDocNo);
        identityAuthority = (EditText) mainLayout.findViewById(R.id.identityAuthority);
        identityPlace = (EditText) mainLayout.findViewById(R.id.identityPlace);
        addressDocNo = (EditText) mainLayout.findViewById(R.id.addressDocNo);
        addressAuthority = (EditText) mainLayout.findViewById(R.id.addressAuthority);
        addressPlace = (EditText) mainLayout.findViewById(R.id.addressPlace);
        identityProofDate = (TextView) mainLayout.findViewById(R.id.identityProofDate);
        addressProofDate = (TextView) mainLayout.findViewById(R.id.addressProofDate);
        formCustomerDeclaration = (CheckBox) mainLayout.findViewById(R.id.formCustomerDeclaration);
        formLMODeclaration = (CheckBox) mainLayout.findViewById(R.id.formLMODeclaration);
    }

    private void registerListeners() {
        previousScreenLayout.setOnClickListener(this);
        submitScreenLayout.setOnClickListener(this);
        identityProofDate.setOnClickListener(this);
        addressProofDate.setOnClickListener(this);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    calendarInstance.set(Calendar.YEAR, year);
                    calendarInstance.set(Calendar.MONTH, monthOfYear);
                    calendarInstance.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateProofsDate();
                }
            };

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                dateSetListener,
                calendarInstance.get(Calendar.YEAR),
                calendarInstance.get(Calendar.MONTH),
                calendarInstance.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(calendarInstance.getTimeInMillis());
        datePickerDialog.show();
    }

    private void updateProofsDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        switch (proofType) {

            case 1:
                identityProofDate.setText(format.format(calendarInstance.getTime()));
                break;

            case 2:
                addressProofDate.setText(format.format(calendarInstance.getTime()));
                break;
        }
    }

    private void setData() {
        Realm realm = Realm.getDefaultInstance();
        CustomerDocumentModel model = realm.where(CustomerDocumentModel.class).findFirst();
        if (model != null) {
            identityProofSpinner.setSelection(model.getIdentityType());
            identityDocNo.setText(model.getIdentityDOCNumber());
            identityAuthority.setText(model.getIdentityAuth());
            identityPlace.setText(model.getIdentityPlace());
            identityProofDate.setText(model.getIdentityDate());
            addressProofSpinner.setSelection(model.getAddressType());
            addressDocNo.setText(model.getAddressDOCNumber());
            addressAuthority.setText(model.getAddressAuth());
            addressPlace.setText(model.getAddressPlace());
            addressProofDate.setText(model.getAddressDate());
        }
        realm.close();
    }

    private boolean validateFormFields() {
        boolean isValid = false;
        if (FormValidations.isFormSpinnerItemSelected(identityProofSpinner, FormValidations.SPINNER.IDENTITY_PROOF))
            if (FormValidations.isFormEditTextValid(identityDocNo, FormValidations.FORM_FIELDS.IDENTITY_DOC))
                if (FormValidations.isFormEditTextValid(identityAuthority, FormValidations.FORM_FIELDS.IDENTITY_AUTH))
                    if (FormValidations.isFormEditTextValid(identityPlace, FormValidations.FORM_FIELDS.IDENTITY_PLACE))
                        if (!identityProofDate.getText().toString().equals(getString(R.string.identity_date_issue_hint))) {
                            if (FormValidations.isFormSpinnerItemSelected(addressProofSpinner, FormValidations.SPINNER.ADDRESS_PROOF))
                                if (FormValidations.isFormEditTextValid(addressDocNo, FormValidations.FORM_FIELDS.ADDRESS_DOC))
                                    if (FormValidations.isFormEditTextValid(addressAuthority, FormValidations.FORM_FIELDS.ADDRESS_AUTH))
                                        if (FormValidations.isFormEditTextValid(addressPlace, FormValidations.FORM_FIELDS.ADDRESS_PLACE))
                                            if (!addressProofDate.getText().toString().equals(getString(R.string.identity_date_issue_hint))) {
                                                if (FormValidations.isFormCheckBoxChecked(formCustomerDeclaration, FormValidations.CHECKBOXES.CUSTOMER_DEC))
                                                    if (FormValidations.isFormCheckBoxChecked(formLMODeclaration, FormValidations.CHECKBOXES.LMO_DEC))
                                                        isValid = true;
                                            } else {
                                                Utils.showDialog(getActivity(),
                                                        getString(R.string.invalid_address_date_title),
                                                        getString(R.string.invalid_address_date_message), null);
                                            }
                        } else {
                            Utils.showDialog(getActivity(),
                                    getString(R.string.invalid_identity_date_title),
                                    getString(R.string.invalid_identity_date_message), null);
                        }
        return isValid;
    }

    private void saveFormData() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            CustomerDocumentModel model = null;
            model = realm.where(CustomerDocumentModel.class).findFirst();
            if (model == null) {
                model = new CustomerDocumentModel();
            }
            model.setFormTime(Constants.formTime);
            model.setIdentityType(identityProofSpinner.getSelectedItemPosition());
            model.setIdentityDOCNumber(identityDocNo.getText().toString());
            model.setIdentityAuth(identityAuthority.getText().toString());
            model.setIdentityPlace(identityPlace.getText().toString());
            model.setIdentityDate(identityProofDate.getText().toString());
            model.setAddressType(addressProofSpinner.getSelectedItemPosition());
            model.setAddressDOCNumber(addressDocNo.getText().toString());
            model.setAddressAuth(addressAuthority.getText().toString());
            model.setAddressPlace(addressPlace.getText().toString());
            model.setAddressDate(addressProofDate.getText().toString());
            realm.copyToRealmOrUpdate(model);

            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            offlineFormModel.setFormCAFData(getFormDataAsJSON().toString());
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
            realm.close();
        } catch (Exception ex) {
            realm.cancelTransaction();
            realm.close();
            ex.printStackTrace();
        }
    }

    private JSONObject getFormDataAsJSON() {
        JSONObject formData = null;
        try {
            Realm resultRealm = Realm.getDefaultInstance();
            OfflineFormModel offlineFormModel = resultRealm.where(OfflineFormModel.class).equalTo("formTime", Constants.formTime).findFirst();
            formData = new JSONObject(offlineFormModel.getFormCAFData());
            formData.put("poiLov", String.valueOf(identityProofSpinner.getSelectedItemPosition()));
            formData.put("poiDocumentNo", identityDocNo.getText().toString());
            formData.put("poiDateOfIssue", identityProofDate.getText().toString());
            formData.put("poiPlaceOfIssue", identityPlace.getText().toString());
            formData.put("poiIssuingAuthority", identityAuthority.getText().toString());
            formData.put("poaLov", String.valueOf(addressProofSpinner.getSelectedItemPosition()));
            formData.put("poaDocumentNo", addressDocNo.getText().toString());
            formData.put("poaDateOfIssue", addressProofDate.getText().toString());
            formData.put("poaPlaceOfIssue", addressPlace.getText().toString());
            formData.put("poaIssuingAuthority", addressAuthority.getText().toString());
            formData.put("customerDec", formCustomerDeclaration.isChecked() ? "Y" : "N");
            formData.put("lmoDec", formLMODeclaration.isChecked() ? "Y" : "N");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return formData;
    }

    private void submitCAFForm(JSONObject requestData) {
        if (Utils.isNetworkAvailable(getActivity())) {
            Utils.showProgress(getActivity(), getString(R.string.submitting_caf_form));
            RequestHandler requestHandler = new RequestHandler();
            requestHandler.submitCAFForm(getActivity(), this, requestData, Constants.SAVE_CAF_FORM);
        } else {
            Utils.showDialog(this, getString(R.string.caf_form_saved_title),
                    getString(R.string.caf_form_saved_no_internet), Constants.SAVE_CAF_OFFLINE);
        }
    }

    private void saveCustomerID(String customerID) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class).equalTo("formTime", Constants.formTime).findFirst();
        offlineFormModel.setFormTime(offlineFormModel.getFormTime());
        offlineFormModel.setFormCAFData(offlineFormModel.getFormCAFData());
        offlineFormModel.setFormCAFData(offlineFormModel.getFormPaymentData());
        offlineFormModel.setFormUploaded(false);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.previousScreenLayout:
                saveFormData();
                getActivity().getSupportFragmentManager().popBackStack();
                break;

            case R.id.submitScreenLayout:
//                if (validateFormFields()) {
                saveFormData();
                submitCAFForm(getFormDataAsJSON());
//                }
                break;

            case R.id.identityProofDate:
                proofType = 1;
                showDatePickerDialog();
                break;

            case R.id.addressProofDate:
                proofType = 2;
                showDatePickerDialog();
                break;
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.SAVE_CAF_FORM:
                try {
                    Utils.cancelProgress();
                    JSONObject responseData = (JSONObject) response;
                    if (responseData.has("customerID")) {
                        Intent intent = new Intent(getActivity(), WorkOrderActivity.class);
                        String customerID = responseData.getString("customerID");
                        saveCustomerID(customerID);
                        intent.putExtra("customerID", customerID);
                        intent.putExtra("cafNumber", Constants.cafNumber);
                        getActivity().startActivity(intent);
                    } else {
                        Utils.showDialog(this, getString(R.string.caf_form_saved_title),
                                getString(R.string.caf_form_saved_request_failed), Constants.SAVE_CAF_OFFLINE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        saveFormData();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.SAVE_CAF_OFFLINE:
                getActivity().startActivity(new Intent(getActivity(), MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }
}
