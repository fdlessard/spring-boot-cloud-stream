package io.fdlessard.codebites.cloud.stream.api.services;

import io.fdlessard.codebites.cloud.stream.api.model.Address;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class AddressService {

  public static final String ADDRESS_BINDING_NAME = "address-out-0";

  private StreamBridge streamBridge;

  public void createAddress(Address address) {
    logger.info("Sending address: {}", address);
    streamBridge.send(ADDRESS_BINDING_NAME, address);
  }

}
