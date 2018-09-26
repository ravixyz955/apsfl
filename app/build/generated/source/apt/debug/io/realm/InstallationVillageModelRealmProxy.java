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

public class InstallationVillageModelRealmProxy extends com.app.apsfl.models.InstallationVillageModel
    implements RealmObjectProxy, InstallationVillageModelRealmProxyInterface {

    static final class InstallationVillageModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long villageCompositeKeyIndex;
        public long villageSerialNumberIndex;
        public long villageNameIndex;
        public long mandalSerialNumberIndex;
        public long districtSerialNumberIndex;
        public long stateIdIndex;
        public long regionIndex;
        public long stdCodeIndex;
        public long pinCodeIndex;
        public long isVillageCheckedIndex;

        InstallationVillageModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(10);
            this.villageCompositeKeyIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "villageCompositeKey");
            indicesMap.put("villageCompositeKey", this.villageCompositeKeyIndex);
            this.villageSerialNumberIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "villageSerialNumber");
            indicesMap.put("villageSerialNumber", this.villageSerialNumberIndex);
            this.villageNameIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "villageName");
            indicesMap.put("villageName", this.villageNameIndex);
            this.mandalSerialNumberIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "mandalSerialNumber");
            indicesMap.put("mandalSerialNumber", this.mandalSerialNumberIndex);
            this.districtSerialNumberIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "districtSerialNumber");
            indicesMap.put("districtSerialNumber", this.districtSerialNumberIndex);
            this.stateIdIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "stateId");
            indicesMap.put("stateId", this.stateIdIndex);
            this.regionIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "region");
            indicesMap.put("region", this.regionIndex);
            this.stdCodeIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "stdCode");
            indicesMap.put("stdCode", this.stdCodeIndex);
            this.pinCodeIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "pinCode");
            indicesMap.put("pinCode", this.pinCodeIndex);
            this.isVillageCheckedIndex = getValidColumnIndex(path, table, "InstallationVillageModel", "isVillageChecked");
            indicesMap.put("isVillageChecked", this.isVillageCheckedIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final InstallationVillageModelColumnInfo otherInfo = (InstallationVillageModelColumnInfo) other;
            this.villageCompositeKeyIndex = otherInfo.villageCompositeKeyIndex;
            this.villageSerialNumberIndex = otherInfo.villageSerialNumberIndex;
            this.villageNameIndex = otherInfo.villageNameIndex;
            this.mandalSerialNumberIndex = otherInfo.mandalSerialNumberIndex;
            this.districtSerialNumberIndex = otherInfo.districtSerialNumberIndex;
            this.stateIdIndex = otherInfo.stateIdIndex;
            this.regionIndex = otherInfo.regionIndex;
            this.stdCodeIndex = otherInfo.stdCodeIndex;
            this.pinCodeIndex = otherInfo.pinCodeIndex;
            this.isVillageCheckedIndex = otherInfo.isVillageCheckedIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final InstallationVillageModelColumnInfo clone() {
            return (InstallationVillageModelColumnInfo) super.clone();
        }

    }
    private InstallationVillageModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("villageCompositeKey");
        fieldNames.add("villageSerialNumber");
        fieldNames.add("villageName");
        fieldNames.add("mandalSerialNumber");
        fieldNames.add("districtSerialNumber");
        fieldNames.add("stateId");
        fieldNames.add("region");
        fieldNames.add("stdCode");
        fieldNames.add("pinCode");
        fieldNames.add("isVillageChecked");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    InstallationVillageModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (InstallationVillageModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.InstallationVillageModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'villageCompositeKey' cannot be changed after object was created.");
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
    public String realmGet$stateId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stateIdIndex);
    }

    public void realmSet$stateId(String value) {
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
                row.getTable().setNull(columnInfo.stateIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stateIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stateIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stateIdIndex, value);
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

    @SuppressWarnings("cast")
    public String realmGet$stdCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stdCodeIndex);
    }

    public void realmSet$stdCode(String value) {
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
                row.getTable().setNull(columnInfo.stdCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stdCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stdCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stdCodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$pinCode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pinCodeIndex);
    }

    public void realmSet$pinCode(String value) {
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
                row.getTable().setNull(columnInfo.pinCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pinCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pinCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pinCodeIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("InstallationVillageModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("InstallationVillageModel");
            realmObjectSchema.add(new Property("villageCompositeKey", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("villageSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("villageName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("mandalSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("districtSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("stateId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("region", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("stdCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("pinCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isVillageChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("InstallationVillageModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_InstallationVillageModel")) {
            Table table = sharedRealm.getTable("class_InstallationVillageModel");
            table.addColumn(RealmFieldType.STRING, "villageCompositeKey", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "villageSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "villageName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "mandalSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "districtSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "stateId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "region", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "stdCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "pinCode", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isVillageChecked", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("villageCompositeKey"));
            table.setPrimaryKey("villageCompositeKey");
            return table;
        }
        return sharedRealm.getTable("class_InstallationVillageModel");
    }

    public static InstallationVillageModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_InstallationVillageModel")) {
            Table table = sharedRealm.getTable("class_InstallationVillageModel");
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

            final InstallationVillageModelColumnInfo columnInfo = new InstallationVillageModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("villageCompositeKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'villageCompositeKey' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("villageCompositeKey") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'villageCompositeKey' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.villageCompositeKeyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'villageCompositeKey' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("villageCompositeKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'villageCompositeKey' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("villageCompositeKey"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'villageCompositeKey' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            if (!columnTypes.containsKey("districtSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("districtSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.districtSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtSerialNumber' is required. Either set @Required to field 'districtSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("stateId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stateId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("stateId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'stateId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.stateIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'stateId' is required. Either set @Required to field 'stateId' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("stdCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stdCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("stdCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'stdCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.stdCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'stdCode' is required. Either set @Required to field 'stdCode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("pinCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pinCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("pinCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'pinCode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.pinCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'pinCode' is required. Either set @Required to field 'pinCode' or migrate using RealmObjectSchema.setNullable().");
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
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'InstallationVillageModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_InstallationVillageModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.InstallationVillageModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.InstallationVillageModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.InstallationVillageModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("villageCompositeKey")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("villageCompositeKey"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.InstallationVillageModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.InstallationVillageModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("villageCompositeKey")) {
                if (json.isNull("villageCompositeKey")) {
                    obj = (io.realm.InstallationVillageModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.InstallationVillageModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.InstallationVillageModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.InstallationVillageModel.class, json.getString("villageCompositeKey"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'villageCompositeKey'.");
            }
        }
        if (json.has("villageSerialNumber")) {
            if (json.isNull("villageSerialNumber")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber((String) json.getString("villageSerialNumber"));
            }
        }
        if (json.has("villageName")) {
            if (json.isNull("villageName")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageName(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageName((String) json.getString("villageName"));
            }
        }
        if (json.has("mandalSerialNumber")) {
            if (json.isNull("mandalSerialNumber")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber((String) json.getString("mandalSerialNumber"));
            }
        }
        if (json.has("districtSerialNumber")) {
            if (json.isNull("districtSerialNumber")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber((String) json.getString("districtSerialNumber"));
            }
        }
        if (json.has("stateId")) {
            if (json.isNull("stateId")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stateId(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stateId((String) json.getString("stateId"));
            }
        }
        if (json.has("region")) {
            if (json.isNull("region")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$region(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$region((String) json.getString("region"));
            }
        }
        if (json.has("stdCode")) {
            if (json.isNull("stdCode")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stdCode(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stdCode((String) json.getString("stdCode"));
            }
        }
        if (json.has("pinCode")) {
            if (json.isNull("pinCode")) {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$pinCode(null);
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$pinCode((String) json.getString("pinCode"));
            }
        }
        if (json.has("isVillageChecked")) {
            if (json.isNull("isVillageChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isVillageChecked' to null.");
            } else {
                ((InstallationVillageModelRealmProxyInterface) obj).realmSet$isVillageChecked((boolean) json.getBoolean("isVillageChecked"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.InstallationVillageModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.InstallationVillageModel obj = new com.app.apsfl.models.InstallationVillageModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("villageCompositeKey")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageCompositeKey(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageCompositeKey((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("villageSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("villageName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageName(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$villageName((String) reader.nextString());
                }
            } else if (name.equals("mandalSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$mandalSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("districtSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$districtSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("stateId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stateId(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stateId((String) reader.nextString());
                }
            } else if (name.equals("region")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$region(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$region((String) reader.nextString());
                }
            } else if (name.equals("stdCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stdCode(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$stdCode((String) reader.nextString());
                }
            } else if (name.equals("pinCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$pinCode(null);
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$pinCode((String) reader.nextString());
                }
            } else if (name.equals("isVillageChecked")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isVillageChecked' to null.");
                } else {
                    ((InstallationVillageModelRealmProxyInterface) obj).realmSet$isVillageChecked((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'villageCompositeKey'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.InstallationVillageModel copyOrUpdate(Realm realm, com.app.apsfl.models.InstallationVillageModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.InstallationVillageModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.InstallationVillageModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.InstallationVillageModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((InstallationVillageModelRealmProxyInterface) object).realmGet$villageCompositeKey();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.InstallationVillageModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.InstallationVillageModelRealmProxy();
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

    public static com.app.apsfl.models.InstallationVillageModel copy(Realm realm, com.app.apsfl.models.InstallationVillageModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.InstallationVillageModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.InstallationVillageModel realmObject = realm.createObjectInternal(com.app.apsfl.models.InstallationVillageModel.class, ((InstallationVillageModelRealmProxyInterface) newObject).realmGet$villageCompositeKey(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$villageSerialNumber(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$villageSerialNumber());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$villageName(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$villageName());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$mandalSerialNumber(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$mandalSerialNumber());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$districtSerialNumber(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$districtSerialNumber());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$stateId(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$stateId());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$region(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$region());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$stdCode(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$stdCode());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$pinCode(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$pinCode());
            ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$isVillageChecked(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$isVillageChecked());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.InstallationVillageModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.InstallationVillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        InstallationVillageModelColumnInfo columnInfo = (InstallationVillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.InstallationVillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((InstallationVillageModelRealmProxyInterface) object).realmGet$villageCompositeKey();
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
        String realmGet$villageSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
        if (realmGet$villageSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
        }
        String realmGet$villageName = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageName();
        if (realmGet$villageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
        }
        String realmGet$mandalSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
        if (realmGet$mandalSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
        }
        String realmGet$districtSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
        if (realmGet$districtSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
        }
        String realmGet$stateId = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stateId();
        if (realmGet$stateId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
        }
        String realmGet$region = ((InstallationVillageModelRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        }
        String realmGet$stdCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stdCode();
        if (realmGet$stdCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
        }
        String realmGet$pinCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$pinCode();
        if (realmGet$pinCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((InstallationVillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.InstallationVillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        InstallationVillageModelColumnInfo columnInfo = (InstallationVillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.InstallationVillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.InstallationVillageModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.InstallationVillageModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((InstallationVillageModelRealmProxyInterface) object).realmGet$villageCompositeKey();
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
                String realmGet$villageSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
                if (realmGet$villageSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
                }
                String realmGet$villageName = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageName();
                if (realmGet$villageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
                }
                String realmGet$mandalSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
                if (realmGet$mandalSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
                }
                String realmGet$districtSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
                if (realmGet$districtSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
                }
                String realmGet$stateId = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stateId();
                if (realmGet$stateId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
                }
                String realmGet$region = ((InstallationVillageModelRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                }
                String realmGet$stdCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stdCode();
                if (realmGet$stdCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
                }
                String realmGet$pinCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$pinCode();
                if (realmGet$pinCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((InstallationVillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.InstallationVillageModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.InstallationVillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        InstallationVillageModelColumnInfo columnInfo = (InstallationVillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.InstallationVillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((InstallationVillageModelRealmProxyInterface) object).realmGet$villageCompositeKey();
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
        String realmGet$villageSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
        if (realmGet$villageSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, false);
        }
        String realmGet$villageName = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageName();
        if (realmGet$villageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.villageNameIndex, rowIndex, false);
        }
        String realmGet$mandalSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
        if (realmGet$mandalSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, false);
        }
        String realmGet$districtSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
        if (realmGet$districtSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, false);
        }
        String realmGet$stateId = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stateId();
        if (realmGet$stateId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stateIdIndex, rowIndex, false);
        }
        String realmGet$region = ((InstallationVillageModelRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
        }
        String realmGet$stdCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stdCode();
        if (realmGet$stdCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, false);
        }
        String realmGet$pinCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$pinCode();
        if (realmGet$pinCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((InstallationVillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.InstallationVillageModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        InstallationVillageModelColumnInfo columnInfo = (InstallationVillageModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.InstallationVillageModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.InstallationVillageModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.InstallationVillageModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((InstallationVillageModelRealmProxyInterface) object).realmGet$villageCompositeKey();
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
                String realmGet$villageSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageSerialNumber();
                if (realmGet$villageSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, realmGet$villageSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.villageSerialNumberIndex, rowIndex, false);
                }
                String realmGet$villageName = ((InstallationVillageModelRealmProxyInterface)object).realmGet$villageName();
                if (realmGet$villageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.villageNameIndex, rowIndex, realmGet$villageName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.villageNameIndex, rowIndex, false);
                }
                String realmGet$mandalSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$mandalSerialNumber();
                if (realmGet$mandalSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, realmGet$mandalSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mandalSerialNumberIndex, rowIndex, false);
                }
                String realmGet$districtSerialNumber = ((InstallationVillageModelRealmProxyInterface)object).realmGet$districtSerialNumber();
                if (realmGet$districtSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, realmGet$districtSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.districtSerialNumberIndex, rowIndex, false);
                }
                String realmGet$stateId = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stateId();
                if (realmGet$stateId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stateIdIndex, rowIndex, false);
                }
                String realmGet$region = ((InstallationVillageModelRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
                }
                String realmGet$stdCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$stdCode();
                if (realmGet$stdCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, realmGet$stdCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stdCodeIndex, rowIndex, false);
                }
                String realmGet$pinCode = ((InstallationVillageModelRealmProxyInterface)object).realmGet$pinCode();
                if (realmGet$pinCode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, realmGet$pinCode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pinCodeIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isVillageCheckedIndex, rowIndex, ((InstallationVillageModelRealmProxyInterface)object).realmGet$isVillageChecked(), false);
            }
        }
    }

    public static com.app.apsfl.models.InstallationVillageModel createDetachedCopy(com.app.apsfl.models.InstallationVillageModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.InstallationVillageModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.InstallationVillageModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.InstallationVillageModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.InstallationVillageModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$villageCompositeKey(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$villageCompositeKey());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$villageSerialNumber(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$villageSerialNumber());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$villageName(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$villageName());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$mandalSerialNumber(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$mandalSerialNumber());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$districtSerialNumber(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$districtSerialNumber());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$stateId(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$stateId());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$region(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$region());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$stdCode(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$stdCode());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$pinCode(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$pinCode());
        ((InstallationVillageModelRealmProxyInterface) unmanagedObject).realmSet$isVillageChecked(((InstallationVillageModelRealmProxyInterface) realmObject).realmGet$isVillageChecked());
        return unmanagedObject;
    }

    static com.app.apsfl.models.InstallationVillageModel update(Realm realm, com.app.apsfl.models.InstallationVillageModel realmObject, com.app.apsfl.models.InstallationVillageModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$villageSerialNumber(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$villageSerialNumber());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$villageName(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$villageName());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$mandalSerialNumber(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$mandalSerialNumber());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$districtSerialNumber(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$districtSerialNumber());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$stateId(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$stateId());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$region(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$region());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$stdCode(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$stdCode());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$pinCode(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$pinCode());
        ((InstallationVillageModelRealmProxyInterface) realmObject).realmSet$isVillageChecked(((InstallationVillageModelRealmProxyInterface) newObject).realmGet$isVillageChecked());
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
        InstallationVillageModelRealmProxy aInstallationVillageModel = (InstallationVillageModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aInstallationVillageModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aInstallationVillageModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aInstallationVillageModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
