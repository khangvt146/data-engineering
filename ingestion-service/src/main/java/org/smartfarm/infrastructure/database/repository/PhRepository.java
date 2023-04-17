package org.smartfarm.infrastructure.database.repository;

import org.smartfarm.infrastructure.database.entity.HumidityRecord;
import org.smartfarm.infrastructure.database.entity.PhRecord;
import org.springframework.data.repository.CrudRepository;

public interface PhRepository extends CrudRepository<PhRecord, String> {

}
