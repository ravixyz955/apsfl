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

public class POPOLTModelRealmProxy extends com.app.apsfl.models.POPOLTModel
    implements RealmObjectProxy, POPOLTModelRealmProxyInterface {

    static final class POPOLTModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long popOLTIDIndex;
        public long popIDIndex;
        public long popNameIndex;
        public long popOLTSerialNumberIndex;
        public long popLabelNumberIndex;

        POPOLTModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.popOLTIDIndex = getValidColumnIndex(path, table, "POPOLTModel", "popOLTID");
            indicesMap.put("popOLTID", this.popOLTIDIndex);
            this.popIDIndex = getValidColumnIndex(path, table, "POPOLTModel", "popID");
            indicesMap.put("popID", this.popIDIndex);
            this.popNameIndex = getValidColumnIndex(path, table, "POPOLTModel", "popName");
            indicesMap.put("popName", this.popNameIndex);
            this.popOLTSerialNumberIndex = getValidColumnIndex(path, table, "POPOLTModel", "popOLTSerialNumber");
            indicesMap.put("popOLTSerialNumber", this.popOLTSerialNumberIndex);
            this.popLabelNumberIndex = getValidColumnIndex(path, table, "POPOLTModel", "popLabelNumber");
            indicesMap.put("popLabelNumber", this.popLabelNumberIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final POPOLTModelColumnInfo otherInfo = (POPOLTModelColumnInfo) other;
            this.popOLTIDIndex = otherInfo.popOLTIDIndex;
            this.popIDIndex = otherInfo.popIDIndex;
            this.popNameIndex = otherInfo.popNameIndex;
            this.popOLTSerialNumberIndex = otherInfo.popOLTSerialNumberIndex;
            this.popLabelNumberIndex = otherInfo.popLabelNumberIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final POPOLTModelColumnInfo clone() {
            return (POPOLTModelColumnInfo) super.clone();
        }

    }
    private POPOLTModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("popOLTID");
        fieldNames.add("popID");
        fieldNames.add("popName");
        fieldNames.add("popOLTSerialNumber");
        fieldNames.add("popLabelNumber");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    POPOLTModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (POPOLTModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.POPOLTModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$popOLTID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popOLTIDIndex);
    }

    public void realmSet$popOLTID(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'popOLTID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$popID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popIDIndex);
    }

    public void realmSet$popID(String value) {
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
                row.getTable().setNull(columnInfo.popIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popIDIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popNameIndex);
    }

    public void realmSet$popName(String value) {
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
                row.getTable().setNull(columnInfo.popNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popOLTSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popOLTSerialNumberIndex);
    }

    public void realmSet$popOLTSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.popOLTSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popOLTSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popOLTSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popOLTSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popLabelNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popLabelNumberIndex);
    }

    public void realmSet$popLabelNumber(String value) {
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
                row.getTable().setNull(columnInfo.popLabelNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popLabelNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popLabelNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popLabelNumberIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("POPOLTModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("POPOLTModel");
            realmObjectSchema.add(new Property("popOLTID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popOLTSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popLabelNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("POPOLTModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_POPOLTModel")) {
            Table table = sharedRealm.getTable("class_POPOLTModel");
            table.addColumn(RealmFieldType.STRING, "popOLTID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popOLTSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popLabelNumber", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("popOLTID"));
            table.setPrimaryKey("popOLTID");
            return table;
        }
        return sharedRealm.getTable("class_POPOLTModel");
    }

    public static POPOLTModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_POPOLTModel")) {
            Table table = sharedRealm.getTable("class_POPOLTModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 5; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final POPOLTModelColumnInfo columnInfo = new POPOLTModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("popOLTID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popOLTID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popOLTID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popOLTID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popOLTIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'popOLTID' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("popOLTID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'popOLTID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("popOLTID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'popOLTID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("popID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popID' is required. Either set @Required to field 'popID' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popName' is required. Either set @Required to field 'popName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popOLTSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popOLTSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popOLTSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popOLTSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popOLTSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popOLTSerialNumber' is required. Either set @Required to field 'popOLTSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popLabelNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popLabelNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popLabelNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popLabelNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popLabelNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popLabelNumber' is required. Either set @Required to field 'popLabelNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'POPOLTModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_POPOLTModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.POPOLTModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.POPOLTModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.POPOLTModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("popOLTID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("popOLTID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.POPOLTModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.POPOLTModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("popOLTID")) {
                if (json.isNull("popOLTID")) {
                    obj = (io.realm.POPOLTModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.POPOLTModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.POPOLTModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.POPOLTModel.class, json.getString("popOLTID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'popOLTID'.");
            }
        }
        if (json.has("popID")) {
            if (json.isNull("popID")) {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popID(null);
            } else {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popID((String) json.getString("popID"));
            }
        }
        if (json.has("popName")) {
            if (json.isNull("popName")) {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popName(null);
            } else {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popName((String) json.getString("popName"));
            }
        }
        if (json.has("popOLTSerialNumber")) {
            if (json.isNull("popOLTSerialNumber")) {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popOLTSerialNumber(null);
            } else {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popOLTSerialNumber((String) json.getString("popOLTSerialNumber"));
            }
        }
        if (json.has("popLabelNumber")) {
            if (json.isNull("popLabelNumber")) {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popLabelNumber(null);
            } else {
                ((POPOLTModelRealmProxyInterface) obj).realmSet$popLabelNumber((String) json.getString("popLabelNumber"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.POPOLTModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.POPOLTModel obj = new com.app.apsfl.models.POPOLTModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("popOLTID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popOLTID(null);
                } else {
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popOLTID((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("popID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popID(null);
                } else {
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popID((String) reader.nextString());
                }
            } else if (name.equals("popName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popName(null);
                } else {
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popName((String) reader.nextString());
                }
            } else if (name.equals("popOLTSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popOLTSerialNumber(null);
                } else {
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popOLTSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("popLabelNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popLabelNumber(null);
                } else {
                    ((POPOLTModelRealmProxyInterface) obj).realmSet$popLabelNumber((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'popOLTID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.POPOLTModel copyOrUpdate(Realm realm, com.app.apsfl.models.POPOLTModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.POPOLTModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.POPOLTModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.POPOLTModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((POPOLTModelRealmProxyInterface) object).realmGet$popOLTID();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.POPOLTModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.POPOLTModelRealmProxy();
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

    public static com.app.apsfl.models.POPOLTModel copy(Realm realm, com.app.apsfl.models.POPOLTModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.POPOLTModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.POPOLTModel realmObject = realm.createObjectInternal(com.app.apsfl.models.POPOLTModel.class, ((POPOLTModelRealmProxyInterface) newObject).realmGet$popOLTID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popID(((POPOLTModelRealmProxyInterface) newObject).realmGet$popID());
            ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popName(((POPOLTModelRealmProxyInterface) newObject).realmGet$popName());
            ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popOLTSerialNumber(((POPOLTModelRealmProxyInterface) newObject).realmGet$popOLTSerialNumber());
            ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popLabelNumber(((POPOLTModelRealmProxyInterface) newObject).realmGet$popLabelNumber());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.POPOLTModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.POPOLTModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        POPOLTModelColumnInfo columnInfo = (POPOLTModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.POPOLTModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((POPOLTModelRealmProxyInterface) object).realmGet$popOLTID();
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
        String realmGet$popID = ((POPOLTModelRealmProxyInterface)object).realmGet$popID();
        if (realmGet$popID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
        }
        String realmGet$popName = ((POPOLTModelRealmProxyInterface)object).realmGet$popName();
        if (realmGet$popName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
        }
        String realmGet$popOLTSerialNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popOLTSerialNumber();
        if (realmGet$popOLTSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popOLTSerialNumberIndex, rowIndex, realmGet$popOLTSerialNumber, false);
        }
        String realmGet$popLabelNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popLabelNumber();
        if (realmGet$popLabelNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popLabelNumberIndex, rowIndex, realmGet$popLabelNumber, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.POPOLTModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        POPOLTModelColumnInfo columnInfo = (POPOLTModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.POPOLTModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.POPOLTModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.POPOLTModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((POPOLTModelRealmProxyInterface) object).realmGet$popOLTID();
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
                String realmGet$popID = ((POPOLTModelRealmProxyInterface)object).realmGet$popID();
                if (realmGet$popID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
                }
                String realmGet$popName = ((POPOLTModelRealmProxyInterface)object).realmGet$popName();
                if (realmGet$popName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
                }
                String realmGet$popOLTSerialNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popOLTSerialNumber();
                if (realmGet$popOLTSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popOLTSerialNumberIndex, rowIndex, realmGet$popOLTSerialNumber, false);
                }
                String realmGet$popLabelNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popLabelNumber();
                if (realmGet$popLabelNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popLabelNumberIndex, rowIndex, realmGet$popLabelNumber, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.POPOLTModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.POPOLTModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        POPOLTModelColumnInfo columnInfo = (POPOLTModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.POPOLTModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((POPOLTModelRealmProxyInterface) object).realmGet$popOLTID();
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
        String realmGet$popID = ((POPOLTModelRealmProxyInterface)object).realmGet$popID();
        if (realmGet$popID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popIDIndex, rowIndex, false);
        }
        String realmGet$popName = ((POPOLTModelRealmProxyInterface)object).realmGet$popName();
        if (realmGet$popName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popNameIndex, rowIndex, false);
        }
        String realmGet$popOLTSerialNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popOLTSerialNumber();
        if (realmGet$popOLTSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popOLTSerialNumberIndex, rowIndex, realmGet$popOLTSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popOLTSerialNumberIndex, rowIndex, false);
        }
        String realmGet$popLabelNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popLabelNumber();
        if (realmGet$popLabelNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popLabelNumberIndex, rowIndex, realmGet$popLabelNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popLabelNumberIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.POPOLTModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        POPOLTModelColumnInfo columnInfo = (POPOLTModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.POPOLTModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.POPOLTModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.POPOLTModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((POPOLTModelRealmProxyInterface) object).realmGet$popOLTID();
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
                String realmGet$popID = ((POPOLTModelRealmProxyInterface)object).realmGet$popID();
                if (realmGet$popID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIDIndex, rowIndex, realmGet$popID, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popIDIndex, rowIndex, false);
                }
                String realmGet$popName = ((POPOLTModelRealmProxyInterface)object).realmGet$popName();
                if (realmGet$popName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popNameIndex, rowIndex, false);
                }
                String realmGet$popOLTSerialNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popOLTSerialNumber();
                if (realmGet$popOLTSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popOLTSerialNumberIndex, rowIndex, realmGet$popOLTSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popOLTSerialNumberIndex, rowIndex, false);
                }
                String realmGet$popLabelNumber = ((POPOLTModelRealmProxyInterface)object).realmGet$popLabelNumber();
                if (realmGet$popLabelNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popLabelNumberIndex, rowIndex, realmGet$popLabelNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popLabelNumberIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.POPOLTModel createDetachedCopy(com.app.apsfl.models.POPOLTModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.POPOLTModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.POPOLTModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.POPOLTModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.POPOLTModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((POPOLTModelRealmProxyInterface) unmanagedObject).realmSet$popOLTID(((POPOLTModelRealmProxyInterface) realmObject).realmGet$popOLTID());
        ((POPOLTModelRealmProxyInterface) unmanagedObject).realmSet$popID(((POPOLTModelRealmProxyInterface) realmObject).realmGet$popID());
        ((POPOLTModelRealmProxyInterface) unmanagedObject).realmSet$popName(((POPOLTModelRealmProxyInterface) realmObject).realmGet$popName());
        ((POPOLTModelRealmProxyInterface) unmanagedObject).realmSet$popOLTSerialNumber(((POPOLTModelRealmProxyInterface) realmObject).realmGet$popOLTSerialNumber());
        ((POPOLTModelRealmProxyInterface) unmanagedObject).realmSet$popLabelNumber(((POPOLTModelRealmProxyInterface) realmObject).realmGet$popLabelNumber());
        return unmanagedObject;
    }

    static com.app.apsfl.models.POPOLTModel update(Realm realm, com.app.apsfl.models.POPOLTModel realmObject, com.app.apsfl.models.POPOLTModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popID(((POPOLTModelRealmProxyInterface) newObject).realmGet$popID());
        ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popName(((POPOLTModelRealmProxyInterface) newObject).realmGet$popName());
        ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popOLTSerialNumber(((POPOLTModelRealmProxyInterface) newObject).realmGet$popOLTSerialNumber());
        ((POPOLTModelRealmProxyInterface) realmObject).realmSet$popLabelNumber(((POPOLTModelRealmProxyInterface) newObject).realmGet$popLabelNumber());
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
        POPOLTModelRealmProxy aPOPOLTModel = (POPOLTModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPOPOLTModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPOPOLTModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPOPOLTModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
