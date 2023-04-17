package org.smartfarm.infrastructure.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PushKafkaMessage {
    String deviceId;
    String timestamps;
    Double value;
    String unit;
    String msg = null;
}
