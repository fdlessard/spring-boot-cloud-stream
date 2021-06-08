package io.fdlessard.codebites.cloud.stream.api.controllers;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import io.fdlessard.codebites.cloud.stream.api.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class AsynchronousCustomerController {

  private CustomerService customerService;

  @PostMapping(value = "/asynchronous-customers")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody
  public void post(@RequestBody Customer customer) {

    logger.info("AsynchronousCustomerController.post(" + customer + ")");
    customerService.createAsynchronousCustomer(customer);
  }

  @PatchMapping(value = "/asynchronous-customers")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody
  public void patch(@RequestBody Customer customer) {

    logger.info("AsynchronousCustomerController.patch(" + customer + ")");
    customerService.updateAsynchronousCustomer(customer);
  }

  @PutMapping(value = "/asynchronous-customers")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody
  public void put(@RequestBody Customer customer) {

    logger.info("AsynchronousCustomerController.put(" + customer + ")");
    customerService.updateAsynchronousCustomer(customer);
  }

}
