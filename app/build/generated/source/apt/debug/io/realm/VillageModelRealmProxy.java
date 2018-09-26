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

public class VillageModelRealmProxy extends com.app.apsfl.models.VillageModel
    implements RealmObjectProxy, VillageModelRealmProxyInterface {

    static final class VillageModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long subStationUIDIndex;
        public long villageCompositeKeyIndex;
        public long villageSerialNumberIndex;
        public long villageNameIndex;
        public long mandalSerialNumberIndex;
        public long mandalNameIndex;
        public long districtSerialNumberIndex;
        public long districtNameIndex;
        public long isVillageCheckedIndex;
        public long regionIndex;

        VillageModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(10);
            this.subStationUIDIndex = getValidColumnIndex(path, table, "VillageModel", "subStationUID");
            indicesMap.put("subStationUID", this.subStationUIDIndex);
            this.villageCompositeKeyIndex = getValidColumnIndex(path, table, "VillageModel", "villageCompositeKey");
            indicesMap.put("villageCompositeKey", this.villageCompositeKeyIndex);
            this.villageSerialNumberIndex = getValidColumnIndex(path, table, "VillageModel", "villageSerialNumber");
            indicesMap.put("villageSerialNumber", this.villageSerialNumberIndex);
            this.villageNameIndex = getValidColumnIndex(path, table, "VillageModel", "villageName");
            indicesMap.put("villageName", this.villageNameIndex);
            this.mandalSerialNumberIndex = getValidColumnIndex(path, table, "VillageModel", "mandalSerialNumber");
            indicesMap.put("mandalSerialNumber", this.mandalSerialNumberIndex);
            this.mandalNameIndex = getValidColumnIndex(path, table, "VillageModel", "mandalName");
            indicesMap.put("mandalName", this.mandalNameIndex);
            this.districtSerialNumberIndex = getValidColumnIndex(path, table, "VillageModel", "districtSerialNumber");
            indicesMap.put("districtSerialNumber", this.districtSerialNumberIndex);
            this.districtNameIndex = getValidColumnIndex(path, table, "VillageModel", "districtName");
            indicesMap.put("districtName", this.districtNameIndex);
            this.isVillageCheckedIndex = getValidColumnIndex(path, table, "VillageModel", "isVillageChecked");
            indicesMap.put("isVillageChecked", this.isVillageCheckedIndex);
            this.regionIndex = getValidColumnIndex(path, table, "VillageModel", "region");
            indicesMap.put("region", this.regionIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final VillageModelColumnInfo otherInfo = (VillageModelColumnInfo) other;
            this.subStationUIDIndex = otherInfo.subStationUIDIndex;
            this.villageCompositeKeyIndex = otherInfo.villageCompositeKeyIndex;
            this.villageSerialNumberIndex = otherInfo.villageSerialNumberIndex;
            this.villageNameIndex = otherInfo.villageNameIndex;
            this.mandalSerialNumberIndex = otherInfo.mandalSerialNumberIndex;
            this.mandalNameIndex = otherInfo.mandalNameIndex;
            this.districtSerialNumberIndex = otherInfo.districtSerialNumberIndex;
            this.districtNameIndex = otherInfo.districtNameIndex;
            this.isVillageCheckedIndex = otherInfo.isVillageCheckedIndex;
            this.regionIndex = otherInfo.regionIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final VillageModelColumnInfo clone() {
            return (VillageModelColumnInfo) super.clone();
        }

    }
    private VillageModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("subStationUID");
        fieldNames.add("villageCompositeKey");
        fieldNames.add("villageSerialNumber");
        fieldNames.add("villageName");
        fieldNames.add("mandalSerialNumber");
        fieldNames.add("mandalName");
        fieldNames.add("districtSerialNumber");
        fieldNames.add("districtName");
        fieldNames.add("isVillageChecked");
        fieldNames.add("region");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    VillageModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VillageModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.VillageModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$subStationUID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.subStationUIDIndex);
    }

    public void realmSet$subStationUID(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'subStationUID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$villageCompositeKey() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.villageCompositeKeyIndex);
    }

    public void realmSet$villageCompositeKey(String value) {
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
                row.getTable().setNull(columnInfo.villageCompositeKeyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.villageCompositeKeyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.villageCompositeKeyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.villageCompositeKeyIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$villageSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.villageSerialNumberIndex);
    }

    public void realmSet$villageSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.villageSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.villageSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.villageSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.villageSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$villageName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.villageNameIndex);
    }

    public void realmSet$villageName(String value) {
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
                row.getTable().setNull(columnInfo.villageNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.villageNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.villageNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.villageNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$mandalSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mandalSerialNumberIndex);
    }

    public void realmSet$mandalSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.mandalSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mandalSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mandalSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mandalSerialNumberIndex, value);
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
    public String realmGet$districtSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.districtSerialNumberIndex);
    }

    public void realmSet$districtSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.districtSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.districtSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.districtSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.districtSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$districtName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.districtNameIndex);
    }

    public void realmSet$districtName(String value) {
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
                row.getTable().setNull(columnInfo.districtNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.districtNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.districtNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.districtNameIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isVillageChecked() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isVillageCheckedIndex);
    }

    public void realmSet$isVillageChecked(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isVillageCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isVillageCheckedIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$region() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.regionIndex);
    }

    public void realmSet$region(String value) {
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
                row.getTable().setNull(columnInfo.regionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.regionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.regionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.regionIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("VillageModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("VillageModel");
            realmObjectSchema.add(new Property("subStationUID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("villageCompositeKey", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("villageSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("villageName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalName", RealmFieldType.STRING, !Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("districtSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("districtName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isVillageChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("region", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("VillageModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_VillageModel")) {
            Table table = sharedRealm.getTable("class_VillageModel");
            table.addColumn(RealmFieldType.STRING, "subStationUID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "villageCompositeKey", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "villageSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "villageName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mandalSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mandalName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "districtSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "districtName", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isVillageChecked", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "region", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("subStationUID"));
            table.addSearchIndex(table.getColumnIndex("mandalName"));
            table.setPrimaryKey("subStationUID");
            return table;
        }
        return sharedRealm.getTable("class_VillageModel");
    }

    public static VillageModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_VillageModel")) {
            Table table = sharedRealm.getTable("class_VillageModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 10) {
                if (columnCount < 10) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 10 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 10 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 10 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 10; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final VillageModelColumnInfo columnInfo = new VillageModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("subStationUID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'subStationUID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("subStationUID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'subStationUID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.subStationUIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'subStationUID' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("subStationUID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'subStationUID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("subStationUID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'subStationUID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("villageCompositeKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'villageCompositeKey' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("villageCompositeKey") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'villageCompositeKey' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.villageCompositeKeyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'villageCompositeKey' is required. Either set @Required to field 'villageCompositeKey' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("villageSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'villageSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("villageSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'villageSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.villageSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'villageSerialNumber' is required. Either set @Required to field 'villageSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("villageName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'villageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("villageName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'villageName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.villageNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'villageName' is required. Either set @Required to field 'villageName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("mandalSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mandalSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mandalSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mandalSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.mandalSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mandalSerialNumber' is required. Either set @Required to field 'mandalSerialNumber' or migrate using RealmObjectSchema.setNullable().");
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
            if (!table.hasSearchIndex(table.getColumnIndex("mandalName"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'mandalName' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("districtSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtSerialNumber' is required. Either set @Required to field 'districtSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("districtName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtName' is required. Either set @Required to field 'districtName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isVillageChecked")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isVillageChecked' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isVillageChecked") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isVillageChecked' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isVillageCheckedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isVillageChecked' does support null values in the existing Realm file. Use corresponding boxed type for field 'isVillageChecked' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("region")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'region' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("region") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'region' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.regionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'region' is required. Either set @Required to field 'region' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'VillageModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_VillageModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.VillageModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.VillageModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.VillageModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("subStationUID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("subStationUID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.VillageModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.VillageModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("subStationUID")) {
                if (json.isNull("subStationUID")) {
                    obj = (io.realm.VillageModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.VillageModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.VillageModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.VillageModel.class, json.getString("subStationUID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'subStationUID'.");
            }
        }
        if (json.has("villageCompositeKey")) {
            if (json.isNull("villageCompositeKey")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$villageCompositeKey(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$villageCompositeKey((String) json.getString("villageCompositeKey"));
            }
        }
        if (json.has("villageSerialNumber")) {
            if (json.isNull("villageSerialNumber")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber((String) json.getString("villageSerialNumber"));
            }
        }
        if (json.has("villageName")) {
            if (json.isNull("villageName")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$villageName(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$villageName((String) json.getString("villageName"));
            }
        }
        if (json.has("mandalSerialNumber")) {
            if (json.isNull("mandalSerialNumber")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber((String) json.getString("mandalSerialNumber"));
            }
        }
        if (json.has("mandalName")) {
            if (json.isNull("mandalName")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$mandalName(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$mandalName((String) json.getString("mandalName"));
            }
        }
        if (json.has("districtSerialNumber")) {
            if (json.isNull("districtSerialNumber")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber((String) json.getString("districtSerialNumber"));
            }
        }
        if (json.has("districtName")) {
            if (json.isNull("districtName")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$districtName(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$districtName((String) json.getString("districtName"));
            }
        }
        if (json.has("isVillageChecked")) {
            if (json.isNull("isVillageChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isVillageChecked' to null.");
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$isVillageChecked((boolean) json.getBoolean("isVillageChecked"));
            }
        }
        if (json.has("region")) {
            if (json.isNull("region")) {
                ((VillageModelRealmProxyInterface) obj).realmSet$region(null);
            } else {
                ((VillageModelRealmProxyInterface) obj).realmSet$region((String) json.getString("region"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.VillageModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.VillageModel obj = new com.app.apsfl.models.VillageModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("subStationUID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$subStationUID(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$subStationUID((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("villageCompositeKey")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$villageCompositeKey(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$villageCompositeKey((String) reader.nextString());
                }
            } else if (name.equals("villageSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("villageName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$villageName(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$villageName((String) reader.nextString());
                }
            } else if (name.equals("mandalSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("mandalName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$mandalName(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$mandalName((String) reader.nextString());
                }
            } else if (name.equals("districtSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("districtName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$districtName(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$districtName((String) reader.nextString());
                }
            } else if (name.equals("isVillageChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isVillageChecked' to null.");
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$isVillageChecked((boolean) reader.nextBoolean());
                }
            } else if (name.equals("region")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VillageModelRealmProxyInterface) obj).realmSet$region(null);
                } else {
                    ((VillageModelRealmProxyInterface) obj).realmSet$region((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'subStationUID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.VillageModel copyOrUpdate(Realm realm, com.app.apsfl.models.VillageModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.VillageModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.VillageModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.VillageModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((VillageModelRealmProxyInterface) object).realmGet$subStationUID();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.VillageModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.VillageModelRealmProxy();
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

    public static com.app.apsfl.models.VillageModel copy(Realm realm, com.app.apsfl.models.VillageModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.VillageModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.VillageModel realmObject = realm.createObjectInternal(com.app.apsfl.models.VillageModel.class, ((VillageModelRealmProxyInterface) newObject).realmGet$subStationUID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((VillageModelRealmProxyInterface) realmObject).realmSet$villageCompositeKey(((VillageModelRealmProxyInterface) newObject).realmGet$villageCompositeKey());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$villageSerialNumber(((VillageModelRealmProxyInterface) newObject).realmGet$villageSerialNumber());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$villageName(((VillageModelRealmProxyInterface) newObject).realmGet$villageName());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$mandalSerialNumber(((VillageModelRealmProxyInterface) newObject).realmGet$mandalSerialNumber());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$mandalName(((VillageModelRealmProxyInterface) newObject).realmGet$mandalName());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$districtSerialNumber(((VillageModelRealmProxyInterface) newObject).realmGet$districtSerialNumber());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$districtName(((VillageModelRealmProxyInterface) newObject).realmGet$districtName());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$isVillageChecked(((VillageModelRealmProxyInterface) newObject).realmGet$isVillageChecked());
            ((VillageModelRealmProxyInterface) realmObject).realmSet$region(((VillageModelRealmProxyInterface) newObject).realmGet$region());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.VillageModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.VillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VillageModelColumnInfo columnInfo = (VillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((VillageModelRealmProxyInterface) object).realmGet$subStationUID();
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
        String realmGet$villageCompositeKey = ((VillageModelRealmProxyInterface)object).realmGet$villageCompositeKey();
        if (realmGet$villageCompositeKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageCompositeKeyIndex, rowIndex, realmGet$villageCompositeKey, false);
        }
        String realmGet$villageSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
        if (realmGet$villageSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
        }
        String realmGet$villageName = ((VillageModelRealmProxyInterface)object).realmGet$villageName();
        if (realmGet$villageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
        }
        String realmGet$mandalSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
        if (realmGet$mandalSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
        }
        String realmGet$mandalName = ((VillageModelRealmProxyInterface)object).realmGet$mandalName();
        if (realmGet$mandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
        }
        String realmGet$districtSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
        if (realmGet$districtSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
        }
        String realmGet$districtName = ((VillageModelRealmProxyInterface)object).realmGet$districtName();
        if (realmGet$districtName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((VillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
        String realmGet$region = ((VillageModelRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.VillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VillageModelColumnInfo columnInfo = (VillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.VillageModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.VillageModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((VillageModelRealmProxyInterface) object).realmGet$subStationUID();
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
                String realmGet$villageCompositeKey = ((VillageModelRealmProxyInterface)object).realmGet$villageCompositeKey();
                if (realmGet$villageCompositeKey != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageCompositeKeyIndex, rowIndex, realmGet$villageCompositeKey, false);
                }
                String realmGet$villageSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
                if (realmGet$villageSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
                }
                String realmGet$villageName = ((VillageModelRealmProxyInterface)object).realmGet$villageName();
                if (realmGet$villageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
                }
                String realmGet$mandalSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
                if (realmGet$mandalSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
                }
                String realmGet$mandalName = ((VillageModelRealmProxyInterface)object).realmGet$mandalName();
                if (realmGet$mandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
                }
                String realmGet$districtSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
                if (realmGet$districtSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
                }
                String realmGet$districtName = ((VillageModelRealmProxyInterface)object).realmGet$districtName();
                if (realmGet$districtName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((VillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
                String realmGet$region = ((VillageModelRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.VillageModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.VillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VillageModelColumnInfo columnInfo = (VillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((VillageModelRealmProxyInterface) object).realmGet$subStationUID();
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
        String realmGet$villageCompositeKey = ((VillageModelRealmProxyInterface)object).realmGet$villageCompositeKey();
        if (realmGet$villageCompositeKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageCompositeKeyIndex, rowIndex, realmGet$villageCompositeKey, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.villageCompositeKeyIndex, rowIndex, false);
        }
        String realmGet$villageSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
        if (realmGet$villageSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, false);
        }
        String realmGet$villageName = ((VillageModelRealmProxyInterface)object).realmGet$villageName();
        if (realmGet$villageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.villageNameIndex, rowIndex, false);
        }
        String realmGet$mandalSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
        if (realmGet$mandalSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, false);
        }
        String realmGet$mandalName = ((VillageModelRealmProxyInterface)object).realmGet$mandalName();
        if (realmGet$mandalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, false);
        }
        String realmGet$districtSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
        if (realmGet$districtSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, false);
        }
        String realmGet$districtName = ((VillageModelRealmProxyInterface)object).realmGet$districtName();
        if (realmGet$districtName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.districtNameIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((VillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
        String realmGet$region = ((VillageModelRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.VillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        VillageModelColumnInfo columnInfo = (VillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.VillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.VillageModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.VillageModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((VillageModelRealmProxyInterface) object).realmGet$subStationUID();
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
                String realmGet$villageCompositeKey = ((VillageModelRealmProxyInterface)object).realmGet$villageCompositeKey();
                if (realmGet$villageCompositeKey != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageCompositeKeyIndex, rowIndex, realmGet$villageCompositeKey, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.villageCompositeKeyIndex, rowIndex, false);
                }
                String realmGet$villageSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
                if (realmGet$villageSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, false);
                }
                String realmGet$villageName = ((VillageModelRealmProxyInterface)object).realmGet$villageName();
                if (realmGet$villageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.villageNameIndex, rowIndex, false);
                }
                String realmGet$mandalSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
                if (realmGet$mandalSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, false);
                }
                String realmGet$mandalName = ((VillageModelRealmProxyInterface)object).realmGet$mandalName();
                if (realmGet$mandalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, realmGet$mandalName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mandalNameIndex, rowIndex, false);
                }
                String realmGet$districtSerialNumber = ((VillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
                if (realmGet$districtSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, false);
                }
                String realmGet$districtName = ((VillageModelRealmProxyInterface)object).realmGet$districtName();
                if (realmGet$districtName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtNameIndex, rowIndex, realmGet$districtName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.districtNameIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((VillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
                String realmGet$region = ((VillageModelRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.VillageModel createDetachedCopy(com.app.apsfl.models.VillageModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.VillageModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.VillageModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.VillageModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.VillageModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$subStationUID(((VillageModelRealmProxyInterface) realmObject).realmGet$subStationUID());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$villageCompositeKey(((VillageModelRealmProxyInterface) realmObject).realmGet$villageCompositeKey());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$villageSerialNumber(((VillageModelRealmProxyInterface) realmObject).realmGet$villageSerialNumber());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$villageName(((VillageModelRealmProxyInterface) realmObject).realmGet$villageName());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$mandalSerialNumber(((VillageModelRealmProxyInterface) realmObject).realmGet$mandalSerialNumber());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$mandalName(((VillageModelRealmProxyInterface) realmObject).realmGet$mandalName());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$districtSerialNumber(((VillageModelRealmProxyInterface) realmObject).realmGet$districtSerialNumber());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$districtName(((VillageModelRealmProxyInterface) realmObject).realmGet$districtName());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$isVillageChecked(((VillageModelRealmProxyInterface) realmObject).realmGet$isVillageChecked());
        ((VillageModelRealmProxyInterface) unmanagedObject).realmSet$region(((VillageModelRealmProxyInterface) realmObject).realmGet$region());
        return unmanagedObject;
    }

    static com.app.apsfl.models.VillageModel update(Realm realm, com.app.apsfl.models.VillageModel realmObject, com.app.apsfl.models.VillageModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((VillageModelRealmProxyInterface) realmObject).realmSet$villageCompositeKey(((VillageModelRealmProxyInterface) newObject).realmGet$villageCompositeKey());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$villageSerialNumber(((VillageModelRealmProxyInterface) newObject).realmGet$villageSerialNumber());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$villageName(((VillageModelRealmProxyInterface) newObject).realmGet$villageName());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$mandalSerialNumber(((VillageModelRealmProxyInterface) newObject).realmGet$mandalSerialNumber());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$mandalName(((VillageModelRealmProxyInterface) newObject).realmGet$mandalName());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$districtSerialNumber(((VillageModelRealmProxyInterface) newObject).realmGet$districtSerialNumber());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$districtName(((VillageModelRealmProxyInterface) newObject).realmGet$districtName());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$isVillageChecked(((VillageModelRealmProxyInterface) newObject).realmGet$isVillageChecked());
        ((VillageModelRealmProxyInterface) realmObject).realmSet$region(((VillageModelRealmProxyInterface) newObject).realmGet$region());
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
        VillageModelRealmProxy aVillageModel = (VillageModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVillageModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVillageModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVillageModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
