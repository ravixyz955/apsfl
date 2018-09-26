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

public class L3PortModelRealmProxy extends com.app.apsfl.models.L3PortModel
    implements RealmObjectProxy, L3PortModelRealmProxyInterface {

    static final class L3PortModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long l1PortNumberIndex;
        public long l3PortNumbersIndex;

        L3PortModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.l1PortNumberIndex = getValidColumnIndex(path, table, "L3PortModel", "l1PortNumber");
            indicesMap.put("l1PortNumber", this.l1PortNumberIndex);
            this.l3PortNumbersIndex = getValidColumnIndex(path, table, "L3PortModel", "l3PortNumbers");
            indicesMap.put("l3PortNumbers", this.l3PortNumbersIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final L3PortModelColumnInfo otherInfo = (L3PortModelColumnInfo) other;
            this.l1PortNumberIndex = otherInfo.l1PortNumberIndex;
            this.l3PortNumbersIndex = otherInfo.l3PortNumbersIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final L3PortModelColumnInfo clone() {
            return (L3PortModelColumnInfo) super.clone();
        }

    }
    private L3PortModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("l1PortNumber");
        fieldNames.add("l3PortNumbers");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    L3PortModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (L3PortModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.L3PortModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$l1PortNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.l1PortNumberIndex);
    }

    public void realmSet$l1PortNumber(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'l1PortNumber' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$l3PortNumbers() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.l3PortNumbersIndex);
    }

    public void realmSet$l3PortNumbers(String value) {
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
                row.getTable().setNull(columnInfo.l3PortNumbersIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.l3PortNumbersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.l3PortNumbersIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.l3PortNumbersIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("L3PortModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("L3PortModel");
            realmObjectSchema.add(new Property("l1PortNumber", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("l3PortNumbers", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("L3PortModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_L3PortModel")) {
            Table table = sharedRealm.getTable("class_L3PortModel");
            table.addColumn(RealmFieldType.STRING, "l1PortNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "l3PortNumbers", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("l1PortNumber"));
            table.setPrimaryKey("l1PortNumber");
            return table;
        }
        return sharedRealm.getTable("class_L3PortModel");
    }

    public static L3PortModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_L3PortModel")) {
            Table table = sharedRealm.getTable("class_L3PortModel");
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

            final L3PortModelColumnInfo columnInfo = new L3PortModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("l1PortNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'l1PortNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("l1PortNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'l1PortNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.l1PortNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'l1PortNumber' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("l1PortNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'l1PortNumber' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("l1PortNumber"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'l1PortNumber' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("l3PortNumbers")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'l3PortNumbers' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("l3PortNumbers") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'l3PortNumbers' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.l3PortNumbersIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'l3PortNumbers' is required. Either set @Required to field 'l3PortNumbers' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'L3PortModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_L3PortModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.L3PortModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.L3PortModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.L3PortModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("l1PortNumber")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("l1PortNumber"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.L3PortModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.L3PortModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("l1PortNumber")) {
                if (json.isNull("l1PortNumber")) {
                    obj = (io.realm.L3PortModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.L3PortModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.L3PortModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.L3PortModel.class, json.getString("l1PortNumber"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'l1PortNumber'.");
            }
        }
        if (json.has("l3PortNumbers")) {
            if (json.isNull("l3PortNumbers")) {
                ((L3PortModelRealmProxyInterface) obj).realmSet$l3PortNumbers(null);
            } else {
                ((L3PortModelRealmProxyInterface) obj).realmSet$l3PortNumbers((String) json.getString("l3PortNumbers"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.L3PortModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.L3PortModel obj = new com.app.apsfl.models.L3PortModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("l1PortNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L3PortModelRealmProxyInterface) obj).realmSet$l1PortNumber(null);
                } else {
                    ((L3PortModelRealmProxyInterface) obj).realmSet$l1PortNumber((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("l3PortNumbers")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L3PortModelRealmProxyInterface) obj).realmSet$l3PortNumbers(null);
                } else {
                    ((L3PortModelRealmProxyInterface) obj).realmSet$l3PortNumbers((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'l1PortNumber'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.L3PortModel copyOrUpdate(Realm realm, com.app.apsfl.models.L3PortModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.L3PortModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.L3PortModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.L3PortModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((L3PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.L3PortModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.L3PortModelRealmProxy();
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

    public static com.app.apsfl.models.L3PortModel copy(Realm realm, com.app.apsfl.models.L3PortModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.L3PortModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.L3PortModel realmObject = realm.createObjectInternal(com.app.apsfl.models.L3PortModel.class, ((L3PortModelRealmProxyInterface) newObject).realmGet$l1PortNumber(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((L3PortModelRealmProxyInterface) realmObject).realmSet$l3PortNumbers(((L3PortModelRealmProxyInterface) newObject).realmGet$l3PortNumbers());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.L3PortModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.L3PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L3PortModelColumnInfo columnInfo = (L3PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L3PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((L3PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
        String realmGet$l3PortNumbers = ((L3PortModelRealmProxyInterface)object).realmGet$l3PortNumbers();
        if (realmGet$l3PortNumbers != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumbersIndex, rowIndex, realmGet$l3PortNumbers, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.L3PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L3PortModelColumnInfo columnInfo = (L3PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L3PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.L3PortModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.L3PortModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((L3PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
                String realmGet$l3PortNumbers = ((L3PortModelRealmProxyInterface)object).realmGet$l3PortNumbers();
                if (realmGet$l3PortNumbers != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumbersIndex, rowIndex, realmGet$l3PortNumbers, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.L3PortModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.L3PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L3PortModelColumnInfo columnInfo = (L3PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L3PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((L3PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
        String realmGet$l3PortNumbers = ((L3PortModelRealmProxyInterface)object).realmGet$l3PortNumbers();
        if (realmGet$l3PortNumbers != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumbersIndex, rowIndex, realmGet$l3PortNumbers, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.l3PortNumbersIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.L3PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L3PortModelColumnInfo columnInfo = (L3PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L3PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.L3PortModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.L3PortModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((L3PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
                String realmGet$l3PortNumbers = ((L3PortModelRealmProxyInterface)object).realmGet$l3PortNumbers();
                if (realmGet$l3PortNumbers != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l3PortNumbersIndex, rowIndex, realmGet$l3PortNumbers, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.l3PortNumbersIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.L3PortModel createDetachedCopy(com.app.apsfl.models.L3PortModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.L3PortModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.L3PortModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.L3PortModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.L3PortModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((L3PortModelRealmProxyInterface) unmanagedObject).realmSet$l1PortNumber(((L3PortModelRealmProxyInterface) realmObject).realmGet$l1PortNumber());
        ((L3PortModelRealmProxyInterface) unmanagedObject).realmSet$l3PortNumbers(((L3PortModelRealmProxyInterface) realmObject).realmGet$l3PortNumbers());
        return unmanagedObject;
    }

    static com.app.apsfl.models.L3PortModel update(Realm realm, com.app.apsfl.models.L3PortModel realmObject, com.app.apsfl.models.L3PortModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((L3PortModelRealmProxyInterface) realmObject).realmSet$l3PortNumbers(((L3PortModelRealmProxyInterface) newObject).realmGet$l3PortNumbers());
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
        L3PortModelRealmProxy aL3PortModel = (L3PortModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aL3PortModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aL3PortModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aL3PortModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
