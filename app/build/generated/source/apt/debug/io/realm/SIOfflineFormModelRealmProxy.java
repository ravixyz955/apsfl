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

public class SIOfflineFormModelRealmProxy extends com.app.apsfl.models.SIOfflineFormModel
    implements RealmObjectProxy, SIOfflineFormModelRealmProxyInterface {

    static final class SIOfflineFormModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long apsflTrackIdIndex;
        public long formPaymentDataIndex;
        public long cafOTPNumberIndex;
        public long cafNumberIndex;
        public long isNetworkAvailbleIndex;
        public long isFormUploadedIndex;
        public long statusMessageIndex;

        SIOfflineFormModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.apsflTrackIdIndex = getValidColumnIndex(path, table, "SIOfflineFormModel", "apsflTrackId");
            indicesMap.put("apsflTrackId", this.apsflTrackIdIndex);
            this.formPaymentDataIndex = getValidColumnIndex(path, table, "SIOfflineFormModel", "formPaymentData");
            indicesMap.put("formPaymentData", this.formPaymentDataIndex);
            this.cafOTPNumberIndex = getValidColumnIndex(path, table, "SIOfflineFormModel", "cafOTPNumber");
            indicesMap.put("cafOTPNumber", this.cafOTPNumberIndex);
            this.cafNumberIndex = getValidColumnIndex(path, table, "SIOfflineFormModel", "cafNumber");
            indicesMap.put("cafNumber", this.cafNumberIndex);
            this.isNetworkAvailbleIndex = getValidColumnIndex(path, table, "SIOfflineFormModel", "isNetworkAvailble");
            indicesMap.put("isNetworkAvailble", this.isNetworkAvailbleIndex);
            this.isFormUploadedIndex = getValidColumnIndex(path, table, "SIOfflineFormModel", "isFormUploaded");
            indicesMap.put("isFormUploaded", this.isFormUploadedIndex);
            this.statusMessageIndex = getValidColumnIndex(path, table, "SIOfflineFormModel", "statusMessage");
            indicesMap.put("statusMessage", this.statusMessageIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final SIOfflineFormModelColumnInfo otherInfo = (SIOfflineFormModelColumnInfo) other;
            this.apsflTrackIdIndex = otherInfo.apsflTrackIdIndex;
            this.formPaymentDataIndex = otherInfo.formPaymentDataIndex;
            this.cafOTPNumberIndex = otherInfo.cafOTPNumberIndex;
            this.cafNumberIndex = otherInfo.cafNumberIndex;
            this.isNetworkAvailbleIndex = otherInfo.isNetworkAvailbleIndex;
            this.isFormUploadedIndex = otherInfo.isFormUploadedIndex;
            this.statusMessageIndex = otherInfo.statusMessageIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final SIOfflineFormModelColumnInfo clone() {
            return (SIOfflineFormModelColumnInfo) super.clone();
        }

    }
    private SIOfflineFormModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("apsflTrackId");
        fieldNames.add("formPaymentData");
        fieldNames.add("cafOTPNumber");
        fieldNames.add("cafNumber");
        fieldNames.add("isNetworkAvailble");
        fieldNames.add("isFormUploaded");
        fieldNames.add("statusMessage");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SIOfflineFormModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SIOfflineFormModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.SIOfflineFormModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'apsflTrackId' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$formPaymentData() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.formPaymentDataIndex);
    }

    public void realmSet$formPaymentData(String value) {
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
                row.getTable().setNull(columnInfo.formPaymentDataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.formPaymentDataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.formPaymentDataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.formPaymentDataIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cafOTPNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cafOTPNumberIndex);
    }

    public void realmSet$cafOTPNumber(String value) {
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
                row.getTable().setNull(columnInfo.cafOTPNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cafOTPNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cafOTPNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cafOTPNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cafNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cafNumberIndex);
    }

    public void realmSet$cafNumber(String value) {
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
                row.getTable().setNull(columnInfo.cafNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cafNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cafNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cafNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isNetworkAvailble() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isNetworkAvailbleIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isNetworkAvailbleIndex);
    }

    public void realmSet$isNetworkAvailble(Boolean value) {
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
                row.getTable().setNull(columnInfo.isNetworkAvailbleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isNetworkAvailbleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isNetworkAvailbleIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isNetworkAvailbleIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$isFormUploaded() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isFormUploadedIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isFormUploadedIndex);
    }

    public void realmSet$isFormUploaded(Boolean value) {
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
                row.getTable().setNull(columnInfo.isFormUploadedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isFormUploadedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isFormUploadedIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isFormUploadedIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$statusMessage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusMessageIndex);
    }

    public void realmSet$statusMessage(String value) {
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
                row.getTable().setNull(columnInfo.statusMessageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusMessageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusMessageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusMessageIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("SIOfflineFormModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("SIOfflineFormModel");
            realmObjectSchema.add(new Property("apsflTrackId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("formPaymentData", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cafOTPNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cafNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isNetworkAvailble", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("isFormUploaded", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("statusMessage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("SIOfflineFormModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_SIOfflineFormModel")) {
            Table table = sharedRealm.getTable("class_SIOfflineFormModel");
            table.addColumn(RealmFieldType.STRING, "apsflTrackId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "formPaymentData", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cafOTPNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cafNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isNetworkAvailble", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isFormUploaded", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "statusMessage", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("apsflTrackId"));
            table.setPrimaryKey("apsflTrackId");
            return table;
        }
        return sharedRealm.getTable("class_SIOfflineFormModel");
    }

    public static SIOfflineFormModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SIOfflineFormModel")) {
            Table table = sharedRealm.getTable("class_SIOfflineFormModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 7) {
                if (columnCount < 7) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 7; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final SIOfflineFormModelColumnInfo columnInfo = new SIOfflineFormModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("apsflTrackId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'apsflTrackId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("apsflTrackId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'apsflTrackId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.apsflTrackIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'apsflTrackId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("apsflTrackId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'apsflTrackId' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("apsflTrackId"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'apsflTrackId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("formPaymentData")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'formPaymentData' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("formPaymentData") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'formPaymentData' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.formPaymentDataIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'formPaymentData' is required. Either set @Required to field 'formPaymentData' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cafOTPNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cafOTPNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cafOTPNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cafOTPNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cafOTPNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cafOTPNumber' is required. Either set @Required to field 'cafOTPNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cafNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cafNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cafNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cafNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cafNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cafNumber' is required. Either set @Required to field 'cafNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isNetworkAvailble")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isNetworkAvailble' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isNetworkAvailble") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isNetworkAvailble' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isNetworkAvailbleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isNetworkAvailble' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isNetworkAvailble' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isFormUploaded")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isFormUploaded' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isFormUploaded") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isFormUploaded' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.isFormUploadedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'isFormUploaded' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isFormUploaded' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("statusMessage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'statusMessage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("statusMessage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'statusMessage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.statusMessageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'statusMessage' is required. Either set @Required to field 'statusMessage' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SIOfflineFormModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SIOfflineFormModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.SIOfflineFormModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.SIOfflineFormModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.SIOfflineFormModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("apsflTrackId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("apsflTrackId"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SIOfflineFormModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.SIOfflineFormModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("apsflTrackId")) {
                if (json.isNull("apsflTrackId")) {
                    obj = (io.realm.SIOfflineFormModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SIOfflineFormModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.SIOfflineFormModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SIOfflineFormModel.class, json.getString("apsflTrackId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'apsflTrackId'.");
            }
        }
        if (json.has("formPaymentData")) {
            if (json.isNull("formPaymentData")) {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData(null);
            } else {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData((String) json.getString("formPaymentData"));
            }
        }
        if (json.has("cafOTPNumber")) {
            if (json.isNull("cafOTPNumber")) {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber(null);
            } else {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber((String) json.getString("cafOTPNumber"));
            }
        }
        if (json.has("cafNumber")) {
            if (json.isNull("cafNumber")) {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafNumber(null);
            } else {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafNumber((String) json.getString("cafNumber"));
            }
        }
        if (json.has("isNetworkAvailble")) {
            if (json.isNull("isNetworkAvailble")) {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble(null);
            } else {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble((boolean) json.getBoolean("isNetworkAvailble"));
            }
        }
        if (json.has("isFormUploaded")) {
            if (json.isNull("isFormUploaded")) {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded(null);
            } else {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded((boolean) json.getBoolean("isFormUploaded"));
            }
        }
        if (json.has("statusMessage")) {
            if (json.isNull("statusMessage")) {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage(null);
            } else {
                ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage((String) json.getString("statusMessage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.SIOfflineFormModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.SIOfflineFormModel obj = new com.app.apsfl.models.SIOfflineFormModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("apsflTrackId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$apsflTrackId(null);
                } else {
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$apsflTrackId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("formPaymentData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData(null);
                } else {
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$formPaymentData((String) reader.nextString());
                }
            } else if (name.equals("cafOTPNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber(null);
                } else {
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafOTPNumber((String) reader.nextString());
                }
            } else if (name.equals("cafNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafNumber(null);
                } else {
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$cafNumber((String) reader.nextString());
                }
            } else if (name.equals("isNetworkAvailble")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble(null);
                } else {
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isNetworkAvailble((boolean) reader.nextBoolean());
                }
            } else if (name.equals("isFormUploaded")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded(null);
                } else {
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$isFormUploaded((boolean) reader.nextBoolean());
                }
            } else if (name.equals("statusMessage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage(null);
                } else {
                    ((SIOfflineFormModelRealmProxyInterface) obj).realmSet$statusMessage((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'apsflTrackId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.SIOfflineFormModel copyOrUpdate(Realm realm, com.app.apsfl.models.SIOfflineFormModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SIOfflineFormModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.SIOfflineFormModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.SIOfflineFormModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((SIOfflineFormModelRealmProxyInterface) object).realmGet$apsflTrackId();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SIOfflineFormModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.SIOfflineFormModelRealmProxy();
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

    public static com.app.apsfl.models.SIOfflineFormModel copy(Realm realm, com.app.apsfl.models.SIOfflineFormModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SIOfflineFormModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.SIOfflineFormModel realmObject = realm.createObjectInternal(com.app.apsfl.models.SIOfflineFormModel.class, ((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$apsflTrackId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$formPaymentData(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$formPaymentData());
            ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$cafOTPNumber(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$cafOTPNumber());
            ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$cafNumber(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$cafNumber());
            ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$isNetworkAvailble(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$isNetworkAvailble());
            ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$isFormUploaded(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$isFormUploaded());
            ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$statusMessage(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$statusMessage());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.SIOfflineFormModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SIOfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIOfflineFormModelColumnInfo columnInfo = (SIOfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIOfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SIOfflineFormModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
        String realmGet$formPaymentData = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
        if (realmGet$formPaymentData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
        }
        String realmGet$cafOTPNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
        if (realmGet$cafOTPNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
        }
        String realmGet$cafNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafNumber();
        if (realmGet$cafNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafNumberIndex, rowIndex, realmGet$cafNumber, false);
        }
        Boolean realmGet$isNetworkAvailble = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
        if (realmGet$isNetworkAvailble != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
        }
        Boolean realmGet$isFormUploaded = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
        if (realmGet$isFormUploaded != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
        }
        String realmGet$statusMessage = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
        if (realmGet$statusMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SIOfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIOfflineFormModelColumnInfo columnInfo = (SIOfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIOfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SIOfflineFormModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SIOfflineFormModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SIOfflineFormModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
                String realmGet$formPaymentData = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
                if (realmGet$formPaymentData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
                }
                String realmGet$cafOTPNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
                if (realmGet$cafOTPNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
                }
                String realmGet$cafNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafNumber();
                if (realmGet$cafNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafNumberIndex, rowIndex, realmGet$cafNumber, false);
                }
                Boolean realmGet$isNetworkAvailble = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
                if (realmGet$isNetworkAvailble != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
                }
                Boolean realmGet$isFormUploaded = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
                if (realmGet$isFormUploaded != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
                }
                String realmGet$statusMessage = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
                if (realmGet$statusMessage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.SIOfflineFormModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SIOfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIOfflineFormModelColumnInfo columnInfo = (SIOfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIOfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SIOfflineFormModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
        String realmGet$formPaymentData = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
        if (realmGet$formPaymentData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, false);
        }
        String realmGet$cafOTPNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
        if (realmGet$cafOTPNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, false);
        }
        String realmGet$cafNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafNumber();
        if (realmGet$cafNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cafNumberIndex, rowIndex, realmGet$cafNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cafNumberIndex, rowIndex, false);
        }
        Boolean realmGet$isNetworkAvailble = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
        if (realmGet$isNetworkAvailble != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, false);
        }
        Boolean realmGet$isFormUploaded = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
        if (realmGet$isFormUploaded != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, false);
        }
        String realmGet$statusMessage = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
        if (realmGet$statusMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SIOfflineFormModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SIOfflineFormModelColumnInfo columnInfo = (SIOfflineFormModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SIOfflineFormModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SIOfflineFormModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SIOfflineFormModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SIOfflineFormModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
                String realmGet$formPaymentData = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$formPaymentData();
                if (realmGet$formPaymentData != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, realmGet$formPaymentData, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.formPaymentDataIndex, rowIndex, false);
                }
                String realmGet$cafOTPNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafOTPNumber();
                if (realmGet$cafOTPNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, realmGet$cafOTPNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cafOTPNumberIndex, rowIndex, false);
                }
                String realmGet$cafNumber = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$cafNumber();
                if (realmGet$cafNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cafNumberIndex, rowIndex, realmGet$cafNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cafNumberIndex, rowIndex, false);
                }
                Boolean realmGet$isNetworkAvailble = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isNetworkAvailble();
                if (realmGet$isNetworkAvailble != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, realmGet$isNetworkAvailble, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isNetworkAvailbleIndex, rowIndex, false);
                }
                Boolean realmGet$isFormUploaded = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$isFormUploaded();
                if (realmGet$isFormUploaded != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, realmGet$isFormUploaded, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.isFormUploadedIndex, rowIndex, false);
                }
                String realmGet$statusMessage = ((SIOfflineFormModelRealmProxyInterface)object).realmGet$statusMessage();
                if (realmGet$statusMessage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, realmGet$statusMessage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusMessageIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.SIOfflineFormModel createDetachedCopy(com.app.apsfl.models.SIOfflineFormModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.SIOfflineFormModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.SIOfflineFormModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.SIOfflineFormModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.SIOfflineFormModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((SIOfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$apsflTrackId(((SIOfflineFormModelRealmProxyInterface) realmObject).realmGet$apsflTrackId());
        ((SIOfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$formPaymentData(((SIOfflineFormModelRealmProxyInterface) realmObject).realmGet$formPaymentData());
        ((SIOfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$cafOTPNumber(((SIOfflineFormModelRealmProxyInterface) realmObject).realmGet$cafOTPNumber());
        ((SIOfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$cafNumber(((SIOfflineFormModelRealmProxyInterface) realmObject).realmGet$cafNumber());
        ((SIOfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$isNetworkAvailble(((SIOfflineFormModelRealmProxyInterface) realmObject).realmGet$isNetworkAvailble());
        ((SIOfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$isFormUploaded(((SIOfflineFormModelRealmProxyInterface) realmObject).realmGet$isFormUploaded());
        ((SIOfflineFormModelRealmProxyInterface) unmanagedObject).realmSet$statusMessage(((SIOfflineFormModelRealmProxyInterface) realmObject).realmGet$statusMessage());
        return unmanagedObject;
    }

    static com.app.apsfl.models.SIOfflineFormModel update(Realm realm, com.app.apsfl.models.SIOfflineFormModel realmObject, com.app.apsfl.models.SIOfflineFormModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$formPaymentData(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$formPaymentData());
        ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$cafOTPNumber(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$cafOTPNumber());
        ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$cafNumber(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$cafNumber());
        ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$isNetworkAvailble(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$isNetworkAvailble());
        ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$isFormUploaded(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$isFormUploaded());
        ((SIOfflineFormModelRealmProxyInterface) realmObject).realmSet$statusMessage(((SIOfflineFormModelRealmProxyInterface) newObject).realmGet$statusMessage());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SIOfflineFormModel = [");
        stringBuilder.append("{apsflTrackId:");
        stringBuilder.append(realmGet$apsflTrackId() != null ? realmGet$apsflTrackId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{formPaymentData:");
        stringBuilder.append(realmGet$formPaymentData() != null ? realmGet$formPaymentData() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cafOTPNumber:");
        stringBuilder.append(realmGet$cafOTPNumber() != null ? realmGet$cafOTPNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cafNumber:");
        stringBuilder.append(realmGet$cafNumber() != null ? realmGet$cafNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isNetworkAvailble:");
        stringBuilder.append(realmGet$isNetworkAvailble() != null ? realmGet$isNetworkAvailble() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isFormUploaded:");
        stringBuilder.append(realmGet$isFormUploaded() != null ? realmGet$isFormUploaded() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{statusMessage:");
        stringBuilder.append(realmGet$statusMessage() != null ? realmGet$statusMessage() : "null");
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
        SIOfflineFormModelRealmProxy aSIOfflineFormModel = (SIOfflineFormModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSIOfflineFormModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSIOfflineFormModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSIOfflineFormModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
