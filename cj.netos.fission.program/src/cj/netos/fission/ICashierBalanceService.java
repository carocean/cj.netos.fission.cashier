package cj.netos.fission;

import cj.netos.fission.model.CashierBalance;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

public interface ICashierBalanceService {
    /**
     * 列出正在营业且出纳台有钱的用户标识
     * @param limit
     * @param skip
     * @return
     */
    List<String> pagePersonByCashierOpening(int limit, int skip);

    CashierBalance getAndInitBalance(String person);


    void updateBalance(String person, long balanceAmount);


}
