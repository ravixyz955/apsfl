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

public class ServicesModelRealmProxy extends com.app.apsfl.models.ServicesModel
    implements RealmObjectProxy, ServicesModelRealmProxyInterface {

    static final class ServicesModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long serviceCodeIndex;
        public long serviceNameIndex;
        public long serviceEffectiveFromIndex;
        public long isServiceCheckedIndex;

        ServicesModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.serviceCodeIndex = getValidColumnIndex(path, table, "ServicesModel", "serviceCode");
            indicesMap.put("serviceCode", this.serviceCodeIndex);
            this.serviceNameIndex = getValidColumnIndex(path, table, "ServicesModel", "serviceName");
            indicesMap.put("serviceName", this.serviceNameIndex);
            this.serviceEffectiveFromIndex = getValidColumnIndex(path, table, "ServicesModel", "serviceEffectiveFrom");
            indicesMap.put("serviceEffectiveFrom", this.serviceEffectiveFromIndex);
            this.isServiceCheckedIndex = getValidColumnIndex(path, table, "ServicesModel", "isServiceChecked");
            indicesMap.put("isServiceChecked", this.isServiceCheckedIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ServicesModelColumnInfo otherInfo = (ServicesModelColumnInfo) other;
            this.serviceCodeIndex = otherInfo.serviceCodeIndex;
            this.serviceNameIndex = otherInfo.serviceNameIndex;
            this.serviceEffectiveFromIndex = otherInfo.serviceEffectiveFromIndex;
            this.isServiceCheckedIndex = otherInfo.isServiceCheckedIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ServicesModelColumnInfo clone() {
            return (ServicesModelColumnInfo) super.clone();
        }

    }
    private ServicesModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("serviceCode");
        fieldNames.add("serviceName");
        fieldNames.add("serviceEffectiveFrom");
        fieldNames.add("isServiceChecked");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ServicesModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ServicesModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.ServicesModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$serviceCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.serviceCodeIndex);
    }

    public void realmSet$serviceCode(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'serviceCode' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$serviceName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.serviceNameIndex);
    }

    public void realmSet$serviceName(String value) {
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
                row.getTable().setNull(columnInfo.serviceNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.serviceNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.serviceNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.serviceNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$serviceEffectiveFrom() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.serviceEffectiveFromIndex);
    }

    public void realmSet$serviceEffectiveFrom(String value) {
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
                row.getTable().setNull(columnInfo.serviceEffectiveFromIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.serviceEffectiveFromIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.serviceEffectiveFromIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.serviceEffectiveFromIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isServiceChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isServiceCheckedIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isServiceCheckedIndex);
    }

    public void realmSet$isServiceChecked(Boolean value) {
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
                row.getTable().setNull(columnInfo.isServiceCheckedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isServiceCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isServiceCheckedIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isServiceCheckedIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ServicesModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ServicesModel");
            realmObjectSchema.add(new Property("serviceCode", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("serviceName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("serviceEffectiveFrom", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isServiceChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("ServicesModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_ServicesModel")) {
            Table table = sharedRealm.getTable("class_ServicesModel");
            table.addColumn(RealmFieldType.STRING, "serviceCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "serviceName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "serviceEffectiveFrom", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isServiceChecked", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("serviceCode"));
            table.setPrimaryKey("serviceCode");
            return table;
        }
        return sharedRealm.getTable("class_ServicesModel");
    }

    public static ServicesModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_ServicesModel")) {
            Table table = sharedRealm.getTable("class_ServicesModel");
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

            final ServicesModelColumnInfo columnInfo = new ServicesModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("serviceCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'serviceCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("serviceCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'serviceCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.serviceCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'serviceCode' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("serviceCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'serviceCode' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("serviceCode"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'serviceCode' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("serviceName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'serviceName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("serviceName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'serviceName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.serviceNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'serviceName' is required. Either set @Required to field 'serviceName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("serviceEffectiveFrom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'serviceEffectiveFrom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("serviceEffectiveFrom") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'serviceEffectiveFrom' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.serviceEffectiveFromIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'serviceEffectiveFrom' is required. Either set @Required to field 'serviceEffectiveFrom' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isServiceChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isServiceChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isServiceChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isServiceChecked' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isServiceCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isServiceChecked' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isServiceChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ServicesModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ServicesModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.ServicesModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.ServicesModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.ServicesModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("serviceCode")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("serviceCode"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.ServicesModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ServicesModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("serviceCode")) {
                if (json.isNull("serviceCode")) {
                    obj = (io.realm.ServicesModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.ServicesModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ServicesModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.ServicesModel.class, json.getString("serviceCode"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'serviceCode'.");
            }
        }
        if (json.has("serviceName")) {
            if (json.isNull("serviceName")) {
                ((ServicesModelRealmProxyInterface) obj).realmSet$serviceName(null);
            } else {
                ((ServicesModelRealmProxyInterface) obj).realmSet$serviceName((String) json.getString("serviceName"));
            }
        }
        if (json.has("serviceEffectiveFrom")) {
            if (json.isNull("serviceEffectiveFrom")) {
                ((ServicesModelRealmProxyInterface) obj).realmSet$serviceEffectiveFrom(null);
            } else {
                ((ServicesModelRealmProxyInterface) obj).realmSet$serviceEffectiveFrom((String) json.getString("serviceEffectiveFrom"));
            }
        }
        if (json.has("isServiceChecked")) {
            if (json.isNull("isServiceChecked")) {
                ((ServicesModelRealmProxyInterface) obj).realmSet$isServiceChecked(null);
            } else {
                ((ServicesModelRealmProxyInterface) obj).realmSet$isServiceChecked((boolean) json.getBoolean("isServiceChecked"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.ServicesModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.ServicesModel obj = new com.app.apsfl.models.ServicesModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("serviceCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ServicesModelRealmProxyInterface) obj).realmSet$serviceCode(null);
                } else {
                    ((ServicesModelRealmProxyInterface) obj).realmSet$serviceCode((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("serviceName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ServicesModelRealmProxyInterface) obj).realmSet$serviceName(null);
                } else {
                    ((ServicesModelRealmProxyInterface) obj).realmSet$serviceName((String) reader.nextString());
                }
            } else if (name.equals("serviceEffectiveFrom")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ServicesModelRealmProxyInterface) obj).realmSet$serviceEffectiveFrom(null);
                } else {
                    ((ServicesModelRealmProxyInterface) obj).realmSet$serviceEffectiveFrom((String) reader.nextString());
                }
            } else if (name.equals("isServiceChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ServicesModelRealmProxyInterface) obj).realmSet$isServiceChecked(null);
                } else {
                    ((ServicesModelRealmProxyInterface) obj).realmSet$isServiceChecked((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'serviceCode'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.ServicesModel copyOrUpdate(Realm realm, com.app.apsfl.models.ServicesModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.ServicesModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.ServicesModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.ServicesModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((ServicesModelRealmProxyInterface) object).realmGet$serviceCode();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.ServicesModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ServicesModelRealmProxy();
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

    public static com.app.apsfl.models.ServicesModel copy(Realm realm, com.app.apsfl.models.ServicesModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.ServicesModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.ServicesModel realmObject = realm.createObjectInternal(com.app.apsfl.models.ServicesModel.class, ((ServicesModelRealmProxyInterface) newObject).realmGet$serviceCode(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ServicesModelRealmProxyInterface) realmObject).realmSet$serviceName(((ServicesModelRealmProxyInterface) newObject).realmGet$serviceName());
            ((ServicesModelRealmProxyInterface) realmObject).realmSet$serviceEffectiveFrom(((ServicesModelRealmProxyInterface) newObject).realmGet$serviceEffectiveFrom());
            ((ServicesModelRealmProxyInterface) realmObject).realmSet$isServiceChecked(((ServicesModelRealmProxyInterface) newObject).realmGet$isServiceChecked());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.ServicesModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.ServicesModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ServicesModelColumnInfo columnInfo = (ServicesModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ServicesModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ServicesModelRealmProxyInterface) object).realmGet$serviceCode();
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
        String realmGet$serviceName = ((ServicesModelRealmProxyInterface)object).realmGet$serviceName();
        if (realmGet$serviceName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceNameIndex, rowIndex, realmGet$serviceName, false);
        }
        String realmGet$serviceEffectiveFrom = ((ServicesModelRealmProxyInterface)object).realmGet$serviceEffectiveFrom();
        if (realmGet$serviceEffectiveFrom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceEffectiveFromIndex, rowIndex, realmGet$serviceEffectiveFrom, false);
        }
        Boolean realmGet$isServiceChecked = ((ServicesModelRealmProxyInterface)object).realmGet$isServiceChecked();
        if (realmGet$isServiceChecked != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isServiceCheckedIndex, rowIndex, realmGet$isServiceChecked, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.ServicesModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ServicesModelColumnInfo columnInfo = (ServicesModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ServicesModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.ServicesModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.ServicesModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ServicesModelRealmProxyInterface) object).realmGet$serviceCode();
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
                String realmGet$serviceName = ((ServicesModelRealmProxyInterface)object).realmGet$serviceName();
                if (realmGet$serviceName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.serviceNameIndex, rowIndex, realmGet$serviceName, false);
                }
                String realmGet$serviceEffectiveFrom = ((ServicesModelRealmProxyInterface)object).realmGet$serviceEffectiveFrom();
                if (realmGet$serviceEffectiveFrom != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.serviceEffectiveFromIndex, rowIndex, realmGet$serviceEffectiveFrom, false);
                }
                Boolean realmGet$isServiceChecked = ((ServicesModelRealmProxyInterface)object).realmGet$isServiceChecked();
                if (realmGet$isServiceChecked != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isServiceCheckedIndex, rowIndex, realmGet$isServiceChecked, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.ServicesModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.ServicesModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ServicesModelColumnInfo columnInfo = (ServicesModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ServicesModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ServicesModelRealmProxyInterface) object).realmGet$serviceCode();
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
        String realmGet$serviceName = ((ServicesModelRealmProxyInterface)object).realmGet$serviceName();
        if (realmGet$serviceName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceNameIndex, rowIndex, realmGet$serviceName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.serviceNameIndex, rowIndex, false);
        }
        String realmGet$serviceEffectiveFrom = ((ServicesModelRealmProxyInterface)object).realmGet$serviceEffectiveFrom();
        if (realmGet$serviceEffectiveFrom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceEffectiveFromIndex, rowIndex, realmGet$serviceEffectiveFrom, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.serviceEffectiveFromIndex, rowIndex, false);
        }
        Boolean realmGet$isServiceChecked = ((ServicesModelRealmProxyInterface)object).realmGet$isServiceChecked();
        if (realmGet$isServiceChecked != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isServiceCheckedIndex, rowIndex, realmGet$isServiceChecked, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isServiceCheckedIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.ServicesModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        ServicesModelColumnInfo columnInfo = (ServicesModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.ServicesModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.ServicesModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.ServicesModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ServicesModelRealmProxyInterface) object).realmGet$serviceCode();
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
                String realmGet$serviceName = ((ServicesModelRealmProxyInterface)object).realmGet$serviceName();
                if (realmGet$serviceName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.serviceNameIndex, rowIndex, realmGet$serviceName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.serviceNameIndex, rowIndex, false);
                }
                String realmGet$serviceEffectiveFrom = ((ServicesModelRealmProxyInterface)object).realmGet$serviceEffectiveFrom();
                if (realmGet$serviceEffectiveFrom != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.serviceEffectiveFromIndex, rowIndex, realmGet$serviceEffectiveFrom, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.serviceEffectiveFromIndex, rowIndex, false);
                }
                Boolean realmGet$isServiceChecked = ((ServicesModelRealmProxyInterface)object).realmGet$isServiceChecked();
                if (realmGet$isServiceChecked != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isServiceCheckedIndex, rowIndex, realmGet$isServiceChecked, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isServiceCheckedIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.ServicesModel createDetachedCopy(com.app.apsfl.models.ServicesModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.ServicesModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.ServicesModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.ServicesModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.ServicesModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((ServicesModelRealmProxyInterface) unmanagedObject).realmSet$serviceCode(((ServicesModelRealmProxyInterface) realmObject).realmGet$serviceCode());
        ((ServicesModelRealmProxyInterface) unmanagedObject).realmSet$serviceName(((ServicesModelRealmProxyInterface) realmObject).realmGet$serviceName());
        ((ServicesModelRealmProxyInterface) unmanagedObject).realmSet$serviceEffectiveFrom(((ServicesModelRealmProxyInterface) realmObject).realmGet$serviceEffectiveFrom());
        ((ServicesModelRealmProxyInterface) unmanagedObject).realmSet$isServiceChecked(((ServicesModelRealmProxyInterface) realmObject).realmGet$isServiceChecked());
        return unmanagedObject;
    }

    static com.app.apsfl.models.ServicesModel update(Realm realm, com.app.apsfl.models.ServicesModel realmObject, com.app.apsfl.models.ServicesModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ServicesModelRealmProxyInterface) realmObject).realmSet$serviceName(((ServicesModelRealmProxyInterface) newObject).realmGet$serviceName());
        ((ServicesModelRealmProxyInterface) realmObject).realmSet$serviceEffectiveFrom(((ServicesModelRealmProxyInterface) newObject).realmGet$serviceEffectiveFrom());
        ((ServicesModelRealmProxyInterface) realmObject).realmSet$isServiceChecked(((ServicesModelRealmProxyInterface) newObject).realmGet$isServiceChecked());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ServicesModel = [");
        stringBuilder.append("{serviceCode:");
        stringBuilder.append(realmGet$serviceCode() != null ? realmGet$serviceCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{serviceName:");
        stringBuilder.append(realmGet$serviceName() != null ? realmGet$serviceName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{serviceEffectiveFrom:");
        stringBuilder.append(realmGet$serviceEffectiveFrom() != null ? realmGet$serviceEffectiveFrom() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isServiceChecked:");
        stringBuilder.append(realmGet$isServiceChecked() != null ? realmGet$isServiceChecked() : "null");
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
        ServicesModelRealmProxy aServicesModel = (ServicesModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aServicesModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aServicesModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aServicesModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
