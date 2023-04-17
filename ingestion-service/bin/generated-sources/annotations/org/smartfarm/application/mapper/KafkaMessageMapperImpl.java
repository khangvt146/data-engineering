package org.smartfarm.application.mapper;

import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.infrastructure.model.PushKafkaMessage;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T09:59:28+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class KafkaMessageMapperImpl implements KafkaMessageMapper {

    @Override
    public PushKafkaMessage toEntityMessage(TsEvent event) {
        if ( event == null ) {
            return null;
        }

        PushKafkaMessage pushKafkaMessage = new PushKafkaMessage();

        pushKafkaMessage.setDeviceId( event.getDeviceId() );
        if ( event.getTimestamps() != null ) {
            pushKafkaMessage.setTimestamps( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( event.getTimestamps() ) );
        }
        pushKafkaMessage.setValue( event.getValue() );
        pushKafkaMessage.setUnit( event.getUnit() );

        return pushKafkaMessage;
    }
}
