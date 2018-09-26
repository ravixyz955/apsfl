package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.app.apsfl.models.IptvSIDataModel.class);
        modelClasses.add(com.app.apsfl.models.SIPOPModel.class);
        modelClasses.add(com.app.apsfl.models.VOIPFeatureModel.class);
        modelClasses.add(com.app.apsfl.models.OltPortDetails.class);
        modelClasses.add(com.app.apsfl.models.FormSpinnerModel.class);
        modelClasses.add(com.app.apsfl.models.ChargeTaxModel.class);
        modelClasses.add(com.app.apsfl.models.POPModel.class);
        modelClasses.add(com.app.apsfl.models.L3PortModel.class);
        modelClasses.add(com.app.apsfl.models.CustomerAddressModel.class);
        modelClasses.add(com.app.apsfl.models.CustomerInfoModel.class);
        modelClasses.add(com.app.apsfl.models.ServicesModel.class);
        modelClasses.add(com.app.apsfl.models.VpnServiceModel.class);
        modelClasses.add(com.app.apsfl.models.OfflineFormModel.class);
        modelClasses.add(com.app.apsfl.models.TaxModel.class);
        modelClasses.add(com.app.apsfl.models.CPEStockModel.class);
        modelClasses.add(com.app.apsfl.models.MandalModel.class);
        modelClasses.add(com.app.apsfl.models.SICustomerInfoModel.class);
        modelClasses.add(com.app.apsfl.models.CPEInfoModel.class);
        modelClasses.add(com.app.apsfl.models.L2PortModel.class);
        modelClasses.add(com.app.apsfl.models.VillageModel.class);
        modelClasses.add(com.app.apsfl.models.POPOLTModel.class);
        modelClasses.add(com.app.apsfl.models.EnterpriseCustomer.class);
        modelClasses.add(com.app.apsfl.models.ProductModel.class);
        modelClasses.add(com.app.apsfl.models.SIOfflineFormModel.class);
        modelClasses.add(com.app.apsfl.models.OfflineEditCafModel.class);
        modelClasses.add(com.app.apsfl.models.L1PortModel.class);
        modelClasses.add(com.app.apsfl.models.TaxRegionModel.class);
        modelClasses.add(com.app.apsfl.models.PopMandalModel.class);
        modelClasses.add(com.app.apsfl.models.DistrictModel.class);
        modelClasses.add(com.app.apsfl.models.CPEDataModel.class);
        modelClasses.add(com.app.apsfl.models.CustomerDocumentModel.class);
        modelClasses.add(com.app.apsfl.models.InstallationVillageModel.class);
        modelClasses.add(com.app.apsfl.models.SICpeInfoModel.class);
        modelClasses.add(com.app.apsfl.models.IptvDataModel.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return io.realm.IptvSIDataModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return io.realm.SIPOPModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return io.realm.VOIPFeatureModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return io.realm.OltPortDetailsRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return io.realm.FormSpinnerModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return io.realm.ChargeTaxModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return io.realm.POPModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return io.realm.L3PortModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return io.realm.CustomerAddressModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return io.realm.CustomerInfoModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return io.realm.ServicesModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return io.realm.VpnServiceModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return io.realm.OfflineFormModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return io.realm.TaxModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return io.realm.CPEStockModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return io.realm.MandalModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return io.realm.SICustomerInfoModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return io.realm.CPEInfoModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return io.realm.L2PortModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return io.realm.VillageModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return io.realm.POPOLTModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return io.realm.EnterpriseCustomerRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return io.realm.ProductModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return io.realm.SIOfflineFormModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return io.realm.OfflineEditCafModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return io.realm.L1PortModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return io.realm.TaxRegionModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return io.realm.PopMandalModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return io.realm.DistrictModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return io.realm.CPEDataModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return io.realm.CustomerDocumentModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return io.realm.InstallationVillageModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return io.realm.SICpeInfoModelRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return io.realm.IptvDataModelRealmProxy.initTable(sharedRealm);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return io.realm.IptvSIDataModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return io.realm.SIPOPModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return io.realm.VOIPFeatureModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return io.realm.OltPortDetailsRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return io.realm.FormSpinnerModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return io.realm.ChargeTaxModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return io.realm.POPModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return io.realm.L3PortModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return io.realm.CustomerAddressModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return io.realm.CustomerInfoModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return io.realm.ServicesModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return io.realm.VpnServiceModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return io.realm.OfflineFormModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return io.realm.TaxModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return io.realm.CPEStockModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return io.realm.MandalModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return io.realm.SICustomerInfoModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return io.realm.CPEInfoModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return io.realm.L2PortModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return io.realm.VillageModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return io.realm.POPOLTModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return io.realm.EnterpriseCustomerRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return io.realm.ProductModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return io.realm.SIOfflineFormModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return io.realm.OfflineEditCafModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return io.realm.L1PortModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return io.realm.TaxRegionModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return io.realm.PopMandalModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return io.realm.DistrictModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return io.realm.CPEDataModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return io.realm.CustomerDocumentModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return io.realm.InstallationVillageModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return io.realm.SICpeInfoModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return io.realm.IptvDataModelRealmProxy.createRealmObjectSchema(realmSchema);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return io.realm.IptvSIDataModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return io.realm.SIPOPModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return io.realm.VOIPFeatureModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return io.realm.OltPortDetailsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return io.realm.FormSpinnerModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return io.realm.ChargeTaxModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return io.realm.POPModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return io.realm.L3PortModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return io.realm.CustomerAddressModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return io.realm.CustomerInfoModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return io.realm.ServicesModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return io.realm.VpnServiceModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return io.realm.OfflineFormModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return io.realm.TaxModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return io.realm.CPEStockModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return io.realm.MandalModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return io.realm.SICustomerInfoModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return io.realm.CPEInfoModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return io.realm.L2PortModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return io.realm.VillageModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return io.realm.POPOLTModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return io.realm.EnterpriseCustomerRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return io.realm.ProductModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return io.realm.SIOfflineFormModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return io.realm.OfflineEditCafModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return io.realm.L1PortModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return io.realm.TaxRegionModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return io.realm.PopMandalModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return io.realm.DistrictModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return io.realm.CPEDataModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return io.realm.CustomerDocumentModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return io.realm.InstallationVillageModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return io.realm.SICpeInfoModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return io.realm.IptvDataModelRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return io.realm.IptvSIDataModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return io.realm.SIPOPModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return io.realm.VOIPFeatureModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return io.realm.OltPortDetailsRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return io.realm.FormSpinnerModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return io.realm.ChargeTaxModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return io.realm.POPModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return io.realm.L3PortModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return io.realm.CustomerAddressModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return io.realm.CustomerInfoModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return io.realm.ServicesModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return io.realm.VpnServiceModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return io.realm.OfflineFormModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return io.realm.TaxModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return io.realm.CPEStockModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return io.realm.MandalModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return io.realm.SICustomerInfoModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return io.realm.CPEInfoModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return io.realm.L2PortModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return io.realm.VillageModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return io.realm.POPOLTModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return io.realm.EnterpriseCustomerRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return io.realm.ProductModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return io.realm.SIOfflineFormModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return io.realm.OfflineEditCafModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return io.realm.L1PortModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return io.realm.TaxRegionModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return io.realm.PopMandalModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return io.realm.DistrictModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return io.realm.CPEDataModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return io.realm.CustomerDocumentModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return io.realm.InstallationVillageModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return io.realm.SICpeInfoModelRealmProxy.getFieldNames();
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return io.realm.IptvDataModelRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return io.realm.IptvSIDataModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return io.realm.SIPOPModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return io.realm.VOIPFeatureModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return io.realm.OltPortDetailsRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return io.realm.FormSpinnerModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return io.realm.ChargeTaxModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return io.realm.POPModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return io.realm.L3PortModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return io.realm.CustomerAddressModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return io.realm.CustomerInfoModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return io.realm.ServicesModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return io.realm.VpnServiceModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return io.realm.OfflineFormModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return io.realm.TaxModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return io.realm.CPEStockModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return io.realm.MandalModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return io.realm.SICustomerInfoModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return io.realm.CPEInfoModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return io.realm.L2PortModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return io.realm.VillageModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return io.realm.POPOLTModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return io.realm.EnterpriseCustomerRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return io.realm.ProductModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return io.realm.SIOfflineFormModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return io.realm.OfflineEditCafModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return io.realm.L1PortModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return io.realm.TaxRegionModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return io.realm.PopMandalModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return io.realm.DistrictModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return io.realm.CPEDataModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return io.realm.CustomerDocumentModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return io.realm.InstallationVillageModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return io.realm.SICpeInfoModelRealmProxy.getTableName();
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return io.realm.IptvDataModelRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
                return clazz.cast(new io.realm.IptvSIDataModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
                return clazz.cast(new io.realm.SIPOPModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
                return clazz.cast(new io.realm.VOIPFeatureModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
                return clazz.cast(new io.realm.OltPortDetailsRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
                return clazz.cast(new io.realm.FormSpinnerModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
                return clazz.cast(new io.realm.ChargeTaxModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
                return clazz.cast(new io.realm.POPModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
                return clazz.cast(new io.realm.L3PortModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
                return clazz.cast(new io.realm.CustomerAddressModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
                return clazz.cast(new io.realm.CustomerInfoModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
                return clazz.cast(new io.realm.ServicesModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
                return clazz.cast(new io.realm.VpnServiceModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
                return clazz.cast(new io.realm.OfflineFormModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
                return clazz.cast(new io.realm.TaxModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
                return clazz.cast(new io.realm.CPEStockModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
                return clazz.cast(new io.realm.MandalModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
                return clazz.cast(new io.realm.SICustomerInfoModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
                return clazz.cast(new io.realm.CPEInfoModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
                return clazz.cast(new io.realm.L2PortModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
                return clazz.cast(new io.realm.VillageModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
                return clazz.cast(new io.realm.POPOLTModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
                return clazz.cast(new io.realm.EnterpriseCustomerRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
                return clazz.cast(new io.realm.ProductModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
                return clazz.cast(new io.realm.SIOfflineFormModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
                return clazz.cast(new io.realm.OfflineEditCafModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
                return clazz.cast(new io.realm.L1PortModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
                return clazz.cast(new io.realm.TaxRegionModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
                return clazz.cast(new io.realm.PopMandalModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
                return clazz.cast(new io.realm.DistrictModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
                return clazz.cast(new io.realm.CPEDataModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
                return clazz.cast(new io.realm.CustomerDocumentModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
                return clazz.cast(new io.realm.InstallationVillageModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
                return clazz.cast(new io.realm.SICpeInfoModelRealmProxy());
            } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
                return clazz.cast(new io.realm.IptvDataModelRealmProxy());
            } else {
                throw getMissingProxyClassException(clazz);
            }
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return clazz.cast(io.realm.IptvSIDataModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.IptvSIDataModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return clazz.cast(io.realm.SIPOPModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.SIPOPModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return clazz.cast(io.realm.VOIPFeatureModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.VOIPFeatureModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return clazz.cast(io.realm.OltPortDetailsRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.OltPortDetails) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return clazz.cast(io.realm.FormSpinnerModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.FormSpinnerModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return clazz.cast(io.realm.ChargeTaxModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.ChargeTaxModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return clazz.cast(io.realm.POPModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.POPModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return clazz.cast(io.realm.L3PortModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.L3PortModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return clazz.cast(io.realm.CustomerAddressModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.CustomerAddressModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return clazz.cast(io.realm.CustomerInfoModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.CustomerInfoModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return clazz.cast(io.realm.ServicesModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.ServicesModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return clazz.cast(io.realm.VpnServiceModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.VpnServiceModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return clazz.cast(io.realm.OfflineFormModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.OfflineFormModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return clazz.cast(io.realm.TaxModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.TaxModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return clazz.cast(io.realm.CPEStockModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.CPEStockModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return clazz.cast(io.realm.MandalModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.MandalModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return clazz.cast(io.realm.SICustomerInfoModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.SICustomerInfoModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return clazz.cast(io.realm.CPEInfoModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.CPEInfoModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return clazz.cast(io.realm.L2PortModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.L2PortModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return clazz.cast(io.realm.VillageModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.VillageModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return clazz.cast(io.realm.POPOLTModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.POPOLTModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return clazz.cast(io.realm.EnterpriseCustomerRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.EnterpriseCustomer) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return clazz.cast(io.realm.ProductModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.ProductModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return clazz.cast(io.realm.SIOfflineFormModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.SIOfflineFormModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return clazz.cast(io.realm.OfflineEditCafModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.OfflineEditCafModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return clazz.cast(io.realm.L1PortModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.L1PortModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return clazz.cast(io.realm.TaxRegionModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.TaxRegionModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return clazz.cast(io.realm.PopMandalModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.PopMandalModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return clazz.cast(io.realm.DistrictModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.DistrictModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return clazz.cast(io.realm.CPEDataModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.CPEDataModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return clazz.cast(io.realm.CustomerDocumentModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.CustomerDocumentModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return clazz.cast(io.realm.InstallationVillageModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.InstallationVillageModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return clazz.cast(io.realm.SICpeInfoModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.SICpeInfoModel) obj, update, cache));
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return clazz.cast(io.realm.IptvDataModelRealmProxy.copyOrUpdate(realm, (com.app.apsfl.models.IptvDataModel) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            io.realm.IptvSIDataModelRealmProxy.insert(realm, (com.app.apsfl.models.IptvSIDataModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            io.realm.SIPOPModelRealmProxy.insert(realm, (com.app.apsfl.models.SIPOPModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            io.realm.VOIPFeatureModelRealmProxy.insert(realm, (com.app.apsfl.models.VOIPFeatureModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            io.realm.OltPortDetailsRealmProxy.insert(realm, (com.app.apsfl.models.OltPortDetails) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            io.realm.FormSpinnerModelRealmProxy.insert(realm, (com.app.apsfl.models.FormSpinnerModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            io.realm.ChargeTaxModelRealmProxy.insert(realm, (com.app.apsfl.models.ChargeTaxModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            io.realm.POPModelRealmProxy.insert(realm, (com.app.apsfl.models.POPModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            io.realm.L3PortModelRealmProxy.insert(realm, (com.app.apsfl.models.L3PortModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            io.realm.CustomerAddressModelRealmProxy.insert(realm, (com.app.apsfl.models.CustomerAddressModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            io.realm.CustomerInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.CustomerInfoModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            io.realm.ServicesModelRealmProxy.insert(realm, (com.app.apsfl.models.ServicesModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            io.realm.VpnServiceModelRealmProxy.insert(realm, (com.app.apsfl.models.VpnServiceModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            io.realm.OfflineFormModelRealmProxy.insert(realm, (com.app.apsfl.models.OfflineFormModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            io.realm.TaxModelRealmProxy.insert(realm, (com.app.apsfl.models.TaxModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            io.realm.CPEStockModelRealmProxy.insert(realm, (com.app.apsfl.models.CPEStockModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            io.realm.MandalModelRealmProxy.insert(realm, (com.app.apsfl.models.MandalModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            io.realm.SICustomerInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.SICustomerInfoModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            io.realm.CPEInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.CPEInfoModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            io.realm.L2PortModelRealmProxy.insert(realm, (com.app.apsfl.models.L2PortModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            io.realm.VillageModelRealmProxy.insert(realm, (com.app.apsfl.models.VillageModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            io.realm.POPOLTModelRealmProxy.insert(realm, (com.app.apsfl.models.POPOLTModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            io.realm.EnterpriseCustomerRealmProxy.insert(realm, (com.app.apsfl.models.EnterpriseCustomer) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            io.realm.ProductModelRealmProxy.insert(realm, (com.app.apsfl.models.ProductModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            io.realm.SIOfflineFormModelRealmProxy.insert(realm, (com.app.apsfl.models.SIOfflineFormModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            io.realm.OfflineEditCafModelRealmProxy.insert(realm, (com.app.apsfl.models.OfflineEditCafModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            io.realm.L1PortModelRealmProxy.insert(realm, (com.app.apsfl.models.L1PortModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            io.realm.TaxRegionModelRealmProxy.insert(realm, (com.app.apsfl.models.TaxRegionModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            io.realm.PopMandalModelRealmProxy.insert(realm, (com.app.apsfl.models.PopMandalModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            io.realm.DistrictModelRealmProxy.insert(realm, (com.app.apsfl.models.DistrictModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            io.realm.CPEDataModelRealmProxy.insert(realm, (com.app.apsfl.models.CPEDataModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            io.realm.CustomerDocumentModelRealmProxy.insert(realm, (com.app.apsfl.models.CustomerDocumentModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            io.realm.InstallationVillageModelRealmProxy.insert(realm, (com.app.apsfl.models.InstallationVillageModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            io.realm.SICpeInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.SICpeInfoModel) object, cache);
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            io.realm.IptvDataModelRealmProxy.insert(realm, (com.app.apsfl.models.IptvDataModel) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new IdentityHashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
                io.realm.IptvSIDataModelRealmProxy.insert(realm, (com.app.apsfl.models.IptvSIDataModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
                io.realm.SIPOPModelRealmProxy.insert(realm, (com.app.apsfl.models.SIPOPModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
                io.realm.VOIPFeatureModelRealmProxy.insert(realm, (com.app.apsfl.models.VOIPFeatureModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
                io.realm.OltPortDetailsRealmProxy.insert(realm, (com.app.apsfl.models.OltPortDetails) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
                io.realm.FormSpinnerModelRealmProxy.insert(realm, (com.app.apsfl.models.FormSpinnerModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
                io.realm.ChargeTaxModelRealmProxy.insert(realm, (com.app.apsfl.models.ChargeTaxModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
                io.realm.POPModelRealmProxy.insert(realm, (com.app.apsfl.models.POPModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
                io.realm.L3PortModelRealmProxy.insert(realm, (com.app.apsfl.models.L3PortModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
                io.realm.CustomerAddressModelRealmProxy.insert(realm, (com.app.apsfl.models.CustomerAddressModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
                io.realm.CustomerInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.CustomerInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
                io.realm.ServicesModelRealmProxy.insert(realm, (com.app.apsfl.models.ServicesModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
                io.realm.VpnServiceModelRealmProxy.insert(realm, (com.app.apsfl.models.VpnServiceModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
                io.realm.OfflineFormModelRealmProxy.insert(realm, (com.app.apsfl.models.OfflineFormModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
                io.realm.TaxModelRealmProxy.insert(realm, (com.app.apsfl.models.TaxModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
                io.realm.CPEStockModelRealmProxy.insert(realm, (com.app.apsfl.models.CPEStockModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
                io.realm.MandalModelRealmProxy.insert(realm, (com.app.apsfl.models.MandalModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
                io.realm.SICustomerInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.SICustomerInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
                io.realm.CPEInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.CPEInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
                io.realm.L2PortModelRealmProxy.insert(realm, (com.app.apsfl.models.L2PortModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
                io.realm.VillageModelRealmProxy.insert(realm, (com.app.apsfl.models.VillageModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
                io.realm.POPOLTModelRealmProxy.insert(realm, (com.app.apsfl.models.POPOLTModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
                io.realm.EnterpriseCustomerRealmProxy.insert(realm, (com.app.apsfl.models.EnterpriseCustomer) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
                io.realm.ProductModelRealmProxy.insert(realm, (com.app.apsfl.models.ProductModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
                io.realm.SIOfflineFormModelRealmProxy.insert(realm, (com.app.apsfl.models.SIOfflineFormModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
                io.realm.OfflineEditCafModelRealmProxy.insert(realm, (com.app.apsfl.models.OfflineEditCafModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
                io.realm.L1PortModelRealmProxy.insert(realm, (com.app.apsfl.models.L1PortModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
                io.realm.TaxRegionModelRealmProxy.insert(realm, (com.app.apsfl.models.TaxRegionModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
                io.realm.PopMandalModelRealmProxy.insert(realm, (com.app.apsfl.models.PopMandalModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
                io.realm.DistrictModelRealmProxy.insert(realm, (com.app.apsfl.models.DistrictModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
                io.realm.CPEDataModelRealmProxy.insert(realm, (com.app.apsfl.models.CPEDataModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
                io.realm.CustomerDocumentModelRealmProxy.insert(realm, (com.app.apsfl.models.CustomerDocumentModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
                io.realm.InstallationVillageModelRealmProxy.insert(realm, (com.app.apsfl.models.InstallationVillageModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
                io.realm.SICpeInfoModelRealmProxy.insert(realm, (com.app.apsfl.models.SICpeInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
                io.realm.IptvDataModelRealmProxy.insert(realm, (com.app.apsfl.models.IptvDataModel) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
                    io.realm.IptvSIDataModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
                    io.realm.SIPOPModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
                    io.realm.VOIPFeatureModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
                    io.realm.OltPortDetailsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
                    io.realm.FormSpinnerModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
                    io.realm.ChargeTaxModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
                    io.realm.POPModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
                    io.realm.L3PortModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
                    io.realm.CustomerAddressModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
                    io.realm.CustomerInfoModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
                    io.realm.ServicesModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
                    io.realm.VpnServiceModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
                    io.realm.OfflineFormModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
                    io.realm.TaxModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
                    io.realm.CPEStockModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
                    io.realm.MandalModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
                    io.realm.SICustomerInfoModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
                    io.realm.CPEInfoModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
                    io.realm.L2PortModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
                    io.realm.VillageModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
                    io.realm.POPOLTModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
                    io.realm.EnterpriseCustomerRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
                    io.realm.ProductModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
                    io.realm.SIOfflineFormModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
                    io.realm.OfflineEditCafModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
                    io.realm.L1PortModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
                    io.realm.TaxRegionModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
                    io.realm.PopMandalModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
                    io.realm.DistrictModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
                    io.realm.CPEDataModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
                    io.realm.CustomerDocumentModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
                    io.realm.InstallationVillageModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
                    io.realm.SICpeInfoModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
                    io.realm.IptvDataModelRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            io.realm.IptvSIDataModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.IptvSIDataModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            io.realm.SIPOPModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SIPOPModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            io.realm.VOIPFeatureModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.VOIPFeatureModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            io.realm.OltPortDetailsRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.OltPortDetails) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            io.realm.FormSpinnerModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.FormSpinnerModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            io.realm.ChargeTaxModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.ChargeTaxModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            io.realm.POPModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.POPModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            io.realm.L3PortModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.L3PortModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            io.realm.CustomerAddressModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CustomerAddressModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            io.realm.CustomerInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CustomerInfoModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            io.realm.ServicesModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.ServicesModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            io.realm.VpnServiceModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.VpnServiceModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            io.realm.OfflineFormModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.OfflineFormModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            io.realm.TaxModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.TaxModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            io.realm.CPEStockModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CPEStockModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            io.realm.MandalModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.MandalModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            io.realm.SICustomerInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SICustomerInfoModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            io.realm.CPEInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CPEInfoModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            io.realm.L2PortModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.L2PortModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            io.realm.VillageModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.VillageModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            io.realm.POPOLTModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.POPOLTModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            io.realm.EnterpriseCustomerRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.EnterpriseCustomer) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            io.realm.ProductModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.ProductModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            io.realm.SIOfflineFormModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SIOfflineFormModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            io.realm.OfflineEditCafModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.OfflineEditCafModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            io.realm.L1PortModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.L1PortModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            io.realm.TaxRegionModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.TaxRegionModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            io.realm.PopMandalModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.PopMandalModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            io.realm.DistrictModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.DistrictModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            io.realm.CPEDataModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CPEDataModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            io.realm.CustomerDocumentModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CustomerDocumentModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            io.realm.InstallationVillageModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.InstallationVillageModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            io.realm.SICpeInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SICpeInfoModel) obj, cache);
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            io.realm.IptvDataModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.IptvDataModel) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new IdentityHashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
                io.realm.IptvSIDataModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.IptvSIDataModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
                io.realm.SIPOPModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SIPOPModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
                io.realm.VOIPFeatureModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.VOIPFeatureModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
                io.realm.OltPortDetailsRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.OltPortDetails) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
                io.realm.FormSpinnerModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.FormSpinnerModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
                io.realm.ChargeTaxModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.ChargeTaxModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
                io.realm.POPModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.POPModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
                io.realm.L3PortModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.L3PortModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
                io.realm.CustomerAddressModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CustomerAddressModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
                io.realm.CustomerInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CustomerInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
                io.realm.ServicesModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.ServicesModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
                io.realm.VpnServiceModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.VpnServiceModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
                io.realm.OfflineFormModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.OfflineFormModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
                io.realm.TaxModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.TaxModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
                io.realm.CPEStockModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CPEStockModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
                io.realm.MandalModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.MandalModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
                io.realm.SICustomerInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SICustomerInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
                io.realm.CPEInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CPEInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
                io.realm.L2PortModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.L2PortModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
                io.realm.VillageModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.VillageModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
                io.realm.POPOLTModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.POPOLTModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
                io.realm.EnterpriseCustomerRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.EnterpriseCustomer) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
                io.realm.ProductModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.ProductModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
                io.realm.SIOfflineFormModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SIOfflineFormModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
                io.realm.OfflineEditCafModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.OfflineEditCafModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
                io.realm.L1PortModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.L1PortModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
                io.realm.TaxRegionModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.TaxRegionModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
                io.realm.PopMandalModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.PopMandalModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
                io.realm.DistrictModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.DistrictModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
                io.realm.CPEDataModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CPEDataModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
                io.realm.CustomerDocumentModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.CustomerDocumentModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
                io.realm.InstallationVillageModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.InstallationVillageModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
                io.realm.SICpeInfoModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.SICpeInfoModel) object, cache);
            } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
                io.realm.IptvDataModelRealmProxy.insertOrUpdate(realm, (com.app.apsfl.models.IptvDataModel) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
                    io.realm.IptvSIDataModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
                    io.realm.SIPOPModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
                    io.realm.VOIPFeatureModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
                    io.realm.OltPortDetailsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
                    io.realm.FormSpinnerModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
                    io.realm.ChargeTaxModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
                    io.realm.POPModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
                    io.realm.L3PortModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
                    io.realm.CustomerAddressModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
                    io.realm.CustomerInfoModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
                    io.realm.ServicesModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
                    io.realm.VpnServiceModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
                    io.realm.OfflineFormModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
                    io.realm.TaxModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
                    io.realm.CPEStockModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
                    io.realm.MandalModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
                    io.realm.SICustomerInfoModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
                    io.realm.CPEInfoModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
                    io.realm.L2PortModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
                    io.realm.VillageModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
                    io.realm.POPOLTModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
                    io.realm.EnterpriseCustomerRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
                    io.realm.ProductModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
                    io.realm.SIOfflineFormModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
                    io.realm.OfflineEditCafModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
                    io.realm.L1PortModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
                    io.realm.TaxRegionModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
                    io.realm.PopMandalModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
                    io.realm.DistrictModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
                    io.realm.CPEDataModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
                    io.realm.CustomerDocumentModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
                    io.realm.InstallationVillageModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
                    io.realm.SICpeInfoModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
                    io.realm.IptvDataModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return clazz.cast(io.realm.IptvSIDataModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return clazz.cast(io.realm.SIPOPModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return clazz.cast(io.realm.VOIPFeatureModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return clazz.cast(io.realm.OltPortDetailsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return clazz.cast(io.realm.FormSpinnerModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return clazz.cast(io.realm.ChargeTaxModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return clazz.cast(io.realm.POPModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return clazz.cast(io.realm.L3PortModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return clazz.cast(io.realm.CustomerAddressModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return clazz.cast(io.realm.CustomerInfoModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return clazz.cast(io.realm.ServicesModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return clazz.cast(io.realm.VpnServiceModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return clazz.cast(io.realm.OfflineFormModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return clazz.cast(io.realm.TaxModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return clazz.cast(io.realm.CPEStockModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return clazz.cast(io.realm.MandalModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return clazz.cast(io.realm.SICustomerInfoModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return clazz.cast(io.realm.CPEInfoModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return clazz.cast(io.realm.L2PortModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return clazz.cast(io.realm.VillageModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return clazz.cast(io.realm.POPOLTModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return clazz.cast(io.realm.EnterpriseCustomerRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return clazz.cast(io.realm.ProductModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return clazz.cast(io.realm.SIOfflineFormModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return clazz.cast(io.realm.OfflineEditCafModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return clazz.cast(io.realm.L1PortModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return clazz.cast(io.realm.TaxRegionModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return clazz.cast(io.realm.PopMandalModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return clazz.cast(io.realm.DistrictModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return clazz.cast(io.realm.CPEDataModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return clazz.cast(io.realm.CustomerDocumentModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return clazz.cast(io.realm.InstallationVillageModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return clazz.cast(io.realm.SICpeInfoModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return clazz.cast(io.realm.IptvDataModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return clazz.cast(io.realm.IptvSIDataModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return clazz.cast(io.realm.SIPOPModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return clazz.cast(io.realm.VOIPFeatureModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return clazz.cast(io.realm.OltPortDetailsRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return clazz.cast(io.realm.FormSpinnerModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return clazz.cast(io.realm.ChargeTaxModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return clazz.cast(io.realm.POPModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return clazz.cast(io.realm.L3PortModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return clazz.cast(io.realm.CustomerAddressModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return clazz.cast(io.realm.CustomerInfoModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return clazz.cast(io.realm.ServicesModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return clazz.cast(io.realm.VpnServiceModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return clazz.cast(io.realm.OfflineFormModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return clazz.cast(io.realm.TaxModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return clazz.cast(io.realm.CPEStockModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return clazz.cast(io.realm.MandalModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return clazz.cast(io.realm.SICustomerInfoModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return clazz.cast(io.realm.CPEInfoModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return clazz.cast(io.realm.L2PortModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return clazz.cast(io.realm.VillageModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return clazz.cast(io.realm.POPOLTModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return clazz.cast(io.realm.EnterpriseCustomerRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return clazz.cast(io.realm.ProductModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return clazz.cast(io.realm.SIOfflineFormModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return clazz.cast(io.realm.OfflineEditCafModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return clazz.cast(io.realm.L1PortModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return clazz.cast(io.realm.TaxRegionModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return clazz.cast(io.realm.PopMandalModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return clazz.cast(io.realm.DistrictModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return clazz.cast(io.realm.CPEDataModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return clazz.cast(io.realm.CustomerDocumentModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return clazz.cast(io.realm.InstallationVillageModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return clazz.cast(io.realm.SICpeInfoModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return clazz.cast(io.realm.IptvDataModelRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.app.apsfl.models.IptvSIDataModel.class)) {
            return clazz.cast(io.realm.IptvSIDataModelRealmProxy.createDetachedCopy((com.app.apsfl.models.IptvSIDataModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.SIPOPModel.class)) {
            return clazz.cast(io.realm.SIPOPModelRealmProxy.createDetachedCopy((com.app.apsfl.models.SIPOPModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.VOIPFeatureModel.class)) {
            return clazz.cast(io.realm.VOIPFeatureModelRealmProxy.createDetachedCopy((com.app.apsfl.models.VOIPFeatureModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.OltPortDetails.class)) {
            return clazz.cast(io.realm.OltPortDetailsRealmProxy.createDetachedCopy((com.app.apsfl.models.OltPortDetails) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.FormSpinnerModel.class)) {
            return clazz.cast(io.realm.FormSpinnerModelRealmProxy.createDetachedCopy((com.app.apsfl.models.FormSpinnerModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.ChargeTaxModel.class)) {
            return clazz.cast(io.realm.ChargeTaxModelRealmProxy.createDetachedCopy((com.app.apsfl.models.ChargeTaxModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.POPModel.class)) {
            return clazz.cast(io.realm.POPModelRealmProxy.createDetachedCopy((com.app.apsfl.models.POPModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.L3PortModel.class)) {
            return clazz.cast(io.realm.L3PortModelRealmProxy.createDetachedCopy((com.app.apsfl.models.L3PortModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.CustomerAddressModel.class)) {
            return clazz.cast(io.realm.CustomerAddressModelRealmProxy.createDetachedCopy((com.app.apsfl.models.CustomerAddressModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.CustomerInfoModel.class)) {
            return clazz.cast(io.realm.CustomerInfoModelRealmProxy.createDetachedCopy((com.app.apsfl.models.CustomerInfoModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.ServicesModel.class)) {
            return clazz.cast(io.realm.ServicesModelRealmProxy.createDetachedCopy((com.app.apsfl.models.ServicesModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.VpnServiceModel.class)) {
            return clazz.cast(io.realm.VpnServiceModelRealmProxy.createDetachedCopy((com.app.apsfl.models.VpnServiceModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.OfflineFormModel.class)) {
            return clazz.cast(io.realm.OfflineFormModelRealmProxy.createDetachedCopy((com.app.apsfl.models.OfflineFormModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.TaxModel.class)) {
            return clazz.cast(io.realm.TaxModelRealmProxy.createDetachedCopy((com.app.apsfl.models.TaxModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.CPEStockModel.class)) {
            return clazz.cast(io.realm.CPEStockModelRealmProxy.createDetachedCopy((com.app.apsfl.models.CPEStockModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.MandalModel.class)) {
            return clazz.cast(io.realm.MandalModelRealmProxy.createDetachedCopy((com.app.apsfl.models.MandalModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.SICustomerInfoModel.class)) {
            return clazz.cast(io.realm.SICustomerInfoModelRealmProxy.createDetachedCopy((com.app.apsfl.models.SICustomerInfoModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.CPEInfoModel.class)) {
            return clazz.cast(io.realm.CPEInfoModelRealmProxy.createDetachedCopy((com.app.apsfl.models.CPEInfoModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.L2PortModel.class)) {
            return clazz.cast(io.realm.L2PortModelRealmProxy.createDetachedCopy((com.app.apsfl.models.L2PortModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.VillageModel.class)) {
            return clazz.cast(io.realm.VillageModelRealmProxy.createDetachedCopy((com.app.apsfl.models.VillageModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.POPOLTModel.class)) {
            return clazz.cast(io.realm.POPOLTModelRealmProxy.createDetachedCopy((com.app.apsfl.models.POPOLTModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.EnterpriseCustomer.class)) {
            return clazz.cast(io.realm.EnterpriseCustomerRealmProxy.createDetachedCopy((com.app.apsfl.models.EnterpriseCustomer) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.ProductModel.class)) {
            return clazz.cast(io.realm.ProductModelRealmProxy.createDetachedCopy((com.app.apsfl.models.ProductModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.SIOfflineFormModel.class)) {
            return clazz.cast(io.realm.SIOfflineFormModelRealmProxy.createDetachedCopy((com.app.apsfl.models.SIOfflineFormModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.OfflineEditCafModel.class)) {
            return clazz.cast(io.realm.OfflineEditCafModelRealmProxy.createDetachedCopy((com.app.apsfl.models.OfflineEditCafModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.L1PortModel.class)) {
            return clazz.cast(io.realm.L1PortModelRealmProxy.createDetachedCopy((com.app.apsfl.models.L1PortModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.TaxRegionModel.class)) {
            return clazz.cast(io.realm.TaxRegionModelRealmProxy.createDetachedCopy((com.app.apsfl.models.TaxRegionModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.PopMandalModel.class)) {
            return clazz.cast(io.realm.PopMandalModelRealmProxy.createDetachedCopy((com.app.apsfl.models.PopMandalModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.DistrictModel.class)) {
            return clazz.cast(io.realm.DistrictModelRealmProxy.createDetachedCopy((com.app.apsfl.models.DistrictModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.CPEDataModel.class)) {
            return clazz.cast(io.realm.CPEDataModelRealmProxy.createDetachedCopy((com.app.apsfl.models.CPEDataModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.CustomerDocumentModel.class)) {
            return clazz.cast(io.realm.CustomerDocumentModelRealmProxy.createDetachedCopy((com.app.apsfl.models.CustomerDocumentModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.InstallationVillageModel.class)) {
            return clazz.cast(io.realm.InstallationVillageModelRealmProxy.createDetachedCopy((com.app.apsfl.models.InstallationVillageModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.SICpeInfoModel.class)) {
            return clazz.cast(io.realm.SICpeInfoModelRealmProxy.createDetachedCopy((com.app.apsfl.models.SICpeInfoModel) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.app.apsfl.models.IptvDataModel.class)) {
            return clazz.cast(io.realm.IptvDataModelRealmProxy.createDetachedCopy((com.app.apsfl.models.IptvDataModel) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
