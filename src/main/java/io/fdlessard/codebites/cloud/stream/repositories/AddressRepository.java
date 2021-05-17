package io.fdlessard.codebites.cloud.stream.repositories;

import io.fdlessard.codebites.cloud.stream.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "addresses")
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}