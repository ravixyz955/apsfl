package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomerInfoModelRealmProxy extends com.app.apsfl.models.CustomerInfoModel
    implements RealmObjectProxy, CustomerInfoModelRealmProxyInterface {

    static final class CustomerInfoModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long formTimeIndex;
        public long customerAadhaarNumberIndex;
        public long customerTitleIndex;
        public long customerFirstNameIndex;
        public long customerMiddleNameIndex;
        public long customerLastNameIndex;
        public long customerFatherNameIndex;
        public long customerDOBIndex;
        public long customerGenderIndex;
        public long contactPersonNameIndex;
        public long customerEmailIndex;
        public long billFrequencyPositionIndex;
        public long billCyclePositionIndex;
        public long segmentPositionIndex;
        public long channelPositionIndex;
        public long customerPANIndex;
        public long customerTANIndex;
        public long allPackagesSILMOIndex;
        public long cafStatusIndex;
        public long isDataFromAadharIndex;
        public long statusIndex;

        CustomerInfoModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(21);
            this.formTimeIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "formTime");
            indicesMap.put("formTime", this.formTimeIndex);
            this.customerAadhaarNumberIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerAadhaarNumber");
            indicesMap.put("customerAadhaarNumber", this.customerAadhaarNumberIndex);
            this.customerTitleIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerTitle");
            indicesMap.put("customerTitle", this.customerTitleIndex);
            this.customerFirstNameIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerFirstName");
            indicesMap.put("customerFirstName", this.customerFirstNameIndex);
            this.customerMiddleNameIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerMiddleName");
            indicesMap.put("customerMiddleName", this.customerMiddleNameIndex);
            this.customerLastNameIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerLastName");
            indicesMap.put("customerLastName", this.customerLastNameIndex);
            this.customerFatherNameIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerFatherName");
            indicesMap.put("customerFatherName", this.customerFatherNameIndex);
            this.customerDOBIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerDOB");
            indicesMap.put("customerDOB", this.customerDOBIndex);
            this.customerGenderIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerGender");
            indicesMap.put("customerGender", this.customerGenderIndex);
            this.contactPersonNameIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "contactPersonName");
            indicesMap.put("contactPersonName", this.contactPersonNameIndex);
            this.customerEmailIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerEmail");
            indicesMap.put("customerEmail", this.customerEmailIndex);
            this.billFrequencyPositionIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "billFrequencyPosition");
            indicesMap.put("billFrequencyPosition", this.billFrequencyPositionIndex);
            this.billCyclePositionIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "billCyclePosition");
            indicesMap.put("billCyclePosition", this.billCyclePositionIndex);
            this.segmentPositionIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "segmentPosition");
            indicesMap.put("segmentPosition", this.segmentPositionIndex);
            this.channelPositionIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "channelPosition");
            indicesMap.put("channelPosition", this.channelPositionIndex);
            this.customerPANIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerPAN");
            indicesMap.put("customerPAN", this.customerPANIndex);
            this.customerTANIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "customerTAN");
            indicesMap.put("customerTAN", this.customerTANIndex);
            this.allPackagesSILMOIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "allPackagesSILMO");
            indicesMap.put("allPackagesSILMO", this.allPackagesSILMOIndex);
            this.cafStatusIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "cafStatus");
            indicesMap.put("cafStatus", this.cafStatusIndex);
            this.isDataFromAadharIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "isDataFromAadhar");
            indicesMap.put("isDataFromAadhar", this.isDataFromAadharIndex);
            this.statusIndex = getValidColumnIndex(path, table, "CustomerInfoModel", "status");
            indicesMap.put("status", this.statusIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CustomerInfoModelColumnInfo otherInfo = (CustomerInfoModelColumnInfo) other;
            this.formTimeIndex = otherInfo.formTimeIndex;
            this.customerAadhaarNumberIndex = otherInfo.customerAadhaarNumberIndex;
            this.customerTitleIndex = otherInfo.customerTitleIndex;
            this.customerFirstNameIndex = otherInfo.customerFirstNameIndex;
            this.customerMiddleNameIndex = otherInfo.customerMiddleNameIndex;
            this.customerLastNameIndex = otherInfo.customerLastNameIndex;
            this.customerFatherNameIndex = otherInfo.customerFatherNameIndex;
            this.customerDOBIndex = otherInfo.customerDOBIndex;
            this.customerGenderIndex = otherInfo.customerGenderIndex;
            this.contactPersonNameIndex = otherInfo.contactPersonNameIndex;
            this.customerEmailIndex = otherInfo.customerEmailIndex;
            this.billFrequencyPositionIndex = otherInfo.billFrequencyPositionIndex;
            this.billCyclePositionIndex = otherInfo.billCyclePositionIndex;
            this.segmentPositionIndex = otherInfo.segmentPositionIndex;
            this.channelPositionIndex = otherInfo.channelPositionIndex;
            this.customerPANIndex = otherInfo.customerPANIndex;
            this.customerTANIndex = otherInfo.customerTANIndex;
            this.allPackagesSILMOIndex = otherInfo.allPackagesSILMOIndex;
            this.cafStatusIndex = otherInfo.cafStatusIndex;
            this.isDataFromAadharIndex = otherInfo.isDataFromAadharIndex;
            this.statusIndex = otherInfo.statusIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CustomerInfoModelColumnInfo clone() {
            return (CustomerInfoModelColumnInfo) super.clone();
        }

    }
    private CustomerInfoModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("formTime");
        fieldNames.add("customerAadhaarNumber");
        fieldNames.add("customerTitle");
        fieldNames.add("customerFirstName");
        fieldNames.add("customerMiddleName");
        fieldNames.add("customerLastName");
        fieldNames.add("customerFatherName");
        fieldNames.add("customerDOB");
        fieldNames.add("customerGender");
        fieldNames.add("contactPersonName");
        fieldNames.add("customerEmail");
        fieldNames.add("billFrequencyPosition");
        fieldNames.add("billCyclePosition");
        fieldNames.add("segmentPosition");
        fieldNames.add("channelPosition");
        fieldNames.add("customerPAN");
        fieldNames.add("customerTAN");
        fieldNames.add("allPackagesSILMO");
        fieldNames.add("cafStatus");
        fieldNames.add("isDataFromAadhar");
        fieldNames.add("status");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CustomerInfoModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CustomerInfoModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.CustomerInfoModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public Long realmGet$formTime() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.formTimeIndex)) {
            return null;
        }
        return (long) proxyState.getRow$realm().getLong(columnInfo.formTimeIndex);
    }

    public void realmSet$formTime(Long value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'formTime' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$customerAadhaarNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerAadhaarNumberIndex);
    }

    public void realmSet$customerAadhaarNumber(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerAadhaarNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerAadhaarNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerAadhaarNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerAadhaarNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$customerTitle() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.customerTitleIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.customerTitleIndex);
    }

    public void realmSet$customerTitle(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.customerTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerTitleIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.customerTitleIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerFirstName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerFirstNameIndex);
    }

    public void realmSet$customerFirstName(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerFirstNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerFirstNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerFirstNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerFirstNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerMiddleName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerMiddleNameIndex);
    }

    public void realmSet$customerMiddleName(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerMiddleNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerMiddleNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerMiddleNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerMiddleNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerLastName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerLastNameIndex);
    }

    public void realmSet$customerLastName(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerLastNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerLastNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerLastNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerLastNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerFatherName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerFatherNameIndex);
    }

    public void realmSet$customerFatherName(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerFatherNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerFatherNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerFatherNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerFatherNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerDOB() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerDOBIndex);
    }

    public void realmSet$customerDOB(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerDOBIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerDOBIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerDOBIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerDOBIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$customerGender() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.customerGenderIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.customerGenderIndex);
    }

    public void realmSet$customerGender(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerGenderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.customerGenderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerGenderIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.customerGenderIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$contactPersonName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contactPersonNameIndex);
    }

    public void realmSet$contactPersonName(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contactPersonNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contactPersonNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contactPersonNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contactPersonNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerEmail() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerEmailIndex);
    }

    public void realmSet$customerEmail(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerEmailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerEmailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerEmailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerEmailIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$billFrequencyPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.billFrequencyPositionIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.billFrequencyPositionIndex);
    }

    public void realmSet$billFrequencyPosition(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.billFrequencyPositionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.billFrequencyPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.billFrequencyPositionIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.billFrequencyPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$billCyclePosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.billCyclePositionIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.billCyclePositionIndex);
    }

    public void realmSet$billCyclePosition(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.billCyclePositionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.billCyclePositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.billCyclePositionIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.billCyclePositionIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$segmentPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.segmentPositionIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.segmentPositionIndex);
    }

    public void realmSet$segmentPosition(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.segmentPositionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.segmentPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.segmentPositionIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.segmentPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$channelPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.channelPositionIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.channelPositionIndex);
    }

    public void realmSet$channelPosition(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.channelPositionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.channelPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.channelPositionIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.channelPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerPAN() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerPANIndex);
    }

    public void realmSet$customerPAN(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerPANIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerPANIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerPANIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerPANIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerTAN() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerTANIndex);
    }

    public void realmSet$customerTAN(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerTANIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerTANIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerTANIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerTANIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$allPackagesSILMO() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.allPackagesSILMOIndex);
    }

    public void realmSet$allPackagesSILMO(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.allPackagesSILMOIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.allPackagesSILMOIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.allPackagesSILMOIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.allPackagesSILMOIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cafStatus() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cafStatusIndex);
    }

    public void realmSet$cafStatus(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cafStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cafStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cafStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cafStatusIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isDataFromAadhar() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isDataFromAadharIndex);
    }

    public void realmSet$isDataFromAadhar(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isDataFromAadharIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isDataFromAadharIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$status() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    public void realmSet$status(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CustomerInfoModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CustomerInfoModel");
            realmObjectSchema.add(new Property("formTime", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerAadhaarNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerTitle", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerFirstName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerMiddleName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerLastName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerFatherName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerDOB", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerGender", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("contactPersonName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerEmail", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("billFrequencyPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("billCyclePosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("segmentPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("channelPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerPAN", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerTAN", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("allPackagesSILMO", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cafStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isDataFromAadhar", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CustomerInfoModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CustomerInfoModel")) {
            Table table = sharedRealm.getTable("class_CustomerInfoModel");
            table.addColumn(RealmFieldType.INTEGER, "formTime", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerAadhaarNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "customerTitle", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerFirstName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerMiddleName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerLastName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerFatherName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerDOB", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "customerGender", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "contactPersonName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerEmail", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "billFrequencyPosition", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "billCyclePosition", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "segmentPosition", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "channelPosition", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerPAN", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerTAN", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "allPackagesSILMO", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cafStatus", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isDataFromAadhar", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "status", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("formTime"));
            table.setPrimaryKey("formTime");
            return table;
        }
        return sharedRealm.getTable("class_CustomerInfoModel");
    }

    public static CustomerInfoModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CustomerInfoModel")) {
            Table table = sharedRealm.getTable("class_CustomerInfoModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 21) {
                if (columnCount < 21) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 21 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 21 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 21 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 21; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CustomerInfoModelColumnInfo columnInfo = new CustomerInfoModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("formTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'formTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("formTime") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Long' for field 'formTime' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.formTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'formTime' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("formTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'formTime' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("formTime"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'formTime' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("customerAadhaarNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerAadhaarNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerAadhaarNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerAadhaarNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerAadhaarNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerAadhaarNumber' is required. Either set @Required to field 'customerAadhaarNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerTitle")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerTitle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerTitle") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'customerTitle' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerTitleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'customerTitle' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'customerTitle' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerFirstName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerFirstName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerFirstName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerFirstName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerFirstNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerFirstName' is required. Either set @Required to field 'customerFirstName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerMiddleName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerMiddleName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerMiddleName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerMiddleName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerMiddleNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerMiddleName' is required. Either set @Required to field 'customerMiddleName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerLastName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerLastName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerLastName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerLastName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerLastNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerLastName' is required. Either set @Required to field 'customerLastName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerFatherName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerFatherName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerFatherName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerFatherName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerFatherNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerFatherName' is required. Either set @Required to field 'customerFatherName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerDOB")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerDOB' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerDOB") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerDOB' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerDOBIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerDOB' is required. Either set @Required to field 'customerDOB' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerGender")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerGender' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerGender") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'customerGender' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerGenderIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'customerGender' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'customerGender' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("contactPersonName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contactPersonName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("contactPersonName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contactPersonName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.contactPersonNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contactPersonName' is required. Either set @Required to field 'contactPersonName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerEmail")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerEmail' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerEmail") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerEmail' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerEmailIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerEmail' is required. Either set @Required to field 'customerEmail' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("billFrequencyPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'billFrequencyPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("billFrequencyPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'billFrequencyPosition' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.billFrequencyPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'billFrequencyPosition' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'billFrequencyPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("billCyclePosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'billCyclePosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("billCyclePosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'billCyclePosition' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.billCyclePositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'billCyclePosition' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'billCyclePosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("segmentPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'segmentPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("segmentPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'segmentPosition' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.segmentPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'segmentPosition' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'segmentPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("channelPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'channelPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("channelPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'channelPosition' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.channelPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'channelPosition' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'channelPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerPAN")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerPAN' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerPAN") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerPAN' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerPANIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerPAN' is required. Either set @Required to field 'customerPAN' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerTAN")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerTAN' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerTAN") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerTAN' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerTANIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerTAN' is required. Either set @Required to field 'customerTAN' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("allPackagesSILMO")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'allPackagesSILMO' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("allPackagesSILMO") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'allPackagesSILMO' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.allPackagesSILMOIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'allPackagesSILMO' is required. Either set @Required to field 'allPackagesSILMO' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cafStatus")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cafStatus' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cafStatus") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cafStatus' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cafStatusIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cafStatus' is required. Either set @Required to field 'cafStatus' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isDataFromAadhar")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isDataFromAadhar' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isDataFromAadhar") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isDataFromAadhar' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isDataFromAadharIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isDataFromAadhar' does support null values in the existing Realm file. Use corresponding boxed type for field 'isDataFromAadhar' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("status")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("status") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'status' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.statusIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' is required. Either set @Required to field 'status' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CustomerInfoModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CustomerInfoModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.CustomerInfoModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.CustomerInfoModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.CustomerInfoModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("formTime")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("formTime"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CustomerInfoModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CustomerInfoModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("formTime")) {
                if (json.isNull("formTime")) {
                    obj = (io.realm.CustomerInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CustomerInfoModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CustomerInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CustomerInfoModel.class, json.getLong("formTime"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'formTime'.");
            }
        }
        if (json.has("customerAadhaarNumber")) {
            if (json.isNull("customerAadhaarNumber")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber((String) json.getString("customerAadhaarNumber"));
            }
        }
        if (json.has("customerTitle")) {
            if (json.isNull("customerTitle")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTitle(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTitle((int) json.getInt("customerTitle"));
            }
        }
        if (json.has("customerFirstName")) {
            if (json.isNull("customerFirstName")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFirstName(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFirstName((String) json.getString("customerFirstName"));
            }
        }
        if (json.has("customerMiddleName")) {
            if (json.isNull("customerMiddleName")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerMiddleName(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerMiddleName((String) json.getString("customerMiddleName"));
            }
        }
        if (json.has("customerLastName")) {
            if (json.isNull("customerLastName")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerLastName(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerLastName((String) json.getString("customerLastName"));
            }
        }
        if (json.has("customerFatherName")) {
            if (json.isNull("customerFatherName")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFatherName(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFatherName((String) json.getString("customerFatherName"));
            }
        }
        if (json.has("customerDOB")) {
            if (json.isNull("customerDOB")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerDOB(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerDOB((String) json.getString("customerDOB"));
            }
        }
        if (json.has("customerGender")) {
            if (json.isNull("customerGender")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerGender(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerGender((int) json.getInt("customerGender"));
            }
        }
        if (json.has("contactPersonName")) {
            if (json.isNull("contactPersonName")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$contactPersonName(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$contactPersonName((String) json.getString("contactPersonName"));
            }
        }
        if (json.has("customerEmail")) {
            if (json.isNull("customerEmail")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerEmail(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerEmail((String) json.getString("customerEmail"));
            }
        }
        if (json.has("billFrequencyPosition")) {
            if (json.isNull("billFrequencyPosition")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billFrequencyPosition(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billFrequencyPosition((int) json.getInt("billFrequencyPosition"));
            }
        }
        if (json.has("billCyclePosition")) {
            if (json.isNull("billCyclePosition")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billCyclePosition(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billCyclePosition((int) json.getInt("billCyclePosition"));
            }
        }
        if (json.has("segmentPosition")) {
            if (json.isNull("segmentPosition")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$segmentPosition(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$segmentPosition((int) json.getInt("segmentPosition"));
            }
        }
        if (json.has("channelPosition")) {
            if (json.isNull("channelPosition")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$channelPosition(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$channelPosition((int) json.getInt("channelPosition"));
            }
        }
        if (json.has("customerPAN")) {
            if (json.isNull("customerPAN")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerPAN(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerPAN((String) json.getString("customerPAN"));
            }
        }
        if (json.has("customerTAN")) {
            if (json.isNull("customerTAN")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTAN(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTAN((String) json.getString("customerTAN"));
            }
        }
        if (json.has("allPackagesSILMO")) {
            if (json.isNull("allPackagesSILMO")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$allPackagesSILMO(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$allPackagesSILMO((String) json.getString("allPackagesSILMO"));
            }
        }
        if (json.has("cafStatus")) {
            if (json.isNull("cafStatus")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$cafStatus(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$cafStatus((String) json.getString("cafStatus"));
            }
        }
        if (json.has("isDataFromAadhar")) {
            if (json.isNull("isDataFromAadhar")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isDataFromAadhar' to null.");
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$isDataFromAadhar((boolean) json.getBoolean("isDataFromAadhar"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$status(null);
            } else {
                ((CustomerInfoModelRealmProxyInterface) obj).realmSet$status((String) json.getString("status"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.CustomerInfoModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.CustomerInfoModel obj = new com.app.apsfl.models.CustomerInfoModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("formTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$formTime(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$formTime((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("customerAadhaarNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber((String) reader.nextString());
                }
            } else if (name.equals("customerTitle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTitle(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTitle((int) reader.nextInt());
                }
            } else if (name.equals("customerFirstName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFirstName(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFirstName((String) reader.nextString());
                }
            } else if (name.equals("customerMiddleName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerMiddleName(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerMiddleName((String) reader.nextString());
                }
            } else if (name.equals("customerLastName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerLastName(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerLastName((String) reader.nextString());
                }
            } else if (name.equals("customerFatherName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFatherName(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerFatherName((String) reader.nextString());
                }
            } else if (name.equals("customerDOB")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerDOB(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerDOB((String) reader.nextString());
                }
            } else if (name.equals("customerGender")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerGender(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerGender((int) reader.nextInt());
                }
            } else if (name.equals("contactPersonName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$contactPersonName(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$contactPersonName((String) reader.nextString());
                }
            } else if (name.equals("customerEmail")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerEmail(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerEmail((String) reader.nextString());
                }
            } else if (name.equals("billFrequencyPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billFrequencyPosition(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billFrequencyPosition((int) reader.nextInt());
                }
            } else if (name.equals("billCyclePosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billCyclePosition(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$billCyclePosition((int) reader.nextInt());
                }
            } else if (name.equals("segmentPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$segmentPosition(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$segmentPosition((int) reader.nextInt());
                }
            } else if (name.equals("channelPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$channelPosition(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$channelPosition((int) reader.nextInt());
                }
            } else if (name.equals("customerPAN")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerPAN(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerPAN((String) reader.nextString());
                }
            } else if (name.equals("customerTAN")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTAN(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$customerTAN((String) reader.nextString());
                }
            } else if (name.equals("allPackagesSILMO")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$allPackagesSILMO(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$allPackagesSILMO((String) reader.nextString());
                }
            } else if (name.equals("cafStatus")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$cafStatus(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$cafStatus((String) reader.nextString());
                }
            } else if (name.equals("isDataFromAadhar")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isDataFromAadhar' to null.");
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$isDataFromAadhar((boolean) reader.nextBoolean());
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$status(null);
                } else {
                    ((CustomerInfoModelRealmProxyInterface) obj).realmSet$status((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'formTime'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.CustomerInfoModel copyOrUpdate(Realm realm, com.app.apsfl.models.CustomerInfoModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CustomerInfoModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.CustomerInfoModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.CustomerInfoModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CustomerInfoModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CustomerInfoModelRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.app.apsfl.models.CustomerInfoModel copy(Realm realm, com.app.apsfl.models.CustomerInfoModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CustomerInfoModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.CustomerInfoModel realmObject = realm.createObjectInternal(com.app.apsfl.models.CustomerInfoModel.class, ((CustomerInfoModelRealmProxyInterface) newObject).realmGet$formTime(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerAadhaarNumber(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerAadhaarNumber());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerTitle(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerTitle());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerFirstName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerFirstName());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerMiddleName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerMiddleName());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerLastName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerLastName());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerFatherName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerFatherName());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerDOB(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerDOB());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerGender(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerGender());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$contactPersonName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$contactPersonName());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerEmail(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerEmail());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$billFrequencyPosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$billFrequencyPosition());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$billCyclePosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$billCyclePosition());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$segmentPosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$segmentPosition());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$channelPosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$channelPosition());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerPAN(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerPAN());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerTAN(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerTAN());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$allPackagesSILMO(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$allPackagesSILMO());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$cafStatus(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$cafStatus());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$isDataFromAadhar(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$isDataFromAadhar());
            ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$status(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$status());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.CustomerInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerInfoModelColumnInfo columnInfo = (CustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$customerAadhaarNumber = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
        if (realmGet$customerAadhaarNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
        }
        Number realmGet$customerTitle = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTitle();
        if (realmGet$customerTitle != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.customerTitleIndex, rowIndex, realmGet$customerTitle.longValue(), false);
        }
        String realmGet$customerFirstName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFirstName();
        if (realmGet$customerFirstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerFirstNameIndex, rowIndex, realmGet$customerFirstName, false);
        }
        String realmGet$customerMiddleName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerMiddleName();
        if (realmGet$customerMiddleName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerMiddleNameIndex, rowIndex, realmGet$customerMiddleName, false);
        }
        String realmGet$customerLastName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerLastName();
        if (realmGet$customerLastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerLastNameIndex, rowIndex, realmGet$customerLastName, false);
        }
        String realmGet$customerFatherName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFatherName();
        if (realmGet$customerFatherName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerFatherNameIndex, rowIndex, realmGet$customerFatherName, false);
        }
        String realmGet$customerDOB = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerDOB();
        if (realmGet$customerDOB != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerDOBIndex, rowIndex, realmGet$customerDOB, false);
        }
        Number realmGet$customerGender = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerGender();
        if (realmGet$customerGender != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.customerGenderIndex, rowIndex, realmGet$customerGender.longValue(), false);
        }
        String realmGet$contactPersonName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$contactPersonName();
        if (realmGet$contactPersonName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
        }
        String realmGet$customerEmail = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerEmail();
        if (realmGet$customerEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerEmailIndex, rowIndex, realmGet$customerEmail, false);
        }
        Number realmGet$billFrequencyPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billFrequencyPosition();
        if (realmGet$billFrequencyPosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.billFrequencyPositionIndex, rowIndex, realmGet$billFrequencyPosition.longValue(), false);
        }
        Number realmGet$billCyclePosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billCyclePosition();
        if (realmGet$billCyclePosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.billCyclePositionIndex, rowIndex, realmGet$billCyclePosition.longValue(), false);
        }
        Number realmGet$segmentPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$segmentPosition();
        if (realmGet$segmentPosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.segmentPositionIndex, rowIndex, realmGet$segmentPosition.longValue(), false);
        }
        Number realmGet$channelPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$channelPosition();
        if (realmGet$channelPosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.channelPositionIndex, rowIndex, realmGet$channelPosition.longValue(), false);
        }
        String realmGet$customerPAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerPAN();
        if (realmGet$customerPAN != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerPANIndex, rowIndex, realmGet$customerPAN, false);
        }
        String realmGet$customerTAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTAN();
        if (realmGet$customerTAN != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerTANIndex, rowIndex, realmGet$customerTAN, false);
        }
        String realmGet$allPackagesSILMO = ((CustomerInfoModelRealmProxyInterface)object).realmGet$allPackagesSILMO();
        if (realmGet$allPackagesSILMO != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.allPackagesSILMOIndex, rowIndex, realmGet$allPackagesSILMO, false);
        }
        String realmGet$cafStatus = ((CustomerInfoModelRealmProxyInterface)object).realmGet$cafStatus();
        if (realmGet$cafStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isDataFromAadharIndex, rowIndex, ((CustomerInfoModelRealmProxyInterface)object).realmGet$isDataFromAadhar(), false);
        String realmGet$status = ((CustomerInfoModelRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerInfoModelColumnInfo columnInfo = (CustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CustomerInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CustomerInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$customerAadhaarNumber = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
                if (realmGet$customerAadhaarNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
                }
                Number realmGet$customerTitle = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTitle();
                if (realmGet$customerTitle != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.customerTitleIndex, rowIndex, realmGet$customerTitle.longValue(), false);
                }
                String realmGet$customerFirstName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFirstName();
                if (realmGet$customerFirstName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerFirstNameIndex, rowIndex, realmGet$customerFirstName, false);
                }
                String realmGet$customerMiddleName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerMiddleName();
                if (realmGet$customerMiddleName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerMiddleNameIndex, rowIndex, realmGet$customerMiddleName, false);
                }
                String realmGet$customerLastName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerLastName();
                if (realmGet$customerLastName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerLastNameIndex, rowIndex, realmGet$customerLastName, false);
                }
                String realmGet$customerFatherName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFatherName();
                if (realmGet$customerFatherName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerFatherNameIndex, rowIndex, realmGet$customerFatherName, false);
                }
                String realmGet$customerDOB = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerDOB();
                if (realmGet$customerDOB != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerDOBIndex, rowIndex, realmGet$customerDOB, false);
                }
                Number realmGet$customerGender = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerGender();
                if (realmGet$customerGender != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.customerGenderIndex, rowIndex, realmGet$customerGender.longValue(), false);
                }
                String realmGet$contactPersonName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$contactPersonName();
                if (realmGet$contactPersonName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
                }
                String realmGet$customerEmail = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerEmail();
                if (realmGet$customerEmail != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerEmailIndex, rowIndex, realmGet$customerEmail, false);
                }
                Number realmGet$billFrequencyPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billFrequencyPosition();
                if (realmGet$billFrequencyPosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.billFrequencyPositionIndex, rowIndex, realmGet$billFrequencyPosition.longValue(), false);
                }
                Number realmGet$billCyclePosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billCyclePosition();
                if (realmGet$billCyclePosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.billCyclePositionIndex, rowIndex, realmGet$billCyclePosition.longValue(), false);
                }
                Number realmGet$segmentPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$segmentPosition();
                if (realmGet$segmentPosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.segmentPositionIndex, rowIndex, realmGet$segmentPosition.longValue(), false);
                }
                Number realmGet$channelPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$channelPosition();
                if (realmGet$channelPosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.channelPositionIndex, rowIndex, realmGet$channelPosition.longValue(), false);
                }
                String realmGet$customerPAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerPAN();
                if (realmGet$customerPAN != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerPANIndex, rowIndex, realmGet$customerPAN, false);
                }
                String realmGet$customerTAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTAN();
                if (realmGet$customerTAN != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerTANIndex, rowIndex, realmGet$customerTAN, false);
                }
                String realmGet$allPackagesSILMO = ((CustomerInfoModelRealmProxyInterface)object).realmGet$allPackagesSILMO();
                if (realmGet$allPackagesSILMO != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.allPackagesSILMOIndex, rowIndex, realmGet$allPackagesSILMO, false);
                }
                String realmGet$cafStatus = ((CustomerInfoModelRealmProxyInterface)object).realmGet$cafStatus();
                if (realmGet$cafStatus != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isDataFromAadharIndex, rowIndex, ((CustomerInfoModelRealmProxyInterface)object).realmGet$isDataFromAadhar(), false);
                String realmGet$status = ((CustomerInfoModelRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.CustomerInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerInfoModelColumnInfo columnInfo = (CustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$customerAadhaarNumber = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
        if (realmGet$customerAadhaarNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, false);
        }
        Number realmGet$customerTitle = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTitle();
        if (realmGet$customerTitle != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.customerTitleIndex, rowIndex, realmGet$customerTitle.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerTitleIndex, rowIndex, false);
        }
        String realmGet$customerFirstName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFirstName();
        if (realmGet$customerFirstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerFirstNameIndex, rowIndex, realmGet$customerFirstName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerFirstNameIndex, rowIndex, false);
        }
        String realmGet$customerMiddleName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerMiddleName();
        if (realmGet$customerMiddleName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerMiddleNameIndex, rowIndex, realmGet$customerMiddleName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerMiddleNameIndex, rowIndex, false);
        }
        String realmGet$customerLastName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerLastName();
        if (realmGet$customerLastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerLastNameIndex, rowIndex, realmGet$customerLastName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerLastNameIndex, rowIndex, false);
        }
        String realmGet$customerFatherName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFatherName();
        if (realmGet$customerFatherName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerFatherNameIndex, rowIndex, realmGet$customerFatherName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerFatherNameIndex, rowIndex, false);
        }
        String realmGet$customerDOB = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerDOB();
        if (realmGet$customerDOB != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerDOBIndex, rowIndex, realmGet$customerDOB, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerDOBIndex, rowIndex, false);
        }
        Number realmGet$customerGender = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerGender();
        if (realmGet$customerGender != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.customerGenderIndex, rowIndex, realmGet$customerGender.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerGenderIndex, rowIndex, false);
        }
        String realmGet$contactPersonName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$contactPersonName();
        if (realmGet$contactPersonName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, false);
        }
        String realmGet$customerEmail = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerEmail();
        if (realmGet$customerEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerEmailIndex, rowIndex, realmGet$customerEmail, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerEmailIndex, rowIndex, false);
        }
        Number realmGet$billFrequencyPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billFrequencyPosition();
        if (realmGet$billFrequencyPosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.billFrequencyPositionIndex, rowIndex, realmGet$billFrequencyPosition.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.billFrequencyPositionIndex, rowIndex, false);
        }
        Number realmGet$billCyclePosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billCyclePosition();
        if (realmGet$billCyclePosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.billCyclePositionIndex, rowIndex, realmGet$billCyclePosition.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.billCyclePositionIndex, rowIndex, false);
        }
        Number realmGet$segmentPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$segmentPosition();
        if (realmGet$segmentPosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.segmentPositionIndex, rowIndex, realmGet$segmentPosition.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.segmentPositionIndex, rowIndex, false);
        }
        Number realmGet$channelPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$channelPosition();
        if (realmGet$channelPosition != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.channelPositionIndex, rowIndex, realmGet$channelPosition.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.channelPositionIndex, rowIndex, false);
        }
        String realmGet$customerPAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerPAN();
        if (realmGet$customerPAN != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerPANIndex, rowIndex, realmGet$customerPAN, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerPANIndex, rowIndex, false);
        }
        String realmGet$customerTAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTAN();
        if (realmGet$customerTAN != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerTANIndex, rowIndex, realmGet$customerTAN, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerTANIndex, rowIndex, false);
        }
        String realmGet$allPackagesSILMO = ((CustomerInfoModelRealmProxyInterface)object).realmGet$allPackagesSILMO();
        if (realmGet$allPackagesSILMO != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.allPackagesSILMOIndex, rowIndex, realmGet$allPackagesSILMO, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.allPackagesSILMOIndex, rowIndex, false);
        }
        String realmGet$cafStatus = ((CustomerInfoModelRealmProxyInterface)object).realmGet$cafStatus();
        if (realmGet$cafStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isDataFromAadharIndex, rowIndex, ((CustomerInfoModelRealmProxyInterface)object).realmGet$isDataFromAadhar(), false);
        String realmGet$status = ((CustomerInfoModelRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerInfoModelColumnInfo columnInfo = (CustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CustomerInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CustomerInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$customerAadhaarNumber = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
                if (realmGet$customerAadhaarNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, false);
                }
                Number realmGet$customerTitle = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTitle();
                if (realmGet$customerTitle != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.customerTitleIndex, rowIndex, realmGet$customerTitle.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerTitleIndex, rowIndex, false);
                }
                String realmGet$customerFirstName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFirstName();
                if (realmGet$customerFirstName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerFirstNameIndex, rowIndex, realmGet$customerFirstName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerFirstNameIndex, rowIndex, false);
                }
                String realmGet$customerMiddleName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerMiddleName();
                if (realmGet$customerMiddleName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerMiddleNameIndex, rowIndex, realmGet$customerMiddleName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerMiddleNameIndex, rowIndex, false);
                }
                String realmGet$customerLastName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerLastName();
                if (realmGet$customerLastName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerLastNameIndex, rowIndex, realmGet$customerLastName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerLastNameIndex, rowIndex, false);
                }
                String realmGet$customerFatherName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerFatherName();
                if (realmGet$customerFatherName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerFatherNameIndex, rowIndex, realmGet$customerFatherName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerFatherNameIndex, rowIndex, false);
                }
                String realmGet$customerDOB = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerDOB();
                if (realmGet$customerDOB != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerDOBIndex, rowIndex, realmGet$customerDOB, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerDOBIndex, rowIndex, false);
                }
                Number realmGet$customerGender = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerGender();
                if (realmGet$customerGender != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.customerGenderIndex, rowIndex, realmGet$customerGender.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerGenderIndex, rowIndex, false);
                }
                String realmGet$contactPersonName = ((CustomerInfoModelRealmProxyInterface)object).realmGet$contactPersonName();
                if (realmGet$contactPersonName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, false);
                }
                String realmGet$customerEmail = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerEmail();
                if (realmGet$customerEmail != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerEmailIndex, rowIndex, realmGet$customerEmail, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerEmailIndex, rowIndex, false);
                }
                Number realmGet$billFrequencyPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billFrequencyPosition();
                if (realmGet$billFrequencyPosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.billFrequencyPositionIndex, rowIndex, realmGet$billFrequencyPosition.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.billFrequencyPositionIndex, rowIndex, false);
                }
                Number realmGet$billCyclePosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$billCyclePosition();
                if (realmGet$billCyclePosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.billCyclePositionIndex, rowIndex, realmGet$billCyclePosition.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.billCyclePositionIndex, rowIndex, false);
                }
                Number realmGet$segmentPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$segmentPosition();
                if (realmGet$segmentPosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.segmentPositionIndex, rowIndex, realmGet$segmentPosition.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.segmentPositionIndex, rowIndex, false);
                }
                Number realmGet$channelPosition = ((CustomerInfoModelRealmProxyInterface)object).realmGet$channelPosition();
                if (realmGet$channelPosition != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.channelPositionIndex, rowIndex, realmGet$channelPosition.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.channelPositionIndex, rowIndex, false);
                }
                String realmGet$customerPAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerPAN();
                if (realmGet$customerPAN != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerPANIndex, rowIndex, realmGet$customerPAN, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerPANIndex, rowIndex, false);
                }
                String realmGet$customerTAN = ((CustomerInfoModelRealmProxyInterface)object).realmGet$customerTAN();
                if (realmGet$customerTAN != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerTANIndex, rowIndex, realmGet$customerTAN, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerTANIndex, rowIndex, false);
                }
                String realmGet$allPackagesSILMO = ((CustomerInfoModelRealmProxyInterface)object).realmGet$allPackagesSILMO();
                if (realmGet$allPackagesSILMO != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.allPackagesSILMOIndex, rowIndex, realmGet$allPackagesSILMO, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.allPackagesSILMOIndex, rowIndex, false);
                }
                String realmGet$cafStatus = ((CustomerInfoModelRealmProxyInterface)object).realmGet$cafStatus();
                if (realmGet$cafStatus != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isDataFromAadharIndex, rowIndex, ((CustomerInfoModelRealmProxyInterface)object).realmGet$isDataFromAadhar(), false);
                String realmGet$status = ((CustomerInfoModelRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.CustomerInfoModel createDetachedCopy(com.app.apsfl.models.CustomerInfoModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.CustomerInfoModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.CustomerInfoModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.CustomerInfoModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.CustomerInfoModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$formTime(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$formTime());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerAadhaarNumber(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerAadhaarNumber());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerTitle(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerTitle());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerFirstName(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerFirstName());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerMiddleName(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerMiddleName());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerLastName(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerLastName());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerFatherName(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerFatherName());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerDOB(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerDOB());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerGender(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerGender());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$contactPersonName(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$contactPersonName());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerEmail(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerEmail());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$billFrequencyPosition(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$billFrequencyPosition());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$billCyclePosition(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$billCyclePosition());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$segmentPosition(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$segmentPosition());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$channelPosition(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$channelPosition());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerPAN(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerPAN());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$customerTAN(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$customerTAN());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$allPackagesSILMO(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$allPackagesSILMO());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$cafStatus(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$cafStatus());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$isDataFromAadhar(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$isDataFromAadhar());
        ((CustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$status(((CustomerInfoModelRealmProxyInterface) realmObject).realmGet$status());
        return unmanagedObject;
    }

    static com.app.apsfl.models.CustomerInfoModel update(Realm realm, com.app.apsfl.models.CustomerInfoModel realmObject, com.app.apsfl.models.CustomerInfoModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerAadhaarNumber(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerAadhaarNumber());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerTitle(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerTitle());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerFirstName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerFirstName());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerMiddleName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerMiddleName());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerLastName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerLastName());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerFatherName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerFatherName());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerDOB(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerDOB());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerGender(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerGender());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$contactPersonName(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$contactPersonName());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerEmail(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerEmail());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$billFrequencyPosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$billFrequencyPosition());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$billCyclePosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$billCyclePosition());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$segmentPosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$segmentPosition());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$channelPosition(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$channelPosition());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerPAN(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerPAN());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$customerTAN(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$customerTAN());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$allPackagesSILMO(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$allPackagesSILMO());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$cafStatus(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$cafStatus());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$isDataFromAadhar(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$isDataFromAadhar());
        ((CustomerInfoModelRealmProxyInterface) realmObject).realmSet$status(((CustomerInfoModelRealmProxyInterface) newObject).realmGet$status());
        return realmObject;
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfoModelRealmProxy aCustomerInfoModel = (CustomerInfoModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCustomerInfoModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCustomerInfoModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCustomerInfoModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
