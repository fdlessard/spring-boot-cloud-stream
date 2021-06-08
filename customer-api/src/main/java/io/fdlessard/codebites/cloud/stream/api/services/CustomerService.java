package io.fdlessard.codebites.cloud.stream.api.services;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import io.fdlessard.codebites.cloud.stream.api.repositories.CustomerRepository;
import liquibase.pro.packaged.C;
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

  public Customer getCustomer(Long id) {
    logger.info("CustomerService.getCustomer - {}", id);
    return customerRepository.findById(id).get();
  }

  public void createAsynchronousCustomer(Customer customer) {
    logger.info("CustomerService.createAsynchronousCustomer - {}", customer);
    logger.info("Sending customer: {}", customer);
    streamBridge.send(CUSTOMER_BINDING_NAME, customer);
  }

  public Customer createCustomer(Customer customer) {
    logger.info("CustomerService.createCustomer - {}", customer);
    logger.info("Create customer: {}", customer);
    return customerRepository.save(customer);
  }

  public void updateCustomer(Customer customer) {
    logger.info("Updating customer: {}", customer);
    streamBridge.send(CUSTOMER_BINDING_NAME, customer);
  }

}
