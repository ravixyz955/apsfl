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

public class PopMandalModelRealmProxy extends com.app.apsfl.models.PopMandalModel
    implements RealmObjectProxy, PopMandalModelRealmProxyInterface {

    static final class PopMandalModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long mandalIDIndex;
        public long mandalNameIndex;
        public long districtIDIndex;
        public long mandalSerialNumberIndex;
        public long isMandalCheckedIndex;

        PopMandalModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.mandalIDIndex = getValidColumnIndex(path, table, "PopMandalModel", "mandalID");
            indicesMap.put("mandalID", this.mandalIDIndex);
            this.mandalNameIndex = getValidColumnIndex(path, table, "PopMandalModel", "mandalName");
            indicesMap.put("mandalName", this.mandalNameIndex);
            this.districtIDIndex = getValidColumnIndex(path, table, "PopMandalModel", "districtID");
            indicesMap.put("districtID", this.districtIDIndex);
            this.mandalSerialNumberIndex = getValidColumnIndex(path, table, "PopMandalModel", "mandalSerialNumber");
            indicesMap.put("mandalSerialNumber", this.mandalSerialNumberIndex);
            this.isMandalCheckedIndex = getValidColumnIndex(path, table, "PopMandalModel", "isMandalChecked");
            indicesMap.put("isMandalChecked", this.isMandalCheckedIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final PopMandalModelColumnInfo otherInfo = (PopMandalModelColumnInfo) other;
            this.mandalIDIndex = otherInfo.mandalIDIndex;
            this.mandalNameIndex = otherInfo.mandalNameIndex;
            this.districtIDIndex = otherInfo.districtIDIndex;
            this.mandalSerialNumberIndex = otherInfo.mandalSerialNumberIndex;
            this.isMandalCheckedIndex = otherInfo.isMandalCheckedIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final PopMandalModelColumnInfo clone() {
            return (PopMandalModelColumnInfo) super.clone();
        }

    }
    private PopMandalModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("mandalID");
        fieldNames.add("mandalName");
        fieldNames.add("districtID");
        fieldNames.add("mandalSerialNumber");
        fieldNames.add("isMandalChecked");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PopMandalModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PopMandalModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.PopMandalModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$mandalID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.mandalIDIndex);
    }

    public void realmSet$mandalID(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'mandalID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$mandalName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mandalNameIndex);
    }

    public void realmSet$mandalName(String value) {
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
                row.getTable().setNull(columnInfo.mandalNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mandalNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mandalNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mandalNameIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$districtID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.districtIDIndex);
    }

    public void realmSet$districtID(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.districtIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.districtIDIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$mandalSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.mandalSerialNumberIndex);
    }

    public void realmSet$mandalSerialNumber(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.mandalSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.mandalSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isMandalChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isMandalCheckedIndex);
    }

    public void realmSet$isMandalChecked(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isMandalCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isMandalCheckedIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("PopMandalModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("PopMandalModel");
            realmObjectSchema.add(new Property("mandalID", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("districtID", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalSerialNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("isMandalChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("PopMandalModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_PopMandalModel")) {
            Table table = sharedRealm.getTable("class_PopMandalModel");
            table.addColumn(RealmFieldType.INTEGER, "mandalID", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mandalName", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "districtID", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "mandalSerialNumber", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isMandalChecked", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("mandalID"));
            table.setPrimaryKey("mandalID");
            return table;
        }
        return sharedRealm.getTable("class_PopMandalModel");
    }

    public static PopMandalModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_PopMandalModel")) {
            Table table = sharedRealm.getTable("class_PopMandalModel");
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

            final PopMandalModelColumnInfo columnInfo = new PopMandalModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("mandalID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mandalID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mandalID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'mandalID' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.mandalIDIndex) && table.findFirstNull(columnInfo.mandalIDIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'mandalID'. Either maintain the same type for primary key field 'mandalID', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("mandalID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'mandalID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("mandalID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'mandalID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("mandalName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mandalName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mandalName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mandalName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.mandalNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mandalName' is required. Either set @Required to field 'mandalName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("districtID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'districtID' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.districtIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtID' does support null values in the existing Realm file. Use corresponding boxed type for field 'districtID' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("mandalSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mandalSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mandalSerialNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'mandalSerialNumber' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.mandalSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mandalSerialNumber' does support null values in the existing Realm file. Use corresponding boxed type for field 'mandalSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isMandalChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isMandalChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isMandalChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isMandalChecked' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isMandalCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isMandalChecked' does support null values in the existing Realm file. Use corresponding boxed type for field 'isMandalChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'PopMandalModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_PopMandalModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.PopMandalModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.PopMandalModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.PopMandalModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("mandalID")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("mandalID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.PopMandalModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PopMandalModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("mandalID")) {
                if (json.isNull("mandalID")) {
                    obj = (io.realm.PopMandalModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.PopMandalModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PopMandalModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.PopMandalModel.class, json.getInt("mandalID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'mandalID'.");
            }
        }
        if (json.has("mandalName")) {
            if (json.isNull("mandalName")) {
                ((PopMandalModelRealmProxyInterface) obj).realmSet$mandalName(null);
            } else {
                ((PopMandalModelRealmProxyInterface) obj).realmSet$mandalName((String) json.getString("mandalName"));
            }
        }
        if (json.has("districtID")) {
            if (json.isNull("districtID")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'districtID' to null.");
            } else {
                ((PopMandalModelRealmProxyInterface) obj).realmSet$districtID((int) json.getInt("districtID"));
            }
        }
        if (json.has("mandalSerialNumber")) {
            if (json.isNull("mandalSerialNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'mandalSerialNumber' to null.");
            } else {
                ((PopMandalModelRealmProxyInterface) obj).realmSet$mandalSerialNumber((int) json.getInt("mandalSerialNumber"));
            }
        }
        if (json.has("isMandalChecked")) {
            if (json.isNull("isMandalChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isMandalChecked' to null.");
            } else {
                ((PopMandalModelRealmProxyInterface) obj).realmSet$isMandalChecked((boolean) json.getBoolean("isMandalChecked"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.PopMandalModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.PopMandalModel obj = new com.app.apsfl.models.PopMandalModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("mandalID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mandalID' to null.");
                } else {
                    ((PopMandalModelRealmProxyInterface) obj).realmSet$mandalID((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("mandalName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PopMandalModelRealmProxyInterface) obj).realmSet$mandalName(null);
                } else {
                    ((PopMandalModelRealmProxyInterface) obj).realmSet$mandalName((String) reader.nextString());
                }
            } else if (name.equals("districtID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'districtID' to null.");
                } else {
                    ((PopMandalModelRealmProxyInterface) obj).realmSet$districtID((int) reader.nextInt());
                }
            } else if (name.equals("mandalSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mandalSerialNumber' to null.");
                } else {
                    ((PopMandalModelRealmProxyInterface) obj).realmSet$mandalSerialNumber((int) reader.nextInt());
                }
            } else if (name.equals("isMandalChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isMandalChecked' to null.");
                } else {
                    ((PopMandalModelRealmProxyInterface) obj).realmSet$isMandalChecked((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'mandalID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.PopMandalModel copyOrUpdate(Realm realm, com.app.apsfl.models.PopMandalModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.PopMandalModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.PopMandalModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.PopMandalModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.PopMandalModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.PopMandalModelRealmProxy();
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

    public static com.app.apsfl.models.PopMandalModel copy(Realm realm, com.app.apsfl.models.PopMandalModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.PopMandalModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.PopMandalModel realmObject = realm.createObjectInternal(com.app.apsfl.models.PopMandalModel.class, ((PopMandalModelRealmProxyInterface) newObject).realmGet$mandalID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PopMandalModelRealmProxyInterface) realmObject).realmSet$mandalName(((PopMandalModelRealmProxyInterface) newObject).realmGet$mandalName());
            ((PopMandalModelRealmProxyInterface) realmObject).realmSet$districtID(((PopMandalModelRealmProxyInterface) newObject).realmGet$districtID());
            ((PopMandalModelRealmProxyInterface) realmObject).realmSet$mandalSerialNumber(((PopMandalModelRealmProxyInterface) newObject).realmGet$mandalSerialNumber());
            ((PopMandalModelRealmProxyInterface) realmObject).realmSet$isMandalChecked(((PopMandalModelRealmProxyInterface) newObject).realmGet$isMandalChecked());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.PopMandalModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.PopMandalModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        PopMandalModelColumnInfo columnInfo = (PopMandalModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.PopMandalModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((PopMandalModelRealmProxyInterface) object).realmGet$mandalID(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$mandalName = ((PopMandalModelRealmProxyInterface)object).realmGet$mandalName();
        if (realmGet$mandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.districtIDIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$districtID(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$mandalSerialNumber(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isMandalCheckedIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$isMandalChecked(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.PopMandalModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        PopMandalModelColumnInfo columnInfo = (PopMandalModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.PopMandalModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.PopMandalModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.PopMandalModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((PopMandalModelRealmProxyInterface) object).realmGet$mandalID(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$mandalName = ((PopMandalModelRealmProxyInterface)object).realmGet$mandalName();
                if (realmGet$mandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.districtIDIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$districtID(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$mandalSerialNumber(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isMandalCheckedIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$isMandalChecked(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.PopMandalModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.PopMandalModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        PopMandalModelColumnInfo columnInfo = (PopMandalModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.PopMandalModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((PopMandalModelRealmProxyInterface) object).realmGet$mandalID(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$mandalName = ((PopMandalModelRealmProxyInterface)object).realmGet$mandalName();
        if (realmGet$mandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.districtIDIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$districtID(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$mandalSerialNumber(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isMandalCheckedIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$isMandalChecked(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.PopMandalModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        PopMandalModelColumnInfo columnInfo = (PopMandalModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.PopMandalModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.PopMandalModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.PopMandalModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PopMandalModelRealmProxyInterface) object).realmGet$mandalID());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((PopMandalModelRealmProxyInterface) object).realmGet$mandalID(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$mandalName = ((PopMandalModelRealmProxyInterface)object).realmGet$mandalName();
                if (realmGet$mandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.districtIDIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$districtID(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$mandalSerialNumber(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isMandalCheckedIndex, rowIndex, ((PopMandalModelRealmProxyInterface)object).realmGet$isMandalChecked(), false);
            }
        }
    }

    public static com.app.apsfl.models.PopMandalModel createDetachedCopy(com.app.apsfl.models.PopMandalModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.PopMandalModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.PopMandalModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.PopMandalModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.PopMandalModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((PopMandalModelRealmProxyInterface) unmanagedObject).realmSet$mandalID(((PopMandalModelRealmProxyInterface) realmObject).realmGet$mandalID());
        ((PopMandalModelRealmProxyInterface) unmanagedObject).realmSet$mandalName(((PopMandalModelRealmProxyInterface) realmObject).realmGet$mandalName());
        ((PopMandalModelRealmProxyInterface) unmanagedObject).realmSet$districtID(((PopMandalModelRealmProxyInterface) realmObject).realmGet$districtID());
        ((PopMandalModelRealmProxyInterface) unmanagedObject).realmSet$mandalSerialNumber(((PopMandalModelRealmProxyInterface) realmObject).realmGet$mandalSerialNumber());
        ((PopMandalModelRealmProxyInterface) unmanagedObject).realmSet$isMandalChecked(((PopMandalModelRealmProxyInterface) realmObject).realmGet$isMandalChecked());
        return unmanagedObject;
    }

    static com.app.apsfl.models.PopMandalModel update(Realm realm, com.app.apsfl.models.PopMandalModel realmObject, com.app.apsfl.models.PopMandalModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PopMandalModelRealmProxyInterface) realmObject).realmSet$mandalName(((PopMandalModelRealmProxyInterface) newObject).realmGet$mandalName());
        ((PopMandalModelRealmProxyInterface) realmObject).realmSet$districtID(((PopMandalModelRealmProxyInterface) newObject).realmGet$districtID());
        ((PopMandalModelRealmProxyInterface) realmObject).realmSet$mandalSerialNumber(((PopMandalModelRealmProxyInterface) newObject).realmGet$mandalSerialNumber());
        ((PopMandalModelRealmProxyInterface) realmObject).realmSet$isMandalChecked(((PopMandalModelRealmProxyInterface) newObject).realmGet$isMandalChecked());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PopMandalModel = [");
        stringBuilder.append("{mandalID:");
        stringBuilder.append(realmGet$mandalID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mandalName:");
        stringBuilder.append(realmGet$mandalName() != null ? realmGet$mandalName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{districtID:");
        stringBuilder.append(realmGet$districtID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mandalSerialNumber:");
        stringBuilder.append(realmGet$mandalSerialNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isMandalChecked:");
        stringBuilder.append(realmGet$isMandalChecked());
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
        PopMandalModelRealmProxy aPopMandalModel = (PopMandalModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPopMandalModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPopMandalModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPopMandalModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
