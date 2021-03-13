package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.IMFSettingsService;
import cj.netos.fission.mapper.BusinessIncomeRatioMapper;
import cj.netos.fission.mapper.MfSettingsMapper;
import cj.netos.fission.model.BusinessIncomeRatio;
import cj.netos.fission.model.BusinessIncomeRatioExample;
import cj.netos.fission.model.Cashier;
import cj.netos.fission.model.MfSettings;
import cj.studio.ecm.IServiceSetter;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.math.BigDecimal;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "mfSettingsService")
public class MFSettingsService implements IMFSettingsService, IServiceSetter {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.MfSettingsMapper")
    MfSettingsMapper mfSettingsMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.BusinessIncomeRatioMapper")
    BusinessIncomeRatioMapper businessIncomeRatioMapper;
    ICashierService cashierService;

    @CjServiceSite
    IServiceSite site;

    @CjTransaction
    @Override
    public void setService(String serviceId, Object service) {
        cashierService = (ICashierService) service;
    }

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

    @CjTransaction
    @Override
    public BigDecimal getBusinessIncomeRatio(long amount) {
        BusinessIncomeRatioExample example = new BusinessIncomeRatioExample();
        example.createCriteria().andMinAmountEdgeLessThanOrEqualTo(amount).andMaxAmountEdgeGreaterThan(amount);
        List<BusinessIncomeRatio> ratios = businessIncomeRatioMapper.selectByExample(example);
        if (ratios.isEmpty()) {
            return new BigDecimal("0.2000");//默认是20%
        }
        return ratios.get(0).getRatio();
    }
}
