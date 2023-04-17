package org.smartfarm.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.application.mapper.TsEventMapper;
import org.smartfarm.application.port.in.IncomingEventPort;
import org.smartfarm.application.usecase.CheckConditionUsecase;
import org.smartfarm.application.usecase.StoreEventUsecase;
import org.smartfarm.infrastructure.model.IncomingTsEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Slf4j
@RequiredArgsConstructor
public class IncomingEventAdapter implements IncomingEventPort {
    @Autowired
    private StoreEventUsecase storeEventUsecase;

    @Autowired
    private CheckConditionUsecase checkConditionUsecase;

    @Autowired
    private TsEventMapper tsEventMapper;

    private static ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = "smart_farm_temperature", containerFactory = "tsEventListener")
    public void listenTempEvent(@Payload String event) {
        try {
            IncomingTsEvent incomingTsEvent = objectMapper.readValue(event, IncomingTsEvent.class);
            log.info("Received Time Series event: {}", incomingTsEvent);
            TsEvent tsEvent = tsEventMapper.toDomain(incomingTsEvent);
            checkConditionUsecase.checkTemperature(tsEvent);
            storeEventUsecase.storeTemperature(tsEvent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "smart_farm_humidity", containerFactory = "tsEventListener")
    public void listenHumidityEvent(@Payload String event) {
        try {
            IncomingTsEvent incomingTsEvent = objectMapper.readValue(event, IncomingTsEvent.class);
            log.info("Received Time Series event: {}", incomingTsEvent);
            TsEvent tsEvent = tsEventMapper.toDomain(incomingTsEvent);
            storeEventUsecase.storeHumidity(tsEvent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "smart_farm_light", containerFactory = "tsEventListener")
    public void listenLightEvent(@Payload String event) {
        try {
            IncomingTsEvent incomingTsEvent = objectMapper.readValue(event, IncomingTsEvent.class);
            log.info("Received Time Series event: {}", incomingTsEvent);
            TsEvent tsEvent = tsEventMapper.toDomain(incomingTsEvent);
            storeEventUsecase.storeLight(tsEvent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "smart_farm_ph", containerFactory = "tsEventListener")
    public void listenPhEvent(@Payload String event) {
        try {
            IncomingTsEvent incomingTsEvent = objectMapper.readValue(event, IncomingTsEvent.class);
            log.info("Received Time Series event: {}", incomingTsEvent);
            TsEvent tsEvent = tsEventMapper.toDomain(incomingTsEvent);
            storeEventUsecase.storePh(tsEvent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "smart_farm_pressure", containerFactory = "tsEventListener")
    public void listenPressureEvent(@Payload String event) {
        try {
            IncomingTsEvent incomingTsEvent = objectMapper.readValue(event, IncomingTsEvent.class);
            log.info("Received Time Series event: {}", incomingTsEvent);
            TsEvent tsEvent = tsEventMapper.toDomain(incomingTsEvent);
            storeEventUsecase.storePressure(tsEvent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "smart_farm_salinity", containerFactory = "tsEventListener")
    public void listenSalinityEvent(@Payload String event) {
        try {
            IncomingTsEvent incomingTsEvent = objectMapper.readValue(event, IncomingTsEvent.class);
            log.info("Received Time Series event: {}", incomingTsEvent);
            TsEvent tsEvent = tsEventMapper.toDomain(incomingTsEvent);
            storeEventUsecase.storeSalinity(tsEvent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
