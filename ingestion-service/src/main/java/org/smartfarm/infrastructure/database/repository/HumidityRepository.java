package org.smartfarm.infrastructure.database.repository;

import org.smartfarm.infrastructure.database.entity.HumidityRecord;
import org.smartfarm.infrastructure.database.entity.TempRecord;
import org.springframework.data.repository.CrudRepository;

public interface HumidityRepository extends CrudRepository<HumidityRecord, String> {

}
