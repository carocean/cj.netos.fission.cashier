package cj.netos.fission.service;

import cj.netos.fission.IServicePriceService;
import cj.netos.fission.mapper.ServicePriceMapper;
import cj.netos.fission.model.ServicePrice;
import cj.netos.fission.model.ServicePriceExample;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;

import java.util.List;

@CjService(name = "servicePriceService")
public class ServicePriceService implements IServicePriceService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.ServicePriceMapper")
    ServicePriceMapper servicePriceMapper;

    @Override
    public List<ServicePrice> getAll() {
        ServicePriceExample example = new ServicePriceExample();
        example.createCriteria();
        return servicePriceMapper.selectByExample(example);
    }
}
