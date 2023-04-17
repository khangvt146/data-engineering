package org.smartfarm.application.mapper;

import javax.annotation.processing.Generated;
import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.infrastructure.database.entity.HumidityRecord;
import org.smartfarm.infrastructure.database.entity.LightRecord;
import org.smartfarm.infrastructure.database.entity.PhRecord;
import org.smartfarm.infrastructure.database.entity.PressureRecord;
import org.smartfarm.infrastructure.database.entity.SalinityRecord;
import org.smartfarm.infrastructure.database.entity.TempRecord;
import org.smartfarm.infrastructure.model.IncomingTsEvent;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T09:59:28+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class TsEventMapperImpl implements TsEventMapper {

    @Override
    public TsEvent toDomain(IncomingTsEvent event) {
        if ( event == null ) {
            return null;
        }

        TsEvent tsEvent = new TsEvent();

        tsEvent.setDeviceId( event.getDeviceId() );
        tsEvent.setTimestamps( event.getTimestamps() );
        tsEvent.setValue( event.getValue() );
        tsEvent.setUnit( event.getUnit() );

        return tsEvent;
    }

    @Override
    public TempRecord toTempPersistence(TsEvent event) {
        if ( event == null ) {
            return null;
        }

        TempRecord tempRecord = new TempRecord();

        tempRecord.setDeviceId( event.getDeviceId() );
        tempRecord.setTimestamps( event.getTimestamps() );
        tempRecord.setUnit( event.getUnit() );
        tempRecord.setValue( event.getValue() );

        return tempRecord;
    }

    @Override
    public HumidityRecord toHumidityPersistence(TsEvent event) {
        if ( event == null ) {
            return null;
        }

        HumidityRecord humidityRecord = new HumidityRecord();

        humidityRecord.setDeviceId( event.getDeviceId() );
        humidityRecord.setTimestamps( event.getTimestamps() );
        humidityRecord.setUnit( event.getUnit() );
        humidityRecord.setValue( event.getValue() );

        return humidityRecord;
    }

    @Override
    public LightRecord toLightPersistence(TsEvent event) {
        if ( event == null ) {
            return null;
        }

        LightRecord lightRecord = new LightRecord();

        lightRecord.setDeviceId( event.getDeviceId() );
        lightRecord.setTimestamps( event.getTimestamps() );
        lightRecord.setUnit( event.getUnit() );
        lightRecord.setValue( event.getValue() );

        return lightRecord;
    }

    @Override
    public PhRecord toPhPersistence(TsEvent event) {
        if ( event == null ) {
            return null;
        }

        PhRecord phRecord = new PhRecord();

        phRecord.setDeviceId( event.getDeviceId() );
        phRecord.setTimestamps( event.getTimestamps() );
        phRecord.setUnit( event.getUnit() );
        phRecord.setValue( event.getValue() );

        return phRecord;
    }

    @Override
    public PressureRecord toPressurePersistence(TsEvent event) {
        if ( event == null ) {
            return null;
        }

        PressureRecord pressureRecord = new PressureRecord();

        pressureRecord.setDeviceId( event.getDeviceId() );
        pressureRecord.setTimestamps( event.getTimestamps() );
        pressureRecord.setUnit( event.getUnit() );
        pressureRecord.setValue( event.getValue() );

        return pressureRecord;
    }

    @Override
    public SalinityRecord toSalinityPersistence(TsEvent event) {
        if ( event == null ) {
            return null;
        }

        SalinityRecord salinityRecord = new SalinityRecord();

        salinityRecord.setDeviceId( event.getDeviceId() );
        salinityRecord.setTimestamps( event.getTimestamps() );
        salinityRecord.setUnit( event.getUnit() );
        salinityRecord.setValue( event.getValue() );

        return salinityRecord;
    }
}
