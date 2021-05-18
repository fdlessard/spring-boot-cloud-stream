package io.fdlessard.codebites.cloud.stream.processor;

import io.fdlessard.codebites.cloud.stream.processor.model.Address;
import io.fdlessard.codebites.cloud.stream.processor.model.Customer;
import io.fdlessard.codebites.cloud.stream.processor.services.AddressService;
import io.fdlessard.codebites.cloud.stream.processor.services.CustomerService;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class CustomerProcessorApplication {

  @Autowired
  private CustomerService customerService;

  @Autowired
  private AddressService addressService;

  public static void main(String[] args) {
    SpringApplication.run(CustomerProcessorApplication.class, args);
  }

  @Bean
  Consumer<Customer> receiveCustomer() {
    return customer -> {
      logger.info("Received Customer: {}", customer);
      customerService.createCustomer(customer);
    };
  }

  @Bean
  Consumer<Address> receiveAddress() {
    return address -> {
      logger.info("Received Address: {}", address);
      addressService.createAddress(address);

    };
  }

}
