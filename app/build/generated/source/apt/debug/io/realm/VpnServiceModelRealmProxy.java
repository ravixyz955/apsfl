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

public class VpnServiceModelRealmProxy extends com.app.apsfl.models.VpnServiceModel
    implements RealmObjectProxy, VpnServiceModelRealmProxyInterface {

    static final class VpnServiceModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long VpnCompositeKeyIndex;
        public long substnUidIndex;
        public long oltSerialNoIndex;
        public long vpnsrvcNameIndex;

        VpnServiceModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.VpnCompositeKeyIndex = getValidColumnIndex(path, table, "VpnServiceModel", "VpnCompositeKey");
            indicesMap.put("VpnCompositeKey", this.VpnCompositeKeyIndex);
            this.substnUidIndex = getValidColumnIndex(path, table, "VpnServiceModel", "substnUid");
            indicesMap.put("substnUid", this.substnUidIndex);
            this.oltSerialNoIndex = getValidColumnIndex(path, table, "VpnServiceModel", "oltSerialNo");
            indicesMap.put("oltSerialNo", this.oltSerialNoIndex);
            this.vpnsrvcNameIndex = getValidColumnIndex(path, table, "VpnServiceModel", "vpnsrvcName");
            indicesMap.put("vpnsrvcName", this.vpnsrvcNameIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final VpnServiceModelColumnInfo otherInfo = (VpnServiceModelColumnInfo) other;
            this.VpnCompositeKeyIndex = otherInfo.VpnCompositeKeyIndex;
            this.substnUidIndex = otherInfo.substnUidIndex;
            this.oltSerialNoIndex = otherInfo.oltSerialNoIndex;
            this.vpnsrvcNameIndex = otherInfo.vpnsrvcNameIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final VpnServiceModelColumnInfo clone() {
            return (VpnServiceModelColumnInfo) super.clone();
        }

    }
    private VpnServiceModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("VpnCompositeKey");
        fieldNames.add("substnUid");
        fieldNames.add("oltSerialNo");
        fieldNames.add("vpnsrvcName");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    VpnServiceModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VpnServiceModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.VpnServiceModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$VpnCompositeKey() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VpnCompositeKeyIndex);
    }

    public void realmSet$VpnCompositeKey(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'VpnCompositeKey' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$substnUid() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.substnUidIndex);
    }

    public void realmSet$substnUid(String value) {
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
                row.getTable().setNull(columnInfo.substnUidIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.substnUidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.substnUidIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.substnUidIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$oltSerialNo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.oltSerialNoIndex);
    }

    public void realmSet$oltSerialNo(String value) {
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
                row.getTable().setNull(columnInfo.oltSerialNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.oltSerialNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.oltSerialNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.oltSerialNoIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$vpnsrvcName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.vpnsrvcNameIndex);
    }

    public void realmSet$vpnsrvcName(String value) {
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
                row.getTable().setNull(columnInfo.vpnsrvcNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.vpnsrvcNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.vpnsrvcNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.vpnsrvcNameIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("VpnServiceModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("VpnServiceModel");
            realmObjectSchema.add(new Property("VpnCompositeKey", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("substnUid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("oltSerialNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("vpnsrvcName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("VpnServiceModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_VpnServiceModel")) {
            Table table = sharedRealm.getTable("class_VpnServiceModel");
            table.addColumn(RealmFieldType.STRING, "VpnCompositeKey", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "substnUid", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "oltSerialNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "vpnsrvcName", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("VpnCompositeKey"));
            table.setPrimaryKey("VpnCompositeKey");
            return table;
        }
        return sharedRealm.getTable("class_VpnServiceModel");
    }

    public static VpnServiceModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_VpnServiceModel")) {
            Table table = sharedRealm.getTable("class_VpnServiceModel");
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

            final VpnServiceModelColumnInfo columnInfo = new VpnServiceModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("VpnCompositeKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'VpnCompositeKey' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("VpnCompositeKey") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'VpnCompositeKey' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.VpnCompositeKeyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'VpnCompositeKey' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("VpnCompositeKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'VpnCompositeKey' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("VpnCompositeKey"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'VpnCompositeKey' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("substnUid")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'substnUid' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("substnUid") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'substnUid' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.substnUidIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'substnUid' is required. Either set @Required to field 'substnUid' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("oltSerialNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'oltSerialNo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("oltSerialNo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'oltSerialNo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.oltSerialNoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'oltSerialNo' is required. Either set @Required to field 'oltSerialNo' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("vpnsrvcName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'vpnsrvcName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("vpnsrvcName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'vpnsrvcName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.vpnsrvcNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'vpnsrvcName' is required. Either set @Required to field 'vpnsrvcName' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'VpnServiceModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_VpnServiceModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.VpnServiceModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.VpnServiceModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.VpnServiceModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("VpnCompositeKey")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("VpnCompositeKey"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.VpnServiceModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.VpnServiceModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("VpnCompositeKey")) {
                if (json.isNull("VpnCompositeKey")) {
                    obj = (io.realm.VpnServiceModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.VpnServiceModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.VpnServiceModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.VpnServiceModel.class, json.getString("VpnCompositeKey"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'VpnCompositeKey'.");
            }
        }
        if (json.has("substnUid")) {
            if (json.isNull("substnUid")) {
                ((VpnServiceModelRealmProxyInterface) obj).realmSet$substnUid(null);
            } else {
                ((VpnServiceModelRealmProxyInterface) obj).realmSet$substnUid((String) json.getString("substnUid"));
            }
        }
        if (json.has("oltSerialNo")) {
            if (json.isNull("oltSerialNo")) {
                ((VpnServiceModelRealmProxyInterface) obj).realmSet$oltSerialNo(null);
            } else {
                ((VpnServiceModelRealmProxyInterface) obj).realmSet$oltSerialNo((String) json.getString("oltSerialNo"));
            }
        }
        if (json.has("vpnsrvcName")) {
            if (json.isNull("vpnsrvcName")) {
                ((VpnServiceModelRealmProxyInterface) obj).realmSet$vpnsrvcName(null);
            } else {
                ((VpnServiceModelRealmProxyInterface) obj).realmSet$vpnsrvcName((String) json.getString("vpnsrvcName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.VpnServiceModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.VpnServiceModel obj = new com.app.apsfl.models.VpnServiceModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("VpnCompositeKey")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$VpnCompositeKey(null);
                } else {
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$VpnCompositeKey((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("substnUid")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$substnUid(null);
                } else {
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$substnUid((String) reader.nextString());
                }
            } else if (name.equals("oltSerialNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$oltSerialNo(null);
                } else {
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$oltSerialNo((String) reader.nextString());
                }
            } else if (name.equals("vpnsrvcName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$vpnsrvcName(null);
                } else {
                    ((VpnServiceModelRealmProxyInterface) obj).realmSet$vpnsrvcName((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'VpnCompositeKey'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.VpnServiceModel copyOrUpdate(Realm realm, com.app.apsfl.models.VpnServiceModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.VpnServiceModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.VpnServiceModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.VpnServiceModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((VpnServiceModelRealmProxyInterface) object).realmGet$VpnCompositeKey();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.VpnServiceModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.VpnServiceModelRealmProxy();
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

    public static com.app.apsfl.models.VpnServiceModel copy(Realm realm, com.app.apsfl.models.VpnServiceModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.VpnServiceModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.VpnServiceModel realmObject = realm.createObjectInternal(com.app.apsfl.models.VpnServiceModel.class, ((VpnServiceModelRealmProxyInterface) newObject).realmGet$VpnCompositeKey(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((VpnServiceModelRealmProxyInterface) realmObject).realmSet$substnUid(((VpnServiceModelRealmProxyInterface) newObject).realmGet$substnUid());
            ((VpnServiceModelRealmProxyInterface) realmObject).realmSet$oltSerialNo(((VpnServiceModelRealmProxyInterface) newObject).realmGet$oltSerialNo());
            ((VpnServiceModelRealmProxyInterface) realmObject).realmSet$vpnsrvcName(((VpnServiceModelRealmProxyInterface) newObject).realmGet$vpnsrvcName());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.VpnServiceModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.VpnServiceModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VpnServiceModelColumnInfo columnInfo = (VpnServiceModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VpnServiceModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((VpnServiceModelRealmProxyInterface) object).realmGet$VpnCompositeKey();
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
        String realmGet$substnUid = ((VpnServiceModelRealmProxyInterface)object).realmGet$substnUid();
        if (realmGet$substnUid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.substnUidIndex, rowIndex, realmGet$substnUid, false);
        }
        String realmGet$oltSerialNo = ((VpnServiceModelRealmProxyInterface)object).realmGet$oltSerialNo();
        if (realmGet$oltSerialNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.oltSerialNoIndex, rowIndex, realmGet$oltSerialNo, false);
        }
        String realmGet$vpnsrvcName = ((VpnServiceModelRealmProxyInterface)object).realmGet$vpnsrvcName();
        if (realmGet$vpnsrvcName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vpnsrvcNameIndex, rowIndex, realmGet$vpnsrvcName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.VpnServiceModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VpnServiceModelColumnInfo columnInfo = (VpnServiceModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VpnServiceModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.VpnServiceModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.VpnServiceModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((VpnServiceModelRealmProxyInterface) object).realmGet$VpnCompositeKey();
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
                String realmGet$substnUid = ((VpnServiceModelRealmProxyInterface)object).realmGet$substnUid();
                if (realmGet$substnUid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.substnUidIndex, rowIndex, realmGet$substnUid, false);
                }
                String realmGet$oltSerialNo = ((VpnServiceModelRealmProxyInterface)object).realmGet$oltSerialNo();
                if (realmGet$oltSerialNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.oltSerialNoIndex, rowIndex, realmGet$oltSerialNo, false);
                }
                String realmGet$vpnsrvcName = ((VpnServiceModelRealmProxyInterface)object).realmGet$vpnsrvcName();
                if (realmGet$vpnsrvcName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.vpnsrvcNameIndex, rowIndex, realmGet$vpnsrvcName, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.VpnServiceModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.VpnServiceModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VpnServiceModelColumnInfo columnInfo = (VpnServiceModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VpnServiceModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((VpnServiceModelRealmProxyInterface) object).realmGet$VpnCompositeKey();
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
        String realmGet$substnUid = ((VpnServiceModelRealmProxyInterface)object).realmGet$substnUid();
        if (realmGet$substnUid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.substnUidIndex, rowIndex, realmGet$substnUid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.substnUidIndex, rowIndex, false);
        }
        String realmGet$oltSerialNo = ((VpnServiceModelRealmProxyInterface)object).realmGet$oltSerialNo();
        if (realmGet$oltSerialNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.oltSerialNoIndex, rowIndex, realmGet$oltSerialNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.oltSerialNoIndex, rowIndex, false);
        }
        String realmGet$vpnsrvcName = ((VpnServiceModelRealmProxyInterface)object).realmGet$vpnsrvcName();
        if (realmGet$vpnsrvcName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vpnsrvcNameIndex, rowIndex, realmGet$vpnsrvcName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.vpnsrvcNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.VpnServiceModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VpnServiceModelColumnInfo columnInfo = (VpnServiceModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VpnServiceModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.VpnServiceModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.VpnServiceModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((VpnServiceModelRealmProxyInterface) object).realmGet$VpnCompositeKey();
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
                String realmGet$substnUid = ((VpnServiceModelRealmProxyInterface)object).realmGet$substnUid();
                if (realmGet$substnUid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.substnUidIndex, rowIndex, realmGet$substnUid, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.substnUidIndex, rowIndex, false);
                }
                String realmGet$oltSerialNo = ((VpnServiceModelRealmProxyInterface)object).realmGet$oltSerialNo();
                if (realmGet$oltSerialNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.oltSerialNoIndex, rowIndex, realmGet$oltSerialNo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.oltSerialNoIndex, rowIndex, false);
                }
                String realmGet$vpnsrvcName = ((VpnServiceModelRealmProxyInterface)object).realmGet$vpnsrvcName();
                if (realmGet$vpnsrvcName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.vpnsrvcNameIndex, rowIndex, realmGet$vpnsrvcName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.vpnsrvcNameIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.VpnServiceModel createDetachedCopy(com.app.apsfl.models.VpnServiceModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.VpnServiceModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.VpnServiceModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.VpnServiceModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.VpnServiceModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((VpnServiceModelRealmProxyInterface) unmanagedObject).realmSet$VpnCompositeKey(((VpnServiceModelRealmProxyInterface) realmObject).realmGet$VpnCompositeKey());
        ((VpnServiceModelRealmProxyInterface) unmanagedObject).realmSet$substnUid(((VpnServiceModelRealmProxyInterface) realmObject).realmGet$substnUid());
        ((VpnServiceModelRealmProxyInterface) unmanagedObject).realmSet$oltSerialNo(((VpnServiceModelRealmProxyInterface) realmObject).realmGet$oltSerialNo());
        ((VpnServiceModelRealmProxyInterface) unmanagedObject).realmSet$vpnsrvcName(((VpnServiceModelRealmProxyInterface) realmObject).realmGet$vpnsrvcName());
        return unmanagedObject;
    }

    static com.app.apsfl.models.VpnServiceModel update(Realm realm, com.app.apsfl.models.VpnServiceModel realmObject, com.app.apsfl.models.VpnServiceModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((VpnServiceModelRealmProxyInterface) realmObject).realmSet$substnUid(((VpnServiceModelRealmProxyInterface) newObject).realmGet$substnUid());
        ((VpnServiceModelRealmProxyInterface) realmObject).realmSet$oltSerialNo(((VpnServiceModelRealmProxyInterface) newObject).realmGet$oltSerialNo());
        ((VpnServiceModelRealmProxyInterface) realmObject).realmSet$vpnsrvcName(((VpnServiceModelRealmProxyInterface) newObject).realmGet$vpnsrvcName());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("VpnServiceModel = [");
        stringBuilder.append("{VpnCompositeKey:");
        stringBuilder.append(realmGet$VpnCompositeKey() != null ? realmGet$VpnCompositeKey() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{substnUid:");
        stringBuilder.append(realmGet$substnUid() != null ? realmGet$substnUid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{oltSerialNo:");
        stringBuilder.append(realmGet$oltSerialNo() != null ? realmGet$oltSerialNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vpnsrvcName:");
        stringBuilder.append(realmGet$vpnsrvcName() != null ? realmGet$vpnsrvcName() : "null");
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
        VpnServiceModelRealmProxy aVpnServiceModel = (VpnServiceModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVpnServiceModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVpnServiceModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVpnServiceModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
