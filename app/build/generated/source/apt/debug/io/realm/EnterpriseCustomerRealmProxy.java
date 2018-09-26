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

public class EnterpriseCustomerRealmProxy extends com.app.apsfl.models.EnterpriseCustomer
    implements RealmObjectProxy, EnterpriseCustomerRealmProxyInterface {

    static final class EnterpriseCustomerColumnInfo extends ColumnInfo
        implements Cloneable {

        public long customerIDIndex;
        public long customerNameIndex;
        public long customerMobileNumberIndex;
        public long isCustomerCheckedIndex;
        public long enterPriseCustomerTypeIndex;
        public long paymentCustomerIdIndex;
        public long registerNoIndex;
        public long organizationNameIndex;
        public long contactpersionNameIndex;
        public long dateOfIncorporationIndex;
        public long billFrequencyIndex;
        public long address1Index;
        public long address2Index;
        public long localityIndex;
        public long emailIndex;

        EnterpriseCustomerColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(15);
            this.customerIDIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "customerID");
            indicesMap.put("customerID", this.customerIDIndex);
            this.customerNameIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "customerName");
            indicesMap.put("customerName", this.customerNameIndex);
            this.customerMobileNumberIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "customerMobileNumber");
            indicesMap.put("customerMobileNumber", this.customerMobileNumberIndex);
            this.isCustomerCheckedIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "isCustomerChecked");
            indicesMap.put("isCustomerChecked", this.isCustomerCheckedIndex);
            this.enterPriseCustomerTypeIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "enterPriseCustomerType");
            indicesMap.put("enterPriseCustomerType", this.enterPriseCustomerTypeIndex);
            this.paymentCustomerIdIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "paymentCustomerId");
            indicesMap.put("paymentCustomerId", this.paymentCustomerIdIndex);
            this.registerNoIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "registerNo");
            indicesMap.put("registerNo", this.registerNoIndex);
            this.organizationNameIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "organizationName");
            indicesMap.put("organizationName", this.organizationNameIndex);
            this.contactpersionNameIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "contactpersionName");
            indicesMap.put("contactpersionName", this.contactpersionNameIndex);
            this.dateOfIncorporationIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "dateOfIncorporation");
            indicesMap.put("dateOfIncorporation", this.dateOfIncorporationIndex);
            this.billFrequencyIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "billFrequency");
            indicesMap.put("billFrequency", this.billFrequencyIndex);
            this.address1Index = getValidColumnIndex(path, table, "EnterpriseCustomer", "address1");
            indicesMap.put("address1", this.address1Index);
            this.address2Index = getValidColumnIndex(path, table, "EnterpriseCustomer", "address2");
            indicesMap.put("address2", this.address2Index);
            this.localityIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "locality");
            indicesMap.put("locality", this.localityIndex);
            this.emailIndex = getValidColumnIndex(path, table, "EnterpriseCustomer", "email");
            indicesMap.put("email", this.emailIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final EnterpriseCustomerColumnInfo otherInfo = (EnterpriseCustomerColumnInfo) other;
            this.customerIDIndex = otherInfo.customerIDIndex;
            this.customerNameIndex = otherInfo.customerNameIndex;
            this.customerMobileNumberIndex = otherInfo.customerMobileNumberIndex;
            this.isCustomerCheckedIndex = otherInfo.isCustomerCheckedIndex;
            this.enterPriseCustomerTypeIndex = otherInfo.enterPriseCustomerTypeIndex;
            this.paymentCustomerIdIndex = otherInfo.paymentCustomerIdIndex;
            this.registerNoIndex = otherInfo.registerNoIndex;
            this.organizationNameIndex = otherInfo.organizationNameIndex;
            this.contactpersionNameIndex = otherInfo.contactpersionNameIndex;
            this.dateOfIncorporationIndex = otherInfo.dateOfIncorporationIndex;
            this.billFrequencyIndex = otherInfo.billFrequencyIndex;
            this.address1Index = otherInfo.address1Index;
            this.address2Index = otherInfo.address2Index;
            this.localityIndex = otherInfo.localityIndex;
            this.emailIndex = otherInfo.emailIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final EnterpriseCustomerColumnInfo clone() {
            return (EnterpriseCustomerColumnInfo) super.clone();
        }

    }
    private EnterpriseCustomerColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("customerID");
        fieldNames.add("customerName");
        fieldNames.add("customerMobileNumber");
        fieldNames.add("isCustomerChecked");
        fieldNames.add("enterPriseCustomerType");
        fieldNames.add("paymentCustomerId");
        fieldNames.add("registerNo");
        fieldNames.add("organizationName");
        fieldNames.add("contactpersionName");
        fieldNames.add("dateOfIncorporation");
        fieldNames.add("billFrequency");
        fieldNames.add("address1");
        fieldNames.add("address2");
        fieldNames.add("locality");
        fieldNames.add("email");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    EnterpriseCustomerRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (EnterpriseCustomerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.EnterpriseCustomer.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$customerID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerIDIndex);
    }

    public void realmSet$customerID(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'customerID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$customerName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerNameIndex);
    }

    public void realmSet$customerName(String value) {
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
                row.getTable().setNull(columnInfo.customerNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerMobileNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerMobileNumberIndex);
    }

    public void realmSet$customerMobileNumber(String value) {
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
                row.getTable().setNull(columnInfo.customerMobileNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerMobileNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerMobileNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerMobileNumberIndex, value);
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
    public String realmGet$enterPriseCustomerType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.enterPriseCustomerTypeIndex);
    }

    public void realmSet$enterPriseCustomerType(String value) {
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
                row.getTable().setNull(columnInfo.enterPriseCustomerTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.enterPriseCustomerTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.enterPriseCustomerTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.enterPriseCustomerTypeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$paymentCustomerId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paymentCustomerIdIndex);
    }

    public void realmSet$paymentCustomerId(String value) {
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
                row.getTable().setNull(columnInfo.paymentCustomerIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paymentCustomerIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paymentCustomerIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paymentCustomerIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$registerNo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.registerNoIndex);
    }

    public void realmSet$registerNo(String value) {
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
                row.getTable().setNull(columnInfo.registerNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.registerNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.registerNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.registerNoIndex, value);
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
    public String realmGet$contactpersionName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contactpersionNameIndex);
    }

    public void realmSet$contactpersionName(String value) {
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
                row.getTable().setNull(columnInfo.contactpersionNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contactpersionNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contactpersionNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contactpersionNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$dateOfIncorporation() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateOfIncorporationIndex);
    }

    public void realmSet$dateOfIncorporation(String value) {
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
                row.getTable().setNull(columnInfo.dateOfIncorporationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateOfIncorporationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateOfIncorporationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateOfIncorporationIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$billFrequency() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.billFrequencyIndex);
    }

    public void realmSet$billFrequency(String value) {
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
                row.getTable().setNull(columnInfo.billFrequencyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.billFrequencyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.billFrequencyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.billFrequencyIndex, value);
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
    public String realmGet$email() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    public void realmSet$email(String value) {
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
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("EnterpriseCustomer")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("EnterpriseCustomer");
            realmObjectSchema.add(new Property("customerID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerMobileNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isCustomerChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("enterPriseCustomerType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("paymentCustomerId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("registerNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("organizationName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("contactpersionName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("dateOfIncorporation", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("billFrequency", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("address1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("address2", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("locality", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("EnterpriseCustomer");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_EnterpriseCustomer")) {
            Table table = sharedRealm.getTable("class_EnterpriseCustomer");
            table.addColumn(RealmFieldType.STRING, "customerID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerMobileNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isCustomerChecked", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "enterPriseCustomerType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "paymentCustomerId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "registerNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "organizationName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "contactpersionName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "dateOfIncorporation", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "billFrequency", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "address1", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "address2", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "locality", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "email", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("customerID"));
            table.setPrimaryKey("customerID");
            return table;
        }
        return sharedRealm.getTable("class_EnterpriseCustomer");
    }

    public static EnterpriseCustomerColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_EnterpriseCustomer")) {
            Table table = sharedRealm.getTable("class_EnterpriseCustomer");
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

            final EnterpriseCustomerColumnInfo columnInfo = new EnterpriseCustomerColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("customerID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'customerID' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("customerID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'customerID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("customerID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'customerID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("customerName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerName' is required. Either set @Required to field 'customerName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerMobileNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerMobileNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerMobileNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerMobileNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerMobileNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerMobileNumber' is required. Either set @Required to field 'customerMobileNumber' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("enterPriseCustomerType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'enterPriseCustomerType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("enterPriseCustomerType") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'enterPriseCustomerType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.enterPriseCustomerTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'enterPriseCustomerType' is required. Either set @Required to field 'enterPriseCustomerType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("paymentCustomerId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'paymentCustomerId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("paymentCustomerId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'paymentCustomerId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.paymentCustomerIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'paymentCustomerId' is required. Either set @Required to field 'paymentCustomerId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("registerNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'registerNo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("registerNo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'registerNo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.registerNoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'registerNo' is required. Either set @Required to field 'registerNo' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("contactpersionName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contactpersionName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("contactpersionName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contactpersionName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.contactpersionNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contactpersionName' is required. Either set @Required to field 'contactpersionName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("dateOfIncorporation")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateOfIncorporation' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("dateOfIncorporation") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateOfIncorporation' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.dateOfIncorporationIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateOfIncorporation' is required. Either set @Required to field 'dateOfIncorporation' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("billFrequency")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'billFrequency' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("billFrequency") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'billFrequency' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.billFrequencyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'billFrequency' is required. Either set @Required to field 'billFrequency' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("email")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("email") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.emailIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'email' is required. Either set @Required to field 'email' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'EnterpriseCustomer' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_EnterpriseCustomer";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.EnterpriseCustomer createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.EnterpriseCustomer obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.EnterpriseCustomer.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("customerID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("customerID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.EnterpriseCustomer.class), false, Collections.<String> emptyList());
                    obj = new io.realm.EnterpriseCustomerRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("customerID")) {
                if (json.isNull("customerID")) {
                    obj = (io.realm.EnterpriseCustomerRealmProxy) realm.createObjectInternal(com.app.apsfl.models.EnterpriseCustomer.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.EnterpriseCustomerRealmProxy) realm.createObjectInternal(com.app.apsfl.models.EnterpriseCustomer.class, json.getString("customerID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'customerID'.");
            }
        }
        if (json.has("customerName")) {
            if (json.isNull("customerName")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerName(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerName((String) json.getString("customerName"));
            }
        }
        if (json.has("customerMobileNumber")) {
            if (json.isNull("customerMobileNumber")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerMobileNumber(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerMobileNumber((String) json.getString("customerMobileNumber"));
            }
        }
        if (json.has("isCustomerChecked")) {
            if (json.isNull("isCustomerChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isCustomerChecked' to null.");
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$isCustomerChecked((boolean) json.getBoolean("isCustomerChecked"));
            }
        }
        if (json.has("enterPriseCustomerType")) {
            if (json.isNull("enterPriseCustomerType")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$enterPriseCustomerType(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$enterPriseCustomerType((String) json.getString("enterPriseCustomerType"));
            }
        }
        if (json.has("paymentCustomerId")) {
            if (json.isNull("paymentCustomerId")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$paymentCustomerId(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$paymentCustomerId((String) json.getString("paymentCustomerId"));
            }
        }
        if (json.has("registerNo")) {
            if (json.isNull("registerNo")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$registerNo(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$registerNo((String) json.getString("registerNo"));
            }
        }
        if (json.has("organizationName")) {
            if (json.isNull("organizationName")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$organizationName(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$organizationName((String) json.getString("organizationName"));
            }
        }
        if (json.has("contactpersionName")) {
            if (json.isNull("contactpersionName")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$contactpersionName(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$contactpersionName((String) json.getString("contactpersionName"));
            }
        }
        if (json.has("dateOfIncorporation")) {
            if (json.isNull("dateOfIncorporation")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$dateOfIncorporation(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$dateOfIncorporation((String) json.getString("dateOfIncorporation"));
            }
        }
        if (json.has("billFrequency")) {
            if (json.isNull("billFrequency")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$billFrequency(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$billFrequency((String) json.getString("billFrequency"));
            }
        }
        if (json.has("address1")) {
            if (json.isNull("address1")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address1(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address1((String) json.getString("address1"));
            }
        }
        if (json.has("address2")) {
            if (json.isNull("address2")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address2(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address2((String) json.getString("address2"));
            }
        }
        if (json.has("locality")) {
            if (json.isNull("locality")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$locality(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$locality((String) json.getString("locality"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$email(null);
            } else {
                ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$email((String) json.getString("email"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.EnterpriseCustomer createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.EnterpriseCustomer obj = new com.app.apsfl.models.EnterpriseCustomer();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("customerID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerID(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerID((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("customerName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerName(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerName((String) reader.nextString());
                }
            } else if (name.equals("customerMobileNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerMobileNumber(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$customerMobileNumber((String) reader.nextString());
                }
            } else if (name.equals("isCustomerChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isCustomerChecked' to null.");
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$isCustomerChecked((boolean) reader.nextBoolean());
                }
            } else if (name.equals("enterPriseCustomerType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$enterPriseCustomerType(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$enterPriseCustomerType((String) reader.nextString());
                }
            } else if (name.equals("paymentCustomerId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$paymentCustomerId(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$paymentCustomerId((String) reader.nextString());
                }
            } else if (name.equals("registerNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$registerNo(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$registerNo((String) reader.nextString());
                }
            } else if (name.equals("organizationName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$organizationName(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$organizationName((String) reader.nextString());
                }
            } else if (name.equals("contactpersionName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$contactpersionName(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$contactpersionName((String) reader.nextString());
                }
            } else if (name.equals("dateOfIncorporation")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$dateOfIncorporation(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$dateOfIncorporation((String) reader.nextString());
                }
            } else if (name.equals("billFrequency")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$billFrequency(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$billFrequency((String) reader.nextString());
                }
            } else if (name.equals("address1")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address1(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address1((String) reader.nextString());
                }
            } else if (name.equals("address2")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address2(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$address2((String) reader.nextString());
                }
            } else if (name.equals("locality")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$locality(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$locality((String) reader.nextString());
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$email(null);
                } else {
                    ((EnterpriseCustomerRealmProxyInterface) obj).realmSet$email((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'customerID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.EnterpriseCustomer copyOrUpdate(Realm realm, com.app.apsfl.models.EnterpriseCustomer object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.EnterpriseCustomer) cachedRealmObject;
        } else {
            com.app.apsfl.models.EnterpriseCustomer realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.EnterpriseCustomer.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((EnterpriseCustomerRealmProxyInterface) object).realmGet$customerID();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.EnterpriseCustomer.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.EnterpriseCustomerRealmProxy();
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

    public static com.app.apsfl.models.EnterpriseCustomer copy(Realm realm, com.app.apsfl.models.EnterpriseCustomer newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.EnterpriseCustomer) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.EnterpriseCustomer realmObject = realm.createObjectInternal(com.app.apsfl.models.EnterpriseCustomer.class, ((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$customerID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$customerName(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$customerName());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$customerMobileNumber(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$customerMobileNumber());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$isCustomerChecked(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$isCustomerChecked());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$enterPriseCustomerType(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$enterPriseCustomerType());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$paymentCustomerId(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$paymentCustomerId());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$registerNo(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$registerNo());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$organizationName(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$organizationName());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$contactpersionName(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$contactpersionName());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$dateOfIncorporation(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$dateOfIncorporation());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$billFrequency(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$billFrequency());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$address1(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$address1());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$address2(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$address2());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$locality(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$locality());
            ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$email(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$email());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.EnterpriseCustomer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.EnterpriseCustomer.class);
        long tableNativePtr = table.getNativeTablePointer();
        EnterpriseCustomerColumnInfo columnInfo = (EnterpriseCustomerColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.EnterpriseCustomer.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((EnterpriseCustomerRealmProxyInterface) object).realmGet$customerID();
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
        String realmGet$customerName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerName();
        if (realmGet$customerName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
        }
        String realmGet$customerMobileNumber = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerMobileNumber();
        if (realmGet$customerMobileNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerMobileNumberIndex, rowIndex, realmGet$customerMobileNumber, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((EnterpriseCustomerRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
        String realmGet$enterPriseCustomerType = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$enterPriseCustomerType();
        if (realmGet$enterPriseCustomerType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.enterPriseCustomerTypeIndex, rowIndex, realmGet$enterPriseCustomerType, false);
        }
        String realmGet$paymentCustomerId = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$paymentCustomerId();
        if (realmGet$paymentCustomerId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paymentCustomerIdIndex, rowIndex, realmGet$paymentCustomerId, false);
        }
        String realmGet$registerNo = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$registerNo();
        if (realmGet$registerNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.registerNoIndex, rowIndex, realmGet$registerNo, false);
        }
        String realmGet$organizationName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$organizationName();
        if (realmGet$organizationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
        }
        String realmGet$contactpersionName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$contactpersionName();
        if (realmGet$contactpersionName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactpersionNameIndex, rowIndex, realmGet$contactpersionName, false);
        }
        String realmGet$dateOfIncorporation = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$dateOfIncorporation();
        if (realmGet$dateOfIncorporation != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateOfIncorporationIndex, rowIndex, realmGet$dateOfIncorporation, false);
        }
        String realmGet$billFrequency = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$billFrequency();
        if (realmGet$billFrequency != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billFrequencyIndex, rowIndex, realmGet$billFrequency, false);
        }
        String realmGet$address1 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address1();
        if (realmGet$address1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
        }
        String realmGet$address2 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address2();
        if (realmGet$address2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
        }
        String realmGet$locality = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$locality();
        if (realmGet$locality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
        }
        String realmGet$email = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.EnterpriseCustomer.class);
        long tableNativePtr = table.getNativeTablePointer();
        EnterpriseCustomerColumnInfo columnInfo = (EnterpriseCustomerColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.EnterpriseCustomer.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.EnterpriseCustomer object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.EnterpriseCustomer) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((EnterpriseCustomerRealmProxyInterface) object).realmGet$customerID();
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
                String realmGet$customerName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerName();
                if (realmGet$customerName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
                }
                String realmGet$customerMobileNumber = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerMobileNumber();
                if (realmGet$customerMobileNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerMobileNumberIndex, rowIndex, realmGet$customerMobileNumber, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((EnterpriseCustomerRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
                String realmGet$enterPriseCustomerType = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$enterPriseCustomerType();
                if (realmGet$enterPriseCustomerType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.enterPriseCustomerTypeIndex, rowIndex, realmGet$enterPriseCustomerType, false);
                }
                String realmGet$paymentCustomerId = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$paymentCustomerId();
                if (realmGet$paymentCustomerId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paymentCustomerIdIndex, rowIndex, realmGet$paymentCustomerId, false);
                }
                String realmGet$registerNo = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$registerNo();
                if (realmGet$registerNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.registerNoIndex, rowIndex, realmGet$registerNo, false);
                }
                String realmGet$organizationName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$organizationName();
                if (realmGet$organizationName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
                }
                String realmGet$contactpersionName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$contactpersionName();
                if (realmGet$contactpersionName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactpersionNameIndex, rowIndex, realmGet$contactpersionName, false);
                }
                String realmGet$dateOfIncorporation = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$dateOfIncorporation();
                if (realmGet$dateOfIncorporation != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateOfIncorporationIndex, rowIndex, realmGet$dateOfIncorporation, false);
                }
                String realmGet$billFrequency = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$billFrequency();
                if (realmGet$billFrequency != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billFrequencyIndex, rowIndex, realmGet$billFrequency, false);
                }
                String realmGet$address1 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address1();
                if (realmGet$address1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
                }
                String realmGet$address2 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address2();
                if (realmGet$address2 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
                }
                String realmGet$locality = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$locality();
                if (realmGet$locality != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
                }
                String realmGet$email = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.EnterpriseCustomer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.EnterpriseCustomer.class);
        long tableNativePtr = table.getNativeTablePointer();
        EnterpriseCustomerColumnInfo columnInfo = (EnterpriseCustomerColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.EnterpriseCustomer.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((EnterpriseCustomerRealmProxyInterface) object).realmGet$customerID();
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
        String realmGet$customerName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerName();
        if (realmGet$customerName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerNameIndex, rowIndex, false);
        }
        String realmGet$customerMobileNumber = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerMobileNumber();
        if (realmGet$customerMobileNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerMobileNumberIndex, rowIndex, realmGet$customerMobileNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerMobileNumberIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((EnterpriseCustomerRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
        String realmGet$enterPriseCustomerType = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$enterPriseCustomerType();
        if (realmGet$enterPriseCustomerType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.enterPriseCustomerTypeIndex, rowIndex, realmGet$enterPriseCustomerType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.enterPriseCustomerTypeIndex, rowIndex, false);
        }
        String realmGet$paymentCustomerId = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$paymentCustomerId();
        if (realmGet$paymentCustomerId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paymentCustomerIdIndex, rowIndex, realmGet$paymentCustomerId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paymentCustomerIdIndex, rowIndex, false);
        }
        String realmGet$registerNo = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$registerNo();
        if (realmGet$registerNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.registerNoIndex, rowIndex, realmGet$registerNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.registerNoIndex, rowIndex, false);
        }
        String realmGet$organizationName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$organizationName();
        if (realmGet$organizationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, false);
        }
        String realmGet$contactpersionName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$contactpersionName();
        if (realmGet$contactpersionName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactpersionNameIndex, rowIndex, realmGet$contactpersionName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contactpersionNameIndex, rowIndex, false);
        }
        String realmGet$dateOfIncorporation = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$dateOfIncorporation();
        if (realmGet$dateOfIncorporation != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateOfIncorporationIndex, rowIndex, realmGet$dateOfIncorporation, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateOfIncorporationIndex, rowIndex, false);
        }
        String realmGet$billFrequency = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$billFrequency();
        if (realmGet$billFrequency != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billFrequencyIndex, rowIndex, realmGet$billFrequency, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.billFrequencyIndex, rowIndex, false);
        }
        String realmGet$address1 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address1();
        if (realmGet$address1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.address1Index, rowIndex, false);
        }
        String realmGet$address2 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address2();
        if (realmGet$address2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.address2Index, rowIndex, false);
        }
        String realmGet$locality = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$locality();
        if (realmGet$locality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.localityIndex, rowIndex, false);
        }
        String realmGet$email = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.EnterpriseCustomer.class);
        long tableNativePtr = table.getNativeTablePointer();
        EnterpriseCustomerColumnInfo columnInfo = (EnterpriseCustomerColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.EnterpriseCustomer.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.EnterpriseCustomer object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.EnterpriseCustomer) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((EnterpriseCustomerRealmProxyInterface) object).realmGet$customerID();
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
                String realmGet$customerName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerName();
                if (realmGet$customerName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerNameIndex, rowIndex, false);
                }
                String realmGet$customerMobileNumber = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$customerMobileNumber();
                if (realmGet$customerMobileNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerMobileNumberIndex, rowIndex, realmGet$customerMobileNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerMobileNumberIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isCustomerCheckedIndex, rowIndex, ((EnterpriseCustomerRealmProxyInterface)object).realmGet$isCustomerChecked(), false);
                String realmGet$enterPriseCustomerType = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$enterPriseCustomerType();
                if (realmGet$enterPriseCustomerType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.enterPriseCustomerTypeIndex, rowIndex, realmGet$enterPriseCustomerType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.enterPriseCustomerTypeIndex, rowIndex, false);
                }
                String realmGet$paymentCustomerId = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$paymentCustomerId();
                if (realmGet$paymentCustomerId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paymentCustomerIdIndex, rowIndex, realmGet$paymentCustomerId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.paymentCustomerIdIndex, rowIndex, false);
                }
                String realmGet$registerNo = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$registerNo();
                if (realmGet$registerNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.registerNoIndex, rowIndex, realmGet$registerNo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.registerNoIndex, rowIndex, false);
                }
                String realmGet$organizationName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$organizationName();
                if (realmGet$organizationName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, realmGet$organizationName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.organizationNameIndex, rowIndex, false);
                }
                String realmGet$contactpersionName = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$contactpersionName();
                if (realmGet$contactpersionName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactpersionNameIndex, rowIndex, realmGet$contactpersionName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contactpersionNameIndex, rowIndex, false);
                }
                String realmGet$dateOfIncorporation = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$dateOfIncorporation();
                if (realmGet$dateOfIncorporation != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateOfIncorporationIndex, rowIndex, realmGet$dateOfIncorporation, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateOfIncorporationIndex, rowIndex, false);
                }
                String realmGet$billFrequency = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$billFrequency();
                if (realmGet$billFrequency != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billFrequencyIndex, rowIndex, realmGet$billFrequency, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.billFrequencyIndex, rowIndex, false);
                }
                String realmGet$address1 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address1();
                if (realmGet$address1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address1Index, rowIndex, realmGet$address1, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.address1Index, rowIndex, false);
                }
                String realmGet$address2 = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$address2();
                if (realmGet$address2 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.address2Index, rowIndex, realmGet$address2, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.address2Index, rowIndex, false);
                }
                String realmGet$locality = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$locality();
                if (realmGet$locality != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.localityIndex, rowIndex, realmGet$locality, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.localityIndex, rowIndex, false);
                }
                String realmGet$email = ((EnterpriseCustomerRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.EnterpriseCustomer createDetachedCopy(com.app.apsfl.models.EnterpriseCustomer realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.EnterpriseCustomer unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.EnterpriseCustomer)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.EnterpriseCustomer)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.EnterpriseCustomer();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$customerID(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$customerID());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$customerName(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$customerName());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$customerMobileNumber(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$customerMobileNumber());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$isCustomerChecked(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$isCustomerChecked());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$enterPriseCustomerType(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$enterPriseCustomerType());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$paymentCustomerId(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$paymentCustomerId());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$registerNo(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$registerNo());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$organizationName(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$organizationName());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$contactpersionName(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$contactpersionName());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$dateOfIncorporation(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$dateOfIncorporation());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$billFrequency(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$billFrequency());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$address1(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$address1());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$address2(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$address2());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$locality(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$locality());
        ((EnterpriseCustomerRealmProxyInterface) unmanagedObject).realmSet$email(((EnterpriseCustomerRealmProxyInterface) realmObject).realmGet$email());
        return unmanagedObject;
    }

    static com.app.apsfl.models.EnterpriseCustomer update(Realm realm, com.app.apsfl.models.EnterpriseCustomer realmObject, com.app.apsfl.models.EnterpriseCustomer newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$customerName(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$customerName());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$customerMobileNumber(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$customerMobileNumber());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$isCustomerChecked(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$isCustomerChecked());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$enterPriseCustomerType(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$enterPriseCustomerType());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$paymentCustomerId(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$paymentCustomerId());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$registerNo(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$registerNo());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$organizationName(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$organizationName());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$contactpersionName(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$contactpersionName());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$dateOfIncorporation(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$dateOfIncorporation());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$billFrequency(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$billFrequency());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$address1(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$address1());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$address2(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$address2());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$locality(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$locality());
        ((EnterpriseCustomerRealmProxyInterface) realmObject).realmSet$email(((EnterpriseCustomerRealmProxyInterface) newObject).realmGet$email());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("EnterpriseCustomer = [");
        stringBuilder.append("{customerID:");
        stringBuilder.append(realmGet$customerID() != null ? realmGet$customerID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{customerName:");
        stringBuilder.append(realmGet$customerName() != null ? realmGet$customerName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{customerMobileNumber:");
        stringBuilder.append(realmGet$customerMobileNumber() != null ? realmGet$customerMobileNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isCustomerChecked:");
        stringBuilder.append(realmGet$isCustomerChecked());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{enterPriseCustomerType:");
        stringBuilder.append(realmGet$enterPriseCustomerType() != null ? realmGet$enterPriseCustomerType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paymentCustomerId:");
        stringBuilder.append(realmGet$paymentCustomerId() != null ? realmGet$paymentCustomerId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{registerNo:");
        stringBuilder.append(realmGet$registerNo() != null ? realmGet$registerNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{organizationName:");
        stringBuilder.append(realmGet$organizationName() != null ? realmGet$organizationName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contactpersionName:");
        stringBuilder.append(realmGet$contactpersionName() != null ? realmGet$contactpersionName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateOfIncorporation:");
        stringBuilder.append(realmGet$dateOfIncorporation() != null ? realmGet$dateOfIncorporation() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{billFrequency:");
        stringBuilder.append(realmGet$billFrequency() != null ? realmGet$billFrequency() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address1:");
        stringBuilder.append(realmGet$address1() != null ? realmGet$address1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address2:");
        stringBuilder.append(realmGet$address2() != null ? realmGet$address2() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locality:");
        stringBuilder.append(realmGet$locality() != null ? realmGet$locality() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
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
        EnterpriseCustomerRealmProxy aEnterpriseCustomer = (EnterpriseCustomerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aEnterpriseCustomer.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aEnterpriseCustomer.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aEnterpriseCustomer.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
