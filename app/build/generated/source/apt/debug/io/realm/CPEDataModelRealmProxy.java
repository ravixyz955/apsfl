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

public class CPEDataModelRealmProxy extends com.app.apsfl.models.CPEDataModel
    implements RealmObjectProxy, CPEDataModelRealmProxyInterface {

    static final class CPEDataModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long cpeProfileIDcpeInstallmentCountIndex;
        public long cpeProfileIDIndex;
        public long cpeModelNameIndex;
        public long cpeProfileNameIndex;
        public long cpeModelDetailsIndex;
        public long cpePurchaseCostIndex;
        public long cpeRentalCostIndex;
        public long cpeLovTypeIndex;
        public long cpeInstallmentCountIndex;
        public long installationTaxAmountIndex;
        public long cpeInstallationCostIndex;
        public long cpeInstallmentCostIndex;
        public long cpeTaxIndex;
        public long cpeTotalCostIndex;
        public long upFrontChargesIndex;

        CPEDataModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(15);
            this.cpeProfileIDcpeInstallmentCountIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeProfileIDcpeInstallmentCount");
            indicesMap.put("cpeProfileIDcpeInstallmentCount", this.cpeProfileIDcpeInstallmentCountIndex);
            this.cpeProfileIDIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeProfileID");
            indicesMap.put("cpeProfileID", this.cpeProfileIDIndex);
            this.cpeModelNameIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeModelName");
            indicesMap.put("cpeModelName", this.cpeModelNameIndex);
            this.cpeProfileNameIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeProfileName");
            indicesMap.put("cpeProfileName", this.cpeProfileNameIndex);
            this.cpeModelDetailsIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeModelDetails");
            indicesMap.put("cpeModelDetails", this.cpeModelDetailsIndex);
            this.cpePurchaseCostIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpePurchaseCost");
            indicesMap.put("cpePurchaseCost", this.cpePurchaseCostIndex);
            this.cpeRentalCostIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeRentalCost");
            indicesMap.put("cpeRentalCost", this.cpeRentalCostIndex);
            this.cpeLovTypeIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeLovType");
            indicesMap.put("cpeLovType", this.cpeLovTypeIndex);
            this.cpeInstallmentCountIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeInstallmentCount");
            indicesMap.put("cpeInstallmentCount", this.cpeInstallmentCountIndex);
            this.installationTaxAmountIndex = getValidColumnIndex(path, table, "CPEDataModel", "installationTaxAmount");
            indicesMap.put("installationTaxAmount", this.installationTaxAmountIndex);
            this.cpeInstallationCostIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeInstallationCost");
            indicesMap.put("cpeInstallationCost", this.cpeInstallationCostIndex);
            this.cpeInstallmentCostIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeInstallmentCost");
            indicesMap.put("cpeInstallmentCost", this.cpeInstallmentCostIndex);
            this.cpeTaxIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeTax");
            indicesMap.put("cpeTax", this.cpeTaxIndex);
            this.cpeTotalCostIndex = getValidColumnIndex(path, table, "CPEDataModel", "cpeTotalCost");
            indicesMap.put("cpeTotalCost", this.cpeTotalCostIndex);
            this.upFrontChargesIndex = getValidColumnIndex(path, table, "CPEDataModel", "upFrontCharges");
            indicesMap.put("upFrontCharges", this.upFrontChargesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CPEDataModelColumnInfo otherInfo = (CPEDataModelColumnInfo) other;
            this.cpeProfileIDcpeInstallmentCountIndex = otherInfo.cpeProfileIDcpeInstallmentCountIndex;
            this.cpeProfileIDIndex = otherInfo.cpeProfileIDIndex;
            this.cpeModelNameIndex = otherInfo.cpeModelNameIndex;
            this.cpeProfileNameIndex = otherInfo.cpeProfileNameIndex;
            this.cpeModelDetailsIndex = otherInfo.cpeModelDetailsIndex;
            this.cpePurchaseCostIndex = otherInfo.cpePurchaseCostIndex;
            this.cpeRentalCostIndex = otherInfo.cpeRentalCostIndex;
            this.cpeLovTypeIndex = otherInfo.cpeLovTypeIndex;
            this.cpeInstallmentCountIndex = otherInfo.cpeInstallmentCountIndex;
            this.installationTaxAmountIndex = otherInfo.installationTaxAmountIndex;
            this.cpeInstallationCostIndex = otherInfo.cpeInstallationCostIndex;
            this.cpeInstallmentCostIndex = otherInfo.cpeInstallmentCostIndex;
            this.cpeTaxIndex = otherInfo.cpeTaxIndex;
            this.cpeTotalCostIndex = otherInfo.cpeTotalCostIndex;
            this.upFrontChargesIndex = otherInfo.upFrontChargesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CPEDataModelColumnInfo clone() {
            return (CPEDataModelColumnInfo) super.clone();
        }

    }
    private CPEDataModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("cpeProfileIDcpeInstallmentCount");
        fieldNames.add("cpeProfileID");
        fieldNames.add("cpeModelName");
        fieldNames.add("cpeProfileName");
        fieldNames.add("cpeModelDetails");
        fieldNames.add("cpePurchaseCost");
        fieldNames.add("cpeRentalCost");
        fieldNames.add("cpeLovType");
        fieldNames.add("cpeInstallmentCount");
        fieldNames.add("installationTaxAmount");
        fieldNames.add("cpeInstallationCost");
        fieldNames.add("cpeInstallmentCost");
        fieldNames.add("cpeTax");
        fieldNames.add("cpeTotalCost");
        fieldNames.add("upFrontCharges");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CPEDataModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CPEDataModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.CPEDataModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeProfileIDcpeInstallmentCount() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeProfileIDcpeInstallmentCountIndex);
    }

    public void realmSet$cpeProfileIDcpeInstallmentCount(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'cpeProfileIDcpeInstallmentCount' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public int realmGet$cpeProfileID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cpeProfileIDIndex);
    }

    public void realmSet$cpeProfileID(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cpeProfileIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cpeProfileIDIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeModelName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeModelNameIndex);
    }

    public void realmSet$cpeModelName(String value) {
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
                row.getTable().setNull(columnInfo.cpeModelNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeModelNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeModelNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeModelNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeProfileName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeProfileNameIndex);
    }

    public void realmSet$cpeProfileName(String value) {
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
                row.getTable().setNull(columnInfo.cpeProfileNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeProfileNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeProfileNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeProfileNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeModelDetails() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeModelDetailsIndex);
    }

    public void realmSet$cpeModelDetails(String value) {
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
                row.getTable().setNull(columnInfo.cpeModelDetailsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeModelDetailsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeModelDetailsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeModelDetailsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpePurchaseCost() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpePurchaseCostIndex);
    }

    public void realmSet$cpePurchaseCost(String value) {
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
                row.getTable().setNull(columnInfo.cpePurchaseCostIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpePurchaseCostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpePurchaseCostIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpePurchaseCostIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeRentalCost() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeRentalCostIndex);
    }

    public void realmSet$cpeRentalCost(String value) {
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
                row.getTable().setNull(columnInfo.cpeRentalCostIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeRentalCostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeRentalCostIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeRentalCostIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeLovType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeLovTypeIndex);
    }

    public void realmSet$cpeLovType(String value) {
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
                row.getTable().setNull(columnInfo.cpeLovTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeLovTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeLovTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeLovTypeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeInstallmentCount() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeInstallmentCountIndex);
    }

    public void realmSet$cpeInstallmentCount(String value) {
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
                row.getTable().setNull(columnInfo.cpeInstallmentCountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeInstallmentCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeInstallmentCountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeInstallmentCountIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$installationTaxAmount() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.installationTaxAmountIndex);
    }

    public void realmSet$installationTaxAmount(String value) {
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
                row.getTable().setNull(columnInfo.installationTaxAmountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.installationTaxAmountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.installationTaxAmountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.installationTaxAmountIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeInstallationCost() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeInstallationCostIndex);
    }

    public void realmSet$cpeInstallationCost(String value) {
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
                row.getTable().setNull(columnInfo.cpeInstallationCostIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeInstallationCostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeInstallationCostIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeInstallationCostIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeInstallmentCost() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeInstallmentCostIndex);
    }

    public void realmSet$cpeInstallmentCost(String value) {
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
                row.getTable().setNull(columnInfo.cpeInstallmentCostIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeInstallmentCostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeInstallmentCostIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeInstallmentCostIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeTaxIndex);
    }

    public void realmSet$cpeTax(String value) {
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
                row.getTable().setNull(columnInfo.cpeTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeTaxIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeTotalCost() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeTotalCostIndex);
    }

    public void realmSet$cpeTotalCost(String value) {
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
                row.getTable().setNull(columnInfo.cpeTotalCostIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeTotalCostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeTotalCostIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeTotalCostIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$upFrontCharges() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.upFrontChargesIndex);
    }

    public void realmSet$upFrontCharges(String value) {
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
                row.getTable().setNull(columnInfo.upFrontChargesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.upFrontChargesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.upFrontChargesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.upFrontChargesIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CPEDataModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CPEDataModel");
            realmObjectSchema.add(new Property("cpeProfileIDcpeInstallmentCount", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeProfileID", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeModelName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeProfileName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeModelDetails", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpePurchaseCost", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeRentalCost", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeLovType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeInstallmentCount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("installationTaxAmount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeInstallationCost", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeInstallmentCost", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeTotalCost", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("upFrontCharges", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CPEDataModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CPEDataModel")) {
            Table table = sharedRealm.getTable("class_CPEDataModel");
            table.addColumn(RealmFieldType.STRING, "cpeProfileIDcpeInstallmentCount", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cpeProfileID", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeModelName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeProfileName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeModelDetails", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpePurchaseCost", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeRentalCost", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeLovType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeInstallmentCount", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "installationTaxAmount", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeInstallationCost", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeInstallmentCost", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeTotalCost", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "upFrontCharges", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("cpeProfileIDcpeInstallmentCount"));
            table.addSearchIndex(table.getColumnIndex("cpeProfileID"));
            table.setPrimaryKey("cpeProfileIDcpeInstallmentCount");
            return table;
        }
        return sharedRealm.getTable("class_CPEDataModel");
    }

    public static CPEDataModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CPEDataModel")) {
            Table table = sharedRealm.getTable("class_CPEDataModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 15) {
                if (columnCount < 15) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 15 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 15 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 15 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 15; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CPEDataModelColumnInfo columnInfo = new CPEDataModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("cpeProfileIDcpeInstallmentCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeProfileIDcpeInstallmentCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeProfileIDcpeInstallmentCount") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeProfileIDcpeInstallmentCount' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeProfileIDcpeInstallmentCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'cpeProfileIDcpeInstallmentCount' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("cpeProfileIDcpeInstallmentCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'cpeProfileIDcpeInstallmentCount' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("cpeProfileIDcpeInstallmentCount"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'cpeProfileIDcpeInstallmentCount' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("cpeProfileID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeProfileID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeProfileID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cpeProfileID' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cpeProfileIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeProfileID' does support null values in the existing Realm file. Use corresponding boxed type for field 'cpeProfileID' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("cpeProfileID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'cpeProfileID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("cpeModelName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeModelName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeModelName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeModelName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeModelNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeModelName' is required. Either set @Required to field 'cpeModelName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeProfileName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeProfileName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeProfileName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeProfileName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeProfileNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeProfileName' is required. Either set @Required to field 'cpeProfileName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeModelDetails")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeModelDetails' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeModelDetails") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeModelDetails' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeModelDetailsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeModelDetails' is required. Either set @Required to field 'cpeModelDetails' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpePurchaseCost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpePurchaseCost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpePurchaseCost") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpePurchaseCost' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpePurchaseCostIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpePurchaseCost' is required. Either set @Required to field 'cpePurchaseCost' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeRentalCost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeRentalCost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeRentalCost") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeRentalCost' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeRentalCostIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeRentalCost' is required. Either set @Required to field 'cpeRentalCost' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeLovType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeLovType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeLovType") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeLovType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeLovTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeLovType' is required. Either set @Required to field 'cpeLovType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeInstallmentCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeInstallmentCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeInstallmentCount") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeInstallmentCount' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeInstallmentCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeInstallmentCount' is required. Either set @Required to field 'cpeInstallmentCount' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("installationTaxAmount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'installationTaxAmount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("installationTaxAmount") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'installationTaxAmount' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.installationTaxAmountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'installationTaxAmount' is required. Either set @Required to field 'installationTaxAmount' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeInstallationCost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeInstallationCost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeInstallationCost") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeInstallationCost' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeInstallationCostIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeInstallationCost' is required. Either set @Required to field 'cpeInstallationCost' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeInstallmentCost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeInstallmentCost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeInstallmentCost") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeInstallmentCost' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeInstallmentCostIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeInstallmentCost' is required. Either set @Required to field 'cpeInstallmentCost' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeTax' is required. Either set @Required to field 'cpeTax' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cpeTotalCost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeTotalCost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeTotalCost") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeTotalCost' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeTotalCostIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeTotalCost' is required. Either set @Required to field 'cpeTotalCost' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("upFrontCharges")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'upFrontCharges' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("upFrontCharges") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'upFrontCharges' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.upFrontChargesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'upFrontCharges' is required. Either set @Required to field 'upFrontCharges' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CPEDataModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CPEDataModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.CPEDataModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.CPEDataModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.CPEDataModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("cpeProfileIDcpeInstallmentCount")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("cpeProfileIDcpeInstallmentCount"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CPEDataModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CPEDataModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("cpeProfileIDcpeInstallmentCount")) {
                if (json.isNull("cpeProfileIDcpeInstallmentCount")) {
                    obj = (io.realm.CPEDataModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CPEDataModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CPEDataModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CPEDataModel.class, json.getString("cpeProfileIDcpeInstallmentCount"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'cpeProfileIDcpeInstallmentCount'.");
            }
        }
        if (json.has("cpeProfileID")) {
            if (json.isNull("cpeProfileID")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cpeProfileID' to null.");
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileID((int) json.getInt("cpeProfileID"));
            }
        }
        if (json.has("cpeModelName")) {
            if (json.isNull("cpeModelName")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelName(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelName((String) json.getString("cpeModelName"));
            }
        }
        if (json.has("cpeProfileName")) {
            if (json.isNull("cpeProfileName")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileName(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileName((String) json.getString("cpeProfileName"));
            }
        }
        if (json.has("cpeModelDetails")) {
            if (json.isNull("cpeModelDetails")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelDetails(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelDetails((String) json.getString("cpeModelDetails"));
            }
        }
        if (json.has("cpePurchaseCost")) {
            if (json.isNull("cpePurchaseCost")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpePurchaseCost(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpePurchaseCost((String) json.getString("cpePurchaseCost"));
            }
        }
        if (json.has("cpeRentalCost")) {
            if (json.isNull("cpeRentalCost")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeRentalCost(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeRentalCost((String) json.getString("cpeRentalCost"));
            }
        }
        if (json.has("cpeLovType")) {
            if (json.isNull("cpeLovType")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeLovType(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeLovType((String) json.getString("cpeLovType"));
            }
        }
        if (json.has("cpeInstallmentCount")) {
            if (json.isNull("cpeInstallmentCount")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCount(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCount((String) json.getString("cpeInstallmentCount"));
            }
        }
        if (json.has("installationTaxAmount")) {
            if (json.isNull("installationTaxAmount")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$installationTaxAmount(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$installationTaxAmount((String) json.getString("installationTaxAmount"));
            }
        }
        if (json.has("cpeInstallationCost")) {
            if (json.isNull("cpeInstallationCost")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallationCost(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallationCost((String) json.getString("cpeInstallationCost"));
            }
        }
        if (json.has("cpeInstallmentCost")) {
            if (json.isNull("cpeInstallmentCost")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCost(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCost((String) json.getString("cpeInstallmentCost"));
            }
        }
        if (json.has("cpeTax")) {
            if (json.isNull("cpeTax")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTax(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTax((String) json.getString("cpeTax"));
            }
        }
        if (json.has("cpeTotalCost")) {
            if (json.isNull("cpeTotalCost")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTotalCost(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTotalCost((String) json.getString("cpeTotalCost"));
            }
        }
        if (json.has("upFrontCharges")) {
            if (json.isNull("upFrontCharges")) {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$upFrontCharges(null);
            } else {
                ((CPEDataModelRealmProxyInterface) obj).realmSet$upFrontCharges((String) json.getString("upFrontCharges"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.CPEDataModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.CPEDataModel obj = new com.app.apsfl.models.CPEDataModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("cpeProfileIDcpeInstallmentCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileIDcpeInstallmentCount(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileIDcpeInstallmentCount((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("cpeProfileID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cpeProfileID' to null.");
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileID((int) reader.nextInt());
                }
            } else if (name.equals("cpeModelName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelName(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelName((String) reader.nextString());
                }
            } else if (name.equals("cpeProfileName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileName(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeProfileName((String) reader.nextString());
                }
            } else if (name.equals("cpeModelDetails")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelDetails(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeModelDetails((String) reader.nextString());
                }
            } else if (name.equals("cpePurchaseCost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpePurchaseCost(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpePurchaseCost((String) reader.nextString());
                }
            } else if (name.equals("cpeRentalCost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeRentalCost(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeRentalCost((String) reader.nextString());
                }
            } else if (name.equals("cpeLovType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeLovType(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeLovType((String) reader.nextString());
                }
            } else if (name.equals("cpeInstallmentCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCount(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCount((String) reader.nextString());
                }
            } else if (name.equals("installationTaxAmount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$installationTaxAmount(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$installationTaxAmount((String) reader.nextString());
                }
            } else if (name.equals("cpeInstallationCost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallationCost(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallationCost((String) reader.nextString());
                }
            } else if (name.equals("cpeInstallmentCost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCost(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeInstallmentCost((String) reader.nextString());
                }
            } else if (name.equals("cpeTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTax(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTax((String) reader.nextString());
                }
            } else if (name.equals("cpeTotalCost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTotalCost(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$cpeTotalCost((String) reader.nextString());
                }
            } else if (name.equals("upFrontCharges")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$upFrontCharges(null);
                } else {
                    ((CPEDataModelRealmProxyInterface) obj).realmSet$upFrontCharges((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'cpeProfileIDcpeInstallmentCount'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.CPEDataModel copyOrUpdate(Realm realm, com.app.apsfl.models.CPEDataModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CPEDataModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.CPEDataModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.CPEDataModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((CPEDataModelRealmProxyInterface) object).realmGet$cpeProfileIDcpeInstallmentCount();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CPEDataModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CPEDataModelRealmProxy();
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

    public static com.app.apsfl.models.CPEDataModel copy(Realm realm, com.app.apsfl.models.CPEDataModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CPEDataModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.CPEDataModel realmObject = realm.createObjectInternal(com.app.apsfl.models.CPEDataModel.class, ((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeProfileIDcpeInstallmentCount(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeProfileID(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeProfileID());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeModelName(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeModelName());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeProfileName(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeProfileName());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeModelDetails(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeModelDetails());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpePurchaseCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpePurchaseCost());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeRentalCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeRentalCost());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeLovType(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeLovType());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeInstallmentCount(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeInstallmentCount());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$installationTaxAmount(((CPEDataModelRealmProxyInterface) newObject).realmGet$installationTaxAmount());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeInstallationCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeInstallationCost());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeInstallmentCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeInstallmentCost());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeTax(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeTax());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeTotalCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeTotalCost());
            ((CPEDataModelRealmProxyInterface) realmObject).realmSet$upFrontCharges(((CPEDataModelRealmProxyInterface) newObject).realmGet$upFrontCharges());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.CPEDataModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CPEDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEDataModelColumnInfo columnInfo = (CPEDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((CPEDataModelRealmProxyInterface) object).realmGet$cpeProfileIDcpeInstallmentCount();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
        String realmGet$cpeModelName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelName();
        if (realmGet$cpeModelName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeModelNameIndex, rowIndex, realmGet$cpeModelName, false);
        }
        String realmGet$cpeProfileName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileName();
        if (realmGet$cpeProfileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeProfileNameIndex, rowIndex, realmGet$cpeProfileName, false);
        }
        String realmGet$cpeModelDetails = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelDetails();
        if (realmGet$cpeModelDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeModelDetailsIndex, rowIndex, realmGet$cpeModelDetails, false);
        }
        String realmGet$cpePurchaseCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpePurchaseCost();
        if (realmGet$cpePurchaseCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpePurchaseCostIndex, rowIndex, realmGet$cpePurchaseCost, false);
        }
        String realmGet$cpeRentalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeRentalCost();
        if (realmGet$cpeRentalCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeRentalCostIndex, rowIndex, realmGet$cpeRentalCost, false);
        }
        String realmGet$cpeLovType = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeLovType();
        if (realmGet$cpeLovType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeLovTypeIndex, rowIndex, realmGet$cpeLovType, false);
        }
        String realmGet$cpeInstallmentCount = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCount();
        if (realmGet$cpeInstallmentCount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCountIndex, rowIndex, realmGet$cpeInstallmentCount, false);
        }
        String realmGet$installationTaxAmount = ((CPEDataModelRealmProxyInterface)object).realmGet$installationTaxAmount();
        if (realmGet$installationTaxAmount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.installationTaxAmountIndex, rowIndex, realmGet$installationTaxAmount, false);
        }
        String realmGet$cpeInstallationCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallationCost();
        if (realmGet$cpeInstallationCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallationCostIndex, rowIndex, realmGet$cpeInstallationCost, false);
        }
        String realmGet$cpeInstallmentCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCost();
        if (realmGet$cpeInstallmentCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCostIndex, rowIndex, realmGet$cpeInstallmentCost, false);
        }
        String realmGet$cpeTax = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTax();
        if (realmGet$cpeTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeTaxIndex, rowIndex, realmGet$cpeTax, false);
        }
        String realmGet$cpeTotalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTotalCost();
        if (realmGet$cpeTotalCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeTotalCostIndex, rowIndex, realmGet$cpeTotalCost, false);
        }
        String realmGet$upFrontCharges = ((CPEDataModelRealmProxyInterface)object).realmGet$upFrontCharges();
        if (realmGet$upFrontCharges != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.upFrontChargesIndex, rowIndex, realmGet$upFrontCharges, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CPEDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEDataModelColumnInfo columnInfo = (CPEDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CPEDataModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CPEDataModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((CPEDataModelRealmProxyInterface) object).realmGet$cpeProfileIDcpeInstallmentCount();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
                String realmGet$cpeModelName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelName();
                if (realmGet$cpeModelName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeModelNameIndex, rowIndex, realmGet$cpeModelName, false);
                }
                String realmGet$cpeProfileName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileName();
                if (realmGet$cpeProfileName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeProfileNameIndex, rowIndex, realmGet$cpeProfileName, false);
                }
                String realmGet$cpeModelDetails = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelDetails();
                if (realmGet$cpeModelDetails != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeModelDetailsIndex, rowIndex, realmGet$cpeModelDetails, false);
                }
                String realmGet$cpePurchaseCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpePurchaseCost();
                if (realmGet$cpePurchaseCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpePurchaseCostIndex, rowIndex, realmGet$cpePurchaseCost, false);
                }
                String realmGet$cpeRentalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeRentalCost();
                if (realmGet$cpeRentalCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeRentalCostIndex, rowIndex, realmGet$cpeRentalCost, false);
                }
                String realmGet$cpeLovType = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeLovType();
                if (realmGet$cpeLovType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeLovTypeIndex, rowIndex, realmGet$cpeLovType, false);
                }
                String realmGet$cpeInstallmentCount = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCount();
                if (realmGet$cpeInstallmentCount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCountIndex, rowIndex, realmGet$cpeInstallmentCount, false);
                }
                String realmGet$installationTaxAmount = ((CPEDataModelRealmProxyInterface)object).realmGet$installationTaxAmount();
                if (realmGet$installationTaxAmount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.installationTaxAmountIndex, rowIndex, realmGet$installationTaxAmount, false);
                }
                String realmGet$cpeInstallationCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallationCost();
                if (realmGet$cpeInstallationCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallationCostIndex, rowIndex, realmGet$cpeInstallationCost, false);
                }
                String realmGet$cpeInstallmentCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCost();
                if (realmGet$cpeInstallmentCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCostIndex, rowIndex, realmGet$cpeInstallmentCost, false);
                }
                String realmGet$cpeTax = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTax();
                if (realmGet$cpeTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeTaxIndex, rowIndex, realmGet$cpeTax, false);
                }
                String realmGet$cpeTotalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTotalCost();
                if (realmGet$cpeTotalCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeTotalCostIndex, rowIndex, realmGet$cpeTotalCost, false);
                }
                String realmGet$upFrontCharges = ((CPEDataModelRealmProxyInterface)object).realmGet$upFrontCharges();
                if (realmGet$upFrontCharges != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.upFrontChargesIndex, rowIndex, realmGet$upFrontCharges, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.CPEDataModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CPEDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEDataModelColumnInfo columnInfo = (CPEDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((CPEDataModelRealmProxyInterface) object).realmGet$cpeProfileIDcpeInstallmentCount();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
        String realmGet$cpeModelName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelName();
        if (realmGet$cpeModelName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeModelNameIndex, rowIndex, realmGet$cpeModelName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeModelNameIndex, rowIndex, false);
        }
        String realmGet$cpeProfileName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileName();
        if (realmGet$cpeProfileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeProfileNameIndex, rowIndex, realmGet$cpeProfileName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeProfileNameIndex, rowIndex, false);
        }
        String realmGet$cpeModelDetails = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelDetails();
        if (realmGet$cpeModelDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeModelDetailsIndex, rowIndex, realmGet$cpeModelDetails, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeModelDetailsIndex, rowIndex, false);
        }
        String realmGet$cpePurchaseCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpePurchaseCost();
        if (realmGet$cpePurchaseCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpePurchaseCostIndex, rowIndex, realmGet$cpePurchaseCost, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpePurchaseCostIndex, rowIndex, false);
        }
        String realmGet$cpeRentalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeRentalCost();
        if (realmGet$cpeRentalCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeRentalCostIndex, rowIndex, realmGet$cpeRentalCost, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeRentalCostIndex, rowIndex, false);
        }
        String realmGet$cpeLovType = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeLovType();
        if (realmGet$cpeLovType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeLovTypeIndex, rowIndex, realmGet$cpeLovType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeLovTypeIndex, rowIndex, false);
        }
        String realmGet$cpeInstallmentCount = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCount();
        if (realmGet$cpeInstallmentCount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCountIndex, rowIndex, realmGet$cpeInstallmentCount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeInstallmentCountIndex, rowIndex, false);
        }
        String realmGet$installationTaxAmount = ((CPEDataModelRealmProxyInterface)object).realmGet$installationTaxAmount();
        if (realmGet$installationTaxAmount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.installationTaxAmountIndex, rowIndex, realmGet$installationTaxAmount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.installationTaxAmountIndex, rowIndex, false);
        }
        String realmGet$cpeInstallationCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallationCost();
        if (realmGet$cpeInstallationCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallationCostIndex, rowIndex, realmGet$cpeInstallationCost, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeInstallationCostIndex, rowIndex, false);
        }
        String realmGet$cpeInstallmentCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCost();
        if (realmGet$cpeInstallmentCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCostIndex, rowIndex, realmGet$cpeInstallmentCost, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeInstallmentCostIndex, rowIndex, false);
        }
        String realmGet$cpeTax = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTax();
        if (realmGet$cpeTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeTaxIndex, rowIndex, realmGet$cpeTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeTaxIndex, rowIndex, false);
        }
        String realmGet$cpeTotalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTotalCost();
        if (realmGet$cpeTotalCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeTotalCostIndex, rowIndex, realmGet$cpeTotalCost, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeTotalCostIndex, rowIndex, false);
        }
        String realmGet$upFrontCharges = ((CPEDataModelRealmProxyInterface)object).realmGet$upFrontCharges();
        if (realmGet$upFrontCharges != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.upFrontChargesIndex, rowIndex, realmGet$upFrontCharges, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.upFrontChargesIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CPEDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEDataModelColumnInfo columnInfo = (CPEDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CPEDataModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CPEDataModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((CPEDataModelRealmProxyInterface) object).realmGet$cpeProfileIDcpeInstallmentCount();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
                String realmGet$cpeModelName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelName();
                if (realmGet$cpeModelName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeModelNameIndex, rowIndex, realmGet$cpeModelName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeModelNameIndex, rowIndex, false);
                }
                String realmGet$cpeProfileName = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeProfileName();
                if (realmGet$cpeProfileName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeProfileNameIndex, rowIndex, realmGet$cpeProfileName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeProfileNameIndex, rowIndex, false);
                }
                String realmGet$cpeModelDetails = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeModelDetails();
                if (realmGet$cpeModelDetails != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeModelDetailsIndex, rowIndex, realmGet$cpeModelDetails, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeModelDetailsIndex, rowIndex, false);
                }
                String realmGet$cpePurchaseCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpePurchaseCost();
                if (realmGet$cpePurchaseCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpePurchaseCostIndex, rowIndex, realmGet$cpePurchaseCost, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpePurchaseCostIndex, rowIndex, false);
                }
                String realmGet$cpeRentalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeRentalCost();
                if (realmGet$cpeRentalCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeRentalCostIndex, rowIndex, realmGet$cpeRentalCost, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeRentalCostIndex, rowIndex, false);
                }
                String realmGet$cpeLovType = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeLovType();
                if (realmGet$cpeLovType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeLovTypeIndex, rowIndex, realmGet$cpeLovType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeLovTypeIndex, rowIndex, false);
                }
                String realmGet$cpeInstallmentCount = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCount();
                if (realmGet$cpeInstallmentCount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCountIndex, rowIndex, realmGet$cpeInstallmentCount, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeInstallmentCountIndex, rowIndex, false);
                }
                String realmGet$installationTaxAmount = ((CPEDataModelRealmProxyInterface)object).realmGet$installationTaxAmount();
                if (realmGet$installationTaxAmount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.installationTaxAmountIndex, rowIndex, realmGet$installationTaxAmount, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.installationTaxAmountIndex, rowIndex, false);
                }
                String realmGet$cpeInstallationCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallationCost();
                if (realmGet$cpeInstallationCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallationCostIndex, rowIndex, realmGet$cpeInstallationCost, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeInstallationCostIndex, rowIndex, false);
                }
                String realmGet$cpeInstallmentCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeInstallmentCost();
                if (realmGet$cpeInstallmentCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeInstallmentCostIndex, rowIndex, realmGet$cpeInstallmentCost, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeInstallmentCostIndex, rowIndex, false);
                }
                String realmGet$cpeTax = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTax();
                if (realmGet$cpeTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeTaxIndex, rowIndex, realmGet$cpeTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeTaxIndex, rowIndex, false);
                }
                String realmGet$cpeTotalCost = ((CPEDataModelRealmProxyInterface)object).realmGet$cpeTotalCost();
                if (realmGet$cpeTotalCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeTotalCostIndex, rowIndex, realmGet$cpeTotalCost, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeTotalCostIndex, rowIndex, false);
                }
                String realmGet$upFrontCharges = ((CPEDataModelRealmProxyInterface)object).realmGet$upFrontCharges();
                if (realmGet$upFrontCharges != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.upFrontChargesIndex, rowIndex, realmGet$upFrontCharges, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.upFrontChargesIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.CPEDataModel createDetachedCopy(com.app.apsfl.models.CPEDataModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.CPEDataModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.CPEDataModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.CPEDataModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.CPEDataModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeProfileIDcpeInstallmentCount(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeProfileIDcpeInstallmentCount());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeProfileID(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeProfileID());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeModelName(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeModelName());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeProfileName(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeProfileName());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeModelDetails(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeModelDetails());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpePurchaseCost(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpePurchaseCost());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeRentalCost(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeRentalCost());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeLovType(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeLovType());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeInstallmentCount(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeInstallmentCount());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$installationTaxAmount(((CPEDataModelRealmProxyInterface) realmObject).realmGet$installationTaxAmount());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeInstallationCost(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeInstallationCost());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeInstallmentCost(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeInstallmentCost());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeTax(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeTax());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$cpeTotalCost(((CPEDataModelRealmProxyInterface) realmObject).realmGet$cpeTotalCost());
        ((CPEDataModelRealmProxyInterface) unmanagedObject).realmSet$upFrontCharges(((CPEDataModelRealmProxyInterface) realmObject).realmGet$upFrontCharges());
        return unmanagedObject;
    }

    static com.app.apsfl.models.CPEDataModel update(Realm realm, com.app.apsfl.models.CPEDataModel realmObject, com.app.apsfl.models.CPEDataModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeProfileID(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeProfileID());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeModelName(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeModelName());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeProfileName(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeProfileName());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeModelDetails(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeModelDetails());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpePurchaseCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpePurchaseCost());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeRentalCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeRentalCost());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeLovType(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeLovType());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeInstallmentCount(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeInstallmentCount());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$installationTaxAmount(((CPEDataModelRealmProxyInterface) newObject).realmGet$installationTaxAmount());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeInstallationCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeInstallationCost());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeInstallmentCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeInstallmentCost());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeTax(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeTax());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$cpeTotalCost(((CPEDataModelRealmProxyInterface) newObject).realmGet$cpeTotalCost());
        ((CPEDataModelRealmProxyInterface) realmObject).realmSet$upFrontCharges(((CPEDataModelRealmProxyInterface) newObject).realmGet$upFrontCharges());
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
        CPEDataModelRealmProxy aCPEDataModel = (CPEDataModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCPEDataModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCPEDataModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCPEDataModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
