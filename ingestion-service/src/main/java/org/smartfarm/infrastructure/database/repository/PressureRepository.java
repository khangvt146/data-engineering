package org.smartfarm.infrastructure.database.repository;

import org.smartfarm.infrastructure.database.entity.HumidityRecord;
import org.smartfarm.infrastructure.database.entity.PressureRecord;
import org.springframework.data.repository.CrudRepository;

public interface PressureRepository extends CrudRepository<PressureRecord, String> {

}
