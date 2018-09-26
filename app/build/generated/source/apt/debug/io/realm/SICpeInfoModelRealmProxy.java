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

public class SICpeInfoModelRealmProxy extends com.app.apsfl.models.SICpeInfoModel
    implements RealmObjectProxy, SICpeInfoModelRealmProxyInterface {

    static final class SICpeInfoModelColumnInfo extends ColumnInfo
        implements Cloneable {

        public long apsflTrackIdIndex;
        public long packageDetailsIndex;
        public long popDistIdIndex;
        public long popMandalIdIndex;
        public long popIdIndex;
        public long selectedPopDistrictIndex;
        public long selectedPopMandalIndex;
        public long selectedPopIndex;
        public long oltIdPositionIndex;
        public long oltPortIdPositionIndex;
        public long onuModelPositionIndex;
        public long onuSerialNumberIndex;
        public long iptvPositionIndex;
        public long iptvSerialNumberIndex;
        public long vpnPositionIndex;
        public long teleConnCountPositionIndex;
        public long selectedIptvListIndex;
        public long iptvPackagesIndex;

        SICpeInfoModelColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(18);
            this.apsflTrackIdIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "apsflTrackId");
            indicesMap.put("apsflTrackId", this.apsflTrackIdIndex);
            this.packageDetailsIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "packageDetails");
            indicesMap.put("packageDetails", this.packageDetailsIndex);
            this.popDistIdIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "popDistId");
            indicesMap.put("popDistId", this.popDistIdIndex);
            this.popMandalIdIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "popMandalId");
            indicesMap.put("popMandalId", this.popMandalIdIndex);
            this.popIdIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "popId");
            indicesMap.put("popId", this.popIdIndex);
            this.selectedPopDistrictIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "selectedPopDistrict");
            indicesMap.put("selectedPopDistrict", this.selectedPopDistrictIndex);
            this.selectedPopMandalIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "selectedPopMandal");
            indicesMap.put("selectedPopMandal", this.selectedPopMandalIndex);
            this.selectedPopIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "selectedPop");
            indicesMap.put("selectedPop", this.selectedPopIndex);
            this.oltIdPositionIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "oltIdPosition");
            indicesMap.put("oltIdPosition", this.oltIdPositionIndex);
            this.oltPortIdPositionIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "oltPortIdPosition");
            indicesMap.put("oltPortIdPosition", this.oltPortIdPositionIndex);
            this.onuModelPositionIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "onuModelPosition");
            indicesMap.put("onuModelPosition", this.onuModelPositionIndex);
            this.onuSerialNumberIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "onuSerialNumber");
            indicesMap.put("onuSerialNumber", this.onuSerialNumberIndex);
            this.iptvPositionIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "iptvPosition");
            indicesMap.put("iptvPosition", this.iptvPositionIndex);
            this.iptvSerialNumberIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "iptvSerialNumber");
            indicesMap.put("iptvSerialNumber", this.iptvSerialNumberIndex);
            this.vpnPositionIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "vpnPosition");
            indicesMap.put("vpnPosition", this.vpnPositionIndex);
            this.teleConnCountPositionIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "teleConnCountPosition");
            indicesMap.put("teleConnCountPosition", this.teleConnCountPositionIndex);
            this.selectedIptvListIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "selectedIptvList");
            indicesMap.put("selectedIptvList", this.selectedIptvListIndex);
            this.iptvPackagesIndex = getValidColumnIndex(path, table, "SICpeInfoModel", "iptvPackages");
            indicesMap.put("iptvPackages", this.iptvPackagesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final SICpeInfoModelColumnInfo otherInfo = (SICpeInfoModelColumnInfo) other;
            this.apsflTrackIdIndex = otherInfo.apsflTrackIdIndex;
            this.packageDetailsIndex = otherInfo.packageDetailsIndex;
            this.popDistIdIndex = otherInfo.popDistIdIndex;
            this.popMandalIdIndex = otherInfo.popMandalIdIndex;
            this.popIdIndex = otherInfo.popIdIndex;
            this.selectedPopDistrictIndex = otherInfo.selectedPopDistrictIndex;
            this.selectedPopMandalIndex = otherInfo.selectedPopMandalIndex;
            this.selectedPopIndex = otherInfo.selectedPopIndex;
            this.oltIdPositionIndex = otherInfo.oltIdPositionIndex;
            this.oltPortIdPositionIndex = otherInfo.oltPortIdPositionIndex;
            this.onuModelPositionIndex = otherInfo.onuModelPositionIndex;
            this.onuSerialNumberIndex = otherInfo.onuSerialNumberIndex;
            this.iptvPositionIndex = otherInfo.iptvPositionIndex;
            this.iptvSerialNumberIndex = otherInfo.iptvSerialNumberIndex;
            this.vpnPositionIndex = otherInfo.vpnPositionIndex;
            this.teleConnCountPositionIndex = otherInfo.teleConnCountPositionIndex;
            this.selectedIptvListIndex = otherInfo.selectedIptvListIndex;
            this.iptvPackagesIndex = otherInfo.iptvPackagesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final SICpeInfoModelColumnInfo clone() {
            return (SICpeInfoModelColumnInfo) super.clone();
        }

    }
    private SICpeInfoModelColumnInfo columnInfo;
    private ProxyState proxyState;
    private RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("apsflTrackId");
        fieldNames.add("packageDetails");
        fieldNames.add("popDistId");
        fieldNames.add("popMandalId");
        fieldNames.add("popId");
        fieldNames.add("selectedPopDistrict");
        fieldNames.add("selectedPopMandal");
        fieldNames.add("selectedPop");
        fieldNames.add("oltIdPosition");
        fieldNames.add("oltPortIdPosition");
        fieldNames.add("onuModelPosition");
        fieldNames.add("onuSerialNumber");
        fieldNames.add("iptvPosition");
        fieldNames.add("iptvSerialNumber");
        fieldNames.add("vpnPosition");
        fieldNames.add("teleConnCountPosition");
        fieldNames.add("selectedIptvList");
        fieldNames.add("iptvPackages");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SICpeInfoModelRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SICpeInfoModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.app.apsfl.models.SICpeInfoModel.class, this);
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
    public String realmGet$packageDetails() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.packageDetailsIndex);
    }

    public void realmSet$packageDetails(String value) {
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
                row.getTable().setNull(columnInfo.packageDetailsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.packageDetailsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.packageDetailsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.packageDetailsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popDistId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popDistIdIndex);
    }

    public void realmSet$popDistId(String value) {
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
                row.getTable().setNull(columnInfo.popDistIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popDistIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popDistIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popDistIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popMandalId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popMandalIdIndex);
    }

    public void realmSet$popMandalId(String value) {
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
                row.getTable().setNull(columnInfo.popMandalIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popMandalIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popMandalIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popMandalIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$popId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popIdIndex);
    }

    public void realmSet$popId(String value) {
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
                row.getTable().setNull(columnInfo.popIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$selectedPopDistrict() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.selectedPopDistrictIndex);
    }

    public void realmSet$selectedPopDistrict(String value) {
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
                row.getTable().setNull(columnInfo.selectedPopDistrictIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.selectedPopDistrictIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.selectedPopDistrictIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.selectedPopDistrictIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$selectedPopMandal() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.selectedPopMandalIndex);
    }

    public void realmSet$selectedPopMandal(String value) {
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
                row.getTable().setNull(columnInfo.selectedPopMandalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.selectedPopMandalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.selectedPopMandalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.selectedPopMandalIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$selectedPop() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.selectedPopIndex);
    }

    public void realmSet$selectedPop(String value) {
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
                row.getTable().setNull(columnInfo.selectedPopIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.selectedPopIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.selectedPopIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.selectedPopIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$oltIdPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.oltIdPositionIndex);
    }

    public void realmSet$oltIdPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.oltIdPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.oltIdPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$oltPortIdPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.oltPortIdPositionIndex);
    }

    public void realmSet$oltPortIdPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.oltPortIdPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.oltPortIdPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$onuModelPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.onuModelPositionIndex);
    }

    public void realmSet$onuModelPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.onuModelPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.onuModelPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$onuSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.onuSerialNumberIndex);
    }

    public void realmSet$onuSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.onuSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.onuSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.onuSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.onuSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$iptvPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.iptvPositionIndex);
    }

    public void realmSet$iptvPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.iptvPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.iptvPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvSerialNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvSerialNumberIndex);
    }

    public void realmSet$iptvSerialNumber(String value) {
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
                row.getTable().setNull(columnInfo.iptvSerialNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iptvSerialNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iptvSerialNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iptvSerialNumberIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$vpnPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.vpnPositionIndex);
    }

    public void realmSet$vpnPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.vpnPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.vpnPositionIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$teleConnCountPosition() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.teleConnCountPositionIndex);
    }

    public void realmSet$teleConnCountPosition(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.teleConnCountPositionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.teleConnCountPositionIndex, value);
    }

    public RealmList<com.app.apsfl.models.IptvSIDataModel> realmGet$selectedIptvList() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (selectedIptvListRealmList != null) {
            return selectedIptvListRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.selectedIptvListIndex);
            selectedIptvListRealmList = new RealmList<com.app.apsfl.models.IptvSIDataModel>(com.app.apsfl.models.IptvSIDataModel.class, linkView, proxyState.getRealm$realm());
            return selectedIptvListRealmList;
        }
    }

    public void realmSet$selectedIptvList(RealmList<com.app.apsfl.models.IptvSIDataModel> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("selectedIptvList")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.app.apsfl.models.IptvSIDataModel> original = value;
                value = new RealmList<com.app.apsfl.models.IptvSIDataModel>();
                for (com.app.apsfl.models.IptvSIDataModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.selectedIptvListIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @SuppressWarnings("cast")
    public String realmGet$iptvPackages() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iptvPackagesIndex);
    }

    public void realmSet$iptvPackages(String value) {
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
                row.getTable().setNull(columnInfo.iptvPackagesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iptvPackagesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iptvPackagesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iptvPackagesIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("SICpeInfoModel")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("SICpeInfoModel");
            realmObjectSchema.add(new Property("apsflTrackId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("packageDetails", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popDistId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popMandalId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("selectedPopDistrict", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("selectedPopMandal", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("selectedPop", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("oltIdPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("oltPortIdPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("onuModelPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("onuSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("iptvSerialNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("vpnPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("teleConnCountPosition", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            if (!realmSchema.contains("IptvSIDataModel")) {
                IptvSIDataModelRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("selectedIptvList", RealmFieldType.LIST, realmSchema.get("IptvSIDataModel")));
            realmObjectSchema.add(new Property("iptvPackages", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("SICpeInfoModel");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_SICpeInfoModel")) {
            Table table = sharedRealm.getTable("class_SICpeInfoModel");
            table.addColumn(RealmFieldType.STRING, "apsflTrackId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "packageDetails", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popDistId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popMandalId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "popId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "selectedPopDistrict", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "selectedPopMandal", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "selectedPop", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "oltIdPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "oltPortIdPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "onuModelPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "onuSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "iptvPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "iptvSerialNumber", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "vpnPosition", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "teleConnCountPosition", Table.NOT_NULLABLE);
            if (!sharedRealm.hasTable("class_IptvSIDataModel")) {
                IptvSIDataModelRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "selectedIptvList", sharedRealm.getTable("class_IptvSIDataModel"));
            table.addColumn(RealmFieldType.STRING, "iptvPackages", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("apsflTrackId"));
            table.setPrimaryKey("apsflTrackId");
            return table;
        }
        return sharedRealm.getTable("class_SICpeInfoModel");
    }

    public static SICpeInfoModelColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SICpeInfoModel")) {
            Table table = sharedRealm.getTable("class_SICpeInfoModel");
            final long columnCount = table.getColumnCount();
            if (columnCount != 18) {
                if (columnCount < 18) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 18 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 18 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 18 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 18; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final SICpeInfoModelColumnInfo columnInfo = new SICpeInfoModelColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("packageDetails")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'packageDetails' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("packageDetails") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'packageDetails' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.packageDetailsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'packageDetails' is required. Either set @Required to field 'packageDetails' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popDistId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popDistId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popDistId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popDistId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popDistIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popDistId' is required. Either set @Required to field 'popDistId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popMandalId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popMandalId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popMandalId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popMandalId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popMandalIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popMandalId' is required. Either set @Required to field 'popMandalId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'popId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'popId' is required. Either set @Required to field 'popId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedPopDistrict")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedPopDistrict' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("selectedPopDistrict") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'selectedPopDistrict' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.selectedPopDistrictIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'selectedPopDistrict' is required. Either set @Required to field 'selectedPopDistrict' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedPopMandal")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedPopMandal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("selectedPopMandal") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'selectedPopMandal' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.selectedPopMandalIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'selectedPopMandal' is required. Either set @Required to field 'selectedPopMandal' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedPop")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedPop' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("selectedPop") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'selectedPop' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.selectedPopIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'selectedPop' is required. Either set @Required to field 'selectedPop' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("oltIdPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'oltIdPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("oltIdPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'oltIdPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.oltIdPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'oltIdPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'oltIdPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("oltPortIdPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'oltPortIdPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("oltPortIdPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'oltPortIdPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.oltPortIdPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'oltPortIdPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'oltPortIdPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuModelPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuModelPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuModelPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'onuModelPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.onuModelPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuModelPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'onuModelPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("onuSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'onuSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("onuSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'onuSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.onuSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'onuSerialNumber' is required. Either set @Required to field 'onuSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'iptvPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.iptvPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'iptvPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("iptvSerialNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvSerialNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvSerialNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvSerialNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvSerialNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvSerialNumber' is required. Either set @Required to field 'iptvSerialNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("vpnPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'vpnPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("vpnPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'vpnPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.vpnPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'vpnPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'vpnPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("teleConnCountPosition")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'teleConnCountPosition' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("teleConnCountPosition") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'teleConnCountPosition' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.teleConnCountPositionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'teleConnCountPosition' does support null values in the existing Realm file. Use corresponding boxed type for field 'teleConnCountPosition' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("selectedIptvList")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selectedIptvList'");
            }
            if (columnTypes.get("selectedIptvList") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'IptvSIDataModel' for field 'selectedIptvList'");
            }
            if (!sharedRealm.hasTable("class_IptvSIDataModel")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_IptvSIDataModel' for field 'selectedIptvList'");
            }
            Table table_16 = sharedRealm.getTable("class_IptvSIDataModel");
            if (!table.getLinkTarget(columnInfo.selectedIptvListIndex).hasSameSchema(table_16)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'selectedIptvList': '" + table.getLinkTarget(columnInfo.selectedIptvListIndex).getName() + "' expected - was '" + table_16.getName() + "'");
            }
            if (!columnTypes.containsKey("iptvPackages")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iptvPackages' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iptvPackages") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iptvPackages' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iptvPackagesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iptvPackages' is required. Either set @Required to field 'iptvPackages' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SICpeInfoModel' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SICpeInfoModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.app.apsfl.models.SICpeInfoModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.app.apsfl.models.SICpeInfoModel obj = null;
        if (update) {
            Table table = realm.getTable(com.app.apsfl.models.SICpeInfoModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SICpeInfoModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.SICpeInfoModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("selectedIptvList")) {
                excludeFields.add("selectedIptvList");
            }
            if (json.has("apsflTrackId")) {
                if (json.isNull("apsflTrackId")) {
                    obj = (io.realm.SICpeInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SICpeInfoModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.SICpeInfoModelRealmProxy) realm.createObjectInternal(com.app.apsfl.models.SICpeInfoModel.class, json.getString("apsflTrackId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'apsflTrackId'.");
            }
        }
        if (json.has("packageDetails")) {
            if (json.isNull("packageDetails")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$packageDetails(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$packageDetails((String) json.getString("packageDetails"));
            }
        }
        if (json.has("popDistId")) {
            if (json.isNull("popDistId")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popDistId(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popDistId((String) json.getString("popDistId"));
            }
        }
        if (json.has("popMandalId")) {
            if (json.isNull("popMandalId")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popMandalId(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popMandalId((String) json.getString("popMandalId"));
            }
        }
        if (json.has("popId")) {
            if (json.isNull("popId")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popId(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popId((String) json.getString("popId"));
            }
        }
        if (json.has("selectedPopDistrict")) {
            if (json.isNull("selectedPopDistrict")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopDistrict(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopDistrict((String) json.getString("selectedPopDistrict"));
            }
        }
        if (json.has("selectedPopMandal")) {
            if (json.isNull("selectedPopMandal")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopMandal(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopMandal((String) json.getString("selectedPopMandal"));
            }
        }
        if (json.has("selectedPop")) {
            if (json.isNull("selectedPop")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPop(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPop((String) json.getString("selectedPop"));
            }
        }
        if (json.has("oltIdPosition")) {
            if (json.isNull("oltIdPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'oltIdPosition' to null.");
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$oltIdPosition((int) json.getInt("oltIdPosition"));
            }
        }
        if (json.has("oltPortIdPosition")) {
            if (json.isNull("oltPortIdPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'oltPortIdPosition' to null.");
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$oltPortIdPosition((int) json.getInt("oltPortIdPosition"));
            }
        }
        if (json.has("onuModelPosition")) {
            if (json.isNull("onuModelPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'onuModelPosition' to null.");
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$onuModelPosition((int) json.getInt("onuModelPosition"));
            }
        }
        if (json.has("onuSerialNumber")) {
            if (json.isNull("onuSerialNumber")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber((String) json.getString("onuSerialNumber"));
            }
        }
        if (json.has("iptvPosition")) {
            if (json.isNull("iptvPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iptvPosition' to null.");
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvPosition((int) json.getInt("iptvPosition"));
            }
        }
        if (json.has("iptvSerialNumber")) {
            if (json.isNull("iptvSerialNumber")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvSerialNumber(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvSerialNumber((String) json.getString("iptvSerialNumber"));
            }
        }
        if (json.has("vpnPosition")) {
            if (json.isNull("vpnPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'vpnPosition' to null.");
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$vpnPosition((int) json.getInt("vpnPosition"));
            }
        }
        if (json.has("teleConnCountPosition")) {
            if (json.isNull("teleConnCountPosition")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'teleConnCountPosition' to null.");
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$teleConnCountPosition((int) json.getInt("teleConnCountPosition"));
            }
        }
        if (json.has("selectedIptvList")) {
            if (json.isNull("selectedIptvList")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedIptvList(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmGet$selectedIptvList().clear();
                JSONArray array = json.getJSONArray("selectedIptvList");
                for (int i = 0; i < array.length(); i++) {
                    com.app.apsfl.models.IptvSIDataModel item = IptvSIDataModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((SICpeInfoModelRealmProxyInterface) obj).realmGet$selectedIptvList().add(item);
                }
            }
        }
        if (json.has("iptvPackages")) {
            if (json.isNull("iptvPackages")) {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvPackages(null);
            } else {
                ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvPackages((String) json.getString("iptvPackages"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.app.apsfl.models.SICpeInfoModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.app.apsfl.models.SICpeInfoModel obj = new com.app.apsfl.models.SICpeInfoModel();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("apsflTrackId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$apsflTrackId(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$apsflTrackId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("packageDetails")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$packageDetails(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$packageDetails((String) reader.nextString());
                }
            } else if (name.equals("popDistId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popDistId(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popDistId((String) reader.nextString());
                }
            } else if (name.equals("popMandalId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popMandalId(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popMandalId((String) reader.nextString());
                }
            } else if (name.equals("popId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popId(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$popId((String) reader.nextString());
                }
            } else if (name.equals("selectedPopDistrict")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopDistrict(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopDistrict((String) reader.nextString());
                }
            } else if (name.equals("selectedPopMandal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopMandal(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPopMandal((String) reader.nextString());
                }
            } else if (name.equals("selectedPop")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPop(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedPop((String) reader.nextString());
                }
            } else if (name.equals("oltIdPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'oltIdPosition' to null.");
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$oltIdPosition((int) reader.nextInt());
                }
            } else if (name.equals("oltPortIdPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'oltPortIdPosition' to null.");
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$oltPortIdPosition((int) reader.nextInt());
                }
            } else if (name.equals("onuModelPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'onuModelPosition' to null.");
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$onuModelPosition((int) reader.nextInt());
                }
            } else if (name.equals("onuSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$onuSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("iptvPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iptvPosition' to null.");
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvPosition((int) reader.nextInt());
                }
            } else if (name.equals("iptvSerialNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvSerialNumber(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvSerialNumber((String) reader.nextString());
                }
            } else if (name.equals("vpnPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'vpnPosition' to null.");
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$vpnPosition((int) reader.nextInt());
                }
            } else if (name.equals("teleConnCountPosition")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'teleConnCountPosition' to null.");
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$teleConnCountPosition((int) reader.nextInt());
                }
            } else if (name.equals("selectedIptvList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedIptvList(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$selectedIptvList(new RealmList<com.app.apsfl.models.IptvSIDataModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.app.apsfl.models.IptvSIDataModel item = IptvSIDataModelRealmProxy.createUsingJsonStream(realm, reader);
                        ((SICpeInfoModelRealmProxyInterface) obj).realmGet$selectedIptvList().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("iptvPackages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvPackages(null);
                } else {
                    ((SICpeInfoModelRealmProxyInterface) obj).realmSet$iptvPackages((String) reader.nextString());
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

    public static com.app.apsfl.models.SICpeInfoModel copyOrUpdate(Realm realm, com.app.apsfl.models.SICpeInfoModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SICpeInfoModel) cachedRealmObject;
        } else {
            com.app.apsfl.models.SICpeInfoModel realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.app.apsfl.models.SICpeInfoModel.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((SICpeInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.app.apsfl.models.SICpeInfoModel.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.SICpeInfoModelRealmProxy();
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

    public static com.app.apsfl.models.SICpeInfoModel copy(Realm realm, com.app.apsfl.models.SICpeInfoModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.app.apsfl.models.SICpeInfoModel) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.app.apsfl.models.SICpeInfoModel realmObject = realm.createObjectInternal(com.app.apsfl.models.SICpeInfoModel.class, ((SICpeInfoModelRealmProxyInterface) newObject).realmGet$apsflTrackId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$packageDetails(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$packageDetails());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$popDistId(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$popDistId());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$popMandalId(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$popMandalId());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$popId(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$popId());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$selectedPopDistrict(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedPopDistrict());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$selectedPopMandal(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedPopMandal());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$selectedPop(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedPop());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$oltIdPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$oltIdPosition());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$oltPortIdPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$oltPortIdPosition());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$onuModelPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$onuModelPosition());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$onuSerialNumber(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$onuSerialNumber());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$iptvPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$iptvPosition());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$iptvSerialNumber(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$iptvSerialNumber());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$vpnPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$vpnPosition());
            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$teleConnCountPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$teleConnCountPosition());

            RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListList = ((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedIptvList();
            if (selectedIptvListList != null) {
                RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListRealmList = ((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$selectedIptvList();
                for (int i = 0; i < selectedIptvListList.size(); i++) {
                    com.app.apsfl.models.IptvSIDataModel selectedIptvListItem = selectedIptvListList.get(i);
                    com.app.apsfl.models.IptvSIDataModel cacheselectedIptvList = (com.app.apsfl.models.IptvSIDataModel) cache.get(selectedIptvListItem);
                    if (cacheselectedIptvList != null) {
                        selectedIptvListRealmList.add(cacheselectedIptvList);
                    } else {
                        selectedIptvListRealmList.add(IptvSIDataModelRealmProxy.copyOrUpdate(realm, selectedIptvListList.get(i), update, cache));
                    }
                }
            }

            ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$iptvPackages(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$iptvPackages());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.app.apsfl.models.SICpeInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SICpeInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICpeInfoModelColumnInfo columnInfo = (SICpeInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICpeInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SICpeInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
        String realmGet$packageDetails = ((SICpeInfoModelRealmProxyInterface)object).realmGet$packageDetails();
        if (realmGet$packageDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.packageDetailsIndex, rowIndex, realmGet$packageDetails, false);
        }
        String realmGet$popDistId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popDistId();
        if (realmGet$popDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
        }
        String realmGet$popMandalId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popMandalId();
        if (realmGet$popMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
        }
        String realmGet$popId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popId();
        if (realmGet$popId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
        }
        String realmGet$selectedPopDistrict = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopDistrict();
        if (realmGet$selectedPopDistrict != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedPopDistrictIndex, rowIndex, realmGet$selectedPopDistrict, false);
        }
        String realmGet$selectedPopMandal = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopMandal();
        if (realmGet$selectedPopMandal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedPopMandalIndex, rowIndex, realmGet$selectedPopMandal, false);
        }
        String realmGet$selectedPop = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPop();
        if (realmGet$selectedPop != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedPopIndex, rowIndex, realmGet$selectedPop, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.oltIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltIdPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.oltPortIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltPortIdPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
        String realmGet$onuSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
        if (realmGet$onuSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPosition(), false);
        String realmGet$iptvSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvSerialNumber();
        if (realmGet$iptvSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvSerialNumberIndex, rowIndex, realmGet$iptvSerialNumber, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.vpnPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$vpnPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);

        RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListList = ((SICpeInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
        if (selectedIptvListList != null) {
            long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
            for (com.app.apsfl.models.IptvSIDataModel selectedIptvListItem : selectedIptvListList) {
                Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                if (cacheItemIndexselectedIptvList == null) {
                    cacheItemIndexselectedIptvList = IptvSIDataModelRealmProxy.insert(realm, selectedIptvListItem, cache);
                }
                LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
            }
            LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);
        }

        String realmGet$iptvPackages = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPackages();
        if (realmGet$iptvPackages != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SICpeInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICpeInfoModelColumnInfo columnInfo = (SICpeInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICpeInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SICpeInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SICpeInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SICpeInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
                String realmGet$packageDetails = ((SICpeInfoModelRealmProxyInterface)object).realmGet$packageDetails();
                if (realmGet$packageDetails != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.packageDetailsIndex, rowIndex, realmGet$packageDetails, false);
                }
                String realmGet$popDistId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popDistId();
                if (realmGet$popDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
                }
                String realmGet$popMandalId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popMandalId();
                if (realmGet$popMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
                }
                String realmGet$popId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popId();
                if (realmGet$popId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
                }
                String realmGet$selectedPopDistrict = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopDistrict();
                if (realmGet$selectedPopDistrict != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedPopDistrictIndex, rowIndex, realmGet$selectedPopDistrict, false);
                }
                String realmGet$selectedPopMandal = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopMandal();
                if (realmGet$selectedPopMandal != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedPopMandalIndex, rowIndex, realmGet$selectedPopMandal, false);
                }
                String realmGet$selectedPop = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPop();
                if (realmGet$selectedPop != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedPopIndex, rowIndex, realmGet$selectedPop, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.oltIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltIdPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.oltPortIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltPortIdPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
                String realmGet$onuSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
                if (realmGet$onuSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPosition(), false);
                String realmGet$iptvSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvSerialNumber();
                if (realmGet$iptvSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvSerialNumberIndex, rowIndex, realmGet$iptvSerialNumber, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.vpnPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$vpnPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);

                RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListList = ((SICpeInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
                if (selectedIptvListList != null) {
                    long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
                    for (com.app.apsfl.models.IptvSIDataModel selectedIptvListItem : selectedIptvListList) {
                        Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                        if (cacheItemIndexselectedIptvList == null) {
                            cacheItemIndexselectedIptvList = IptvSIDataModelRealmProxy.insert(realm, selectedIptvListItem, cache);
                        }
                        LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
                    }
                    LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);
                }

                String realmGet$iptvPackages = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPackages();
                if (realmGet$iptvPackages != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.app.apsfl.models.SICpeInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.app.apsfl.models.SICpeInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICpeInfoModelColumnInfo columnInfo = (SICpeInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICpeInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((SICpeInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
        String realmGet$packageDetails = ((SICpeInfoModelRealmProxyInterface)object).realmGet$packageDetails();
        if (realmGet$packageDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.packageDetailsIndex, rowIndex, realmGet$packageDetails, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.packageDetailsIndex, rowIndex, false);
        }
        String realmGet$popDistId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popDistId();
        if (realmGet$popDistId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, false);
        }
        String realmGet$popMandalId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popMandalId();
        if (realmGet$popMandalId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, false);
        }
        String realmGet$popId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popId();
        if (realmGet$popId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popIdIndex, rowIndex, false);
        }
        String realmGet$selectedPopDistrict = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopDistrict();
        if (realmGet$selectedPopDistrict != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedPopDistrictIndex, rowIndex, realmGet$selectedPopDistrict, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.selectedPopDistrictIndex, rowIndex, false);
        }
        String realmGet$selectedPopMandal = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopMandal();
        if (realmGet$selectedPopMandal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedPopMandalIndex, rowIndex, realmGet$selectedPopMandal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.selectedPopMandalIndex, rowIndex, false);
        }
        String realmGet$selectedPop = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPop();
        if (realmGet$selectedPop != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.selectedPopIndex, rowIndex, realmGet$selectedPop, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.selectedPopIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.oltIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltIdPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.oltPortIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltPortIdPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
        String realmGet$onuSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
        if (realmGet$onuSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iptvPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPosition(), false);
        String realmGet$iptvSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvSerialNumber();
        if (realmGet$iptvSerialNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvSerialNumberIndex, rowIndex, realmGet$iptvSerialNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvSerialNumberIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.vpnPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$vpnPosition(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);

        long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
        LinkView.nativeClear(selectedIptvListNativeLinkViewPtr);
        RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListList = ((SICpeInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
        if (selectedIptvListList != null) {
            for (com.app.apsfl.models.IptvSIDataModel selectedIptvListItem : selectedIptvListList) {
                Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                if (cacheItemIndexselectedIptvList == null) {
                    cacheItemIndexselectedIptvList = IptvSIDataModelRealmProxy.insertOrUpdate(realm, selectedIptvListItem, cache);
                }
                LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
            }
        }
        LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);

        String realmGet$iptvPackages = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPackages();
        if (realmGet$iptvPackages != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.app.apsfl.models.SICpeInfoModel.class);
        long tableNativePtr = table.getNativeTablePointer();
        SICpeInfoModelColumnInfo columnInfo = (SICpeInfoModelColumnInfo) realm.schema.getColumnInfo(com.app.apsfl.models.SICpeInfoModel.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.app.apsfl.models.SICpeInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.app.apsfl.models.SICpeInfoModel) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((SICpeInfoModelRealmProxyInterface) object).realmGet$apsflTrackId();
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
                String realmGet$packageDetails = ((SICpeInfoModelRealmProxyInterface)object).realmGet$packageDetails();
                if (realmGet$packageDetails != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.packageDetailsIndex, rowIndex, realmGet$packageDetails, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.packageDetailsIndex, rowIndex, false);
                }
                String realmGet$popDistId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popDistId();
                if (realmGet$popDistId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, realmGet$popDistId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popDistIdIndex, rowIndex, false);
                }
                String realmGet$popMandalId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popMandalId();
                if (realmGet$popMandalId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, realmGet$popMandalId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popMandalIdIndex, rowIndex, false);
                }
                String realmGet$popId = ((SICpeInfoModelRealmProxyInterface)object).realmGet$popId();
                if (realmGet$popId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.popIdIndex, rowIndex, realmGet$popId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popIdIndex, rowIndex, false);
                }
                String realmGet$selectedPopDistrict = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopDistrict();
                if (realmGet$selectedPopDistrict != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedPopDistrictIndex, rowIndex, realmGet$selectedPopDistrict, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.selectedPopDistrictIndex, rowIndex, false);
                }
                String realmGet$selectedPopMandal = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPopMandal();
                if (realmGet$selectedPopMandal != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedPopMandalIndex, rowIndex, realmGet$selectedPopMandal, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.selectedPopMandalIndex, rowIndex, false);
                }
                String realmGet$selectedPop = ((SICpeInfoModelRealmProxyInterface)object).realmGet$selectedPop();
                if (realmGet$selectedPop != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.selectedPopIndex, rowIndex, realmGet$selectedPop, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.selectedPopIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.oltIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltIdPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.oltPortIdPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$oltPortIdPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.onuModelPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuModelPosition(), false);
                String realmGet$onuSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$onuSerialNumber();
                if (realmGet$onuSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, realmGet$onuSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.onuSerialNumberIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.iptvPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPosition(), false);
                String realmGet$iptvSerialNumber = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvSerialNumber();
                if (realmGet$iptvSerialNumber != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvSerialNumberIndex, rowIndex, realmGet$iptvSerialNumber, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvSerialNumberIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.vpnPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$vpnPosition(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.teleConnCountPositionIndex, rowIndex, ((SICpeInfoModelRealmProxyInterface)object).realmGet$teleConnCountPosition(), false);

                long selectedIptvListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.selectedIptvListIndex, rowIndex);
                LinkView.nativeClear(selectedIptvListNativeLinkViewPtr);
                RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListList = ((SICpeInfoModelRealmProxyInterface) object).realmGet$selectedIptvList();
                if (selectedIptvListList != null) {
                    for (com.app.apsfl.models.IptvSIDataModel selectedIptvListItem : selectedIptvListList) {
                        Long cacheItemIndexselectedIptvList = cache.get(selectedIptvListItem);
                        if (cacheItemIndexselectedIptvList == null) {
                            cacheItemIndexselectedIptvList = IptvSIDataModelRealmProxy.insertOrUpdate(realm, selectedIptvListItem, cache);
                        }
                        LinkView.nativeAdd(selectedIptvListNativeLinkViewPtr, cacheItemIndexselectedIptvList);
                    }
                }
                LinkView.nativeClose(selectedIptvListNativeLinkViewPtr);

                String realmGet$iptvPackages = ((SICpeInfoModelRealmProxyInterface)object).realmGet$iptvPackages();
                if (realmGet$iptvPackages != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, realmGet$iptvPackages, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iptvPackagesIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.app.apsfl.models.SICpeInfoModel createDetachedCopy(com.app.apsfl.models.SICpeInfoModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.app.apsfl.models.SICpeInfoModel unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.app.apsfl.models.SICpeInfoModel)cachedObject.object;
            } else {
                unmanagedObject = (com.app.apsfl.models.SICpeInfoModel)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.app.apsfl.models.SICpeInfoModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$apsflTrackId(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$apsflTrackId());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$packageDetails(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$packageDetails());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$popDistId(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$popDistId());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$popMandalId(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$popMandalId());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$popId(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$popId());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedPopDistrict(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$selectedPopDistrict());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedPopMandal(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$selectedPopMandal());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedPop(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$selectedPop());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$oltIdPosition(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$oltIdPosition());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$oltPortIdPosition(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$oltPortIdPosition());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuModelPosition(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$onuModelPosition());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$onuSerialNumber(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$onuSerialNumber());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$iptvPosition(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$iptvPosition());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$iptvSerialNumber(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$iptvSerialNumber());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$vpnPosition(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$vpnPosition());
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$teleConnCountPosition(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$teleConnCountPosition());

        // Deep copy of selectedIptvList
        if (currentDepth == maxDepth) {
            ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedIptvList(null);
        } else {
            RealmList<com.app.apsfl.models.IptvSIDataModel> managedselectedIptvListList = ((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$selectedIptvList();
            RealmList<com.app.apsfl.models.IptvSIDataModel> unmanagedselectedIptvListList = new RealmList<com.app.apsfl.models.IptvSIDataModel>();
            ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$selectedIptvList(unmanagedselectedIptvListList);
            int nextDepth = currentDepth + 1;
            int size = managedselectedIptvListList.size();
            for (int i = 0; i < size; i++) {
                com.app.apsfl.models.IptvSIDataModel item = IptvSIDataModelRealmProxy.createDetachedCopy(managedselectedIptvListList.get(i), nextDepth, maxDepth, cache);
                unmanagedselectedIptvListList.add(item);
            }
        }
        ((SICpeInfoModelRealmProxyInterface) unmanagedObject).realmSet$iptvPackages(((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$iptvPackages());
        return unmanagedObject;
    }

    static com.app.apsfl.models.SICpeInfoModel update(Realm realm, com.app.apsfl.models.SICpeInfoModel realmObject, com.app.apsfl.models.SICpeInfoModel newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$packageDetails(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$packageDetails());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$popDistId(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$popDistId());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$popMandalId(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$popMandalId());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$popId(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$popId());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$selectedPopDistrict(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedPopDistrict());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$selectedPopMandal(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedPopMandal());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$selectedPop(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedPop());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$oltIdPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$oltIdPosition());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$oltPortIdPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$oltPortIdPosition());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$onuModelPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$onuModelPosition());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$onuSerialNumber(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$onuSerialNumber());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$iptvPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$iptvPosition());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$iptvSerialNumber(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$iptvSerialNumber());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$vpnPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$vpnPosition());
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$teleConnCountPosition(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$teleConnCountPosition());
        RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListList = ((SICpeInfoModelRealmProxyInterface) newObject).realmGet$selectedIptvList();
        RealmList<com.app.apsfl.models.IptvSIDataModel> selectedIptvListRealmList = ((SICpeInfoModelRealmProxyInterface) realmObject).realmGet$selectedIptvList();
        selectedIptvListRealmList.clear();
        if (selectedIptvListList != null) {
            for (int i = 0; i < selectedIptvListList.size(); i++) {
                com.app.apsfl.models.IptvSIDataModel selectedIptvListItem = selectedIptvListList.get(i);
                com.app.apsfl.models.IptvSIDataModel cacheselectedIptvList = (com.app.apsfl.models.IptvSIDataModel) cache.get(selectedIptvListItem);
                if (cacheselectedIptvList != null) {
                    selectedIptvListRealmList.add(cacheselectedIptvList);
                } else {
                    selectedIptvListRealmList.add(IptvSIDataModelRealmProxy.copyOrUpdate(realm, selectedIptvListList.get(i), true, cache));
                }
            }
        }
        ((SICpeInfoModelRealmProxyInterface) realmObject).realmSet$iptvPackages(((SICpeInfoModelRealmProxyInterface) newObject).realmGet$iptvPackages());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SICpeInfoModel = [");
        stringBuilder.append("{apsflTrackId:");
        stringBuilder.append(realmGet$apsflTrackId() != null ? realmGet$apsflTrackId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{packageDetails:");
        stringBuilder.append(realmGet$packageDetails() != null ? realmGet$packageDetails() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popDistId:");
        stringBuilder.append(realmGet$popDistId() != null ? realmGet$popDistId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popMandalId:");
        stringBuilder.append(realmGet$popMandalId() != null ? realmGet$popMandalId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popId:");
        stringBuilder.append(realmGet$popId() != null ? realmGet$popId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectedPopDistrict:");
        stringBuilder.append(realmGet$selectedPopDistrict() != null ? realmGet$selectedPopDistrict() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectedPopMandal:");
        stringBuilder.append(realmGet$selectedPopMandal() != null ? realmGet$selectedPopMandal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectedPop:");
        stringBuilder.append(realmGet$selectedPop() != null ? realmGet$selectedPop() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{oltIdPosition:");
        stringBuilder.append(realmGet$oltIdPosition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{oltPortIdPosition:");
        stringBuilder.append(realmGet$oltPortIdPosition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{onuModelPosition:");
        stringBuilder.append(realmGet$onuModelPosition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{onuSerialNumber:");
        stringBuilder.append(realmGet$onuSerialNumber() != null ? realmGet$onuSerialNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iptvPosition:");
        stringBuilder.append(realmGet$iptvPosition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iptvSerialNumber:");
        stringBuilder.append(realmGet$iptvSerialNumber() != null ? realmGet$iptvSerialNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vpnPosition:");
        stringBuilder.append(realmGet$vpnPosition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{teleConnCountPosition:");
        stringBuilder.append(realmGet$teleConnCountPosition());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectedIptvList:");
        stringBuilder.append("RealmList<IptvSIDataModel>[").append(realmGet$selectedIptvList().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iptvPackages:");
        stringBuilder.append(realmGet$iptvPackages() != null ? realmGet$iptvPackages() : "null");
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
        SICpeInfoModelRealmProxy aSICpeInfoModel = (SICpeInfoModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSICpeInfoModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSICpeInfoModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSICpeInfoModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
