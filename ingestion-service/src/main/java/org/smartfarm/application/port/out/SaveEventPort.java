package org.smartfarm.application.port.out;

import org.smartfarm.infrastructure.database.entity.*;

public interface SaveEventPort {
    void saveTempEvent(TempRecord tempInfo);
    void saveHumidityEvent(HumidityRecord humidityInfo);
    void saveLightEvent(LightRecord lightInfo);
    void savePhEvent(PhRecord phInfo);
    void savePressureEvent(PressureRecord pressureInfo);
    void saveSalinityEvent(SalinityRecord salinityInfo);
}
