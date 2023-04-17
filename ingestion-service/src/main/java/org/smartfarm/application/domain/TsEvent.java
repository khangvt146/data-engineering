package org.smartfarm.application.domain;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
public class TsEvent {
    String deviceId;
    LocalDateTime timestamps;
    Double value;
    String unit;
}
