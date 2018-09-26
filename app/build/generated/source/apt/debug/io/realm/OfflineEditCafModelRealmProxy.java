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

public class OfflineEditCafModelRealmProxy extends com.app.apsfl.models.OfflineEditCafModel
    implements RealmObjectProxy, OfflineEditCafModelRealmProxyInterface {

    static final class OfflineEditCafModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long apsflTrackIdIndex;
        public long cafNoIndex;
        public long contactPersonMobileNoIndex;
        public long contactPersonNameIndex;
        public long cpeplaceIndex;
        public long instAddress1Index;
        public long fNameIndex;
        public long organizationNameIndex;
        public long instDistIdIndex;
        public long instMandalIdIndex;
        public long packageNamesIndex;
        public long popDistIdIndex;
        public long popMandalIdIndex;
        public long coreServiceCodesIndex;
        public long iptvPackagesIndex;
        public long entCustomerCodeIndex;
        public long entCustTypeIndex;
        public long custIdIndex;
        public long billCycleIndex;

        OfflineEditCafModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(19);
            this.apsflTrackIdIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "apsflTrackId");
            indicesMap.put("apsflTrackId", this.apsflTrackIdIndex);
            this.cafNoIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "cafNo");
            indicesMap.put("cafNo", this.cafNoIndex);
            this.contactPersonMobileNoIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "contactPersonMobileNo");
            indicesMap.put("contactPersonMobileNo", this.contactPersonMobileNoIndex);
            this.contactPersonNameIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "contactPersonName");
            indicesMap.put("contactPersonName", this.contactPersonNameIndex);
            this.cpeplaceIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "cpeplace");
            indicesMap.put("cpeplace", this.cpeplaceIndex);
            this.instAddress1Index = getValidColumnIndex(path, table, "OfflineEditCafModel", "instAddress1");
            indicesMap.put("instAddress1", this.instAddress1Index);
            this.fNameIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "fName");
            indicesMap.put("fName", this.fNameIndex);
            this.organizationNameIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "organizationName");
            indicesMap.put("organizationName", this.organizationNameIndex);
            this.instDistIdIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "instDistId");
            indicesMap.put("instDistId", this.instDistIdIndex);
            this.instMandalIdIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "instMandalId");
            indicesMap.put("instMandalId", this.instMandalIdIndex);
            this.packageNamesIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "packageNames");
            indicesMap.put("packageNames", this.packageNamesIndex);
            this.popDistIdIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "popDistId");
            indicesMap.put("popDistId", this.popDistIdIndex);
            this.popMandalIdIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "popMandalId");
            indicesMap.put("popMandalId", this.popMandalIdIndex);
            this.coreServiceCodesIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "coreServiceCodes");
            indicesMap.put("coreServiceCodes", this.coreServiceCodesIndex);
            this.iptvPackagesIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "iptvPackages");
            indicesMap.put("iptvPackages", this.iptvPackagesIndex);
            this.entCustomerCodeIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "entCustomerCode");
            indicesMap.put("entCustomerCode", this.entCustomerCodeIndex);
            this.entCustTypeIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "entCustType");
            indicesMap.put("entCustType", this.entCustTypeIndex);
            this.custIdIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "custId");
            indicesMap.put("custId", this.custIdIndex);
            this.billCycleIndex = getValidColumnIndex(path, table, "OfflineEditCafModel", "billCycle");
            indicesMap.put("billCycle", this.billCycleIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final OfflineEditCafModelColumnInfo otherInfo = (OfflineEditCafModelColumnInfo) other;
            this.apsflTrackIdIndex = otherInfo.apsflTrackIdIndex;
            this.cafNoIndex = otherInfo.cafNoIndex;
            this.contactPersonMobileNoIndex = otherInfo.contactPersonMobileNoIndex;
            this.contactPersonNameIndex = otherInfo.contactPersonNameIndex;
            this.cpeplaceIndex = otherInfo.cpeplaceIndex;
            this.instAddress1Index = otherInfo.instAddress1Index;
            this.fNameIndex = otherInfo.fNameIndex;
            this.organizationNameIndex = otherInfo.organizationNameIndex;
            this.instDistIdIndex = otherInfo.instDistIdIndex;
            this.instMandalIdIndex = otherInfo.instMandalIdIndex;
            this.packageNamesIndex = otherInfo.packageNamesIndex;
            this.popDistIdIndex = otherInfo.popDistIdIndex;
            this.popMandalIdIndex = otherInfo.popMandalIdIndex;
            this.coreServiceCodesIndex = otherInfo.coreServiceCodesIndex;
            this.iptvPackagesIndex = otherInfo.iptvPackagesIndex;
            this.entCustomerCodeIndex = otherInfo.entCustomerCodeIndex;
            this.entCustTypeIndex = otherInfo.entCustTypeIndex;
            this.custIdIndex = otherInfo.custIdIndex;
            this.billCycleIndex = otherInfo.billCycleIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final OfflineEditCafModelColumnInfo clone() {
            return (OfflineEditCafModelColumnInfo) super.clone();
        }

    }
    private OfflineEditCafModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("apsflTrackId");
        fieldNames.add("cafNo");
        fieldNames.add("contactPersonMobileNo");
        fieldNames.add("contactPersonName");
        fieldNames.add("cpeplace");
        fieldNames.add("instAddress1");
        fieldNames.add("fName");
        fieldNames.add("organizationName");
        fieldNames.add("instDistId");
        fieldNames.add("instMandalId");
        fieldNames.add("packageNames");
        fieldNames.add("popDistId");
        fieldNames.add("popMandalId");
        fieldNames.add("coreServiceCodes");
        fieldNames.add("iptvPackages");
        fieldNames.add("entCustomerCode");
        fieldNames.add("entCustType");
        fieldNames.add("custId");
        fieldNames.add("billCycle");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    OfflineEditCafModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OfflineEditCafModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.OfflineEditCafModel.class, this);
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
    public String realmGet$contactPersonMobileNo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contactPersonMobileNoIndex);
    }

    public void realmSet$contactPersonMobileNo(String value) {
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
                row.getTable().setNull(columnInfo.contactPersonMobileNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contactPersonMobileNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contactPersonMobileNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contactPersonMobileNoIndex, value);
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
    public String realmGet$instAddress1() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instAddress1Index);
    }

    public void realmSet$instAddress1(String value) {
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
                row.getTable().setNull(columnInfo.instAddress1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instAddress1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instAddress1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instAddress1Index, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$fName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fNameIndex);
    }

    public void realmSet$fName(String value) {
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
                row.getTable().setNull(columnInfo.fNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fNameIndex, value);
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
    public String realmGet$instDistId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instDistIdIndex);
    }

    public void realmSet$instDistId(String value) {
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
                row.getTable().setNull(columnInfo.instDistIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instDistIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instDistIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instDistIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$instMandalId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instMandalIdIndex);
    }

    public void realmSet$instMandalId(String value) {
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
                row.getTable().setNull(columnInfo.instMandalIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instMandalIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instMandalIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instMandalIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$packageNames() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.packageNamesIndex);
    }

    public void realmSet$packageNames(String value) {
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
                row.getTable().setNull(columnInfo.packageNamesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.packageNamesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.packageNamesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.packageNamesIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popDistId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popDistIdIndex);
    }

    public void realmSet$popDistId(String value) {
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
                row.getTable().setNull(columnInfo.popDistIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popDistIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popDistIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popDistIdIndex, value);
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
    public String realmGet$coreServiceCodes() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.coreServiceCodesIndex);
    }

    public void realmSet$coreServiceCodes(String value) {
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
                row.getTable().setNull(columnInfo.coreServiceCodesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.coreServiceCodesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.coreServiceCodesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.coreServiceCodesIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvPackages() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvPackagesIndex);
    }

    public void realmSet$iptvPackages(String value) {
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
                row.getTable().setNull(columnInfo.iptvPackagesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iptvPackagesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iptvPackagesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iptvPackagesIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("OfflineEditCafModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("OfflineEditCafModel");
            realmObjectSchema.add(new Property("apsflTrackId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cafNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("contactPersonMobileNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("contactPersonName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeplace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("instAddress1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("fName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("organizationName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("instDistId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("instMandalId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("packageNames", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popDistId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popMandalId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("coreServiceCodes", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvPackages", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("entCustomerCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("entCustType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("custId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("billCycle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("OfflineEditCafModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_OfflineEditCafModel")) {
            Table table = sharedRealm.getTable("class_OfflineEditCafModel");
            table.addColumn(RealmFieldType.STRING, "apsflTrackId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cafNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "contactPersonMobileNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "contactPersonName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeplace", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "instAddress1", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "fName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "organizationName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "instDistId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "instMandalId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "packageNames", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popDistId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popMandalId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "coreServiceCodes", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvPackages", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "entCustomerCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "entCustType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "custId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "billCycle", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("apsflTrackId"));
            table.setPrimaryKey("apsflTrackId");
            return table;
        }
        return sharedRealm.getTable("class_OfflineEditCafModel");
    }

    public static OfflineEditCafModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_OfflineEditCafModel")) {
            Table table = sharedRealm.getTable("class_OfflineEditCafModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 19) {
                if (columnCount < 19) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 19 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 19 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 19 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 19; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final OfflineEditCafModelColumnInfo columnInfo = new OfflineEditCafModelColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("contactPersonMobileNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contactPersonMobileNo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("contactPersonMobileNo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contactPersonMobileNo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.contactPersonMobileNoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contactPersonMobileNo' is required. Either set @Required to field 'contactPersonMobileNo' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("cpeplace")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeplace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeplace") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeplace' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeplaceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeplace' is required. Either set @Required to field 'cpeplace' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("instAddress1")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'instAddress1' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("instAddress1") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'instAddress1' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.instAddress1Index)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'instAddress1' is required. Either set @Required to field 'instAddress1' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("fName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("fName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.fNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fName' is required. Either set @Required to field 'fName' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("instDistId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'instDistId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("instDistId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'instDistId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.instDistIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'instDistId' is required. Either set @Required to field 'instDistId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("instMandalId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'instMandalId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("instMandalId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'instMandalId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.instMandalIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'instMandalId' is required. Either set @Required to field 'instMandalId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("packageNames")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'packageNames' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("packageNames") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'packageNames' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.packageNamesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'packageNames' is required. Either set @Required to field 'packageNames' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popDistId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popDistId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popDistId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popDistId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popDistIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popDistId' is required. Either set @Required to field 'popDistId' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("coreServiceCodes")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'coreServiceCodes' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("coreServiceCodes") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'coreServiceCodes' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.coreServiceCodesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'coreServiceCodes' is required. Either set @Required to field 'coreServiceCodes' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvPackages")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvPackages' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvPackages") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvPackages' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvPackagesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvPackages' is required. Either set @Required to field 'iptvPackages' or migrate using RealmObjectSchema.setNullable().");
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
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'OfflineEditCafModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_OfflineEditCafModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.OfflineEditCafModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.OfflineEditCafModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.OfflineEditCafModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.OfflineEditCafModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.OfflineEditCafModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("apsflTrackId")) {
                if (json.isNull("apsflTrackId")) {
                    obj = (io.realm.OfflineEditCafModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.OfflineEditCafModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.OfflineEditCafModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.OfflineEditCafModel.class, json.getString("apsflTrackId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'apsflTrackId'.");
            }
        }
        if (json.has("cafNo")) {
            if (json.isNull("cafNo")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cafNo(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cafNo((String) json.getString("cafNo"));
            }
        }
        if (json.has("contactPersonMobileNo")) {
            if (json.isNull("contactPersonMobileNo")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonMobileNo(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonMobileNo((String) json.getString("contactPersonMobileNo"));
            }
        }
        if (json.has("contactPersonName")) {
            if (json.isNull("contactPersonName")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonName(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonName((String) json.getString("contactPersonName"));
            }
        }
        if (json.has("cpeplace")) {
            if (json.isNull("cpeplace")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cpeplace(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cpeplace((String) json.getString("cpeplace"));
            }
        }
        if (json.has("instAddress1")) {
            if (json.isNull("instAddress1")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instAddress1(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instAddress1((String) json.getString("instAddress1"));
            }
        }
        if (json.has("fName")) {
            if (json.isNull("fName")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$fName(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$fName((String) json.getString("fName"));
            }
        }
        if (json.has("organizationName")) {
            if (json.isNull("organizationName")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$organizationName(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$organizationName((String) json.getString("organizationName"));
            }
        }
        if (json.has("instDistId")) {
            if (json.isNull("instDistId")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instDistId(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instDistId((String) json.getString("instDistId"));
            }
        }
        if (json.has("instMandalId")) {
            if (json.isNull("instMandalId")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instMandalId(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instMandalId((String) json.getString("instMandalId"));
            }
        }
        if (json.has("packageNames")) {
            if (json.isNull("packageNames")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$packageNames(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$packageNames((String) json.getString("packageNames"));
            }
        }
        if (json.has("popDistId")) {
            if (json.isNull("popDistId")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popDistId(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popDistId((String) json.getString("popDistId"));
            }
        }
        if (json.has("popMandalId")) {
            if (json.isNull("popMandalId")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popMandalId(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popMandalId((String) json.getString("popMandalId"));
            }
        }
        if (json.has("coreServiceCodes")) {
            if (json.isNull("coreServiceCodes")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$coreServiceCodes(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$coreServiceCodes((String) json.getString("coreServiceCodes"));
            }
        }
        if (json.has("iptvPackages")) {
            if (json.isNull("iptvPackages")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$iptvPackages(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$iptvPackages((String) json.getString("iptvPackages"));
            }
        }
        if (json.has("entCustomerCode")) {
            if (json.isNull("entCustomerCode")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustomerCode(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustomerCode((String) json.getString("entCustomerCode"));
            }
        }
        if (json.has("entCustType")) {
            if (json.isNull("entCustType")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustType(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustType((String) json.getString("entCustType"));
            }
        }
        if (json.has("custId")) {
            if (json.isNull("custId")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$custId(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$custId((String) json.getString("custId"));
            }
        }
        if (json.has("billCycle")) {
            if (json.isNull("billCycle")) {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$billCycle(null);
            } else {
                ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$billCycle((String) json.getString("billCycle"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.OfflineEditCafModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.OfflineEditCafModel obj = new com.app.apsfl.models.OfflineEditCafModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("apsflTrackId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$apsflTrackId(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$apsflTrackId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("cafNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cafNo(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cafNo((String) reader.nextString());
                }
            } else if (name.equals("contactPersonMobileNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonMobileNo(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonMobileNo((String) reader.nextString());
                }
            } else if (name.equals("contactPersonName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonName(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$contactPersonName((String) reader.nextString());
                }
            } else if (name.equals("cpeplace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cpeplace(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$cpeplace((String) reader.nextString());
                }
            } else if (name.equals("instAddress1")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instAddress1(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instAddress1((String) reader.nextString());
                }
            } else if (name.equals("fName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$fName(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$fName((String) reader.nextString());
                }
            } else if (name.equals("organizationName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$organizationName(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$organizationName((String) reader.nextString());
                }
            } else if (name.equals("instDistId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instDistId(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instDistId((String) reader.nextString());
                }
            } else if (name.equals("instMandalId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instMandalId(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$instMandalId((String) reader.nextString());
                }
            } else if (name.equals("packageNames")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$packageNames(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$packageNames((String) reader.nextString());
                }
            } else if (name.equals("popDistId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popDistId(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popDistId((String) reader.nextString());
                }
            } else if (name.equals("popMandalId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popMandalId(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$popMandalId((String) reader.nextString());
                }
            } else if (name.equals("coreServiceCodes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$coreServiceCodes(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$coreServiceCodes((String) reader.nextString());
                }
            } else if (name.equals("iptvPackages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$iptvPackages(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$iptvPackages((String) reader.nextString());
                }
            } else if (name.equals("entCustomerCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustomerCode(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustomerCode((String) reader.nextString());
                }
            } else if (name.equals("entCustType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustType(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$entCustType((String) reader.nextString());
                }
            } else if (name.equals("custId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$custId(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$custId((String) reader.nextString());
                }
            } else if (name.equals("billCycle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$billCycle(null);
                } else {
                    ((OfflineEditCafModelRealmProxyInterface) obj).realmSet$billCycle((String) reader.nextString());
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

    public static com.app.apsfl.models.OfflineEditCafModel copyOrUpdate(Realm realm, com.app.apsfl.models.OfflineEditCafModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.OfflineEditCafModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.OfflineEditCafModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.OfflineEditCafModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((OfflineEditCafModelRealmProxyInterface) object).realmGet$apsflTrackId();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.OfflineEditCafModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.OfflineEditCafModelRealmProxy();
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

    public static com.app.apsfl.models.OfflineEditCafModel copy(Realm realm, com.app.apsfl.models.OfflineEditCafModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.OfflineEditCafModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.OfflineEditCafModel realmObject = realm.createObjectInternal(com.app.apsfl.models.OfflineEditCafModel.class, ((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$apsflTrackId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$cafNo(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$cafNo());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$contactPersonMobileNo(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$contactPersonMobileNo());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$contactPersonName(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$contactPersonName());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$cpeplace(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$cpeplace());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$instAddress1(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$instAddress1());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$fName(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$fName());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$organizationName(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$organizationName());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$instDistId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$instDistId());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$instMandalId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$instMandalId());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$packageNames(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$packageNames());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$popDistId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$popDistId());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$popMandalId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$popMandalId());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$coreServiceCodes(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$coreServiceCodes());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$iptvPackages(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$iptvPackages());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$entCustomerCode(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$entCustomerCode());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$entCustType(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$entCustType());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$custId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$custId());
            ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$billCycle(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$billCycle());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.OfflineEditCafModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.OfflineEditCafModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineEditCafModelColumnInfo columnInfo = (OfflineEditCafModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineEditCafModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((OfflineEditCafModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
        String realmGet$cafNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cafNo();
        if (realmGet$cafNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
        }
        String realmGet$contactPersonMobileNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonMobileNo();
        if (realmGet$contactPersonMobileNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactPersonMobileNoIndex, rowIndex, realmGet$contactPersonMobileNo, false);
        }
        String realmGet$contactPersonName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonName();
        if (realmGet$contactPersonName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
        }
        String realmGet$cpeplace = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cpeplace();
        if (realmGet$cpeplace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
        }
        String realmGet$instAddress1 = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instAddress1();
        if (realmGet$instAddress1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instAddress1Index, rowIndex, realmGet$instAddress1, false);
        }
        String realmGet$fName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$fName();
        if (realmGet$fName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fNameIndex, rowIndex, realmGet$fName, false);
        }
        String realmGet$organizationName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$organizationName();
        if (realmGet$organizationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
        }
        String realmGet$instDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instDistId();
        if (realmGet$instDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instDistIdIndex, rowIndex, realmGet$instDistId, false);
        }
        String realmGet$instMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instMandalId();
        if (realmGet$instMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instMandalIdIndex, rowIndex, realmGet$instMandalId, false);
        }
        String realmGet$packageNames = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$packageNames();
        if (realmGet$packageNames != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.packageNamesIndex, rowIndex, realmGet$packageNames, false);
        }
        String realmGet$popDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popDistId();
        if (realmGet$popDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
        }
        String realmGet$popMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popMandalId();
        if (realmGet$popMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
        }
        String realmGet$coreServiceCodes = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$coreServiceCodes();
        if (realmGet$coreServiceCodes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodesIndex, rowIndex, realmGet$coreServiceCodes, false);
        }
        String realmGet$iptvPackages = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$iptvPackages();
        if (realmGet$iptvPackages != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
        }
        String realmGet$entCustomerCode = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustomerCode();
        if (realmGet$entCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
        }
        String realmGet$entCustType = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustType();
        if (realmGet$entCustType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
        }
        String realmGet$custId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$custId();
        if (realmGet$custId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
        }
        String realmGet$billCycle = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$billCycle();
        if (realmGet$billCycle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.OfflineEditCafModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineEditCafModelColumnInfo columnInfo = (OfflineEditCafModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineEditCafModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.OfflineEditCafModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.OfflineEditCafModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((OfflineEditCafModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
                String realmGet$cafNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cafNo();
                if (realmGet$cafNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
                }
                String realmGet$contactPersonMobileNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonMobileNo();
                if (realmGet$contactPersonMobileNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactPersonMobileNoIndex, rowIndex, realmGet$contactPersonMobileNo, false);
                }
                String realmGet$contactPersonName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonName();
                if (realmGet$contactPersonName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
                }
                String realmGet$cpeplace = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cpeplace();
                if (realmGet$cpeplace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
                }
                String realmGet$instAddress1 = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instAddress1();
                if (realmGet$instAddress1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instAddress1Index, rowIndex, realmGet$instAddress1, false);
                }
                String realmGet$fName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$fName();
                if (realmGet$fName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fNameIndex, rowIndex, realmGet$fName, false);
                }
                String realmGet$organizationName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$organizationName();
                if (realmGet$organizationName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
                }
                String realmGet$instDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instDistId();
                if (realmGet$instDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instDistIdIndex, rowIndex, realmGet$instDistId, false);
                }
                String realmGet$instMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instMandalId();
                if (realmGet$instMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instMandalIdIndex, rowIndex, realmGet$instMandalId, false);
                }
                String realmGet$packageNames = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$packageNames();
                if (realmGet$packageNames != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.packageNamesIndex, rowIndex, realmGet$packageNames, false);
                }
                String realmGet$popDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popDistId();
                if (realmGet$popDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
                }
                String realmGet$popMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popMandalId();
                if (realmGet$popMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
                }
                String realmGet$coreServiceCodes = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$coreServiceCodes();
                if (realmGet$coreServiceCodes != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodesIndex, rowIndex, realmGet$coreServiceCodes, false);
                }
                String realmGet$iptvPackages = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$iptvPackages();
                if (realmGet$iptvPackages != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
                }
                String realmGet$entCustomerCode = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustomerCode();
                if (realmGet$entCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
                }
                String realmGet$entCustType = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustType();
                if (realmGet$entCustType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
                }
                String realmGet$custId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$custId();
                if (realmGet$custId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
                }
                String realmGet$billCycle = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$billCycle();
                if (realmGet$billCycle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.OfflineEditCafModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.OfflineEditCafModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineEditCafModelColumnInfo columnInfo = (OfflineEditCafModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineEditCafModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((OfflineEditCafModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
        String realmGet$cafNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cafNo();
        if (realmGet$cafNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cafNoIndex, rowIndex, false);
        }
        String realmGet$contactPersonMobileNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonMobileNo();
        if (realmGet$contactPersonMobileNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactPersonMobileNoIndex, rowIndex, realmGet$contactPersonMobileNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contactPersonMobileNoIndex, rowIndex, false);
        }
        String realmGet$contactPersonName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonName();
        if (realmGet$contactPersonName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, false);
        }
        String realmGet$cpeplace = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cpeplace();
        if (realmGet$cpeplace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, false);
        }
        String realmGet$instAddress1 = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instAddress1();
        if (realmGet$instAddress1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instAddress1Index, rowIndex, realmGet$instAddress1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instAddress1Index, rowIndex, false);
        }
        String realmGet$fName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$fName();
        if (realmGet$fName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fNameIndex, rowIndex, realmGet$fName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fNameIndex, rowIndex, false);
        }
        String realmGet$organizationName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$organizationName();
        if (realmGet$organizationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, false);
        }
        String realmGet$instDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instDistId();
        if (realmGet$instDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instDistIdIndex, rowIndex, realmGet$instDistId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instDistIdIndex, rowIndex, false);
        }
        String realmGet$instMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instMandalId();
        if (realmGet$instMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instMandalIdIndex, rowIndex, realmGet$instMandalId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instMandalIdIndex, rowIndex, false);
        }
        String realmGet$packageNames = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$packageNames();
        if (realmGet$packageNames != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.packageNamesIndex, rowIndex, realmGet$packageNames, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.packageNamesIndex, rowIndex, false);
        }
        String realmGet$popDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popDistId();
        if (realmGet$popDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, false);
        }
        String realmGet$popMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popMandalId();
        if (realmGet$popMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, false);
        }
        String realmGet$coreServiceCodes = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$coreServiceCodes();
        if (realmGet$coreServiceCodes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodesIndex, rowIndex, realmGet$coreServiceCodes, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coreServiceCodesIndex, rowIndex, false);
        }
        String realmGet$iptvPackages = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$iptvPackages();
        if (realmGet$iptvPackages != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, false);
        }
        String realmGet$entCustomerCode = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustomerCode();
        if (realmGet$entCustomerCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, false);
        }
        String realmGet$entCustType = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustType();
        if (realmGet$entCustType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, false);
        }
        String realmGet$custId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$custId();
        if (realmGet$custId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.custIdIndex, rowIndex, false);
        }
        String realmGet$billCycle = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$billCycle();
        if (realmGet$billCycle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.billCycleIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.OfflineEditCafModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        OfflineEditCafModelColumnInfo columnInfo = (OfflineEditCafModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OfflineEditCafModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.OfflineEditCafModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.OfflineEditCafModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((OfflineEditCafModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
                String realmGet$cafNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cafNo();
                if (realmGet$cafNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafNoIndex, rowIndex, realmGet$cafNo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cafNoIndex, rowIndex, false);
                }
                String realmGet$contactPersonMobileNo = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonMobileNo();
                if (realmGet$contactPersonMobileNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactPersonMobileNoIndex, rowIndex, realmGet$contactPersonMobileNo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contactPersonMobileNoIndex, rowIndex, false);
                }
                String realmGet$contactPersonName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$contactPersonName();
                if (realmGet$contactPersonName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, realmGet$contactPersonName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contactPersonNameIndex, rowIndex, false);
                }
                String realmGet$cpeplace = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$cpeplace();
                if (realmGet$cpeplace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, realmGet$cpeplace, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeplaceIndex, rowIndex, false);
                }
                String realmGet$instAddress1 = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instAddress1();
                if (realmGet$instAddress1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instAddress1Index, rowIndex, realmGet$instAddress1, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.instAddress1Index, rowIndex, false);
                }
                String realmGet$fName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$fName();
                if (realmGet$fName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fNameIndex, rowIndex, realmGet$fName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fNameIndex, rowIndex, false);
                }
                String realmGet$organizationName = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$organizationName();
                if (realmGet$organizationName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, false);
                }
                String realmGet$instDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instDistId();
                if (realmGet$instDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instDistIdIndex, rowIndex, realmGet$instDistId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.instDistIdIndex, rowIndex, false);
                }
                String realmGet$instMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$instMandalId();
                if (realmGet$instMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.instMandalIdIndex, rowIndex, realmGet$instMandalId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.instMandalIdIndex, rowIndex, false);
                }
                String realmGet$packageNames = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$packageNames();
                if (realmGet$packageNames != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.packageNamesIndex, rowIndex, realmGet$packageNames, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.packageNamesIndex, rowIndex, false);
                }
                String realmGet$popDistId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popDistId();
                if (realmGet$popDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, false);
                }
                String realmGet$popMandalId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$popMandalId();
                if (realmGet$popMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, false);
                }
                String realmGet$coreServiceCodes = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$coreServiceCodes();
                if (realmGet$coreServiceCodes != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodesIndex, rowIndex, realmGet$coreServiceCodes, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.coreServiceCodesIndex, rowIndex, false);
                }
                String realmGet$iptvPackages = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$iptvPackages();
                if (realmGet$iptvPackages != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, false);
                }
                String realmGet$entCustomerCode = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustomerCode();
                if (realmGet$entCustomerCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, realmGet$entCustomerCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.entCustomerCodeIndex, rowIndex, false);
                }
                String realmGet$entCustType = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$entCustType();
                if (realmGet$entCustType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, realmGet$entCustType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.entCustTypeIndex, rowIndex, false);
                }
                String realmGet$custId = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$custId();
                if (realmGet$custId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.custIdIndex, rowIndex, realmGet$custId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.custIdIndex, rowIndex, false);
                }
                String realmGet$billCycle = ((OfflineEditCafModelRealmProxyInterface)object).realmGet$billCycle();
                if (realmGet$billCycle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billCycleIndex, rowIndex, realmGet$billCycle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.billCycleIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.OfflineEditCafModel createDetachedCopy(com.app.apsfl.models.OfflineEditCafModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.OfflineEditCafModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.OfflineEditCafModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.OfflineEditCafModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.OfflineEditCafModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$apsflTrackId(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$apsflTrackId());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$cafNo(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$cafNo());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$contactPersonMobileNo(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$contactPersonMobileNo());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$contactPersonName(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$contactPersonName());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$cpeplace(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$cpeplace());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$instAddress1(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$instAddress1());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$fName(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$fName());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$organizationName(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$organizationName());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$instDistId(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$instDistId());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$instMandalId(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$instMandalId());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$packageNames(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$packageNames());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$popDistId(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$popDistId());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$popMandalId(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$popMandalId());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$coreServiceCodes(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$coreServiceCodes());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$iptvPackages(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$iptvPackages());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$entCustomerCode(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$entCustomerCode());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$entCustType(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$entCustType());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$custId(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$custId());
        ((OfflineEditCafModelRealmProxyInterface) unmanagedObject).realmSet$billCycle(((OfflineEditCafModelRealmProxyInterface) realmObject).realmGet$billCycle());
        return unmanagedObject;
    }

    static com.app.apsfl.models.OfflineEditCafModel update(Realm realm, com.app.apsfl.models.OfflineEditCafModel realmObject, com.app.apsfl.models.OfflineEditCafModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$cafNo(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$cafNo());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$contactPersonMobileNo(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$contactPersonMobileNo());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$contactPersonName(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$contactPersonName());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$cpeplace(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$cpeplace());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$instAddress1(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$instAddress1());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$fName(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$fName());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$organizationName(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$organizationName());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$instDistId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$instDistId());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$instMandalId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$instMandalId());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$packageNames(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$packageNames());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$popDistId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$popDistId());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$popMandalId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$popMandalId());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$coreServiceCodes(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$coreServiceCodes());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$iptvPackages(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$iptvPackages());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$entCustomerCode(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$entCustomerCode());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$entCustType(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$entCustType());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$custId(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$custId());
        ((OfflineEditCafModelRealmProxyInterface) realmObject).realmSet$billCycle(((OfflineEditCafModelRealmProxyInterface) newObject).realmGet$billCycle());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("OfflineEditCafModel = [");
        stringBuilder.append("{apsflTrackId:");
        stringBuilder.append(realmGet$apsflTrackId() != null ? realmGet$apsflTrackId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cafNo:");
        stringBuilder.append(realmGet$cafNo() != null ? realmGet$cafNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contactPersonMobileNo:");
        stringBuilder.append(realmGet$contactPersonMobileNo() != null ? realmGet$contactPersonMobileNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contactPersonName:");
        stringBuilder.append(realmGet$contactPersonName() != null ? realmGet$contactPersonName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cpeplace:");
        stringBuilder.append(realmGet$cpeplace() != null ? realmGet$cpeplace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instAddress1:");
        stringBuilder.append(realmGet$instAddress1() != null ? realmGet$instAddress1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fName:");
        stringBuilder.append(realmGet$fName() != null ? realmGet$fName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{organizationName:");
        stringBuilder.append(realmGet$organizationName() != null ? realmGet$organizationName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instDistId:");
        stringBuilder.append(realmGet$instDistId() != null ? realmGet$instDistId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instMandalId:");
        stringBuilder.append(realmGet$instMandalId() != null ? realmGet$instMandalId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{packageNames:");
        stringBuilder.append(realmGet$packageNames() != null ? realmGet$packageNames() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popDistId:");
        stringBuilder.append(realmGet$popDistId() != null ? realmGet$popDistId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popMandalId:");
        stringBuilder.append(realmGet$popMandalId() != null ? realmGet$popMandalId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coreServiceCodes:");
        stringBuilder.append(realmGet$coreServiceCodes() != null ? realmGet$coreServiceCodes() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iptvPackages:");
        stringBuilder.append(realmGet$iptvPackages() != null ? realmGet$iptvPackages() : "null");
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
        OfflineEditCafModelRealmProxy aOfflineEditCafModel = (OfflineEditCafModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aOfflineEditCafModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOfflineEditCafModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aOfflineEditCafModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
