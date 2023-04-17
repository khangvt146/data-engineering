package org.smartfarm.application.usecase;

import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.infrastructure.model.IncomingTsEvent;

public interface StoreEventUsecase {
    void storeTemperature(TsEvent event);
    void storeHumidity(TsEvent event);
    void storeLight(TsEvent event);
    void storePh(TsEvent event);
    void storePressure(TsEvent event);
    void storeSalinity(TsEvent event);
}
