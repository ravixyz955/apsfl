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

public class CPEStockModelRealmProxy extends com.app.apsfl.models.CPEStockModel
    implements RealmObjectProxy, CPEStockModelRealmProxyInterface {

    static final class CPEStockModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long cpeSerialNumberIndex;
        public long cpeProfileIDIndex;
        public long cpeMacIdIndex;

        CPEStockModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(3);
            this.cpeSerialNumberIndex = getValidColumnIndex(path, table, "CPEStockModel", "cpeSerialNumber");
            indicesMap.put("cpeSerialNumber", this.cpeSerialNumberIndex);
            this.cpeProfileIDIndex = getValidColumnIndex(path, table, "CPEStockModel", "cpeProfileID");
            indicesMap.put("cpeProfileID", this.cpeProfileIDIndex);
            this.cpeMacIdIndex = getValidColumnIndex(path, table, "CPEStockModel", "cpeMacId");
            indicesMap.put("cpeMacId", this.cpeMacIdIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CPEStockModelColumnInfo otherInfo = (CPEStockModelColumnInfo) other;
            this.cpeSerialNumberIndex = otherInfo.cpeSerialNumberIndex;
            this.cpeProfileIDIndex = otherInfo.cpeProfileIDIndex;
            this.cpeMacIdIndex = otherInfo.cpeMacIdIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CPEStockModelColumnInfo clone() {
            return (CPEStockModelColumnInfo) super.clone();
        }

    }
    private CPEStockModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("cpeSerialNumber");
        fieldNames.add("cpeProfileID");
        fieldNames.add("cpeMacId");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CPEStockModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CPEStockModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.CPEStockModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$cpeSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeSerialNumberIndex);
    }

    public void realmSet$cpeSerialNumber(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'cpeSerialNumber' cannot be changed after object was created.");
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
    public String realmGet$cpeMacId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cpeMacIdIndex);
    }

    public void realmSet$cpeMacId(String value) {
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
                row.getTable().setNull(columnInfo.cpeMacIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cpeMacIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cpeMacIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cpeMacIdIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CPEStockModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CPEStockModel");
            realmObjectSchema.add(new Property("cpeSerialNumber", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeProfileID", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cpeMacId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CPEStockModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CPEStockModel")) {
            Table table = sharedRealm.getTable("class_CPEStockModel");
            table.addColumn(RealmFieldType.STRING, "cpeSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cpeProfileID", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cpeMacId", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("cpeSerialNumber"));
            table.setPrimaryKey("cpeSerialNumber");
            return table;
        }
        return sharedRealm.getTable("class_CPEStockModel");
    }

    public static CPEStockModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CPEStockModel")) {
            Table table = sharedRealm.getTable("class_CPEStockModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 3) {
                if (columnCount < 3) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CPEStockModelColumnInfo columnInfo = new CPEStockModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("cpeSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'cpeSerialNumber' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("cpeSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'cpeSerialNumber' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("cpeSerialNumber"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'cpeSerialNumber' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            if (!columnTypes.containsKey("cpeMacId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cpeMacId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cpeMacId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cpeMacId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cpeMacIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cpeMacId' is required. Either set @Required to field 'cpeMacId' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CPEStockModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CPEStockModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.CPEStockModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.CPEStockModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.CPEStockModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("cpeSerialNumber")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("cpeSerialNumber"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CPEStockModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CPEStockModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("cpeSerialNumber")) {
                if (json.isNull("cpeSerialNumber")) {
                    obj = (io.realm.CPEStockModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CPEStockModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CPEStockModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.CPEStockModel.class, json.getString("cpeSerialNumber"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'cpeSerialNumber'.");
            }
        }
        if (json.has("cpeProfileID")) {
            if (json.isNull("cpeProfileID")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cpeProfileID' to null.");
            } else {
                ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeProfileID((int) json.getInt("cpeProfileID"));
            }
        }
        if (json.has("cpeMacId")) {
            if (json.isNull("cpeMacId")) {
                ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeMacId(null);
            } else {
                ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeMacId((String) json.getString("cpeMacId"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.CPEStockModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.CPEStockModel obj = new com.app.apsfl.models.CPEStockModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("cpeSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeSerialNumber(null);
                } else {
                    ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeSerialNumber((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("cpeProfileID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cpeProfileID' to null.");
                } else {
                    ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeProfileID((int) reader.nextInt());
                }
            } else if (name.equals("cpeMacId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeMacId(null);
                } else {
                    ((CPEStockModelRealmProxyInterface) obj).realmSet$cpeMacId((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'cpeSerialNumber'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.CPEStockModel copyOrUpdate(Realm realm, com.app.apsfl.models.CPEStockModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CPEStockModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.CPEStockModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.CPEStockModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((CPEStockModelRealmProxyInterface) object).realmGet$cpeSerialNumber();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.CPEStockModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CPEStockModelRealmProxy();
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

    public static com.app.apsfl.models.CPEStockModel copy(Realm realm, com.app.apsfl.models.CPEStockModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.CPEStockModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.CPEStockModel realmObject = realm.createObjectInternal(com.app.apsfl.models.CPEStockModel.class, ((CPEStockModelRealmProxyInterface) newObject).realmGet$cpeSerialNumber(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CPEStockModelRealmProxyInterface) realmObject).realmSet$cpeProfileID(((CPEStockModelRealmProxyInterface) newObject).realmGet$cpeProfileID());
            ((CPEStockModelRealmProxyInterface) realmObject).realmSet$cpeMacId(((CPEStockModelRealmProxyInterface) newObject).realmGet$cpeMacId());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.CPEStockModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CPEStockModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEStockModelColumnInfo columnInfo = (CPEStockModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEStockModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((CPEStockModelRealmProxyInterface) object).realmGet$cpeSerialNumber();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEStockModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
        String realmGet$cpeMacId = ((CPEStockModelRealmProxyInterface)object).realmGet$cpeMacId();
        if (realmGet$cpeMacId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeMacIdIndex, rowIndex, realmGet$cpeMacId, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CPEStockModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEStockModelColumnInfo columnInfo = (CPEStockModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEStockModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CPEStockModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CPEStockModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((CPEStockModelRealmProxyInterface) object).realmGet$cpeSerialNumber();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEStockModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
                String realmGet$cpeMacId = ((CPEStockModelRealmProxyInterface)object).realmGet$cpeMacId();
                if (realmGet$cpeMacId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeMacIdIndex, rowIndex, realmGet$cpeMacId, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.CPEStockModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.CPEStockModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEStockModelColumnInfo columnInfo = (CPEStockModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEStockModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((CPEStockModelRealmProxyInterface) object).realmGet$cpeSerialNumber();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEStockModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
        String realmGet$cpeMacId = ((CPEStockModelRealmProxyInterface)object).realmGet$cpeMacId();
        if (realmGet$cpeMacId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cpeMacIdIndex, rowIndex, realmGet$cpeMacId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cpeMacIdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.CPEStockModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        CPEStockModelColumnInfo columnInfo = (CPEStockModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.CPEStockModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.CPEStockModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.CPEStockModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((CPEStockModelRealmProxyInterface) object).realmGet$cpeSerialNumber();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.cpeProfileIDIndex, rowIndex, ((CPEStockModelRealmProxyInterface)object).realmGet$cpeProfileID(), false);
                String realmGet$cpeMacId = ((CPEStockModelRealmProxyInterface)object).realmGet$cpeMacId();
                if (realmGet$cpeMacId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cpeMacIdIndex, rowIndex, realmGet$cpeMacId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cpeMacIdIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.CPEStockModel createDetachedCopy(com.app.apsfl.models.CPEStockModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.CPEStockModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.CPEStockModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.CPEStockModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.CPEStockModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CPEStockModelRealmProxyInterface) unmanagedObject).realmSet$cpeSerialNumber(((CPEStockModelRealmProxyInterface) realmObject).realmGet$cpeSerialNumber());
        ((CPEStockModelRealmProxyInterface) unmanagedObject).realmSet$cpeProfileID(((CPEStockModelRealmProxyInterface) realmObject).realmGet$cpeProfileID());
        ((CPEStockModelRealmProxyInterface) unmanagedObject).realmSet$cpeMacId(((CPEStockModelRealmProxyInterface) realmObject).realmGet$cpeMacId());
        return unmanagedObject;
    }

    static com.app.apsfl.models.CPEStockModel update(Realm realm, com.app.apsfl.models.CPEStockModel realmObject, com.app.apsfl.models.CPEStockModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CPEStockModelRealmProxyInterface) realmObject).realmSet$cpeProfileID(((CPEStockModelRealmProxyInterface) newObject).realmGet$cpeProfileID());
        ((CPEStockModelRealmProxyInterface) realmObject).realmSet$cpeMacId(((CPEStockModelRealmProxyInterface) newObject).realmGet$cpeMacId());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CPEStockModel = [");
        stringBuilder.append("{cpeSerialNumber:");
        stringBuilder.append(realmGet$cpeSerialNumber() != null ? realmGet$cpeSerialNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cpeProfileID:");
        stringBuilder.append(realmGet$cpeProfileID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cpeMacId:");
        stringBuilder.append(realmGet$cpeMacId() != null ? realmGet$cpeMacId() : "null");
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
        CPEStockModelRealmProxy aCPEStockModel = (CPEStockModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCPEStockModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCPEStockModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCPEStockModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
