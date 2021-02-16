package cj.netos.fission.service;

import cj.netos.fission.ICashierBalanceService;
import cj.netos.fission.mapper.CashierBalanceMapper;
import cj.netos.fission.model.CashierBalance;
import cj.netos.fission.model.CashierBalanceExample;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.ArrayList;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "cashierBalanceService")
public class CashierBalanceService implements ICashierBalanceService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.CashierBalanceMapper")
    CashierBalanceMapper cashierBalanceMapper;

    @CjTransaction
    @Override
    public List<String> pagePersonByCashierOpening(int limit, int skip) {
        List<CashierBalance> balances = cashierBalanceMapper.page(0, limit, skip);
        List<String> list = new ArrayList<>();
        for (CashierBalance balance : balances) {
            list.add(balance.getPerson());
        }
        return list;
    }

    @CjTransaction
    @Override
    public CashierBalance getAndInitBalance(String person) {
        CashierBalanceExample example = new CashierBalanceExample();
        example.createCriteria().andPersonEqualTo(person);
        List<CashierBalance> balances = cashierBalanceMapper.selectByExample(example);
        if (!balances.isEmpty()) {
            return balances.get(0);
        }
        CashierBalance balance = new CashierBalance();
        balance.setBalance(0L);
        balance.setPerson(person);
        cashierBalanceMapper.insert(balance);
        return balance;
    }

    @CjTransaction
    @Override
    public void updateBalance(String person, long balanceAmount) {
        cashierBalanceMapper.updateBalance(person, balanceAmount);
    }

}