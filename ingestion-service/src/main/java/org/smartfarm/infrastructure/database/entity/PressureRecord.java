package org.smartfarm.infrastructure.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pressure")
@Getter
@Setter
public class PressureRecord {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "received_at")
    private LocalDateTime timestamps;

    @Column(name = "value")
    private Double value;

    @Column(name = "unit")
    private String unit = null;
}
