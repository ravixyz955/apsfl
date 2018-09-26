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

public class DistrictModelRealmProxy extends com.app.apsfl.models.DistrictModel
    implements RealmObjectProxy, DistrictModelRealmProxyInterface {

    static final class DistrictModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long districtIDIndex;
        public long districtNameIndex;

        DistrictModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.districtIDIndex = getValidColumnIndex(path, table, "DistrictModel", "districtID");
            indicesMap.put("districtID", this.districtIDIndex);
            this.districtNameIndex = getValidColumnIndex(path, table, "DistrictModel", "districtName");
            indicesMap.put("districtName", this.districtNameIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final DistrictModelColumnInfo otherInfo = (DistrictModelColumnInfo) other;
            this.districtIDIndex = otherInfo.districtIDIndex;
            this.districtNameIndex = otherInfo.districtNameIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final DistrictModelColumnInfo clone() {
            return (DistrictModelColumnInfo) super.clone();
        }

    }
    private DistrictModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("districtID");
        fieldNames.add("districtName");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    DistrictModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DistrictModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.DistrictModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$districtID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.districtIDIndex);
    }

    public void realmSet$districtID(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'districtID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$districtName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.districtNameIndex);
    }

    public void realmSet$districtName(String value) {
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
                row.getTable().setNull(columnInfo.districtNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.districtNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.districtNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.districtNameIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("DistrictModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("DistrictModel");
            realmObjectSchema.add(new Property("districtID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("districtName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("DistrictModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_DistrictModel")) {
            Table table = sharedRealm.getTable("class_DistrictModel");
            table.addColumn(RealmFieldType.STRING, "districtID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "districtName", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("districtID"));
            table.setPrimaryKey("districtID");
            return table;
        }
        return sharedRealm.getTable("class_DistrictModel");
    }

    public static DistrictModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_DistrictModel")) {
            Table table = sharedRealm.getTable("class_DistrictModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final DistrictModelColumnInfo columnInfo = new DistrictModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("districtID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'districtID' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("districtID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'districtID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("districtID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'districtID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("districtName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtName' is required. Either set @Required to field 'districtName' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'DistrictModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_DistrictModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.DistrictModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.DistrictModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.DistrictModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("districtID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("districtID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.DistrictModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.DistrictModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("districtID")) {
                if (json.isNull("districtID")) {
                    obj = (io.realm.DistrictModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.DistrictModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.DistrictModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.DistrictModel.class, json.getString("districtID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'districtID'.");
            }
        }
        if (json.has("districtName")) {
            if (json.isNull("districtName")) {
                ((DistrictModelRealmProxyInterface) obj).realmSet$districtName(null);
            } else {
                ((DistrictModelRealmProxyInterface) obj).realmSet$districtName((String) json.getString("districtName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.DistrictModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.DistrictModel obj = new com.app.apsfl.models.DistrictModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("districtID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DistrictModelRealmProxyInterface) obj).realmSet$districtID(null);
                } else {
                    ((DistrictModelRealmProxyInterface) obj).realmSet$districtID((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("districtName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DistrictModelRealmProxyInterface) obj).realmSet$districtName(null);
                } else {
                    ((DistrictModelRealmProxyInterface) obj).realmSet$districtName((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'districtID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.DistrictModel copyOrUpdate(Realm realm, com.app.apsfl.models.DistrictModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.DistrictModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.DistrictModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.DistrictModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((DistrictModelRealmProxyInterface) object).realmGet$districtID();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.DistrictModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.DistrictModelRealmProxy();
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

    public static com.app.apsfl.models.DistrictModel copy(Realm realm, com.app.apsfl.models.DistrictModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.DistrictModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.DistrictModel realmObject = realm.createObjectInternal(com.app.apsfl.models.DistrictModel.class, ((DistrictModelRealmProxyInterface) newObject).realmGet$districtID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((DistrictModelRealmProxyInterface) realmObject).realmSet$districtName(((DistrictModelRealmProxyInterface) newObject).realmGet$districtName());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.DistrictModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.DistrictModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        DistrictModelColumnInfo columnInfo = (DistrictModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.DistrictModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((DistrictModelRealmProxyInterface) object).realmGet$districtID();
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
        String realmGet$districtName = ((DistrictModelRealmProxyInterface)object).realmGet$districtName();
        if (realmGet$districtName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.DistrictModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        DistrictModelColumnInfo columnInfo = (DistrictModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.DistrictModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.DistrictModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.DistrictModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((DistrictModelRealmProxyInterface) object).realmGet$districtID();
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
                String realmGet$districtName = ((DistrictModelRealmProxyInterface)object).realmGet$districtName();
                if (realmGet$districtName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.DistrictModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.DistrictModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        DistrictModelColumnInfo columnInfo = (DistrictModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.DistrictModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((DistrictModelRealmProxyInterface) object).realmGet$districtID();
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
        String realmGet$districtName = ((DistrictModelRealmProxyInterface)object).realmGet$districtName();
        if (realmGet$districtName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.districtNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.DistrictModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        DistrictModelColumnInfo columnInfo = (DistrictModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.DistrictModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.DistrictModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.DistrictModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((DistrictModelRealmProxyInterface) object).realmGet$districtID();
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
                String realmGet$districtName = ((DistrictModelRealmProxyInterface)object).realmGet$districtName();
                if (realmGet$districtName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.districtNameIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.DistrictModel createDetachedCopy(com.app.apsfl.models.DistrictModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.DistrictModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.DistrictModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.DistrictModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.DistrictModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((DistrictModelRealmProxyInterface) unmanagedObject).realmSet$districtID(((DistrictModelRealmProxyInterface) realmObject).realmGet$districtID());
        ((DistrictModelRealmProxyInterface) unmanagedObject).realmSet$districtName(((DistrictModelRealmProxyInterface) realmObject).realmGet$districtName());
        return unmanagedObject;
    }

    static com.app.apsfl.models.DistrictModel update(Realm realm, com.app.apsfl.models.DistrictModel realmObject, com.app.apsfl.models.DistrictModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((DistrictModelRealmProxyInterface) realmObject).realmSet$districtName(((DistrictModelRealmProxyInterface) newObject).realmGet$districtName());
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
        DistrictModelRealmProxy aDistrictModel = (DistrictModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDistrictModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDistrictModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDistrictModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
