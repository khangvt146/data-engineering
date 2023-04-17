package org.smartfarm.infrastructure.database.repository;

import org.smartfarm.infrastructure.database.entity.HumidityRecord;
import org.smartfarm.infrastructure.database.entity.SalinityRecord;
import org.springframework.data.repository.CrudRepository;

public interface SalinityRepository extends CrudRepository<SalinityRecord, String> {

}
