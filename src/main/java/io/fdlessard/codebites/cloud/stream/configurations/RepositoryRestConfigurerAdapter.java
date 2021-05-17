package io.fdlessard.codebites.cloud.stream.configurations;


import io.fdlessard.codebites.cloud.stream.model.Address;
import io.fdlessard.codebites.cloud.stream.model.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration repositoryRestConfiguration,
      CorsRegistry corsRegistry) {

    repositoryRestConfiguration.exposeIdsFor(
        Customer.class,
        Address.class
    );
  }

}
