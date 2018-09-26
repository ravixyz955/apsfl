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

public class ProductModelRealmProxy extends com.app.apsfl.models.ProductModel
    implements RealmObjectProxy, ProductModelRealmProxyInterface {

    static final class ProductModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long productUniqueKeyIndex;
        public long productCodeIndex;
        public long productNameIndex;
        public long productDateIndex;
        public long productTenantCodeIndex;
        public long voipServiceCodeIndex;
        public long productTenantNameIndex;
        public long productRecurringChargeIndex;
        public long productActivationChargeIndex;
        public long productSecurityChargeIndex;
        public long productRecurringTaxIndex;
        public long productActivationTaxIndex;
        public long productSecurityTaxIndex;
        public long productTaxIndex;
        public long productTotalChargeIndex;
        public long productLockInPeriodIndex;
        public long productTypeIndex;
        public long isProductCheckBoxVisibleIndex;
        public long isProductCheckedIndex;
        public long isIndividualProductIndex;
        public long isProductInfoShownIndex;
        public long featureCodesIndex;
        public long productDataIndex;
        public long totalProductsCostIndex;
        public long coreServiceCodeIndex;
        public long srvcNameIndex;
        public long serviceCodeIndex;

        ProductModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(27);
            this.productUniqueKeyIndex = getValidColumnIndex(path, table, "ProductModel", "productUniqueKey");
            indicesMap.put("productUniqueKey", this.productUniqueKeyIndex);
            this.productCodeIndex = getValidColumnIndex(path, table, "ProductModel", "productCode");
            indicesMap.put("productCode", this.productCodeIndex);
            this.productNameIndex = getValidColumnIndex(path, table, "ProductModel", "productName");
            indicesMap.put("productName", this.productNameIndex);
            this.productDateIndex = getValidColumnIndex(path, table, "ProductModel", "productDate");
            indicesMap.put("productDate", this.productDateIndex);
            this.productTenantCodeIndex = getValidColumnIndex(path, table, "ProductModel", "productTenantCode");
            indicesMap.put("productTenantCode", this.productTenantCodeIndex);
            this.voipServiceCodeIndex = getValidColumnIndex(path, table, "ProductModel", "voipServiceCode");
            indicesMap.put("voipServiceCode", this.voipServiceCodeIndex);
            this.productTenantNameIndex = getValidColumnIndex(path, table, "ProductModel", "productTenantName");
            indicesMap.put("productTenantName", this.productTenantNameIndex);
            this.productRecurringChargeIndex = getValidColumnIndex(path, table, "ProductModel", "productRecurringCharge");
            indicesMap.put("productRecurringCharge", this.productRecurringChargeIndex);
            this.productActivationChargeIndex = getValidColumnIndex(path, table, "ProductModel", "productActivationCharge");
            indicesMap.put("productActivationCharge", this.productActivationChargeIndex);
            this.productSecurityChargeIndex = getValidColumnIndex(path, table, "ProductModel", "productSecurityCharge");
            indicesMap.put("productSecurityCharge", this.productSecurityChargeIndex);
            this.productRecurringTaxIndex = getValidColumnIndex(path, table, "ProductModel", "productRecurringTax");
            indicesMap.put("productRecurringTax", this.productRecurringTaxIndex);
            this.productActivationTaxIndex = getValidColumnIndex(path, table, "ProductModel", "productActivationTax");
            indicesMap.put("productActivationTax", this.productActivationTaxIndex);
            this.productSecurityTaxIndex = getValidColumnIndex(path, table, "ProductModel", "productSecurityTax");
            indicesMap.put("productSecurityTax", this.productSecurityTaxIndex);
            this.productTaxIndex = getValidColumnIndex(path, table, "ProductModel", "productTax");
            indicesMap.put("productTax", this.productTaxIndex);
            this.productTotalChargeIndex = getValidColumnIndex(path, table, "ProductModel", "productTotalCharge");
            indicesMap.put("productTotalCharge", this.productTotalChargeIndex);
            this.productLockInPeriodIndex = getValidColumnIndex(path, table, "ProductModel", "productLockInPeriod");
            indicesMap.put("productLockInPeriod", this.productLockInPeriodIndex);
            this.productTypeIndex = getValidColumnIndex(path, table, "ProductModel", "productType");
            indicesMap.put("productType", this.productTypeIndex);
            this.isProductCheckBoxVisibleIndex = getValidColumnIndex(path, table, "ProductModel", "isProductCheckBoxVisible");
            indicesMap.put("isProductCheckBoxVisible", this.isProductCheckBoxVisibleIndex);
            this.isProductCheckedIndex = getValidColumnIndex(path, table, "ProductModel", "isProductChecked");
            indicesMap.put("isProductChecked", this.isProductCheckedIndex);
            this.isIndividualProductIndex = getValidColumnIndex(path, table, "ProductModel", "isIndividualProduct");
            indicesMap.put("isIndividualProduct", this.isIndividualProductIndex);
            this.isProductInfoShownIndex = getValidColumnIndex(path, table, "ProductModel", "isProductInfoShown");
            indicesMap.put("isProductInfoShown", this.isProductInfoShownIndex);
            this.featureCodesIndex = getValidColumnIndex(path, table, "ProductModel", "featureCodes");
            indicesMap.put("featureCodes", this.featureCodesIndex);
            this.productDataIndex = getValidColumnIndex(path, table, "ProductModel", "productData");
            indicesMap.put("productData", this.productDataIndex);
            this.totalProductsCostIndex = getValidColumnIndex(path, table, "ProductModel", "totalProductsCost");
            indicesMap.put("totalProductsCost", this.totalProductsCostIndex);
            this.coreServiceCodeIndex = getValidColumnIndex(path, table, "ProductModel", "coreServiceCode");
            indicesMap.put("coreServiceCode", this.coreServiceCodeIndex);
            this.srvcNameIndex = getValidColumnIndex(path, table, "ProductModel", "srvcName");
            indicesMap.put("srvcName", this.srvcNameIndex);
            this.serviceCodeIndex = getValidColumnIndex(path, table, "ProductModel", "serviceCode");
            indicesMap.put("serviceCode", this.serviceCodeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ProductModelColumnInfo otherInfo = (ProductModelColumnInfo) other;
            this.productUniqueKeyIndex = otherInfo.productUniqueKeyIndex;
            this.productCodeIndex = otherInfo.productCodeIndex;
            this.productNameIndex = otherInfo.productNameIndex;
            this.productDateIndex = otherInfo.productDateIndex;
            this.productTenantCodeIndex = otherInfo.productTenantCodeIndex;
            this.voipServiceCodeIndex = otherInfo.voipServiceCodeIndex;
            this.productTenantNameIndex = otherInfo.productTenantNameIndex;
            this.productRecurringChargeIndex = otherInfo.productRecurringChargeIndex;
            this.productActivationChargeIndex = otherInfo.productActivationChargeIndex;
            this.productSecurityChargeIndex = otherInfo.productSecurityChargeIndex;
            this.productRecurringTaxIndex = otherInfo.productRecurringTaxIndex;
            this.productActivationTaxIndex = otherInfo.productActivationTaxIndex;
            this.productSecurityTaxIndex = otherInfo.productSecurityTaxIndex;
            this.productTaxIndex = otherInfo.productTaxIndex;
            this.productTotalChargeIndex = otherInfo.productTotalChargeIndex;
            this.productLockInPeriodIndex = otherInfo.productLockInPeriodIndex;
            this.productTypeIndex = otherInfo.productTypeIndex;
            this.isProductCheckBoxVisibleIndex = otherInfo.isProductCheckBoxVisibleIndex;
            this.isProductCheckedIndex = otherInfo.isProductCheckedIndex;
            this.isIndividualProductIndex = otherInfo.isIndividualProductIndex;
            this.isProductInfoShownIndex = otherInfo.isProductInfoShownIndex;
            this.featureCodesIndex = otherInfo.featureCodesIndex;
            this.productDataIndex = otherInfo.productDataIndex;
            this.totalProductsCostIndex = otherInfo.totalProductsCostIndex;
            this.coreServiceCodeIndex = otherInfo.coreServiceCodeIndex;
            this.srvcNameIndex = otherInfo.srvcNameIndex;
            this.serviceCodeIndex = otherInfo.serviceCodeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ProductModelColumnInfo clone() {
            return (ProductModelColumnInfo) super.clone();
        }

    }
    private ProductModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("productUniqueKey");
        fieldNames.add("productCode");
        fieldNames.add("productName");
        fieldNames.add("productDate");
        fieldNames.add("productTenantCode");
        fieldNames.add("voipServiceCode");
        fieldNames.add("productTenantName");
        fieldNames.add("productRecurringCharge");
        fieldNames.add("productActivationCharge");
        fieldNames.add("productSecurityCharge");
        fieldNames.add("productRecurringTax");
        fieldNames.add("productActivationTax");
        fieldNames.add("productSecurityTax");
        fieldNames.add("productTax");
        fieldNames.add("productTotalCharge");
        fieldNames.add("productLockInPeriod");
        fieldNames.add("productType");
        fieldNames.add("isProductCheckBoxVisible");
        fieldNames.add("isProductChecked");
        fieldNames.add("isIndividualProduct");
        fieldNames.add("isProductInfoShown");
        fieldNames.add("featureCodes");
        fieldNames.add("productData");
        fieldNames.add("totalProductsCost");
        fieldNames.add("coreServiceCode");
        fieldNames.add("srvcName");
        fieldNames.add("serviceCode");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.ProductModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$productUniqueKey() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productUniqueKeyIndex);
    }

    public void realmSet$productUniqueKey(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'productUniqueKey' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$productCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productCodeIndex);
    }

    public void realmSet$productCode(String value) {
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
                row.getTable().setNull(columnInfo.productCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productNameIndex);
    }

    public void realmSet$productName(String value) {
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
                row.getTable().setNull(columnInfo.productNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productDateIndex);
    }

    public void realmSet$productDate(String value) {
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
                row.getTable().setNull(columnInfo.productDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productDateIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productTenantCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productTenantCodeIndex);
    }

    public void realmSet$productTenantCode(String value) {
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
                row.getTable().setNull(columnInfo.productTenantCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productTenantCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productTenantCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productTenantCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$voipServiceCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.voipServiceCodeIndex);
    }

    public void realmSet$voipServiceCode(String value) {
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
                row.getTable().setNull(columnInfo.voipServiceCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.voipServiceCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.voipServiceCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.voipServiceCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productTenantName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productTenantNameIndex);
    }

    public void realmSet$productTenantName(String value) {
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
                row.getTable().setNull(columnInfo.productTenantNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productTenantNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productTenantNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productTenantNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productRecurringCharge() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productRecurringChargeIndex);
    }

    public void realmSet$productRecurringCharge(String value) {
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
                row.getTable().setNull(columnInfo.productRecurringChargeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productRecurringChargeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productRecurringChargeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productRecurringChargeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productActivationCharge() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productActivationChargeIndex);
    }

    public void realmSet$productActivationCharge(String value) {
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
                row.getTable().setNull(columnInfo.productActivationChargeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productActivationChargeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productActivationChargeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productActivationChargeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productSecurityCharge() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productSecurityChargeIndex);
    }

    public void realmSet$productSecurityCharge(String value) {
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
                row.getTable().setNull(columnInfo.productSecurityChargeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productSecurityChargeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productSecurityChargeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productSecurityChargeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productRecurringTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productRecurringTaxIndex);
    }

    public void realmSet$productRecurringTax(String value) {
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
                row.getTable().setNull(columnInfo.productRecurringTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productRecurringTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productRecurringTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productRecurringTaxIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productActivationTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productActivationTaxIndex);
    }

    public void realmSet$productActivationTax(String value) {
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
                row.getTable().setNull(columnInfo.productActivationTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productActivationTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productActivationTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productActivationTaxIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productSecurityTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productSecurityTaxIndex);
    }

    public void realmSet$productSecurityTax(String value) {
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
                row.getTable().setNull(columnInfo.productSecurityTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productSecurityTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productSecurityTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productSecurityTaxIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productTaxIndex);
    }

    public void realmSet$productTax(String value) {
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
                row.getTable().setNull(columnInfo.productTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productTaxIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productTotalCharge() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productTotalChargeIndex);
    }

    public void realmSet$productTotalCharge(String value) {
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
                row.getTable().setNull(columnInfo.productTotalChargeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productTotalChargeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productTotalChargeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productTotalChargeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productLockInPeriod() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productLockInPeriodIndex);
    }

    public void realmSet$productLockInPeriod(String value) {
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
                row.getTable().setNull(columnInfo.productLockInPeriodIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productLockInPeriodIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productLockInPeriodIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productLockInPeriodIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productTypeIndex);
    }

    public void realmSet$productType(String value) {
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
                row.getTable().setNull(columnInfo.productTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productTypeIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isProductCheckBoxVisible() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isProductCheckBoxVisibleIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isProductCheckBoxVisibleIndex);
    }

    public void realmSet$isProductCheckBoxVisible(Boolean value) {
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
                row.getTable().setNull(columnInfo.isProductCheckBoxVisibleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isProductCheckBoxVisibleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isProductCheckBoxVisibleIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isProductCheckBoxVisibleIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isProductChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isProductCheckedIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isProductCheckedIndex);
    }

    public void realmSet$isProductChecked(Boolean value) {
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
                row.getTable().setNull(columnInfo.isProductCheckedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isProductCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isProductCheckedIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isProductCheckedIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isIndividualProduct() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isIndividualProductIndex);
    }

    public void realmSet$isIndividualProduct(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isIndividualProductIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isIndividualProductIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isProductInfoShown() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isProductInfoShownIndex);
    }

    public void realmSet$isProductInfoShown(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isProductInfoShownIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isProductInfoShownIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$featureCodes() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.featureCodesIndex);
    }

    public void realmSet$featureCodes(String value) {
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
                row.getTable().setNull(columnInfo.featureCodesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.featureCodesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.featureCodesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.featureCodesIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$productData() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productDataIndex);
    }

    public void realmSet$productData(String value) {
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
                row.getTable().setNull(columnInfo.productDataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productDataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productDataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productDataIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$totalProductsCost() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.totalProductsCostIndex);
    }

    public void realmSet$totalProductsCost(String value) {
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
                row.getTable().setNull(columnInfo.totalProductsCostIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.totalProductsCostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalProductsCostIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.totalProductsCostIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$coreServiceCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.coreServiceCodeIndex);
    }

    public void realmSet$coreServiceCode(String value) {
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
                row.getTable().setNull(columnInfo.coreServiceCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.coreServiceCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.coreServiceCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.coreServiceCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$srvcName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.srvcNameIndex);
    }

    public void realmSet$srvcName(String value) {
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
                row.getTable().setNull(columnInfo.srvcNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.srvcNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.srvcNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.srvcNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$serviceCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.serviceCodeIndex);
    }

    public void realmSet$serviceCode(String value) {
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
                row.getTable().setNull(columnInfo.serviceCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.serviceCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.serviceCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.serviceCodeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ProductModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ProductModel");
            realmObjectSchema.add(new Property("productUniqueKey", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productTenantCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voipServiceCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productTenantName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productRecurringCharge", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productActivationCharge", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productSecurityCharge", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productRecurringTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productActivationTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productSecurityTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productTotalCharge", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productLockInPeriod", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isProductCheckBoxVisible", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isProductChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isIndividualProduct", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("isProductInfoShown", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("featureCodes", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("productData", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("totalProductsCost", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("coreServiceCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("srvcName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("serviceCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("ProductModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_ProductModel")) {
            Table table = sharedRealm.getTable("class_ProductModel");
            table.addColumn(RealmFieldType.STRING, "productUniqueKey", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productTenantCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "voipServiceCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productTenantName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productRecurringCharge", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productActivationCharge", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productSecurityCharge", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productRecurringTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productActivationTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productSecurityTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productTotalCharge", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productLockInPeriod", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productType", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isProductCheckBoxVisible", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isProductChecked", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isIndividualProduct", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isProductInfoShown", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "featureCodes", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "productData", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "totalProductsCost", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "coreServiceCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "srvcName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "serviceCode", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("productUniqueKey"));
            table.setPrimaryKey("productUniqueKey");
            return table;
        }
        return sharedRealm.getTable("class_ProductModel");
    }

    public static ProductModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_ProductModel")) {
            Table table = sharedRealm.getTable("class_ProductModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 27) {
                if (columnCount < 27) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 27 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 27 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 27 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 27; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ProductModelColumnInfo columnInfo = new ProductModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("productUniqueKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productUniqueKey' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productUniqueKey") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productUniqueKey' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productUniqueKeyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'productUniqueKey' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("productUniqueKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'productUniqueKey' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("productUniqueKey"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'productUniqueKey' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("productCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productCode' is required. Either set @Required to field 'productCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productName' is required. Either set @Required to field 'productName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productDate' is required. Either set @Required to field 'productDate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productTenantCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productTenantCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productTenantCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productTenantCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productTenantCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productTenantCode' is required. Either set @Required to field 'productTenantCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("voipServiceCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'voipServiceCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("voipServiceCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'voipServiceCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.voipServiceCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'voipServiceCode' is required. Either set @Required to field 'voipServiceCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productTenantName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productTenantName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productTenantName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productTenantName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productTenantNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productTenantName' is required. Either set @Required to field 'productTenantName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productRecurringCharge")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productRecurringCharge' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productRecurringCharge") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productRecurringCharge' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productRecurringChargeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productRecurringCharge' is required. Either set @Required to field 'productRecurringCharge' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productActivationCharge")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productActivationCharge' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productActivationCharge") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productActivationCharge' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productActivationChargeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productActivationCharge' is required. Either set @Required to field 'productActivationCharge' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productSecurityCharge")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productSecurityCharge' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productSecurityCharge") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productSecurityCharge' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productSecurityChargeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productSecurityCharge' is required. Either set @Required to field 'productSecurityCharge' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productRecurringTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productRecurringTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productRecurringTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productRecurringTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productRecurringTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productRecurringTax' is required. Either set @Required to field 'productRecurringTax' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productActivationTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productActivationTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productActivationTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productActivationTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productActivationTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productActivationTax' is required. Either set @Required to field 'productActivationTax' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productSecurityTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productSecurityTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productSecurityTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productSecurityTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productSecurityTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productSecurityTax' is required. Either set @Required to field 'productSecurityTax' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productTax' is required. Either set @Required to field 'productTax' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productTotalCharge")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productTotalCharge' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productTotalCharge") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productTotalCharge' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productTotalChargeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productTotalCharge' is required. Either set @Required to field 'productTotalCharge' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productLockInPeriod")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productLockInPeriod' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productLockInPeriod") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productLockInPeriod' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productLockInPeriodIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productLockInPeriod' is required. Either set @Required to field 'productLockInPeriod' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productType") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productType' is required. Either set @Required to field 'productType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isProductCheckBoxVisible")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isProductCheckBoxVisible' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isProductCheckBoxVisible") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isProductCheckBoxVisible' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isProductCheckBoxVisibleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isProductCheckBoxVisible' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isProductCheckBoxVisible' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isProductChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isProductChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isProductChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isProductChecked' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isProductCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isProductChecked' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isProductChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isIndividualProduct")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isIndividualProduct' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isIndividualProduct") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isIndividualProduct' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isIndividualProductIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isIndividualProduct' does support null values in the existing Realm file. Use corresponding boxed type for field 'isIndividualProduct' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isProductInfoShown")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isProductInfoShown' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isProductInfoShown") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isProductInfoShown' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isProductInfoShownIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isProductInfoShown' does support null values in the existing Realm file. Use corresponding boxed type for field 'isProductInfoShown' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("featureCodes")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'featureCodes' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("featureCodes") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'featureCodes' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.featureCodesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'featureCodes' is required. Either set @Required to field 'featureCodes' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productData")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productData' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("productData") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productData' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.productDataIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productData' is required. Either set @Required to field 'productData' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("totalProductsCost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalProductsCost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("totalProductsCost") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'totalProductsCost' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.totalProductsCostIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalProductsCost' is required. Either set @Required to field 'totalProductsCost' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("coreServiceCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'coreServiceCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("coreServiceCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'coreServiceCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.coreServiceCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'coreServiceCode' is required. Either set @Required to field 'coreServiceCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("srvcName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'srvcName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("srvcName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'srvcName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.srvcNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'srvcName' is required. Either set @Required to field 'srvcName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("serviceCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'serviceCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("serviceCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'serviceCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.serviceCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'serviceCode' is required. Either set @Required to field 'serviceCode' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ProductModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ProductModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.ProductModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.ProductModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.ProductModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("productUniqueKey")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("productUniqueKey"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.ProductModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ProductModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("productUniqueKey")) {
                if (json.isNull("productUniqueKey")) {
                    obj = (io.realm.ProductModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.ProductModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ProductModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.ProductModel.class, json.getString("productUniqueKey"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'productUniqueKey'.");
            }
        }
        if (json.has("productCode")) {
            if (json.isNull("productCode")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productCode(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productCode((String) json.getString("productCode"));
            }
        }
        if (json.has("productName")) {
            if (json.isNull("productName")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productName(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productName((String) json.getString("productName"));
            }
        }
        if (json.has("productDate")) {
            if (json.isNull("productDate")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productDate(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productDate((String) json.getString("productDate"));
            }
        }
        if (json.has("productTenantCode")) {
            if (json.isNull("productTenantCode")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTenantCode(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTenantCode((String) json.getString("productTenantCode"));
            }
        }
        if (json.has("voipServiceCode")) {
            if (json.isNull("voipServiceCode")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$voipServiceCode(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$voipServiceCode((String) json.getString("voipServiceCode"));
            }
        }
        if (json.has("productTenantName")) {
            if (json.isNull("productTenantName")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTenantName(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTenantName((String) json.getString("productTenantName"));
            }
        }
        if (json.has("productRecurringCharge")) {
            if (json.isNull("productRecurringCharge")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringCharge(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringCharge((String) json.getString("productRecurringCharge"));
            }
        }
        if (json.has("productActivationCharge")) {
            if (json.isNull("productActivationCharge")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productActivationCharge(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productActivationCharge((String) json.getString("productActivationCharge"));
            }
        }
        if (json.has("productSecurityCharge")) {
            if (json.isNull("productSecurityCharge")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityCharge(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityCharge((String) json.getString("productSecurityCharge"));
            }
        }
        if (json.has("productRecurringTax")) {
            if (json.isNull("productRecurringTax")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringTax(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringTax((String) json.getString("productRecurringTax"));
            }
        }
        if (json.has("productActivationTax")) {
            if (json.isNull("productActivationTax")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productActivationTax(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productActivationTax((String) json.getString("productActivationTax"));
            }
        }
        if (json.has("productSecurityTax")) {
            if (json.isNull("productSecurityTax")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityTax(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityTax((String) json.getString("productSecurityTax"));
            }
        }
        if (json.has("productTax")) {
            if (json.isNull("productTax")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTax(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTax((String) json.getString("productTax"));
            }
        }
        if (json.has("productTotalCharge")) {
            if (json.isNull("productTotalCharge")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTotalCharge(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productTotalCharge((String) json.getString("productTotalCharge"));
            }
        }
        if (json.has("productLockInPeriod")) {
            if (json.isNull("productLockInPeriod")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productLockInPeriod(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productLockInPeriod((String) json.getString("productLockInPeriod"));
            }
        }
        if (json.has("productType")) {
            if (json.isNull("productType")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productType(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productType((String) json.getString("productType"));
            }
        }
        if (json.has("isProductCheckBoxVisible")) {
            if (json.isNull("isProductCheckBoxVisible")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$isProductCheckBoxVisible(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$isProductCheckBoxVisible((boolean) json.getBoolean("isProductCheckBoxVisible"));
            }
        }
        if (json.has("isProductChecked")) {
            if (json.isNull("isProductChecked")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$isProductChecked(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$isProductChecked((boolean) json.getBoolean("isProductChecked"));
            }
        }
        if (json.has("isIndividualProduct")) {
            if (json.isNull("isIndividualProduct")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isIndividualProduct' to null.");
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$isIndividualProduct((boolean) json.getBoolean("isIndividualProduct"));
            }
        }
        if (json.has("isProductInfoShown")) {
            if (json.isNull("isProductInfoShown")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isProductInfoShown' to null.");
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$isProductInfoShown((boolean) json.getBoolean("isProductInfoShown"));
            }
        }
        if (json.has("featureCodes")) {
            if (json.isNull("featureCodes")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$featureCodes(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$featureCodes((String) json.getString("featureCodes"));
            }
        }
        if (json.has("productData")) {
            if (json.isNull("productData")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$productData(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$productData((String) json.getString("productData"));
            }
        }
        if (json.has("totalProductsCost")) {
            if (json.isNull("totalProductsCost")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$totalProductsCost(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$totalProductsCost((String) json.getString("totalProductsCost"));
            }
        }
        if (json.has("coreServiceCode")) {
            if (json.isNull("coreServiceCode")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$coreServiceCode(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$coreServiceCode((String) json.getString("coreServiceCode"));
            }
        }
        if (json.has("srvcName")) {
            if (json.isNull("srvcName")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$srvcName(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$srvcName((String) json.getString("srvcName"));
            }
        }
        if (json.has("serviceCode")) {
            if (json.isNull("serviceCode")) {
                ((ProductModelRealmProxyInterface) obj).realmSet$serviceCode(null);
            } else {
                ((ProductModelRealmProxyInterface) obj).realmSet$serviceCode((String) json.getString("serviceCode"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.ProductModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.ProductModel obj = new com.app.apsfl.models.ProductModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("productUniqueKey")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productUniqueKey(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productUniqueKey((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("productCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productCode(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productCode((String) reader.nextString());
                }
            } else if (name.equals("productName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productName(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productName((String) reader.nextString());
                }
            } else if (name.equals("productDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productDate(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productDate((String) reader.nextString());
                }
            } else if (name.equals("productTenantCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTenantCode(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTenantCode((String) reader.nextString());
                }
            } else if (name.equals("voipServiceCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$voipServiceCode(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$voipServiceCode((String) reader.nextString());
                }
            } else if (name.equals("productTenantName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTenantName(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTenantName((String) reader.nextString());
                }
            } else if (name.equals("productRecurringCharge")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringCharge(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringCharge((String) reader.nextString());
                }
            } else if (name.equals("productActivationCharge")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productActivationCharge(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productActivationCharge((String) reader.nextString());
                }
            } else if (name.equals("productSecurityCharge")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityCharge(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityCharge((String) reader.nextString());
                }
            } else if (name.equals("productRecurringTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringTax(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productRecurringTax((String) reader.nextString());
                }
            } else if (name.equals("productActivationTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productActivationTax(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productActivationTax((String) reader.nextString());
                }
            } else if (name.equals("productSecurityTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityTax(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productSecurityTax((String) reader.nextString());
                }
            } else if (name.equals("productTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTax(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTax((String) reader.nextString());
                }
            } else if (name.equals("productTotalCharge")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTotalCharge(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productTotalCharge((String) reader.nextString());
                }
            } else if (name.equals("productLockInPeriod")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productLockInPeriod(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productLockInPeriod((String) reader.nextString());
                }
            } else if (name.equals("productType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productType(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productType((String) reader.nextString());
                }
            } else if (name.equals("isProductCheckBoxVisible")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$isProductCheckBoxVisible(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$isProductCheckBoxVisible((boolean) reader.nextBoolean());
                }
            } else if (name.equals("isProductChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$isProductChecked(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$isProductChecked((boolean) reader.nextBoolean());
                }
            } else if (name.equals("isIndividualProduct")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isIndividualProduct' to null.");
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$isIndividualProduct((boolean) reader.nextBoolean());
                }
            } else if (name.equals("isProductInfoShown")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isProductInfoShown' to null.");
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$isProductInfoShown((boolean) reader.nextBoolean());
                }
            } else if (name.equals("featureCodes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$featureCodes(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$featureCodes((String) reader.nextString());
                }
            } else if (name.equals("productData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$productData(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$productData((String) reader.nextString());
                }
            } else if (name.equals("totalProductsCost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$totalProductsCost(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$totalProductsCost((String) reader.nextString());
                }
            } else if (name.equals("coreServiceCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$coreServiceCode(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$coreServiceCode((String) reader.nextString());
                }
            } else if (name.equals("srvcName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$srvcName(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$srvcName((String) reader.nextString());
                }
            } else if (name.equals("serviceCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductModelRealmProxyInterface) obj).realmSet$serviceCode(null);
                } else {
                    ((ProductModelRealmProxyInterface) obj).realmSet$serviceCode((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'productUniqueKey'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.ProductModel copyOrUpdate(Realm realm, com.app.apsfl.models.ProductModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.ProductModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.ProductModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.ProductModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((ProductModelRealmProxyInterface) object).realmGet$productUniqueKey();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.ProductModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ProductModelRealmProxy();
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

    public static com.app.apsfl.models.ProductModel copy(Realm realm, com.app.apsfl.models.ProductModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.ProductModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.ProductModel realmObject = realm.createObjectInternal(com.app.apsfl.models.ProductModel.class, ((ProductModelRealmProxyInterface) newObject).realmGet$productUniqueKey(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productCode(((ProductModelRealmProxyInterface) newObject).realmGet$productCode());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productName(((ProductModelRealmProxyInterface) newObject).realmGet$productName());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productDate(((ProductModelRealmProxyInterface) newObject).realmGet$productDate());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productTenantCode(((ProductModelRealmProxyInterface) newObject).realmGet$productTenantCode());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$voipServiceCode(((ProductModelRealmProxyInterface) newObject).realmGet$voipServiceCode());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productTenantName(((ProductModelRealmProxyInterface) newObject).realmGet$productTenantName());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productRecurringCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productRecurringCharge());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productActivationCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productActivationCharge());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productSecurityCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productSecurityCharge());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productRecurringTax(((ProductModelRealmProxyInterface) newObject).realmGet$productRecurringTax());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productActivationTax(((ProductModelRealmProxyInterface) newObject).realmGet$productActivationTax());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productSecurityTax(((ProductModelRealmProxyInterface) newObject).realmGet$productSecurityTax());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productTax(((ProductModelRealmProxyInterface) newObject).realmGet$productTax());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productTotalCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productTotalCharge());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productLockInPeriod(((ProductModelRealmProxyInterface) newObject).realmGet$productLockInPeriod());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productType(((ProductModelRealmProxyInterface) newObject).realmGet$productType());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$isProductCheckBoxVisible(((ProductModelRealmProxyInterface) newObject).realmGet$isProductCheckBoxVisible());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$isProductChecked(((ProductModelRealmProxyInterface) newObject).realmGet$isProductChecked());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$isIndividualProduct(((ProductModelRealmProxyInterface) newObject).realmGet$isIndividualProduct());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$isProductInfoShown(((ProductModelRealmProxyInterface) newObject).realmGet$isProductInfoShown());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$featureCodes(((ProductModelRealmProxyInterface) newObject).realmGet$featureCodes());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$productData(((ProductModelRealmProxyInterface) newObject).realmGet$productData());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$totalProductsCost(((ProductModelRealmProxyInterface) newObject).realmGet$totalProductsCost());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$coreServiceCode(((ProductModelRealmProxyInterface) newObject).realmGet$coreServiceCode());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$srvcName(((ProductModelRealmProxyInterface) newObject).realmGet$srvcName());
            ((ProductModelRealmProxyInterface) realmObject).realmSet$serviceCode(((ProductModelRealmProxyInterface) newObject).realmGet$serviceCode());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.ProductModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.ProductModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductModelColumnInfo columnInfo = (ProductModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ProductModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ProductModelRealmProxyInterface) object).realmGet$productUniqueKey();
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
        String realmGet$productCode = ((ProductModelRealmProxyInterface)object).realmGet$productCode();
        if (realmGet$productCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productCodeIndex, rowIndex, realmGet$productCode, false);
        }
        String realmGet$productName = ((ProductModelRealmProxyInterface)object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        }
        String realmGet$productDate = ((ProductModelRealmProxyInterface)object).realmGet$productDate();
        if (realmGet$productDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDateIndex, rowIndex, realmGet$productDate, false);
        }
        String realmGet$productTenantCode = ((ProductModelRealmProxyInterface)object).realmGet$productTenantCode();
        if (realmGet$productTenantCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTenantCodeIndex, rowIndex, realmGet$productTenantCode, false);
        }
        String realmGet$voipServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$voipServiceCode();
        if (realmGet$voipServiceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.voipServiceCodeIndex, rowIndex, realmGet$voipServiceCode, false);
        }
        String realmGet$productTenantName = ((ProductModelRealmProxyInterface)object).realmGet$productTenantName();
        if (realmGet$productTenantName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTenantNameIndex, rowIndex, realmGet$productTenantName, false);
        }
        String realmGet$productRecurringCharge = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringCharge();
        if (realmGet$productRecurringCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productRecurringChargeIndex, rowIndex, realmGet$productRecurringCharge, false);
        }
        String realmGet$productActivationCharge = ((ProductModelRealmProxyInterface)object).realmGet$productActivationCharge();
        if (realmGet$productActivationCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productActivationChargeIndex, rowIndex, realmGet$productActivationCharge, false);
        }
        String realmGet$productSecurityCharge = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityCharge();
        if (realmGet$productSecurityCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productSecurityChargeIndex, rowIndex, realmGet$productSecurityCharge, false);
        }
        String realmGet$productRecurringTax = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringTax();
        if (realmGet$productRecurringTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productRecurringTaxIndex, rowIndex, realmGet$productRecurringTax, false);
        }
        String realmGet$productActivationTax = ((ProductModelRealmProxyInterface)object).realmGet$productActivationTax();
        if (realmGet$productActivationTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productActivationTaxIndex, rowIndex, realmGet$productActivationTax, false);
        }
        String realmGet$productSecurityTax = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityTax();
        if (realmGet$productSecurityTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productSecurityTaxIndex, rowIndex, realmGet$productSecurityTax, false);
        }
        String realmGet$productTax = ((ProductModelRealmProxyInterface)object).realmGet$productTax();
        if (realmGet$productTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTaxIndex, rowIndex, realmGet$productTax, false);
        }
        String realmGet$productTotalCharge = ((ProductModelRealmProxyInterface)object).realmGet$productTotalCharge();
        if (realmGet$productTotalCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTotalChargeIndex, rowIndex, realmGet$productTotalCharge, false);
        }
        String realmGet$productLockInPeriod = ((ProductModelRealmProxyInterface)object).realmGet$productLockInPeriod();
        if (realmGet$productLockInPeriod != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productLockInPeriodIndex, rowIndex, realmGet$productLockInPeriod, false);
        }
        String realmGet$productType = ((ProductModelRealmProxyInterface)object).realmGet$productType();
        if (realmGet$productType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTypeIndex, rowIndex, realmGet$productType, false);
        }
        Boolean realmGet$isProductCheckBoxVisible = ((ProductModelRealmProxyInterface)object).realmGet$isProductCheckBoxVisible();
        if (realmGet$isProductCheckBoxVisible != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckBoxVisibleIndex, rowIndex, realmGet$isProductCheckBoxVisible, false);
        }
        Boolean realmGet$isProductChecked = ((ProductModelRealmProxyInterface)object).realmGet$isProductChecked();
        if (realmGet$isProductChecked != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckedIndex, rowIndex, realmGet$isProductChecked, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isIndividualProductIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isIndividualProduct(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductInfoShownIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isProductInfoShown(), false);
        String realmGet$featureCodes = ((ProductModelRealmProxyInterface)object).realmGet$featureCodes();
        if (realmGet$featureCodes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.featureCodesIndex, rowIndex, realmGet$featureCodes, false);
        }
        String realmGet$productData = ((ProductModelRealmProxyInterface)object).realmGet$productData();
        if (realmGet$productData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDataIndex, rowIndex, realmGet$productData, false);
        }
        String realmGet$totalProductsCost = ((ProductModelRealmProxyInterface)object).realmGet$totalProductsCost();
        if (realmGet$totalProductsCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalProductsCostIndex, rowIndex, realmGet$totalProductsCost, false);
        }
        String realmGet$coreServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$coreServiceCode();
        if (realmGet$coreServiceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
        }
        String realmGet$srvcName = ((ProductModelRealmProxyInterface)object).realmGet$srvcName();
        if (realmGet$srvcName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.srvcNameIndex, rowIndex, realmGet$srvcName, false);
        }
        String realmGet$serviceCode = ((ProductModelRealmProxyInterface)object).realmGet$serviceCode();
        if (realmGet$serviceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.ProductModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductModelColumnInfo columnInfo = (ProductModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ProductModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.ProductModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.ProductModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ProductModelRealmProxyInterface) object).realmGet$productUniqueKey();
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
                String realmGet$productCode = ((ProductModelRealmProxyInterface)object).realmGet$productCode();
                if (realmGet$productCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productCodeIndex, rowIndex, realmGet$productCode, false);
                }
                String realmGet$productName = ((ProductModelRealmProxyInterface)object).realmGet$productName();
                if (realmGet$productName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
                }
                String realmGet$productDate = ((ProductModelRealmProxyInterface)object).realmGet$productDate();
                if (realmGet$productDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productDateIndex, rowIndex, realmGet$productDate, false);
                }
                String realmGet$productTenantCode = ((ProductModelRealmProxyInterface)object).realmGet$productTenantCode();
                if (realmGet$productTenantCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTenantCodeIndex, rowIndex, realmGet$productTenantCode, false);
                }
                String realmGet$voipServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$voipServiceCode();
                if (realmGet$voipServiceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.voipServiceCodeIndex, rowIndex, realmGet$voipServiceCode, false);
                }
                String realmGet$productTenantName = ((ProductModelRealmProxyInterface)object).realmGet$productTenantName();
                if (realmGet$productTenantName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTenantNameIndex, rowIndex, realmGet$productTenantName, false);
                }
                String realmGet$productRecurringCharge = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringCharge();
                if (realmGet$productRecurringCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productRecurringChargeIndex, rowIndex, realmGet$productRecurringCharge, false);
                }
                String realmGet$productActivationCharge = ((ProductModelRealmProxyInterface)object).realmGet$productActivationCharge();
                if (realmGet$productActivationCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productActivationChargeIndex, rowIndex, realmGet$productActivationCharge, false);
                }
                String realmGet$productSecurityCharge = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityCharge();
                if (realmGet$productSecurityCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productSecurityChargeIndex, rowIndex, realmGet$productSecurityCharge, false);
                }
                String realmGet$productRecurringTax = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringTax();
                if (realmGet$productRecurringTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productRecurringTaxIndex, rowIndex, realmGet$productRecurringTax, false);
                }
                String realmGet$productActivationTax = ((ProductModelRealmProxyInterface)object).realmGet$productActivationTax();
                if (realmGet$productActivationTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productActivationTaxIndex, rowIndex, realmGet$productActivationTax, false);
                }
                String realmGet$productSecurityTax = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityTax();
                if (realmGet$productSecurityTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productSecurityTaxIndex, rowIndex, realmGet$productSecurityTax, false);
                }
                String realmGet$productTax = ((ProductModelRealmProxyInterface)object).realmGet$productTax();
                if (realmGet$productTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTaxIndex, rowIndex, realmGet$productTax, false);
                }
                String realmGet$productTotalCharge = ((ProductModelRealmProxyInterface)object).realmGet$productTotalCharge();
                if (realmGet$productTotalCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTotalChargeIndex, rowIndex, realmGet$productTotalCharge, false);
                }
                String realmGet$productLockInPeriod = ((ProductModelRealmProxyInterface)object).realmGet$productLockInPeriod();
                if (realmGet$productLockInPeriod != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productLockInPeriodIndex, rowIndex, realmGet$productLockInPeriod, false);
                }
                String realmGet$productType = ((ProductModelRealmProxyInterface)object).realmGet$productType();
                if (realmGet$productType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTypeIndex, rowIndex, realmGet$productType, false);
                }
                Boolean realmGet$isProductCheckBoxVisible = ((ProductModelRealmProxyInterface)object).realmGet$isProductCheckBoxVisible();
                if (realmGet$isProductCheckBoxVisible != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckBoxVisibleIndex, rowIndex, realmGet$isProductCheckBoxVisible, false);
                }
                Boolean realmGet$isProductChecked = ((ProductModelRealmProxyInterface)object).realmGet$isProductChecked();
                if (realmGet$isProductChecked != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckedIndex, rowIndex, realmGet$isProductChecked, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isIndividualProductIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isIndividualProduct(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductInfoShownIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isProductInfoShown(), false);
                String realmGet$featureCodes = ((ProductModelRealmProxyInterface)object).realmGet$featureCodes();
                if (realmGet$featureCodes != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.featureCodesIndex, rowIndex, realmGet$featureCodes, false);
                }
                String realmGet$productData = ((ProductModelRealmProxyInterface)object).realmGet$productData();
                if (realmGet$productData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productDataIndex, rowIndex, realmGet$productData, false);
                }
                String realmGet$totalProductsCost = ((ProductModelRealmProxyInterface)object).realmGet$totalProductsCost();
                if (realmGet$totalProductsCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalProductsCostIndex, rowIndex, realmGet$totalProductsCost, false);
                }
                String realmGet$coreServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$coreServiceCode();
                if (realmGet$coreServiceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
                }
                String realmGet$srvcName = ((ProductModelRealmProxyInterface)object).realmGet$srvcName();
                if (realmGet$srvcName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.srvcNameIndex, rowIndex, realmGet$srvcName, false);
                }
                String realmGet$serviceCode = ((ProductModelRealmProxyInterface)object).realmGet$serviceCode();
                if (realmGet$serviceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.ProductModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.ProductModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductModelColumnInfo columnInfo = (ProductModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ProductModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ProductModelRealmProxyInterface) object).realmGet$productUniqueKey();
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
        String realmGet$productCode = ((ProductModelRealmProxyInterface)object).realmGet$productCode();
        if (realmGet$productCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productCodeIndex, rowIndex, realmGet$productCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productCodeIndex, rowIndex, false);
        }
        String realmGet$productName = ((ProductModelRealmProxyInterface)object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
        }
        String realmGet$productDate = ((ProductModelRealmProxyInterface)object).realmGet$productDate();
        if (realmGet$productDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDateIndex, rowIndex, realmGet$productDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productDateIndex, rowIndex, false);
        }
        String realmGet$productTenantCode = ((ProductModelRealmProxyInterface)object).realmGet$productTenantCode();
        if (realmGet$productTenantCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTenantCodeIndex, rowIndex, realmGet$productTenantCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productTenantCodeIndex, rowIndex, false);
        }
        String realmGet$voipServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$voipServiceCode();
        if (realmGet$voipServiceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.voipServiceCodeIndex, rowIndex, realmGet$voipServiceCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voipServiceCodeIndex, rowIndex, false);
        }
        String realmGet$productTenantName = ((ProductModelRealmProxyInterface)object).realmGet$productTenantName();
        if (realmGet$productTenantName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTenantNameIndex, rowIndex, realmGet$productTenantName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productTenantNameIndex, rowIndex, false);
        }
        String realmGet$productRecurringCharge = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringCharge();
        if (realmGet$productRecurringCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productRecurringChargeIndex, rowIndex, realmGet$productRecurringCharge, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productRecurringChargeIndex, rowIndex, false);
        }
        String realmGet$productActivationCharge = ((ProductModelRealmProxyInterface)object).realmGet$productActivationCharge();
        if (realmGet$productActivationCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productActivationChargeIndex, rowIndex, realmGet$productActivationCharge, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productActivationChargeIndex, rowIndex, false);
        }
        String realmGet$productSecurityCharge = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityCharge();
        if (realmGet$productSecurityCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productSecurityChargeIndex, rowIndex, realmGet$productSecurityCharge, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productSecurityChargeIndex, rowIndex, false);
        }
        String realmGet$productRecurringTax = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringTax();
        if (realmGet$productRecurringTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productRecurringTaxIndex, rowIndex, realmGet$productRecurringTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productRecurringTaxIndex, rowIndex, false);
        }
        String realmGet$productActivationTax = ((ProductModelRealmProxyInterface)object).realmGet$productActivationTax();
        if (realmGet$productActivationTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productActivationTaxIndex, rowIndex, realmGet$productActivationTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productActivationTaxIndex, rowIndex, false);
        }
        String realmGet$productSecurityTax = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityTax();
        if (realmGet$productSecurityTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productSecurityTaxIndex, rowIndex, realmGet$productSecurityTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productSecurityTaxIndex, rowIndex, false);
        }
        String realmGet$productTax = ((ProductModelRealmProxyInterface)object).realmGet$productTax();
        if (realmGet$productTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTaxIndex, rowIndex, realmGet$productTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productTaxIndex, rowIndex, false);
        }
        String realmGet$productTotalCharge = ((ProductModelRealmProxyInterface)object).realmGet$productTotalCharge();
        if (realmGet$productTotalCharge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTotalChargeIndex, rowIndex, realmGet$productTotalCharge, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productTotalChargeIndex, rowIndex, false);
        }
        String realmGet$productLockInPeriod = ((ProductModelRealmProxyInterface)object).realmGet$productLockInPeriod();
        if (realmGet$productLockInPeriod != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productLockInPeriodIndex, rowIndex, realmGet$productLockInPeriod, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productLockInPeriodIndex, rowIndex, false);
        }
        String realmGet$productType = ((ProductModelRealmProxyInterface)object).realmGet$productType();
        if (realmGet$productType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productTypeIndex, rowIndex, realmGet$productType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productTypeIndex, rowIndex, false);
        }
        Boolean realmGet$isProductCheckBoxVisible = ((ProductModelRealmProxyInterface)object).realmGet$isProductCheckBoxVisible();
        if (realmGet$isProductCheckBoxVisible != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckBoxVisibleIndex, rowIndex, realmGet$isProductCheckBoxVisible, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isProductCheckBoxVisibleIndex, rowIndex, false);
        }
        Boolean realmGet$isProductChecked = ((ProductModelRealmProxyInterface)object).realmGet$isProductChecked();
        if (realmGet$isProductChecked != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckedIndex, rowIndex, realmGet$isProductChecked, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isProductCheckedIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isIndividualProductIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isIndividualProduct(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductInfoShownIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isProductInfoShown(), false);
        String realmGet$featureCodes = ((ProductModelRealmProxyInterface)object).realmGet$featureCodes();
        if (realmGet$featureCodes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.featureCodesIndex, rowIndex, realmGet$featureCodes, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.featureCodesIndex, rowIndex, false);
        }
        String realmGet$productData = ((ProductModelRealmProxyInterface)object).realmGet$productData();
        if (realmGet$productData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDataIndex, rowIndex, realmGet$productData, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productDataIndex, rowIndex, false);
        }
        String realmGet$totalProductsCost = ((ProductModelRealmProxyInterface)object).realmGet$totalProductsCost();
        if (realmGet$totalProductsCost != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalProductsCostIndex, rowIndex, realmGet$totalProductsCost, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalProductsCostIndex, rowIndex, false);
        }
        String realmGet$coreServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$coreServiceCode();
        if (realmGet$coreServiceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, false);
        }
        String realmGet$srvcName = ((ProductModelRealmProxyInterface)object).realmGet$srvcName();
        if (realmGet$srvcName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.srvcNameIndex, rowIndex, realmGet$srvcName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.srvcNameIndex, rowIndex, false);
        }
        String realmGet$serviceCode = ((ProductModelRealmProxyInterface)object).realmGet$serviceCode();
        if (realmGet$serviceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.ProductModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductModelColumnInfo columnInfo = (ProductModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ProductModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.ProductModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.ProductModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ProductModelRealmProxyInterface) object).realmGet$productUniqueKey();
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
                String realmGet$productCode = ((ProductModelRealmProxyInterface)object).realmGet$productCode();
                if (realmGet$productCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productCodeIndex, rowIndex, realmGet$productCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productCodeIndex, rowIndex, false);
                }
                String realmGet$productName = ((ProductModelRealmProxyInterface)object).realmGet$productName();
                if (realmGet$productName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
                }
                String realmGet$productDate = ((ProductModelRealmProxyInterface)object).realmGet$productDate();
                if (realmGet$productDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productDateIndex, rowIndex, realmGet$productDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productDateIndex, rowIndex, false);
                }
                String realmGet$productTenantCode = ((ProductModelRealmProxyInterface)object).realmGet$productTenantCode();
                if (realmGet$productTenantCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTenantCodeIndex, rowIndex, realmGet$productTenantCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productTenantCodeIndex, rowIndex, false);
                }
                String realmGet$voipServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$voipServiceCode();
                if (realmGet$voipServiceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.voipServiceCodeIndex, rowIndex, realmGet$voipServiceCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voipServiceCodeIndex, rowIndex, false);
                }
                String realmGet$productTenantName = ((ProductModelRealmProxyInterface)object).realmGet$productTenantName();
                if (realmGet$productTenantName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTenantNameIndex, rowIndex, realmGet$productTenantName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productTenantNameIndex, rowIndex, false);
                }
                String realmGet$productRecurringCharge = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringCharge();
                if (realmGet$productRecurringCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productRecurringChargeIndex, rowIndex, realmGet$productRecurringCharge, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productRecurringChargeIndex, rowIndex, false);
                }
                String realmGet$productActivationCharge = ((ProductModelRealmProxyInterface)object).realmGet$productActivationCharge();
                if (realmGet$productActivationCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productActivationChargeIndex, rowIndex, realmGet$productActivationCharge, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productActivationChargeIndex, rowIndex, false);
                }
                String realmGet$productSecurityCharge = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityCharge();
                if (realmGet$productSecurityCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productSecurityChargeIndex, rowIndex, realmGet$productSecurityCharge, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productSecurityChargeIndex, rowIndex, false);
                }
                String realmGet$productRecurringTax = ((ProductModelRealmProxyInterface)object).realmGet$productRecurringTax();
                if (realmGet$productRecurringTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productRecurringTaxIndex, rowIndex, realmGet$productRecurringTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productRecurringTaxIndex, rowIndex, false);
                }
                String realmGet$productActivationTax = ((ProductModelRealmProxyInterface)object).realmGet$productActivationTax();
                if (realmGet$productActivationTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productActivationTaxIndex, rowIndex, realmGet$productActivationTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productActivationTaxIndex, rowIndex, false);
                }
                String realmGet$productSecurityTax = ((ProductModelRealmProxyInterface)object).realmGet$productSecurityTax();
                if (realmGet$productSecurityTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productSecurityTaxIndex, rowIndex, realmGet$productSecurityTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productSecurityTaxIndex, rowIndex, false);
                }
                String realmGet$productTax = ((ProductModelRealmProxyInterface)object).realmGet$productTax();
                if (realmGet$productTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTaxIndex, rowIndex, realmGet$productTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productTaxIndex, rowIndex, false);
                }
                String realmGet$productTotalCharge = ((ProductModelRealmProxyInterface)object).realmGet$productTotalCharge();
                if (realmGet$productTotalCharge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTotalChargeIndex, rowIndex, realmGet$productTotalCharge, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productTotalChargeIndex, rowIndex, false);
                }
                String realmGet$productLockInPeriod = ((ProductModelRealmProxyInterface)object).realmGet$productLockInPeriod();
                if (realmGet$productLockInPeriod != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productLockInPeriodIndex, rowIndex, realmGet$productLockInPeriod, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productLockInPeriodIndex, rowIndex, false);
                }
                String realmGet$productType = ((ProductModelRealmProxyInterface)object).realmGet$productType();
                if (realmGet$productType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productTypeIndex, rowIndex, realmGet$productType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productTypeIndex, rowIndex, false);
                }
                Boolean realmGet$isProductCheckBoxVisible = ((ProductModelRealmProxyInterface)object).realmGet$isProductCheckBoxVisible();
                if (realmGet$isProductCheckBoxVisible != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckBoxVisibleIndex, rowIndex, realmGet$isProductCheckBoxVisible, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isProductCheckBoxVisibleIndex, rowIndex, false);
                }
                Boolean realmGet$isProductChecked = ((ProductModelRealmProxyInterface)object).realmGet$isProductChecked();
                if (realmGet$isProductChecked != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductCheckedIndex, rowIndex, realmGet$isProductChecked, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isProductCheckedIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isIndividualProductIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isIndividualProduct(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isProductInfoShownIndex, rowIndex, ((ProductModelRealmProxyInterface)object).realmGet$isProductInfoShown(), false);
                String realmGet$featureCodes = ((ProductModelRealmProxyInterface)object).realmGet$featureCodes();
                if (realmGet$featureCodes != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.featureCodesIndex, rowIndex, realmGet$featureCodes, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.featureCodesIndex, rowIndex, false);
                }
                String realmGet$productData = ((ProductModelRealmProxyInterface)object).realmGet$productData();
                if (realmGet$productData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productDataIndex, rowIndex, realmGet$productData, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productDataIndex, rowIndex, false);
                }
                String realmGet$totalProductsCost = ((ProductModelRealmProxyInterface)object).realmGet$totalProductsCost();
                if (realmGet$totalProductsCost != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalProductsCostIndex, rowIndex, realmGet$totalProductsCost, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalProductsCostIndex, rowIndex, false);
                }
                String realmGet$coreServiceCode = ((ProductModelRealmProxyInterface)object).realmGet$coreServiceCode();
                if (realmGet$coreServiceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, false);
                }
                String realmGet$srvcName = ((ProductModelRealmProxyInterface)object).realmGet$srvcName();
                if (realmGet$srvcName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.srvcNameIndex, rowIndex, realmGet$srvcName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.srvcNameIndex, rowIndex, false);
                }
                String realmGet$serviceCode = ((ProductModelRealmProxyInterface)object).realmGet$serviceCode();
                if (realmGet$serviceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.ProductModel createDetachedCopy(com.app.apsfl.models.ProductModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.ProductModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.ProductModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.ProductModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.ProductModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productUniqueKey(((ProductModelRealmProxyInterface) realmObject).realmGet$productUniqueKey());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productCode(((ProductModelRealmProxyInterface) realmObject).realmGet$productCode());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productName(((ProductModelRealmProxyInterface) realmObject).realmGet$productName());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productDate(((ProductModelRealmProxyInterface) realmObject).realmGet$productDate());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productTenantCode(((ProductModelRealmProxyInterface) realmObject).realmGet$productTenantCode());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$voipServiceCode(((ProductModelRealmProxyInterface) realmObject).realmGet$voipServiceCode());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productTenantName(((ProductModelRealmProxyInterface) realmObject).realmGet$productTenantName());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productRecurringCharge(((ProductModelRealmProxyInterface) realmObject).realmGet$productRecurringCharge());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productActivationCharge(((ProductModelRealmProxyInterface) realmObject).realmGet$productActivationCharge());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productSecurityCharge(((ProductModelRealmProxyInterface) realmObject).realmGet$productSecurityCharge());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productRecurringTax(((ProductModelRealmProxyInterface) realmObject).realmGet$productRecurringTax());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productActivationTax(((ProductModelRealmProxyInterface) realmObject).realmGet$productActivationTax());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productSecurityTax(((ProductModelRealmProxyInterface) realmObject).realmGet$productSecurityTax());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productTax(((ProductModelRealmProxyInterface) realmObject).realmGet$productTax());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productTotalCharge(((ProductModelRealmProxyInterface) realmObject).realmGet$productTotalCharge());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productLockInPeriod(((ProductModelRealmProxyInterface) realmObject).realmGet$productLockInPeriod());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productType(((ProductModelRealmProxyInterface) realmObject).realmGet$productType());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$isProductCheckBoxVisible(((ProductModelRealmProxyInterface) realmObject).realmGet$isProductCheckBoxVisible());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$isProductChecked(((ProductModelRealmProxyInterface) realmObject).realmGet$isProductChecked());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$isIndividualProduct(((ProductModelRealmProxyInterface) realmObject).realmGet$isIndividualProduct());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$isProductInfoShown(((ProductModelRealmProxyInterface) realmObject).realmGet$isProductInfoShown());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$featureCodes(((ProductModelRealmProxyInterface) realmObject).realmGet$featureCodes());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$productData(((ProductModelRealmProxyInterface) realmObject).realmGet$productData());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$totalProductsCost(((ProductModelRealmProxyInterface) realmObject).realmGet$totalProductsCost());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$coreServiceCode(((ProductModelRealmProxyInterface) realmObject).realmGet$coreServiceCode());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$srvcName(((ProductModelRealmProxyInterface) realmObject).realmGet$srvcName());
        ((ProductModelRealmProxyInterface) unmanagedObject).realmSet$serviceCode(((ProductModelRealmProxyInterface) realmObject).realmGet$serviceCode());
        return unmanagedObject;
    }

    static com.app.apsfl.models.ProductModel update(Realm realm, com.app.apsfl.models.ProductModel realmObject, com.app.apsfl.models.ProductModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productCode(((ProductModelRealmProxyInterface) newObject).realmGet$productCode());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productName(((ProductModelRealmProxyInterface) newObject).realmGet$productName());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productDate(((ProductModelRealmProxyInterface) newObject).realmGet$productDate());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productTenantCode(((ProductModelRealmProxyInterface) newObject).realmGet$productTenantCode());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$voipServiceCode(((ProductModelRealmProxyInterface) newObject).realmGet$voipServiceCode());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productTenantName(((ProductModelRealmProxyInterface) newObject).realmGet$productTenantName());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productRecurringCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productRecurringCharge());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productActivationCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productActivationCharge());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productSecurityCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productSecurityCharge());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productRecurringTax(((ProductModelRealmProxyInterface) newObject).realmGet$productRecurringTax());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productActivationTax(((ProductModelRealmProxyInterface) newObject).realmGet$productActivationTax());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productSecurityTax(((ProductModelRealmProxyInterface) newObject).realmGet$productSecurityTax());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productTax(((ProductModelRealmProxyInterface) newObject).realmGet$productTax());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productTotalCharge(((ProductModelRealmProxyInterface) newObject).realmGet$productTotalCharge());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productLockInPeriod(((ProductModelRealmProxyInterface) newObject).realmGet$productLockInPeriod());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productType(((ProductModelRealmProxyInterface) newObject).realmGet$productType());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$isProductCheckBoxVisible(((ProductModelRealmProxyInterface) newObject).realmGet$isProductCheckBoxVisible());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$isProductChecked(((ProductModelRealmProxyInterface) newObject).realmGet$isProductChecked());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$isIndividualProduct(((ProductModelRealmProxyInterface) newObject).realmGet$isIndividualProduct());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$isProductInfoShown(((ProductModelRealmProxyInterface) newObject).realmGet$isProductInfoShown());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$featureCodes(((ProductModelRealmProxyInterface) newObject).realmGet$featureCodes());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$productData(((ProductModelRealmProxyInterface) newObject).realmGet$productData());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$totalProductsCost(((ProductModelRealmProxyInterface) newObject).realmGet$totalProductsCost());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$coreServiceCode(((ProductModelRealmProxyInterface) newObject).realmGet$coreServiceCode());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$srvcName(((ProductModelRealmProxyInterface) newObject).realmGet$srvcName());
        ((ProductModelRealmProxyInterface) realmObject).realmSet$serviceCode(((ProductModelRealmProxyInterface) newObject).realmGet$serviceCode());
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
        ProductModelRealmProxy aProductModel = (ProductModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProductModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProductModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProductModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
