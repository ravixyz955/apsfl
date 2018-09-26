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

public class VOIPFeatureModelRealmProxy extends com.app.apsfl.models.VOIPFeatureModel
    implements RealmObjectProxy, VOIPFeatureModelRealmProxyInterface {

    static final class VOIPFeatureModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long uniqueKeyIndex;
        public long coreServiceCodeIndex;
        public long effectiveFromIndex;
        public long featureCodeIndex;
        public long paramCodeIndex;
        public long paramNameIndex;
        public long paramTypeIndex;
        public long paramLovNameIndex;
        public long maxParamValuesIndex;

        VOIPFeatureModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(9);
            this.uniqueKeyIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "uniqueKey");
            indicesMap.put("uniqueKey", this.uniqueKeyIndex);
            this.coreServiceCodeIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "coreServiceCode");
            indicesMap.put("coreServiceCode", this.coreServiceCodeIndex);
            this.effectiveFromIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "effectiveFrom");
            indicesMap.put("effectiveFrom", this.effectiveFromIndex);
            this.featureCodeIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "featureCode");
            indicesMap.put("featureCode", this.featureCodeIndex);
            this.paramCodeIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "paramCode");
            indicesMap.put("paramCode", this.paramCodeIndex);
            this.paramNameIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "paramName");
            indicesMap.put("paramName", this.paramNameIndex);
            this.paramTypeIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "paramType");
            indicesMap.put("paramType", this.paramTypeIndex);
            this.paramLovNameIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "paramLovName");
            indicesMap.put("paramLovName", this.paramLovNameIndex);
            this.maxParamValuesIndex = getValidColumnIndex(path, table, "VOIPFeatureModel", "maxParamValues");
            indicesMap.put("maxParamValues", this.maxParamValuesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final VOIPFeatureModelColumnInfo otherInfo = (VOIPFeatureModelColumnInfo) other;
            this.uniqueKeyIndex = otherInfo.uniqueKeyIndex;
            this.coreServiceCodeIndex = otherInfo.coreServiceCodeIndex;
            this.effectiveFromIndex = otherInfo.effectiveFromIndex;
            this.featureCodeIndex = otherInfo.featureCodeIndex;
            this.paramCodeIndex = otherInfo.paramCodeIndex;
            this.paramNameIndex = otherInfo.paramNameIndex;
            this.paramTypeIndex = otherInfo.paramTypeIndex;
            this.paramLovNameIndex = otherInfo.paramLovNameIndex;
            this.maxParamValuesIndex = otherInfo.maxParamValuesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final VOIPFeatureModelColumnInfo clone() {
            return (VOIPFeatureModelColumnInfo) super.clone();
        }

    }
    private VOIPFeatureModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("uniqueKey");
        fieldNames.add("coreServiceCode");
        fieldNames.add("effectiveFrom");
        fieldNames.add("featureCode");
        fieldNames.add("paramCode");
        fieldNames.add("paramName");
        fieldNames.add("paramType");
        fieldNames.add("paramLovName");
        fieldNames.add("maxParamValues");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    VOIPFeatureModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VOIPFeatureModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.VOIPFeatureModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$uniqueKey() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uniqueKeyIndex);
    }

    public void realmSet$uniqueKey(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'uniqueKey' cannot be changed after object was created.");
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
    public String realmGet$effectiveFrom() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.effectiveFromIndex);
    }

    public void realmSet$effectiveFrom(String value) {
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
                row.getTable().setNull(columnInfo.effectiveFromIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.effectiveFromIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.effectiveFromIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.effectiveFromIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$featureCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.featureCodeIndex);
    }

    public void realmSet$featureCode(String value) {
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
                row.getTable().setNull(columnInfo.featureCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.featureCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.featureCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.featureCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$paramCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paramCodeIndex);
    }

    public void realmSet$paramCode(String value) {
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
                row.getTable().setNull(columnInfo.paramCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paramCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paramCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paramCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$paramName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paramNameIndex);
    }

    public void realmSet$paramName(String value) {
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
                row.getTable().setNull(columnInfo.paramNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paramNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paramNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paramNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$paramType() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paramTypeIndex);
    }

    public void realmSet$paramType(String value) {
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
                row.getTable().setNull(columnInfo.paramTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paramTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paramTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paramTypeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$paramLovName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paramLovNameIndex);
    }

    public void realmSet$paramLovName(String value) {
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
                row.getTable().setNull(columnInfo.paramLovNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paramLovNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paramLovNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paramLovNameIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$maxParamValues() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxParamValuesIndex);
    }

    public void realmSet$maxParamValues(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxParamValuesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxParamValuesIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("VOIPFeatureModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("VOIPFeatureModel");
            realmObjectSchema.add(new Property("uniqueKey", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("coreServiceCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("effectiveFrom", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("featureCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("paramCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("paramName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("paramType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("paramLovName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("maxParamValues", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("VOIPFeatureModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_VOIPFeatureModel")) {
            Table table = sharedRealm.getTable("class_VOIPFeatureModel");
            table.addColumn(RealmFieldType.STRING, "uniqueKey", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "coreServiceCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "effectiveFrom", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "featureCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "paramCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "paramName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "paramType", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "paramLovName", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "maxParamValues", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("uniqueKey"));
            table.setPrimaryKey("uniqueKey");
            return table;
        }
        return sharedRealm.getTable("class_VOIPFeatureModel");
    }

    public static VOIPFeatureModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_VOIPFeatureModel")) {
            Table table = sharedRealm.getTable("class_VOIPFeatureModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 9) {
                if (columnCount < 9) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 9 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 9 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 9 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 9; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final VOIPFeatureModelColumnInfo columnInfo = new VOIPFeatureModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("uniqueKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'uniqueKey' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("uniqueKey") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'uniqueKey' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.uniqueKeyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'uniqueKey' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("uniqueKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'uniqueKey' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("uniqueKey"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'uniqueKey' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            if (!columnTypes.containsKey("effectiveFrom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'effectiveFrom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("effectiveFrom") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'effectiveFrom' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.effectiveFromIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'effectiveFrom' is required. Either set @Required to field 'effectiveFrom' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("featureCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'featureCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("featureCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'featureCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.featureCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'featureCode' is required. Either set @Required to field 'featureCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("paramCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'paramCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("paramCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'paramCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.paramCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'paramCode' is required. Either set @Required to field 'paramCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("paramName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'paramName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("paramName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'paramName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.paramNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'paramName' is required. Either set @Required to field 'paramName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("paramType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'paramType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("paramType") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'paramType' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.paramTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'paramType' is required. Either set @Required to field 'paramType' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("paramLovName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'paramLovName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("paramLovName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'paramLovName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.paramLovNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'paramLovName' is required. Either set @Required to field 'paramLovName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("maxParamValues")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxParamValues' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("maxParamValues") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxParamValues' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.maxParamValuesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxParamValues' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxParamValues' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'VOIPFeatureModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_VOIPFeatureModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.VOIPFeatureModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.VOIPFeatureModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.VOIPFeatureModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("uniqueKey")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("uniqueKey"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.VOIPFeatureModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.VOIPFeatureModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uniqueKey")) {
                if (json.isNull("uniqueKey")) {
                    obj = (io.realm.VOIPFeatureModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.VOIPFeatureModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.VOIPFeatureModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.VOIPFeatureModel.class, json.getString("uniqueKey"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uniqueKey'.");
            }
        }
        if (json.has("coreServiceCode")) {
            if (json.isNull("coreServiceCode")) {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$coreServiceCode(null);
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$coreServiceCode((String) json.getString("coreServiceCode"));
            }
        }
        if (json.has("effectiveFrom")) {
            if (json.isNull("effectiveFrom")) {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$effectiveFrom(null);
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$effectiveFrom((String) json.getString("effectiveFrom"));
            }
        }
        if (json.has("featureCode")) {
            if (json.isNull("featureCode")) {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$featureCode(null);
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$featureCode((String) json.getString("featureCode"));
            }
        }
        if (json.has("paramCode")) {
            if (json.isNull("paramCode")) {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramCode(null);
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramCode((String) json.getString("paramCode"));
            }
        }
        if (json.has("paramName")) {
            if (json.isNull("paramName")) {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramName(null);
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramName((String) json.getString("paramName"));
            }
        }
        if (json.has("paramType")) {
            if (json.isNull("paramType")) {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramType(null);
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramType((String) json.getString("paramType"));
            }
        }
        if (json.has("paramLovName")) {
            if (json.isNull("paramLovName")) {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramLovName(null);
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramLovName((String) json.getString("paramLovName"));
            }
        }
        if (json.has("maxParamValues")) {
            if (json.isNull("maxParamValues")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxParamValues' to null.");
            } else {
                ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$maxParamValues((int) json.getInt("maxParamValues"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.VOIPFeatureModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.VOIPFeatureModel obj = new com.app.apsfl.models.VOIPFeatureModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("uniqueKey")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$uniqueKey(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$uniqueKey((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("coreServiceCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$coreServiceCode(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$coreServiceCode((String) reader.nextString());
                }
            } else if (name.equals("effectiveFrom")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$effectiveFrom(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$effectiveFrom((String) reader.nextString());
                }
            } else if (name.equals("featureCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$featureCode(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$featureCode((String) reader.nextString());
                }
            } else if (name.equals("paramCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramCode(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramCode((String) reader.nextString());
                }
            } else if (name.equals("paramName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramName(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramName((String) reader.nextString());
                }
            } else if (name.equals("paramType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramType(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramType((String) reader.nextString());
                }
            } else if (name.equals("paramLovName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramLovName(null);
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$paramLovName((String) reader.nextString());
                }
            } else if (name.equals("maxParamValues")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxParamValues' to null.");
                } else {
                    ((VOIPFeatureModelRealmProxyInterface) obj).realmSet$maxParamValues((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uniqueKey'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.VOIPFeatureModel copyOrUpdate(Realm realm, com.app.apsfl.models.VOIPFeatureModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.VOIPFeatureModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.VOIPFeatureModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.VOIPFeatureModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((VOIPFeatureModelRealmProxyInterface) object).realmGet$uniqueKey();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.VOIPFeatureModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.VOIPFeatureModelRealmProxy();
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

    public static com.app.apsfl.models.VOIPFeatureModel copy(Realm realm, com.app.apsfl.models.VOIPFeatureModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.VOIPFeatureModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.VOIPFeatureModel realmObject = realm.createObjectInternal(com.app.apsfl.models.VOIPFeatureModel.class, ((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$uniqueKey(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$coreServiceCode(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$coreServiceCode());
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$effectiveFrom(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$effectiveFrom());
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$featureCode(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$featureCode());
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramCode(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramCode());
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramName(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramName());
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramType(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramType());
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramLovName(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramLovName());
            ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$maxParamValues(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$maxParamValues());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.VOIPFeatureModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.VOIPFeatureModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VOIPFeatureModelColumnInfo columnInfo = (VOIPFeatureModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VOIPFeatureModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((VOIPFeatureModelRealmProxyInterface) object).realmGet$uniqueKey();
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
        String realmGet$coreServiceCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$coreServiceCode();
        if (realmGet$coreServiceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
        }
        String realmGet$effectiveFrom = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$effectiveFrom();
        if (realmGet$effectiveFrom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
        }
        String realmGet$featureCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$featureCode();
        if (realmGet$featureCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.featureCodeIndex, rowIndex, realmGet$featureCode, false);
        }
        String realmGet$paramCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramCode();
        if (realmGet$paramCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramCodeIndex, rowIndex, realmGet$paramCode, false);
        }
        String realmGet$paramName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramName();
        if (realmGet$paramName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
        }
        String realmGet$paramType = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramType();
        if (realmGet$paramType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramTypeIndex, rowIndex, realmGet$paramType, false);
        }
        String realmGet$paramLovName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramLovName();
        if (realmGet$paramLovName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramLovNameIndex, rowIndex, realmGet$paramLovName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.maxParamValuesIndex, rowIndex, ((VOIPFeatureModelRealmProxyInterface)object).realmGet$maxParamValues(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.VOIPFeatureModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VOIPFeatureModelColumnInfo columnInfo = (VOIPFeatureModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VOIPFeatureModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.VOIPFeatureModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.VOIPFeatureModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((VOIPFeatureModelRealmProxyInterface) object).realmGet$uniqueKey();
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
                String realmGet$coreServiceCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$coreServiceCode();
                if (realmGet$coreServiceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
                }
                String realmGet$effectiveFrom = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$effectiveFrom();
                if (realmGet$effectiveFrom != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
                }
                String realmGet$featureCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$featureCode();
                if (realmGet$featureCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.featureCodeIndex, rowIndex, realmGet$featureCode, false);
                }
                String realmGet$paramCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramCode();
                if (realmGet$paramCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramCodeIndex, rowIndex, realmGet$paramCode, false);
                }
                String realmGet$paramName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramName();
                if (realmGet$paramName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
                }
                String realmGet$paramType = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramType();
                if (realmGet$paramType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramTypeIndex, rowIndex, realmGet$paramType, false);
                }
                String realmGet$paramLovName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramLovName();
                if (realmGet$paramLovName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramLovNameIndex, rowIndex, realmGet$paramLovName, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.maxParamValuesIndex, rowIndex, ((VOIPFeatureModelRealmProxyInterface)object).realmGet$maxParamValues(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.VOIPFeatureModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.VOIPFeatureModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VOIPFeatureModelColumnInfo columnInfo = (VOIPFeatureModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VOIPFeatureModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((VOIPFeatureModelRealmProxyInterface) object).realmGet$uniqueKey();
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
        String realmGet$coreServiceCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$coreServiceCode();
        if (realmGet$coreServiceCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, false);
        }
        String realmGet$effectiveFrom = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$effectiveFrom();
        if (realmGet$effectiveFrom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, false);
        }
        String realmGet$featureCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$featureCode();
        if (realmGet$featureCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.featureCodeIndex, rowIndex, realmGet$featureCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.featureCodeIndex, rowIndex, false);
        }
        String realmGet$paramCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramCode();
        if (realmGet$paramCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramCodeIndex, rowIndex, realmGet$paramCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paramCodeIndex, rowIndex, false);
        }
        String realmGet$paramName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramName();
        if (realmGet$paramName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paramNameIndex, rowIndex, false);
        }
        String realmGet$paramType = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramType();
        if (realmGet$paramType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramTypeIndex, rowIndex, realmGet$paramType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paramTypeIndex, rowIndex, false);
        }
        String realmGet$paramLovName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramLovName();
        if (realmGet$paramLovName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramLovNameIndex, rowIndex, realmGet$paramLovName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paramLovNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.maxParamValuesIndex, rowIndex, ((VOIPFeatureModelRealmProxyInterface)object).realmGet$maxParamValues(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.VOIPFeatureModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VOIPFeatureModelColumnInfo columnInfo = (VOIPFeatureModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VOIPFeatureModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.VOIPFeatureModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.VOIPFeatureModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((VOIPFeatureModelRealmProxyInterface) object).realmGet$uniqueKey();
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
                String realmGet$coreServiceCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$coreServiceCode();
                if (realmGet$coreServiceCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, realmGet$coreServiceCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.coreServiceCodeIndex, rowIndex, false);
                }
                String realmGet$effectiveFrom = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$effectiveFrom();
                if (realmGet$effectiveFrom != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, false);
                }
                String realmGet$featureCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$featureCode();
                if (realmGet$featureCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.featureCodeIndex, rowIndex, realmGet$featureCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.featureCodeIndex, rowIndex, false);
                }
                String realmGet$paramCode = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramCode();
                if (realmGet$paramCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramCodeIndex, rowIndex, realmGet$paramCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.paramCodeIndex, rowIndex, false);
                }
                String realmGet$paramName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramName();
                if (realmGet$paramName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.paramNameIndex, rowIndex, false);
                }
                String realmGet$paramType = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramType();
                if (realmGet$paramType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramTypeIndex, rowIndex, realmGet$paramType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.paramTypeIndex, rowIndex, false);
                }
                String realmGet$paramLovName = ((VOIPFeatureModelRealmProxyInterface)object).realmGet$paramLovName();
                if (realmGet$paramLovName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paramLovNameIndex, rowIndex, realmGet$paramLovName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.paramLovNameIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.maxParamValuesIndex, rowIndex, ((VOIPFeatureModelRealmProxyInterface)object).realmGet$maxParamValues(), false);
            }
        }
    }

    public static com.app.apsfl.models.VOIPFeatureModel createDetachedCopy(com.app.apsfl.models.VOIPFeatureModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.VOIPFeatureModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.VOIPFeatureModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.VOIPFeatureModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.VOIPFeatureModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$uniqueKey(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$uniqueKey());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$coreServiceCode(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$coreServiceCode());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$effectiveFrom(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$effectiveFrom());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$featureCode(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$featureCode());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$paramCode(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$paramCode());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$paramName(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$paramName());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$paramType(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$paramType());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$paramLovName(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$paramLovName());
        ((VOIPFeatureModelRealmProxyInterface) unmanagedObject).realmSet$maxParamValues(((VOIPFeatureModelRealmProxyInterface) realmObject).realmGet$maxParamValues());
        return unmanagedObject;
    }

    static com.app.apsfl.models.VOIPFeatureModel update(Realm realm, com.app.apsfl.models.VOIPFeatureModel realmObject, com.app.apsfl.models.VOIPFeatureModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$coreServiceCode(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$coreServiceCode());
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$effectiveFrom(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$effectiveFrom());
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$featureCode(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$featureCode());
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramCode(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramCode());
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramName(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramName());
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramType(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramType());
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$paramLovName(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$paramLovName());
        ((VOIPFeatureModelRealmProxyInterface) realmObject).realmSet$maxParamValues(((VOIPFeatureModelRealmProxyInterface) newObject).realmGet$maxParamValues());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("VOIPFeatureModel = [");
        stringBuilder.append("{uniqueKey:");
        stringBuilder.append(realmGet$uniqueKey() != null ? realmGet$uniqueKey() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coreServiceCode:");
        stringBuilder.append(realmGet$coreServiceCode() != null ? realmGet$coreServiceCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{effectiveFrom:");
        stringBuilder.append(realmGet$effectiveFrom() != null ? realmGet$effectiveFrom() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{featureCode:");
        stringBuilder.append(realmGet$featureCode() != null ? realmGet$featureCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paramCode:");
        stringBuilder.append(realmGet$paramCode() != null ? realmGet$paramCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paramName:");
        stringBuilder.append(realmGet$paramName() != null ? realmGet$paramName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paramType:");
        stringBuilder.append(realmGet$paramType() != null ? realmGet$paramType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paramLovName:");
        stringBuilder.append(realmGet$paramLovName() != null ? realmGet$paramLovName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxParamValues:");
        stringBuilder.append(realmGet$maxParamValues());
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
        VOIPFeatureModelRealmProxy aVOIPFeatureModel = (VOIPFeatureModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVOIPFeatureModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVOIPFeatureModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVOIPFeatureModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
