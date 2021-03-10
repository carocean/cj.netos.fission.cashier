package cj.netos.fission;

import cj.netos.fission.model.MfSettings;

public interface IMFSettingsService {
    MfSettings getSettings();

    long getStayBalanceOfPerson(String person);
}
