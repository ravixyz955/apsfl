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

public class TaxModelRealmProxy extends com.app.apsfl.models.TaxModel
    implements RealmObjectProxy, TaxModelRealmProxyInterface {

    static final class TaxModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long uniqueKeyIndex;
        public long regionCodeIndex;
        public long taxCodeIndex;
        public long effectiveFromIndex;
        public long effectiveToIndex;
        public long taxPercentageIndex;
        public long isAbsoluteIndex;

        TaxModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.uniqueKeyIndex = getValidColumnIndex(path, table, "TaxModel", "uniqueKey");
            indicesMap.put("uniqueKey", this.uniqueKeyIndex);
            this.regionCodeIndex = getValidColumnIndex(path, table, "TaxModel", "regionCode");
            indicesMap.put("regionCode", this.regionCodeIndex);
            this.taxCodeIndex = getValidColumnIndex(path, table, "TaxModel", "taxCode");
            indicesMap.put("taxCode", this.taxCodeIndex);
            this.effectiveFromIndex = getValidColumnIndex(path, table, "TaxModel", "effectiveFrom");
            indicesMap.put("effectiveFrom", this.effectiveFromIndex);
            this.effectiveToIndex = getValidColumnIndex(path, table, "TaxModel", "effectiveTo");
            indicesMap.put("effectiveTo", this.effectiveToIndex);
            this.taxPercentageIndex = getValidColumnIndex(path, table, "TaxModel", "taxPercentage");
            indicesMap.put("taxPercentage", this.taxPercentageIndex);
            this.isAbsoluteIndex = getValidColumnIndex(path, table, "TaxModel", "isAbsolute");
            indicesMap.put("isAbsolute", this.isAbsoluteIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final TaxModelColumnInfo otherInfo = (TaxModelColumnInfo) other;
            this.uniqueKeyIndex = otherInfo.uniqueKeyIndex;
            this.regionCodeIndex = otherInfo.regionCodeIndex;
            this.taxCodeIndex = otherInfo.taxCodeIndex;
            this.effectiveFromIndex = otherInfo.effectiveFromIndex;
            this.effectiveToIndex = otherInfo.effectiveToIndex;
            this.taxPercentageIndex = otherInfo.taxPercentageIndex;
            this.isAbsoluteIndex = otherInfo.isAbsoluteIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final TaxModelColumnInfo clone() {
            return (TaxModelColumnInfo) super.clone();
        }

    }
    private TaxModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("uniqueKey");
        fieldNames.add("regionCode");
        fieldNames.add("taxCode");
        fieldNames.add("effectiveFrom");
        fieldNames.add("effectiveTo");
        fieldNames.add("taxPercentage");
        fieldNames.add("isAbsolute");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TaxModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TaxModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.TaxModel.class, this);
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
    public String realmGet$regionCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.regionCodeIndex);
    }

    public void realmSet$regionCode(String value) {
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
                row.getTable().setNull(columnInfo.regionCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.regionCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.regionCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.regionCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$taxCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.taxCodeIndex);
    }

    public void realmSet$taxCode(String value) {
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
                row.getTable().setNull(columnInfo.taxCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.taxCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.taxCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.taxCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public Long realmGet$effectiveFrom() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.effectiveFromIndex)) {
            return null;
        }
        return (long) proxyState.getRow$realm().getLong(columnInfo.effectiveFromIndex);
    }

    public void realmSet$effectiveFrom(Long value) {
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
            row.getTable().setLong(columnInfo.effectiveFromIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.effectiveFromIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.effectiveFromIndex, value);
    }

    @SuppressWarnings("cast")
    public Long realmGet$effectiveTo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.effectiveToIndex)) {
            return null;
        }
        return (long) proxyState.getRow$realm().getLong(columnInfo.effectiveToIndex);
    }

    public void realmSet$effectiveTo(Long value) {
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
                row.getTable().setNull(columnInfo.effectiveToIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.effectiveToIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.effectiveToIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.effectiveToIndex, value);
    }

    @SuppressWarnings("cast")
    public Double realmGet$taxPercentage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.taxPercentageIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.taxPercentageIndex);
    }

    public void realmSet$taxPercentage(Double value) {
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
                row.getTable().setNull(columnInfo.taxPercentageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.taxPercentageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.taxPercentageIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.taxPercentageIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isAbsolute() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isAbsoluteIndex);
    }

    public void realmSet$isAbsolute(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isAbsoluteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isAbsoluteIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("TaxModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("TaxModel");
            realmObjectSchema.add(new Property("uniqueKey", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("regionCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("taxCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("effectiveFrom", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("effectiveTo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("taxPercentage", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isAbsolute", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("TaxModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_TaxModel")) {
            Table table = sharedRealm.getTable("class_TaxModel");
            table.addColumn(RealmFieldType.STRING, "uniqueKey", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "regionCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "taxCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "effectiveFrom", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "effectiveTo", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "taxPercentage", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isAbsolute", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("uniqueKey"));
            table.setPrimaryKey("uniqueKey");
            return table;
        }
        return sharedRealm.getTable("class_TaxModel");
    }

    public static TaxModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_TaxModel")) {
            Table table = sharedRealm.getTable("class_TaxModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 7) {
                if (columnCount < 7) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 7; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final TaxModelColumnInfo columnInfo = new TaxModelColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("regionCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'regionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("regionCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'regionCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.regionCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'regionCode' is required. Either set @Required to field 'regionCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("taxCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'taxCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("taxCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'taxCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.taxCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'taxCode' is required. Either set @Required to field 'taxCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("effectiveFrom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'effectiveFrom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("effectiveFrom") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Long' for field 'effectiveFrom' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.effectiveFromIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'effectiveFrom' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'effectiveFrom' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("effectiveTo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'effectiveTo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("effectiveTo") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Long' for field 'effectiveTo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.effectiveToIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'effectiveTo' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'effectiveTo' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("taxPercentage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'taxPercentage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("taxPercentage") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'taxPercentage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.taxPercentageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'taxPercentage' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'taxPercentage' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isAbsolute")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isAbsolute' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isAbsolute") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isAbsolute' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isAbsoluteIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isAbsolute' does support null values in the existing Realm file. Use corresponding boxed type for field 'isAbsolute' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'TaxModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_TaxModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.TaxModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.TaxModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.TaxModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.TaxModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TaxModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uniqueKey")) {
                if (json.isNull("uniqueKey")) {
                    obj = (io.realm.TaxModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.TaxModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TaxModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.TaxModel.class, json.getString("uniqueKey"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uniqueKey'.");
            }
        }
        if (json.has("regionCode")) {
            if (json.isNull("regionCode")) {
                ((TaxModelRealmProxyInterface) obj).realmSet$regionCode(null);
            } else {
                ((TaxModelRealmProxyInterface) obj).realmSet$regionCode((String) json.getString("regionCode"));
            }
        }
        if (json.has("taxCode")) {
            if (json.isNull("taxCode")) {
                ((TaxModelRealmProxyInterface) obj).realmSet$taxCode(null);
            } else {
                ((TaxModelRealmProxyInterface) obj).realmSet$taxCode((String) json.getString("taxCode"));
            }
        }
        if (json.has("effectiveFrom")) {
            if (json.isNull("effectiveFrom")) {
                ((TaxModelRealmProxyInterface) obj).realmSet$effectiveFrom(null);
            } else {
                ((TaxModelRealmProxyInterface) obj).realmSet$effectiveFrom((long) json.getLong("effectiveFrom"));
            }
        }
        if (json.has("effectiveTo")) {
            if (json.isNull("effectiveTo")) {
                ((TaxModelRealmProxyInterface) obj).realmSet$effectiveTo(null);
            } else {
                ((TaxModelRealmProxyInterface) obj).realmSet$effectiveTo((long) json.getLong("effectiveTo"));
            }
        }
        if (json.has("taxPercentage")) {
            if (json.isNull("taxPercentage")) {
                ((TaxModelRealmProxyInterface) obj).realmSet$taxPercentage(null);
            } else {
                ((TaxModelRealmProxyInterface) obj).realmSet$taxPercentage((double) json.getDouble("taxPercentage"));
            }
        }
        if (json.has("isAbsolute")) {
            if (json.isNull("isAbsolute")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isAbsolute' to null.");
            } else {
                ((TaxModelRealmProxyInterface) obj).realmSet$isAbsolute((boolean) json.getBoolean("isAbsolute"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.TaxModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.TaxModel obj = new com.app.apsfl.models.TaxModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("uniqueKey")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxModelRealmProxyInterface) obj).realmSet$uniqueKey(null);
                } else {
                    ((TaxModelRealmProxyInterface) obj).realmSet$uniqueKey((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("regionCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxModelRealmProxyInterface) obj).realmSet$regionCode(null);
                } else {
                    ((TaxModelRealmProxyInterface) obj).realmSet$regionCode((String) reader.nextString());
                }
            } else if (name.equals("taxCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxModelRealmProxyInterface) obj).realmSet$taxCode(null);
                } else {
                    ((TaxModelRealmProxyInterface) obj).realmSet$taxCode((String) reader.nextString());
                }
            } else if (name.equals("effectiveFrom")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxModelRealmProxyInterface) obj).realmSet$effectiveFrom(null);
                } else {
                    ((TaxModelRealmProxyInterface) obj).realmSet$effectiveFrom((long) reader.nextLong());
                }
            } else if (name.equals("effectiveTo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxModelRealmProxyInterface) obj).realmSet$effectiveTo(null);
                } else {
                    ((TaxModelRealmProxyInterface) obj).realmSet$effectiveTo((long) reader.nextLong());
                }
            } else if (name.equals("taxPercentage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxModelRealmProxyInterface) obj).realmSet$taxPercentage(null);
                } else {
                    ((TaxModelRealmProxyInterface) obj).realmSet$taxPercentage((double) reader.nextDouble());
                }
            } else if (name.equals("isAbsolute")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isAbsolute' to null.");
                } else {
                    ((TaxModelRealmProxyInterface) obj).realmSet$isAbsolute((boolean) reader.nextBoolean());
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

    public static com.app.apsfl.models.TaxModel copyOrUpdate(Realm realm, com.app.apsfl.models.TaxModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.TaxModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.TaxModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.TaxModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((TaxModelRealmProxyInterface) object).realmGet$uniqueKey();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.TaxModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.TaxModelRealmProxy();
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

    public static com.app.apsfl.models.TaxModel copy(Realm realm, com.app.apsfl.models.TaxModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.TaxModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.TaxModel realmObject = realm.createObjectInternal(com.app.apsfl.models.TaxModel.class, ((TaxModelRealmProxyInterface) newObject).realmGet$uniqueKey(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((TaxModelRealmProxyInterface) realmObject).realmSet$regionCode(((TaxModelRealmProxyInterface) newObject).realmGet$regionCode());
            ((TaxModelRealmProxyInterface) realmObject).realmSet$taxCode(((TaxModelRealmProxyInterface) newObject).realmGet$taxCode());
            ((TaxModelRealmProxyInterface) realmObject).realmSet$effectiveFrom(((TaxModelRealmProxyInterface) newObject).realmGet$effectiveFrom());
            ((TaxModelRealmProxyInterface) realmObject).realmSet$effectiveTo(((TaxModelRealmProxyInterface) newObject).realmGet$effectiveTo());
            ((TaxModelRealmProxyInterface) realmObject).realmSet$taxPercentage(((TaxModelRealmProxyInterface) newObject).realmGet$taxPercentage());
            ((TaxModelRealmProxyInterface) realmObject).realmSet$isAbsolute(((TaxModelRealmProxyInterface) newObject).realmGet$isAbsolute());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.TaxModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.TaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxModelColumnInfo columnInfo = (TaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((TaxModelRealmProxyInterface) object).realmGet$uniqueKey();
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
        String realmGet$regionCode = ((TaxModelRealmProxyInterface)object).realmGet$regionCode();
        if (realmGet$regionCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
        }
        String realmGet$taxCode = ((TaxModelRealmProxyInterface)object).realmGet$taxCode();
        if (realmGet$taxCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
        }
        Number realmGet$effectiveFrom = ((TaxModelRealmProxyInterface)object).realmGet$effectiveFrom();
        if (realmGet$effectiveFrom != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom.longValue(), false);
        }
        Number realmGet$effectiveTo = ((TaxModelRealmProxyInterface)object).realmGet$effectiveTo();
        if (realmGet$effectiveTo != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo.longValue(), false);
        }
        Double realmGet$taxPercentage = ((TaxModelRealmProxyInterface)object).realmGet$taxPercentage();
        if (realmGet$taxPercentage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.taxPercentageIndex, rowIndex, realmGet$taxPercentage, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isAbsoluteIndex, rowIndex, ((TaxModelRealmProxyInterface)object).realmGet$isAbsolute(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.TaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxModelColumnInfo columnInfo = (TaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.TaxModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.TaxModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((TaxModelRealmProxyInterface) object).realmGet$uniqueKey();
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
                String realmGet$regionCode = ((TaxModelRealmProxyInterface)object).realmGet$regionCode();
                if (realmGet$regionCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
                }
                String realmGet$taxCode = ((TaxModelRealmProxyInterface)object).realmGet$taxCode();
                if (realmGet$taxCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
                }
                Number realmGet$effectiveFrom = ((TaxModelRealmProxyInterface)object).realmGet$effectiveFrom();
                if (realmGet$effectiveFrom != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom.longValue(), false);
                }
                Number realmGet$effectiveTo = ((TaxModelRealmProxyInterface)object).realmGet$effectiveTo();
                if (realmGet$effectiveTo != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo.longValue(), false);
                }
                Double realmGet$taxPercentage = ((TaxModelRealmProxyInterface)object).realmGet$taxPercentage();
                if (realmGet$taxPercentage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.taxPercentageIndex, rowIndex, realmGet$taxPercentage, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isAbsoluteIndex, rowIndex, ((TaxModelRealmProxyInterface)object).realmGet$isAbsolute(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.TaxModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.TaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxModelColumnInfo columnInfo = (TaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((TaxModelRealmProxyInterface) object).realmGet$uniqueKey();
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
        String realmGet$regionCode = ((TaxModelRealmProxyInterface)object).realmGet$regionCode();
        if (realmGet$regionCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, false);
        }
        String realmGet$taxCode = ((TaxModelRealmProxyInterface)object).realmGet$taxCode();
        if (realmGet$taxCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, false);
        }
        Number realmGet$effectiveFrom = ((TaxModelRealmProxyInterface)object).realmGet$effectiveFrom();
        if (realmGet$effectiveFrom != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, false);
        }
        Number realmGet$effectiveTo = ((TaxModelRealmProxyInterface)object).realmGet$effectiveTo();
        if (realmGet$effectiveTo != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, false);
        }
        Double realmGet$taxPercentage = ((TaxModelRealmProxyInterface)object).realmGet$taxPercentage();
        if (realmGet$taxPercentage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.taxPercentageIndex, rowIndex, realmGet$taxPercentage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.taxPercentageIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isAbsoluteIndex, rowIndex, ((TaxModelRealmProxyInterface)object).realmGet$isAbsolute(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.TaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxModelColumnInfo columnInfo = (TaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.TaxModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.TaxModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((TaxModelRealmProxyInterface) object).realmGet$uniqueKey();
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
                String realmGet$regionCode = ((TaxModelRealmProxyInterface)object).realmGet$regionCode();
                if (realmGet$regionCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, false);
                }
                String realmGet$taxCode = ((TaxModelRealmProxyInterface)object).realmGet$taxCode();
                if (realmGet$taxCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, false);
                }
                Number realmGet$effectiveFrom = ((TaxModelRealmProxyInterface)object).realmGet$effectiveFrom();
                if (realmGet$effectiveFrom != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, false);
                }
                Number realmGet$effectiveTo = ((TaxModelRealmProxyInterface)object).realmGet$effectiveTo();
                if (realmGet$effectiveTo != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, false);
                }
                Double realmGet$taxPercentage = ((TaxModelRealmProxyInterface)object).realmGet$taxPercentage();
                if (realmGet$taxPercentage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.taxPercentageIndex, rowIndex, realmGet$taxPercentage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.taxPercentageIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isAbsoluteIndex, rowIndex, ((TaxModelRealmProxyInterface)object).realmGet$isAbsolute(), false);
            }
        }
    }

    public static com.app.apsfl.models.TaxModel createDetachedCopy(com.app.apsfl.models.TaxModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.TaxModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.TaxModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.TaxModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.TaxModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((TaxModelRealmProxyInterface) unmanagedObject).realmSet$uniqueKey(((TaxModelRealmProxyInterface) realmObject).realmGet$uniqueKey());
        ((TaxModelRealmProxyInterface) unmanagedObject).realmSet$regionCode(((TaxModelRealmProxyInterface) realmObject).realmGet$regionCode());
        ((TaxModelRealmProxyInterface) unmanagedObject).realmSet$taxCode(((TaxModelRealmProxyInterface) realmObject).realmGet$taxCode());
        ((TaxModelRealmProxyInterface) unmanagedObject).realmSet$effectiveFrom(((TaxModelRealmProxyInterface) realmObject).realmGet$effectiveFrom());
        ((TaxModelRealmProxyInterface) unmanagedObject).realmSet$effectiveTo(((TaxModelRealmProxyInterface) realmObject).realmGet$effectiveTo());
        ((TaxModelRealmProxyInterface) unmanagedObject).realmSet$taxPercentage(((TaxModelRealmProxyInterface) realmObject).realmGet$taxPercentage());
        ((TaxModelRealmProxyInterface) unmanagedObject).realmSet$isAbsolute(((TaxModelRealmProxyInterface) realmObject).realmGet$isAbsolute());
        return unmanagedObject;
    }

    static com.app.apsfl.models.TaxModel update(Realm realm, com.app.apsfl.models.TaxModel realmObject, com.app.apsfl.models.TaxModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((TaxModelRealmProxyInterface) realmObject).realmSet$regionCode(((TaxModelRealmProxyInterface) newObject).realmGet$regionCode());
        ((TaxModelRealmProxyInterface) realmObject).realmSet$taxCode(((TaxModelRealmProxyInterface) newObject).realmGet$taxCode());
        ((TaxModelRealmProxyInterface) realmObject).realmSet$effectiveFrom(((TaxModelRealmProxyInterface) newObject).realmGet$effectiveFrom());
        ((TaxModelRealmProxyInterface) realmObject).realmSet$effectiveTo(((TaxModelRealmProxyInterface) newObject).realmGet$effectiveTo());
        ((TaxModelRealmProxyInterface) realmObject).realmSet$taxPercentage(((TaxModelRealmProxyInterface) newObject).realmGet$taxPercentage());
        ((TaxModelRealmProxyInterface) realmObject).realmSet$isAbsolute(((TaxModelRealmProxyInterface) newObject).realmGet$isAbsolute());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TaxModel = [");
        stringBuilder.append("{uniqueKey:");
        stringBuilder.append(realmGet$uniqueKey() != null ? realmGet$uniqueKey() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{regionCode:");
        stringBuilder.append(realmGet$regionCode() != null ? realmGet$regionCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{taxCode:");
        stringBuilder.append(realmGet$taxCode() != null ? realmGet$taxCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{effectiveFrom:");
        stringBuilder.append(realmGet$effectiveFrom() != null ? realmGet$effectiveFrom() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{effectiveTo:");
        stringBuilder.append(realmGet$effectiveTo() != null ? realmGet$effectiveTo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{taxPercentage:");
        stringBuilder.append(realmGet$taxPercentage() != null ? realmGet$taxPercentage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isAbsolute:");
        stringBuilder.append(realmGet$isAbsolute());
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
        TaxModelRealmProxy aTaxModel = (TaxModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTaxModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTaxModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTaxModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
