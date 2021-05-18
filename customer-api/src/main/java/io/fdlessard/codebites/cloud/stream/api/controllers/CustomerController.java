package io.fdlessard.codebites.cloud.stream.api.controllers;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import io.fdlessard.codebites.cloud.stream.api.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@RepositoryRestController
public class CustomerController {

  private CustomerService customerService;

  @PostMapping(value = "/customers")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public void post(@RequestBody Customer customer) {
    customerService.createCustomer(customer);
  }

}
