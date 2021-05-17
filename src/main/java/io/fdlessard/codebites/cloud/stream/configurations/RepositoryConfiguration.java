package io.fdlessard.codebites.cloud.stream.configurations;

import io.fdlessard.codebites.cloud.stream.model.AddressEventHandler;
import io.fdlessard.codebites.cloud.stream.model.CustomerEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

  @Bean
  CustomerEventHandler customerEventHandler() {
    return new CustomerEventHandler();
  }

  @Bean
  AddressEventHandler addressEventHandler() {
    return new AddressEventHandler();
  }
}
