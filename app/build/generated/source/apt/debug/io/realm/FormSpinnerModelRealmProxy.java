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

public class FormSpinnerModelRealmProxy extends com.app.apsfl.models.FormSpinnerModel
    implements RealmObjectProxy, FormSpinnerModelRealmProxyInterface {

    static final class FormSpinnerModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long customerTitlesIndex;
        public long customerSegmentsIndex;
        public long customerChannelsIndex;
        public long billFrequenciesIndex;
        public long vmAddressesIndex;
        public long hotLinePrioritiesIndex;

        FormSpinnerModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(6);
            this.customerTitlesIndex = getValidColumnIndex(path, table, "FormSpinnerModel", "customerTitles");
            indicesMap.put("customerTitles", this.customerTitlesIndex);
            this.customerSegmentsIndex = getValidColumnIndex(path, table, "FormSpinnerModel", "customerSegments");
            indicesMap.put("customerSegments", this.customerSegmentsIndex);
            this.customerChannelsIndex = getValidColumnIndex(path, table, "FormSpinnerModel", "customerChannels");
            indicesMap.put("customerChannels", this.customerChannelsIndex);
            this.billFrequenciesIndex = getValidColumnIndex(path, table, "FormSpinnerModel", "billFrequencies");
            indicesMap.put("billFrequencies", this.billFrequenciesIndex);
            this.vmAddressesIndex = getValidColumnIndex(path, table, "FormSpinnerModel", "vmAddresses");
            indicesMap.put("vmAddresses", this.vmAddressesIndex);
            this.hotLinePrioritiesIndex = getValidColumnIndex(path, table, "FormSpinnerModel", "hotLinePriorities");
            indicesMap.put("hotLinePriorities", this.hotLinePrioritiesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final FormSpinnerModelColumnInfo otherInfo = (FormSpinnerModelColumnInfo) other;
            this.customerTitlesIndex = otherInfo.customerTitlesIndex;
            this.customerSegmentsIndex = otherInfo.customerSegmentsIndex;
            this.customerChannelsIndex = otherInfo.customerChannelsIndex;
            this.billFrequenciesIndex = otherInfo.billFrequenciesIndex;
            this.vmAddressesIndex = otherInfo.vmAddressesIndex;
            this.hotLinePrioritiesIndex = otherInfo.hotLinePrioritiesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final FormSpinnerModelColumnInfo clone() {
            return (FormSpinnerModelColumnInfo) super.clone();
        }

    }
    private FormSpinnerModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("customerTitles");
        fieldNames.add("customerSegments");
        fieldNames.add("customerChannels");
        fieldNames.add("billFrequencies");
        fieldNames.add("vmAddresses");
        fieldNames.add("hotLinePriorities");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    FormSpinnerModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FormSpinnerModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.FormSpinnerModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$customerTitles() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerTitlesIndex);
    }

    public void realmSet$customerTitles(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'customerTitles' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$customerSegments() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerSegmentsIndex);
    }

    public void realmSet$customerSegments(String value) {
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
                row.getTable().setNull(columnInfo.customerSegmentsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerSegmentsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerSegmentsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerSegmentsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$customerChannels() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerChannelsIndex);
    }

    public void realmSet$customerChannels(String value) {
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
                row.getTable().setNull(columnInfo.customerChannelsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerChannelsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerChannelsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerChannelsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$billFrequencies() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.billFrequenciesIndex);
    }

    public void realmSet$billFrequencies(String value) {
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
                row.getTable().setNull(columnInfo.billFrequenciesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.billFrequenciesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.billFrequenciesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.billFrequenciesIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$vmAddresses() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.vmAddressesIndex);
    }

    public void realmSet$vmAddresses(String value) {
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
                row.getTable().setNull(columnInfo.vmAddressesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.vmAddressesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.vmAddressesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.vmAddressesIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$hotLinePriorities() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.hotLinePrioritiesIndex);
    }

    public void realmSet$hotLinePriorities(String value) {
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
                row.getTable().setNull(columnInfo.hotLinePrioritiesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.hotLinePrioritiesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.hotLinePrioritiesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.hotLinePrioritiesIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("FormSpinnerModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("FormSpinnerModel");
            realmObjectSchema.add(new Property("customerTitles", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerSegments", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("customerChannels", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("billFrequencies", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("vmAddresses", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("hotLinePriorities", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("FormSpinnerModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_FormSpinnerModel")) {
            Table table = sharedRealm.getTable("class_FormSpinnerModel");
            table.addColumn(RealmFieldType.STRING, "customerTitles", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerSegments", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "customerChannels", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "billFrequencies", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "vmAddresses", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "hotLinePriorities", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("customerTitles"));
            table.setPrimaryKey("customerTitles");
            return table;
        }
        return sharedRealm.getTable("class_FormSpinnerModel");
    }

    public static FormSpinnerModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_FormSpinnerModel")) {
            Table table = sharedRealm.getTable("class_FormSpinnerModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 6) {
                if (columnCount < 6) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 6; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final FormSpinnerModelColumnInfo columnInfo = new FormSpinnerModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("customerTitles")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerTitles' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerTitles") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerTitles' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerTitlesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'customerTitles' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("customerTitles")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'customerTitles' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("customerTitles"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'customerTitles' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("customerSegments")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerSegments' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerSegments") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerSegments' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerSegmentsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerSegments' is required. Either set @Required to field 'customerSegments' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("customerChannels")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerChannels' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("customerChannels") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerChannels' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.customerChannelsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerChannels' is required. Either set @Required to field 'customerChannels' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("billFrequencies")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'billFrequencies' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("billFrequencies") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'billFrequencies' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.billFrequenciesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'billFrequencies' is required. Either set @Required to field 'billFrequencies' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("vmAddresses")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'vmAddresses' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("vmAddresses") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'vmAddresses' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.vmAddressesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'vmAddresses' is required. Either set @Required to field 'vmAddresses' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("hotLinePriorities")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'hotLinePriorities' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("hotLinePriorities") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'hotLinePriorities' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.hotLinePrioritiesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'hotLinePriorities' is required. Either set @Required to field 'hotLinePriorities' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'FormSpinnerModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_FormSpinnerModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.FormSpinnerModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.FormSpinnerModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.FormSpinnerModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("customerTitles")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("customerTitles"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.FormSpinnerModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.FormSpinnerModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("customerTitles")) {
                if (json.isNull("customerTitles")) {
                    obj = (io.realm.FormSpinnerModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.FormSpinnerModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.FormSpinnerModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.FormSpinnerModel.class, json.getString("customerTitles"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'customerTitles'.");
            }
        }
        if (json.has("customerSegments")) {
            if (json.isNull("customerSegments")) {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerSegments(null);
            } else {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerSegments((String) json.getString("customerSegments"));
            }
        }
        if (json.has("customerChannels")) {
            if (json.isNull("customerChannels")) {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerChannels(null);
            } else {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerChannels((String) json.getString("customerChannels"));
            }
        }
        if (json.has("billFrequencies")) {
            if (json.isNull("billFrequencies")) {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$billFrequencies(null);
            } else {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$billFrequencies((String) json.getString("billFrequencies"));
            }
        }
        if (json.has("vmAddresses")) {
            if (json.isNull("vmAddresses")) {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$vmAddresses(null);
            } else {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$vmAddresses((String) json.getString("vmAddresses"));
            }
        }
        if (json.has("hotLinePriorities")) {
            if (json.isNull("hotLinePriorities")) {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$hotLinePriorities(null);
            } else {
                ((FormSpinnerModelRealmProxyInterface) obj).realmSet$hotLinePriorities((String) json.getString("hotLinePriorities"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.FormSpinnerModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.FormSpinnerModel obj = new com.app.apsfl.models.FormSpinnerModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("customerTitles")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerTitles(null);
                } else {
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerTitles((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("customerSegments")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerSegments(null);
                } else {
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerSegments((String) reader.nextString());
                }
            } else if (name.equals("customerChannels")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerChannels(null);
                } else {
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$customerChannels((String) reader.nextString());
                }
            } else if (name.equals("billFrequencies")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$billFrequencies(null);
                } else {
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$billFrequencies((String) reader.nextString());
                }
            } else if (name.equals("vmAddresses")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$vmAddresses(null);
                } else {
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$vmAddresses((String) reader.nextString());
                }
            } else if (name.equals("hotLinePriorities")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$hotLinePriorities(null);
                } else {
                    ((FormSpinnerModelRealmProxyInterface) obj).realmSet$hotLinePriorities((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'customerTitles'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.FormSpinnerModel copyOrUpdate(Realm realm, com.app.apsfl.models.FormSpinnerModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.FormSpinnerModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.FormSpinnerModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.FormSpinnerModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((FormSpinnerModelRealmProxyInterface) object).realmGet$customerTitles();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.FormSpinnerModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.FormSpinnerModelRealmProxy();
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

    public static com.app.apsfl.models.FormSpinnerModel copy(Realm realm, com.app.apsfl.models.FormSpinnerModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.FormSpinnerModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.FormSpinnerModel realmObject = realm.createObjectInternal(com.app.apsfl.models.FormSpinnerModel.class, ((FormSpinnerModelRealmProxyInterface) newObject).realmGet$customerTitles(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$customerSegments(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$customerSegments());
            ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$customerChannels(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$customerChannels());
            ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$billFrequencies(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$billFrequencies());
            ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$vmAddresses(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$vmAddresses());
            ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$hotLinePriorities(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$hotLinePriorities());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.FormSpinnerModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.FormSpinnerModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        FormSpinnerModelColumnInfo columnInfo = (FormSpinnerModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.FormSpinnerModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((FormSpinnerModelRealmProxyInterface) object).realmGet$customerTitles();
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
        String realmGet$customerSegments = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerSegments();
        if (realmGet$customerSegments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerSegmentsIndex, rowIndex, realmGet$customerSegments, false);
        }
        String realmGet$customerChannels = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerChannels();
        if (realmGet$customerChannels != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerChannelsIndex, rowIndex, realmGet$customerChannels, false);
        }
        String realmGet$billFrequencies = ((FormSpinnerModelRealmProxyInterface)object).realmGet$billFrequencies();
        if (realmGet$billFrequencies != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billFrequenciesIndex, rowIndex, realmGet$billFrequencies, false);
        }
        String realmGet$vmAddresses = ((FormSpinnerModelRealmProxyInterface)object).realmGet$vmAddresses();
        if (realmGet$vmAddresses != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vmAddressesIndex, rowIndex, realmGet$vmAddresses, false);
        }
        String realmGet$hotLinePriorities = ((FormSpinnerModelRealmProxyInterface)object).realmGet$hotLinePriorities();
        if (realmGet$hotLinePriorities != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.hotLinePrioritiesIndex, rowIndex, realmGet$hotLinePriorities, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.FormSpinnerModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        FormSpinnerModelColumnInfo columnInfo = (FormSpinnerModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.FormSpinnerModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.FormSpinnerModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.FormSpinnerModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((FormSpinnerModelRealmProxyInterface) object).realmGet$customerTitles();
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
                String realmGet$customerSegments = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerSegments();
                if (realmGet$customerSegments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerSegmentsIndex, rowIndex, realmGet$customerSegments, false);
                }
                String realmGet$customerChannels = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerChannels();
                if (realmGet$customerChannels != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerChannelsIndex, rowIndex, realmGet$customerChannels, false);
                }
                String realmGet$billFrequencies = ((FormSpinnerModelRealmProxyInterface)object).realmGet$billFrequencies();
                if (realmGet$billFrequencies != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billFrequenciesIndex, rowIndex, realmGet$billFrequencies, false);
                }
                String realmGet$vmAddresses = ((FormSpinnerModelRealmProxyInterface)object).realmGet$vmAddresses();
                if (realmGet$vmAddresses != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.vmAddressesIndex, rowIndex, realmGet$vmAddresses, false);
                }
                String realmGet$hotLinePriorities = ((FormSpinnerModelRealmProxyInterface)object).realmGet$hotLinePriorities();
                if (realmGet$hotLinePriorities != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.hotLinePrioritiesIndex, rowIndex, realmGet$hotLinePriorities, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.FormSpinnerModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.FormSpinnerModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        FormSpinnerModelColumnInfo columnInfo = (FormSpinnerModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.FormSpinnerModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((FormSpinnerModelRealmProxyInterface) object).realmGet$customerTitles();
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
        String realmGet$customerSegments = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerSegments();
        if (realmGet$customerSegments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerSegmentsIndex, rowIndex, realmGet$customerSegments, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerSegmentsIndex, rowIndex, false);
        }
        String realmGet$customerChannels = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerChannels();
        if (realmGet$customerChannels != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerChannelsIndex, rowIndex, realmGet$customerChannels, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerChannelsIndex, rowIndex, false);
        }
        String realmGet$billFrequencies = ((FormSpinnerModelRealmProxyInterface)object).realmGet$billFrequencies();
        if (realmGet$billFrequencies != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.billFrequenciesIndex, rowIndex, realmGet$billFrequencies, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.billFrequenciesIndex, rowIndex, false);
        }
        String realmGet$vmAddresses = ((FormSpinnerModelRealmProxyInterface)object).realmGet$vmAddresses();
        if (realmGet$vmAddresses != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vmAddressesIndex, rowIndex, realmGet$vmAddresses, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.vmAddressesIndex, rowIndex, false);
        }
        String realmGet$hotLinePriorities = ((FormSpinnerModelRealmProxyInterface)object).realmGet$hotLinePriorities();
        if (realmGet$hotLinePriorities != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.hotLinePrioritiesIndex, rowIndex, realmGet$hotLinePriorities, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.hotLinePrioritiesIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.FormSpinnerModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        FormSpinnerModelColumnInfo columnInfo = (FormSpinnerModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.FormSpinnerModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.FormSpinnerModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.FormSpinnerModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((FormSpinnerModelRealmProxyInterface) object).realmGet$customerTitles();
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
                String realmGet$customerSegments = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerSegments();
                if (realmGet$customerSegments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerSegmentsIndex, rowIndex, realmGet$customerSegments, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerSegmentsIndex, rowIndex, false);
                }
                String realmGet$customerChannels = ((FormSpinnerModelRealmProxyInterface)object).realmGet$customerChannels();
                if (realmGet$customerChannels != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerChannelsIndex, rowIndex, realmGet$customerChannels, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerChannelsIndex, rowIndex, false);
                }
                String realmGet$billFrequencies = ((FormSpinnerModelRealmProxyInterface)object).realmGet$billFrequencies();
                if (realmGet$billFrequencies != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.billFrequenciesIndex, rowIndex, realmGet$billFrequencies, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.billFrequenciesIndex, rowIndex, false);
                }
                String realmGet$vmAddresses = ((FormSpinnerModelRealmProxyInterface)object).realmGet$vmAddresses();
                if (realmGet$vmAddresses != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.vmAddressesIndex, rowIndex, realmGet$vmAddresses, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.vmAddressesIndex, rowIndex, false);
                }
                String realmGet$hotLinePriorities = ((FormSpinnerModelRealmProxyInterface)object).realmGet$hotLinePriorities();
                if (realmGet$hotLinePriorities != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.hotLinePrioritiesIndex, rowIndex, realmGet$hotLinePriorities, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.hotLinePrioritiesIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.FormSpinnerModel createDetachedCopy(com.app.apsfl.models.FormSpinnerModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.FormSpinnerModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.FormSpinnerModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.FormSpinnerModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.FormSpinnerModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((FormSpinnerModelRealmProxyInterface) unmanagedObject).realmSet$customerTitles(((FormSpinnerModelRealmProxyInterface) realmObject).realmGet$customerTitles());
        ((FormSpinnerModelRealmProxyInterface) unmanagedObject).realmSet$customerSegments(((FormSpinnerModelRealmProxyInterface) realmObject).realmGet$customerSegments());
        ((FormSpinnerModelRealmProxyInterface) unmanagedObject).realmSet$customerChannels(((FormSpinnerModelRealmProxyInterface) realmObject).realmGet$customerChannels());
        ((FormSpinnerModelRealmProxyInterface) unmanagedObject).realmSet$billFrequencies(((FormSpinnerModelRealmProxyInterface) realmObject).realmGet$billFrequencies());
        ((FormSpinnerModelRealmProxyInterface) unmanagedObject).realmSet$vmAddresses(((FormSpinnerModelRealmProxyInterface) realmObject).realmGet$vmAddresses());
        ((FormSpinnerModelRealmProxyInterface) unmanagedObject).realmSet$hotLinePriorities(((FormSpinnerModelRealmProxyInterface) realmObject).realmGet$hotLinePriorities());
        return unmanagedObject;
    }

    static com.app.apsfl.models.FormSpinnerModel update(Realm realm, com.app.apsfl.models.FormSpinnerModel realmObject, com.app.apsfl.models.FormSpinnerModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$customerSegments(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$customerSegments());
        ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$customerChannels(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$customerChannels());
        ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$billFrequencies(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$billFrequencies());
        ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$vmAddresses(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$vmAddresses());
        ((FormSpinnerModelRealmProxyInterface) realmObject).realmSet$hotLinePriorities(((FormSpinnerModelRealmProxyInterface) newObject).realmGet$hotLinePriorities());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FormSpinnerModel = [");
        stringBuilder.append("{customerTitles:");
        stringBuilder.append(realmGet$customerTitles() != null ? realmGet$customerTitles() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{customerSegments:");
        stringBuilder.append(realmGet$customerSegments() != null ? realmGet$customerSegments() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{customerChannels:");
        stringBuilder.append(realmGet$customerChannels() != null ? realmGet$customerChannels() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{billFrequencies:");
        stringBuilder.append(realmGet$billFrequencies() != null ? realmGet$billFrequencies() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vmAddresses:");
        stringBuilder.append(realmGet$vmAddresses() != null ? realmGet$vmAddresses() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hotLinePriorities:");
        stringBuilder.append(realmGet$hotLinePriorities() != null ? realmGet$hotLinePriorities() : "null");
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
        FormSpinnerModelRealmProxy aFormSpinnerModel = (FormSpinnerModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFormSpinnerModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFormSpinnerModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFormSpinnerModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
