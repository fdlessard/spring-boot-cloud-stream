package io.fdlessard.codebites.cloud.stream.api.controllers;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import io.fdlessard.codebites.cloud.stream.api.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping(value = "/synchronous-customers/{id}")
  @ResponseStatus(HttpStatus.FOUND)
  @ResponseBody
  public Customer get(@PathVariable Long id) {

    logger.info("SynchronousCustomerController.get(" + id + ")");
    return customerService.getCustomer(id);
  }

  @PostMapping(value = "/synchronous-customers")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public void post(@RequestBody Customer customer) {

    logger.info("SynchronousCustomerController.post(" + customer + ")");
    customerService.createCustomer(customer);
  }

}
