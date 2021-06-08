package io.fdlessard.codebites.cloud.stream.api.model;

import io.fdlessard.codebites.cloud.stream.api.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class CustomerPublisher implements Publisher<Customer >{

  private CustomerService customerService;

  public void publishCreate(Customer customer) {
    logger.info("CustomerPublisher.publishCreate() - {} ", customer);
    customerService.updateAsynchronousCustomer(customer);
  }

  public void publishUpdate(Customer customer) {
    logger.info("CustomerPublisher.publishUpdate() - {} ", customer);
    customerService.updateAsynchronousCustomer(customer);
  }

}
