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

public class SIPOPModelRealmProxy extends com.app.apsfl.models.SIPOPModel
    implements RealmObjectProxy, SIPOPModelRealmProxyInterface {

    static final class SIPOPModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long popIDIndex;
        public long popNameIndex;
        public long isPOPCheckedIndex;
        public long districtIdIndex;
        public long mandalIDIndex;

        SIPOPModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.popIDIndex = getValidColumnIndex(path, table, "SIPOPModel", "popID");
            indicesMap.put("popID", this.popIDIndex);
            this.popNameIndex = getValidColumnIndex(path, table, "SIPOPModel", "popName");
            indicesMap.put("popName", this.popNameIndex);
            this.isPOPCheckedIndex = getValidColumnIndex(path, table, "SIPOPModel", "isPOPChecked");
            indicesMap.put("isPOPChecked", this.isPOPCheckedIndex);
            this.districtIdIndex = getValidColumnIndex(path, table, "SIPOPModel", "districtId");
            indicesMap.put("districtId", this.districtIdIndex);
            this.mandalIDIndex = getValidColumnIndex(path, table, "SIPOPModel", "mandalID");
            indicesMap.put("mandalID", this.mandalIDIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final SIPOPModelColumnInfo otherInfo = (SIPOPModelColumnInfo) other;
            this.popIDIndex = otherInfo.popIDIndex;
            this.popNameIndex = otherInfo.popNameIndex;
            this.isPOPCheckedIndex = otherInfo.isPOPCheckedIndex;
            this.districtIdIndex = otherInfo.districtIdIndex;
            this.mandalIDIndex = otherInfo.mandalIDIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final SIPOPModelColumnInfo clone() {
            return (SIPOPModelColumnInfo) super.clone();
        }

    }
    private SIPOPModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("popID");
        fieldNames.add("popName");
        fieldNames.add("isPOPChecked");
        fieldNames.add("districtId");
        fieldNames.add("mandalID");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SIPOPModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SIPOPModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.SIPOPModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'popID' cannot be changed after object was created.");
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
    public boolean realmGet$isPOPChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isPOPCheckedIndex);
    }

    public void realmSet$isPOPChecked(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isPOPCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isPOPCheckedIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$districtId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.districtIdIndex);
    }

    public void realmSet$districtId(String value) {
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
                row.getTable().setNull(columnInfo.districtIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.districtIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.districtIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.districtIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$mandalID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mandalIDIndex);
    }

    public void realmSet$mandalID(String value) {
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
                row.getTable().setNull(columnInfo.mandalIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mandalIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mandalIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mandalIDIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("SIPOPModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("SIPOPModel");
            realmObjectSchema.add(new Property("popID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isPOPChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("districtId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("SIPOPModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_SIPOPModel")) {
            Table table = sharedRealm.getTable("class_SIPOPModel");
            table.addColumn(RealmFieldType.STRING, "popID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popName", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isPOPChecked", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "districtId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mandalID", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("popID"));
            table.setPrimaryKey("popID");
            return table;
        }
        return sharedRealm.getTable("class_SIPOPModel");
    }

    public static SIPOPModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SIPOPModel")) {
            Table table = sharedRealm.getTable("class_SIPOPModel");
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

            final SIPOPModelColumnInfo columnInfo = new SIPOPModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("popID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'popID' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("popID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'popID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("popID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'popID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            if (!columnTypes.containsKey("isPOPChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isPOPChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isPOPChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isPOPChecked' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isPOPCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isPOPChecked' does support null values in the existing Realm file. Use corresponding boxed type for field 'isPOPChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("districtId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtId' is required. Either set @Required to field 'districtId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("mandalID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mandalID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mandalID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mandalID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.mandalIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mandalID' is required. Either set @Required to field 'mandalID' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SIPOPModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SIPOPModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.SIPOPModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.SIPOPModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.SIPOPModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("popID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("popID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SIPOPModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.SIPOPModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("popID")) {
                if (json.isNull("popID")) {
                    obj = (io.realm.SIPOPModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SIPOPModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.SIPOPModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SIPOPModel.class, json.getString("popID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'popID'.");
            }
        }
        if (json.has("popName")) {
            if (json.isNull("popName")) {
                ((SIPOPModelRealmProxyInterface) obj).realmSet$popName(null);
            } else {
                ((SIPOPModelRealmProxyInterface) obj).realmSet$popName((String) json.getString("popName"));
            }
        }
        if (json.has("isPOPChecked")) {
            if (json.isNull("isPOPChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isPOPChecked' to null.");
            } else {
                ((SIPOPModelRealmProxyInterface) obj).realmSet$isPOPChecked((boolean) json.getBoolean("isPOPChecked"));
            }
        }
        if (json.has("districtId")) {
            if (json.isNull("districtId")) {
                ((SIPOPModelRealmProxyInterface) obj).realmSet$districtId(null);
            } else {
                ((SIPOPModelRealmProxyInterface) obj).realmSet$districtId((String) json.getString("districtId"));
            }
        }
        if (json.has("mandalID")) {
            if (json.isNull("mandalID")) {
                ((SIPOPModelRealmProxyInterface) obj).realmSet$mandalID(null);
            } else {
                ((SIPOPModelRealmProxyInterface) obj).realmSet$mandalID((String) json.getString("mandalID"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.SIPOPModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.SIPOPModel obj = new com.app.apsfl.models.SIPOPModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("popID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$popID(null);
                } else {
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$popID((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("popName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$popName(null);
                } else {
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$popName((String) reader.nextString());
                }
            } else if (name.equals("isPOPChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isPOPChecked' to null.");
                } else {
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$isPOPChecked((boolean) reader.nextBoolean());
                }
            } else if (name.equals("districtId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$districtId(null);
                } else {
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$districtId((String) reader.nextString());
                }
            } else if (name.equals("mandalID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$mandalID(null);
                } else {
                    ((SIPOPModelRealmProxyInterface) obj).realmSet$mandalID((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'popID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.SIPOPModel copyOrUpdate(Realm realm, com.app.apsfl.models.SIPOPModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SIPOPModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.SIPOPModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.SIPOPModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((SIPOPModelRealmProxyInterface) object).realmGet$popID();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SIPOPModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.SIPOPModelRealmProxy();
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

    public static com.app.apsfl.models.SIPOPModel copy(Realm realm, com.app.apsfl.models.SIPOPModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SIPOPModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.SIPOPModel realmObject = realm.createObjectInternal(com.app.apsfl.models.SIPOPModel.class, ((SIPOPModelRealmProxyInterface) newObject).realmGet$popID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SIPOPModelRealmProxyInterface) realmObject).realmSet$popName(((SIPOPModelRealmProxyInterface) newObject).realmGet$popName());
            ((SIPOPModelRealmProxyInterface) realmObject).realmSet$isPOPChecked(((SIPOPModelRealmProxyInterface) newObject).realmGet$isPOPChecked());
            ((SIPOPModelRealmProxyInterface) realmObject).realmSet$districtId(((SIPOPModelRealmProxyInterface) newObject).realmGet$districtId());
            ((SIPOPModelRealmProxyInterface) realmObject).realmSet$mandalID(((SIPOPModelRealmProxyInterface) newObject).realmGet$mandalID());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.SIPOPModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SIPOPModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIPOPModelColumnInfo columnInfo = (SIPOPModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIPOPModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SIPOPModelRealmProxyInterface) object).realmGet$popID();
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
        String realmGet$popName = ((SIPOPModelRealmProxyInterface)object).realmGet$popName();
        if (realmGet$popName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isPOPCheckedIndex, rowIndex, ((SIPOPModelRealmProxyInterface)object).realmGet$isPOPChecked(), false);
        String realmGet$districtId = ((SIPOPModelRealmProxyInterface)object).realmGet$districtId();
        if (realmGet$districtId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtIdIndex, rowIndex, realmGet$districtId, false);
        }
        String realmGet$mandalID = ((SIPOPModelRealmProxyInterface)object).realmGet$mandalID();
        if (realmGet$mandalID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SIPOPModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIPOPModelColumnInfo columnInfo = (SIPOPModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIPOPModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SIPOPModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SIPOPModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SIPOPModelRealmProxyInterface) object).realmGet$popID();
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
                String realmGet$popName = ((SIPOPModelRealmProxyInterface)object).realmGet$popName();
                if (realmGet$popName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isPOPCheckedIndex, rowIndex, ((SIPOPModelRealmProxyInterface)object).realmGet$isPOPChecked(), false);
                String realmGet$districtId = ((SIPOPModelRealmProxyInterface)object).realmGet$districtId();
                if (realmGet$districtId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtIdIndex, rowIndex, realmGet$districtId, false);
                }
                String realmGet$mandalID = ((SIPOPModelRealmProxyInterface)object).realmGet$mandalID();
                if (realmGet$mandalID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.SIPOPModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SIPOPModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIPOPModelColumnInfo columnInfo = (SIPOPModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIPOPModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SIPOPModelRealmProxyInterface) object).realmGet$popID();
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
        String realmGet$popName = ((SIPOPModelRealmProxyInterface)object).realmGet$popName();
        if (realmGet$popName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popNameIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isPOPCheckedIndex, rowIndex, ((SIPOPModelRealmProxyInterface)object).realmGet$isPOPChecked(), false);
        String realmGet$districtId = ((SIPOPModelRealmProxyInterface)object).realmGet$districtId();
        if (realmGet$districtId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtIdIndex, rowIndex, realmGet$districtId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.districtIdIndex, rowIndex, false);
        }
        String realmGet$mandalID = ((SIPOPModelRealmProxyInterface)object).realmGet$mandalID();
        if (realmGet$mandalID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SIPOPModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIPOPModelColumnInfo columnInfo = (SIPOPModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIPOPModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SIPOPModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SIPOPModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SIPOPModelRealmProxyInterface) object).realmGet$popID();
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
                String realmGet$popName = ((SIPOPModelRealmProxyInterface)object).realmGet$popName();
                if (realmGet$popName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popNameIndex, rowIndex, realmGet$popName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popNameIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isPOPCheckedIndex, rowIndex, ((SIPOPModelRealmProxyInterface)object).realmGet$isPOPChecked(), false);
                String realmGet$districtId = ((SIPOPModelRealmProxyInterface)object).realmGet$districtId();
                if (realmGet$districtId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtIdIndex, rowIndex, realmGet$districtId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.districtIdIndex, rowIndex, false);
                }
                String realmGet$mandalID = ((SIPOPModelRealmProxyInterface)object).realmGet$mandalID();
                if (realmGet$mandalID != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, realmGet$mandalID, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mandalIDIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.SIPOPModel createDetachedCopy(com.app.apsfl.models.SIPOPModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.SIPOPModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.SIPOPModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.SIPOPModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.SIPOPModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((SIPOPModelRealmProxyInterface) unmanagedObject).realmSet$popID(((SIPOPModelRealmProxyInterface) realmObject).realmGet$popID());
        ((SIPOPModelRealmProxyInterface) unmanagedObject).realmSet$popName(((SIPOPModelRealmProxyInterface) realmObject).realmGet$popName());
        ((SIPOPModelRealmProxyInterface) unmanagedObject).realmSet$isPOPChecked(((SIPOPModelRealmProxyInterface) realmObject).realmGet$isPOPChecked());
        ((SIPOPModelRealmProxyInterface) unmanagedObject).realmSet$districtId(((SIPOPModelRealmProxyInterface) realmObject).realmGet$districtId());
        ((SIPOPModelRealmProxyInterface) unmanagedObject).realmSet$mandalID(((SIPOPModelRealmProxyInterface) realmObject).realmGet$mandalID());
        return unmanagedObject;
    }

    static com.app.apsfl.models.SIPOPModel update(Realm realm, com.app.apsfl.models.SIPOPModel realmObject, com.app.apsfl.models.SIPOPModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((SIPOPModelRealmProxyInterface) realmObject).realmSet$popName(((SIPOPModelRealmProxyInterface) newObject).realmGet$popName());
        ((SIPOPModelRealmProxyInterface) realmObject).realmSet$isPOPChecked(((SIPOPModelRealmProxyInterface) newObject).realmGet$isPOPChecked());
        ((SIPOPModelRealmProxyInterface) realmObject).realmSet$districtId(((SIPOPModelRealmProxyInterface) newObject).realmGet$districtId());
        ((SIPOPModelRealmProxyInterface) realmObject).realmSet$mandalID(((SIPOPModelRealmProxyInterface) newObject).realmGet$mandalID());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SIPOPModel = [");
        stringBuilder.append("{popID:");
        stringBuilder.append(realmGet$popID() != null ? realmGet$popID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popName:");
        stringBuilder.append(realmGet$popName() != null ? realmGet$popName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isPOPChecked:");
        stringBuilder.append(realmGet$isPOPChecked());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{districtId:");
        stringBuilder.append(realmGet$districtId() != null ? realmGet$districtId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mandalID:");
        stringBuilder.append(realmGet$mandalID() != null ? realmGet$mandalID() : "null");
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
        SIPOPModelRealmProxy aSIPOPModel = (SIPOPModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSIPOPModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSIPOPModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSIPOPModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
