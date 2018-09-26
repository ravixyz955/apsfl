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

public class IptvSIDataModelRealmProxy extends com.app.apsfl.models.IptvSIDataModel
    implements RealmObjectProxy, IptvSIDataModelRealmProxyInterface {

    static final class IptvSIDataModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long iptvpositionApsflTrackIdIndex;
        public long apsflTrackIdIndex;
        public long iptvpositionIndex;
        public long iptvBoxModelIndex;
        public long ipTVSerialNumberIndex;
        public long stbModelPositionIndex;
        public long isSTBCheckedIndex;
        public long iptvPkgIndex;

        IptvSIDataModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(8);
            this.iptvpositionApsflTrackIdIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "iptvpositionApsflTrackId");
            indicesMap.put("iptvpositionApsflTrackId", this.iptvpositionApsflTrackIdIndex);
            this.apsflTrackIdIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "apsflTrackId");
            indicesMap.put("apsflTrackId", this.apsflTrackIdIndex);
            this.iptvpositionIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "iptvposition");
            indicesMap.put("iptvposition", this.iptvpositionIndex);
            this.iptvBoxModelIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "iptvBoxModel");
            indicesMap.put("iptvBoxModel", this.iptvBoxModelIndex);
            this.ipTVSerialNumberIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "ipTVSerialNumber");
            indicesMap.put("ipTVSerialNumber", this.ipTVSerialNumberIndex);
            this.stbModelPositionIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "stbModelPosition");
            indicesMap.put("stbModelPosition", this.stbModelPositionIndex);
            this.isSTBCheckedIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "isSTBChecked");
            indicesMap.put("isSTBChecked", this.isSTBCheckedIndex);
            this.iptvPkgIndex = getValidColumnIndex(path, table, "IptvSIDataModel", "iptvPkg");
            indicesMap.put("iptvPkg", this.iptvPkgIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final IptvSIDataModelColumnInfo otherInfo = (IptvSIDataModelColumnInfo) other;
            this.iptvpositionApsflTrackIdIndex = otherInfo.iptvpositionApsflTrackIdIndex;
            this.apsflTrackIdIndex = otherInfo.apsflTrackIdIndex;
            this.iptvpositionIndex = otherInfo.iptvpositionIndex;
            this.iptvBoxModelIndex = otherInfo.iptvBoxModelIndex;
            this.ipTVSerialNumberIndex = otherInfo.ipTVSerialNumberIndex;
            this.stbModelPositionIndex = otherInfo.stbModelPositionIndex;
            this.isSTBCheckedIndex = otherInfo.isSTBCheckedIndex;
            this.iptvPkgIndex = otherInfo.iptvPkgIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final IptvSIDataModelColumnInfo clone() {
            return (IptvSIDataModelColumnInfo) super.clone();
        }

    }
    private IptvSIDataModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("iptvpositionApsflTrackId");
        fieldNames.add("apsflTrackId");
        fieldNames.add("iptvposition");
        fieldNames.add("iptvBoxModel");
        fieldNames.add("ipTVSerialNumber");
        fieldNames.add("stbModelPosition");
        fieldNames.add("isSTBChecked");
        fieldNames.add("iptvPkg");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    IptvSIDataModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (IptvSIDataModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.IptvSIDataModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvpositionApsflTrackId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvpositionApsflTrackIdIndex);
    }

    public void realmSet$iptvpositionApsflTrackId(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'iptvpositionApsflTrackId' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$apsflTrackId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.apsflTrackIdIndex);
    }

    public void realmSet$apsflTrackId(String value) {
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
                row.getTable().setNull(columnInfo.apsflTrackIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.apsflTrackIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.apsflTrackIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.apsflTrackIdIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$iptvposition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.iptvpositionIndex);
    }

    public void realmSet$iptvposition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.iptvpositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.iptvpositionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvBoxModel() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvBoxModelIndex);
    }

    public void realmSet$iptvBoxModel(String value) {
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
                row.getTable().setNull(columnInfo.iptvBoxModelIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iptvBoxModelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iptvBoxModelIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iptvBoxModelIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$ipTVSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ipTVSerialNumberIndex);
    }

    public void realmSet$ipTVSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.ipTVSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ipTVSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ipTVSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ipTVSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$stbModelPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.stbModelPositionIndex);
    }

    public void realmSet$stbModelPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.stbModelPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.stbModelPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isSTBChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isSTBCheckedIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isSTBCheckedIndex);
    }

    public void realmSet$isSTBChecked(Boolean value) {
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
                row.getTable().setNull(columnInfo.isSTBCheckedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isSTBCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isSTBCheckedIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isSTBCheckedIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvPkg() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvPkgIndex);
    }

    public void realmSet$iptvPkg(String value) {
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
                row.getTable().setNull(columnInfo.iptvPkgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iptvPkgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iptvPkgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iptvPkgIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("IptvSIDataModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("IptvSIDataModel");
            realmObjectSchema.add(new Property("iptvpositionApsflTrackId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("apsflTrackId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvposition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvBoxModel", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("ipTVSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("stbModelPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("isSTBChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvPkg", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("IptvSIDataModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_IptvSIDataModel")) {
            Table table = sharedRealm.getTable("class_IptvSIDataModel");
            table.addColumn(RealmFieldType.STRING, "iptvpositionApsflTrackId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "apsflTrackId", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "iptvposition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvBoxModel", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "ipTVSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "stbModelPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isSTBChecked", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvPkg", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("iptvpositionApsflTrackId"));
            table.setPrimaryKey("iptvpositionApsflTrackId");
            return table;
        }
        return sharedRealm.getTable("class_IptvSIDataModel");
    }

    public static IptvSIDataModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_IptvSIDataModel")) {
            Table table = sharedRealm.getTable("class_IptvSIDataModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 8) {
                if (columnCount < 8) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 8 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 8 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 8 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 8; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final IptvSIDataModelColumnInfo columnInfo = new IptvSIDataModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("iptvpositionApsflTrackId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvpositionApsflTrackId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvpositionApsflTrackId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvpositionApsflTrackId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvpositionApsflTrackIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'iptvpositionApsflTrackId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("iptvpositionApsflTrackId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'iptvpositionApsflTrackId' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("iptvpositionApsflTrackId"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'iptvpositionApsflTrackId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("apsflTrackId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'apsflTrackId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("apsflTrackId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'apsflTrackId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.apsflTrackIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'apsflTrackId' is required. Either set @Required to field 'apsflTrackId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvposition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvposition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvposition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'iptvposition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.iptvpositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvposition' does support null values in the existing Realm file. Use corresponding boxed type for field 'iptvposition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvBoxModel")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvBoxModel' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvBoxModel") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvBoxModel' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvBoxModelIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvBoxModel' is required. Either set @Required to field 'iptvBoxModel' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("ipTVSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'ipTVSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("ipTVSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'ipTVSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.ipTVSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'ipTVSerialNumber' is required. Either set @Required to field 'ipTVSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("stbModelPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stbModelPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("stbModelPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'stbModelPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.stbModelPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'stbModelPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'stbModelPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isSTBChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isSTBChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isSTBChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isSTBChecked' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isSTBCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isSTBChecked' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isSTBChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvPkg")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvPkg' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvPkg") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvPkg' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvPkgIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvPkg' is required. Either set @Required to field 'iptvPkg' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'IptvSIDataModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_IptvSIDataModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.IptvSIDataModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.IptvSIDataModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.IptvSIDataModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("iptvpositionApsflTrackId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("iptvpositionApsflTrackId"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.IptvSIDataModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.IptvSIDataModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("iptvpositionApsflTrackId")) {
                if (json.isNull("iptvpositionApsflTrackId")) {
                    obj = (io.realm.IptvSIDataModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.IptvSIDataModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.IptvSIDataModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.IptvSIDataModel.class, json.getString("iptvpositionApsflTrackId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'iptvpositionApsflTrackId'.");
            }
        }
        if (json.has("apsflTrackId")) {
            if (json.isNull("apsflTrackId")) {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$apsflTrackId(null);
            } else {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$apsflTrackId((String) json.getString("apsflTrackId"));
            }
        }
        if (json.has("iptvposition")) {
            if (json.isNull("iptvposition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iptvposition' to null.");
            } else {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvposition((int) json.getInt("iptvposition"));
            }
        }
        if (json.has("iptvBoxModel")) {
            if (json.isNull("iptvBoxModel")) {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel(null);
            } else {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel((String) json.getString("iptvBoxModel"));
            }
        }
        if (json.has("ipTVSerialNumber")) {
            if (json.isNull("ipTVSerialNumber")) {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber(null);
            } else {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber((String) json.getString("ipTVSerialNumber"));
            }
        }
        if (json.has("stbModelPosition")) {
            if (json.isNull("stbModelPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'stbModelPosition' to null.");
            } else {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$stbModelPosition((int) json.getInt("stbModelPosition"));
            }
        }
        if (json.has("isSTBChecked")) {
            if (json.isNull("isSTBChecked")) {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$isSTBChecked(null);
            } else {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$isSTBChecked((boolean) json.getBoolean("isSTBChecked"));
            }
        }
        if (json.has("iptvPkg")) {
            if (json.isNull("iptvPkg")) {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvPkg(null);
            } else {
                ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvPkg((String) json.getString("iptvPkg"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.IptvSIDataModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.IptvSIDataModel obj = new com.app.apsfl.models.IptvSIDataModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("iptvpositionApsflTrackId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvpositionApsflTrackId(null);
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvpositionApsflTrackId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("apsflTrackId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$apsflTrackId(null);
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$apsflTrackId((String) reader.nextString());
                }
            } else if (name.equals("iptvposition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iptvposition' to null.");
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvposition((int) reader.nextInt());
                }
            } else if (name.equals("iptvBoxModel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel(null);
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel((String) reader.nextString());
                }
            } else if (name.equals("ipTVSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber(null);
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("stbModelPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'stbModelPosition' to null.");
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$stbModelPosition((int) reader.nextInt());
                }
            } else if (name.equals("isSTBChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$isSTBChecked(null);
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$isSTBChecked((boolean) reader.nextBoolean());
                }
            } else if (name.equals("iptvPkg")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvPkg(null);
                } else {
                    ((IptvSIDataModelRealmProxyInterface) obj).realmSet$iptvPkg((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'iptvpositionApsflTrackId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.IptvSIDataModel copyOrUpdate(Realm realm, com.app.apsfl.models.IptvSIDataModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.IptvSIDataModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.IptvSIDataModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.IptvSIDataModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((IptvSIDataModelRealmProxyInterface) object).realmGet$iptvpositionApsflTrackId();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.IptvSIDataModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.IptvSIDataModelRealmProxy();
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

    public static com.app.apsfl.models.IptvSIDataModel copy(Realm realm, com.app.apsfl.models.IptvSIDataModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.IptvSIDataModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.IptvSIDataModel realmObject = realm.createObjectInternal(com.app.apsfl.models.IptvSIDataModel.class, ((IptvSIDataModelRealmProxyInterface) newObject).realmGet$iptvpositionApsflTrackId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$apsflTrackId(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$apsflTrackId());
            ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$iptvposition(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$iptvposition());
            ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$iptvBoxModel(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$iptvBoxModel());
            ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$ipTVSerialNumber(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$ipTVSerialNumber());
            ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$stbModelPosition(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$stbModelPosition());
            ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$isSTBChecked(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$isSTBChecked());
            ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$iptvPkg(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$iptvPkg());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.IptvSIDataModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.IptvSIDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvSIDataModelColumnInfo columnInfo = (IptvSIDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvSIDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((IptvSIDataModelRealmProxyInterface) object).realmGet$iptvpositionApsflTrackId();
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
        String realmGet$apsflTrackId = ((IptvSIDataModelRealmProxyInterface)object).realmGet$apsflTrackId();
        if (realmGet$apsflTrackId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.apsflTrackIdIndex, rowIndex, realmGet$apsflTrackId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
        String realmGet$iptvBoxModel = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
        if (realmGet$iptvBoxModel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
        }
        String realmGet$ipTVSerialNumber = ((IptvSIDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
        if (realmGet$ipTVSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
        Boolean realmGet$isSTBChecked = ((IptvSIDataModelRealmProxyInterface)object).realmGet$isSTBChecked();
        if (realmGet$isSTBChecked != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSTBCheckedIndex, rowIndex, realmGet$isSTBChecked, false);
        }
        String realmGet$iptvPkg = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvPkg();
        if (realmGet$iptvPkg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.IptvSIDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvSIDataModelColumnInfo columnInfo = (IptvSIDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvSIDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.IptvSIDataModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.IptvSIDataModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((IptvSIDataModelRealmProxyInterface) object).realmGet$iptvpositionApsflTrackId();
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
                String realmGet$apsflTrackId = ((IptvSIDataModelRealmProxyInterface)object).realmGet$apsflTrackId();
                if (realmGet$apsflTrackId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.apsflTrackIdIndex, rowIndex, realmGet$apsflTrackId, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
                String realmGet$iptvBoxModel = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
                if (realmGet$iptvBoxModel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
                }
                String realmGet$ipTVSerialNumber = ((IptvSIDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
                if (realmGet$ipTVSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
                Boolean realmGet$isSTBChecked = ((IptvSIDataModelRealmProxyInterface)object).realmGet$isSTBChecked();
                if (realmGet$isSTBChecked != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isSTBCheckedIndex, rowIndex, realmGet$isSTBChecked, false);
                }
                String realmGet$iptvPkg = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvPkg();
                if (realmGet$iptvPkg != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.IptvSIDataModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.IptvSIDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvSIDataModelColumnInfo columnInfo = (IptvSIDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvSIDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((IptvSIDataModelRealmProxyInterface) object).realmGet$iptvpositionApsflTrackId();
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
        String realmGet$apsflTrackId = ((IptvSIDataModelRealmProxyInterface)object).realmGet$apsflTrackId();
        if (realmGet$apsflTrackId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.apsflTrackIdIndex, rowIndex, realmGet$apsflTrackId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.apsflTrackIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
        String realmGet$iptvBoxModel = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
        if (realmGet$iptvBoxModel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, false);
        }
        String realmGet$ipTVSerialNumber = ((IptvSIDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
        if (realmGet$ipTVSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
        Boolean realmGet$isSTBChecked = ((IptvSIDataModelRealmProxyInterface)object).realmGet$isSTBChecked();
        if (realmGet$isSTBChecked != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSTBCheckedIndex, rowIndex, realmGet$isSTBChecked, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isSTBCheckedIndex, rowIndex, false);
        }
        String realmGet$iptvPkg = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvPkg();
        if (realmGet$iptvPkg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.IptvSIDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvSIDataModelColumnInfo columnInfo = (IptvSIDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvSIDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.IptvSIDataModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.IptvSIDataModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((IptvSIDataModelRealmProxyInterface) object).realmGet$iptvpositionApsflTrackId();
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
                String realmGet$apsflTrackId = ((IptvSIDataModelRealmProxyInterface)object).realmGet$apsflTrackId();
                if (realmGet$apsflTrackId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.apsflTrackIdIndex, rowIndex, realmGet$apsflTrackId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.apsflTrackIdIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
                String realmGet$iptvBoxModel = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
                if (realmGet$iptvBoxModel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, false);
                }
                String realmGet$ipTVSerialNumber = ((IptvSIDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
                if (realmGet$ipTVSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvSIDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
                Boolean realmGet$isSTBChecked = ((IptvSIDataModelRealmProxyInterface)object).realmGet$isSTBChecked();
                if (realmGet$isSTBChecked != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isSTBCheckedIndex, rowIndex, realmGet$isSTBChecked, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isSTBCheckedIndex, rowIndex, false);
                }
                String realmGet$iptvPkg = ((IptvSIDataModelRealmProxyInterface)object).realmGet$iptvPkg();
                if (realmGet$iptvPkg != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.IptvSIDataModel createDetachedCopy(com.app.apsfl.models.IptvSIDataModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.IptvSIDataModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.IptvSIDataModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.IptvSIDataModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.IptvSIDataModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvpositionApsflTrackId(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$iptvpositionApsflTrackId());
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$apsflTrackId(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$apsflTrackId());
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvposition(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$iptvposition());
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvBoxModel(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$iptvBoxModel());
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$ipTVSerialNumber(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$ipTVSerialNumber());
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$stbModelPosition(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$stbModelPosition());
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$isSTBChecked(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$isSTBChecked());
        ((IptvSIDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvPkg(((IptvSIDataModelRealmProxyInterface) realmObject).realmGet$iptvPkg());
        return unmanagedObject;
    }

    static com.app.apsfl.models.IptvSIDataModel update(Realm realm, com.app.apsfl.models.IptvSIDataModel realmObject, com.app.apsfl.models.IptvSIDataModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$apsflTrackId(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$apsflTrackId());
        ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$iptvposition(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$iptvposition());
        ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$iptvBoxModel(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$iptvBoxModel());
        ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$ipTVSerialNumber(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$ipTVSerialNumber());
        ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$stbModelPosition(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$stbModelPosition());
        ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$isSTBChecked(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$isSTBChecked());
        ((IptvSIDataModelRealmProxyInterface) realmObject).realmSet$iptvPkg(((IptvSIDataModelRealmProxyInterface) newObject).realmGet$iptvPkg());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("IptvSIDataModel = [");
        stringBuilder.append("{iptvpositionApsflTrackId:");
        stringBuilder.append(realmGet$iptvpositionApsflTrackId() != null ? realmGet$iptvpositionApsflTrackId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{apsflTrackId:");
        stringBuilder.append(realmGet$apsflTrackId() != null ? realmGet$apsflTrackId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iptvposition:");
        stringBuilder.append(realmGet$iptvposition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iptvBoxModel:");
        stringBuilder.append(realmGet$iptvBoxModel() != null ? realmGet$iptvBoxModel() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ipTVSerialNumber:");
        stringBuilder.append(realmGet$ipTVSerialNumber() != null ? realmGet$ipTVSerialNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stbModelPosition:");
        stringBuilder.append(realmGet$stbModelPosition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isSTBChecked:");
        stringBuilder.append(realmGet$isSTBChecked() != null ? realmGet$isSTBChecked() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iptvPkg:");
        stringBuilder.append(realmGet$iptvPkg() != null ? realmGet$iptvPkg() : "null");
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
        IptvSIDataModelRealmProxy aIptvSIDataModel = (IptvSIDataModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aIptvSIDataModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aIptvSIDataModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aIptvSIDataModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
