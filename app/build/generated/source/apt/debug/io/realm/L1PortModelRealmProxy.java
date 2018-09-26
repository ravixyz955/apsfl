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

public class L1PortModelRealmProxy extends com.app.apsfl.models.L1PortModel
    implements RealmObjectProxy, L1PortModelRealmProxyInterface {

    static final class L1PortModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long oltL1PortIndex;
        public long oltPortNumberIndex;
        public long l1PortNumbersIndex;
        public long popIdPortnoIndex;

        L1PortModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.oltL1PortIndex = getValidColumnIndex(path, table, "L1PortModel", "oltL1Port");
            indicesMap.put("oltL1Port", this.oltL1PortIndex);
            this.oltPortNumberIndex = getValidColumnIndex(path, table, "L1PortModel", "oltPortNumber");
            indicesMap.put("oltPortNumber", this.oltPortNumberIndex);
            this.l1PortNumbersIndex = getValidColumnIndex(path, table, "L1PortModel", "l1PortNumbers");
            indicesMap.put("l1PortNumbers", this.l1PortNumbersIndex);
            this.popIdPortnoIndex = getValidColumnIndex(path, table, "L1PortModel", "popIdPortno");
            indicesMap.put("popIdPortno", this.popIdPortnoIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final L1PortModelColumnInfo otherInfo = (L1PortModelColumnInfo) other;
            this.oltL1PortIndex = otherInfo.oltL1PortIndex;
            this.oltPortNumberIndex = otherInfo.oltPortNumberIndex;
            this.l1PortNumbersIndex = otherInfo.l1PortNumbersIndex;
            this.popIdPortnoIndex = otherInfo.popIdPortnoIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final L1PortModelColumnInfo clone() {
            return (L1PortModelColumnInfo) super.clone();
        }

    }
    private L1PortModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("oltL1Port");
        fieldNames.add("oltPortNumber");
        fieldNames.add("l1PortNumbers");
        fieldNames.add("popIdPortno");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    L1PortModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (L1PortModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.L1PortModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$oltL1Port() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.oltL1PortIndex);
    }

    public void realmSet$oltL1Port(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'oltL1Port' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$oltPortNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.oltPortNumberIndex);
    }

    public void realmSet$oltPortNumber(String value) {
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
                row.getTable().setNull(columnInfo.oltPortNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.oltPortNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.oltPortNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.oltPortNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$l1PortNumbers() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.l1PortNumbersIndex);
    }

    public void realmSet$l1PortNumbers(String value) {
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
                row.getTable().setNull(columnInfo.l1PortNumbersIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.l1PortNumbersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.l1PortNumbersIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.l1PortNumbersIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popIdPortno() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popIdPortnoIndex);
    }

    public void realmSet$popIdPortno(String value) {
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
                row.getTable().setNull(columnInfo.popIdPortnoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popIdPortnoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popIdPortnoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popIdPortnoIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("L1PortModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("L1PortModel");
            realmObjectSchema.add(new Property("oltL1Port", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("oltPortNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("l1PortNumbers", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popIdPortno", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("L1PortModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_L1PortModel")) {
            Table table = sharedRealm.getTable("class_L1PortModel");
            table.addColumn(RealmFieldType.STRING, "oltL1Port", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "oltPortNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "l1PortNumbers", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popIdPortno", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("oltL1Port"));
            table.setPrimaryKey("oltL1Port");
            return table;
        }
        return sharedRealm.getTable("class_L1PortModel");
    }

    public static L1PortModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_L1PortModel")) {
            Table table = sharedRealm.getTable("class_L1PortModel");
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

            final L1PortModelColumnInfo columnInfo = new L1PortModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("oltL1Port")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'oltL1Port' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("oltL1Port") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'oltL1Port' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.oltL1PortIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'oltL1Port' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("oltL1Port")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'oltL1Port' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("oltL1Port"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'oltL1Port' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("oltPortNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'oltPortNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("oltPortNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'oltPortNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.oltPortNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'oltPortNumber' is required. Either set @Required to field 'oltPortNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("l1PortNumbers")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'l1PortNumbers' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("l1PortNumbers") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'l1PortNumbers' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.l1PortNumbersIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'l1PortNumbers' is required. Either set @Required to field 'l1PortNumbers' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popIdPortno")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popIdPortno' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popIdPortno") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popIdPortno' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popIdPortnoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popIdPortno' is required. Either set @Required to field 'popIdPortno' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'L1PortModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_L1PortModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.L1PortModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.L1PortModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.L1PortModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("oltL1Port")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("oltL1Port"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.L1PortModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.L1PortModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("oltL1Port")) {
                if (json.isNull("oltL1Port")) {
                    obj = (io.realm.L1PortModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.L1PortModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.L1PortModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.L1PortModel.class, json.getString("oltL1Port"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'oltL1Port'.");
            }
        }
        if (json.has("oltPortNumber")) {
            if (json.isNull("oltPortNumber")) {
                ((L1PortModelRealmProxyInterface) obj).realmSet$oltPortNumber(null);
            } else {
                ((L1PortModelRealmProxyInterface) obj).realmSet$oltPortNumber((String) json.getString("oltPortNumber"));
            }
        }
        if (json.has("l1PortNumbers")) {
            if (json.isNull("l1PortNumbers")) {
                ((L1PortModelRealmProxyInterface) obj).realmSet$l1PortNumbers(null);
            } else {
                ((L1PortModelRealmProxyInterface) obj).realmSet$l1PortNumbers((String) json.getString("l1PortNumbers"));
            }
        }
        if (json.has("popIdPortno")) {
            if (json.isNull("popIdPortno")) {
                ((L1PortModelRealmProxyInterface) obj).realmSet$popIdPortno(null);
            } else {
                ((L1PortModelRealmProxyInterface) obj).realmSet$popIdPortno((String) json.getString("popIdPortno"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.L1PortModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.L1PortModel obj = new com.app.apsfl.models.L1PortModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("oltL1Port")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L1PortModelRealmProxyInterface) obj).realmSet$oltL1Port(null);
                } else {
                    ((L1PortModelRealmProxyInterface) obj).realmSet$oltL1Port((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("oltPortNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L1PortModelRealmProxyInterface) obj).realmSet$oltPortNumber(null);
                } else {
                    ((L1PortModelRealmProxyInterface) obj).realmSet$oltPortNumber((String) reader.nextString());
                }
            } else if (name.equals("l1PortNumbers")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L1PortModelRealmProxyInterface) obj).realmSet$l1PortNumbers(null);
                } else {
                    ((L1PortModelRealmProxyInterface) obj).realmSet$l1PortNumbers((String) reader.nextString());
                }
            } else if (name.equals("popIdPortno")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((L1PortModelRealmProxyInterface) obj).realmSet$popIdPortno(null);
                } else {
                    ((L1PortModelRealmProxyInterface) obj).realmSet$popIdPortno((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'oltL1Port'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.L1PortModel copyOrUpdate(Realm realm, com.app.apsfl.models.L1PortModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.L1PortModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.L1PortModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.L1PortModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((L1PortModelRealmProxyInterface) object).realmGet$oltL1Port();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.L1PortModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.L1PortModelRealmProxy();
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

    public static com.app.apsfl.models.L1PortModel copy(Realm realm, com.app.apsfl.models.L1PortModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.L1PortModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.L1PortModel realmObject = realm.createObjectInternal(com.app.apsfl.models.L1PortModel.class, ((L1PortModelRealmProxyInterface) newObject).realmGet$oltL1Port(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((L1PortModelRealmProxyInterface) realmObject).realmSet$oltPortNumber(((L1PortModelRealmProxyInterface) newObject).realmGet$oltPortNumber());
            ((L1PortModelRealmProxyInterface) realmObject).realmSet$l1PortNumbers(((L1PortModelRealmProxyInterface) newObject).realmGet$l1PortNumbers());
            ((L1PortModelRealmProxyInterface) realmObject).realmSet$popIdPortno(((L1PortModelRealmProxyInterface) newObject).realmGet$popIdPortno());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.L1PortModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.L1PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L1PortModelColumnInfo columnInfo = (L1PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L1PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((L1PortModelRealmProxyInterface) object).realmGet$oltL1Port();
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
        String realmGet$oltPortNumber = ((L1PortModelRealmProxyInterface)object).realmGet$oltPortNumber();
        if (realmGet$oltPortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
        }
        String realmGet$l1PortNumbers = ((L1PortModelRealmProxyInterface)object).realmGet$l1PortNumbers();
        if (realmGet$l1PortNumbers != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumbersIndex, rowIndex, realmGet$l1PortNumbers, false);
        }
        String realmGet$popIdPortno = ((L1PortModelRealmProxyInterface)object).realmGet$popIdPortno();
        if (realmGet$popIdPortno != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIdPortnoIndex, rowIndex, realmGet$popIdPortno, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.L1PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L1PortModelColumnInfo columnInfo = (L1PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L1PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.L1PortModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.L1PortModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((L1PortModelRealmProxyInterface) object).realmGet$oltL1Port();
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
                String realmGet$oltPortNumber = ((L1PortModelRealmProxyInterface)object).realmGet$oltPortNumber();
                if (realmGet$oltPortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
                }
                String realmGet$l1PortNumbers = ((L1PortModelRealmProxyInterface)object).realmGet$l1PortNumbers();
                if (realmGet$l1PortNumbers != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumbersIndex, rowIndex, realmGet$l1PortNumbers, false);
                }
                String realmGet$popIdPortno = ((L1PortModelRealmProxyInterface)object).realmGet$popIdPortno();
                if (realmGet$popIdPortno != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIdPortnoIndex, rowIndex, realmGet$popIdPortno, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.L1PortModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.L1PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L1PortModelColumnInfo columnInfo = (L1PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L1PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((L1PortModelRealmProxyInterface) object).realmGet$oltL1Port();
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
        String realmGet$oltPortNumber = ((L1PortModelRealmProxyInterface)object).realmGet$oltPortNumber();
        if (realmGet$oltPortNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, false);
        }
        String realmGet$l1PortNumbers = ((L1PortModelRealmProxyInterface)object).realmGet$l1PortNumbers();
        if (realmGet$l1PortNumbers != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumbersIndex, rowIndex, realmGet$l1PortNumbers, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.l1PortNumbersIndex, rowIndex, false);
        }
        String realmGet$popIdPortno = ((L1PortModelRealmProxyInterface)object).realmGet$popIdPortno();
        if (realmGet$popIdPortno != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIdPortnoIndex, rowIndex, realmGet$popIdPortno, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popIdPortnoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.L1PortModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        L1PortModelColumnInfo columnInfo = (L1PortModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.L1PortModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.L1PortModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.L1PortModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((L1PortModelRealmProxyInterface) object).realmGet$oltL1Port();
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
                String realmGet$oltPortNumber = ((L1PortModelRealmProxyInterface)object).realmGet$oltPortNumber();
                if (realmGet$oltPortNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, realmGet$oltPortNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.oltPortNumberIndex, rowIndex, false);
                }
                String realmGet$l1PortNumbers = ((L1PortModelRealmProxyInterface)object).realmGet$l1PortNumbers();
                if (realmGet$l1PortNumbers != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.l1PortNumbersIndex, rowIndex, realmGet$l1PortNumbers, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.l1PortNumbersIndex, rowIndex, false);
                }
                String realmGet$popIdPortno = ((L1PortModelRealmProxyInterface)object).realmGet$popIdPortno();
                if (realmGet$popIdPortno != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIdPortnoIndex, rowIndex, realmGet$popIdPortno, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popIdPortnoIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.L1PortModel createDetachedCopy(com.app.apsfl.models.L1PortModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.L1PortModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.L1PortModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.L1PortModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.L1PortModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((L1PortModelRealmProxyInterface) unmanagedObject).realmSet$oltL1Port(((L1PortModelRealmProxyInterface) realmObject).realmGet$oltL1Port());
        ((L1PortModelRealmProxyInterface) unmanagedObject).realmSet$oltPortNumber(((L1PortModelRealmProxyInterface) realmObject).realmGet$oltPortNumber());
        ((L1PortModelRealmProxyInterface) unmanagedObject).realmSet$l1PortNumbers(((L1PortModelRealmProxyInterface) realmObject).realmGet$l1PortNumbers());
        ((L1PortModelRealmProxyInterface) unmanagedObject).realmSet$popIdPortno(((L1PortModelRealmProxyInterface) realmObject).realmGet$popIdPortno());
        return unmanagedObject;
    }

    static com.app.apsfl.models.L1PortModel update(Realm realm, com.app.apsfl.models.L1PortModel realmObject, com.app.apsfl.models.L1PortModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((L1PortModelRealmProxyInterface) realmObject).realmSet$oltPortNumber(((L1PortModelRealmProxyInterface) newObject).realmGet$oltPortNumber());
        ((L1PortModelRealmProxyInterface) realmObject).realmSet$l1PortNumbers(((L1PortModelRealmProxyInterface) newObject).realmGet$l1PortNumbers());
        ((L1PortModelRealmProxyInterface) realmObject).realmSet$popIdPortno(((L1PortModelRealmProxyInterface) newObject).realmGet$popIdPortno());
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
        L1PortModelRealmProxy aL1PortModel = (L1PortModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aL1PortModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aL1PortModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aL1PortModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
