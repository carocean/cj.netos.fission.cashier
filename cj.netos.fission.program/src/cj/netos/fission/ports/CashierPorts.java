package cj.netos.fission.ports;

import cj.netos.fission.*;
import cj.netos.fission.model.*;
import cj.netos.fission.util.CashierUtils;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@CjService(name = "/cashier.ports")
public class CashierPorts implements ICashierPorts {
    @CjServiceRef
    ICashierService cashierService;
    @CjServiceRef
    ICashierRecordService cashierRecordService;
    @CjServiceRef
    ICashierBalanceService cashierBalanceService;
    @CjServiceRef
    ISnatchEnvelopeAlgorithm snatchEnvelopeAlgorithm;
    @CjServiceRef
    ITagService tagService;
    @CjServiceRef
    IPersonService personService;
    @CjServiceRef
    IMFSettingsService mfSettingsService;
    @CjServiceRef
    IRecommendedService recommendedService;
    @Override
    public CashierBalance getCashierBalance(ISecuritySession securitySession) throws CircuitException {
        return cashierService.getCashierBalance(securitySession.principal());
    }

    @Override
    public Cashier getCashier(ISecuritySession securitySession) throws CircuitException {
        return cashierService.getAndInitCashier(securitySession.principal());
    }

    @Override
    public MfSettings getSettings(ISecuritySession securitySession) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("800", "拒绝访问");
        }
        return mfSettingsService.getSettings();
    }

    @Override
    public BossInfo getBossInfo(ISecuritySession securitySession) throws CircuitException {
        long balance = cashierBalanceService.getAndInitBalance(securitySession.principal()).getBalance();
        long payeeCount = cashierRecordService.totalPayee(securitySession.principal());
        long payerCount = cashierRecordService.totalPayer(securitySession.principal());
        long payerAmount = cashierRecordService.totalPayerAmount(securitySession.principal());
        List<String> payeeList = cashierRecordService.pagePayeeId(securitySession.principal(), 5, 0);
        long empCount = cashierService.totalEmployeeCount(securitySession.principal());
        long commissionAmount = cashierRecordService.totalCommissionAmount(securitySession.principal());
        BossInfo info = new BossInfo();
        info.setBalance(balance);
        info.setPayeeAmount(payerAmount);
        info.setPayeeCount(payeeCount);
        info.setPayerCount(payerCount);
        info.setMembersTop5(payeeList);
        info.setEmpCount(empCount);
        info.setCommission(commissionAmount);
        return info;
    }

    @Override
    public void setSalesman(ISecuritySession securitySession, String person) throws CircuitException {
        person = CashierUtils.getAccountCode(person);
        cashierService.setSalesman(securitySession.principal(), person);
    }

    @Override
    public void setRequirement(ISecuritySession securitySession, int becomeAgent, String phone) throws CircuitException {
        cashierService.setRequirement(securitySession.principal(), becomeAgent, phone);
    }

    @Override
    public List<BusinessIncomeRatio> listBusinessIncomeRatio(ISecuritySession securitySession) throws CircuitException {
        return mfSettingsService.listBusinessIncomeRatio();
    }

    @Override
    public WithdrawShuntBO computeWithdrawShuntInfo(ISecuritySession securitySession, long amount) throws CircuitException {
        //分账
        Cashier cashier = cashierService.getAndInitCashier(securitySession.principal());
        BigDecimal amountBD = new BigDecimal(amount);
        MfSettings settings = mfSettingsService.getSettings();
        long gainAmount = new BigDecimal("1.000").subtract(settings.getWithdrawShuntRatio()).multiply(amountBD).longValue();
        long shuntAmount = amount - gainAmount;
        BigDecimal shuntAmountBD = new BigDecimal(shuntAmount).setScale(0, RoundingMode.DOWN);//可分的账金
        long absorbAmount = settings.getWithdrawAbsorbRatio().multiply(shuntAmountBD).longValue();
        long commissionAmount = 0;
        if (!StringUtil.isEmpty(cashier.getReferrer())) {
            commissionAmount = settings.getWithdrawCommRatio().multiply(shuntAmountBD).longValue();
        }
        long incomeAmount = shuntAmount - absorbAmount - commissionAmount;//只要是剩下的钱平台全收
        //分完
        WithdrawShuntBO bo = new WithdrawShuntBO();
        bo.setAbsorbAmount(absorbAmount);
        bo.setCommissionAmount(commissionAmount);
        bo.setGainAmount(gainAmount);
        bo.setShuntAmount(shuntAmount);
        bo.setIncomeAmount(incomeAmount);
        bo.setWithdrawAbsorbRatio(settings.getWithdrawAbsorbRatio());
        bo.setWithdrawCommRatio(settings.getWithdrawCommRatio());
        bo.setWithdrawIncomeRatio(settings.getWithdrawIncomeRatio());
        bo.setWithdrawShuntRatio(settings.getWithdrawShuntRatio());
        return bo;
    }

    @Override
    public long getStayBalance(ISecuritySession securitySession) throws CircuitException {
        return mfSettingsService.getStayBalanceOfPerson(securitySession.principal());
    }

    @Override
    public void setCacAverage(ISecuritySession securitySession, long cacAverage) throws CircuitException {
        cashierService.setCacAverage(securitySession.principal(), cacAverage);
    }

    @Override
    public void setAmplitudeFactor(ISecuritySession securitySession, BigDecimal amplitudeFactor) throws CircuitException {
        cashierService.setAmplitudeFactor(securitySession.principal(), amplitudeFactor);
    }

    @Override
    public long assessCacCount(ISecuritySession securitySession) throws CircuitException {
        Cashier cashier = cashierService.getAndInitCashier(securitySession.principal());
        CashierBalance balance = cashierBalanceService.getAndInitBalance(securitySession.principal());
        if (balance.getBalance() <= 0) {
            return 0;
        }
        return snatchEnvelopeAlgorithm.dynamicAssessCount(balance.getBalance(), cashier.getCacAverage(), cashier.getAmplitudeFactor().doubleValue());
    }

    @Override
    public void startCashier(ISecuritySession securitySession) throws CircuitException {
        cashierService.startCashier(securitySession.principal());
    }

    @Override
    public void stopCashier(ISecuritySession securitySession, String closedCause) throws CircuitException {
        cashierService.stopCashier(securitySession.principal(), closedCause);
    }

    @Override
    public AlgorithmInfo getAlgorithmInfo(ISecuritySession securitySession) throws CircuitException {
        Cashier cashier = cashierService.getAndInitCashier(securitySession.principal());
        long upMaxBound = this.snatchEnvelopeAlgorithm.upMaxBound(cashier.getCacAverage(), cashier.getAmplitudeFactor().doubleValue());
        long baseLine = this.snatchEnvelopeAlgorithm.baseLine(cashier.getCacAverage(), cashier.getAmplitudeFactor().doubleValue());
        long amplitude = this.snatchEnvelopeAlgorithm.amplitude(cashier.getCacAverage(), cashier.getAmplitudeFactor().doubleValue());
        AlgorithmInfo info = new AlgorithmInfo();
        info.setAmplitude(amplitude);
        info.setBaseLine(baseLine);
        info.setUpMaxBound(upMaxBound);
        return info;
    }

    @Override
    public void configTags(ISecuritySession securitySession, List<Tag> tags) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("800", "拒绝访问");
        }
        for (Tag tag : tags) {
            tagService.add(tag);
        }
    }

    @Override
    public List<Tag> listAllTag(ISecuritySession securitySession) throws CircuitException {
        return tagService.listAllTag();
    }

    @Override
    public void addPropertyTag(ISecuritySession securitySession, String tagId) throws CircuitException {
        if (!tagService.exists(tagId)) {
            throw new CircuitException("404", String.format("不存在标签:%s", tagId));
        }
        tagService.addPropertyTag(securitySession.principal(), tagId);
    }

    @Override
    public void removePropertyTag(ISecuritySession securitySession, String tagId) throws CircuitException {
        tagService.removePropertyTag(securitySession.principal(), tagId);
    }

    @Override
    public List<Tag> listMyPropertyTag(ISecuritySession securitySession) throws CircuitException {
        return tagService.listMyPropertyTag(securitySession.principal());
    }

    @Override
    public List<Tag> listPropertyTagOfPerson(ISecuritySession securitySession, String person) throws CircuitException {
        return tagService.listMyPropertyTag(person);
    }

    @Override
    public Tag getTag(ISecuritySession securitySession, String tagId) throws CircuitException {
        return tagService.getTag(tagId);
    }

    @Override
    public void addLimitTag(ISecuritySession securitySession, String direct, String tagId) throws CircuitException {
        LimitTag tag = new LimitTag();
        tag.setDirect(direct);
        tag.setPerson(securitySession.principal());
        tag.setTag(tagId);
        tagService.addLimitTag(tag);
    }

    @Override
    public void removeLimitTag(ISecuritySession securitySession, String direct, String tagId) throws CircuitException {
        tagService.removeLimitTag(securitySession.principal(), direct, tagId);
    }

    @Override
    public List<Tag> listLimitTag(ISecuritySession securitySession, String direct) throws CircuitException {
        return tagService.listLimitTag(securitySession.principal(), direct);
    }

    @Override
    public void setLimitArea(ISecuritySession securitySession, String direct, String areaType, String areaTitle, String areaCode) throws CircuitException {
        LimitArea area = new LimitArea();
        area.setAreaCode(areaCode);
        area.setAreaTitle(areaTitle);
        area.setAreaType(areaType);
        area.setDirect(direct);
        area.setPerson(securitySession.principal());
        tagService.setLimitArea(area);
    }

    @Override
    public void emptyLimitArea(ISecuritySession securitySession, String direct) throws CircuitException {
        tagService.removeLimitArea(securitySession.principal(), direct);
    }

    @Override
    public void emptyRecommendeds(ISecuritySession securitySession, String person) throws CircuitException {
        if(!securitySession.roleIn("platform:administrators")){
            throw new CircuitException("800","拒绝访问");
        }
        recommendedService.emptyRecommendedsOfPerson(person);
    }

    @Override
    public LimitArea getLimitArea(ISecuritySession securitySession, String direct) throws CircuitException {
        return tagService.getLimitArea(securitySession.principal(), direct);
    }

    @Override
    public void setAttachment(ISecuritySession securitySession, String src, String type) throws CircuitException {
        Attachment attachment = new Attachment();
        attachment.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        attachment.setPerson(securitySession.principal());
        attachment.setSrc(src);
        attachment.setType(type);
        tagService.setAttachment(attachment);
    }

    @Override
    public void emptyAttachment(ISecuritySession securitySession) throws CircuitException {
        tagService.emptyAttachment(securitySession.principal());
    }

    @Override
    public Attachment getAttachment(ISecuritySession securitySession) throws CircuitException {
        return tagService.getAttachment(securitySession.principal());
    }

    @Override
    public void setAdvert(ISecuritySession securitySession, String note) throws CircuitException {
        tagService.setAdvert(securitySession.principal(), note);
    }

    @Override
    public void updateLocation(ISecuritySession securitySession, LatLng location, String province, String city, String district, String town, String provinceCode, String cityCode, String districtCode, String townCode) throws CircuitException {
        personService.updateLocation(securitySession.principal(), location, province, city, district, town, provinceCode, cityCode, districtCode, townCode);
    }
}
