package cj.netos.fission.ports;

import cj.netos.fission.*;
import cj.netos.fission.model.*;
import cj.netos.fission.util.CashierUtils;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.math.BigDecimal;
import java.util.List;

@CjService(name = "/cashier.ports")
public class CashierPorts implements ICashierPorts {
    @CjServiceRef
    ICashierService cashierService;
    @CjServiceRef
    ICashierBalanceService cashierBalanceService;
    @CjServiceRef
    ISnatchEnvelopeAlgorithm snatchEnvelopeAlgorithm;
    @CjServiceRef
    ITagService tagService;
    @CjServiceRef
    IPersonService personService;

    @Override
    public CashierBalance getCashierBalance(ISecuritySession securitySession) throws CircuitException {
        return cashierService.getCashierBalance(securitySession.principal());
    }

    @Override
    public Cashier getCashier(ISecuritySession securitySession) throws CircuitException {
        return cashierService.getAndInitCashier(securitySession.principal());
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
    public void updateLocation(ISecuritySession securitySession,LatLng location, String province, String city, String district, String town, String provinceCode, String cityCode, String districtCode, String townCode) throws CircuitException {
        personService.updateLocation(securitySession.principal(), location,province, city, district, town,provinceCode, cityCode, districtCode, townCode );
    }
}
