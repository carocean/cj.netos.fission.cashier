package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.IMFSettingsService;
import cj.netos.fission.mapper.MfSettingsMapper;
import cj.netos.fission.model.Cashier;
import cj.netos.fission.model.MfSettings;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "mfSettingsService")
public class MFSettingsService implements IMFSettingsService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.MfSettingsMapper")
    MfSettingsMapper mfSettingsMapper;

    @CjServiceRef
    ICashierService cashierService;

    @CjServiceSite
    IServiceSite site;

    @CjTransaction
    @Override
    public MfSettings getSettings() {
        String mfSettingsId = site.getProperty("fission.mf.settings.id");
        return mfSettingsMapper.selectByPrimaryKey(mfSettingsId);
    }

    @CjTransaction
    @Override
    public long getStayBalanceOfPerson(String person) {
        Cashier cashier = cashierService.getAndInitCashier(person);
        Long stay = cashier.getStayBalance();
        if (stay == null) {
            MfSettings mfSettings = getSettings();
            stay = mfSettings.getStayBalance();
        }
        return stay;
    }
}
