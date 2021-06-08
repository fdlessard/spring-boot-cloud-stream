package io.fdlessard.codebites.cloud.stream.api.controllers;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import io.fdlessard.codebites.cloud.stream.api.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class SynchronousCustomerController {

  private CustomerService customerService;

  @PostMapping(value = "/synchronous-customers")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public void post(@RequestBody Customer customer) {

    logger.info("SynchronousCustomerController.post(" + customer + ")");
    customerService.createCustomer(customer);
  }

}