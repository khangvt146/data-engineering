package org.smartfarm.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.infrastructure.database.entity.*;
import org.smartfarm.infrastructure.model.IncomingTsEvent;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TsEventMapper{
    @Mappings({
            @Mapping(source = "deviceId", target = "deviceId"),
            @Mapping(source = "timestamps", target = "timestamps"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "unit", target = "unit")
    })
    TsEvent toDomain(IncomingTsEvent event);
    TempRecord toTempPersistence(TsEvent event);
    HumidityRecord toHumidityPersistence(TsEvent event);
    LightRecord toLightPersistence(TsEvent event);
    PhRecord toPhPersistence(TsEvent event);
    PressureRecord toPressurePersistence(TsEvent event);
    SalinityRecord toSalinityPersistence(TsEvent event);
}
