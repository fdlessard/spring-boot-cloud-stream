package io.fdlessard.codebites.cloud.stream.processor.repositories;

import io.fdlessard.codebites.cloud.stream.processor.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}