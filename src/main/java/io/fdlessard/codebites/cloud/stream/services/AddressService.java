package io.fdlessard.codebites.cloud.stream.services;

import io.fdlessard.codebites.cloud.stream.model.Address;
import io.fdlessard.codebites.cloud.stream.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class AddressService {

  public static final String ADDRESS_BINDING_NAME = "address-out-0";

  private AddressRepository addressRepository;

  private StreamBridge streamBridge;

  public Address createAddress(Address address) {

    Address createdAddress = addressRepository.save(address);
    streamBridge.send(ADDRESS_BINDING_NAME, address);
    return createdAddress;
  }

}
