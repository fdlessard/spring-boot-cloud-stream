package io.fdlessard.codebites.cloud.stream.api.model;

import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(
    name = "customerInlineProjection",
    types = {Customer.class}
)
public interface CustomerInlineProjection {

  Long getId();

  String getFirstName();

  String getLastName();

  String getCompany();

  Set<Address> getAddresses();

}
