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

public class OfflineFormModelRealmProxy extends com.app.apsfl.models.OfflineFormModel
    implements RealmObjectProxy, OfflineFormModelRealmProxyInterface {

    static final class OfflineFormModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long formTimeIndex;
        public long enterpriseCustomerCodeIndex;
        public long cafOTPNumberIndex;
        public long formCAFDataIndex;
        public long formPaymentDataIndex;
        public long isPaymentDataAvailableIndex;
        public long isFormUploadedIndex;
        public long oltPortNumberIndex;
        public long l1PortNumberIndex;
        public long l2PortNumberIndex;
        public long l3PortNumberIndex;
        public long onuSerialNumberIndex;
        public long stbSerialNumberIndex;
        public long isCpeSerialNoUsedIndex;
        public long cafTypeIndex;
        public long cafStatusIndex;
        public long isNetworkAvailbleIndex;
        public long statusMessageIndex;

        OfflineFormModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(18);
            this.formTimeIndex = getValidColumnIndex(path, table, "OfflineFormModel", "formTime");
            indicesMap.put("formTime", this.formTimeIndex);
            this.enterpriseCustomerCodeIndex = getValidColumnIndex(path, table, "OfflineFormModel", "enterpriseCustomerCode");
            indicesMap.put("enterpriseCustomerCode", this.enterpriseCustomerCodeIndex);
            this.cafOTPNumberIndex = getValidColumnIndex(path, table, "OfflineFormModel", "cafOTPNumber");
            indicesMap.put("cafOTPNumber", this.cafOTPNumberIndex);
            this.formCAFDataIndex = getValidColumnIndex(path, table, "OfflineFormModel", "formCAFData");
            indicesMap.put("formCAFData", this.formCAFDataIndex);
            this.formPaymentDataIndex = getValidColumnIndex(path, table, "OfflineFormModel", "formPaymentData");
            indicesMap.put("formPaymentData", this.formPaymentDataIndex);
            this.isPaymentDataAvailableIndex = getValidColumnIndex(path, table, "OfflineFormModel", "isPaymentDataAvailable");
            indicesMap.put("isPaymentDataAvailable", this.isPaymentDataAvailableIndex);
            this.isFormUploadedIndex = getValidColumnIndex(path, table, "OfflineFormModel", "isFormUploaded");
            indicesMap.put("isFormUploaded", this.isFormUploadedIndex);
            this.oltPortNumberIndex = getValidColumnIndex(path, table, "OfflineFormModel", "oltPortNumber");
            indicesMap.put("oltPortNumber", this.oltPortNumberIndex);
            this.l1PortNumberIndex = getValidColumnIndex(path, table, "OfflineFormModel", "l1PortNumber");
            indicesMap.put("l1PortNumber", this.l1PortNumberIndex);
            this.l2PortNumberIndex = getValidColumnIndex(path, table, "OfflineFormModel", "l2PortNumber");
            indicesMap.put("l2PortNumber", this.l2PortNumberIndex);
            this.l3PortNumberIndex = getValidColumnIndex(path, table, "OfflineFormModel", "l3PortNumber");
            indicesMap.put("l3PortNumber", this.l3PortNumberIndex);
            this.onuSerialNumberIndex = getValidColumnIndex(path, table, "OfflineFormModel", "onuSerialNumber");
            indicesMap.put("onuSerialNumber", this.onuSerialNumberIndex);
            this.stbSerialNumberIndex = getValidColumnIndex(path, table, "OfflineFormModel", "stbSerialNumber");
            indicesMap.put("stbSerialNumber", this.stbSerialNumberIndex);
            this.isCpeSerialNoUsedIndex = getValidColumnIndex(path, table, "OfflineFormModel", "isCpeSerialNoUsed");
            indicesMap.put("isCpeSerialNoUsed", this.isCpeSerialNoUsedIndex);
            this.cafTypeIndex = getValidColumnIndex(path, table, "OfflineFormModel", "cafType");
            indicesMap.put("cafType", this.cafTypeIndex);
            this.cafStatusIndex = getValidColumnIndex(path, table, "OfflineFormModel", "cafStatus");
            indicesMap.put("cafStatus", this.cafStatusIndex);
            this.isNetworkAvailbleIndex = getValidColumnIndex(path, table, "OfflineFormModel", "isNetworkAvailble");
            indicesMap.put("isNetworkAvailble", this.isNetworkAvailbleIndex);
            this.statusMessageIndex = getValidColumnIndex(path, table, "OfflineFormModel", "statusMessage");
            indicesMap.put("statusMessage", this.statusMessageIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final OfflineFormModelColumnInfo otherInfo = (OfflineFormModelColumnInfo) other;
            this.formTimeIndex = otherInfo.formTimeIndex;
            this.enterpriseCustomerCodeIndex = otherInfo.enterpriseCustomerCodeIndex;
            this.cafOTPNumberIndex = otherInfo.cafOTPNumberIndex;
            this.formCAFDataIndex = otherInfo.formCAFDataIndex;
            this.formPaymentDataIndex = otherInfo.formPaymentDataIndex;
            this.isPaymentDataAvailableIndex = otherInfo.isPaymentDataAvailableIndex;
            this.isFormUploadedIndex = otherInfo.isFormUploadedIndex;
            this.oltPortNumberIndex = otherInfo.oltPortNumberIndex;
            this.l1PortNumberIndex = otherInfo.l1PortNumberIndex;
            this.l2PortNumberIndex = otherInfo.l2PortNumberIndex;
            this.l3PortNumberIndex = otherInfo.l3PortNumberIndex;
            this.onuSerialNumberIndex = otherInfo.onuSerialNumberIndex;
            this.stbSerialNumberIndex = otherInfo.stbSerialNumberIndex;
            this.isCpeSerialNoUsedIndex = otherInfo.isCpeSerialNoUsedIndex;
            this.cafTypeIndex = otherInfo.cafTypeIndex;
            this.cafStatusIndex = otherInfo.cafStatusIndex;
            this.isNetworkAvailbleIndex = otherInfo.isNetworkAvailbleIndex;
            this.statusMessageIndex = otherInfo.statusMessageIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final OfflineFormModelColumnInfo clone() {
            return (OfflineFormModelColumnInfo) super.clone();
        }

    }
    private OfflineFormModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("formTime");
        fieldNames.add("enterpriseCustomerCode");
        fieldNames.add("cafOTPNumber");
        fieldNames.add("formCAFData");
        fieldNames.add("formPaymentData");
        fieldNames.add("isPaymentDataAvailable");
        fieldNames.add("isFormUploaded");
        fieldNames.add("oltPortNumber");
        fieldNames.add("l1PortNumber");
        fieldNames.add("l2PortNumber");
        fieldNames.add("l3PortNumber");
        fieldNames.add("onuSerialNumber");
        fieldNames.add("stbSerialNumber");
        fieldNames.add("isCpeSerialNoUsed");
        fieldNames.add("cafType");
        fieldNames.add("cafStatus");
        fieldNames.add("isNetworkAvailble");
        fieldNames.add("statusMessage");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    OfflineFormModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OfflineFormModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.OfflineFormModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public long realmGet$formTime() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.formTimeIndex);
    }

    public void realmSet$formTime(long value) {
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
    public String realmGet$enterpriseCustomerCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.enterpriseCustomerCodeIndex);
    }

    public void realmSet$enterpriseCustomerCode(String value) {
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
                row.getTable().setNull(columnInfo.enterpriseCustomerCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.enterpriseCustomerCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.enterpriseCustomerCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.enterpriseCustomerCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cafOTPNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cafOTPNumberIndex);
    }

    public void realmSet$cafOTPNumber(String value) {
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
                row.getTable().setNull(columnInfo.cafOTPNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cafOTPNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cafOTPNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cafOTPNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$formCAFData() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.formCAFDataIndex);
    }

    public void realmSet$formCAFData(String value) {
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
                row.getTable().setNull(columnInfo.formCAFDataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.formCAFDataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.formCAFDataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.formCAFDataIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$formPaymentData() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.formPaymentDataIndex);
    }

    public void realmSet$formPaymentData(String value) {
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
                row.getTable().setNull(columnInfo.formPaymentDataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.formPaymentDataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.formPaymentDataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.formPaymentDataIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isPaymentDataAvailable() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isPaymentDataAvailableIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isPaymentDataAvailableIndex);
    }

    public void realmSet$isPaymentDataAvailable(Boolean value) {
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
                row.getTable().setNull(columnInfo.isPaymentDataAvailableIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isPaymentDataAvailableIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isPaymentDataAvailableIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isPaymentDataAvailableIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isFormUploaded() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isFormUploadedIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isFormUploadedIndex);
    }

    public void realmSet$isFormUploaded(Boolean value) {
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
                row.getTable().setNull(columnInfo.isFormUploadedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isFormUploadedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isFormUploadedIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isFormUploadedIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$oltPortNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.oltPortNumberIndex);
    }

    public void realmSet$oltPortNumber(String value) {
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
                row.getTable().setNull(columnInfo.oltPortNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.oltPortNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.oltPortNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.oltPortNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$l1PortNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.l1PortNumberIndex);
    }

    public void realmSet$l1PortNumber(String value) {
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
                row.getTable().setNull(columnInfo.l1PortNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.l1PortNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.l1PortNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.l1PortNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$l2PortNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.l2PortNumberIndex);
    }

    public void realmSet$l2PortNumber(String value) {
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
                row.getTable().setNull(columnInfo.l2PortNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.l2PortNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.l2PortNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.l2PortNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$l3PortNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.l3PortNumberIndex);
    }

    public void realmSet$l3PortNumber(String value) {
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
                row.getTable().setNull(columnInfo.l3PortNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.l3PortNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.l3PortNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.l3PortNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$onuSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuSerialNumberIndex);
    }

    public void realmSet$onuSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.onuSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$stbSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stbSerialNumberIndex);
    }

    public void realmSet$stbSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.stbSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stbSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stbSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stbSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isCpeSerialNoUsed() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isCpeSerialNoUsedIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isCpeSerialNoUsedIndex);
    }

    public void realmSet$isCpeSerialNoUsed(Boolean value) {
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
                row.getTable().setNull(columnInfo.isCpeSerialNoUsedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isCpeSerialNoUsedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isCpeSerialNoUsedIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isCpeSerialNoUsedIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cafType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cafTypeIndex);
    }

    public void realmSet$cafType(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cafTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cafTypeIndex, value);
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
    public Boolean realmGet$isNetworkAvailble() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isNetworkAvailbleIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isNetworkAvailbleIndex);
    }

    public void realmSet$isNetworkAvailble(Boolean value) {
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
                row.getTable().setNull(columnInfo.isNetworkAvailbleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isNetworkAvailbleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isNetworkAvailbleIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isNetworkAvailbleIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$statusMessage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusMessageIndex);
    }

    public void realmSet$statusMessage(String value) {
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
                row.getTable().setNull(columnInfo.statusMessageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusMessageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusMessageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusMessageIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("OfflineFormModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("OfflineFormModel");
            realmObjectSchema.add(new Property("formTime", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("enterpriseCustomerCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cafOTPNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("formCAFData", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("formPaymentData", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isPaymentDataAvailable", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isFormUploaded", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("oltPortNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("l1PortNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("l2PortNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("l3PortNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("onuSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("stbSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isCpeSerialNoUsed", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cafType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cafStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isNetworkAvailble", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("statusMessage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("OfflineFormModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_OfflineFormModel")) {
            Table table = sharedRealm.getTable("class_OfflineFormModel");
            table.addColumn(RealmFieldType.INTEGER, "formTime", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "enterpriseCustomerCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cafOTPNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "formCAFData", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "formPaymentData", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isPaymentDataAvailable", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isFormUploaded", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "oltPortNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "l1PortNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "l2PortNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "l3PortNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "stbSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isCpeSerialNoUsed", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cafType", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cafStatus", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isNetworkAvailble", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "statusMessage", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("formTime"));
            table.setPrimaryKey("formTime");
            return table;
        }
        return sharedRealm.getTable("class_OfflineFormModel");
    }

    public static OfflineFormModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_OfflineFormModel")) {
            Table table = sharedRealm.getTable("class_OfflineFormModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 18) {
                if (columnCount < 18) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 18 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 18 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 18 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 18; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final OfflineFormModelColumnInfo columnInfo = new OfflineFormModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("formTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'formTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("formTime") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'formTime' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.formTimeIndex) && table.findFirstNull(columnInfo.formTimeIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'formTime'. Either maintain the same type for primary key field 'formTime', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("formTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'formTime' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("formTime"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'formTime' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("enterpriseCustomerCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'enterpriseCustomerCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("enterpriseCustomerCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'enterpriseCustomerCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.enterpriseCustomerCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'enterpriseCustomerCode' is required. Either set @Required to field 'enterpriseCustomerCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cafOTPNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cafOTPNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cafOTPNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cafOTPNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cafOTPNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cafOTPNumber' is required. Either set @Required to field 'cafOTPNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("formCAFData")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'formCAFData' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("formCAFData") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'formCAFData' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.formCAFDataIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'formCAFData' is required. Either set @Required to field 'formCAFData' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("formPaymentData")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'formPaymentData' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("formPaymentData") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'formPaymentData' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.formPaymentDataIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'formPaymentData' is required. Either set @Required to field 'formPaymentData' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isPaymentDataAvailable")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isPaymentDataAvailable' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isPaymentDataAvailable") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isPaymentDataAvailable' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isPaymentDataAvailableIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isPaymentDataAvailable' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isPaymentDataAvailable' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isFormUploaded")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isFormUploaded' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isFormUploaded") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isFormUploaded' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isFormUploadedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isFormUploaded' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isFormUploaded' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("oltPortNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'oltPortNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("oltPortNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'oltPortNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.oltPortNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'oltPortNumber' is required. Either set @Required to field 'oltPortNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("l1PortNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'l1PortNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("l1PortNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'l1PortNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.l1PortNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'l1PortNumber' is required. Either set @Required to field 'l1PortNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("l2PortNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'l2PortNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("l2PortNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'l2PortNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.l2PortNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'l2PortNumber' is required. Either set @Required to field 'l2PortNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("l3PortNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'l3PortNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("l3PortNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'l3PortNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.l3PortNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'l3PortNumber' is required. Either set @Required to field 'l3PortNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuSerialNumber' is required. Either set @Required to field 'onuSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("stbSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stbSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("stbSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'stbSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.stbSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'stbSerialNumber' is required. Either set @Required to field 'stbSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isCpeSerialNoUsed")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isCpeSerialNoUsed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isCpeSerialNoUsed") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isCpeSerialNoUsed' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isCpeSerialNoUsedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isCpeSerialNoUsed' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isCpeSerialNoUsed' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cafType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cafType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cafType") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cafType' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cafTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cafType' does support null values in the existing Realm file. Use corresponding boxed type for field 'cafType' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("isNetworkAvailble")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isNetworkAvailble' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isNetworkAvailble") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isNetworkAvailble' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isNetworkAvailbleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isNetworkAvailble' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isNetworkAvailble' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("statusMessage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'statusMessage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("statusMessage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'statusMessage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.statusMessageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'statusMessage' is required. Either set @Required to field 'statusMessage' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'OfflineFormModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_OfflineFormModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.OfflineFormModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.OfflineFormModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.OfflineFormModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("formTime")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("formTime"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.OfflineFormModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.OfflineFormModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("formTime")) {
                if (json.isNull("formTime")) {
                    obj = (io.realm.OfflineFormModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.OfflineFormModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.OfflineFormModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.OfflineFormModel.class, json.getLong("formTime"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'formTime'.");
            }
        }
        if (json.has("enterpriseCustomerCode")) {
            if (json.isNull("enterpriseCustomerCode")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$enterpriseCustomerCode(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$enterpriseCustomerCode((String) json.getString("enterpriseCustomerCode"));
            }
        }
        if (json.has("cafOTPNumber")) {
            if (json.isNull("cafOTPNumber")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber((String) json.getString("cafOTPNumber"));
            }
        }
        if (json.has("formCAFData")) {
            if (json.isNull("formCAFData")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$formCAFData(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$formCAFData((String) json.getString("formCAFData"));
            }
        }
        if (json.has("formPaymentData")) {
            if (json.isNull("formPaymentData")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData((String) json.getString("formPaymentData"));
            }
        }
        if (json.has("isPaymentDataAvailable")) {
            if (json.isNull("isPaymentDataAvailable")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isPaymentDataAvailable(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isPaymentDataAvailable((boolean) json.getBoolean("isPaymentDataAvailable"));
            }
        }
        if (json.has("isFormUploaded")) {
            if (json.isNull("isFormUploaded")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded((boolean) json.getBoolean("isFormUploaded"));
            }
        }
        if (json.has("oltPortNumber")) {
            if (json.isNull("oltPortNumber")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$oltPortNumber(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$oltPortNumber((String) json.getString("oltPortNumber"));
            }
        }
        if (json.has("l1PortNumber")) {
            if (json.isNull("l1PortNumber")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$l1PortNumber(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$l1PortNumber((String) json.getString("l1PortNumber"));
            }
        }
        if (json.has("l2PortNumber")) {
            if (json.isNull("l2PortNumber")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$l2PortNumber(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$l2PortNumber((String) json.getString("l2PortNumber"));
            }
        }
        if (json.has("l3PortNumber")) {
            if (json.isNull("l3PortNumber")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$l3PortNumber(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$l3PortNumber((String) json.getString("l3PortNumber"));
            }
        }
        if (json.has("onuSerialNumber")) {
            if (json.isNull("onuSerialNumber")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$onuSerialNumber(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$onuSerialNumber((String) json.getString("onuSerialNumber"));
            }
        }
        if (json.has("stbSerialNumber")) {
            if (json.isNull("stbSerialNumber")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$stbSerialNumber(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$stbSerialNumber((String) json.getString("stbSerialNumber"));
            }
        }
        if (json.has("isCpeSerialNoUsed")) {
            if (json.isNull("isCpeSerialNoUsed")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isCpeSerialNoUsed(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isCpeSerialNoUsed((boolean) json.getBoolean("isCpeSerialNoUsed"));
            }
        }
        if (json.has("cafType")) {
            if (json.isNull("cafType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cafType' to null.");
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafType((int) json.getInt("cafType"));
            }
        }
        if (json.has("cafStatus")) {
            if (json.isNull("cafStatus")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafStatus(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafStatus((String) json.getString("cafStatus"));
            }
        }
        if (json.has("isNetworkAvailble")) {
            if (json.isNull("isNetworkAvailble")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble((boolean) json.getBoolean("isNetworkAvailble"));
            }
        }
        if (json.has("statusMessage")) {
            if (json.isNull("statusMessage")) {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage(null);
            } else {
                ((OfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage((String) json.getString("statusMessage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.OfflineFormModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.OfflineFormModel obj = new com.app.apsfl.models.OfflineFormModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("formTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'formTime' to null.");
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$formTime((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("enterpriseCustomerCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$enterpriseCustomerCode(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$enterpriseCustomerCode((String) reader.nextString());
                }
            } else if (name.equals("cafOTPNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber((String) reader.nextString());
                }
            } else if (name.equals("formCAFData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$formCAFData(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$formCAFData((String) reader.nextString());
                }
            } else if (name.equals("formPaymentData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData((String) reader.nextString());
                }
            } else if (name.equals("isPaymentDataAvailable")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isPaymentDataAvailable(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isPaymentDataAvailable((boolean) reader.nextBoolean());
                }
            } else if (name.equals("isFormUploaded")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded((boolean) reader.nextBoolean());
                }
            } else if (name.equals("oltPortNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$oltPortNumber(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$oltPortNumber((String) reader.nextString());
                }
            } else if (name.equals("l1PortNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$l1PortNumber(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$l1PortNumber((String) reader.nextString());
                }
            } else if (name.equals("l2PortNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$l2PortNumber(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$l2PortNumber((String) reader.nextString());
                }
            } else if (name.equals("l3PortNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$l3PortNumber(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$l3PortNumber((String) reader.nextString());
                }
            } else if (name.equals("onuSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$onuSerialNumber(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$onuSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("stbSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$stbSerialNumber(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$stbSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("isCpeSerialNoUsed")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isCpeSerialNoUsed(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isCpeSerialNoUsed((boolean) reader.nextBoolean());
                }
            } else if (name.equals("cafType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cafType' to null.");
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafType((int) reader.nextInt());
                }
            } else if (name.equals("cafStatus")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafStatus(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$cafStatus((String) reader.nextString());
                }
            } else if (name.equals("isNetworkAvailble")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble((boolean) reader.nextBoolean());
                }
            } else if (name.equals("statusMessage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage(null);
                } else {
                    ((OfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage((String) reader.nextString());
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

    public static com.app.apsfl.models.OfflineFormModel copyOrUpdate(Realm realm, com.app.apsfl.models.OfflineFormModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.OfflineFormModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.OfflineFormModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.OfflineFormModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.OfflineFormModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.OfflineFormModelRealmProxy();
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

    public static com.app.apsfl.models.OfflineFormModel copy(Realm realm, com.app.apsfl.models.OfflineFormModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.OfflineFormModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.OfflineFormModel realmObject = realm.createObjectInternal(com.app.apsfl.models.OfflineFormModel.class, ((OfflineFormModelRealmProxyInterface) newObject).realmGet$formTime(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$enterpriseCustomerCode(((OfflineFormModelRealmProxyInterface) newObject).realmGet$enterpriseCustomerCode());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$cafOTPNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$cafOTPNumber());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$formCAFData(((OfflineFormModelRealmProxyInterface) newObject).realmGet$formCAFData());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$formPaymentData(((OfflineFormModelRealmProxyInterface) newObject).realmGet$formPaymentData());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isPaymentDataAvailable(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isPaymentDataAvailable());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isFormUploaded(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isFormUploaded());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$oltPortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$oltPortNumber());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$l1PortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$l1PortNumber());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$l2PortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$l2PortNumber());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$l3PortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$l3PortNumber());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$onuSerialNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$onuSerialNumber());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$stbSerialNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$stbSerialNumber());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isCpeSerialNoUsed(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isCpeSerialNoUsed());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$cafType(((OfflineFormModelRealmProxyInterface) newObject).realmGet$cafType());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$cafStatus(((OfflineFormModelRealmProxyInterface) newObject).realmGet$cafStatus());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isNetworkAvailble(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isNetworkAvailble());
            ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$statusMessage(((OfflineFormModelRealmProxyInterface) newObject).realmGet$statusMessage());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.OfflineFormModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.OfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineFormModelColumnInfo columnInfo = (OfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((OfflineFormModelRealmProxyInterface) object).realmGet$formTime(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$enterpriseCustomerCode = ((OfflineFormModelRealmProxyInterface)object).realmGet$enterpriseCustomerCode();
        if (realmGet$enterpriseCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.enterpriseCustomerCodeIndex, rowIndex, realmGet$enterpriseCustomerCode, false);
        }
        String realmGet$cafOTPNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
        if (realmGet$cafOTPNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
        }
        String realmGet$formCAFData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formCAFData();
        if (realmGet$formCAFData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formCAFDataIndex, rowIndex, realmGet$formCAFData, false);
        }
        String realmGet$formPaymentData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
        if (realmGet$formPaymentData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
        }
        Boolean realmGet$isPaymentDataAvailable = ((OfflineFormModelRealmProxyInterface)object).realmGet$isPaymentDataAvailable();
        if (realmGet$isPaymentDataAvailable != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaymentDataAvailableIndex, rowIndex, realmGet$isPaymentDataAvailable, false);
        }
        Boolean realmGet$isFormUploaded = ((OfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
        if (realmGet$isFormUploaded != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
        }
        String realmGet$oltPortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$oltPortNumber();
        if (realmGet$oltPortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
        }
        String realmGet$l1PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l1PortNumber();
        if (realmGet$l1PortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumberIndex, rowIndex, realmGet$l1PortNumber, false);
        }
        String realmGet$l2PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l2PortNumber();
        if (realmGet$l2PortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumberIndex, rowIndex, realmGet$l2PortNumber, false);
        }
        String realmGet$l3PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l3PortNumber();
        if (realmGet$l3PortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumberIndex, rowIndex, realmGet$l3PortNumber, false);
        }
        String realmGet$onuSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$onuSerialNumber();
        if (realmGet$onuSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
        }
        String realmGet$stbSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$stbSerialNumber();
        if (realmGet$stbSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stbSerialNumberIndex, rowIndex, realmGet$stbSerialNumber, false);
        }
        Boolean realmGet$isCpeSerialNoUsed = ((OfflineFormModelRealmProxyInterface)object).realmGet$isCpeSerialNoUsed();
        if (realmGet$isCpeSerialNoUsed != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isCpeSerialNoUsedIndex, rowIndex, realmGet$isCpeSerialNoUsed, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cafTypeIndex, rowIndex, ((OfflineFormModelRealmProxyInterface)object).realmGet$cafType(), false);
        String realmGet$cafStatus = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafStatus();
        if (realmGet$cafStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
        }
        Boolean realmGet$isNetworkAvailble = ((OfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
        if (realmGet$isNetworkAvailble != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
        }
        String realmGet$statusMessage = ((OfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
        if (realmGet$statusMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.OfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineFormModelColumnInfo columnInfo = (OfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.OfflineFormModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.OfflineFormModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((OfflineFormModelRealmProxyInterface) object).realmGet$formTime(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$enterpriseCustomerCode = ((OfflineFormModelRealmProxyInterface)object).realmGet$enterpriseCustomerCode();
                if (realmGet$enterpriseCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.enterpriseCustomerCodeIndex, rowIndex, realmGet$enterpriseCustomerCode, false);
                }
                String realmGet$cafOTPNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
                if (realmGet$cafOTPNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
                }
                String realmGet$formCAFData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formCAFData();
                if (realmGet$formCAFData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formCAFDataIndex, rowIndex, realmGet$formCAFData, false);
                }
                String realmGet$formPaymentData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
                if (realmGet$formPaymentData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
                }
                Boolean realmGet$isPaymentDataAvailable = ((OfflineFormModelRealmProxyInterface)object).realmGet$isPaymentDataAvailable();
                if (realmGet$isPaymentDataAvailable != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaymentDataAvailableIndex, rowIndex, realmGet$isPaymentDataAvailable, false);
                }
                Boolean realmGet$isFormUploaded = ((OfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
                if (realmGet$isFormUploaded != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
                }
                String realmGet$oltPortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$oltPortNumber();
                if (realmGet$oltPortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
                }
                String realmGet$l1PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l1PortNumber();
                if (realmGet$l1PortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumberIndex, rowIndex, realmGet$l1PortNumber, false);
                }
                String realmGet$l2PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l2PortNumber();
                if (realmGet$l2PortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumberIndex, rowIndex, realmGet$l2PortNumber, false);
                }
                String realmGet$l3PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l3PortNumber();
                if (realmGet$l3PortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumberIndex, rowIndex, realmGet$l3PortNumber, false);
                }
                String realmGet$onuSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$onuSerialNumber();
                if (realmGet$onuSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
                }
                String realmGet$stbSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$stbSerialNumber();
                if (realmGet$stbSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stbSerialNumberIndex, rowIndex, realmGet$stbSerialNumber, false);
                }
                Boolean realmGet$isCpeSerialNoUsed = ((OfflineFormModelRealmProxyInterface)object).realmGet$isCpeSerialNoUsed();
                if (realmGet$isCpeSerialNoUsed != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isCpeSerialNoUsedIndex, rowIndex, realmGet$isCpeSerialNoUsed, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.cafTypeIndex, rowIndex, ((OfflineFormModelRealmProxyInterface)object).realmGet$cafType(), false);
                String realmGet$cafStatus = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafStatus();
                if (realmGet$cafStatus != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
                }
                Boolean realmGet$isNetworkAvailble = ((OfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
                if (realmGet$isNetworkAvailble != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
                }
                String realmGet$statusMessage = ((OfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
                if (realmGet$statusMessage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.OfflineFormModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.OfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineFormModelColumnInfo columnInfo = (OfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((OfflineFormModelRealmProxyInterface) object).realmGet$formTime(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$enterpriseCustomerCode = ((OfflineFormModelRealmProxyInterface)object).realmGet$enterpriseCustomerCode();
        if (realmGet$enterpriseCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.enterpriseCustomerCodeIndex, rowIndex, realmGet$enterpriseCustomerCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.enterpriseCustomerCodeIndex, rowIndex, false);
        }
        String realmGet$cafOTPNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
        if (realmGet$cafOTPNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, false);
        }
        String realmGet$formCAFData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formCAFData();
        if (realmGet$formCAFData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formCAFDataIndex, rowIndex, realmGet$formCAFData, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.formCAFDataIndex, rowIndex, false);
        }
        String realmGet$formPaymentData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
        if (realmGet$formPaymentData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, false);
        }
        Boolean realmGet$isPaymentDataAvailable = ((OfflineFormModelRealmProxyInterface)object).realmGet$isPaymentDataAvailable();
        if (realmGet$isPaymentDataAvailable != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaymentDataAvailableIndex, rowIndex, realmGet$isPaymentDataAvailable, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isPaymentDataAvailableIndex, rowIndex, false);
        }
        Boolean realmGet$isFormUploaded = ((OfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
        if (realmGet$isFormUploaded != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, false);
        }
        String realmGet$oltPortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$oltPortNumber();
        if (realmGet$oltPortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, false);
        }
        String realmGet$l1PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l1PortNumber();
        if (realmGet$l1PortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumberIndex, rowIndex, realmGet$l1PortNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.l1PortNumberIndex, rowIndex, false);
        }
        String realmGet$l2PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l2PortNumber();
        if (realmGet$l2PortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumberIndex, rowIndex, realmGet$l2PortNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.l2PortNumberIndex, rowIndex, false);
        }
        String realmGet$l3PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l3PortNumber();
        if (realmGet$l3PortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumberIndex, rowIndex, realmGet$l3PortNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.l3PortNumberIndex, rowIndex, false);
        }
        String realmGet$onuSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$onuSerialNumber();
        if (realmGet$onuSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, false);
        }
        String realmGet$stbSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$stbSerialNumber();
        if (realmGet$stbSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stbSerialNumberIndex, rowIndex, realmGet$stbSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stbSerialNumberIndex, rowIndex, false);
        }
        Boolean realmGet$isCpeSerialNoUsed = ((OfflineFormModelRealmProxyInterface)object).realmGet$isCpeSerialNoUsed();
        if (realmGet$isCpeSerialNoUsed != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isCpeSerialNoUsedIndex, rowIndex, realmGet$isCpeSerialNoUsed, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isCpeSerialNoUsedIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cafTypeIndex, rowIndex, ((OfflineFormModelRealmProxyInterface)object).realmGet$cafType(), false);
        String realmGet$cafStatus = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafStatus();
        if (realmGet$cafStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, false);
        }
        Boolean realmGet$isNetworkAvailble = ((OfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
        if (realmGet$isNetworkAvailble != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, false);
        }
        String realmGet$statusMessage = ((OfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
        if (realmGet$statusMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.OfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineFormModelColumnInfo columnInfo = (OfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.OfflineFormModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.OfflineFormModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OfflineFormModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((OfflineFormModelRealmProxyInterface) object).realmGet$formTime(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$enterpriseCustomerCode = ((OfflineFormModelRealmProxyInterface)object).realmGet$enterpriseCustomerCode();
                if (realmGet$enterpriseCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.enterpriseCustomerCodeIndex, rowIndex, realmGet$enterpriseCustomerCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.enterpriseCustomerCodeIndex, rowIndex, false);
                }
                String realmGet$cafOTPNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
                if (realmGet$cafOTPNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, false);
                }
                String realmGet$formCAFData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formCAFData();
                if (realmGet$formCAFData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formCAFDataIndex, rowIndex, realmGet$formCAFData, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.formCAFDataIndex, rowIndex, false);
                }
                String realmGet$formPaymentData = ((OfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
                if (realmGet$formPaymentData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, false);
                }
                Boolean realmGet$isPaymentDataAvailable = ((OfflineFormModelRealmProxyInterface)object).realmGet$isPaymentDataAvailable();
                if (realmGet$isPaymentDataAvailable != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaymentDataAvailableIndex, rowIndex, realmGet$isPaymentDataAvailable, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isPaymentDataAvailableIndex, rowIndex, false);
                }
                Boolean realmGet$isFormUploaded = ((OfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
                if (realmGet$isFormUploaded != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, false);
                }
                String realmGet$oltPortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$oltPortNumber();
                if (realmGet$oltPortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, false);
                }
                String realmGet$l1PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l1PortNumber();
                if (realmGet$l1PortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumberIndex, rowIndex, realmGet$l1PortNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.l1PortNumberIndex, rowIndex, false);
                }
                String realmGet$l2PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l2PortNumber();
                if (realmGet$l2PortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumberIndex, rowIndex, realmGet$l2PortNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.l2PortNumberIndex, rowIndex, false);
                }
                String realmGet$l3PortNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$l3PortNumber();
                if (realmGet$l3PortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumberIndex, rowIndex, realmGet$l3PortNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.l3PortNumberIndex, rowIndex, false);
                }
                String realmGet$onuSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$onuSerialNumber();
                if (realmGet$onuSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, false);
                }
                String realmGet$stbSerialNumber = ((OfflineFormModelRealmProxyInterface)object).realmGet$stbSerialNumber();
                if (realmGet$stbSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stbSerialNumberIndex, rowIndex, realmGet$stbSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stbSerialNumberIndex, rowIndex, false);
                }
                Boolean realmGet$isCpeSerialNoUsed = ((OfflineFormModelRealmProxyInterface)object).realmGet$isCpeSerialNoUsed();
                if (realmGet$isCpeSerialNoUsed != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isCpeSerialNoUsedIndex, rowIndex, realmGet$isCpeSerialNoUsed, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isCpeSerialNoUsedIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.cafTypeIndex, rowIndex, ((OfflineFormModelRealmProxyInterface)object).realmGet$cafType(), false);
                String realmGet$cafStatus = ((OfflineFormModelRealmProxyInterface)object).realmGet$cafStatus();
                if (realmGet$cafStatus != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, realmGet$cafStatus, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cafStatusIndex, rowIndex, false);
                }
                Boolean realmGet$isNetworkAvailble = ((OfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
                if (realmGet$isNetworkAvailble != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, false);
                }
                String realmGet$statusMessage = ((OfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
                if (realmGet$statusMessage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.OfflineFormModel createDetachedCopy(com.app.apsfl.models.OfflineFormModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.OfflineFormModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.OfflineFormModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.OfflineFormModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.OfflineFormModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$formTime(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$formTime());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$enterpriseCustomerCode(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$enterpriseCustomerCode());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$cafOTPNumber(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$cafOTPNumber());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$formCAFData(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$formCAFData());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$formPaymentData(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$formPaymentData());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$isPaymentDataAvailable(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$isPaymentDataAvailable());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$isFormUploaded(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$isFormUploaded());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$oltPortNumber(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$oltPortNumber());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$l1PortNumber(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$l1PortNumber());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$l2PortNumber(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$l2PortNumber());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$l3PortNumber(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$l3PortNumber());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$onuSerialNumber(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$onuSerialNumber());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$stbSerialNumber(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$stbSerialNumber());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$isCpeSerialNoUsed(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$isCpeSerialNoUsed());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$cafType(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$cafType());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$cafStatus(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$cafStatus());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$isNetworkAvailble(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$isNetworkAvailble());
        ((OfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$statusMessage(((OfflineFormModelRealmProxyInterface) realmObject).realmGet$statusMessage());
        return unmanagedObject;
    }

    static com.app.apsfl.models.OfflineFormModel update(Realm realm, com.app.apsfl.models.OfflineFormModel realmObject, com.app.apsfl.models.OfflineFormModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$enterpriseCustomerCode(((OfflineFormModelRealmProxyInterface) newObject).realmGet$enterpriseCustomerCode());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$cafOTPNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$cafOTPNumber());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$formCAFData(((OfflineFormModelRealmProxyInterface) newObject).realmGet$formCAFData());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$formPaymentData(((OfflineFormModelRealmProxyInterface) newObject).realmGet$formPaymentData());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isPaymentDataAvailable(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isPaymentDataAvailable());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isFormUploaded(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isFormUploaded());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$oltPortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$oltPortNumber());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$l1PortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$l1PortNumber());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$l2PortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$l2PortNumber());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$l3PortNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$l3PortNumber());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$onuSerialNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$onuSerialNumber());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$stbSerialNumber(((OfflineFormModelRealmProxyInterface) newObject).realmGet$stbSerialNumber());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isCpeSerialNoUsed(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isCpeSerialNoUsed());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$cafType(((OfflineFormModelRealmProxyInterface) newObject).realmGet$cafType());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$cafStatus(((OfflineFormModelRealmProxyInterface) newObject).realmGet$cafStatus());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$isNetworkAvailble(((OfflineFormModelRealmProxyInterface) newObject).realmGet$isNetworkAvailble());
        ((OfflineFormModelRealmProxyInterface) realmObject).realmSet$statusMessage(((OfflineFormModelRealmProxyInterface) newObject).realmGet$statusMessage());
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
        OfflineFormModelRealmProxy aOfflineFormModel = (OfflineFormModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aOfflineFormModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOfflineFormModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aOfflineFormModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
