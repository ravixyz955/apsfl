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

public class IptvDataModelRealmProxy extends com.app.apsfl.models.IptvDataModel
    implements RealmObjectProxy, IptvDataModelRealmProxyInterface {

    static final class IptvDataModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long iptvpositionformTimeIndex;
        public long iptvpositionIndex;
        public long formTimeIndex;
        public long iptvBoxModelIndex;
        public long ipTVSerialNumberIndex;
        public long ipTVMacAddressIndex;
        public long noOfIptvInstallmentsIndex;
        public long iptvPriceForInstallmentIndex;
        public long stbModelPositionIndex;
        public long iptvPkgIndex;
        public long iptvBoxTaxIndex;
        public long upfrontAmountIndex;

        IptvDataModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(12);
            this.iptvpositionformTimeIndex = getValidColumnIndex(path, table, "IptvDataModel", "iptvpositionformTime");
            indicesMap.put("iptvpositionformTime", this.iptvpositionformTimeIndex);
            this.iptvpositionIndex = getValidColumnIndex(path, table, "IptvDataModel", "iptvposition");
            indicesMap.put("iptvposition", this.iptvpositionIndex);
            this.formTimeIndex = getValidColumnIndex(path, table, "IptvDataModel", "formTime");
            indicesMap.put("formTime", this.formTimeIndex);
            this.iptvBoxModelIndex = getValidColumnIndex(path, table, "IptvDataModel", "iptvBoxModel");
            indicesMap.put("iptvBoxModel", this.iptvBoxModelIndex);
            this.ipTVSerialNumberIndex = getValidColumnIndex(path, table, "IptvDataModel", "ipTVSerialNumber");
            indicesMap.put("ipTVSerialNumber", this.ipTVSerialNumberIndex);
            this.ipTVMacAddressIndex = getValidColumnIndex(path, table, "IptvDataModel", "ipTVMacAddress");
            indicesMap.put("ipTVMacAddress", this.ipTVMacAddressIndex);
            this.noOfIptvInstallmentsIndex = getValidColumnIndex(path, table, "IptvDataModel", "noOfIptvInstallments");
            indicesMap.put("noOfIptvInstallments", this.noOfIptvInstallmentsIndex);
            this.iptvPriceForInstallmentIndex = getValidColumnIndex(path, table, "IptvDataModel", "iptvPriceForInstallment");
            indicesMap.put("iptvPriceForInstallment", this.iptvPriceForInstallmentIndex);
            this.stbModelPositionIndex = getValidColumnIndex(path, table, "IptvDataModel", "stbModelPosition");
            indicesMap.put("stbModelPosition", this.stbModelPositionIndex);
            this.iptvPkgIndex = getValidColumnIndex(path, table, "IptvDataModel", "iptvPkg");
            indicesMap.put("iptvPkg", this.iptvPkgIndex);
            this.iptvBoxTaxIndex = getValidColumnIndex(path, table, "IptvDataModel", "iptvBoxTax");
            indicesMap.put("iptvBoxTax", this.iptvBoxTaxIndex);
            this.upfrontAmountIndex = getValidColumnIndex(path, table, "IptvDataModel", "upfrontAmount");
            indicesMap.put("upfrontAmount", this.upfrontAmountIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final IptvDataModelColumnInfo otherInfo = (IptvDataModelColumnInfo) other;
            this.iptvpositionformTimeIndex = otherInfo.iptvpositionformTimeIndex;
            this.iptvpositionIndex = otherInfo.iptvpositionIndex;
            this.formTimeIndex = otherInfo.formTimeIndex;
            this.iptvBoxModelIndex = otherInfo.iptvBoxModelIndex;
            this.ipTVSerialNumberIndex = otherInfo.ipTVSerialNumberIndex;
            this.ipTVMacAddressIndex = otherInfo.ipTVMacAddressIndex;
            this.noOfIptvInstallmentsIndex = otherInfo.noOfIptvInstallmentsIndex;
            this.iptvPriceForInstallmentIndex = otherInfo.iptvPriceForInstallmentIndex;
            this.stbModelPositionIndex = otherInfo.stbModelPositionIndex;
            this.iptvPkgIndex = otherInfo.iptvPkgIndex;
            this.iptvBoxTaxIndex = otherInfo.iptvBoxTaxIndex;
            this.upfrontAmountIndex = otherInfo.upfrontAmountIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final IptvDataModelColumnInfo clone() {
            return (IptvDataModelColumnInfo) super.clone();
        }

    }
    private IptvDataModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("iptvpositionformTime");
        fieldNames.add("iptvposition");
        fieldNames.add("formTime");
        fieldNames.add("iptvBoxModel");
        fieldNames.add("ipTVSerialNumber");
        fieldNames.add("ipTVMacAddress");
        fieldNames.add("noOfIptvInstallments");
        fieldNames.add("iptvPriceForInstallment");
        fieldNames.add("stbModelPosition");
        fieldNames.add("iptvPkg");
        fieldNames.add("iptvBoxTax");
        fieldNames.add("upfrontAmount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    IptvDataModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (IptvDataModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.IptvDataModel.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvpositionformTime() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvpositionformTimeIndex);
    }

    public void realmSet$iptvpositionformTime(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'iptvpositionformTime' cannot be changed after object was created.");
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
    public Long realmGet$formTime() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.formTimeIndex)) {
            return null;
        }
        return (long) proxyState.getRow$realm().getLong(columnInfo.formTimeIndex);
    }

    public void realmSet$formTime(Long value) {
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
                row.getTable().setNull(columnInfo.formTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.formTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.formTimeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.formTimeIndex, value);
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
    public String realmGet$ipTVMacAddress() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ipTVMacAddressIndex);
    }

    public void realmSet$ipTVMacAddress(String value) {
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
                row.getTable().setNull(columnInfo.ipTVMacAddressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ipTVMacAddressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ipTVMacAddressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ipTVMacAddressIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$noOfIptvInstallments() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.noOfIptvInstallmentsIndex);
    }

    public void realmSet$noOfIptvInstallments(String value) {
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
                row.getTable().setNull(columnInfo.noOfIptvInstallmentsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.noOfIptvInstallmentsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.noOfIptvInstallmentsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.noOfIptvInstallmentsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvPriceForInstallment() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvPriceForInstallmentIndex);
    }

    public void realmSet$iptvPriceForInstallment(String value) {
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
                row.getTable().setNull(columnInfo.iptvPriceForInstallmentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iptvPriceForInstallmentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iptvPriceForInstallmentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iptvPriceForInstallmentIndex, value);
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

    @SuppressWarnings("cast")
    public String realmGet$iptvBoxTax() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvBoxTaxIndex);
    }

    public void realmSet$iptvBoxTax(String value) {
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
                row.getTable().setNull(columnInfo.iptvBoxTaxIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iptvBoxTaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iptvBoxTaxIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iptvBoxTaxIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$upfrontAmount() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.upfrontAmountIndex);
    }

    public void realmSet$upfrontAmount(String value) {
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
                row.getTable().setNull(columnInfo.upfrontAmountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.upfrontAmountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.upfrontAmountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.upfrontAmountIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("IptvDataModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("IptvDataModel");
            realmObjectSchema.add(new Property("iptvpositionformTime", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvposition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("formTime", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvBoxModel", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("ipTVSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("ipTVMacAddress", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("noOfIptvInstallments", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvPriceForInstallment", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("stbModelPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvPkg", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvBoxTax", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("upfrontAmount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("IptvDataModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_IptvDataModel")) {
            Table table = sharedRealm.getTable("class_IptvDataModel");
            table.addColumn(RealmFieldType.STRING, "iptvpositionformTime", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "iptvposition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "formTime", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvBoxModel", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "ipTVSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "ipTVMacAddress", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "noOfIptvInstallments", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvPriceForInstallment", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "stbModelPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvPkg", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvBoxTax", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "upfrontAmount", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("iptvpositionformTime"));
            table.setPrimaryKey("iptvpositionformTime");
            return table;
        }
        return sharedRealm.getTable("class_IptvDataModel");
    }

    public static IptvDataModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_IptvDataModel")) {
            Table table = sharedRealm.getTable("class_IptvDataModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 12) {
                if (columnCount < 12) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 12 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 12 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 12 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 12; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final IptvDataModelColumnInfo columnInfo = new IptvDataModelColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("iptvpositionformTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvpositionformTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvpositionformTime") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvpositionformTime' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvpositionformTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'iptvpositionformTime' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("iptvpositionformTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'iptvpositionformTime' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("iptvpositionformTime"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'iptvpositionformTime' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            if (!columnTypes.containsKey("formTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'formTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("formTime") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Long' for field 'formTime' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.formTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'formTime' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'formTime' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("ipTVMacAddress")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'ipTVMacAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("ipTVMacAddress") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'ipTVMacAddress' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.ipTVMacAddressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'ipTVMacAddress' is required. Either set @Required to field 'ipTVMacAddress' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("noOfIptvInstallments")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'noOfIptvInstallments' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("noOfIptvInstallments") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'noOfIptvInstallments' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.noOfIptvInstallmentsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'noOfIptvInstallments' is required. Either set @Required to field 'noOfIptvInstallments' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvPriceForInstallment")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvPriceForInstallment' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvPriceForInstallment") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvPriceForInstallment' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvPriceForInstallmentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvPriceForInstallment' is required. Either set @Required to field 'iptvPriceForInstallment' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("iptvPkg")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvPkg' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvPkg") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvPkg' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvPkgIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvPkg' is required. Either set @Required to field 'iptvPkg' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvBoxTax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvBoxTax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvBoxTax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvBoxTax' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvBoxTaxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvBoxTax' is required. Either set @Required to field 'iptvBoxTax' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("upfrontAmount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'upfrontAmount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("upfrontAmount") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'upfrontAmount' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.upfrontAmountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'upfrontAmount' is required. Either set @Required to field 'upfrontAmount' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'IptvDataModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_IptvDataModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.IptvDataModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.app.apsfl.models.IptvDataModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.IptvDataModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("iptvpositionformTime")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("iptvpositionformTime"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.IptvDataModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.IptvDataModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("iptvpositionformTime")) {
                if (json.isNull("iptvpositionformTime")) {
                    obj = (io.realm.IptvDataModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.IptvDataModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.IptvDataModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.IptvDataModel.class, json.getString("iptvpositionformTime"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'iptvpositionformTime'.");
            }
        }
        if (json.has("iptvposition")) {
            if (json.isNull("iptvposition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iptvposition' to null.");
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvposition((int) json.getInt("iptvposition"));
            }
        }
        if (json.has("formTime")) {
            if (json.isNull("formTime")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$formTime(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$formTime((long) json.getLong("formTime"));
            }
        }
        if (json.has("iptvBoxModel")) {
            if (json.isNull("iptvBoxModel")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel((String) json.getString("iptvBoxModel"));
            }
        }
        if (json.has("ipTVSerialNumber")) {
            if (json.isNull("ipTVSerialNumber")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber((String) json.getString("ipTVSerialNumber"));
            }
        }
        if (json.has("ipTVMacAddress")) {
            if (json.isNull("ipTVMacAddress")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVMacAddress(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVMacAddress((String) json.getString("ipTVMacAddress"));
            }
        }
        if (json.has("noOfIptvInstallments")) {
            if (json.isNull("noOfIptvInstallments")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$noOfIptvInstallments(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$noOfIptvInstallments((String) json.getString("noOfIptvInstallments"));
            }
        }
        if (json.has("iptvPriceForInstallment")) {
            if (json.isNull("iptvPriceForInstallment")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPriceForInstallment(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPriceForInstallment((String) json.getString("iptvPriceForInstallment"));
            }
        }
        if (json.has("stbModelPosition")) {
            if (json.isNull("stbModelPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'stbModelPosition' to null.");
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$stbModelPosition((int) json.getInt("stbModelPosition"));
            }
        }
        if (json.has("iptvPkg")) {
            if (json.isNull("iptvPkg")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPkg(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPkg((String) json.getString("iptvPkg"));
            }
        }
        if (json.has("iptvBoxTax")) {
            if (json.isNull("iptvBoxTax")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxTax(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxTax((String) json.getString("iptvBoxTax"));
            }
        }
        if (json.has("upfrontAmount")) {
            if (json.isNull("upfrontAmount")) {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$upfrontAmount(null);
            } else {
                ((IptvDataModelRealmProxyInterface) obj).realmSet$upfrontAmount((String) json.getString("upfrontAmount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.IptvDataModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.IptvDataModel obj = new com.app.apsfl.models.IptvDataModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("iptvpositionformTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvpositionformTime(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvpositionformTime((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("iptvposition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iptvposition' to null.");
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvposition((int) reader.nextInt());
                }
            } else if (name.equals("formTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$formTime(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$formTime((long) reader.nextLong());
                }
            } else if (name.equals("iptvBoxModel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxModel((String) reader.nextString());
                }
            } else if (name.equals("ipTVSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("ipTVMacAddress")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVMacAddress(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$ipTVMacAddress((String) reader.nextString());
                }
            } else if (name.equals("noOfIptvInstallments")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$noOfIptvInstallments(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$noOfIptvInstallments((String) reader.nextString());
                }
            } else if (name.equals("iptvPriceForInstallment")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPriceForInstallment(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPriceForInstallment((String) reader.nextString());
                }
            } else if (name.equals("stbModelPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'stbModelPosition' to null.");
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$stbModelPosition((int) reader.nextInt());
                }
            } else if (name.equals("iptvPkg")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPkg(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvPkg((String) reader.nextString());
                }
            } else if (name.equals("iptvBoxTax")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxTax(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$iptvBoxTax((String) reader.nextString());
                }
            } else if (name.equals("upfrontAmount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$upfrontAmount(null);
                } else {
                    ((IptvDataModelRealmProxyInterface) obj).realmSet$upfrontAmount((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'iptvpositionformTime'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.app.apsfl.models.IptvDataModel copyOrUpdate(Realm realm, com.app.apsfl.models.IptvDataModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.IptvDataModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.IptvDataModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.IptvDataModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((IptvDataModelRealmProxyInterface) object).realmGet$iptvpositionformTime();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.IptvDataModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.IptvDataModelRealmProxy();
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

    public static com.app.apsfl.models.IptvDataModel copy(Realm realm, com.app.apsfl.models.IptvDataModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.IptvDataModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.IptvDataModel realmObject = realm.createObjectInternal(com.app.apsfl.models.IptvDataModel.class, ((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvpositionformTime(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvposition(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvposition());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$formTime(((IptvDataModelRealmProxyInterface) newObject).realmGet$formTime());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvBoxModel(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvBoxModel());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$ipTVSerialNumber(((IptvDataModelRealmProxyInterface) newObject).realmGet$ipTVSerialNumber());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$ipTVMacAddress(((IptvDataModelRealmProxyInterface) newObject).realmGet$ipTVMacAddress());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$noOfIptvInstallments(((IptvDataModelRealmProxyInterface) newObject).realmGet$noOfIptvInstallments());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvPriceForInstallment(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvPriceForInstallment());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$stbModelPosition(((IptvDataModelRealmProxyInterface) newObject).realmGet$stbModelPosition());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvPkg(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvPkg());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvBoxTax(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvBoxTax());
            ((IptvDataModelRealmProxyInterface) realmObject).realmSet$upfrontAmount(((IptvDataModelRealmProxyInterface) newObject).realmGet$upfrontAmount());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.IptvDataModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.IptvDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvDataModelColumnInfo columnInfo = (IptvDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((IptvDataModelRealmProxyInterface) object).realmGet$iptvpositionformTime();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
        Number realmGet$formTime = ((IptvDataModelRealmProxyInterface)object).realmGet$formTime();
        if (realmGet$formTime != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.formTimeIndex, rowIndex, realmGet$formTime.longValue(), false);
        }
        String realmGet$iptvBoxModel = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
        if (realmGet$iptvBoxModel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
        }
        String realmGet$ipTVSerialNumber = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
        if (realmGet$ipTVSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
        }
        String realmGet$ipTVMacAddress = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVMacAddress();
        if (realmGet$ipTVMacAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ipTVMacAddressIndex, rowIndex, realmGet$ipTVMacAddress, false);
        }
        String realmGet$noOfIptvInstallments = ((IptvDataModelRealmProxyInterface)object).realmGet$noOfIptvInstallments();
        if (realmGet$noOfIptvInstallments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noOfIptvInstallmentsIndex, rowIndex, realmGet$noOfIptvInstallments, false);
        }
        String realmGet$iptvPriceForInstallment = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPriceForInstallment();
        if (realmGet$iptvPriceForInstallment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPriceForInstallmentIndex, rowIndex, realmGet$iptvPriceForInstallment, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
        String realmGet$iptvPkg = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPkg();
        if (realmGet$iptvPkg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
        }
        String realmGet$iptvBoxTax = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxTax();
        if (realmGet$iptvBoxTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxTaxIndex, rowIndex, realmGet$iptvBoxTax, false);
        }
        String realmGet$upfrontAmount = ((IptvDataModelRealmProxyInterface)object).realmGet$upfrontAmount();
        if (realmGet$upfrontAmount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.upfrontAmountIndex, rowIndex, realmGet$upfrontAmount, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.IptvDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvDataModelColumnInfo columnInfo = (IptvDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.IptvDataModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.IptvDataModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((IptvDataModelRealmProxyInterface) object).realmGet$iptvpositionformTime();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
                Number realmGet$formTime = ((IptvDataModelRealmProxyInterface)object).realmGet$formTime();
                if (realmGet$formTime != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.formTimeIndex, rowIndex, realmGet$formTime.longValue(), false);
                }
                String realmGet$iptvBoxModel = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
                if (realmGet$iptvBoxModel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
                }
                String realmGet$ipTVSerialNumber = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
                if (realmGet$ipTVSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
                }
                String realmGet$ipTVMacAddress = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVMacAddress();
                if (realmGet$ipTVMacAddress != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.ipTVMacAddressIndex, rowIndex, realmGet$ipTVMacAddress, false);
                }
                String realmGet$noOfIptvInstallments = ((IptvDataModelRealmProxyInterface)object).realmGet$noOfIptvInstallments();
                if (realmGet$noOfIptvInstallments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noOfIptvInstallmentsIndex, rowIndex, realmGet$noOfIptvInstallments, false);
                }
                String realmGet$iptvPriceForInstallment = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPriceForInstallment();
                if (realmGet$iptvPriceForInstallment != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPriceForInstallmentIndex, rowIndex, realmGet$iptvPriceForInstallment, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
                String realmGet$iptvPkg = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPkg();
                if (realmGet$iptvPkg != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
                }
                String realmGet$iptvBoxTax = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxTax();
                if (realmGet$iptvBoxTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxTaxIndex, rowIndex, realmGet$iptvBoxTax, false);
                }
                String realmGet$upfrontAmount = ((IptvDataModelRealmProxyInterface)object).realmGet$upfrontAmount();
                if (realmGet$upfrontAmount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.upfrontAmountIndex, rowIndex, realmGet$upfrontAmount, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.IptvDataModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.IptvDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvDataModelColumnInfo columnInfo = (IptvDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((IptvDataModelRealmProxyInterface) object).realmGet$iptvpositionformTime();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
        Number realmGet$formTime = ((IptvDataModelRealmProxyInterface)object).realmGet$formTime();
        if (realmGet$formTime != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.formTimeIndex, rowIndex, realmGet$formTime.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.formTimeIndex, rowIndex, false);
        }
        String realmGet$iptvBoxModel = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
        if (realmGet$iptvBoxModel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, false);
        }
        String realmGet$ipTVSerialNumber = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
        if (realmGet$ipTVSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, false);
        }
        String realmGet$ipTVMacAddress = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVMacAddress();
        if (realmGet$ipTVMacAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ipTVMacAddressIndex, rowIndex, realmGet$ipTVMacAddress, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ipTVMacAddressIndex, rowIndex, false);
        }
        String realmGet$noOfIptvInstallments = ((IptvDataModelRealmProxyInterface)object).realmGet$noOfIptvInstallments();
        if (realmGet$noOfIptvInstallments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noOfIptvInstallmentsIndex, rowIndex, realmGet$noOfIptvInstallments, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.noOfIptvInstallmentsIndex, rowIndex, false);
        }
        String realmGet$iptvPriceForInstallment = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPriceForInstallment();
        if (realmGet$iptvPriceForInstallment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPriceForInstallmentIndex, rowIndex, realmGet$iptvPriceForInstallment, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvPriceForInstallmentIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
        String realmGet$iptvPkg = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPkg();
        if (realmGet$iptvPkg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, false);
        }
        String realmGet$iptvBoxTax = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxTax();
        if (realmGet$iptvBoxTax != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxTaxIndex, rowIndex, realmGet$iptvBoxTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvBoxTaxIndex, rowIndex, false);
        }
        String realmGet$upfrontAmount = ((IptvDataModelRealmProxyInterface)object).realmGet$upfrontAmount();
        if (realmGet$upfrontAmount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.upfrontAmountIndex, rowIndex, realmGet$upfrontAmount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.upfrontAmountIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.IptvDataModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        IptvDataModelColumnInfo columnInfo = (IptvDataModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.IptvDataModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.IptvDataModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.IptvDataModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((IptvDataModelRealmProxyInterface) object).realmGet$iptvpositionformTime();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvpositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$iptvposition(), false);
                Number realmGet$formTime = ((IptvDataModelRealmProxyInterface)object).realmGet$formTime();
                if (realmGet$formTime != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.formTimeIndex, rowIndex, realmGet$formTime.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.formTimeIndex, rowIndex, false);
                }
                String realmGet$iptvBoxModel = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxModel();
                if (realmGet$iptvBoxModel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, realmGet$iptvBoxModel, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvBoxModelIndex, rowIndex, false);
                }
                String realmGet$ipTVSerialNumber = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVSerialNumber();
                if (realmGet$ipTVSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, realmGet$ipTVSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.ipTVSerialNumberIndex, rowIndex, false);
                }
                String realmGet$ipTVMacAddress = ((IptvDataModelRealmProxyInterface)object).realmGet$ipTVMacAddress();
                if (realmGet$ipTVMacAddress != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.ipTVMacAddressIndex, rowIndex, realmGet$ipTVMacAddress, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.ipTVMacAddressIndex, rowIndex, false);
                }
                String realmGet$noOfIptvInstallments = ((IptvDataModelRealmProxyInterface)object).realmGet$noOfIptvInstallments();
                if (realmGet$noOfIptvInstallments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noOfIptvInstallmentsIndex, rowIndex, realmGet$noOfIptvInstallments, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.noOfIptvInstallmentsIndex, rowIndex, false);
                }
                String realmGet$iptvPriceForInstallment = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPriceForInstallment();
                if (realmGet$iptvPriceForInstallment != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPriceForInstallmentIndex, rowIndex, realmGet$iptvPriceForInstallment, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvPriceForInstallmentIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.stbModelPositionIndex, rowIndex, ((IptvDataModelRealmProxyInterface)object).realmGet$stbModelPosition(), false);
                String realmGet$iptvPkg = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvPkg();
                if (realmGet$iptvPkg != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, realmGet$iptvPkg, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvPkgIndex, rowIndex, false);
                }
                String realmGet$iptvBoxTax = ((IptvDataModelRealmProxyInterface)object).realmGet$iptvBoxTax();
                if (realmGet$iptvBoxTax != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvBoxTaxIndex, rowIndex, realmGet$iptvBoxTax, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvBoxTaxIndex, rowIndex, false);
                }
                String realmGet$upfrontAmount = ((IptvDataModelRealmProxyInterface)object).realmGet$upfrontAmount();
                if (realmGet$upfrontAmount != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.upfrontAmountIndex, rowIndex, realmGet$upfrontAmount, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.upfrontAmountIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.IptvDataModel createDetachedCopy(com.app.apsfl.models.IptvDataModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.IptvDataModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.IptvDataModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.IptvDataModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.IptvDataModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvpositionformTime(((IptvDataModelRealmProxyInterface) realmObject).realmGet$iptvpositionformTime());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvposition(((IptvDataModelRealmProxyInterface) realmObject).realmGet$iptvposition());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$formTime(((IptvDataModelRealmProxyInterface) realmObject).realmGet$formTime());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvBoxModel(((IptvDataModelRealmProxyInterface) realmObject).realmGet$iptvBoxModel());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$ipTVSerialNumber(((IptvDataModelRealmProxyInterface) realmObject).realmGet$ipTVSerialNumber());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$ipTVMacAddress(((IptvDataModelRealmProxyInterface) realmObject).realmGet$ipTVMacAddress());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$noOfIptvInstallments(((IptvDataModelRealmProxyInterface) realmObject).realmGet$noOfIptvInstallments());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvPriceForInstallment(((IptvDataModelRealmProxyInterface) realmObject).realmGet$iptvPriceForInstallment());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$stbModelPosition(((IptvDataModelRealmProxyInterface) realmObject).realmGet$stbModelPosition());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvPkg(((IptvDataModelRealmProxyInterface) realmObject).realmGet$iptvPkg());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$iptvBoxTax(((IptvDataModelRealmProxyInterface) realmObject).realmGet$iptvBoxTax());
        ((IptvDataModelRealmProxyInterface) unmanagedObject).realmSet$upfrontAmount(((IptvDataModelRealmProxyInterface) realmObject).realmGet$upfrontAmount());
        return unmanagedObject;
    }

    static com.app.apsfl.models.IptvDataModel update(Realm realm, com.app.apsfl.models.IptvDataModel realmObject, com.app.apsfl.models.IptvDataModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvposition(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvposition());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$formTime(((IptvDataModelRealmProxyInterface) newObject).realmGet$formTime());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvBoxModel(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvBoxModel());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$ipTVSerialNumber(((IptvDataModelRealmProxyInterface) newObject).realmGet$ipTVSerialNumber());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$ipTVMacAddress(((IptvDataModelRealmProxyInterface) newObject).realmGet$ipTVMacAddress());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$noOfIptvInstallments(((IptvDataModelRealmProxyInterface) newObject).realmGet$noOfIptvInstallments());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvPriceForInstallment(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvPriceForInstallment());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$stbModelPosition(((IptvDataModelRealmProxyInterface) newObject).realmGet$stbModelPosition());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvPkg(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvPkg());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$iptvBoxTax(((IptvDataModelRealmProxyInterface) newObject).realmGet$iptvBoxTax());
        ((IptvDataModelRealmProxyInterface) realmObject).realmSet$upfrontAmount(((IptvDataModelRealmProxyInterface) newObject).realmGet$upfrontAmount());
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
        IptvDataModelRealmProxy aIptvDataModel = (IptvDataModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aIptvDataModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aIptvDataModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aIptvDataModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
