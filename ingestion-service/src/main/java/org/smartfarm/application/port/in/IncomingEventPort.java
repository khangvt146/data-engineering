package org.smartfarm.application.port.in;

import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.infrastructure.model.IncomingTsEvent;
import org.springframework.messaging.handler.annotation.Payload;

public interface IncomingEventPort {
    void listenTempEvent(@Payload String event);
    void listenHumidityEvent(@Payload String event);
    void listenLightEvent(@Payload String event);
    void listenPhEvent(@Payload String event);
    void listenPressureEvent(@Payload String event);
    void listenSalinityEvent(@Payload String event);
}
