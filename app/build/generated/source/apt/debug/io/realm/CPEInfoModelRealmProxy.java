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

public class CPEInfoModelRealmProxy extends com.app.apsfl.models.CPEInfoModel
    implements RealmObjectProxy, CPEInfoModelRealmProxyInterface {

    static final class CPEInfoModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long formTimeIndex;
        public long cpePOPNameIndex;
        public long cpeOLTIDPositionIndex;
        public long cpeOLTPortIDPositionIndex;
        public long cpeLevel1SlotPositionIndex;
        public long cpeLevel2SlotPositionIndex;
        public long cpeLevel3SlotPositionIndex;
        public long onuModelPositionIndex;
        public long onuDevicePurchasePositionIndex;
        public long vpnSpinnerPositionIndex;
        public long VpnServiceNameIndex;
        public long noOfOnuInstallmentsIndex;
        public long onuPriceForInstallmentIndex;
        public long onuInstallationChargeIndex;
        public long installationTaxIndex;
        public long onuSerialNumberIndex;
        public long onuMacAddressIndex;
        public long cpeExtraCableChargeIndex;
        public long teleConnCountPositionIndex;
        public long iptvConnCountPositionIndex;
        public long onuModelIndex;
        public long onuTaxIndex;
        public long onuUpfrontEmountIndex;
        public long selectedIptvListIndex;

        CPEInfoModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(24);
            this.formTimeIndex = getValidColumnIndex(path, table, "CPEInfoModel", "formTime");
            indicesMap.put("formTime", this.formTimeIndex);
            this.cpePOPNameIndex = getValidColumnIndex(path, table, "CPEInfoModel", "cpePOPName");
            indicesMap.put("cpePOPName", this.cpePOPNameIndex);
            this.cpeOLTIDPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "cpeOLTIDPosition");
            indicesMap.put("cpeOLTIDPosition", this.cpeOLTIDPositionIndex);
            this.cpeOLTPortIDPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "cpeOLTPortIDPosition");
            indicesMap.put("cpeOLTPortIDPosition", this.cpeOLTPortIDPositionIndex);
            this.cpeLevel1SlotPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "cpeLevel1SlotPosition");
            indicesMap.put("cpeLevel1SlotPosition", this.cpeLevel1SlotPositionIndex);
            this.cpeLevel2SlotPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "cpeLevel2SlotPosition");
            indicesMap.put("cpeLevel2SlotPosition", this.cpeLevel2SlotPositionIndex);
            this.cpeLevel3SlotPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "cpeLevel3SlotPosition");
            indicesMap.put("cpeLevel3SlotPosition", this.cpeLevel3SlotPositionIndex);
            this.onuModelPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuModelPosition");
            indicesMap.put("onuModelPosition", this.onuModelPositionIndex);
            this.onuDevicePurchasePositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuDevicePurchasePosition");
            indicesMap.put("onuDevicePurchasePosition", this.onuDevicePurchasePositionIndex);
            this.vpnSpinnerPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "vpnSpinnerPosition");
            indicesMap.put("vpnSpinnerPosition", this.vpnSpinnerPositionIndex);
            this.VpnServiceNameIndex = getValidColumnIndex(path, table, "CPEInfoModel", "VpnServiceName");
            indicesMap.put("VpnServiceName", this.VpnServiceNameIndex);
            this.noOfOnuInstallmentsIndex = getValidColumnIndex(path, table, "CPEInfoModel", "noOfOnuInstallments");
            indicesMap.put("noOfOnuInstallments", this.noOfOnuInstallmentsIndex);
            this.onuPriceForInstallmentIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuPriceForInstallment");
            indicesMap.put("onuPriceForInstallment", this.onuPriceForInstallmentIndex);
            this.onuInstallationChargeIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuInstallationCharge");
            indicesMap.put("onuInstallationCharge", this.onuInstallationChargeIndex);
            this.installationTaxIndex = getValidColumnIndex(path, table, "CPEInfoModel", "installationTax");
            indicesMap.put("installationTax", this.installationTaxIndex);
            this.onuSerialNumberIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuSerialNumber");
            indicesMap.put("onuSerialNumber", this.onuSerialNumberIndex);
            this.onuMacAddressIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuMacAddress");
            indicesMap.put("onuMacAddress", this.onuMacAddressIndex);
            this.cpeExtraCableChargeIndex = getValidColumnIndex(path, table, "CPEInfoModel", "cpeExtraCableCharge");
            indicesMap.put("cpeExtraCableCharge", this.cpeExtraCableChargeIndex);
            this.teleConnCountPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "teleConnCountPosition");
            indicesMap.put("teleConnCountPosition", this.teleConnCountPositionIndex);
            this.iptvConnCountPositionIndex = getValidColumnIndex(path, table, "CPEInfoModel", "iptvConnCountPosition");
            indicesMap.put("iptvConnCountPosition", this.iptvConnCountPositionIndex);
            this.onuModelIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuModel");
            indicesMap.put("onuModel", this.onuModelIndex);
            this.onuTaxIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuTax");
            indicesMap.put("onuTax", this.onuTaxIndex);
            this.onuUpfrontEmountIndex = getValidColumnIndex(path, table, "CPEInfoModel", "onuUpfrontEmount");
            indicesMap.put("onuUpfrontEmount", this.onuUpfrontEmountIndex);
            this.selectedIptvListIndex = getValidColumnIndex(path, table, "CPEInfoModel", "selectedIptvList");
            indicesMap.put("selectedIptvList", this.selectedIptvListIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CPEInfoModelColumnInfo otherInfo = (CPEInfoModelColumnInfo) other;
            this.formTimeIndex = otherInfo.formTimeIndex;
            this.cpePOPNameIndex = otherInfo.cpePOPNameIndex;
            this.cpeOLTIDPositionIndex = otherInfo.cpeOLTIDPositionIndex;
            this.cpeOLTPortIDPositionIndex = otherInfo.cpeOLTPortIDPositionIndex;
            this.cpeLevel1SlotPositionIndex = otherInfo.cpeLevel1SlotPositionIndex;
            this.cpeLevel2SlotPositionIndex = otherInfo.cpeLevel2SlotPositionIndex;
            this.cpeLevel3SlotPositionIndex = otherInfo.cpeLevel3SlotPositionIndex;
            this.onuModelPositionIndex = otherInfo.onuModelPositionIndex;
            this.onuDevicePurchasePositionIndex = otherInfo.onuDevicePurchasePositionIndex;
            this.vpnSpinnerPositionIndex = otherInfo.vpnSpinnerPositionIndex;
            this.VpnServiceNameIndex = otherInfo.VpnServiceNameIndex;
            this.noOfOnuInstallmentsIndex = otherInfo.noOfOnuInstallmentsIndex;
            this.onuPriceForInstallmentIndex = otherInfo.onuPriceForInstallmentIndex;
            this.onuInstallationChargeIndex = otherInfo.onuInstallationChargeIndex;
            this.installationTaxIndex = otherInfo.installationTaxIndex;
            this.onuSerialNumberIndex = otherInfo.onuSerialNumberIndex;
            this.onuMacAddressIndex = otherInfo.onuMacAddressIndex;
            this.cpeExtraCableChargeIndex = otherInfo.cpeExtraCableChargeIndex;
            this.teleConnCountPositionIndex = otherInfo.teleConnCountPositionIndex;
            this.iptvConnCountPositionIndex = otherInfo.iptvConnCountPositionIndex;
            this.onuModelIndex = otherInfo.onuModelIndex;
            this.onuTaxIndex = otherInfo.onuTaxIndex;
            this.onuUpfrontEmountIndex = otherInfo.onuUpfrontEmountIndex;
            this.selectedIptvListIndex = otherInfo.selectedIptvListIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CPEInfoModelColumnInfo clone() {
            return (CPEInfoModelColumnInfo) super.clone();
        }

    }
    private CPEInfoModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("formTime");
        fieldNames.add("cpePOPName");
        fieldNames.add("cpeOLTIDPosition");
        fieldNames.add("cpeOLTPortIDPosition");
        fieldNames.add("cpeLevel1SlotPosition");
        fieldNames.add("cpeLevel2SlotPosition");
        fieldNames.add("cpeLevel3SlotPosition");
        fieldNames.add("onuModelPosition");
        fieldNames.add("onuDevicePurchasePosition");
        fieldNames.add("vpnSpinnerPosition");
        fieldNames.add("VpnServiceName");
        fieldNames.add("noOfOnuInstallments");
        fieldNames.add("onuPriceForInstallment");
        fieldNames.add("onuInstallationCharge");
        fieldNames.add("installationTax");
        fieldNames.add("onuSerialNumber");
        fieldNames.add("onuMacAddress");
        fieldNames.add("cpeExtraCableCharge");
        fieldNames.add("teleConnCountPosition");
        fieldNames.add("iptvConnCountPosition");
        fieldNames.add("onuModel");
        fieldNames.add("onuTax");
        fieldNames.add("onuUpfrontEmount");
        fieldNames.add("selectedIptvList");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CPEInfoModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CPEInfoModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.CPEInfoModel.class, this);
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
    public String realmGet$cpePOPName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpePOPNameIndex);
    }

    public void realmSet$cpePOPName(String value) {
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
                row.getTable().setNull(columnInfo.cpePOPNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpePOPNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpePOPNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpePOPNameIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cpeOLTIDPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cpeOLTIDPositionIndex);
    }

    public void realmSet$cpeOLTIDPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cpeOLTIDPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cpeOLTIDPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cpeOLTPortIDPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cpeOLTPortIDPositionIndex);
    }

    public void realmSet$cpeOLTPortIDPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cpeOLTPortIDPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cpeOLTPortIDPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cpeLevel1SlotPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cpeLevel1SlotPositionIndex);
    }

    public void realmSet$cpeLevel1SlotPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cpeLevel1SlotPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cpeLevel1SlotPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cpeLevel2SlotPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cpeLevel2SlotPositionIndex);
    }

    public void realmSet$cpeLevel2SlotPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cpeLevel2SlotPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cpeLevel2SlotPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cpeLevel3SlotPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cpeLevel3SlotPositionIndex);
    }

    public void realmSet$cpeLevel3SlotPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cpeLevel3SlotPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cpeLevel3SlotPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$onuModelPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.onuModelPositionIndex);
    }

    public void realmSet$onuModelPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.onuModelPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.onuModelPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$onuDevicePurchasePosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.onuDevicePurchasePositionIndex);
    }

    public void realmSet$onuDevicePurchasePosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.onuDevicePurchasePositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.onuDevicePurchasePositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$vpnSpinnerPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.vpnSpinnerPositionIndex);
    }

    public void realmSet$vpnSpinnerPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.vpnSpinnerPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.vpnSpinnerPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$VpnServiceName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VpnServiceNameIndex);
    }

    public void realmSet$VpnServiceName(String value) {
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
                row.getTable().setNull(columnInfo.VpnServiceNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.VpnServiceNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.VpnServiceNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.VpnServiceNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$noOfOnuInstallments() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.noOfOnuInstallmentsIndex);
    }

    public void realmSet$noOfOnuInstallments(String value) {
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
                row.getTable().setNull(columnInfo.noOfOnuInstallmentsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.noOfOnuInstallmentsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.noOfOnuInstallmentsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.noOfOnuInstallmentsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$onuPriceForInstallment() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuPriceForInstallmentIndex);
    }

    public void realmSet$onuPriceForInstallment(String value) {
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
                row.getTable().setNull(columnInfo.onuPriceForInstallmentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuPriceForInstallmentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuPriceForInstallmentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuPriceForInstallmentIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$onuInstallationCharge() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuInstallationChargeIndex);
    }

    public void realmSet$onuInstallationCharge(String value) {
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
                row.getTable().setNull(columnInfo.onuInstallationChargeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuInstallationChargeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuInstallationChargeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuInstallationChargeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$installationTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.installationTaxIndex);
    }

    public void realmSet$installationTax(String value) {
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
                row.getTable().setNull(columnInfo.installationTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.installationTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.installationTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.installationTaxIndex, value);
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
    public String realmGet$onuMacAddress() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuMacAddressIndex);
    }

    public void realmSet$onuMacAddress(String value) {
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
                row.getTable().setNull(columnInfo.onuMacAddressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuMacAddressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuMacAddressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuMacAddressIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeExtraCableCharge() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeExtraCableChargeIndex);
    }

    public void realmSet$cpeExtraCableCharge(String value) {
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
                row.getTable().setNull(columnInfo.cpeExtraCableChargeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeExtraCableChargeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeExtraCableChargeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeExtraCableChargeIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$teleConnCountPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.teleConnCountPositionIndex);
    }

    public void realmSet$teleConnCountPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.teleConnCountPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.teleConnCountPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$iptvConnCountPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.iptvConnCountPositionIndex);
    }

    public void realmSet$iptvConnCountPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.iptvConnCountPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.iptvConnCountPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$onuModel() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuModelIndex);
    }

    public void realmSet$onuModel(String value) {
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
                row.getTable().setNull(columnInfo.onuModelIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuModelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuModelIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuModelIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$onuTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuTaxIndex);
    }

    public void realmSet$onuTax(String value) {
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
                row.getTable().setNull(columnInfo.onuTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuTaxIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$onuUpfrontEmount() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuUpfrontEmountIndex);
    }

    public void realmSet$onuUpfrontEmount(String value) {
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
                row.getTable().setNull(columnInfo.onuUpfrontEmountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuUpfrontEmountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuUpfrontEmountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuUpfrontEmountIndex, value);
    }

    public RealmList<com.app.apsfl.models.IptvDataModel> realmGet$selectedIptvList() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (selectedIptvListRealmList != null) {
            return selectedIptvListRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.selectedIptvListIndex);
            selectedIptvListRealmList = new RealmList<com.app.apsfl.models.IptvDataModel>(com.app.apsfl.models.IptvDataModel.class, linkView, proxyState.getRealm$realm());
            return selectedIptvListRealmList;
        }
    }

    public void realmSet$selectedIptvList(RealmList<com.app.apsfl.models.IptvDataModel> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("selectedIptvList")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.app.apsfl.models.IptvDataModel> original = value;
                value = new RealmList<com.app.apsfl.models.IptvDataModel>();
                for (com.app.apsfl.models.IptvDataModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.selectedIptvListIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CPEInfoModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CPEInfoModel");
            realmObjectSchema.add(new Property("formTime", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpePOPName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeOLTIDPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeOLTPortIDPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeLevel1SlotPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeLevel2SlotPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeLevel3SlotPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("onuModelPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("onuDevicePurchasePosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("vpnSpinnerPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("VpnServiceName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("noOfOnuInstallments", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("onuPriceForInstallment", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("onuInstallationCharge", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("installationTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("onuSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("onuMacAddress", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeExtraCableCharge", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("teleConnCountPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvConnCountPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("onuModel", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("onuTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("onuUpfrontEmount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("IptvDataModel")) {
                IptvDataModelRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("selectedIptvList", RealmFieldType.LIST, realmSchema.get("IptvDataModel")));
            return realmObjectSchema;
        }
        return realmSchema.get("CPEInfoModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CPEInfoModel")) {
            Table table = sharedRealm.getTable("class_CPEInfoModel");
            table.addColumn(RealmFieldType.INTEGER, "formTime", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpePOPName", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cpeOLTIDPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cpeOLTPortIDPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cpeLevel1SlotPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cpeLevel2SlotPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cpeLevel3SlotPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "onuModelPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "onuDevicePurchasePosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "vpnSpinnerPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "VpnServiceName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "noOfOnuInstallments", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuPriceForInstallment", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuInstallationCharge", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "installationTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuMacAddress", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeExtraCableCharge", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "teleConnCountPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "iptvConnCountPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuModel", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuUpfrontEmount", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_IptvDataModel")) {
                IptvDataModelRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "selectedIptvList", sharedRealm.getTable("class_IptvDataModel"));
            table.addSearchIndex(table.getColumnIndex("formTime"));
            table.setPrimaryKey("formTime");
            return table;
        }
        return sharedRealm.getTable("class_CPEInfoModel");
    }

    public static CPEInfoModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CPEInfoModel")) {
            Table table = sharedRealm.getTable("class_CPEInfoModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 24) {
                if (columnCount < 24) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 24 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 24 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 24 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 24; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CPEInfoModelColumnInfo columnInfo = new CPEInfoModelColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("cpePOPName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpePOPName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpePOPName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpePOPName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpePOPNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpePOPName' is required. Either set @Required to field 'cpePOPName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeOLTIDPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeOLTIDPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeOLTIDPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cpeOLTIDPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cpeOLTIDPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeOLTIDPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'cpeOLTIDPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeOLTPortIDPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeOLTPortIDPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeOLTPortIDPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cpeOLTPortIDPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cpeOLTPortIDPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeOLTPortIDPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'cpeOLTPortIDPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeLevel1SlotPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeLevel1SlotPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeLevel1SlotPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cpeLevel1SlotPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cpeLevel1SlotPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeLevel1SlotPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'cpeLevel1SlotPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeLevel2SlotPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeLevel2SlotPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeLevel2SlotPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cpeLevel2SlotPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cpeLevel2SlotPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeLevel2SlotPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'cpeLevel2SlotPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeLevel3SlotPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeLevel3SlotPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeLevel3SlotPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cpeLevel3SlotPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cpeLevel3SlotPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeLevel3SlotPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'cpeLevel3SlotPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuModelPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuModelPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuModelPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'onuModelPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.onuModelPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuModelPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'onuModelPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuDevicePurchasePosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuDevicePurchasePosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuDevicePurchasePosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'onuDevicePurchasePosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.onuDevicePurchasePositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuDevicePurchasePosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'onuDevicePurchasePosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("vpnSpinnerPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'vpnSpinnerPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("vpnSpinnerPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'vpnSpinnerPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.vpnSpinnerPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'vpnSpinnerPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'vpnSpinnerPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("VpnServiceName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'VpnServiceName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("VpnServiceName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'VpnServiceName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.VpnServiceNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'VpnServiceName' is required. Either set @Required to field 'VpnServiceName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("noOfOnuInstallments")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'noOfOnuInstallments' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("noOfOnuInstallments") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'noOfOnuInstallments' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.noOfOnuInstallmentsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'noOfOnuInstallments' is required. Either set @Required to field 'noOfOnuInstallments' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuPriceForInstallment")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuPriceForInstallment' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuPriceForInstallment") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuPriceForInstallment' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuPriceForInstallmentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuPriceForInstallment' is required. Either set @Required to field 'onuPriceForInstallment' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuInstallationCharge")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuInstallationCharge' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuInstallationCharge") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuInstallationCharge' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuInstallationChargeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuInstallationCharge' is required. Either set @Required to field 'onuInstallationCharge' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("installationTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'installationTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("installationTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'installationTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.installationTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'installationTax' is required. Either set @Required to field 'installationTax' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("onuMacAddress")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuMacAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuMacAddress") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuMacAddress' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuMacAddressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuMacAddress' is required. Either set @Required to field 'onuMacAddress' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeExtraCableCharge")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeExtraCableCharge' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeExtraCableCharge") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeExtraCableCharge' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeExtraCableChargeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeExtraCableCharge' is required. Either set @Required to field 'cpeExtraCableCharge' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("teleConnCountPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'teleConnCountPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("teleConnCountPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'teleConnCountPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.teleConnCountPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'teleConnCountPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'teleConnCountPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvConnCountPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvConnCountPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvConnCountPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'iptvConnCountPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.iptvConnCountPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvConnCountPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'iptvConnCountPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuModel")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuModel' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuModel") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuModel' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuModelIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuModel' is required. Either set @Required to field 'onuModel' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuTax' is required. Either set @Required to field 'onuTax' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuUpfrontEmount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuUpfrontEmount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuUpfrontEmount") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuUpfrontEmount' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuUpfrontEmountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuUpfrontEmount' is required. Either set @Required to field 'onuUpfrontEmount' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedIptvList")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedIptvList'");
            }
            if (columnTypes.get("selectedIptvList") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'IptvDataModel' for field 'selectedIptvList'");
            }
            if (!sharedRealm.hasTable("class_IptvDataModel")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_IptvDataModel' for field 'selectedIptvList'");
            }
            Table table_23 = sharedRealm.getTable("class_IptvDataModel");
            if (!table.getLinkTarget(columnInfo.selectedIptvListIndex).hasSameSchema(table_23)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'selectedIptvList': '" + table.getLinkTarget(columnInfo.selectedIptvListIndex).getName() + "' expected - was '" + table_23.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CPEInfoModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CPEInfoModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.CPEInfoModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.app.apsfl.models.CPEInfoModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.CPEInfoModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CPEInfoModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CPEInfoModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("selectedIptvList")) {
                excludeFields.add("selectedIptvList");
            }
            if (json.has("formTime")) {
                if (json.isNull("formTime")) {
                    obj = (io.realm.CPEInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CPEInfoModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CPEInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CPEInfoModel.class, json.getLong("formTime"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'formTime'.");
            }
        }
        if (json.has("cpePOPName")) {
            if (json.isNull("cpePOPName")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpePOPName(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpePOPName((String) json.getString("cpePOPName"));
            }
        }
        if (json.has("cpeOLTIDPosition")) {
            if (json.isNull("cpeOLTIDPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cpeOLTIDPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeOLTIDPosition((int) json.getInt("cpeOLTIDPosition"));
            }
        }
        if (json.has("cpeOLTPortIDPosition")) {
            if (json.isNull("cpeOLTPortIDPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cpeOLTPortIDPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeOLTPortIDPosition((int) json.getInt("cpeOLTPortIDPosition"));
            }
        }
        if (json.has("cpeLevel1SlotPosition")) {
            if (json.isNull("cpeLevel1SlotPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cpeLevel1SlotPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeLevel1SlotPosition((int) json.getInt("cpeLevel1SlotPosition"));
            }
        }
        if (json.has("cpeLevel2SlotPosition")) {
            if (json.isNull("cpeLevel2SlotPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cpeLevel2SlotPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeLevel2SlotPosition((int) json.getInt("cpeLevel2SlotPosition"));
            }
        }
        if (json.has("cpeLevel3SlotPosition")) {
            if (json.isNull("cpeLevel3SlotPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cpeLevel3SlotPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeLevel3SlotPosition((int) json.getInt("cpeLevel3SlotPosition"));
            }
        }
        if (json.has("onuModelPosition")) {
            if (json.isNull("onuModelPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'onuModelPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuModelPosition((int) json.getInt("onuModelPosition"));
            }
        }
        if (json.has("onuDevicePurchasePosition")) {
            if (json.isNull("onuDevicePurchasePosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'onuDevicePurchasePosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuDevicePurchasePosition((int) json.getInt("onuDevicePurchasePosition"));
            }
        }
        if (json.has("vpnSpinnerPosition")) {
            if (json.isNull("vpnSpinnerPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'vpnSpinnerPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$vpnSpinnerPosition((int) json.getInt("vpnSpinnerPosition"));
            }
        }
        if (json.has("VpnServiceName")) {
            if (json.isNull("VpnServiceName")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$VpnServiceName(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$VpnServiceName((String) json.getString("VpnServiceName"));
            }
        }
        if (json.has("noOfOnuInstallments")) {
            if (json.isNull("noOfOnuInstallments")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$noOfOnuInstallments(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$noOfOnuInstallments((String) json.getString("noOfOnuInstallments"));
            }
        }
        if (json.has("onuPriceForInstallment")) {
            if (json.isNull("onuPriceForInstallment")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuPriceForInstallment(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuPriceForInstallment((String) json.getString("onuPriceForInstallment"));
            }
        }
        if (json.has("onuInstallationCharge")) {
            if (json.isNull("onuInstallationCharge")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuInstallationCharge(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuInstallationCharge((String) json.getString("onuInstallationCharge"));
            }
        }
        if (json.has("installationTax")) {
            if (json.isNull("installationTax")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$installationTax(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$installationTax((String) json.getString("installationTax"));
            }
        }
        if (json.has("onuSerialNumber")) {
            if (json.isNull("onuSerialNumber")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber((String) json.getString("onuSerialNumber"));
            }
        }
        if (json.has("onuMacAddress")) {
            if (json.isNull("onuMacAddress")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuMacAddress(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuMacAddress((String) json.getString("onuMacAddress"));
            }
        }
        if (json.has("cpeExtraCableCharge")) {
            if (json.isNull("cpeExtraCableCharge")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeExtraCableCharge(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeExtraCableCharge((String) json.getString("cpeExtraCableCharge"));
            }
        }
        if (json.has("teleConnCountPosition")) {
            if (json.isNull("teleConnCountPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'teleConnCountPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$teleConnCountPosition((int) json.getInt("teleConnCountPosition"));
            }
        }
        if (json.has("iptvConnCountPosition")) {
            if (json.isNull("iptvConnCountPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iptvConnCountPosition' to null.");
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$iptvConnCountPosition((int) json.getInt("iptvConnCountPosition"));
            }
        }
        if (json.has("onuModel")) {
            if (json.isNull("onuModel")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuModel(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuModel((String) json.getString("onuModel"));
            }
        }
        if (json.has("onuTax")) {
            if (json.isNull("onuTax")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuTax(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuTax((String) json.getString("onuTax"));
            }
        }
        if (json.has("onuUpfrontEmount")) {
            if (json.isNull("onuUpfrontEmount")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuUpfrontEmount(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuUpfrontEmount((String) json.getString("onuUpfrontEmount"));
            }
        }
        if (json.has("selectedIptvList")) {
            if (json.isNull("selectedIptvList")) {
                ((CPEInfoModelRealmProxyInterface) obj).realmSet$selectedIptvList(null);
            } else {
                ((CPEInfoModelRealmProxyInterface) obj).realmGet$selectedIptvList().clear();
                JSONArray array = json.getJSONArray("selectedIptvList");
                for (int i = 0; i < array.length(); i++) {
                    com.app.apsfl.models.IptvDataModel item = IptvDataModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((CPEInfoModelRealmProxyInterface) obj).realmGet$selectedIptvList().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.CPEInfoModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.CPEInfoModel obj = new com.app.apsfl.models.CPEInfoModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("formTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$formTime(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$formTime((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("cpePOPName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpePOPName(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpePOPName((String) reader.nextString());
                }
            } else if (name.equals("cpeOLTIDPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cpeOLTIDPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeOLTIDPosition((int) reader.nextInt());
                }
            } else if (name.equals("cpeOLTPortIDPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cpeOLTPortIDPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeOLTPortIDPosition((int) reader.nextInt());
                }
            } else if (name.equals("cpeLevel1SlotPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cpeLevel1SlotPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeLevel1SlotPosition((int) reader.nextInt());
                }
            } else if (name.equals("cpeLevel2SlotPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cpeLevel2SlotPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeLevel2SlotPosition((int) reader.nextInt());
                }
            } else if (name.equals("cpeLevel3SlotPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cpeLevel3SlotPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeLevel3SlotPosition((int) reader.nextInt());
                }
            } else if (name.equals("onuModelPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'onuModelPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuModelPosition((int) reader.nextInt());
                }
            } else if (name.equals("onuDevicePurchasePosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'onuDevicePurchasePosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuDevicePurchasePosition((int) reader.nextInt());
                }
            } else if (name.equals("vpnSpinnerPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'vpnSpinnerPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$vpnSpinnerPosition((int) reader.nextInt());
                }
            } else if (name.equals("VpnServiceName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$VpnServiceName(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$VpnServiceName((String) reader.nextString());
                }
            } else if (name.equals("noOfOnuInstallments")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$noOfOnuInstallments(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$noOfOnuInstallments((String) reader.nextString());
                }
            } else if (name.equals("onuPriceForInstallment")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuPriceForInstallment(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuPriceForInstallment((String) reader.nextString());
                }
            } else if (name.equals("onuInstallationCharge")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuInstallationCharge(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuInstallationCharge((String) reader.nextString());
                }
            } else if (name.equals("installationTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$installationTax(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$installationTax((String) reader.nextString());
                }
            } else if (name.equals("onuSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("onuMacAddress")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuMacAddress(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuMacAddress((String) reader.nextString());
                }
            } else if (name.equals("cpeExtraCableCharge")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeExtraCableCharge(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$cpeExtraCableCharge((String) reader.nextString());
                }
            } else if (name.equals("teleConnCountPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'teleConnCountPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$teleConnCountPosition((int) reader.nextInt());
                }
            } else if (name.equals("iptvConnCountPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iptvConnCountPosition' to null.");
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$iptvConnCountPosition((int) reader.nextInt());
                }
            } else if (name.equals("onuModel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuModel(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuModel((String) reader.nextString());
                }
            } else if (name.equals("onuTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuTax(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuTax((String) reader.nextString());
                }
            } else if (name.equals("onuUpfrontEmount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuUpfrontEmount(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$onuUpfrontEmount((String) reader.nextString());
                }
            } else if (name.equals("selectedIptvList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$selectedIptvList(null);
                } else {
                    ((CPEInfoModelRealmProxyInterface) obj).realmSet$selectedIptvList(new RealmList<com.app.apsfl.models.IptvDataModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.app.apsfl.models.IptvDataModel item = IptvDataModelRealmProxy.createUsingJsonStream(realm, reader);
                        ((CPEInfoModelRealmProxyInterface) obj).realmGet$selectedIptvList().add(item);
                    }
                    reader.endArray();
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

    public static com.app.apsfl.models.CPEInfoModel copyOrUpdate(Realm realm, com.app.apsfl.models.CPEInfoModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CPEInfoModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.CPEInfoModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.CPEInfoModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CPEInfoModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CPEInfoModelRealmProxy();
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

    public static com.app.apsfl.models.CPEInfoModel copy(Realm realm, com.app.apsfl.models.CPEInfoModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CPEInfoModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.CPEInfoModel realmObject = realm.createObjectInternal(com.app.apsfl.models.CPEInfoModel.class, ((CPEInfoModelRealmProxyInterface) newObject).realmGet$formTime(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpePOPName(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpePOPName());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeOLTIDPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeOLTIDPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeOLTPortIDPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeOLTPortIDPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeLevel1SlotPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeLevel1SlotPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeLevel2SlotPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeLevel2SlotPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeLevel3SlotPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeLevel3SlotPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuModelPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuModelPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuDevicePurchasePosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuDevicePurchasePosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$vpnSpinnerPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$vpnSpinnerPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$VpnServiceName(((CPEInfoModelRealmProxyInterface) newObject).realmGet$VpnServiceName());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$noOfOnuInstallments(((CPEInfoModelRealmProxyInterface) newObject).realmGet$noOfOnuInstallments());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuPriceForInstallment(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuPriceForInstallment());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuInstallationCharge(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuInstallationCharge());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$installationTax(((CPEInfoModelRealmProxyInterface) newObject).realmGet$installationTax());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuSerialNumber(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuSerialNumber());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuMacAddress(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuMacAddress());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeExtraCableCharge(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeExtraCableCharge());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$teleConnCountPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$teleConnCountPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$iptvConnCountPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$iptvConnCountPosition());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuModel(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuModel());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuTax(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuTax());
            ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuUpfrontEmount(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuUpfrontEmount());

            RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListList = ((CPEInfoModelRealmProxyInterface) newObject).realmGet$selectedIptvList();
            if (selectedIptvListList != null) {
                RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListRealmList = ((CPEInfoModelRealmProxyInterface) realmObject).realmGet$selectedIptvList();
                for (int i = 0; i < selectedIptvListList.size(); i++) {
                    com.app.apsfl.models.IptvDataModel selectedIptvListItem = selectedIptvListList.get(i);
                    com.app.apsfl.models.IptvDataModel cacheselectedIptvList = (com.app.apsfl.models.IptvDataModel) cache.get(selectedIptvListItem);
                    if (cacheselectedIptvList != null) {
                        selectedIptvListRealmList.add(cacheselectedIptvList);
                    } else {
                        selectedIptvListRealmList.add(IptvDataModelRealmProxy.copyOrUpdate(realm, selectedIptvListList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.CPEInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CPEInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEInfoModelColumnInfo columnInfo = (CPEInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CPEInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$cpePOPName = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpePOPName();
        if (realmGet$cpePOPName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpePOPNameIndex, rowIndex, realmGet$cpePOPName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTIDPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTPortIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTPortIDPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel1SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel1SlotPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel2SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel2SlotPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel3SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel3SlotPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.onuDevicePurchasePositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuDevicePurchasePosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.vpnSpinnerPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$vpnSpinnerPosition(), false);
        String realmGet$VpnServiceName = ((CPEInfoModelRealmProxyInterface)object).realmGet$VpnServiceName();
        if (realmGet$VpnServiceName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VpnServiceNameIndex, rowIndex, realmGet$VpnServiceName, false);
        }
        String realmGet$noOfOnuInstallments = ((CPEInfoModelRealmProxyInterface)object).realmGet$noOfOnuInstallments();
        if (realmGet$noOfOnuInstallments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noOfOnuInstallmentsIndex, rowIndex, realmGet$noOfOnuInstallments, false);
        }
        String realmGet$onuPriceForInstallment = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuPriceForInstallment();
        if (realmGet$onuPriceForInstallment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuPriceForInstallmentIndex, rowIndex, realmGet$onuPriceForInstallment, false);
        }
        String realmGet$onuInstallationCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuInstallationCharge();
        if (realmGet$onuInstallationCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuInstallationChargeIndex, rowIndex, realmGet$onuInstallationCharge, false);
        }
        String realmGet$installationTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$installationTax();
        if (realmGet$installationTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.installationTaxIndex, rowIndex, realmGet$installationTax, false);
        }
        String realmGet$onuSerialNumber = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
        if (realmGet$onuSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
        }
        String realmGet$onuMacAddress = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuMacAddress();
        if (realmGet$onuMacAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuMacAddressIndex, rowIndex, realmGet$onuMacAddress, false);
        }
        String realmGet$cpeExtraCableCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeExtraCableCharge();
        if (realmGet$cpeExtraCableCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeExtraCableChargeIndex, rowIndex, realmGet$cpeExtraCableCharge, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$iptvConnCountPosition(), false);
        String realmGet$onuModel = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModel();
        if (realmGet$onuModel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuModelIndex, rowIndex, realmGet$onuModel, false);
        }
        String realmGet$onuTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuTax();
        if (realmGet$onuTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuTaxIndex, rowIndex, realmGet$onuTax, false);
        }
        String realmGet$onuUpfrontEmount = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuUpfrontEmount();
        if (realmGet$onuUpfrontEmount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuUpfrontEmountIndex, rowIndex, realmGet$onuUpfrontEmount, false);
        }

        RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListList = ((CPEInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
        if (selectedIptvListList != null) {
            long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
            for (com.app.apsfl.models.IptvDataModel selectedIptvListItem : selectedIptvListList) {
                Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                if (cacheItemIndexselectedIptvList == null) {
                    cacheItemIndexselectedIptvList = IptvDataModelRealmProxy.insert(realm, selectedIptvListItem, cache);
                }
                LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
            }
            LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CPEInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEInfoModelColumnInfo columnInfo = (CPEInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CPEInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CPEInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CPEInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$cpePOPName = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpePOPName();
                if (realmGet$cpePOPName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpePOPNameIndex, rowIndex, realmGet$cpePOPName, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTIDPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTPortIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTPortIDPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel1SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel1SlotPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel2SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel2SlotPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel3SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel3SlotPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.onuDevicePurchasePositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuDevicePurchasePosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.vpnSpinnerPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$vpnSpinnerPosition(), false);
                String realmGet$VpnServiceName = ((CPEInfoModelRealmProxyInterface)object).realmGet$VpnServiceName();
                if (realmGet$VpnServiceName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.VpnServiceNameIndex, rowIndex, realmGet$VpnServiceName, false);
                }
                String realmGet$noOfOnuInstallments = ((CPEInfoModelRealmProxyInterface)object).realmGet$noOfOnuInstallments();
                if (realmGet$noOfOnuInstallments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noOfOnuInstallmentsIndex, rowIndex, realmGet$noOfOnuInstallments, false);
                }
                String realmGet$onuPriceForInstallment = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuPriceForInstallment();
                if (realmGet$onuPriceForInstallment != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuPriceForInstallmentIndex, rowIndex, realmGet$onuPriceForInstallment, false);
                }
                String realmGet$onuInstallationCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuInstallationCharge();
                if (realmGet$onuInstallationCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuInstallationChargeIndex, rowIndex, realmGet$onuInstallationCharge, false);
                }
                String realmGet$installationTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$installationTax();
                if (realmGet$installationTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.installationTaxIndex, rowIndex, realmGet$installationTax, false);
                }
                String realmGet$onuSerialNumber = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
                if (realmGet$onuSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
                }
                String realmGet$onuMacAddress = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuMacAddress();
                if (realmGet$onuMacAddress != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuMacAddressIndex, rowIndex, realmGet$onuMacAddress, false);
                }
                String realmGet$cpeExtraCableCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeExtraCableCharge();
                if (realmGet$cpeExtraCableCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeExtraCableChargeIndex, rowIndex, realmGet$cpeExtraCableCharge, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$iptvConnCountPosition(), false);
                String realmGet$onuModel = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModel();
                if (realmGet$onuModel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuModelIndex, rowIndex, realmGet$onuModel, false);
                }
                String realmGet$onuTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuTax();
                if (realmGet$onuTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuTaxIndex, rowIndex, realmGet$onuTax, false);
                }
                String realmGet$onuUpfrontEmount = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuUpfrontEmount();
                if (realmGet$onuUpfrontEmount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuUpfrontEmountIndex, rowIndex, realmGet$onuUpfrontEmount, false);
                }

                RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListList = ((CPEInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
                if (selectedIptvListList != null) {
                    long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
                    for (com.app.apsfl.models.IptvDataModel selectedIptvListItem : selectedIptvListList) {
                        Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                        if (cacheItemIndexselectedIptvList == null) {
                            cacheItemIndexselectedIptvList = IptvDataModelRealmProxy.insert(realm, selectedIptvListItem, cache);
                        }
                        LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
                    }
                    LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.CPEInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CPEInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEInfoModelColumnInfo columnInfo = (CPEInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CPEInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$cpePOPName = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpePOPName();
        if (realmGet$cpePOPName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpePOPNameIndex, rowIndex, realmGet$cpePOPName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpePOPNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTIDPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTPortIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTPortIDPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel1SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel1SlotPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel2SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel2SlotPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel3SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel3SlotPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.onuDevicePurchasePositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuDevicePurchasePosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.vpnSpinnerPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$vpnSpinnerPosition(), false);
        String realmGet$VpnServiceName = ((CPEInfoModelRealmProxyInterface)object).realmGet$VpnServiceName();
        if (realmGet$VpnServiceName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VpnServiceNameIndex, rowIndex, realmGet$VpnServiceName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.VpnServiceNameIndex, rowIndex, false);
        }
        String realmGet$noOfOnuInstallments = ((CPEInfoModelRealmProxyInterface)object).realmGet$noOfOnuInstallments();
        if (realmGet$noOfOnuInstallments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noOfOnuInstallmentsIndex, rowIndex, realmGet$noOfOnuInstallments, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.noOfOnuInstallmentsIndex, rowIndex, false);
        }
        String realmGet$onuPriceForInstallment = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuPriceForInstallment();
        if (realmGet$onuPriceForInstallment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuPriceForInstallmentIndex, rowIndex, realmGet$onuPriceForInstallment, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuPriceForInstallmentIndex, rowIndex, false);
        }
        String realmGet$onuInstallationCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuInstallationCharge();
        if (realmGet$onuInstallationCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuInstallationChargeIndex, rowIndex, realmGet$onuInstallationCharge, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuInstallationChargeIndex, rowIndex, false);
        }
        String realmGet$installationTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$installationTax();
        if (realmGet$installationTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.installationTaxIndex, rowIndex, realmGet$installationTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.installationTaxIndex, rowIndex, false);
        }
        String realmGet$onuSerialNumber = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
        if (realmGet$onuSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, false);
        }
        String realmGet$onuMacAddress = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuMacAddress();
        if (realmGet$onuMacAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuMacAddressIndex, rowIndex, realmGet$onuMacAddress, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuMacAddressIndex, rowIndex, false);
        }
        String realmGet$cpeExtraCableCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeExtraCableCharge();
        if (realmGet$cpeExtraCableCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeExtraCableChargeIndex, rowIndex, realmGet$cpeExtraCableCharge, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeExtraCableChargeIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$iptvConnCountPosition(), false);
        String realmGet$onuModel = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModel();
        if (realmGet$onuModel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuModelIndex, rowIndex, realmGet$onuModel, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuModelIndex, rowIndex, false);
        }
        String realmGet$onuTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuTax();
        if (realmGet$onuTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuTaxIndex, rowIndex, realmGet$onuTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuTaxIndex, rowIndex, false);
        }
        String realmGet$onuUpfrontEmount = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuUpfrontEmount();
        if (realmGet$onuUpfrontEmount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuUpfrontEmountIndex, rowIndex, realmGet$onuUpfrontEmount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuUpfrontEmountIndex, rowIndex, false);
        }

        long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
        LinkView.nativeClear(selectedIptvListNativeLinkViewPtr);
        RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListList = ((CPEInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
        if (selectedIptvListList != null) {
            for (com.app.apsfl.models.IptvDataModel selectedIptvListItem : selectedIptvListList) {
                Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                if (cacheItemIndexselectedIptvList == null) {
                    cacheItemIndexselectedIptvList = IptvDataModelRealmProxy.insertOrUpdate(realm, selectedIptvListItem, cache);
                }
                LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
            }
        }
        LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CPEInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEInfoModelColumnInfo columnInfo = (CPEInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CPEInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CPEInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CPEInfoModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CPEInfoModelRealmProxyInterface) object).realmGet$formTime(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$cpePOPName = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpePOPName();
                if (realmGet$cpePOPName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpePOPNameIndex, rowIndex, realmGet$cpePOPName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpePOPNameIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTIDPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeOLTPortIDPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeOLTPortIDPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel1SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel1SlotPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel2SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel2SlotPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeLevel3SlotPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeLevel3SlotPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.onuDevicePurchasePositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$onuDevicePurchasePosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.vpnSpinnerPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$vpnSpinnerPosition(), false);
                String realmGet$VpnServiceName = ((CPEInfoModelRealmProxyInterface)object).realmGet$VpnServiceName();
                if (realmGet$VpnServiceName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.VpnServiceNameIndex, rowIndex, realmGet$VpnServiceName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.VpnServiceNameIndex, rowIndex, false);
                }
                String realmGet$noOfOnuInstallments = ((CPEInfoModelRealmProxyInterface)object).realmGet$noOfOnuInstallments();
                if (realmGet$noOfOnuInstallments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noOfOnuInstallmentsIndex, rowIndex, realmGet$noOfOnuInstallments, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.noOfOnuInstallmentsIndex, rowIndex, false);
                }
                String realmGet$onuPriceForInstallment = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuPriceForInstallment();
                if (realmGet$onuPriceForInstallment != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuPriceForInstallmentIndex, rowIndex, realmGet$onuPriceForInstallment, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuPriceForInstallmentIndex, rowIndex, false);
                }
                String realmGet$onuInstallationCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuInstallationCharge();
                if (realmGet$onuInstallationCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuInstallationChargeIndex, rowIndex, realmGet$onuInstallationCharge, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuInstallationChargeIndex, rowIndex, false);
                }
                String realmGet$installationTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$installationTax();
                if (realmGet$installationTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.installationTaxIndex, rowIndex, realmGet$installationTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.installationTaxIndex, rowIndex, false);
                }
                String realmGet$onuSerialNumber = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
                if (realmGet$onuSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, false);
                }
                String realmGet$onuMacAddress = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuMacAddress();
                if (realmGet$onuMacAddress != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuMacAddressIndex, rowIndex, realmGet$onuMacAddress, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuMacAddressIndex, rowIndex, false);
                }
                String realmGet$cpeExtraCableCharge = ((CPEInfoModelRealmProxyInterface)object).realmGet$cpeExtraCableCharge();
                if (realmGet$cpeExtraCableCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeExtraCableChargeIndex, rowIndex, realmGet$cpeExtraCableCharge, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeExtraCableChargeIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvConnCountPositionIndex, rowIndex, ((CPEInfoModelRealmProxyInterface)object).realmGet$iptvConnCountPosition(), false);
                String realmGet$onuModel = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuModel();
                if (realmGet$onuModel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuModelIndex, rowIndex, realmGet$onuModel, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuModelIndex, rowIndex, false);
                }
                String realmGet$onuTax = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuTax();
                if (realmGet$onuTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuTaxIndex, rowIndex, realmGet$onuTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuTaxIndex, rowIndex, false);
                }
                String realmGet$onuUpfrontEmount = ((CPEInfoModelRealmProxyInterface)object).realmGet$onuUpfrontEmount();
                if (realmGet$onuUpfrontEmount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuUpfrontEmountIndex, rowIndex, realmGet$onuUpfrontEmount, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuUpfrontEmountIndex, rowIndex, false);
                }

                long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
                LinkView.nativeClear(selectedIptvListNativeLinkViewPtr);
                RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListList = ((CPEInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
                if (selectedIptvListList != null) {
                    for (com.app.apsfl.models.IptvDataModel selectedIptvListItem : selectedIptvListList) {
                        Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                        if (cacheItemIndexselectedIptvList == null) {
                            cacheItemIndexselectedIptvList = IptvDataModelRealmProxy.insertOrUpdate(realm, selectedIptvListItem, cache);
                        }
                        LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
                    }
                }
                LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);

            }
        }
    }

    public static com.app.apsfl.models.CPEInfoModel createDetachedCopy(com.app.apsfl.models.CPEInfoModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.CPEInfoModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.CPEInfoModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.CPEInfoModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.CPEInfoModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$formTime(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$formTime());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpePOPName(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$cpePOPName());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpeOLTIDPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$cpeOLTIDPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpeOLTPortIDPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$cpeOLTPortIDPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpeLevel1SlotPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$cpeLevel1SlotPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpeLevel2SlotPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$cpeLevel2SlotPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpeLevel3SlotPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$cpeLevel3SlotPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuModelPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuModelPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuDevicePurchasePosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuDevicePurchasePosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$vpnSpinnerPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$vpnSpinnerPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$VpnServiceName(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$VpnServiceName());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$noOfOnuInstallments(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$noOfOnuInstallments());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuPriceForInstallment(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuPriceForInstallment());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuInstallationCharge(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuInstallationCharge());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$installationTax(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$installationTax());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuSerialNumber(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuSerialNumber());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuMacAddress(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuMacAddress());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$cpeExtraCableCharge(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$cpeExtraCableCharge());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$teleConnCountPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$teleConnCountPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$iptvConnCountPosition(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$iptvConnCountPosition());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuModel(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuModel());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuTax(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuTax());
        ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuUpfrontEmount(((CPEInfoModelRealmProxyInterface) realmObject).realmGet$onuUpfrontEmount());

        // Deep copy of selectedIptvList
        if (currentDepth == maxDepth) {
            ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedIptvList(null);
        } else {
            RealmList<com.app.apsfl.models.IptvDataModel> managedselectedIptvListList = ((CPEInfoModelRealmProxyInterface) realmObject).realmGet$selectedIptvList();
            RealmList<com.app.apsfl.models.IptvDataModel> unmanagedselectedIptvListList = new RealmList<com.app.apsfl.models.IptvDataModel>();
            ((CPEInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedIptvList(unmanagedselectedIptvListList);
            int nextDepth = currentDepth + 1;
            int size = managedselectedIptvListList.size();
            for (int i = 0; i < size; i++) {
                com.app.apsfl.models.IptvDataModel item = IptvDataModelRealmProxy.createDetachedCopy(managedselectedIptvListList.get(i), nextDepth, maxDepth, cache);
                unmanagedselectedIptvListList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.app.apsfl.models.CPEInfoModel update(Realm realm, com.app.apsfl.models.CPEInfoModel realmObject, com.app.apsfl.models.CPEInfoModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpePOPName(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpePOPName());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeOLTIDPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeOLTIDPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeOLTPortIDPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeOLTPortIDPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeLevel1SlotPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeLevel1SlotPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeLevel2SlotPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeLevel2SlotPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeLevel3SlotPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeLevel3SlotPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuModelPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuModelPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuDevicePurchasePosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuDevicePurchasePosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$vpnSpinnerPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$vpnSpinnerPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$VpnServiceName(((CPEInfoModelRealmProxyInterface) newObject).realmGet$VpnServiceName());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$noOfOnuInstallments(((CPEInfoModelRealmProxyInterface) newObject).realmGet$noOfOnuInstallments());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuPriceForInstallment(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuPriceForInstallment());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuInstallationCharge(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuInstallationCharge());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$installationTax(((CPEInfoModelRealmProxyInterface) newObject).realmGet$installationTax());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuSerialNumber(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuSerialNumber());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuMacAddress(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuMacAddress());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$cpeExtraCableCharge(((CPEInfoModelRealmProxyInterface) newObject).realmGet$cpeExtraCableCharge());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$teleConnCountPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$teleConnCountPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$iptvConnCountPosition(((CPEInfoModelRealmProxyInterface) newObject).realmGet$iptvConnCountPosition());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuModel(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuModel());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuTax(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuTax());
        ((CPEInfoModelRealmProxyInterface) realmObject).realmSet$onuUpfrontEmount(((CPEInfoModelRealmProxyInterface) newObject).realmGet$onuUpfrontEmount());
        RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListList = ((CPEInfoModelRealmProxyInterface) newObject).realmGet$selectedIptvList();
        RealmList<com.app.apsfl.models.IptvDataModel> selectedIptvListRealmList = ((CPEInfoModelRealmProxyInterface) realmObject).realmGet$selectedIptvList();
        selectedIptvListRealmList.clear();
        if (selectedIptvListList != null) {
            for (int i = 0; i < selectedIptvListList.size(); i++) {
                com.app.apsfl.models.IptvDataModel selectedIptvListItem = selectedIptvListList.get(i);
                com.app.apsfl.models.IptvDataModel cacheselectedIptvList = (com.app.apsfl.models.IptvDataModel) cache.get(selectedIptvListItem);
                if (cacheselectedIptvList != null) {
                    selectedIptvListRealmList.add(cacheselectedIptvList);
                } else {
                    selectedIptvListRealmList.add(IptvDataModelRealmProxy.copyOrUpdate(realm, selectedIptvListList.get(i), true, cache));
                }
            }
        }
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
        CPEInfoModelRealmProxy aCPEInfoModel = (CPEInfoModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCPEInfoModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCPEInfoModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCPEInfoModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
