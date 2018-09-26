package com.app.apsfl.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.app.apsfl.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidations {

    public enum SPINNER {
        CUSTOMER_TYPE, CUSTOMER_TITLE, BILL_CYCLE, SEGMENTS, CHANNELS, BILL_FREQUENCY,
        OLT_ID, OLT_PORT_ID, OLT_LEVEL_1, OLT_LEVEL_2, OLT_LEVEL_3, ONU_MODEL, ONU_DEVICE_PURCHASE, STB_MODEL, STB_DEVICE_PURCHASE,
        DISTRICT, IDENTITY_PROOF, ADDRESS_PROOF, PAYMENT_MODE, VPNSERVICE, TELEPHONICCONN_COUNT
    }

    public enum FORM_FIELDS {
        LOGIN_USER, LOGIN_PWD, CHANGE_PWD,
        AADHAAR_NUMBER_INDIVIDUAL, AADHAAR_NUMBER_ENTERPRISE,
        FIRST_NAME, MIDDLE_NAME, SURNAME, CONTACT_PERSON_NAME, FATHER_NAME, EMAIL_ID, PAN_NUMBER, TAN_NUMBER,
        ONU_MAC_ADDRESS, ONU_ID, EXTRA_CABLE_CHARGE, IPTV_MAC_ADDRESS, IPTV_ID,
        ADDRESS1, ADDRESS2, CITY, STATE, LOCALITY, DISTRICT, PINCODE, SI_PINCODE, MOBILE, ALTERNATE_MOBILE, STD_CODE, LANDLINE, LONGITUDE, LATITUDE, LOCATION,
        IDENTITY_DOC, IDENTITY_AUTH, IDENTITY_PLACE, ADDRESS_DOC, ADDRESS_AUTH, ADDRESS_PLACE,
        PAYMENT_AMOUNT, CAF_NUMBER, DD_NUMBER, DD_BANK, DD_BRANCH,
        OTP
    }

    public enum CHECKBOXES {
        CUSTOMER_DEC, LMO_DEC
    }

    public static boolean isFormCheckBoxChecked(final CheckBox checkBox,
                                                final CHECKBOXES type) {
        boolean isValid = false;
        Context mContext = checkBox.getContext();
        switch (type) {
            case CUSTOMER_DEC:
                isValid = checkBox.isChecked();
                if (!isValid)
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_customer_declaration_title),
                            mContext.getString(R.string.invalid_customer_declaration_message), null);
                break;

            case LMO_DEC:
                isValid = checkBox.isChecked();
                if (!isValid)
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_lmo_declaration_title),
                            mContext.getString(R.string.invalid_lmo_declaration_message), null);
                break;
        }
        return isValid;
    }

    public static boolean isFormSpinnerItemSelected(final Spinner spinner,
                                                    final SPINNER type) {
        boolean isValid = false;
        Context mContext = spinner.getContext();
        if (spinner.getSelectedItemPosition() != 0) {
            isValid = true;
        } else {
            switch (type) {
                case CUSTOMER_TYPE:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_customer_type_title),
                            mContext.getString(R.string.invalid_customer_type_message), null);
                    break;

                case CUSTOMER_TITLE:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_customer_title_text),
                            mContext.getString(R.string.invalid_customer_title_message), null);
                    break;

                case BILL_CYCLE:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_bill_cycle_title),
                            mContext.getString(R.string.invalid_bill_cycle_message), null);
                    break;

                case SEGMENTS:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_segments_title),
                            mContext.getString(R.string.invalid_segments_message), null);
                    break;

                case CHANNELS:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_channels_title),
                            mContext.getString(R.string.invalid_channels_message), null);
                    break;

                case BILL_FREQUENCY:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_bill_frequency_title),
                            mContext.getString(R.string.invalid_bill_frequency_message), null);
                    break;

                case OLT_ID:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_olt_id_title),
                            mContext.getString(R.string.invalid_olt_id_message), null);
                    break;

                case OLT_PORT_ID:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_olt_port_id_title),
                            mContext.getString(R.string.invalid_olt_port_id_message), null);
                    break;

                case OLT_LEVEL_1:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_olt_level_1_title),
                            mContext.getString(R.string.invalid_olt_level_1_message), null);
                    break;

                case OLT_LEVEL_2:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_olt_level_2_title),
                            mContext.getString(R.string.invalid_olt_level_2_message), null);
                    break;

                case OLT_LEVEL_3:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_olt_level_3_title),
                            mContext.getString(R.string.invalid_olt_level_3_message), null);
                    break;

                case ONU_MODEL:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_cpe_model_title),
                            mContext.getString(R.string.invalid_cpe_model_message), null);
                    break;

                case ONU_DEVICE_PURCHASE:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_cpe_device_purchase_title),
                            mContext.getString(R.string.invalid_cpe_device_purchase_message), null);
                    break;

                case STB_MODEL:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_stb_model_title),
                            mContext.getString(R.string.invalid_stb_model_message), null);
                    break;

                case STB_DEVICE_PURCHASE:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_stb_device_purchase_title),
                            mContext.getString(R.string.invalid_stb_device_purchase_message), null);
                    break;

                case DISTRICT:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_district_title),
                            mContext.getString(R.string.invalid_district_message), null);
                    break;

                case IDENTITY_PROOF:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_identity_type_title),
                            mContext.getString(R.string.invalid_identity_type_message), null);
                    break;

                case ADDRESS_PROOF:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_address_type_title),
                            mContext.getString(R.string.invalid_address_type_message), null);
                    break;

                case PAYMENT_MODE:
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_payment_mode_title),
                            mContext.getString(R.string.invalid_payment_mode_message), null);
                    break;
                case VPNSERVICE:
                    Utils.showDialog(mContext,
                            "Invalid VPN Service",
                            "Please select a valid vpn service", null);
                    break;
                case TELEPHONICCONN_COUNT:
                    Utils.showDialog(mContext,
                            "Invalid No. of Telephone Connections ",
                            "Please select a valid no. of telephone connections", null);
                    break;

            }
        }
        return isValid;
    }

    public static boolean isFormEditTextValid(final EditText formEditText,
                                              final FORM_FIELDS fieldType) {
        boolean isValid = false;
        Context mContext = formEditText.getContext();
        String inputText = formEditText.getText().toString();
        Pattern pattern;
        Matcher matcher;
        switch (fieldType) {

            case LOGIN_USER:
                String nameRegex = "^[A-Za-z0-9]{1,20}$";
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
//                    pattern = Pattern.compile(nameRegex);
//                    matcher = pattern.matcher(inputText);
//                    if (matcher.matches()) {
//                        isValid = true;
//                    } else {
//                        Utils.showDialog(mContext,
//                                mContext.getString(R.string.login_username_invalid_title),
//                                mContext.getString(R.string.login_username_invalid_message), null);
//                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.login_username_invalid_title),
                            mContext.getString(R.string.login_username_empty_message), null);
                }
                break;

            case LOGIN_PWD:
                String passwordRegex = "^.{4,13}$";
                if (!TextUtils.isEmpty(inputText)) {
                    pattern = Pattern.compile(passwordRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.login_password_invalid_title),
                                mContext.getString(R.string.login_password_invalid_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.login_password_invalid_title),
                            mContext.getString(R.string.login_password_empty_message), null);
                }
                break;
            case CHANGE_PWD:
                String changePasswordRegex = "^.{6,12}$";
                if (!TextUtils.isEmpty(inputText)) {
                    pattern = Pattern.compile(changePasswordRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.login_password_invalid_title),
                                mContext.getString(R.string.login_password_invalid_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.login_password_invalid_title),
                            mContext.getString(R.string.login_password_empty_message), null);
                }
                break;
            case AADHAAR_NUMBER_INDIVIDUAL:
                if (!TextUtils.isEmpty(inputText)) {
                    String stdRegex = "^\\d{12}$";
                    pattern = Pattern.compile(stdRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches() && Utils.validateAadhaar(inputText)) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_aadhaar_title),
                                mContext.getString(R.string.invalid_aadhaar_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_aadhaar_title),
                            mContext.getString(R.string.empty_aadhaar_message), null);
                }
                break;

            case AADHAAR_NUMBER_ENTERPRISE:
                if (!TextUtils.isEmpty(inputText)) {
                    String stdRegex = "^.{12,20}$";
                    pattern = Pattern.compile(stdRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_registration_number_title),
                                mContext.getString(R.string.invalid_registration_number_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_registration_number_title),
                            mContext.getString(R.string.empty_registration_number_message), null);
                }
                break;

            case CAF_NUMBER:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_caf_title),
                            mContext.getString(R.string.empty_caf_message), null);
                }
                break;

            case DD_NUMBER:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_dd_no_title),
                            mContext.getString(R.string.empty_dd_no_message), null);
                }
                break;

            case DD_BANK:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_dd_bank_title),
                            mContext.getString(R.string.empty_dd_bank_message), null);
                }
                break;

            case DD_BRANCH:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_dd_branch_title),
                            mContext.getString(R.string.empty_dd_branch_message), null);
                }
                break;

            case FIRST_NAME:
                if (!TextUtils.isEmpty(inputText)) {


                    if (inputText.length() < 3) {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.firstname),
                                mContext.getString(R.string.should), null);
                    } else {
                        isValid = true;

                    }

                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_first_name_title),
                            mContext.getString(R.string.empty_first_name_message), null);
                }
                break;

            case MIDDLE_NAME:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_middle_name_title),
                            mContext.getString(R.string.empty_middle_name_message), null);
                }
                break;

            case SURNAME:
                if (!TextUtils.isEmpty(inputText)) {
                    if (inputText.length() < 1) {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.surname),
                                mContext.getString(R.string.shouldone), null);
                    } else {
                        isValid = true;

                    }

                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_last_name_title),
                            mContext.getString(R.string.empty_last_name_message), null);
                }
                break;

            case CONTACT_PERSON_NAME:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_contact_person_name_title),
                            mContext.getString(R.string.empty_contact_person_name_message), null);
                }
                break;

            case FATHER_NAME:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_father_name_title),
                            mContext.getString(R.string.empty_father_name_message), null);
                }
                break;

            case EMAIL_ID:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = Patterns.EMAIL_ADDRESS.matcher(inputText).matches();
                    if (!isValid) {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_email_title),
                                mContext.getString(R.string.invalid_email_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_email_title),
                            mContext.getString(R.string.empty_email_message), null);
                }
                break;

            case PAN_NUMBER:
                if (!TextUtils.isEmpty(inputText)) {
                    if (inputText.length() == 10) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_pan_title),
                                mContext.getString(R.string.invalid_pan_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_pan_title),
                            mContext.getString(R.string.empty_pan_message), null);
                }
                break;

            case TAN_NUMBER:
                if (!TextUtils.isEmpty(inputText)) {
                    if (inputText.length() == 10) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_tan_title),
                                mContext.getString(R.string.invalid_tan_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_tan_title),
                            mContext.getString(R.string.empty_tan_message), null);
                }
                break;

            case ONU_MAC_ADDRESS:
                if (!TextUtils.isEmpty(inputText)) {
                    String macRegex = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
                    pattern = Pattern.compile(macRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_onu_mac_title),
                                mContext.getString(R.string.invalid_onu_mac_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_onu_mac_title),
                            mContext.getString(R.string.empty_onu_mac_message), null);
                }
                break;

            case ONU_ID:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_cpe_id_title),
                            mContext.getString(R.string.empty_cpe_id_message), null);
                }
                break;

            case EXTRA_CABLE_CHARGE:
                if (!TextUtils.isEmpty(inputText)) {
                    String stdRegex = "^\\d{0,8}+(\\.\\d{1,2})?$";
                    pattern = Pattern.compile(stdRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_extra_cable_charge_title),
                                mContext.getString(R.string.not_valid_extra_cable_charge), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_extra_cable_charge_title),
                            mContext.getString(R.string.empty_extra_cable_charge_message), null);
                }
                break;

            case IPTV_ID:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_iptv_id_title),
                            mContext.getString(R.string.empty_iptv_id_message), null);
                }
                break;

            case IPTV_MAC_ADDRESS:
                if (!TextUtils.isEmpty(inputText)) {
                    String macRegex = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
                    pattern = Pattern.compile(macRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_iptv_mac_title),
                                mContext.getString(R.string.invalid_iptv_mac_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_iptv_mac_title),
                            mContext.getString(R.string.empty_iptv_mac_message), null);
                }
                break;

            case LATITUDE:
                String latitudeRegex = "^(\\- ?\\d + (\\.\\d +)?),\\s * (\\- ?\\d + (\\.\\d +)?)$";
                pattern = Pattern.compile(latitudeRegex);
                matcher = pattern.matcher(inputText);
                if (matcher.matches()) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_latitude_title),
                            mContext.getString(R.string.invalid_latitude_message), null);
                }
                break;

            case LONGITUDE:
                String longitudeRegex = "^(\\- ?\\d + (\\.\\d +)?),\\s * (\\- ?\\d + (\\.\\d +)?)$";
                pattern = Pattern.compile(longitudeRegex);
                matcher = pattern.matcher(inputText);
                if (matcher.matches()) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_longitude_title),
                            mContext.getString(R.string.invalid_longitude_message), null);
                }
                break;

            case LOCATION:
                if (!TextUtils.isEmpty(inputText)) {
                    /*String macRegex = "/[^A-Za-z0-9/#&-]";
                    pattern = Pattern.compile(macRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {*/
                    isValid = true;
                   /* } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_location_title),
                                mContext.getString(R.string.invalid_location_message), null);
                    }*/
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_location_title),
                            mContext.getString(R.string.invalid_location_message), null);
                }
                break;

            case ADDRESS1:
                if (!TextUtils.isEmpty(inputText)) {
                   /* String macRegex = "/[^A-Za-z0-9/#&-]";
                    pattern = Pattern.compile(macRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {*/
                    isValid = true;
                    /*} else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_address1_title),
                                mContext.getString(R.string.empty_address1_message), null);
                    }*/
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_address1_title),
                            mContext.getString(R.string.empty_address1_message), null);
                }
                break;

            case ADDRESS2:
                if (!TextUtils.isEmpty(inputText)) {
                   /* String macRegex = "/[^A-Za-z0-9/#&-]";
                    pattern = Pattern.compile(macRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {*/
                    isValid = true;
                    /*} else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_address2_title),
                                mContext.getString(R.string.invalid_address2_message), null);
                    }*/
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_address2_title),
                            mContext.getString(R.string.invalid_address2_message), null);
                }
                break;

            case CITY:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_city_title),
                            mContext.getString(R.string.empty_city_message), null);
                }
                break;

            case STATE:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_state_title),
                            mContext.getString(R.string.empty_state_message), null);
                }
                break;

            case LOCALITY:
                if (!TextUtils.isEmpty(inputText)) {
                    /*String macRegex = "/[^A-Za-z0-9/#&-]";
                    pattern = Pattern.compile(macRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {*/
                    isValid = true;
                   /* } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_locality_title),
                                mContext.getString(R.string.empty_locality_message), null);
                    }*/
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_locality_title),
                            mContext.getString(R.string.empty_locality_message), null);
                }
                break;

            case DISTRICT:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_area_title),
                            mContext.getString(R.string.invalid_area_message), null);
                }
                break;

            case PINCODE:
                if (!TextUtils.isEmpty(inputText)) {
                    String pinCodeRegex = "^[0-9]{6}$";
                    pattern = Pattern.compile(pinCodeRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_pinCode_title),
                                mContext.getString(R.string.invalid_pinCode_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_pinCode_title),
                            mContext.getString(R.string.empty_pinCode_message), null);
                }
                break;
            case SI_PINCODE:
                if (!TextUtils.isEmpty(inputText)) {
                    String pinCodeRegex = "^[0-9]{6}$";
                    pattern = Pattern.compile(pinCodeRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_pinCode_title),
                                mContext.getString(R.string.invalid_pinCode_message), null);
                    }
                } else {
                    isValid = true;
                }
                break;
            case MOBILE:
                if (!TextUtils.isEmpty(inputText)) {
                    String mobileRegex = "^[0-9]{10}$";
                    pattern = Pattern.compile(mobileRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_mobile_title),
                                mContext.getString(R.string.invalid_mobile_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_mobile_title),
                            mContext.getString(R.string.empty_mobile_message), null);
                }
                break;

            case ALTERNATE_MOBILE:
                if (!TextUtils.isEmpty(inputText)) {
                    String mobileRegex = "^[0-9]{10}$";
                    pattern = Pattern.compile(mobileRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_alternate_mobile_title),
                                mContext.getString(R.string.invalid_alternate_mobile_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_alternate_mobile_title),
                            mContext.getString(R.string.empty_alternate_mobile_message), null);
                }
                break;

            case STD_CODE:
                String stdRegex = "^\\d{3,5}$";
                pattern = Pattern.compile(stdRegex);
                matcher = pattern.matcher(inputText);
                if (matcher.matches()) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_std_code_title),
                            mContext.getString(R.string.invalid_std_code_message), null);
                }
                break;

            case LANDLINE:
                String landLineRegex = "^\\d{6,10}$";
                pattern = Pattern.compile(landLineRegex);
                matcher = pattern.matcher(inputText);
                if (matcher.matches()) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_landline_title),
                            mContext.getString(R.string.invalid_landline_message), null);
                }
                break;

            case OTP:
                if (!TextUtils.isEmpty(inputText)) {
                    String otpRegex = "^\\d{4}$";
                    pattern = Pattern.compile(otpRegex);
                    matcher = pattern.matcher(inputText);
                    if (matcher.matches()) {
                        isValid = true;
                    } else {
                        Utils.showDialog(mContext,
                                mContext.getString(R.string.invalid_otp_title),
                                mContext.getString(R.string.invalid_otp_message), null);
                    }
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_otp_title),
                            mContext.getString(R.string.empty_otp_message), null);
                }
                break;

            case IDENTITY_DOC:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_identity_doc_title),
                            mContext.getString(R.string.invalid_identity_doc_message), null);
                }
                break;

            case IDENTITY_AUTH:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_identity_auth_title),
                            mContext.getString(R.string.invalid_identity_auth_message), null);
                }
                break;

            case IDENTITY_PLACE:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_identity_place_title),
                            mContext.getString(R.string.invalid_identity_place_message), null);
                }
                break;

            case ADDRESS_DOC:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_address_doc_title),
                            mContext.getString(R.string.invalid_address_doc_title), null);
                }
                break;

            case ADDRESS_AUTH:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_address_auth_title),
                            mContext.getString(R.string.invalid_address_auth_message), null);
                }
                break;

            case ADDRESS_PLACE:
                if (!TextUtils.isEmpty(inputText)) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_address_place_title),
                            mContext.getString(R.string.invalid_address_place_message), null);
                }
                break;

            case PAYMENT_AMOUNT:
                if (!TextUtils.isEmpty(inputText) && !inputText.equals("0")) {
                    isValid = true;
                } else {
                    Utils.showDialog(mContext,
                            mContext.getString(R.string.invalid_payment_amount_title),
                            mContext.getString(R.string.empty_payment_amount_message), null);
                }
                break;
        }

        return isValid;
    }
}