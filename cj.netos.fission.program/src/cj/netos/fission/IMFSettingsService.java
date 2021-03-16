package cj.netos.fission;

import cj.netos.fission.model.BusinessIncomeRatio;
import cj.netos.fission.model.MfSettings;

import java.math.BigDecimal;
import java.util.List;

public interface IMFSettingsService {
    MfSettings getSettings();

    long getStayBalanceOfPerson(String person);

    BigDecimal getBusinessIncomeRatio(long amount);

    List<BusinessIncomeRatio> listBusinessIncomeRatio();

}
