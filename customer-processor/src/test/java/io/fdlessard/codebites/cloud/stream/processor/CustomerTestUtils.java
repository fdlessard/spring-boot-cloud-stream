package io.fdlessard.codebites.cloud.stream.processor;

import io.fdlessard.codebites.cloud.stream.processor.model.Customer;
import java.util.Arrays;
import java.util.List;

public final class CustomerTestUtils {

  public static final String TEST_ID_STR = "id";
  public static final String TEST_VERSION_STR = "version";
  public static final String TEST_FIRST_NAME_STR = "firstName";
  public static final String TEST_LAST_NAME_STR = "lastName";
  public static final String TEST_COMPANY_STR = "company";

  public static Customer buildCustomer() {
    return Customer.builder()
        .id(0l)
        .version(0)
        .firstName(TEST_FIRST_NAME_STR)
        .lastName(TEST_LAST_NAME_STR)
        .company(TEST_COMPANY_STR)
        .build();
  }

  public static List<Customer> buildCustomers() {

    Customer c = buildCustomer();
    c.setId(1l);

    return Arrays.asList( Customer.builder()
            .id(0l)
            .version(0)
            .firstName(TEST_FIRST_NAME_STR)
            .lastName(TEST_LAST_NAME_STR)
            .company(TEST_COMPANY_STR)
            .build(),
        c
    );
  }

  // private constructor since this is a Utils class
  private CustomerTestUtils() {
  }

}
