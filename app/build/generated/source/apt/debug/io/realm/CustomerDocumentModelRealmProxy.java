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

public class CustomerDocumentModelRealmProxy extends com.app.apsfl.models.CustomerDocumentModel
    implements RealmObjectProxy, CustomerDocumentModelRealmProxyInterface {

    static final class CustomerDocumentModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long formTimeIndex;
        public long identityTypeIndex;
        public long identityDOCNumberIndex;
        public long identityAuthIndex;
        public long identityPlaceIndex;
        public long identityDateIndex;
        public long addressTypeIndex;
        public long addressDOCNumberIndex;
        public long addressAuthIndex;
        public long addressPlaceIndex;
        public long addressDateIndex;

        CustomerDocumentModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(11);
            this.formTimeIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "formTime");
            indicesMap.put("formTime", this.formTimeIndex);
            this.identityTypeIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "identityType");
            indicesMap.put("identityType", this.identityTypeIndex);
            this.identityDOCNumberIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "identityDOCNumber");
            indicesMap.put("identityDOCNumber", this.identityDOCNumberIndex);
            this.identityAuthIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "identityAuth");
            indicesMap.put("identityAuth", this.identityAuthIndex);
            this.identityPlaceIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "identityPlace");
            indicesMap.put("identityPlace", this.identityPlaceIndex);
            this.identityDateIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "identityDate");
            indicesMap.put("identityDate", this.identityDateIndex);
            this.addressTypeIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "addressType");
            indicesMap.put("addressType", this.addressTypeIndex);
            this.addressDOCNumberIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "addressDOCNumber");
            indicesMap.put("addressDOCNumber", this.addressDOCNumberIndex);
            this.addressAuthIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "addressAuth");
            indicesMap.put("addressAuth", this.addressAuthIndex);
            this.addressPlaceIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "addressPlace");
            indicesMap.put("addressPlace", this.addressPlaceIndex);
            this.addressDateIndex = getValidColumnIndex(path, table, "CustomerDocumentModel", "addressDate");
            indicesMap.put("addressDate", this.addressDateIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CustomerDocumentModelColumnInfo otherInfo = (CustomerDocumentModelColumnInfo) other;
            this.formTimeIndex = otherInfo.formTimeIndex;
            this.identityTypeIndex = otherInfo.identityTypeIndex;
            this.identityDOCNumberIndex = otherInfo.identityDOCNumberIndex;
            this.identityAuthIndex = otherInfo.identityAuthIndex;
            this.identityPlaceIndex = otherInfo.identityPlaceIndex;
            this.identityDateIndex = otherInfo.identityDateIndex;
            this.addressTypeIndex = otherInfo.addressTypeIndex;
            this.addressDOCNumberIndex = otherInfo.addressDOCNumberIndex;
            this.addressAuthIndex = otherInfo.addressAuthIndex;
            this.addressPlaceIndex = otherInfo.addressPlaceIndex;
            this.addressDateIndex = otherInfo.addressDateIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CustomerDocumentModelColumnInfo clone() {
            return (CustomerDocumentModelColumnInfo) super.clone();
        }

    }
    private CustomerDocumentModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("formTime");
        fieldNames.add("identityType");
        fieldNames.add("identityDOCNumber");
        fieldNames.add("identityAuth");
        fieldNames.add("identityPlace");
        fieldNames.add("identityDate");
        fieldNames.add("addressType");
        fieldNames.add("addressDOCNumber");
        fieldNames.add("addressAuth");
        fieldNames.add("addressPlace");
        fieldNames.add("addressDate");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CustomerDocumentModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CustomerDocumentModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.CustomerDocumentModel.class, this);
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
    public Integer realmGet$identityType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.identityTypeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.identityTypeIndex);
    }

    public void realmSet$identityType(Integer value) {
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
                row.getTable().setNull(columnInfo.identityTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.identityTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identityTypeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.identityTypeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$identityDOCNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.identityDOCNumberIndex);
    }

    public void realmSet$identityDOCNumber(String value) {
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
                row.getTable().setNull(columnInfo.identityDOCNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.identityDOCNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identityDOCNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.identityDOCNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$identityAuth() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.identityAuthIndex);
    }

    public void realmSet$identityAuth(String value) {
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
                row.getTable().setNull(columnInfo.identityAuthIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.identityAuthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identityAuthIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.identityAuthIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$identityPlace() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.identityPlaceIndex);
    }

    public void realmSet$identityPlace(String value) {
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
                row.getTable().setNull(columnInfo.identityPlaceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.identityPlaceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identityPlaceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.identityPlaceIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$identityDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.identityDateIndex);
    }

    public void realmSet$identityDate(String value) {
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
                row.getTable().setNull(columnInfo.identityDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.identityDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identityDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.identityDateIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$addressType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.addressTypeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.addressTypeIndex);
    }

    public void realmSet$addressType(Integer value) {
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
                row.getTable().setNull(columnInfo.addressTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.addressTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressTypeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.addressTypeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$addressDOCNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressDOCNumberIndex);
    }

    public void realmSet$addressDOCNumber(String value) {
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
                row.getTable().setNull(columnInfo.addressDOCNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressDOCNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressDOCNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressDOCNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$addressAuth() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressAuthIndex);
    }

    public void realmSet$addressAuth(String value) {
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
                row.getTable().setNull(columnInfo.addressAuthIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressAuthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressAuthIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressAuthIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$addressPlace() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressPlaceIndex);
    }

    public void realmSet$addressPlace(String value) {
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
                row.getTable().setNull(columnInfo.addressPlaceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressPlaceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressPlaceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressPlaceIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$addressDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressDateIndex);
    }

    public void realmSet$addressDate(String value) {
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
                row.getTable().setNull(columnInfo.addressDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressDateIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CustomerDocumentModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CustomerDocumentModel");
            realmObjectSchema.add(new Property("formTime", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("identityType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("identityDOCNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("identityAuth", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("identityPlace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("identityDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("addressType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("addressDOCNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("addressAuth", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("addressPlace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("addressDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CustomerDocumentModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CustomerDocumentModel")) {
            Table table = sharedRealm.getTable("class_CustomerDocumentModel");
            table.addColumn(RealmFieldType.INTEGER, "formTime", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "identityType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "identityDOCNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "identityAuth", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "identityPlace", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "identityDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "addressType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "addressDOCNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "addressAuth", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "addressPlace", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "addressDate", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("formTime"));
            table.setPrimaryKey("formTime");
            return table;
        }
        return sharedRealm.getTable("class_CustomerDocumentModel");
    }

    public static CustomerDocumentModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CustomerDocumentModel")) {
            Table table = sharedRealm.getTable("class_CustomerDocumentModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 11) {
                if (columnCount < 11) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 11 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 11 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 11 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 11; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CustomerDocumentModelColumnInfo columnInfo = new CustomerDocumentModelColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("identityType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'identityType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("identityType") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'identityType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.identityTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'identityType' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'identityType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("identityDOCNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'identityDOCNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("identityDOCNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'identityDOCNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.identityDOCNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'identityDOCNumber' is required. Either set @Required to field 'identityDOCNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("identityAuth")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'identityAuth' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("identityAuth") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'identityAuth' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.identityAuthIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'identityAuth' is required. Either set @Required to field 'identityAuth' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("identityPlace")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'identityPlace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("identityPlace") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'identityPlace' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.identityPlaceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'identityPlace' is required. Either set @Required to field 'identityPlace' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("identityDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'identityDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("identityDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'identityDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.identityDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'identityDate' is required. Either set @Required to field 'identityDate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("addressType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'addressType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("addressType") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'addressType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.addressTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'addressType' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'addressType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("addressDOCNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'addressDOCNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("addressDOCNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'addressDOCNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.addressDOCNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'addressDOCNumber' is required. Either set @Required to field 'addressDOCNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("addressAuth")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'addressAuth' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("addressAuth") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'addressAuth' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.addressAuthIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'addressAuth' is required. Either set @Required to field 'addressAuth' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("addressPlace")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'addressPlace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("addressPlace") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'addressPlace' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.addressPlaceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'addressPlace' is required. Either set @Required to field 'addressPlace' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("addressDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'addressDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("addressDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'addressDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.addressDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'addressDate' is required. Either set @Required to field 'addressDate' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CustomerDocumentModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CustomerDocumentModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.CustomerDocumentModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.CustomerDocumentModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.CustomerDocumentModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CustomerDocumentModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CustomerDocumentModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("formTime")) {
                if (json.isNull("formTime")) {
                    obj = (io.realm.CustomerDocumentModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CustomerDocumentModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CustomerDocumentModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CustomerDocumentModel.class, json.getLong("formTime"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'formTime'.");
            }
        }
        if (json.has("identityType")) {
            if (json.isNull("identityType")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityType(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityType((int) json.getInt("identityType"));
            }
        }
        if (json.has("identityDOCNumber")) {
            if (json.isNull("identityDOCNumber")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDOCNumber(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDOCNumber((String) json.getString("identityDOCNumber"));
            }
        }
        if (json.has("identityAuth")) {
            if (json.isNull("identityAuth")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityAuth(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityAuth((String) json.getString("identityAuth"));
            }
        }
        if (json.has("identityPlace")) {
            if (json.isNull("identityPlace")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityPlace(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityPlace((String) json.getString("identityPlace"));
            }
        }
        if (json.has("identityDate")) {
            if (json.isNull("identityDate")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDate(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDate((String) json.getString("identityDate"));
            }
        }
        if (json.has("addressType")) {
            if (json.isNull("addressType")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressType(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressType((int) json.getInt("addressType"));
            }
        }
        if (json.has("addressDOCNumber")) {
            if (json.isNull("addressDOCNumber")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDOCNumber(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDOCNumber((String) json.getString("addressDOCNumber"));
            }
        }
        if (json.has("addressAuth")) {
            if (json.isNull("addressAuth")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressAuth(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressAuth((String) json.getString("addressAuth"));
            }
        }
        if (json.has("addressPlace")) {
            if (json.isNull("addressPlace")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressPlace(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressPlace((String) json.getString("addressPlace"));
            }
        }
        if (json.has("addressDate")) {
            if (json.isNull("addressDate")) {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDate(null);
            } else {
                ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDate((String) json.getString("addressDate"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.CustomerDocumentModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.CustomerDocumentModel obj = new com.app.apsfl.models.CustomerDocumentModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("formTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$formTime(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$formTime((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("identityType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityType(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityType((int) reader.nextInt());
                }
            } else if (name.equals("identityDOCNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDOCNumber(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDOCNumber((String) reader.nextString());
                }
            } else if (name.equals("identityAuth")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityAuth(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityAuth((String) reader.nextString());
                }
            } else if (name.equals("identityPlace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityPlace(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityPlace((String) reader.nextString());
                }
            } else if (name.equals("identityDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDate(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$identityDate((String) reader.nextString());
                }
            } else if (name.equals("addressType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressType(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressType((int) reader.nextInt());
                }
            } else if (name.equals("addressDOCNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDOCNumber(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDOCNumber((String) reader.nextString());
                }
            } else if (name.equals("addressAuth")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressAuth(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressAuth((String) reader.nextString());
                }
            } else if (name.equals("addressPlace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressPlace(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressPlace((String) reader.nextString());
                }
            } else if (name.equals("addressDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDate(null);
                } else {
                    ((CustomerDocumentModelRealmProxyInterface) obj).realmSet$addressDate((String) reader.nextString());
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

    public static com.app.apsfl.models.CustomerDocumentModel copyOrUpdate(Realm realm, com.app.apsfl.models.CustomerDocumentModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CustomerDocumentModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.CustomerDocumentModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.CustomerDocumentModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CustomerDocumentModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CustomerDocumentModelRealmProxy();
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

    public static com.app.apsfl.models.CustomerDocumentModel copy(Realm realm, com.app.apsfl.models.CustomerDocumentModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CustomerDocumentModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.CustomerDocumentModel realmObject = realm.createObjectInternal(com.app.apsfl.models.CustomerDocumentModel.class, ((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$formTime(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityType(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityType());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityDOCNumber(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityDOCNumber());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityAuth(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityAuth());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityPlace(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityPlace());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityDate(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityDate());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressType(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressType());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressDOCNumber(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressDOCNumber());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressAuth(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressAuth());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressPlace(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressPlace());
            ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressDate(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressDate());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.CustomerDocumentModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CustomerDocumentModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerDocumentModelColumnInfo columnInfo = (CustomerDocumentModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerDocumentModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Number realmGet$identityType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityType();
        if (realmGet$identityType != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.identityTypeIndex, rowIndex, realmGet$identityType.longValue(), false);
        }
        String realmGet$identityDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDOCNumber();
        if (realmGet$identityDOCNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityDOCNumberIndex, rowIndex, realmGet$identityDOCNumber, false);
        }
        String realmGet$identityAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityAuth();
        if (realmGet$identityAuth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityAuthIndex, rowIndex, realmGet$identityAuth, false);
        }
        String realmGet$identityPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityPlace();
        if (realmGet$identityPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityPlaceIndex, rowIndex, realmGet$identityPlace, false);
        }
        String realmGet$identityDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDate();
        if (realmGet$identityDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityDateIndex, rowIndex, realmGet$identityDate, false);
        }
        Number realmGet$addressType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressType();
        if (realmGet$addressType != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.addressTypeIndex, rowIndex, realmGet$addressType.longValue(), false);
        }
        String realmGet$addressDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDOCNumber();
        if (realmGet$addressDOCNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressDOCNumberIndex, rowIndex, realmGet$addressDOCNumber, false);
        }
        String realmGet$addressAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressAuth();
        if (realmGet$addressAuth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressAuthIndex, rowIndex, realmGet$addressAuth, false);
        }
        String realmGet$addressPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressPlace();
        if (realmGet$addressPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressPlaceIndex, rowIndex, realmGet$addressPlace, false);
        }
        String realmGet$addressDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDate();
        if (realmGet$addressDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressDateIndex, rowIndex, realmGet$addressDate, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CustomerDocumentModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerDocumentModelColumnInfo columnInfo = (CustomerDocumentModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerDocumentModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CustomerDocumentModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CustomerDocumentModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Number realmGet$identityType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityType();
                if (realmGet$identityType != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.identityTypeIndex, rowIndex, realmGet$identityType.longValue(), false);
                }
                String realmGet$identityDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDOCNumber();
                if (realmGet$identityDOCNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityDOCNumberIndex, rowIndex, realmGet$identityDOCNumber, false);
                }
                String realmGet$identityAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityAuth();
                if (realmGet$identityAuth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityAuthIndex, rowIndex, realmGet$identityAuth, false);
                }
                String realmGet$identityPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityPlace();
                if (realmGet$identityPlace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityPlaceIndex, rowIndex, realmGet$identityPlace, false);
                }
                String realmGet$identityDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDate();
                if (realmGet$identityDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityDateIndex, rowIndex, realmGet$identityDate, false);
                }
                Number realmGet$addressType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressType();
                if (realmGet$addressType != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.addressTypeIndex, rowIndex, realmGet$addressType.longValue(), false);
                }
                String realmGet$addressDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDOCNumber();
                if (realmGet$addressDOCNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressDOCNumberIndex, rowIndex, realmGet$addressDOCNumber, false);
                }
                String realmGet$addressAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressAuth();
                if (realmGet$addressAuth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressAuthIndex, rowIndex, realmGet$addressAuth, false);
                }
                String realmGet$addressPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressPlace();
                if (realmGet$addressPlace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressPlaceIndex, rowIndex, realmGet$addressPlace, false);
                }
                String realmGet$addressDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDate();
                if (realmGet$addressDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressDateIndex, rowIndex, realmGet$addressDate, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.CustomerDocumentModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CustomerDocumentModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerDocumentModelColumnInfo columnInfo = (CustomerDocumentModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerDocumentModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime(), false);
        }
        cache.put(object, rowIndex);
        Number realmGet$identityType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityType();
        if (realmGet$identityType != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.identityTypeIndex, rowIndex, realmGet$identityType.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identityTypeIndex, rowIndex, false);
        }
        String realmGet$identityDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDOCNumber();
        if (realmGet$identityDOCNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityDOCNumberIndex, rowIndex, realmGet$identityDOCNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identityDOCNumberIndex, rowIndex, false);
        }
        String realmGet$identityAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityAuth();
        if (realmGet$identityAuth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityAuthIndex, rowIndex, realmGet$identityAuth, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identityAuthIndex, rowIndex, false);
        }
        String realmGet$identityPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityPlace();
        if (realmGet$identityPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityPlaceIndex, rowIndex, realmGet$identityPlace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identityPlaceIndex, rowIndex, false);
        }
        String realmGet$identityDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDate();
        if (realmGet$identityDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityDateIndex, rowIndex, realmGet$identityDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identityDateIndex, rowIndex, false);
        }
        Number realmGet$addressType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressType();
        if (realmGet$addressType != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.addressTypeIndex, rowIndex, realmGet$addressType.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressTypeIndex, rowIndex, false);
        }
        String realmGet$addressDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDOCNumber();
        if (realmGet$addressDOCNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressDOCNumberIndex, rowIndex, realmGet$addressDOCNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressDOCNumberIndex, rowIndex, false);
        }
        String realmGet$addressAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressAuth();
        if (realmGet$addressAuth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressAuthIndex, rowIndex, realmGet$addressAuth, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressAuthIndex, rowIndex, false);
        }
        String realmGet$addressPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressPlace();
        if (realmGet$addressPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressPlaceIndex, rowIndex, realmGet$addressPlace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressPlaceIndex, rowIndex, false);
        }
        String realmGet$addressDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDate();
        if (realmGet$addressDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressDateIndex, rowIndex, realmGet$addressDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressDateIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CustomerDocumentModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomerDocumentModelColumnInfo columnInfo = (CustomerDocumentModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CustomerDocumentModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CustomerDocumentModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CustomerDocumentModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CustomerDocumentModelRealmProxyInterface) object).realmGet$formTime(), false);
                }
                cache.put(object, rowIndex);
                Number realmGet$identityType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityType();
                if (realmGet$identityType != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.identityTypeIndex, rowIndex, realmGet$identityType.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.identityTypeIndex, rowIndex, false);
                }
                String realmGet$identityDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDOCNumber();
                if (realmGet$identityDOCNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityDOCNumberIndex, rowIndex, realmGet$identityDOCNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.identityDOCNumberIndex, rowIndex, false);
                }
                String realmGet$identityAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityAuth();
                if (realmGet$identityAuth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityAuthIndex, rowIndex, realmGet$identityAuth, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.identityAuthIndex, rowIndex, false);
                }
                String realmGet$identityPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityPlace();
                if (realmGet$identityPlace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityPlaceIndex, rowIndex, realmGet$identityPlace, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.identityPlaceIndex, rowIndex, false);
                }
                String realmGet$identityDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$identityDate();
                if (realmGet$identityDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityDateIndex, rowIndex, realmGet$identityDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.identityDateIndex, rowIndex, false);
                }
                Number realmGet$addressType = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressType();
                if (realmGet$addressType != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.addressTypeIndex, rowIndex, realmGet$addressType.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressTypeIndex, rowIndex, false);
                }
                String realmGet$addressDOCNumber = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDOCNumber();
                if (realmGet$addressDOCNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressDOCNumberIndex, rowIndex, realmGet$addressDOCNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressDOCNumberIndex, rowIndex, false);
                }
                String realmGet$addressAuth = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressAuth();
                if (realmGet$addressAuth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressAuthIndex, rowIndex, realmGet$addressAuth, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressAuthIndex, rowIndex, false);
                }
                String realmGet$addressPlace = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressPlace();
                if (realmGet$addressPlace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressPlaceIndex, rowIndex, realmGet$addressPlace, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressPlaceIndex, rowIndex, false);
                }
                String realmGet$addressDate = ((CustomerDocumentModelRealmProxyInterface)object).realmGet$addressDate();
                if (realmGet$addressDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressDateIndex, rowIndex, realmGet$addressDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressDateIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.CustomerDocumentModel createDetachedCopy(com.app.apsfl.models.CustomerDocumentModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.CustomerDocumentModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.CustomerDocumentModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.CustomerDocumentModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.CustomerDocumentModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$formTime(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$formTime());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$identityType(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$identityType());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$identityDOCNumber(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$identityDOCNumber());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$identityAuth(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$identityAuth());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$identityPlace(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$identityPlace());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$identityDate(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$identityDate());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$addressType(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$addressType());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$addressDOCNumber(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$addressDOCNumber());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$addressAuth(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$addressAuth());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$addressPlace(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$addressPlace());
        ((CustomerDocumentModelRealmProxyInterface) unmanagedObject).realmSet$addressDate(((CustomerDocumentModelRealmProxyInterface) realmObject).realmGet$addressDate());
        return unmanagedObject;
    }

    static com.app.apsfl.models.CustomerDocumentModel update(Realm realm, com.app.apsfl.models.CustomerDocumentModel realmObject, com.app.apsfl.models.CustomerDocumentModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityType(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityType());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityDOCNumber(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityDOCNumber());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityAuth(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityAuth());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityPlace(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityPlace());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$identityDate(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$identityDate());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressType(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressType());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressDOCNumber(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressDOCNumber());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressAuth(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressAuth());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressPlace(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressPlace());
        ((CustomerDocumentModelRealmProxyInterface) realmObject).realmSet$addressDate(((CustomerDocumentModelRealmProxyInterface) newObject).realmGet$addressDate());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CustomerDocumentModel = [");
        stringBuilder.append("{formTime:");
        stringBuilder.append(realmGet$formTime() != null ? realmGet$formTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{identityType:");
        stringBuilder.append(realmGet$identityType() != null ? realmGet$identityType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{identityDOCNumber:");
        stringBuilder.append(realmGet$identityDOCNumber() != null ? realmGet$identityDOCNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{identityAuth:");
        stringBuilder.append(realmGet$identityAuth() != null ? realmGet$identityAuth() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{identityPlace:");
        stringBuilder.append(realmGet$identityPlace() != null ? realmGet$identityPlace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{identityDate:");
        stringBuilder.append(realmGet$identityDate() != null ? realmGet$identityDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{addressType:");
        stringBuilder.append(realmGet$addressType() != null ? realmGet$addressType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{addressDOCNumber:");
        stringBuilder.append(realmGet$addressDOCNumber() != null ? realmGet$addressDOCNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{addressAuth:");
        stringBuilder.append(realmGet$addressAuth() != null ? realmGet$addressAuth() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{addressPlace:");
        stringBuilder.append(realmGet$addressPlace() != null ? realmGet$addressPlace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{addressDate:");
        stringBuilder.append(realmGet$addressDate() != null ? realmGet$addressDate() : "null");
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
        CustomerDocumentModelRealmProxy aCustomerDocumentModel = (CustomerDocumentModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCustomerDocumentModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCustomerDocumentModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCustomerDocumentModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
