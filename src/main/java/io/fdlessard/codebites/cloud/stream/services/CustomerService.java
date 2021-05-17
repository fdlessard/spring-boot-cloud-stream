package io.fdlessard.codebites.cloud.stream.services;

import io.fdlessard.codebites.cloud.stream.model.Customer;
import io.fdlessard.codebites.cloud.stream.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerService {

  public static final String CUSTOMER_BINDING_NAME = "customer-out-0";

  private CustomerRepository customerRepository;

  private StreamBridge streamBridge;

  public Customer createCustomer(Customer customer) {

    Customer createdCustomer = customerRepository.save(customer);
    streamBridge.send(CUSTOMER_BINDING_NAME, customer);
    return createdCustomer;
  }

}
