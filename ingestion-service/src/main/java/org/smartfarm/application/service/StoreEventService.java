package org.smartfarm.application.service;

import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.application.mapper.TsEventMapper;
import org.smartfarm.application.port.out.SaveEventPort;
import org.smartfarm.application.usecase.StoreEventUsecase;
import org.smartfarm.infrastructure.database.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

public class StoreEventService implements StoreEventUsecase {

    @Autowired
    private SaveEventPort saveEventPort;

    @Autowired
    private TsEventMapper tsEventMapper;

    @Override
    public void storeTemperature(TsEvent event){
        TempRecord tempRecord = tsEventMapper.toTempPersistence(event);
        saveEventPort.saveTempEvent(tempRecord);
    }

    @Override
    public void storeHumidity(TsEvent event){
        HumidityRecord humidityRecord = tsEventMapper.toHumidityPersistence(event);
        saveEventPort.saveHumidityEvent(humidityRecord);
    }

    @Override
    public void storeLight(TsEvent event){
        LightRecord lightRecord = tsEventMapper.toLightPersistence(event);
        saveEventPort.saveLightEvent(lightRecord);
    }
    @Override
    public void storePressure(TsEvent event){
        PressureRecord pressureRecord = tsEventMapper.toPressurePersistence(event);
        saveEventPort.savePressureEvent(pressureRecord);
    }

    @Override
    public void storePh(TsEvent event){
        PhRecord phRecord = tsEventMapper.toPhPersistence(event);
        saveEventPort.savePhEvent(phRecord);
    }
    @Override
    public void storeSalinity(TsEvent event){
        SalinityRecord salinityRecord = tsEventMapper.toSalinityPersistence(event);
        saveEventPort.saveSalinityEvent(salinityRecord);
    }
}
