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

public class ChargeTaxModelRealmProxy extends com.app.apsfl.models.ChargeTaxModel
    implements RealmObjectProxy, ChargeTaxModelRealmProxyInterface {

    static final class ChargeTaxModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long chargeCodeIndex;
        public long taxCodeIndex;

        ChargeTaxModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.chargeCodeIndex = getValidColumnIndex(path, table, "ChargeTaxModel", "chargeCode");
            indicesMap.put("chargeCode", this.chargeCodeIndex);
            this.taxCodeIndex = getValidColumnIndex(path, table, "ChargeTaxModel", "taxCode");
            indicesMap.put("taxCode", this.taxCodeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ChargeTaxModelColumnInfo otherInfo = (ChargeTaxModelColumnInfo) other;
            this.chargeCodeIndex = otherInfo.chargeCodeIndex;
            this.taxCodeIndex = otherInfo.taxCodeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ChargeTaxModelColumnInfo clone() {
            return (ChargeTaxModelColumnInfo) super.clone();
        }

    }
    private ChargeTaxModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("chargeCode");
        fieldNames.add("taxCode");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ChargeTaxModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChargeTaxModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.ChargeTaxModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$chargeCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.chargeCodeIndex);
    }

    public void realmSet$chargeCode(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'chargeCode' cannot be changed after object was created.");
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ChargeTaxModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ChargeTaxModel");
            realmObjectSchema.add(new Property("chargeCode", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("taxCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("ChargeTaxModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_ChargeTaxModel")) {
            Table table = sharedRealm.getTable("class_ChargeTaxModel");
            table.addColumn(RealmFieldType.STRING, "chargeCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "taxCode", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("chargeCode"));
            table.setPrimaryKey("chargeCode");
            return table;
        }
        return sharedRealm.getTable("class_ChargeTaxModel");
    }

    public static ChargeTaxModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_ChargeTaxModel")) {
            Table table = sharedRealm.getTable("class_ChargeTaxModel");
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

            final ChargeTaxModelColumnInfo columnInfo = new ChargeTaxModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("chargeCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'chargeCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("chargeCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'chargeCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.chargeCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'chargeCode' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("chargeCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'chargeCode' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("chargeCode"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'chargeCode' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ChargeTaxModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ChargeTaxModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.ChargeTaxModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.ChargeTaxModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.ChargeTaxModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("chargeCode")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("chargeCode"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.ChargeTaxModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ChargeTaxModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("chargeCode")) {
                if (json.isNull("chargeCode")) {
                    obj = (io.realm.ChargeTaxModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.ChargeTaxModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ChargeTaxModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.ChargeTaxModel.class, json.getString("chargeCode"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'chargeCode'.");
            }
        }
        if (json.has("taxCode")) {
            if (json.isNull("taxCode")) {
                ((ChargeTaxModelRealmProxyInterface) obj).realmSet$taxCode(null);
            } else {
                ((ChargeTaxModelRealmProxyInterface) obj).realmSet$taxCode((String) json.getString("taxCode"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.ChargeTaxModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.ChargeTaxModel obj = new com.app.apsfl.models.ChargeTaxModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("chargeCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ChargeTaxModelRealmProxyInterface) obj).realmSet$chargeCode(null);
                } else {
                    ((ChargeTaxModelRealmProxyInterface) obj).realmSet$chargeCode((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("taxCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ChargeTaxModelRealmProxyInterface) obj).realmSet$taxCode(null);
                } else {
                    ((ChargeTaxModelRealmProxyInterface) obj).realmSet$taxCode((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'chargeCode'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.ChargeTaxModel copyOrUpdate(Realm realm, com.app.apsfl.models.ChargeTaxModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.ChargeTaxModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.ChargeTaxModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.ChargeTaxModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((ChargeTaxModelRealmProxyInterface) object).realmGet$chargeCode();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.ChargeTaxModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ChargeTaxModelRealmProxy();
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

    public static com.app.apsfl.models.ChargeTaxModel copy(Realm realm, com.app.apsfl.models.ChargeTaxModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.ChargeTaxModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.ChargeTaxModel realmObject = realm.createObjectInternal(com.app.apsfl.models.ChargeTaxModel.class, ((ChargeTaxModelRealmProxyInterface) newObject).realmGet$chargeCode(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ChargeTaxModelRealmProxyInterface) realmObject).realmSet$taxCode(((ChargeTaxModelRealmProxyInterface) newObject).realmGet$taxCode());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.ChargeTaxModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.ChargeTaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ChargeTaxModelColumnInfo columnInfo = (ChargeTaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ChargeTaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ChargeTaxModelRealmProxyInterface) object).realmGet$chargeCode();
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
        String realmGet$taxCode = ((ChargeTaxModelRealmProxyInterface)object).realmGet$taxCode();
        if (realmGet$taxCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.ChargeTaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ChargeTaxModelColumnInfo columnInfo = (ChargeTaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ChargeTaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.ChargeTaxModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.ChargeTaxModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ChargeTaxModelRealmProxyInterface) object).realmGet$chargeCode();
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
                String realmGet$taxCode = ((ChargeTaxModelRealmProxyInterface)object).realmGet$taxCode();
                if (realmGet$taxCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.ChargeTaxModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.ChargeTaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ChargeTaxModelColumnInfo columnInfo = (ChargeTaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ChargeTaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ChargeTaxModelRealmProxyInterface) object).realmGet$chargeCode();
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
        String realmGet$taxCode = ((ChargeTaxModelRealmProxyInterface)object).realmGet$taxCode();
        if (realmGet$taxCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.ChargeTaxModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ChargeTaxModelColumnInfo columnInfo = (ChargeTaxModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ChargeTaxModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.ChargeTaxModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.ChargeTaxModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ChargeTaxModelRealmProxyInterface) object).realmGet$chargeCode();
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
                String realmGet$taxCode = ((ChargeTaxModelRealmProxyInterface)object).realmGet$taxCode();
                if (realmGet$taxCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, realmGet$taxCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.taxCodeIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.ChargeTaxModel createDetachedCopy(com.app.apsfl.models.ChargeTaxModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.ChargeTaxModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.ChargeTaxModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.ChargeTaxModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.ChargeTaxModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((ChargeTaxModelRealmProxyInterface) unmanagedObject).realmSet$chargeCode(((ChargeTaxModelRealmProxyInterface) realmObject).realmGet$chargeCode());
        ((ChargeTaxModelRealmProxyInterface) unmanagedObject).realmSet$taxCode(((ChargeTaxModelRealmProxyInterface) realmObject).realmGet$taxCode());
        return unmanagedObject;
    }

    static com.app.apsfl.models.ChargeTaxModel update(Realm realm, com.app.apsfl.models.ChargeTaxModel realmObject, com.app.apsfl.models.ChargeTaxModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ChargeTaxModelRealmProxyInterface) realmObject).realmSet$taxCode(((ChargeTaxModelRealmProxyInterface) newObject).realmGet$taxCode());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ChargeTaxModel = [");
        stringBuilder.append("{chargeCode:");
        stringBuilder.append(realmGet$chargeCode() != null ? realmGet$chargeCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{taxCode:");
        stringBuilder.append(realmGet$taxCode() != null ? realmGet$taxCode() : "null");
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
        ChargeTaxModelRealmProxy aChargeTaxModel = (ChargeTaxModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aChargeTaxModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChargeTaxModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aChargeTaxModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
