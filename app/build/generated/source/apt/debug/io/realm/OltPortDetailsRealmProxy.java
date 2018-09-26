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

public class OltPortDetailsRealmProxy extends com.app.apsfl.models.OltPortDetails
    implements RealmObjectProxy, OltPortDetailsRealmProxyInterface {

    static final class OltPortDetailsColumnInfo extends ColumnInfo
        implements Cloneable {

        public long popIdPortNoIndex;
        public long portNoIndex;
        public long popIdIndex;

        OltPortDetailsColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(3);
            this.popIdPortNoIndex = getValidColumnIndex(path, table, "OltPortDetails", "popIdPortNo");
            indicesMap.put("popIdPortNo", this.popIdPortNoIndex);
            this.portNoIndex = getValidColumnIndex(path, table, "OltPortDetails", "portNo");
            indicesMap.put("portNo", this.portNoIndex);
            this.popIdIndex = getValidColumnIndex(path, table, "OltPortDetails", "popId");
            indicesMap.put("popId", this.popIdIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final OltPortDetailsColumnInfo otherInfo = (OltPortDetailsColumnInfo) other;
            this.popIdPortNoIndex = otherInfo.popIdPortNoIndex;
            this.portNoIndex = otherInfo.portNoIndex;
            this.popIdIndex = otherInfo.popIdIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final OltPortDetailsColumnInfo clone() {
            return (OltPortDetailsColumnInfo) super.clone();
        }

    }
    private OltPortDetailsColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("popIdPortNo");
        fieldNames.add("portNo");
        fieldNames.add("popId");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    OltPortDetailsRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OltPortDetailsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.OltPortDetails.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$popIdPortNo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popIdPortNoIndex);
    }

    public void realmSet$popIdPortNo(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'popIdPortNo' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$portNo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.portNoIndex);
    }

    public void realmSet$portNo(String value) {
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
                row.getTable().setNull(columnInfo.portNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.portNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.portNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.portNoIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popIdIndex);
    }

    public void realmSet$popId(String value) {
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
                row.getTable().setNull(columnInfo.popIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popIdIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("OltPortDetails")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("OltPortDetails");
            realmObjectSchema.add(new Property("popIdPortNo", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("portNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("OltPortDetails");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_OltPortDetails")) {
            Table table = sharedRealm.getTable("class_OltPortDetails");
            table.addColumn(RealmFieldType.STRING, "popIdPortNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "portNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popId", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("popIdPortNo"));
            table.setPrimaryKey("popIdPortNo");
            return table;
        }
        return sharedRealm.getTable("class_OltPortDetails");
    }

    public static OltPortDetailsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_OltPortDetails")) {
            Table table = sharedRealm.getTable("class_OltPortDetails");
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

            final OltPortDetailsColumnInfo columnInfo = new OltPortDetailsColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("popIdPortNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popIdPortNo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popIdPortNo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popIdPortNo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popIdPortNoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'popIdPortNo' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("popIdPortNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'popIdPortNo' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("popIdPortNo"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'popIdPortNo' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("portNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'portNo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("portNo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'portNo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.portNoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'portNo' is required. Either set @Required to field 'portNo' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popId' is required. Either set @Required to field 'popId' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'OltPortDetails' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_OltPortDetails";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.OltPortDetails createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.OltPortDetails obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.OltPortDetails.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("popIdPortNo")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("popIdPortNo"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.OltPortDetails.class), false, Collections.<String> emptyList());
                    obj = new io.realm.OltPortDetailsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("popIdPortNo")) {
                if (json.isNull("popIdPortNo")) {
                    obj = (io.realm.OltPortDetailsRealmProxy) realm.createObjectInternal(com.app.apsfl.models.OltPortDetails.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.OltPortDetailsRealmProxy) realm.createObjectInternal(com.app.apsfl.models.OltPortDetails.class, json.getString("popIdPortNo"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'popIdPortNo'.");
            }
        }
        if (json.has("portNo")) {
            if (json.isNull("portNo")) {
                ((OltPortDetailsRealmProxyInterface) obj).realmSet$portNo(null);
            } else {
                ((OltPortDetailsRealmProxyInterface) obj).realmSet$portNo((String) json.getString("portNo"));
            }
        }
        if (json.has("popId")) {
            if (json.isNull("popId")) {
                ((OltPortDetailsRealmProxyInterface) obj).realmSet$popId(null);
            } else {
                ((OltPortDetailsRealmProxyInterface) obj).realmSet$popId((String) json.getString("popId"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.OltPortDetails createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.OltPortDetails obj = new com.app.apsfl.models.OltPortDetails();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("popIdPortNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OltPortDetailsRealmProxyInterface) obj).realmSet$popIdPortNo(null);
                } else {
                    ((OltPortDetailsRealmProxyInterface) obj).realmSet$popIdPortNo((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("portNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OltPortDetailsRealmProxyInterface) obj).realmSet$portNo(null);
                } else {
                    ((OltPortDetailsRealmProxyInterface) obj).realmSet$portNo((String) reader.nextString());
                }
            } else if (name.equals("popId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OltPortDetailsRealmProxyInterface) obj).realmSet$popId(null);
                } else {
                    ((OltPortDetailsRealmProxyInterface) obj).realmSet$popId((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'popIdPortNo'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.OltPortDetails copyOrUpdate(Realm realm, com.app.apsfl.models.OltPortDetails object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.OltPortDetails) cachedRealmObject;
        } else {
            com.app.apsfl.models.OltPortDetails realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.OltPortDetails.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((OltPortDetailsRealmProxyInterface) object).realmGet$popIdPortNo();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.OltPortDetails.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.OltPortDetailsRealmProxy();
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

    public static com.app.apsfl.models.OltPortDetails copy(Realm realm, com.app.apsfl.models.OltPortDetails newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.OltPortDetails) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.OltPortDetails realmObject = realm.createObjectInternal(com.app.apsfl.models.OltPortDetails.class, ((OltPortDetailsRealmProxyInterface) newObject).realmGet$popIdPortNo(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((OltPortDetailsRealmProxyInterface) realmObject).realmSet$portNo(((OltPortDetailsRealmProxyInterface) newObject).realmGet$portNo());
            ((OltPortDetailsRealmProxyInterface) realmObject).realmSet$popId(((OltPortDetailsRealmProxyInterface) newObject).realmGet$popId());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.OltPortDetails object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.OltPortDetails.class);
        long tableNativePtr = table.getNativeTablePointer();
        OltPortDetailsColumnInfo columnInfo = (OltPortDetailsColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OltPortDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((OltPortDetailsRealmProxyInterface) object).realmGet$popIdPortNo();
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
        String realmGet$portNo = ((OltPortDetailsRealmProxyInterface)object).realmGet$portNo();
        if (realmGet$portNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.portNoIndex, rowIndex, realmGet$portNo, false);
        }
        String realmGet$popId = ((OltPortDetailsRealmProxyInterface)object).realmGet$popId();
        if (realmGet$popId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.OltPortDetails.class);
        long tableNativePtr = table.getNativeTablePointer();
        OltPortDetailsColumnInfo columnInfo = (OltPortDetailsColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OltPortDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.OltPortDetails object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.OltPortDetails) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((OltPortDetailsRealmProxyInterface) object).realmGet$popIdPortNo();
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
                String realmGet$portNo = ((OltPortDetailsRealmProxyInterface)object).realmGet$portNo();
                if (realmGet$portNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.portNoIndex, rowIndex, realmGet$portNo, false);
                }
                String realmGet$popId = ((OltPortDetailsRealmProxyInterface)object).realmGet$popId();
                if (realmGet$popId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.OltPortDetails object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.OltPortDetails.class);
        long tableNativePtr = table.getNativeTablePointer();
        OltPortDetailsColumnInfo columnInfo = (OltPortDetailsColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OltPortDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((OltPortDetailsRealmProxyInterface) object).realmGet$popIdPortNo();
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
        String realmGet$portNo = ((OltPortDetailsRealmProxyInterface)object).realmGet$portNo();
        if (realmGet$portNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.portNoIndex, rowIndex, realmGet$portNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.portNoIndex, rowIndex, false);
        }
        String realmGet$popId = ((OltPortDetailsRealmProxyInterface)object).realmGet$popId();
        if (realmGet$popId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popIdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.OltPortDetails.class);
        long tableNativePtr = table.getNativeTablePointer();
        OltPortDetailsColumnInfo columnInfo = (OltPortDetailsColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.OltPortDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.OltPortDetails object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.OltPortDetails) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((OltPortDetailsRealmProxyInterface) object).realmGet$popIdPortNo();
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
                String realmGet$portNo = ((OltPortDetailsRealmProxyInterface)object).realmGet$portNo();
                if (realmGet$portNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.portNoIndex, rowIndex, realmGet$portNo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.portNoIndex, rowIndex, false);
                }
                String realmGet$popId = ((OltPortDetailsRealmProxyInterface)object).realmGet$popId();
                if (realmGet$popId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popIdIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.OltPortDetails createDetachedCopy(com.app.apsfl.models.OltPortDetails realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.OltPortDetails unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.OltPortDetails)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.OltPortDetails)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.OltPortDetails();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((OltPortDetailsRealmProxyInterface) unmanagedObject).realmSet$popIdPortNo(((OltPortDetailsRealmProxyInterface) realmObject).realmGet$popIdPortNo());
        ((OltPortDetailsRealmProxyInterface) unmanagedObject).realmSet$portNo(((OltPortDetailsRealmProxyInterface) realmObject).realmGet$portNo());
        ((OltPortDetailsRealmProxyInterface) unmanagedObject).realmSet$popId(((OltPortDetailsRealmProxyInterface) realmObject).realmGet$popId());
        return unmanagedObject;
    }

    static com.app.apsfl.models.OltPortDetails update(Realm realm, com.app.apsfl.models.OltPortDetails realmObject, com.app.apsfl.models.OltPortDetails newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((OltPortDetailsRealmProxyInterface) realmObject).realmSet$portNo(((OltPortDetailsRealmProxyInterface) newObject).realmGet$portNo());
        ((OltPortDetailsRealmProxyInterface) realmObject).realmSet$popId(((OltPortDetailsRealmProxyInterface) newObject).realmGet$popId());
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
        OltPortDetailsRealmProxy aOltPortDetails = (OltPortDetailsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aOltPortDetails.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOltPortDetails.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aOltPortDetails.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
