package org.smartfarm.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.infrastructure.model.PushKafkaMessage;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface KafkaMessageMapper {
    @Mappings({
            @Mapping(source = "deviceId", target = "deviceId"),
            @Mapping(source = "timestamps", target = "timestamps"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "unit", target = "unit")
    })
    PushKafkaMessage toEntityMessage(TsEvent event);
}
