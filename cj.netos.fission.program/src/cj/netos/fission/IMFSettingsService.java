package cj.netos.fission;

import cj.netos.fission.model.MfSettings;

import java.math.BigDecimal;

public interface IMFSettingsService {
    MfSettings getSettings();

    long getStayBalanceOfPerson(String person);

    BigDecimal getBusinessIncomeRatio(long amount);

}
