package io.fdlessard.codebites.cloud.stream.api.controllers;

import io.fdlessard.codebites.cloud.stream.api.model.Address;
import io.fdlessard.codebites.cloud.stream.api.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@RepositoryRestController
public class AddressController {

  private AddressService addressService;

  @PostMapping(value = "/addresses")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public void post(@RequestBody Address address) {
    addressService.createAddress(address);
  }

}
