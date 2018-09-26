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

public class TaxRegionModelRealmProxy extends com.app.apsfl.models.TaxRegionModel
    implements RealmObjectProxy, TaxRegionModelRealmProxyInterface {

    static final class TaxRegionModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long pinCodeIndex;
        public long regionCodeIndex;
        public long effectiveFromIndex;
        public long effectiveToIndex;

        TaxRegionModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.pinCodeIndex = getValidColumnIndex(path, table, "TaxRegionModel", "pinCode");
            indicesMap.put("pinCode", this.pinCodeIndex);
            this.regionCodeIndex = getValidColumnIndex(path, table, "TaxRegionModel", "regionCode");
            indicesMap.put("regionCode", this.regionCodeIndex);
            this.effectiveFromIndex = getValidColumnIndex(path, table, "TaxRegionModel", "effectiveFrom");
            indicesMap.put("effectiveFrom", this.effectiveFromIndex);
            this.effectiveToIndex = getValidColumnIndex(path, table, "TaxRegionModel", "effectiveTo");
            indicesMap.put("effectiveTo", this.effectiveToIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final TaxRegionModelColumnInfo otherInfo = (TaxRegionModelColumnInfo) other;
            this.pinCodeIndex = otherInfo.pinCodeIndex;
            this.regionCodeIndex = otherInfo.regionCodeIndex;
            this.effectiveFromIndex = otherInfo.effectiveFromIndex;
            this.effectiveToIndex = otherInfo.effectiveToIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final TaxRegionModelColumnInfo clone() {
            return (TaxRegionModelColumnInfo) super.clone();
        }

    }
    private TaxRegionModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("pinCode");
        fieldNames.add("regionCode");
        fieldNames.add("effectiveFrom");
        fieldNames.add("effectiveTo");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TaxRegionModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TaxRegionModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.TaxRegionModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'pinCode' cannot be changed after object was created.");
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
    public Double realmGet$effectiveFrom() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.effectiveFromIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.effectiveFromIndex);
    }

    public void realmSet$effectiveFrom(Double value) {
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
            row.getTable().setDouble(columnInfo.effectiveFromIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.effectiveFromIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.effectiveFromIndex, value);
    }

    @SuppressWarnings("cast")
    public Double realmGet$effectiveTo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.effectiveToIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.effectiveToIndex);
    }

    public void realmSet$effectiveTo(Double value) {
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
            row.getTable().setDouble(columnInfo.effectiveToIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.effectiveToIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.effectiveToIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("TaxRegionModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("TaxRegionModel");
            realmObjectSchema.add(new Property("pinCode", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("regionCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("effectiveFrom", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("effectiveTo", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("TaxRegionModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_TaxRegionModel")) {
            Table table = sharedRealm.getTable("class_TaxRegionModel");
            table.addColumn(RealmFieldType.STRING, "pinCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "regionCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "effectiveFrom", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "effectiveTo", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("pinCode"));
            table.setPrimaryKey("pinCode");
            return table;
        }
        return sharedRealm.getTable("class_TaxRegionModel");
    }

    public static TaxRegionModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_TaxRegionModel")) {
            Table table = sharedRealm.getTable("class_TaxRegionModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 4) {
                if (columnCount < 4) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final TaxRegionModelColumnInfo columnInfo = new TaxRegionModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("pinCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pinCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("pinCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'pinCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.pinCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'pinCode' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("pinCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'pinCode' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("pinCode"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'pinCode' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            if (!columnTypes.containsKey("effectiveFrom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'effectiveFrom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("effectiveFrom") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'effectiveFrom' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.effectiveFromIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'effectiveFrom' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'effectiveFrom' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("effectiveTo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'effectiveTo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("effectiveTo") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'effectiveTo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.effectiveToIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'effectiveTo' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'effectiveTo' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'TaxRegionModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_TaxRegionModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.TaxRegionModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.TaxRegionModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.TaxRegionModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("pinCode")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("pinCode"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.TaxRegionModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TaxRegionModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("pinCode")) {
                if (json.isNull("pinCode")) {
                    obj = (io.realm.TaxRegionModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.TaxRegionModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TaxRegionModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.TaxRegionModel.class, json.getString("pinCode"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pinCode'.");
            }
        }
        if (json.has("regionCode")) {
            if (json.isNull("regionCode")) {
                ((TaxRegionModelRealmProxyInterface) obj).realmSet$regionCode(null);
            } else {
                ((TaxRegionModelRealmProxyInterface) obj).realmSet$regionCode((String) json.getString("regionCode"));
            }
        }
        if (json.has("effectiveFrom")) {
            if (json.isNull("effectiveFrom")) {
                ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveFrom(null);
            } else {
                ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveFrom((double) json.getDouble("effectiveFrom"));
            }
        }
        if (json.has("effectiveTo")) {
            if (json.isNull("effectiveTo")) {
                ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveTo(null);
            } else {
                ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveTo((double) json.getDouble("effectiveTo"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.TaxRegionModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.TaxRegionModel obj = new com.app.apsfl.models.TaxRegionModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("pinCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$pinCode(null);
                } else {
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$pinCode((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("regionCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$regionCode(null);
                } else {
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$regionCode((String) reader.nextString());
                }
            } else if (name.equals("effectiveFrom")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveFrom(null);
                } else {
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveFrom((double) reader.nextDouble());
                }
            } else if (name.equals("effectiveTo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveTo(null);
                } else {
                    ((TaxRegionModelRealmProxyInterface) obj).realmSet$effectiveTo((double) reader.nextDouble());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pinCode'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.TaxRegionModel copyOrUpdate(Realm realm, com.app.apsfl.models.TaxRegionModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.TaxRegionModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.TaxRegionModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.TaxRegionModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((TaxRegionModelRealmProxyInterface) object).realmGet$pinCode();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.TaxRegionModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.TaxRegionModelRealmProxy();
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

    public static com.app.apsfl.models.TaxRegionModel copy(Realm realm, com.app.apsfl.models.TaxRegionModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.TaxRegionModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.TaxRegionModel realmObject = realm.createObjectInternal(com.app.apsfl.models.TaxRegionModel.class, ((TaxRegionModelRealmProxyInterface) newObject).realmGet$pinCode(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((TaxRegionModelRealmProxyInterface) realmObject).realmSet$regionCode(((TaxRegionModelRealmProxyInterface) newObject).realmGet$regionCode());
            ((TaxRegionModelRealmProxyInterface) realmObject).realmSet$effectiveFrom(((TaxRegionModelRealmProxyInterface) newObject).realmGet$effectiveFrom());
            ((TaxRegionModelRealmProxyInterface) realmObject).realmSet$effectiveTo(((TaxRegionModelRealmProxyInterface) newObject).realmGet$effectiveTo());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.TaxRegionModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.TaxRegionModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxRegionModelColumnInfo columnInfo = (TaxRegionModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxRegionModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((TaxRegionModelRealmProxyInterface) object).realmGet$pinCode();
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
        String realmGet$regionCode = ((TaxRegionModelRealmProxyInterface)object).realmGet$regionCode();
        if (realmGet$regionCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
        }
        Double realmGet$effectiveFrom = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveFrom();
        if (realmGet$effectiveFrom != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
        }
        Double realmGet$effectiveTo = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveTo();
        if (realmGet$effectiveTo != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.TaxRegionModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxRegionModelColumnInfo columnInfo = (TaxRegionModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxRegionModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.TaxRegionModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.TaxRegionModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((TaxRegionModelRealmProxyInterface) object).realmGet$pinCode();
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
                String realmGet$regionCode = ((TaxRegionModelRealmProxyInterface)object).realmGet$regionCode();
                if (realmGet$regionCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
                }
                Double realmGet$effectiveFrom = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveFrom();
                if (realmGet$effectiveFrom != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
                }
                Double realmGet$effectiveTo = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveTo();
                if (realmGet$effectiveTo != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.TaxRegionModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.TaxRegionModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxRegionModelColumnInfo columnInfo = (TaxRegionModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxRegionModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((TaxRegionModelRealmProxyInterface) object).realmGet$pinCode();
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
        String realmGet$regionCode = ((TaxRegionModelRealmProxyInterface)object).realmGet$regionCode();
        if (realmGet$regionCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, false);
        }
        Double realmGet$effectiveFrom = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveFrom();
        if (realmGet$effectiveFrom != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, false);
        }
        Double realmGet$effectiveTo = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveTo();
        if (realmGet$effectiveTo != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.TaxRegionModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaxRegionModelColumnInfo columnInfo = (TaxRegionModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.TaxRegionModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.TaxRegionModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.TaxRegionModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((TaxRegionModelRealmProxyInterface) object).realmGet$pinCode();
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
                String realmGet$regionCode = ((TaxRegionModelRealmProxyInterface)object).realmGet$regionCode();
                if (realmGet$regionCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, realmGet$regionCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.regionCodeIndex, rowIndex, false);
                }
                Double realmGet$effectiveFrom = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveFrom();
                if (realmGet$effectiveFrom != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, realmGet$effectiveFrom, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.effectiveFromIndex, rowIndex, false);
                }
                Double realmGet$effectiveTo = ((TaxRegionModelRealmProxyInterface)object).realmGet$effectiveTo();
                if (realmGet$effectiveTo != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, realmGet$effectiveTo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.effectiveToIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.TaxRegionModel createDetachedCopy(com.app.apsfl.models.TaxRegionModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.TaxRegionModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.TaxRegionModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.TaxRegionModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.TaxRegionModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((TaxRegionModelRealmProxyInterface) unmanagedObject).realmSet$pinCode(((TaxRegionModelRealmProxyInterface) realmObject).realmGet$pinCode());
        ((TaxRegionModelRealmProxyInterface) unmanagedObject).realmSet$regionCode(((TaxRegionModelRealmProxyInterface) realmObject).realmGet$regionCode());
        ((TaxRegionModelRealmProxyInterface) unmanagedObject).realmSet$effectiveFrom(((TaxRegionModelRealmProxyInterface) realmObject).realmGet$effectiveFrom());
        ((TaxRegionModelRealmProxyInterface) unmanagedObject).realmSet$effectiveTo(((TaxRegionModelRealmProxyInterface) realmObject).realmGet$effectiveTo());
        return unmanagedObject;
    }

    static com.app.apsfl.models.TaxRegionModel update(Realm realm, com.app.apsfl.models.TaxRegionModel realmObject, com.app.apsfl.models.TaxRegionModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((TaxRegionModelRealmProxyInterface) realmObject).realmSet$regionCode(((TaxRegionModelRealmProxyInterface) newObject).realmGet$regionCode());
        ((TaxRegionModelRealmProxyInterface) realmObject).realmSet$effectiveFrom(((TaxRegionModelRealmProxyInterface) newObject).realmGet$effectiveFrom());
        ((TaxRegionModelRealmProxyInterface) realmObject).realmSet$effectiveTo(((TaxRegionModelRealmProxyInterface) newObject).realmGet$effectiveTo());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TaxRegionModel = [");
        stringBuilder.append("{pinCode:");
        stringBuilder.append(realmGet$pinCode() != null ? realmGet$pinCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{regionCode:");
        stringBuilder.append(realmGet$regionCode() != null ? realmGet$regionCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{effectiveFrom:");
        stringBuilder.append(realmGet$effectiveFrom() != null ? realmGet$effectiveFrom() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{effectiveTo:");
        stringBuilder.append(realmGet$effectiveTo() != null ? realmGet$effectiveTo() : "null");
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
        TaxRegionModelRealmProxy aTaxRegionModel = (TaxRegionModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTaxRegionModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTaxRegionModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTaxRegionModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
