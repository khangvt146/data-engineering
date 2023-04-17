package org.smartfarm.infrastructure.database.repository;

import org.smartfarm.infrastructure.database.entity.LightRecord;
import org.smartfarm.infrastructure.database.entity.TempRecord;
import org.springframework.data.repository.CrudRepository;

public interface LightRepository extends CrudRepository<LightRecord, String> {

}
