package io.fdlessard.codebites.cloud.stream.processor.services;

import io.fdlessard.codebites.cloud.stream.processor.model.Address;
import io.fdlessard.codebites.cloud.stream.processor.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class AddressService {

  private AddressRepository addressRepository;

  public Address createAddress(Address address) {

    Address createdAddress = addressRepository.save(address);
    return createdAddress;
  }

}
