package org.smartfarm.application.service;

import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.application.port.out.SendAlarmPort;
import org.smartfarm.application.usecase.CheckConditionUsecase;
import org.smartfarm.infrastructure.database.entity.HumidityRecord;
import org.smartfarm.infrastructure.database.entity.TempRecord;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckConditionService implements CheckConditionUsecase {
    @Autowired
    private SendAlarmPort sendAlarmPort;


    @Override
    public void checkTemperature(TsEvent event){
        Double value = event.getValue();
        if (value > 35) {
            sendAlarmPort.sendAlarm(event);
        }
    }

    @Override
    public void checkLight(TsEvent event){
        Double value = event.getValue();
        if (value < 30) {
            sendAlarmPort.sendAlarm(event);
        }
    }
}
