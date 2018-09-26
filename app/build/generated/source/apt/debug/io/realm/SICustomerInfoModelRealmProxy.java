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

public class SICustomerInfoModelRealmProxy extends com.app.apsfl.models.SICustomerInfoModel
    implements RealmObjectProxy, SICustomerInfoModelRealmProxyInterface {

    static final class SICustomerInfoModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long apsflTrackIdIndex;
        public long cafNoIndex;
        public long organizationNameIndex;
        public long nameOfContactPersonNameIndex;
        public long numberOfContactPersonIndex;
        public long instAddressIndex;
        public long cpeDeviceLocationIndex;
        public long instDistNameIndex;
        public long selectedInstDistIdIndex;
        public long instMandalNameIndex;
        public long selectedInstMandalIdIndex;
        public long instVillageIdIndex;
        public long selectedInstVillageIndex;
        public long entCustomerCodeIndex;
        public long entCustTypeIndex;
        public long custIdIndex;
        public long billCycleIndex;
        public long coreSrvcCodeIndex;

        SICustomerInfoModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(18);
            this.apsflTrackIdIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "apsflTrackId");
            indicesMap.put("apsflTrackId", this.apsflTrackIdIndex);
            this.cafNoIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "cafNo");
            indicesMap.put("cafNo", this.cafNoIndex);
            this.organizationNameIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "organizationName");
            indicesMap.put("organizationName", this.organizationNameIndex);
            this.nameOfContactPersonNameIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "nameOfContactPersonName");
            indicesMap.put("nameOfContactPersonName", this.nameOfContactPersonNameIndex);
            this.numberOfContactPersonIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "numberOfContactPerson");
            indicesMap.put("numberOfContactPerson", this.numberOfContactPersonIndex);
            this.instAddressIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "instAddress");
            indicesMap.put("instAddress", this.instAddressIndex);
            this.cpeDeviceLocationIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "cpeDeviceLocation");
            indicesMap.put("cpeDeviceLocation", this.cpeDeviceLocationIndex);
            this.instDistNameIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "instDistName");
            indicesMap.put("instDistName", this.instDistNameIndex);
            this.selectedInstDistIdIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "selectedInstDistId");
            indicesMap.put("selectedInstDistId", this.selectedInstDistIdIndex);
            this.instMandalNameIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "instMandalName");
            indicesMap.put("instMandalName", this.instMandalNameIndex);
            this.selectedInstMandalIdIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "selectedInstMandalId");
            indicesMap.put("selectedInstMandalId", this.selectedInstMandalIdIndex);
            this.instVillageIdIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "instVillageId");
            indicesMap.put("instVillageId", this.instVillageIdIndex);
            this.selectedInstVillageIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "selectedInstVillage");
            indicesMap.put("selectedInstVillage", this.selectedInstVillageIndex);
            this.entCustomerCodeIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "entCustomerCode");
            indicesMap.put("entCustomerCode", this.entCustomerCodeIndex);
            this.entCustTypeIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "entCustType");
            indicesMap.put("entCustType", this.entCustTypeIndex);
            this.custIdIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "custId");
            indicesMap.put("custId", this.custIdIndex);
            this.billCycleIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "billCycle");
            indicesMap.put("billCycle", this.billCycleIndex);
            this.coreSrvcCodeIndex = getValidColumnIndex(path, table, "SICustomerInfoModel", "coreSrvcCode");
            indicesMap.put("coreSrvcCode", this.coreSrvcCodeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final SICustomerInfoModelColumnInfo otherInfo = (SICustomerInfoModelColumnInfo) other;
            this.apsflTrackIdIndex = otherInfo.apsflTrackIdIndex;
            this.cafNoIndex = otherInfo.cafNoIndex;
            this.organizationNameIndex = otherInfo.organizationNameIndex;
            this.nameOfContactPersonNameIndex = otherInfo.nameOfContactPersonNameIndex;
            this.numberOfContactPersonIndex = otherInfo.numberOfContactPersonIndex;
            this.instAddressIndex = otherInfo.instAddressIndex;
            this.cpeDeviceLocationIndex = otherInfo.cpeDeviceLocationIndex;
            this.instDistNameIndex = otherInfo.instDistNameIndex;
            this.selectedInstDistIdIndex = otherInfo.selectedInstDistIdIndex;
            this.instMandalNameIndex = otherInfo.instMandalNameIndex;
            this.selectedInstMandalIdIndex = otherInfo.selectedInstMandalIdIndex;
            this.instVillageIdIndex = otherInfo.instVillageIdIndex;
            this.selectedInstVillageIndex = otherInfo.selectedInstVillageIndex;
            this.entCustomerCodeIndex = otherInfo.entCustomerCodeIndex;
            this.entCustTypeIndex = otherInfo.entCustTypeIndex;
            this.custIdIndex = otherInfo.custIdIndex;
            this.billCycleIndex = otherInfo.billCycleIndex;
            this.coreSrvcCodeIndex = otherInfo.coreSrvcCodeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final SICustomerInfoModelColumnInfo clone() {
            return (SICustomerInfoModelColumnInfo) super.clone();
        }

    }
    private SICustomerInfoModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("apsflTrackId");
        fieldNames.add("cafNo");
        fieldNames.add("organizationName");
        fieldNames.add("nameOfContactPersonName");
        fieldNames.add("numberOfContactPerson");
        fieldNames.add("instAddress");
        fieldNames.add("cpeDeviceLocation");
        fieldNames.add("instDistName");
        fieldNames.add("selectedInstDistId");
        fieldNames.add("instMandalName");
        fieldNames.add("selectedInstMandalId");
        fieldNames.add("instVillageId");
        fieldNames.add("selectedInstVillage");
        fieldNames.add("entCustomerCode");
        fieldNames.add("entCustType");
        fieldNames.add("custId");
        fieldNames.add("billCycle");
        fieldNames.add("coreSrvcCode");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SICustomerInfoModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SICustomerInfoModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.SICustomerInfoModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$apsflTrackId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.apsflTrackIdIndex);
    }

    public void realmSet$apsflTrackId(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'apsflTrackId' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$cafNo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cafNoIndex);
    }

    public void realmSet$cafNo(String value) {
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
                row.getTable().setNull(columnInfo.cafNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cafNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cafNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cafNoIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$organizationName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.organizationNameIndex);
    }

    public void realmSet$organizationName(String value) {
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
                row.getTable().setNull(columnInfo.organizationNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.organizationNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.organizationNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.organizationNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$nameOfContactPersonName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameOfContactPersonNameIndex);
    }

    public void realmSet$nameOfContactPersonName(String value) {
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
                row.getTable().setNull(columnInfo.nameOfContactPersonNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameOfContactPersonNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameOfContactPersonNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameOfContactPersonNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$numberOfContactPerson() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.numberOfContactPersonIndex);
    }

    public void realmSet$numberOfContactPerson(String value) {
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
                row.getTable().setNull(columnInfo.numberOfContactPersonIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.numberOfContactPersonIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numberOfContactPersonIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.numberOfContactPersonIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$instAddress() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instAddressIndex);
    }

    public void realmSet$instAddress(String value) {
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
                row.getTable().setNull(columnInfo.instAddressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instAddressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instAddressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instAddressIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeDeviceLocation() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeDeviceLocationIndex);
    }

    public void realmSet$cpeDeviceLocation(String value) {
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
                row.getTable().setNull(columnInfo.cpeDeviceLocationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeDeviceLocationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeDeviceLocationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeDeviceLocationIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$instDistName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instDistNameIndex);
    }

    public void realmSet$instDistName(String value) {
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
                row.getTable().setNull(columnInfo.instDistNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instDistNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instDistNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instDistNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$selectedInstDistId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.selectedInstDistIdIndex);
    }

    public void realmSet$selectedInstDistId(String value) {
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
                row.getTable().setNull(columnInfo.selectedInstDistIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.selectedInstDistIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.selectedInstDistIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.selectedInstDistIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$instMandalName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instMandalNameIndex);
    }

    public void realmSet$instMandalName(String value) {
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
                row.getTable().setNull(columnInfo.instMandalNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instMandalNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instMandalNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instMandalNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$selectedInstMandalId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.selectedInstMandalIdIndex);
    }

    public void realmSet$selectedInstMandalId(String value) {
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
                row.getTable().setNull(columnInfo.selectedInstMandalIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.selectedInstMandalIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.selectedInstMandalIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.selectedInstMandalIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$instVillageId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instVillageIdIndex);
    }

    public void realmSet$instVillageId(String value) {
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
                row.getTable().setNull(columnInfo.instVillageIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instVillageIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instVillageIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instVillageIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$selectedInstVillage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.selectedInstVillageIndex);
    }

    public void realmSet$selectedInstVillage(String value) {
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
                row.getTable().setNull(columnInfo.selectedInstVillageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.selectedInstVillageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.selectedInstVillageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.selectedInstVillageIndex, value);
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
    public String realmGet$custId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.custIdIndex);
    }

    public void realmSet$custId(String value) {
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
                row.getTable().setNull(columnInfo.custIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.custIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.custIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.custIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$billCycle() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.billCycleIndex);
    }

    public void realmSet$billCycle(String value) {
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
                row.getTable().setNull(columnInfo.billCycleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.billCycleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.billCycleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.billCycleIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$coreSrvcCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.coreSrvcCodeIndex);
    }

    public void realmSet$coreSrvcCode(String value) {
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
                row.getTable().setNull(columnInfo.coreSrvcCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.coreSrvcCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.coreSrvcCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.coreSrvcCodeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("SICustomerInfoModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("SICustomerInfoModel");
            realmObjectSchema.add(new Property("apsflTrackId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cafNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("organizationName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("nameOfContactPersonName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("numberOfContactPerson", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("instAddress", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeDeviceLocation", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("instDistName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("selectedInstDistId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("instMandalName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("selectedInstMandalId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("instVillageId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("selectedInstVillage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("entCustomerCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("entCustType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("custId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("billCycle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("coreSrvcCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("SICustomerInfoModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_SICustomerInfoModel")) {
            Table table = sharedRealm.getTable("class_SICustomerInfoModel");
            table.addColumn(RealmFieldType.STRING, "apsflTrackId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cafNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "organizationName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nameOfContactPersonName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "numberOfContactPerson", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "instAddress", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeDeviceLocation", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "instDistName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "selectedInstDistId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "instMandalName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "selectedInstMandalId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "instVillageId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "selectedInstVillage", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "entCustomerCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "entCustType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "custId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "billCycle", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "coreSrvcCode", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("apsflTrackId"));
            table.setPrimaryKey("apsflTrackId");
            return table;
        }
        return sharedRealm.getTable("class_SICustomerInfoModel");
    }

    public static SICustomerInfoModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SICustomerInfoModel")) {
            Table table = sharedRealm.getTable("class_SICustomerInfoModel");
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

            final SICustomerInfoModelColumnInfo columnInfo = new SICustomerInfoModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("apsflTrackId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'apsflTrackId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("apsflTrackId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'apsflTrackId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.apsflTrackIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'apsflTrackId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("apsflTrackId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'apsflTrackId' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("apsflTrackId"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'apsflTrackId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("cafNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cafNo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cafNo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cafNo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cafNoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cafNo' is required. Either set @Required to field 'cafNo' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("organizationName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'organizationName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("organizationName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'organizationName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.organizationNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'organizationName' is required. Either set @Required to field 'organizationName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("nameOfContactPersonName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameOfContactPersonName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nameOfContactPersonName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameOfContactPersonName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameOfContactPersonNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameOfContactPersonName' is required. Either set @Required to field 'nameOfContactPersonName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("numberOfContactPerson")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberOfContactPerson' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("numberOfContactPerson") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'numberOfContactPerson' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.numberOfContactPersonIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numberOfContactPerson' is required. Either set @Required to field 'numberOfContactPerson' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("instAddress")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'instAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("instAddress") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'instAddress' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.instAddressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'instAddress' is required. Either set @Required to field 'instAddress' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeDeviceLocation")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeDeviceLocation' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeDeviceLocation") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeDeviceLocation' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeDeviceLocationIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeDeviceLocation' is required. Either set @Required to field 'cpeDeviceLocation' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("instDistName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'instDistName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("instDistName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'instDistName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.instDistNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'instDistName' is required. Either set @Required to field 'instDistName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedInstDistId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedInstDistId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("selectedInstDistId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'selectedInstDistId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.selectedInstDistIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'selectedInstDistId' is required. Either set @Required to field 'selectedInstDistId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("instMandalName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'instMandalName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("instMandalName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'instMandalName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.instMandalNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'instMandalName' is required. Either set @Required to field 'instMandalName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedInstMandalId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedInstMandalId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("selectedInstMandalId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'selectedInstMandalId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.selectedInstMandalIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'selectedInstMandalId' is required. Either set @Required to field 'selectedInstMandalId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("instVillageId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'instVillageId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("instVillageId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'instVillageId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.instVillageIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'instVillageId' is required. Either set @Required to field 'instVillageId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedInstVillage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedInstVillage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("selectedInstVillage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'selectedInstVillage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.selectedInstVillageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'selectedInstVillage' is required. Either set @Required to field 'selectedInstVillage' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("entCustType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'entCustType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("entCustType") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'entCustType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.entCustTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'entCustType' is required. Either set @Required to field 'entCustType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("custId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'custId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("custId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'custId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.custIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'custId' is required. Either set @Required to field 'custId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("billCycle")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'billCycle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("billCycle") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'billCycle' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.billCycleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'billCycle' is required. Either set @Required to field 'billCycle' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("coreSrvcCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'coreSrvcCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("coreSrvcCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'coreSrvcCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.coreSrvcCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'coreSrvcCode' is required. Either set @Required to field 'coreSrvcCode' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SICustomerInfoModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SICustomerInfoModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.SICustomerInfoModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.SICustomerInfoModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.SICustomerInfoModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("apsflTrackId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("apsflTrackId"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SICustomerInfoModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.SICustomerInfoModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("apsflTrackId")) {
                if (json.isNull("apsflTrackId")) {
                    obj = (io.realm.SICustomerInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SICustomerInfoModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.SICustomerInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SICustomerInfoModel.class, json.getString("apsflTrackId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'apsflTrackId'.");
            }
        }
        if (json.has("cafNo")) {
            if (json.isNull("cafNo")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cafNo(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cafNo((String) json.getString("cafNo"));
            }
        }
        if (json.has("organizationName")) {
            if (json.isNull("organizationName")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$organizationName(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$organizationName((String) json.getString("organizationName"));
            }
        }
        if (json.has("nameOfContactPersonName")) {
            if (json.isNull("nameOfContactPersonName")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$nameOfContactPersonName(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$nameOfContactPersonName((String) json.getString("nameOfContactPersonName"));
            }
        }
        if (json.has("numberOfContactPerson")) {
            if (json.isNull("numberOfContactPerson")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$numberOfContactPerson(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$numberOfContactPerson((String) json.getString("numberOfContactPerson"));
            }
        }
        if (json.has("instAddress")) {
            if (json.isNull("instAddress")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instAddress(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instAddress((String) json.getString("instAddress"));
            }
        }
        if (json.has("cpeDeviceLocation")) {
            if (json.isNull("cpeDeviceLocation")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cpeDeviceLocation(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cpeDeviceLocation((String) json.getString("cpeDeviceLocation"));
            }
        }
        if (json.has("instDistName")) {
            if (json.isNull("instDistName")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instDistName(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instDistName((String) json.getString("instDistName"));
            }
        }
        if (json.has("selectedInstDistId")) {
            if (json.isNull("selectedInstDistId")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstDistId(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstDistId((String) json.getString("selectedInstDistId"));
            }
        }
        if (json.has("instMandalName")) {
            if (json.isNull("instMandalName")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instMandalName(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instMandalName((String) json.getString("instMandalName"));
            }
        }
        if (json.has("selectedInstMandalId")) {
            if (json.isNull("selectedInstMandalId")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstMandalId(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstMandalId((String) json.getString("selectedInstMandalId"));
            }
        }
        if (json.has("instVillageId")) {
            if (json.isNull("instVillageId")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instVillageId(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instVillageId((String) json.getString("instVillageId"));
            }
        }
        if (json.has("selectedInstVillage")) {
            if (json.isNull("selectedInstVillage")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstVillage(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstVillage((String) json.getString("selectedInstVillage"));
            }
        }
        if (json.has("entCustomerCode")) {
            if (json.isNull("entCustomerCode")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustomerCode(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustomerCode((String) json.getString("entCustomerCode"));
            }
        }
        if (json.has("entCustType")) {
            if (json.isNull("entCustType")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustType(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustType((String) json.getString("entCustType"));
            }
        }
        if (json.has("custId")) {
            if (json.isNull("custId")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$custId(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$custId((String) json.getString("custId"));
            }
        }
        if (json.has("billCycle")) {
            if (json.isNull("billCycle")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$billCycle(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$billCycle((String) json.getString("billCycle"));
            }
        }
        if (json.has("coreSrvcCode")) {
            if (json.isNull("coreSrvcCode")) {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$coreSrvcCode(null);
            } else {
                ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$coreSrvcCode((String) json.getString("coreSrvcCode"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.SICustomerInfoModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.SICustomerInfoModel obj = new com.app.apsfl.models.SICustomerInfoModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("apsflTrackId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$apsflTrackId(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$apsflTrackId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("cafNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cafNo(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cafNo((String) reader.nextString());
                }
            } else if (name.equals("organizationName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$organizationName(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$organizationName((String) reader.nextString());
                }
            } else if (name.equals("nameOfContactPersonName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$nameOfContactPersonName(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$nameOfContactPersonName((String) reader.nextString());
                }
            } else if (name.equals("numberOfContactPerson")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$numberOfContactPerson(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$numberOfContactPerson((String) reader.nextString());
                }
            } else if (name.equals("instAddress")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instAddress(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instAddress((String) reader.nextString());
                }
            } else if (name.equals("cpeDeviceLocation")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cpeDeviceLocation(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$cpeDeviceLocation((String) reader.nextString());
                }
            } else if (name.equals("instDistName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instDistName(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instDistName((String) reader.nextString());
                }
            } else if (name.equals("selectedInstDistId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstDistId(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstDistId((String) reader.nextString());
                }
            } else if (name.equals("instMandalName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instMandalName(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instMandalName((String) reader.nextString());
                }
            } else if (name.equals("selectedInstMandalId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstMandalId(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstMandalId((String) reader.nextString());
                }
            } else if (name.equals("instVillageId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instVillageId(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$instVillageId((String) reader.nextString());
                }
            } else if (name.equals("selectedInstVillage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstVillage(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$selectedInstVillage((String) reader.nextString());
                }
            } else if (name.equals("entCustomerCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustomerCode(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustomerCode((String) reader.nextString());
                }
            } else if (name.equals("entCustType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustType(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$entCustType((String) reader.nextString());
                }
            } else if (name.equals("custId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$custId(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$custId((String) reader.nextString());
                }
            } else if (name.equals("billCycle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$billCycle(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$billCycle((String) reader.nextString());
                }
            } else if (name.equals("coreSrvcCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$coreSrvcCode(null);
                } else {
                    ((SICustomerInfoModelRealmProxyInterface) obj).realmSet$coreSrvcCode((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'apsflTrackId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.SICustomerInfoModel copyOrUpdate(Realm realm, com.app.apsfl.models.SICustomerInfoModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SICustomerInfoModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.SICustomerInfoModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.SICustomerInfoModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((SICustomerInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SICustomerInfoModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.SICustomerInfoModelRealmProxy();
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

    public static com.app.apsfl.models.SICustomerInfoModel copy(Realm realm, com.app.apsfl.models.SICustomerInfoModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SICustomerInfoModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.SICustomerInfoModel realmObject = realm.createObjectInternal(com.app.apsfl.models.SICustomerInfoModel.class, ((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$apsflTrackId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$cafNo(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$cafNo());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$organizationName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$organizationName());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$nameOfContactPersonName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$nameOfContactPersonName());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$numberOfContactPerson(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$numberOfContactPerson());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instAddress(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instAddress());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$cpeDeviceLocation(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$cpeDeviceLocation());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instDistName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instDistName());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$selectedInstDistId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$selectedInstDistId());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instMandalName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instMandalName());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$selectedInstMandalId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$selectedInstMandalId());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instVillageId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instVillageId());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$selectedInstVillage(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$selectedInstVillage());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$entCustomerCode(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$entCustomerCode());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$entCustType(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$entCustType());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$custId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$custId());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$billCycle(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$billCycle());
            ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$coreSrvcCode(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$coreSrvcCode());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.SICustomerInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SICustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICustomerInfoModelColumnInfo columnInfo = (SICustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SICustomerInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$cafNo = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cafNo();
        if (realmGet$cafNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
        }
        String realmGet$organizationName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$organizationName();
        if (realmGet$organizationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
        }
        String realmGet$nameOfContactPersonName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$nameOfContactPersonName();
        if (realmGet$nameOfContactPersonName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfContactPersonNameIndex, rowIndex, realmGet$nameOfContactPersonName, false);
        }
        String realmGet$numberOfContactPerson = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$numberOfContactPerson();
        if (realmGet$numberOfContactPerson != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numberOfContactPersonIndex, rowIndex, realmGet$numberOfContactPerson, false);
        }
        String realmGet$instAddress = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instAddress();
        if (realmGet$instAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instAddressIndex, rowIndex, realmGet$instAddress, false);
        }
        String realmGet$cpeDeviceLocation = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cpeDeviceLocation();
        if (realmGet$cpeDeviceLocation != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeDeviceLocationIndex, rowIndex, realmGet$cpeDeviceLocation, false);
        }
        String realmGet$instDistName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instDistName();
        if (realmGet$instDistName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instDistNameIndex, rowIndex, realmGet$instDistName, false);
        }
        String realmGet$selectedInstDistId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstDistId();
        if (realmGet$selectedInstDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedInstDistIdIndex, rowIndex, realmGet$selectedInstDistId, false);
        }
        String realmGet$instMandalName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instMandalName();
        if (realmGet$instMandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instMandalNameIndex, rowIndex, realmGet$instMandalName, false);
        }
        String realmGet$selectedInstMandalId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstMandalId();
        if (realmGet$selectedInstMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedInstMandalIdIndex, rowIndex, realmGet$selectedInstMandalId, false);
        }
        String realmGet$instVillageId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instVillageId();
        if (realmGet$instVillageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instVillageIdIndex, rowIndex, realmGet$instVillageId, false);
        }
        String realmGet$selectedInstVillage = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstVillage();
        if (realmGet$selectedInstVillage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedInstVillageIndex, rowIndex, realmGet$selectedInstVillage, false);
        }
        String realmGet$entCustomerCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustomerCode();
        if (realmGet$entCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
        }
        String realmGet$entCustType = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustType();
        if (realmGet$entCustType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
        }
        String realmGet$custId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$custId();
        if (realmGet$custId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
        }
        String realmGet$billCycle = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$billCycle();
        if (realmGet$billCycle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
        }
        String realmGet$coreSrvcCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$coreSrvcCode();
        if (realmGet$coreSrvcCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreSrvcCodeIndex, rowIndex, realmGet$coreSrvcCode, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SICustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICustomerInfoModelColumnInfo columnInfo = (SICustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SICustomerInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SICustomerInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SICustomerInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$cafNo = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cafNo();
                if (realmGet$cafNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
                }
                String realmGet$organizationName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$organizationName();
                if (realmGet$organizationName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
                }
                String realmGet$nameOfContactPersonName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$nameOfContactPersonName();
                if (realmGet$nameOfContactPersonName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfContactPersonNameIndex, rowIndex, realmGet$nameOfContactPersonName, false);
                }
                String realmGet$numberOfContactPerson = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$numberOfContactPerson();
                if (realmGet$numberOfContactPerson != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numberOfContactPersonIndex, rowIndex, realmGet$numberOfContactPerson, false);
                }
                String realmGet$instAddress = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instAddress();
                if (realmGet$instAddress != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instAddressIndex, rowIndex, realmGet$instAddress, false);
                }
                String realmGet$cpeDeviceLocation = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cpeDeviceLocation();
                if (realmGet$cpeDeviceLocation != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeDeviceLocationIndex, rowIndex, realmGet$cpeDeviceLocation, false);
                }
                String realmGet$instDistName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instDistName();
                if (realmGet$instDistName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instDistNameIndex, rowIndex, realmGet$instDistName, false);
                }
                String realmGet$selectedInstDistId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstDistId();
                if (realmGet$selectedInstDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedInstDistIdIndex, rowIndex, realmGet$selectedInstDistId, false);
                }
                String realmGet$instMandalName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instMandalName();
                if (realmGet$instMandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instMandalNameIndex, rowIndex, realmGet$instMandalName, false);
                }
                String realmGet$selectedInstMandalId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstMandalId();
                if (realmGet$selectedInstMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedInstMandalIdIndex, rowIndex, realmGet$selectedInstMandalId, false);
                }
                String realmGet$instVillageId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instVillageId();
                if (realmGet$instVillageId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instVillageIdIndex, rowIndex, realmGet$instVillageId, false);
                }
                String realmGet$selectedInstVillage = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstVillage();
                if (realmGet$selectedInstVillage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedInstVillageIndex, rowIndex, realmGet$selectedInstVillage, false);
                }
                String realmGet$entCustomerCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustomerCode();
                if (realmGet$entCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
                }
                String realmGet$entCustType = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustType();
                if (realmGet$entCustType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
                }
                String realmGet$custId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$custId();
                if (realmGet$custId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
                }
                String realmGet$billCycle = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$billCycle();
                if (realmGet$billCycle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
                }
                String realmGet$coreSrvcCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$coreSrvcCode();
                if (realmGet$coreSrvcCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreSrvcCodeIndex, rowIndex, realmGet$coreSrvcCode, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.SICustomerInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SICustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICustomerInfoModelColumnInfo columnInfo = (SICustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SICustomerInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$cafNo = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cafNo();
        if (realmGet$cafNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cafNoIndex, rowIndex, false);
        }
        String realmGet$organizationName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$organizationName();
        if (realmGet$organizationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, false);
        }
        String realmGet$nameOfContactPersonName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$nameOfContactPersonName();
        if (realmGet$nameOfContactPersonName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfContactPersonNameIndex, rowIndex, realmGet$nameOfContactPersonName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameOfContactPersonNameIndex, rowIndex, false);
        }
        String realmGet$numberOfContactPerson = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$numberOfContactPerson();
        if (realmGet$numberOfContactPerson != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numberOfContactPersonIndex, rowIndex, realmGet$numberOfContactPerson, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numberOfContactPersonIndex, rowIndex, false);
        }
        String realmGet$instAddress = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instAddress();
        if (realmGet$instAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instAddressIndex, rowIndex, realmGet$instAddress, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instAddressIndex, rowIndex, false);
        }
        String realmGet$cpeDeviceLocation = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cpeDeviceLocation();
        if (realmGet$cpeDeviceLocation != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeDeviceLocationIndex, rowIndex, realmGet$cpeDeviceLocation, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeDeviceLocationIndex, rowIndex, false);
        }
        String realmGet$instDistName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instDistName();
        if (realmGet$instDistName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instDistNameIndex, rowIndex, realmGet$instDistName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instDistNameIndex, rowIndex, false);
        }
        String realmGet$selectedInstDistId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstDistId();
        if (realmGet$selectedInstDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedInstDistIdIndex, rowIndex, realmGet$selectedInstDistId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.selectedInstDistIdIndex, rowIndex, false);
        }
        String realmGet$instMandalName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instMandalName();
        if (realmGet$instMandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instMandalNameIndex, rowIndex, realmGet$instMandalName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instMandalNameIndex, rowIndex, false);
        }
        String realmGet$selectedInstMandalId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstMandalId();
        if (realmGet$selectedInstMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedInstMandalIdIndex, rowIndex, realmGet$selectedInstMandalId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.selectedInstMandalIdIndex, rowIndex, false);
        }
        String realmGet$instVillageId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instVillageId();
        if (realmGet$instVillageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instVillageIdIndex, rowIndex, realmGet$instVillageId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instVillageIdIndex, rowIndex, false);
        }
        String realmGet$selectedInstVillage = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstVillage();
        if (realmGet$selectedInstVillage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedInstVillageIndex, rowIndex, realmGet$selectedInstVillage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.selectedInstVillageIndex, rowIndex, false);
        }
        String realmGet$entCustomerCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustomerCode();
        if (realmGet$entCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, false);
        }
        String realmGet$entCustType = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustType();
        if (realmGet$entCustType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, false);
        }
        String realmGet$custId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$custId();
        if (realmGet$custId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.custIdIndex, rowIndex, false);
        }
        String realmGet$billCycle = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$billCycle();
        if (realmGet$billCycle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.billCycleIndex, rowIndex, false);
        }
        String realmGet$coreSrvcCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$coreSrvcCode();
        if (realmGet$coreSrvcCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreSrvcCodeIndex, rowIndex, realmGet$coreSrvcCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coreSrvcCodeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SICustomerInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICustomerInfoModelColumnInfo columnInfo = (SICustomerInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICustomerInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SICustomerInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SICustomerInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SICustomerInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$cafNo = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cafNo();
                if (realmGet$cafNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cafNoIndex, rowIndex, false);
                }
                String realmGet$organizationName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$organizationName();
                if (realmGet$organizationName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, false);
                }
                String realmGet$nameOfContactPersonName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$nameOfContactPersonName();
                if (realmGet$nameOfContactPersonName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfContactPersonNameIndex, rowIndex, realmGet$nameOfContactPersonName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameOfContactPersonNameIndex, rowIndex, false);
                }
                String realmGet$numberOfContactPerson = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$numberOfContactPerson();
                if (realmGet$numberOfContactPerson != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numberOfContactPersonIndex, rowIndex, realmGet$numberOfContactPerson, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numberOfContactPersonIndex, rowIndex, false);
                }
                String realmGet$instAddress = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instAddress();
                if (realmGet$instAddress != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instAddressIndex, rowIndex, realmGet$instAddress, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.instAddressIndex, rowIndex, false);
                }
                String realmGet$cpeDeviceLocation = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$cpeDeviceLocation();
                if (realmGet$cpeDeviceLocation != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeDeviceLocationIndex, rowIndex, realmGet$cpeDeviceLocation, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeDeviceLocationIndex, rowIndex, false);
                }
                String realmGet$instDistName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instDistName();
                if (realmGet$instDistName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instDistNameIndex, rowIndex, realmGet$instDistName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.instDistNameIndex, rowIndex, false);
                }
                String realmGet$selectedInstDistId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstDistId();
                if (realmGet$selectedInstDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedInstDistIdIndex, rowIndex, realmGet$selectedInstDistId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.selectedInstDistIdIndex, rowIndex, false);
                }
                String realmGet$instMandalName = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instMandalName();
                if (realmGet$instMandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instMandalNameIndex, rowIndex, realmGet$instMandalName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.instMandalNameIndex, rowIndex, false);
                }
                String realmGet$selectedInstMandalId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstMandalId();
                if (realmGet$selectedInstMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedInstMandalIdIndex, rowIndex, realmGet$selectedInstMandalId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.selectedInstMandalIdIndex, rowIndex, false);
                }
                String realmGet$instVillageId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$instVillageId();
                if (realmGet$instVillageId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instVillageIdIndex, rowIndex, realmGet$instVillageId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.instVillageIdIndex, rowIndex, false);
                }
                String realmGet$selectedInstVillage = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$selectedInstVillage();
                if (realmGet$selectedInstVillage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedInstVillageIndex, rowIndex, realmGet$selectedInstVillage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.selectedInstVillageIndex, rowIndex, false);
                }
                String realmGet$entCustomerCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustomerCode();
                if (realmGet$entCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, false);
                }
                String realmGet$entCustType = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$entCustType();
                if (realmGet$entCustType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, false);
                }
                String realmGet$custId = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$custId();
                if (realmGet$custId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.custIdIndex, rowIndex, false);
                }
                String realmGet$billCycle = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$billCycle();
                if (realmGet$billCycle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.billCycleIndex, rowIndex, false);
                }
                String realmGet$coreSrvcCode = ((SICustomerInfoModelRealmProxyInterface)object).realmGet$coreSrvcCode();
                if (realmGet$coreSrvcCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreSrvcCodeIndex, rowIndex, realmGet$coreSrvcCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.coreSrvcCodeIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.SICustomerInfoModel createDetachedCopy(com.app.apsfl.models.SICustomerInfoModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.SICustomerInfoModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.SICustomerInfoModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.SICustomerInfoModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.SICustomerInfoModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$apsflTrackId(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$apsflTrackId());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$cafNo(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$cafNo());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$organizationName(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$organizationName());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$nameOfContactPersonName(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$nameOfContactPersonName());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$numberOfContactPerson(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$numberOfContactPerson());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$instAddress(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$instAddress());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpeDeviceLocation(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$cpeDeviceLocation());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$instDistName(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$instDistName());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedInstDistId(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$selectedInstDistId());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$instMandalName(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$instMandalName());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedInstMandalId(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$selectedInstMandalId());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$instVillageId(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$instVillageId());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedInstVillage(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$selectedInstVillage());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$entCustomerCode(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$entCustomerCode());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$entCustType(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$entCustType());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$custId(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$custId());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$billCycle(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$billCycle());
        ((SICustomerInfoModelRealmProxyInterface) unmanagedObject).realmSet$coreSrvcCode(((SICustomerInfoModelRealmProxyInterface) realmObject).realmGet$coreSrvcCode());
        return unmanagedObject;
    }

    static com.app.apsfl.models.SICustomerInfoModel update(Realm realm, com.app.apsfl.models.SICustomerInfoModel realmObject, com.app.apsfl.models.SICustomerInfoModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$cafNo(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$cafNo());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$organizationName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$organizationName());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$nameOfContactPersonName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$nameOfContactPersonName());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$numberOfContactPerson(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$numberOfContactPerson());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instAddress(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instAddress());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$cpeDeviceLocation(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$cpeDeviceLocation());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instDistName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instDistName());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$selectedInstDistId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$selectedInstDistId());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instMandalName(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instMandalName());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$selectedInstMandalId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$selectedInstMandalId());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$instVillageId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$instVillageId());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$selectedInstVillage(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$selectedInstVillage());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$entCustomerCode(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$entCustomerCode());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$entCustType(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$entCustType());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$custId(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$custId());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$billCycle(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$billCycle());
        ((SICustomerInfoModelRealmProxyInterface) realmObject).realmSet$coreSrvcCode(((SICustomerInfoModelRealmProxyInterface) newObject).realmGet$coreSrvcCode());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SICustomerInfoModel = [");
        stringBuilder.append("{apsflTrackId:");
        stringBuilder.append(realmGet$apsflTrackId() != null ? realmGet$apsflTrackId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cafNo:");
        stringBuilder.append(realmGet$cafNo() != null ? realmGet$cafNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{organizationName:");
        stringBuilder.append(realmGet$organizationName() != null ? realmGet$organizationName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameOfContactPersonName:");
        stringBuilder.append(realmGet$nameOfContactPersonName() != null ? realmGet$nameOfContactPersonName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberOfContactPerson:");
        stringBuilder.append(realmGet$numberOfContactPerson() != null ? realmGet$numberOfContactPerson() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instAddress:");
        stringBuilder.append(realmGet$instAddress() != null ? realmGet$instAddress() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cpeDeviceLocation:");
        stringBuilder.append(realmGet$cpeDeviceLocation() != null ? realmGet$cpeDeviceLocation() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instDistName:");
        stringBuilder.append(realmGet$instDistName() != null ? realmGet$instDistName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectedInstDistId:");
        stringBuilder.append(realmGet$selectedInstDistId() != null ? realmGet$selectedInstDistId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instMandalName:");
        stringBuilder.append(realmGet$instMandalName() != null ? realmGet$instMandalName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectedInstMandalId:");
        stringBuilder.append(realmGet$selectedInstMandalId() != null ? realmGet$selectedInstMandalId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instVillageId:");
        stringBuilder.append(realmGet$instVillageId() != null ? realmGet$instVillageId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectedInstVillage:");
        stringBuilder.append(realmGet$selectedInstVillage() != null ? realmGet$selectedInstVillage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{entCustomerCode:");
        stringBuilder.append(realmGet$entCustomerCode() != null ? realmGet$entCustomerCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{entCustType:");
        stringBuilder.append(realmGet$entCustType() != null ? realmGet$entCustType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{custId:");
        stringBuilder.append(realmGet$custId() != null ? realmGet$custId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{billCycle:");
        stringBuilder.append(realmGet$billCycle() != null ? realmGet$billCycle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coreSrvcCode:");
        stringBuilder.append(realmGet$coreSrvcCode() != null ? realmGet$coreSrvcCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
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
        SICustomerInfoModelRealmProxy aSICustomerInfoModel = (SICustomerInfoModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSICustomerInfoModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSICustomerInfoModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSICustomerInfoModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
