package io.fdlessard.codebites.cloud.stream.api.services;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import io.fdlessard.codebites.cloud.stream.api.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

  public static final String CUSTOMER_BINDING_NAME = "customer-out-0";

  private CustomerRepository customerRepository;

  private StreamBridge streamBridge;

  private boolean publishingActivated;

  public CustomerService(
      CustomerRepository customerRepository,
      StreamBridge streamBridge,
      @Value("${customer.publishingActivated}") boolean publishingActivated
  ) {
    this.customerRepository = customerRepository;
    this.streamBridge = streamBridge;
    this.publishingActivated = publishingActivated;
  }

  public Customer getCustomer(Long id) {
    logger.info("CustomerService.getCustomer - {}", id);
    return customerRepository.findById(id).get();
  }

  public void createAsynchronousCustomer(Customer customer) {

    if(!publishingActivated) {
      logger.info("Publishing of customer not activated - not sending create");
      return;
    }

    logger.info("CustomerService.createAsynchronousCustomer - {}", customer);

    Message<Customer> customerMessage = MessageBuilder.withPayload(customer)
        .setHeader("type", "Customer")
        .setHeader("action", "Create")
        .build();

    streamBridge.send(CUSTOMER_BINDING_NAME, customer);
  }

  public void updateAsynchronousCustomer(Customer customer) {

    if(!publishingActivated) {
      logger.info("Publishing of customer not activated - not sending update");
      return;
    }

    logger.info("CustomerService.updateAsynchronousCustomer - {}", customer);

    Message<Customer> customerMessage = MessageBuilder.withPayload(customer)
        .setHeader("type", "Customer")
        .setHeader("action", "Update")
        .build();

    streamBridge.send(CUSTOMER_BINDING_NAME, customerMessage);
  }

  public Customer createCustomer(Customer customer) {
    logger.info("CustomerService.createCustomer - {}", customer);
    Customer createdCustomer = customerRepository.save(customer);
    logger.info("CustomerService.createCustomer - createdCustomer : {}", customer);

    return createdCustomer;
  }

}
