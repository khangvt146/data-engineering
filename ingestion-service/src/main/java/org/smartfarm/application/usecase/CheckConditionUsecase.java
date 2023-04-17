package org.smartfarm.application.usecase;

import org.smartfarm.application.domain.TsEvent;

public interface CheckConditionUsecase {
    void checkTemperature(TsEvent event);
    void checkLight(TsEvent event);
}
