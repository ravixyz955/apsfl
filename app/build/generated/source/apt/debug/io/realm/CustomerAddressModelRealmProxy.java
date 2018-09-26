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

public class CustomerAddressModelRealmProxy extends com.app.apsfl.models.CustomerAddressModel
    implements RealmObjectProxy, CustomerAddressModelRealmProxyInterface {

    static final class CustomerAddressModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long formTimeIndex;
        public long popIDIndex;
        public long popNameIndex;
        public long address1Index;
        public long address2Index;
        public long localityIndex;
        public long pinCodeIndex;
        public long mobileIndex;
        public long stdCodeIndex;
        public long landLineIndex;
        public long villageNameIndex;
        public long villageIDIndex;
        public long mandalNameIndex;
        public long mandalIDIndex;
        public long districtNameIndex;
        public long districtIDIndex;
        public long mobile1Index;
        public long isCustomerCheckedIndex;
        public long isLMOCheckedIndex;
        public long longitudeIndex;
        public long latitudeIndex;
        public long locationIndex;
        public long regionIndex;
        public long popDistrictIndex;
        public long popmandalIndex;
        public long popDistrictIdIndex;
        public long popMandalIdIndex;
        public long apsflUniqueIdIndex;
        public long SINameIndex;
        public long SIEmailIndex;
        public long SIPhnoIndex;
        public long entCustTypeIndex;
        public long entCustomerCodeIndex;
        public long cpeplaceIndex;
        public long statusIndex;
        public long customerAadhaarNumberIndex;

        CustomerAddressModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(36);
            this.formTimeIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "formTime");
            indicesMap.put("formTime", this.formTimeIndex);
            this.popIDIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "popID");
            indicesMap.put("popID", this.popIDIndex);
            this.popNameIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "popName");
            indicesMap.put("popName", this.popNameIndex);
            this.address1Index = getValidColumnIndex(path, table, "CustomerAddressModel", "address1");
            indicesMap.put("address1", this.address1Index);
            this.address2Index = getValidColumnIndex(path, table, "CustomerAddressModel", "address2");
            indicesMap.put("address2", this.address2Index);
            this.localityIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "locality");
            indicesMap.put("locality", this.localityIndex);
            this.pinCodeIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "pinCode");
            indicesMap.put("pinCode", this.pinCodeIndex);
            this.mobileIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "mobile");
            indicesMap.put("mobile", this.mobileIndex);
            this.stdCodeIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "stdCode");
            indicesMap.put("stdCode", this.stdCodeIndex);
            this.landLineIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "landLine");
            indicesMap.put("landLine", this.landLineIndex);
            this.villageNameIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "villageName");
            indicesMap.put("villageName", this.villageNameIndex);
            this.villageIDIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "villageID");
            indicesMap.put("villageID", this.villageIDIndex);
            this.mandalNameIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "mandalName");
            indicesMap.put("mandalName", this.mandalNameIndex);
            this.mandalIDIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "mandalID");
            indicesMap.put("mandalID", this.mandalIDIndex);
            this.districtNameIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "districtName");
            indicesMap.put("districtName", this.districtNameIndex);
            this.districtIDIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "districtID");
            indicesMap.put("districtID", this.districtIDIndex);
            this.mobile1Index = getValidColumnIndex(path, table, "CustomerAddressModel", "mobile1");
            indicesMap.put("mobile1", this.mobile1Index);
            this.isCustomerCheckedIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "isCustomerChecked");
            indicesMap.put("isCustomerChecked", this.isCustomerCheckedIndex);
            this.isLMOCheckedIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "isLMOChecked");
            indicesMap.put("isLMOChecked", this.isLMOCheckedIndex);
            this.longitudeIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "longitude");
            indicesMap.put("longitude", this.longitudeIndex);
            this.latitudeIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "latitude");
            indicesMap.put("latitude", this.latitudeIndex);
            this.locationIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "location");
            indicesMap.put("location", this.locationIndex);
            this.regionIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "region");
            indicesMap.put("region", this.regionIndex);
            this.popDistrictIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "popDistrict");
            indicesMap.put("popDistrict", this.popDistrictIndex);
            this.popmandalIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "popmandal");
            indicesMap.put("popmandal", this.popmandalIndex);
            this.popDistrictIdIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "popDistrictId");
            indicesMap.put("popDistrictId", this.popDistrictIdIndex);
            this.popMandalIdIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "popMandalId");
            indicesMap.put("popMandalId", this.popMandalIdIndex);
            this.apsflUniqueIdIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "apsflUniqueId");
            indicesMap.put("apsflUniqueId", this.apsflUniqueIdIndex);
            this.SINameIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "SIName");
            indicesMap.put("SIName", this.SINameIndex);
            this.SIEmailIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "SIEmail");
            indicesMap.put("SIEmail", this.SIEmailIndex);
            this.SIPhnoIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "SIPhno");
            indicesMap.put("SIPhno", this.SIPhnoIndex);
            this.entCustTypeIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "entCustType");
            indicesMap.put("entCustType", this.entCustTypeIndex);
            this.entCustomerCodeIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "entCustomerCode");
            indicesMap.put("entCustomerCode", this.entCustomerCodeIndex);
            this.cpeplaceIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "cpeplace");
            indicesMap.put("cpeplace", this.cpeplaceIndex);
            this.statusIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "status");
            indicesMap.put("status", this.statusIndex);
            this.customerAadhaarNumberIndex = getValidColumnIndex(path, table, "CustomerAddressModel", "customerAadhaarNumber");
            indicesMap.put("customerAadhaarNumber", this.customerAadhaarNumberIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CustomerAddressModelColumnInfo otherInfo = (CustomerAddressModelColumnInfo) other;
            this.formTimeIndex = otherInfo.formTimeIndex;
            this.popIDIndex = otherInfo.popIDIndex;
            this.popNameIndex = otherInfo.popNameIndex;
            this.address1Index = otherInfo.address1Index;
            this.address2Index = otherInfo.address2Index;
            this.localityIndex = otherInfo.localityIndex;
            this.pinCodeIndex = otherInfo.pinCodeIndex;
            this.mobileIndex = otherInfo.mobileIndex;
            this.stdCodeIndex = otherInfo.stdCodeIndex;
            this.landLineIndex = otherInfo.landLineIndex;
            this.villageNameIndex = otherInfo.villageNameIndex;
            this.villageIDIndex = otherInfo.villageIDIndex;
            this.mandalNameIndex = otherInfo.mandalNameIndex;
            this.mandalIDIndex = otherInfo.mandalIDIndex;
            this.districtNameIndex = otherInfo.districtNameIndex;
            this.districtIDIndex = otherInfo.districtIDIndex;
            this.mobile1Index = otherInfo.mobile1Index;
            this.isCustomerCheckedIndex = otherInfo.isCustomerCheckedIndex;
            this.isLMOCheckedIndex = otherInfo.isLMOCheckedIndex;
            this.longitudeIndex = otherInfo.longitudeIndex;
            this.latitudeIndex = otherInfo.latitudeIndex;
            this.locationIndex = otherInfo.locationIndex;
            this.regionIndex = otherInfo.regionIndex;
            this.popDistrictIndex = otherInfo.popDistrictIndex;
            this.popmandalIndex = otherInfo.popmandalIndex;
            this.popDistrictIdIndex = otherInfo.popDistrictIdIndex;
            this.popMandalIdIndex = otherInfo.popMandalIdIndex;
            this.apsflUniqueIdIndex = otherInfo.apsflUniqueIdIndex;
            this.SINameIndex = otherInfo.SINameIndex;
            this.SIEmailIndex = otherInfo.SIEmailIndex;
            this.SIPhnoIndex = otherInfo.SIPhnoIndex;
            this.entCustTypeIndex = otherInfo.entCustTypeIndex;
            this.entCustomerCodeIndex = otherInfo.entCustomerCodeIndex;
            this.cpeplaceIndex = otherInfo.cpeplaceIndex;
            this.statusIndex = otherInfo.statusIndex;
            this.customerAadhaarNumberIndex = otherInfo.customerAadhaarNumberIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CustomerAddressModelColumnInfo clone() {
            return (CustomerAddressModelColumnInfo) super.clone();
        }

    }
    private CustomerAddressModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("formTime");
        fieldNames.add("popID");
        fieldNames.add("popName");
        fieldNames.add("address1");
        fieldNames.add("address2");
        fieldNames.add("locality");
        fieldNames.add("pinCode");
        fieldNames.add("mobile");
        fieldNames.add("stdCode");
        fieldNames.add("landLine");
        fieldNames.add("villageName");
        fieldNames.add("villageID");
        fieldNames.add("mandalName");
        fieldNames.add("mandalID");
        fieldNames.add("districtName");
        fieldNames.add("districtID");
        fieldNames.add("mobile1");
        fieldNames.add("isCustomerChecked");
        fieldNames.add("isLMOChecked");
        fieldNames.add("longitude");
        fieldNames.add("latitude");
        fieldNames.add("location");
        fieldNames.add("region");
        fieldNames.add("popDistrict");
        fieldNames.add("popmandal");
        fieldNames.add("popDistrictId");
        fieldNames.add("popMandalId");
        fieldNames.add("apsflUniqueId");
        fieldNames.add("SIName");
        fieldNames.add("SIEmail");
        fieldNames.add("SIPhno");
        fieldNames.add("entCustType");
        fieldNames.add("entCustomerCode");
        fieldNames.add("cpeplace");
        fieldNames.add("status");
        fieldNames.add("customerAadhaarNumber");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CustomerAddressModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CustomerAddressModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.CustomerAddressModel.class, this);
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
    public String realmGet$popID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popIDIndex);
    }

    public void realmSet$popID(String value) {
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
                row.getTable().setNull(columnInfo.popIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popIDIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popNameIndex);
    }

    public void realmSet$popName(String value) {
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
                row.getTable().setNull(columnInfo.popNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$address1() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.address1Index);
    }

    public void realmSet$address1(String value) {
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
                row.getTable().setNull(columnInfo.address1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.address1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.address1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.address1Index, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$address2() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.address2Index);
    }

    public void realmSet$address2(String value) {
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
                row.getTable().setNull(columnInfo.address2Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.address2Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.address2Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.address2Index, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$locality() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.localityIndex);
    }

    public void realmSet$locality(String value) {
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
                row.getTable().setNull(columnInfo.localityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.localityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.localityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.localityIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$pinCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pinCodeIndex);
    }

    public void realmSet$pinCode(String value) {
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
                row.getTable().setNull(columnInfo.pinCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pinCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pinCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pinCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$mobile() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mobileIndex);
    }

    public void realmSet$mobile(String value) {
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
                row.getTable().setNull(columnInfo.mobileIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mobileIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mobileIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mobileIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$stdCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stdCodeIndex);
    }

    public void realmSet$stdCode(String value) {
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
                row.getTable().setNull(columnInfo.stdCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stdCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stdCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stdCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$landLine() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.landLineIndex);
    }

    public void realmSet$landLine(String value) {
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
                row.getTable().setNull(columnInfo.landLineIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.landLineIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.landLineIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.landLineIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$villageName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.villageNameIndex);
    }

    public void realmSet$villageName(String value) {
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
                row.getTable().setNull(columnInfo.villageNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.villageNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.villageNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.villageNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$villageID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.villageIDIndex);
    }

    public void realmSet$villageID(String value) {
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
                row.getTable().setNull(columnInfo.villageIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.villageIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.villageIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.villageIDIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$mandalName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mandalNameIndex);
    }

    public void realmSet$mandalName(String value) {
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
                row.getTable().setNull(columnInfo.mandalNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mandalNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mandalNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mandalNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$mandalID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mandalIDIndex);
    }

    public void realmSet$mandalID(String value) {
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
                row.getTable().setNull(columnInfo.mandalIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mandalIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mandalIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mandalIDIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$districtName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.districtNameIndex);
    }

    public void realmSet$districtName(String value) {
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
                row.getTable().setNull(columnInfo.districtNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.districtNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.districtNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.districtNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$districtID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.districtIDIndex);
    }

    public void realmSet$districtID(String value) {
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
                row.getTable().setNull(columnInfo.districtIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.districtIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.districtIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.districtIDIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$mobile1() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mobile1Index);
    }

    public void realmSet$mobile1(String value) {
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
                row.getTable().setNull(columnInfo.mobile1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mobile1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mobile1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mobile1Index, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isCustomerChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isCustomerCheckedIndex);
    }

    public void realmSet$isCustomerChecked(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isCustomerCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isCustomerCheckedIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isLMOChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isLMOCheckedIndex);
    }

    public void realmSet$isLMOChecked(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isLMOCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isLMOCheckedIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$longitude() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.longitudeIndex);
    }

    public void realmSet$longitude(String value) {
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
                row.getTable().setNull(columnInfo.longitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.longitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.longitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.longitudeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$latitude() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.latitudeIndex);
    }

    public void realmSet$latitude(String value) {
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
                row.getTable().setNull(columnInfo.latitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.latitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.latitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.latitudeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$location() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.locationIndex);
    }

    public void realmSet$location(String value) {
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
                row.getTable().setNull(columnInfo.locationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.locationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.locationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.locationIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$region() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.regionIndex);
    }

    public void realmSet$region(String value) {
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
                row.getTable().setNull(columnInfo.regionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.regionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.regionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.regionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popDistrict() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popDistrictIndex);
    }

    public void realmSet$popDistrict(String value) {
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
                row.getTable().setNull(columnInfo.popDistrictIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popDistrictIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popDistrictIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popDistrictIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popmandal() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popmandalIndex);
    }

    public void realmSet$popmandal(String value) {
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
                row.getTable().setNull(columnInfo.popmandalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popmandalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popmandalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popmandalIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popDistrictId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popDistrictIdIndex);
    }

    public void realmSet$popDistrictId(String value) {
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
                row.getTable().setNull(columnInfo.popDistrictIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popDistrictIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popDistrictIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popDistrictIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popMandalId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popMandalIdIndex);
    }

    public void realmSet$popMandalId(String value) {
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
                row.getTable().setNull(columnInfo.popMandalIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popMandalIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popMandalIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popMandalIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$apsflUniqueId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.apsflUniqueIdIndex);
    }

    public void realmSet$apsflUniqueId(String value) {
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
                row.getTable().setNull(columnInfo.apsflUniqueIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.apsflUniqueIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.apsflUniqueIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.apsflUniqueIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$SIName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.SINameIndex);
    }

    public void realmSet$SIName(String value) {
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
                row.getTable().setNull(columnInfo.SINameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.SINameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.SINameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.SINameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$SIEmail() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.SIEmailIndex);
    }

    public void realmSet$SIEmail(String value) {
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
                row.getTable().setNull(columnInfo.SIEmailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.SIEmailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.SIEmailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.SIEmailIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$SIPhno() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.SIPhnoIndex);
    }

    public void realmSet$SIPhno(String value) {
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
                row.getTable().setNull(columnInfo.SIPhnoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.SIPhnoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.SIPhnoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.SIPhnoIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$entCustType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.entCustTypeIndex);
    }

    public void realmSet$entCustType(String value) {
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
                row.getTable().setNull(columnInfo.entCustTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.entCustTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.entCustTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.entCustTypeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$entCustomerCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.entCustomerCodeIndex);
    }

    public void realmSet$entCustomerCode(String value) {
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
                row.getTable().setNull(columnInfo.entCustomerCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.entCustomerCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.entCustomerCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.entCustomerCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeplace() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeplaceIndex);
    }

    public void realmSet$cpeplace(String value) {
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
                row.getTable().setNull(columnInfo.cpeplaceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeplaceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeplaceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeplaceIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CustomerAddressModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CustomerAddressModel");
            realmObjectSchema.add(new Property("formTime", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("address1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("address2", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("locality", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("pinCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mobile", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("stdCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("landLine", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("villageName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("villageID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("districtName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("districtID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mobile1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isCustomerChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("isLMOChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("longitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("latitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("location", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("region", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popDistrict", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popmandal", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popDistrictId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popMandalId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("apsflUniqueId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("SIName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("SIEmail", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("SIPhno", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("entCustType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("entCustomerCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeplace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerAadhaarNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CustomerAddressModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CustomerAddressModel")) {
            Table table = sharedRealm.getTable("class_CustomerAddressModel");
            table.addColumn(RealmFieldType.INTEGER, "formTime", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "address1", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "address2", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "locality", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "pinCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mobile", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "stdCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "landLine", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "villageName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "villageID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mandalName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mandalID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "districtName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "districtID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mobile1", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isCustomerChecked", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isLMOChecked", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "longitude", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "latitude", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "location", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "region", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popDistrict", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popmandal", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popDistrictId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popMandalId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "apsflUniqueId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "SIName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "SIEmail", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "SIPhno", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "entCustType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "entCustomerCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeplace", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "status", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerAadhaarNumber", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("formTime"));
            table.setPrimaryKey("formTime");
            return table;
        }
        return sharedRealm.getTable("class_CustomerAddressModel");
    }

    public static CustomerAddressModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CustomerAddressModel")) {
            Table table = sharedRealm.getTable("class_CustomerAddressModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 36) {
                if (columnCount < 36) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 36 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 36 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 36 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 36; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CustomerAddressModelColumnInfo columnInfo = new CustomerAddressModelColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("popID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popID' is required. Either set @Required to field 'popID' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popName' is required. Either set @Required to field 'popName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("address1")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'address1' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("address1") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'address1' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.address1Index)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'address1' is required. Either set @Required to field 'address1' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("address2")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'address2' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("address2") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'address2' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.address2Index)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'address2' is required. Either set @Required to field 'address2' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("locality")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'locality' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("locality") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'locality' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.localityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'locality' is required. Either set @Required to field 'locality' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("pinCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pinCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("pinCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'pinCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.pinCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'pinCode' is required. Either set @Required to field 'pinCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("mobile")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mobile' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mobile") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mobile' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.mobileIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mobile' is required. Either set @Required to field 'mobile' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("stdCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stdCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("stdCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'stdCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.stdCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'stdCode' is required. Either set @Required to field 'stdCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("landLine")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'landLine' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("landLine") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'landLine' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.landLineIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'landLine' is required. Either set @Required to field 'landLine' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("villageName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'villageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("villageName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'villageName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.villageNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'villageName' is required. Either set @Required to field 'villageName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("villageID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'villageID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("villageID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'villageID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.villageIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'villageID' is required. Either set @Required to field 'villageID' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("mandalName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mandalName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mandalName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mandalName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.mandalNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mandalName' is required. Either set @Required to field 'mandalName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("mandalID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mandalID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mandalID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mandalID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.mandalIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mandalID' is required. Either set @Required to field 'mandalID' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("districtName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtName' is required. Either set @Required to field 'districtName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("districtID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtID' is required. Either set @Required to field 'districtID' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("mobile1")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mobile1' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mobile1") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mobile1' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.mobile1Index)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mobile1' is required. Either set @Required to field 'mobile1' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isCustomerChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isCustomerChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isCustomerChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isCustomerChecked' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isCustomerCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isCustomerChecked' does support null values in the existing Realm file. Use corresponding boxed type for field 'isCustomerChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isLMOChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isLMOChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isLMOChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isLMOChecked' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isLMOCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isLMOChecked' does support null values in the existing Realm file. Use corresponding boxed type for field 'isLMOChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("longitude")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'longitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("longitude") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'longitude' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.longitudeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'longitude' is required. Either set @Required to field 'longitude' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("latitude")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'latitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("latitude") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'latitude' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.latitudeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'latitude' is required. Either set @Required to field 'latitude' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("location")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'location' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("location") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'location' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.locationIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'location' is required. Either set @Required to field 'location' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("region")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'region' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("region") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'region' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.regionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'region' is required. Either set @Required to field 'region' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popDistrict")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popDistrict' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popDistrict") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popDistrict' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popDistrictIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popDistrict' is required. Either set @Required to field 'popDistrict' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popmandal")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popmandal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popmandal") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popmandal' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popmandalIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popmandal' is required. Either set @Required to field 'popmandal' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popDistrictId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popDistrictId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popDistrictId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popDistrictId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popDistrictIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popDistrictId' is required. Either set @Required to field 'popDistrictId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popMandalId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popMandalId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popMandalId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popMandalId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popMandalIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popMandalId' is required. Either set @Required to field 'popMandalId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("apsflUniqueId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'apsflUniqueId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("apsflUniqueId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'apsflUniqueId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.apsflUniqueIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'apsflUniqueId' is required. Either set @Required to field 'apsflUniqueId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("SIName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'SIName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("SIName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'SIName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.SINameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'SIName' is required. Either set @Required to field 'SIName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("SIEmail")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'SIEmail' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("SIEmail") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'SIEmail' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.SIEmailIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'SIEmail' is required. Either set @Required to field 'SIEmail' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("SIPhno")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'SIPhno' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("SIPhno") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'SIPhno' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.SIPhnoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'SIPhno' is required. Either set @Required to field 'SIPhno' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("entCustType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'entCustType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("entCustType") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'entCustType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.entCustTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'entCustType' is required. Either set @Required to field 'entCustType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("entCustomerCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'entCustomerCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("entCustomerCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'entCustomerCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.entCustomerCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'entCustomerCode' is required. Either set @Required to field 'entCustomerCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeplace")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeplace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeplace") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeplace' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeplaceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeplace' is required. Either set @Required to field 'cpeplace' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("customerAadhaarNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerAadhaarNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerAadhaarNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerAadhaarNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerAadhaarNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerAadhaarNumber' is required. Either set @Required to field 'customerAadhaarNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CustomerAddressModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CustomerAddressModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.CustomerAddressModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.CustomerAddressModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.CustomerAddressModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CustomerAddressModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CustomerAddressModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("formTime")) {
                if (json.isNull("formTime")) {
                    obj = (io.realm.CustomerAddressModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CustomerAddressModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CustomerAddressModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CustomerAddressModel.class, json.getLong("formTime"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'formTime'.");
            }
        }
        if (json.has("popID")) {
            if (json.isNull("popID")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popID(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popID((String) json.getString("popID"));
            }
        }
        if (json.has("popName")) {
            if (json.isNull("popName")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popName(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popName((String) json.getString("popName"));
            }
        }
        if (json.has("address1")) {
            if (json.isNull("address1")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address1(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address1((String) json.getString("address1"));
            }
        }
        if (json.has("address2")) {
            if (json.isNull("address2")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address2(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address2((String) json.getString("address2"));
            }
        }
        if (json.has("locality")) {
            if (json.isNull("locality")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$locality(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$locality((String) json.getString("locality"));
            }
        }
        if (json.has("pinCode")) {
            if (json.isNull("pinCode")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$pinCode(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$pinCode((String) json.getString("pinCode"));
            }
        }
        if (json.has("mobile")) {
            if (json.isNull("mobile")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile((String) json.getString("mobile"));
            }
        }
        if (json.has("stdCode")) {
            if (json.isNull("stdCode")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$stdCode(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$stdCode((String) json.getString("stdCode"));
            }
        }
        if (json.has("landLine")) {
            if (json.isNull("landLine")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$landLine(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$landLine((String) json.getString("landLine"));
            }
        }
        if (json.has("villageName")) {
            if (json.isNull("villageName")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageName(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageName((String) json.getString("villageName"));
            }
        }
        if (json.has("villageID")) {
            if (json.isNull("villageID")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageID(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageID((String) json.getString("villageID"));
            }
        }
        if (json.has("mandalName")) {
            if (json.isNull("mandalName")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalName(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalName((String) json.getString("mandalName"));
            }
        }
        if (json.has("mandalID")) {
            if (json.isNull("mandalID")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalID(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalID((String) json.getString("mandalID"));
            }
        }
        if (json.has("districtName")) {
            if (json.isNull("districtName")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtName(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtName((String) json.getString("districtName"));
            }
        }
        if (json.has("districtID")) {
            if (json.isNull("districtID")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtID(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtID((String) json.getString("districtID"));
            }
        }
        if (json.has("mobile1")) {
            if (json.isNull("mobile1")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile1(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile1((String) json.getString("mobile1"));
            }
        }
        if (json.has("isCustomerChecked")) {
            if (json.isNull("isCustomerChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isCustomerChecked' to null.");
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$isCustomerChecked((boolean) json.getBoolean("isCustomerChecked"));
            }
        }
        if (json.has("isLMOChecked")) {
            if (json.isNull("isLMOChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isLMOChecked' to null.");
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$isLMOChecked((boolean) json.getBoolean("isLMOChecked"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$longitude(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$longitude((String) json.getString("longitude"));
            }
        }
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$latitude(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$latitude((String) json.getString("latitude"));
            }
        }
        if (json.has("location")) {
            if (json.isNull("location")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$location(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$location((String) json.getString("location"));
            }
        }
        if (json.has("region")) {
            if (json.isNull("region")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$region(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$region((String) json.getString("region"));
            }
        }
        if (json.has("popDistrict")) {
            if (json.isNull("popDistrict")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrict(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrict((String) json.getString("popDistrict"));
            }
        }
        if (json.has("popmandal")) {
            if (json.isNull("popmandal")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popmandal(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popmandal((String) json.getString("popmandal"));
            }
        }
        if (json.has("popDistrictId")) {
            if (json.isNull("popDistrictId")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrictId(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrictId((String) json.getString("popDistrictId"));
            }
        }
        if (json.has("popMandalId")) {
            if (json.isNull("popMandalId")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popMandalId(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popMandalId((String) json.getString("popMandalId"));
            }
        }
        if (json.has("apsflUniqueId")) {
            if (json.isNull("apsflUniqueId")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$apsflUniqueId(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$apsflUniqueId((String) json.getString("apsflUniqueId"));
            }
        }
        if (json.has("SIName")) {
            if (json.isNull("SIName")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIName(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIName((String) json.getString("SIName"));
            }
        }
        if (json.has("SIEmail")) {
            if (json.isNull("SIEmail")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIEmail(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIEmail((String) json.getString("SIEmail"));
            }
        }
        if (json.has("SIPhno")) {
            if (json.isNull("SIPhno")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIPhno(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIPhno((String) json.getString("SIPhno"));
            }
        }
        if (json.has("entCustType")) {
            if (json.isNull("entCustType")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustType(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustType((String) json.getString("entCustType"));
            }
        }
        if (json.has("entCustomerCode")) {
            if (json.isNull("entCustomerCode")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustomerCode(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustomerCode((String) json.getString("entCustomerCode"));
            }
        }
        if (json.has("cpeplace")) {
            if (json.isNull("cpeplace")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$cpeplace(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$cpeplace((String) json.getString("cpeplace"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$status(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("customerAadhaarNumber")) {
            if (json.isNull("customerAadhaarNumber")) {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber(null);
            } else {
                ((CustomerAddressModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber((String) json.getString("customerAadhaarNumber"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.CustomerAddressModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.CustomerAddressModel obj = new com.app.apsfl.models.CustomerAddressModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("formTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$formTime(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$formTime((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("popID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popID(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popID((String) reader.nextString());
                }
            } else if (name.equals("popName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popName(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popName((String) reader.nextString());
                }
            } else if (name.equals("address1")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address1(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address1((String) reader.nextString());
                }
            } else if (name.equals("address2")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address2(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$address2((String) reader.nextString());
                }
            } else if (name.equals("locality")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$locality(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$locality((String) reader.nextString());
                }
            } else if (name.equals("pinCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$pinCode(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$pinCode((String) reader.nextString());
                }
            } else if (name.equals("mobile")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile((String) reader.nextString());
                }
            } else if (name.equals("stdCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$stdCode(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$stdCode((String) reader.nextString());
                }
            } else if (name.equals("landLine")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$landLine(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$landLine((String) reader.nextString());
                }
            } else if (name.equals("villageName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageName(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageName((String) reader.nextString());
                }
            } else if (name.equals("villageID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageID(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$villageID((String) reader.nextString());
                }
            } else if (name.equals("mandalName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalName(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalName((String) reader.nextString());
                }
            } else if (name.equals("mandalID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalID(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mandalID((String) reader.nextString());
                }
            } else if (name.equals("districtName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtName(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtName((String) reader.nextString());
                }
            } else if (name.equals("districtID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtID(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$districtID((String) reader.nextString());
                }
            } else if (name.equals("mobile1")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile1(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$mobile1((String) reader.nextString());
                }
            } else if (name.equals("isCustomerChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isCustomerChecked' to null.");
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$isCustomerChecked((boolean) reader.nextBoolean());
                }
            } else if (name.equals("isLMOChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isLMOChecked' to null.");
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$isLMOChecked((boolean) reader.nextBoolean());
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$longitude(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$longitude((String) reader.nextString());
                }
            } else if (name.equals("latitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$latitude(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$latitude((String) reader.nextString());
                }
            } else if (name.equals("location")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$location(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$location((String) reader.nextString());
                }
            } else if (name.equals("region")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$region(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$region((String) reader.nextString());
                }
            } else if (name.equals("popDistrict")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrict(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrict((String) reader.nextString());
                }
            } else if (name.equals("popmandal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popmandal(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popmandal((String) reader.nextString());
                }
            } else if (name.equals("popDistrictId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrictId(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popDistrictId((String) reader.nextString());
                }
            } else if (name.equals("popMandalId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popMandalId(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$popMandalId((String) reader.nextString());
                }
            } else if (name.equals("apsflUniqueId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$apsflUniqueId(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$apsflUniqueId((String) reader.nextString());
                }
            } else if (name.equals("SIName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIName(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIName((String) reader.nextString());
                }
            } else if (name.equals("SIEmail")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIEmail(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIEmail((String) reader.nextString());
                }
            } else if (name.equals("SIPhno")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIPhno(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$SIPhno((String) reader.nextString());
                }
            } else if (name.equals("entCustType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustType(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustType((String) reader.nextString());
                }
            } else if (name.equals("entCustomerCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustomerCode(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$entCustomerCode((String) reader.nextString());
                }
            } else if (name.equals("cpeplace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$cpeplace(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$cpeplace((String) reader.nextString());
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$status(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$status((String) reader.nextString());
                }
            } else if (name.equals("customerAadhaarNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber(null);
                } else {
                    ((CustomerAddressModelRealmProxyInterface) obj).realmSet$customerAadhaarNumber((String) reader.nextString());
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

    public static com.app.apsfl.models.CustomerAddressModel copyOrUpdate(Realm realm, com.app.apsfl.models.CustomerAddressModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CustomerAddressModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.CustomerAddressModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.CustomerAddressModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CustomerAddressModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CustomerAddressModelRealmProxy();
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

    public static com.app.apsfl.models.CustomerAddressModel copy(Realm realm, com.app.apsfl.models.CustomerAddressModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CustomerAddressModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.CustomerAddressModel realmObject = realm.createObjectInternal(com.app.apsfl.models.CustomerAddressModel.class, ((CustomerAddressModelRealmProxyInterface) newObject).realmGet$formTime(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popID());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popName());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$address1(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$address1());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$address2(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$address2());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$locality(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$locality());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$pinCode(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$pinCode());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mobile(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mobile());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$stdCode(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$stdCode());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$landLine(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$landLine());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$villageName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$villageName());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$villageID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$villageID());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mandalName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mandalName());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mandalID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mandalID());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$districtName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$districtName());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$districtID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$districtID());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mobile1(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mobile1());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$isCustomerChecked(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$isCustomerChecked());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$isLMOChecked(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$isLMOChecked());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$longitude(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$longitude());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$latitude(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$latitude());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$location(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$location());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$region(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$region());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popDistrict(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popDistrict());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popmandal(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popmandal());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popDistrictId(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popDistrictId());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popMandalId(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popMandalId());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$apsflUniqueId(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$apsflUniqueId());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$SIName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$SIName());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$SIEmail(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$SIEmail());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$SIPhno(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$SIPhno());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$entCustType(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$entCustType());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$entCustomerCode(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$entCustomerCode());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$cpeplace(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$cpeplace());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$status(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$status());
            ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$customerAadhaarNumber(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$customerAadhaarNumber());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.CustomerAddressModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CustomerAddressModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerAddressModelColumnInfo columnInfo = (CustomerAddressModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerAddressModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$popID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popID();
        if (realmGet$popID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
        }
        String realmGet$popName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popName();
        if (realmGet$popName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
        }
        String realmGet$address1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address1();
        if (realmGet$address1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
        }
        String realmGet$address2 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address2();
        if (realmGet$address2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
        }
        String realmGet$locality = ((CustomerAddressModelRealmProxyInterface)object).realmGet$locality();
        if (realmGet$locality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
        }
        String realmGet$pinCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$pinCode();
        if (realmGet$pinCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
        }
        String realmGet$mobile = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
        }
        String realmGet$stdCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$stdCode();
        if (realmGet$stdCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
        }
        String realmGet$landLine = ((CustomerAddressModelRealmProxyInterface)object).realmGet$landLine();
        if (realmGet$landLine != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.landLineIndex, rowIndex, realmGet$landLine, false);
        }
        String realmGet$villageName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageName();
        if (realmGet$villageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
        }
        String realmGet$villageID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageID();
        if (realmGet$villageID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageIDIndex, rowIndex, realmGet$villageID, false);
        }
        String realmGet$mandalName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalName();
        if (realmGet$mandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
        }
        String realmGet$mandalID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalID();
        if (realmGet$mandalID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
        }
        String realmGet$districtName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtName();
        if (realmGet$districtName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
        }
        String realmGet$districtID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtID();
        if (realmGet$districtID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtIDIndex, rowIndex, realmGet$districtID, false);
        }
        String realmGet$mobile1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile1();
        if (realmGet$mobile1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobile1Index, rowIndex, realmGet$mobile1, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isLMOCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isLMOChecked(), false);
        String realmGet$longitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        }
        String realmGet$latitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        }
        String realmGet$location = ((CustomerAddressModelRealmProxyInterface)object).realmGet$location();
        if (realmGet$location != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
        }
        String realmGet$region = ((CustomerAddressModelRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        }
        String realmGet$popDistrict = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrict();
        if (realmGet$popDistrict != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIndex, rowIndex, realmGet$popDistrict, false);
        }
        String realmGet$popmandal = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popmandal();
        if (realmGet$popmandal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popmandalIndex, rowIndex, realmGet$popmandal, false);
        }
        String realmGet$popDistrictId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrictId();
        if (realmGet$popDistrictId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIdIndex, rowIndex, realmGet$popDistrictId, false);
        }
        String realmGet$popMandalId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popMandalId();
        if (realmGet$popMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
        }
        String realmGet$apsflUniqueId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$apsflUniqueId();
        if (realmGet$apsflUniqueId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.apsflUniqueIdIndex, rowIndex, realmGet$apsflUniqueId, false);
        }
        String realmGet$SIName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIName();
        if (realmGet$SIName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SINameIndex, rowIndex, realmGet$SIName, false);
        }
        String realmGet$SIEmail = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIEmail();
        if (realmGet$SIEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SIEmailIndex, rowIndex, realmGet$SIEmail, false);
        }
        String realmGet$SIPhno = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIPhno();
        if (realmGet$SIPhno != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SIPhnoIndex, rowIndex, realmGet$SIPhno, false);
        }
        String realmGet$entCustType = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustType();
        if (realmGet$entCustType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
        }
        String realmGet$entCustomerCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustomerCode();
        if (realmGet$entCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
        }
        String realmGet$cpeplace = ((CustomerAddressModelRealmProxyInterface)object).realmGet$cpeplace();
        if (realmGet$cpeplace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
        }
        String realmGet$status = ((CustomerAddressModelRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$customerAadhaarNumber = ((CustomerAddressModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
        if (realmGet$customerAadhaarNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CustomerAddressModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerAddressModelColumnInfo columnInfo = (CustomerAddressModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerAddressModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CustomerAddressModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CustomerAddressModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$popID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popID();
                if (realmGet$popID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
                }
                String realmGet$popName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popName();
                if (realmGet$popName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
                }
                String realmGet$address1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address1();
                if (realmGet$address1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
                }
                String realmGet$address2 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address2();
                if (realmGet$address2 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
                }
                String realmGet$locality = ((CustomerAddressModelRealmProxyInterface)object).realmGet$locality();
                if (realmGet$locality != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
                }
                String realmGet$pinCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$pinCode();
                if (realmGet$pinCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
                }
                String realmGet$mobile = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile();
                if (realmGet$mobile != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
                }
                String realmGet$stdCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$stdCode();
                if (realmGet$stdCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
                }
                String realmGet$landLine = ((CustomerAddressModelRealmProxyInterface)object).realmGet$landLine();
                if (realmGet$landLine != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.landLineIndex, rowIndex, realmGet$landLine, false);
                }
                String realmGet$villageName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageName();
                if (realmGet$villageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
                }
                String realmGet$villageID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageID();
                if (realmGet$villageID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageIDIndex, rowIndex, realmGet$villageID, false);
                }
                String realmGet$mandalName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalName();
                if (realmGet$mandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
                }
                String realmGet$mandalID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalID();
                if (realmGet$mandalID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
                }
                String realmGet$districtName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtName();
                if (realmGet$districtName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
                }
                String realmGet$districtID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtID();
                if (realmGet$districtID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtIDIndex, rowIndex, realmGet$districtID, false);
                }
                String realmGet$mobile1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile1();
                if (realmGet$mobile1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mobile1Index, rowIndex, realmGet$mobile1, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isLMOCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isLMOChecked(), false);
                String realmGet$longitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                }
                String realmGet$latitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                }
                String realmGet$location = ((CustomerAddressModelRealmProxyInterface)object).realmGet$location();
                if (realmGet$location != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
                }
                String realmGet$region = ((CustomerAddressModelRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                }
                String realmGet$popDistrict = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrict();
                if (realmGet$popDistrict != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIndex, rowIndex, realmGet$popDistrict, false);
                }
                String realmGet$popmandal = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popmandal();
                if (realmGet$popmandal != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popmandalIndex, rowIndex, realmGet$popmandal, false);
                }
                String realmGet$popDistrictId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrictId();
                if (realmGet$popDistrictId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIdIndex, rowIndex, realmGet$popDistrictId, false);
                }
                String realmGet$popMandalId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popMandalId();
                if (realmGet$popMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
                }
                String realmGet$apsflUniqueId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$apsflUniqueId();
                if (realmGet$apsflUniqueId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.apsflUniqueIdIndex, rowIndex, realmGet$apsflUniqueId, false);
                }
                String realmGet$SIName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIName();
                if (realmGet$SIName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.SINameIndex, rowIndex, realmGet$SIName, false);
                }
                String realmGet$SIEmail = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIEmail();
                if (realmGet$SIEmail != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.SIEmailIndex, rowIndex, realmGet$SIEmail, false);
                }
                String realmGet$SIPhno = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIPhno();
                if (realmGet$SIPhno != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.SIPhnoIndex, rowIndex, realmGet$SIPhno, false);
                }
                String realmGet$entCustType = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustType();
                if (realmGet$entCustType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
                }
                String realmGet$entCustomerCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustomerCode();
                if (realmGet$entCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
                }
                String realmGet$cpeplace = ((CustomerAddressModelRealmProxyInterface)object).realmGet$cpeplace();
                if (realmGet$cpeplace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
                }
                String realmGet$status = ((CustomerAddressModelRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                }
                String realmGet$customerAadhaarNumber = ((CustomerAddressModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
                if (realmGet$customerAadhaarNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.CustomerAddressModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CustomerAddressModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerAddressModelColumnInfo columnInfo = (CustomerAddressModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerAddressModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$popID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popID();
        if (realmGet$popID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popIDIndex, rowIndex, false);
        }
        String realmGet$popName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popName();
        if (realmGet$popName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popNameIndex, rowIndex, false);
        }
        String realmGet$address1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address1();
        if (realmGet$address1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.address1Index, rowIndex, false);
        }
        String realmGet$address2 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address2();
        if (realmGet$address2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.address2Index, rowIndex, false);
        }
        String realmGet$locality = ((CustomerAddressModelRealmProxyInterface)object).realmGet$locality();
        if (realmGet$locality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.localityIndex, rowIndex, false);
        }
        String realmGet$pinCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$pinCode();
        if (realmGet$pinCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, false);
        }
        String realmGet$mobile = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mobileIndex, rowIndex, false);
        }
        String realmGet$stdCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$stdCode();
        if (realmGet$stdCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, false);
        }
        String realmGet$landLine = ((CustomerAddressModelRealmProxyInterface)object).realmGet$landLine();
        if (realmGet$landLine != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.landLineIndex, rowIndex, realmGet$landLine, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.landLineIndex, rowIndex, false);
        }
        String realmGet$villageName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageName();
        if (realmGet$villageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.villageNameIndex, rowIndex, false);
        }
        String realmGet$villageID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageID();
        if (realmGet$villageID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageIDIndex, rowIndex, realmGet$villageID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.villageIDIndex, rowIndex, false);
        }
        String realmGet$mandalName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalName();
        if (realmGet$mandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, false);
        }
        String realmGet$mandalID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalID();
        if (realmGet$mandalID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, false);
        }
        String realmGet$districtName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtName();
        if (realmGet$districtName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.districtNameIndex, rowIndex, false);
        }
        String realmGet$districtID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtID();
        if (realmGet$districtID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtIDIndex, rowIndex, realmGet$districtID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.districtIDIndex, rowIndex, false);
        }
        String realmGet$mobile1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile1();
        if (realmGet$mobile1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobile1Index, rowIndex, realmGet$mobile1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mobile1Index, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isLMOCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isLMOChecked(), false);
        String realmGet$longitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
        }
        String realmGet$latitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
        }
        String realmGet$location = ((CustomerAddressModelRealmProxyInterface)object).realmGet$location();
        if (realmGet$location != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.locationIndex, rowIndex, false);
        }
        String realmGet$region = ((CustomerAddressModelRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
        }
        String realmGet$popDistrict = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrict();
        if (realmGet$popDistrict != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIndex, rowIndex, realmGet$popDistrict, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popDistrictIndex, rowIndex, false);
        }
        String realmGet$popmandal = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popmandal();
        if (realmGet$popmandal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popmandalIndex, rowIndex, realmGet$popmandal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popmandalIndex, rowIndex, false);
        }
        String realmGet$popDistrictId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrictId();
        if (realmGet$popDistrictId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIdIndex, rowIndex, realmGet$popDistrictId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popDistrictIdIndex, rowIndex, false);
        }
        String realmGet$popMandalId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popMandalId();
        if (realmGet$popMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, false);
        }
        String realmGet$apsflUniqueId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$apsflUniqueId();
        if (realmGet$apsflUniqueId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.apsflUniqueIdIndex, rowIndex, realmGet$apsflUniqueId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.apsflUniqueIdIndex, rowIndex, false);
        }
        String realmGet$SIName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIName();
        if (realmGet$SIName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SINameIndex, rowIndex, realmGet$SIName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.SINameIndex, rowIndex, false);
        }
        String realmGet$SIEmail = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIEmail();
        if (realmGet$SIEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SIEmailIndex, rowIndex, realmGet$SIEmail, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.SIEmailIndex, rowIndex, false);
        }
        String realmGet$SIPhno = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIPhno();
        if (realmGet$SIPhno != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SIPhnoIndex, rowIndex, realmGet$SIPhno, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.SIPhnoIndex, rowIndex, false);
        }
        String realmGet$entCustType = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustType();
        if (realmGet$entCustType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, false);
        }
        String realmGet$entCustomerCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustomerCode();
        if (realmGet$entCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, false);
        }
        String realmGet$cpeplace = ((CustomerAddressModelRealmProxyInterface)object).realmGet$cpeplace();
        if (realmGet$cpeplace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, false);
        }
        String realmGet$status = ((CustomerAddressModelRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$customerAadhaarNumber = ((CustomerAddressModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
        if (realmGet$customerAadhaarNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CustomerAddressModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerAddressModelColumnInfo columnInfo = (CustomerAddressModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerAddressModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CustomerAddressModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CustomerAddressModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerAddressModelRealmProxyInterface) object).realmGet$formTime(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$popID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popID();
                if (realmGet$popID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popIDIndex, rowIndex, false);
                }
                String realmGet$popName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popName();
                if (realmGet$popName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popNameIndex, rowIndex, false);
                }
                String realmGet$address1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address1();
                if (realmGet$address1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.address1Index, rowIndex, false);
                }
                String realmGet$address2 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$address2();
                if (realmGet$address2 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.address2Index, rowIndex, false);
                }
                String realmGet$locality = ((CustomerAddressModelRealmProxyInterface)object).realmGet$locality();
                if (realmGet$locality != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.localityIndex, rowIndex, false);
                }
                String realmGet$pinCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$pinCode();
                if (realmGet$pinCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, false);
                }
                String realmGet$mobile = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile();
                if (realmGet$mobile != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mobileIndex, rowIndex, false);
                }
                String realmGet$stdCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$stdCode();
                if (realmGet$stdCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, false);
                }
                String realmGet$landLine = ((CustomerAddressModelRealmProxyInterface)object).realmGet$landLine();
                if (realmGet$landLine != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.landLineIndex, rowIndex, realmGet$landLine, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.landLineIndex, rowIndex, false);
                }
                String realmGet$villageName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageName();
                if (realmGet$villageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.villageNameIndex, rowIndex, false);
                }
                String realmGet$villageID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$villageID();
                if (realmGet$villageID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageIDIndex, rowIndex, realmGet$villageID, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.villageIDIndex, rowIndex, false);
                }
                String realmGet$mandalName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalName();
                if (realmGet$mandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, false);
                }
                String realmGet$mandalID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mandalID();
                if (realmGet$mandalID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, false);
                }
                String realmGet$districtName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtName();
                if (realmGet$districtName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.districtNameIndex, rowIndex, false);
                }
                String realmGet$districtID = ((CustomerAddressModelRealmProxyInterface)object).realmGet$districtID();
                if (realmGet$districtID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtIDIndex, rowIndex, realmGet$districtID, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.districtIDIndex, rowIndex, false);
                }
                String realmGet$mobile1 = ((CustomerAddressModelRealmProxyInterface)object).realmGet$mobile1();
                if (realmGet$mobile1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mobile1Index, rowIndex, realmGet$mobile1, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mobile1Index, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isLMOCheckedIndex, rowIndex, ((CustomerAddressModelRealmProxyInterface)object).realmGet$isLMOChecked(), false);
                String realmGet$longitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
                }
                String realmGet$latitude = ((CustomerAddressModelRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
                }
                String realmGet$location = ((CustomerAddressModelRealmProxyInterface)object).realmGet$location();
                if (realmGet$location != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.locationIndex, rowIndex, false);
                }
                String realmGet$region = ((CustomerAddressModelRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
                }
                String realmGet$popDistrict = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrict();
                if (realmGet$popDistrict != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIndex, rowIndex, realmGet$popDistrict, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popDistrictIndex, rowIndex, false);
                }
                String realmGet$popmandal = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popmandal();
                if (realmGet$popmandal != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popmandalIndex, rowIndex, realmGet$popmandal, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popmandalIndex, rowIndex, false);
                }
                String realmGet$popDistrictId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popDistrictId();
                if (realmGet$popDistrictId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistrictIdIndex, rowIndex, realmGet$popDistrictId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popDistrictIdIndex, rowIndex, false);
                }
                String realmGet$popMandalId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$popMandalId();
                if (realmGet$popMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, false);
                }
                String realmGet$apsflUniqueId = ((CustomerAddressModelRealmProxyInterface)object).realmGet$apsflUniqueId();
                if (realmGet$apsflUniqueId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.apsflUniqueIdIndex, rowIndex, realmGet$apsflUniqueId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.apsflUniqueIdIndex, rowIndex, false);
                }
                String realmGet$SIName = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIName();
                if (realmGet$SIName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.SINameIndex, rowIndex, realmGet$SIName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.SINameIndex, rowIndex, false);
                }
                String realmGet$SIEmail = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIEmail();
                if (realmGet$SIEmail != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.SIEmailIndex, rowIndex, realmGet$SIEmail, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.SIEmailIndex, rowIndex, false);
                }
                String realmGet$SIPhno = ((CustomerAddressModelRealmProxyInterface)object).realmGet$SIPhno();
                if (realmGet$SIPhno != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.SIPhnoIndex, rowIndex, realmGet$SIPhno, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.SIPhnoIndex, rowIndex, false);
                }
                String realmGet$entCustType = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustType();
                if (realmGet$entCustType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, false);
                }
                String realmGet$entCustomerCode = ((CustomerAddressModelRealmProxyInterface)object).realmGet$entCustomerCode();
                if (realmGet$entCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, false);
                }
                String realmGet$cpeplace = ((CustomerAddressModelRealmProxyInterface)object).realmGet$cpeplace();
                if (realmGet$cpeplace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, false);
                }
                String realmGet$status = ((CustomerAddressModelRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
                }
                String realmGet$customerAadhaarNumber = ((CustomerAddressModelRealmProxyInterface)object).realmGet$customerAadhaarNumber();
                if (realmGet$customerAadhaarNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, realmGet$customerAadhaarNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerAadhaarNumberIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.CustomerAddressModel createDetachedCopy(com.app.apsfl.models.CustomerAddressModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.CustomerAddressModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.CustomerAddressModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.CustomerAddressModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.CustomerAddressModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$formTime(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$formTime());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$popID(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$popID());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$popName(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$popName());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$address1(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$address1());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$address2(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$address2());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$locality(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$locality());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$pinCode(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$pinCode());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$mobile(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$mobile());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$stdCode(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$stdCode());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$landLine(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$landLine());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$villageName(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$villageName());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$villageID(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$villageID());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$mandalName(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$mandalName());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$mandalID(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$mandalID());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$districtName(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$districtName());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$districtID(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$districtID());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$mobile1(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$mobile1());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$isCustomerChecked(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$isCustomerChecked());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$isLMOChecked(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$isLMOChecked());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$longitude(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$longitude());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$latitude(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$latitude());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$location(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$location());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$region(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$region());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$popDistrict(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$popDistrict());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$popmandal(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$popmandal());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$popDistrictId(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$popDistrictId());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$popMandalId(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$popMandalId());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$apsflUniqueId(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$apsflUniqueId());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$SIName(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$SIName());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$SIEmail(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$SIEmail());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$SIPhno(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$SIPhno());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$entCustType(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$entCustType());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$entCustomerCode(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$entCustomerCode());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$cpeplace(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$cpeplace());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$status(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$status());
        ((CustomerAddressModelRealmProxyInterface) unmanagedObject).realmSet$customerAadhaarNumber(((CustomerAddressModelRealmProxyInterface) realmObject).realmGet$customerAadhaarNumber());
        return unmanagedObject;
    }

    static com.app.apsfl.models.CustomerAddressModel update(Realm realm, com.app.apsfl.models.CustomerAddressModel realmObject, com.app.apsfl.models.CustomerAddressModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popID());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popName());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$address1(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$address1());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$address2(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$address2());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$locality(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$locality());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$pinCode(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$pinCode());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mobile(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mobile());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$stdCode(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$stdCode());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$landLine(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$landLine());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$villageName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$villageName());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$villageID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$villageID());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mandalName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mandalName());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mandalID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mandalID());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$districtName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$districtName());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$districtID(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$districtID());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$mobile1(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$mobile1());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$isCustomerChecked(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$isCustomerChecked());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$isLMOChecked(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$isLMOChecked());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$longitude(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$longitude());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$latitude(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$latitude());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$location(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$location());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$region(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$region());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popDistrict(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popDistrict());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popmandal(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popmandal());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popDistrictId(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popDistrictId());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$popMandalId(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$popMandalId());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$apsflUniqueId(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$apsflUniqueId());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$SIName(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$SIName());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$SIEmail(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$SIEmail());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$SIPhno(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$SIPhno());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$entCustType(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$entCustType());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$entCustomerCode(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$entCustomerCode());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$cpeplace(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$cpeplace());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$status(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$status());
        ((CustomerAddressModelRealmProxyInterface) realmObject).realmSet$customerAadhaarNumber(((CustomerAddressModelRealmProxyInterface) newObject).realmGet$customerAadhaarNumber());
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
        CustomerAddressModelRealmProxy aCustomerAddressModel = (CustomerAddressModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCustomerAddressModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCustomerAddressModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCustomerAddressModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
