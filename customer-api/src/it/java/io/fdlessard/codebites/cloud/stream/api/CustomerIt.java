package io.fdlessard.codebites.cloud.stream.api;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.fdlessard.codebites.cloud.stream.api.model.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Slf4j
@SpringBootTest
@ExtendWith( {SpringExtension.class})
public class CustomerIt extends BaseIt {

  @BeforeEach
  void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
        .build();
  }

  @Test
  void getCustomerById() throws Exception {

    mockMvc.perform(get("/customers/1"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("$.id", is(1)));
  }

  @Test
  void createCustomer() throws Exception {

    mockMvc.perform(post("/customers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(buildJsonStringClient()))
        .andExpect(status().is2xxSuccessful());

    Consumer<String, Customer> customerConsumer = createCustomerConsumer("customers", "customerGroup");
    List<Customer> customers = consumeCustomer(customerConsumer);
    assertNotNull(customers);
    assertEquals(1, customers.size());
    Customer customer = customers.get(0);
    assertEquals("firstName", customer.getFirstName());
    assertEquals("lastName", customer.getLastName());
    assertEquals("company", customer.getCompany());
  }

  static String buildJsonStringClient() {
    return TestUtils.readFileIntoString("/Customer.json");
  }

  private Consumer<String, Customer> createCustomerConsumer(String topicName, String group) {

    Map<String, Object> kafkaConsumerProperties = KafkaTestUtils.consumerProps(
        kafkaContainer.getBootstrapServers(),
        group,
        "true"
    );

    Consumer<String, Customer> consumer = new DefaultKafkaConsumerFactory<String, Customer>(
        kafkaConsumerProperties,
        new StringDeserializer(),
        new JsonDeserializer<>(Customer.class)
    ).createConsumer();
    consumer.subscribe(Collections.singletonList(topicName));

    return consumer;
  }

  public List<Customer> consumeCustomer(Consumer<String, Customer> customerConsumer) {
    ConsumerRecords<String, Customer> customerRecords = KafkaTestUtils.getRecords(customerConsumer, 5000);
    List<Customer> customerValues = new ArrayList<>();
    customerRecords.forEach(customerRecord -> customerValues.add(customerRecord.value()));

    return customerValues;
  }

}
