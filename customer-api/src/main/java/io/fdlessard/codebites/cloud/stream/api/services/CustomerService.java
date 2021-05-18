package io.fdlessard.codebites.cloud.stream.api.services;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerService {

  public static final String CUSTOMER_BINDING_NAME = "customer-out-0";

  private StreamBridge streamBridge;

  public void createCustomer(Customer customer) {
    logger.info("Sending customer: {}", customer);
    streamBridge.send(CUSTOMER_BINDING_NAME, customer);
  }

}
