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

public class L2PortModelRealmProxy extends com.app.apsfl.models.L2PortModel
    implements RealmObjectProxy, L2PortModelRealmProxyInterface {

    static final class L2PortModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long l1PortNumberIndex;
        public long l2PortNumbersIndex;

        L2PortModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.l1PortNumberIndex = getValidColumnIndex(path, table, "L2PortModel", "l1PortNumber");
            indicesMap.put("l1PortNumber", this.l1PortNumberIndex);
            this.l2PortNumbersIndex = getValidColumnIndex(path, table, "L2PortModel", "l2PortNumbers");
            indicesMap.put("l2PortNumbers", this.l2PortNumbersIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final L2PortModelColumnInfo otherInfo = (L2PortModelColumnInfo) other;
            this.l1PortNumberIndex = otherInfo.l1PortNumberIndex;
            this.l2PortNumbersIndex = otherInfo.l2PortNumbersIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final L2PortModelColumnInfo clone() {
            return (L2PortModelColumnInfo) super.clone();
        }

    }
    private L2PortModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("l1PortNumber");
        fieldNames.add("l2PortNumbers");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    L2PortModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (L2PortModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.L2PortModel.class, this);
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
    public String realmGet$l2PortNumbers() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.l2PortNumbersIndex);
    }

    public void realmSet$l2PortNumbers(String value) {
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
                row.getTable().setNull(columnInfo.l2PortNumbersIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.l2PortNumbersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.l2PortNumbersIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.l2PortNumbersIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("L2PortModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("L2PortModel");
            realmObjectSchema.add(new Property("l1PortNumber", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("l2PortNumbers", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("L2PortModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_L2PortModel")) {
            Table table = sharedRealm.getTable("class_L2PortModel");
            table.addColumn(RealmFieldType.STRING, "l1PortNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "l2PortNumbers", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("l1PortNumber"));
            table.setPrimaryKey("l1PortNumber");
            return table;
        }
        return sharedRealm.getTable("class_L2PortModel");
    }

    public static L2PortModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_L2PortModel")) {
            Table table = sharedRealm.getTable("class_L2PortModel");
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

            final L2PortModelColumnInfo columnInfo = new L2PortModelColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("l2PortNumbers")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'l2PortNumbers' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("l2PortNumbers") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'l2PortNumbers' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.l2PortNumbersIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'l2PortNumbers' is required. Either set @Required to field 'l2PortNumbers' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'L2PortModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_L2PortModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.L2PortModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.L2PortModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.L2PortModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.L2PortModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.L2PortModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("l1PortNumber")) {
                if (json.isNull("l1PortNumber")) {
                    obj = (io.realm.L2PortModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.L2PortModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.L2PortModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.L2PortModel.class, json.getString("l1PortNumber"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'l1PortNumber'.");
            }
        }
        if (json.has("l2PortNumbers")) {
            if (json.isNull("l2PortNumbers")) {
                ((L2PortModelRealmProxyInterface) obj).realmSet$l2PortNumbers(null);
            } else {
                ((L2PortModelRealmProxyInterface) obj).realmSet$l2PortNumbers((String) json.getString("l2PortNumbers"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.L2PortModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.L2PortModel obj = new com.app.apsfl.models.L2PortModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("l1PortNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L2PortModelRealmProxyInterface) obj).realmSet$l1PortNumber(null);
                } else {
                    ((L2PortModelRealmProxyInterface) obj).realmSet$l1PortNumber((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("l2PortNumbers")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L2PortModelRealmProxyInterface) obj).realmSet$l2PortNumbers(null);
                } else {
                    ((L2PortModelRealmProxyInterface) obj).realmSet$l2PortNumbers((String) reader.nextString());
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

    public static com.app.apsfl.models.L2PortModel copyOrUpdate(Realm realm, com.app.apsfl.models.L2PortModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.L2PortModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.L2PortModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.L2PortModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((L2PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.L2PortModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.L2PortModelRealmProxy();
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

    public static com.app.apsfl.models.L2PortModel copy(Realm realm, com.app.apsfl.models.L2PortModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.L2PortModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.L2PortModel realmObject = realm.createObjectInternal(com.app.apsfl.models.L2PortModel.class, ((L2PortModelRealmProxyInterface) newObject).realmGet$l1PortNumber(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((L2PortModelRealmProxyInterface) realmObject).realmSet$l2PortNumbers(((L2PortModelRealmProxyInterface) newObject).realmGet$l2PortNumbers());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.L2PortModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.L2PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L2PortModelColumnInfo columnInfo = (L2PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L2PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((L2PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
        String realmGet$l2PortNumbers = ((L2PortModelRealmProxyInterface)object).realmGet$l2PortNumbers();
        if (realmGet$l2PortNumbers != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumbersIndex, rowIndex, realmGet$l2PortNumbers, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.L2PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L2PortModelColumnInfo columnInfo = (L2PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L2PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.L2PortModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.L2PortModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((L2PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
                String realmGet$l2PortNumbers = ((L2PortModelRealmProxyInterface)object).realmGet$l2PortNumbers();
                if (realmGet$l2PortNumbers != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumbersIndex, rowIndex, realmGet$l2PortNumbers, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.L2PortModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.L2PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L2PortModelColumnInfo columnInfo = (L2PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L2PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((L2PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
        String realmGet$l2PortNumbers = ((L2PortModelRealmProxyInterface)object).realmGet$l2PortNumbers();
        if (realmGet$l2PortNumbers != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumbersIndex, rowIndex, realmGet$l2PortNumbers, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.l2PortNumbersIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.L2PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L2PortModelColumnInfo columnInfo = (L2PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L2PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.L2PortModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.L2PortModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((L2PortModelRealmProxyInterface) object).realmGet$l1PortNumber();
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
                String realmGet$l2PortNumbers = ((L2PortModelRealmProxyInterface)object).realmGet$l2PortNumbers();
                if (realmGet$l2PortNumbers != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l2PortNumbersIndex, rowIndex, realmGet$l2PortNumbers, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.l2PortNumbersIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.L2PortModel createDetachedCopy(com.app.apsfl.models.L2PortModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.L2PortModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.L2PortModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.L2PortModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.L2PortModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((L2PortModelRealmProxyInterface) unmanagedObject).realmSet$l1PortNumber(((L2PortModelRealmProxyInterface) realmObject).realmGet$l1PortNumber());
        ((L2PortModelRealmProxyInterface) unmanagedObject).realmSet$l2PortNumbers(((L2PortModelRealmProxyInterface) realmObject).realmGet$l2PortNumbers());
        return unmanagedObject;
    }

    static com.app.apsfl.models.L2PortModel update(Realm realm, com.app.apsfl.models.L2PortModel realmObject, com.app.apsfl.models.L2PortModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((L2PortModelRealmProxyInterface) realmObject).realmSet$l2PortNumbers(((L2PortModelRealmProxyInterface) newObject).realmGet$l2PortNumbers());
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
        L2PortModelRealmProxy aL2PortModel = (L2PortModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aL2PortModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aL2PortModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aL2PortModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
