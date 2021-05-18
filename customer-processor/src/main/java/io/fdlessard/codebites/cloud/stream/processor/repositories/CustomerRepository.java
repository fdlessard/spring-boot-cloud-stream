package io.fdlessard.codebites.cloud.stream.processor.repositories;

import io.fdlessard.codebites.cloud.stream.processor.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
