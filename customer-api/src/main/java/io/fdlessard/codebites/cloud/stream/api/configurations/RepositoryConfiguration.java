package io.fdlessard.codebites.cloud.stream.api.configurations;

import io.fdlessard.codebites.cloud.stream.api.model.CustomerEventHandler;
import io.fdlessard.codebites.cloud.stream.api.model.CustomerPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

  @Bean
  CustomerEventHandler customerEventHandler(CustomerPublisher customerPublisher) {
    return new CustomerEventHandler(customerPublisher);
  }

}
