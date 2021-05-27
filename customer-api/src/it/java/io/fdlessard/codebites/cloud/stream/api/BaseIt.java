package io.fdlessard.codebites.cloud.stream.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import liquibase.pro.packaged.S;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.KafkaContainer;

@Slf4j
@SpringBootTest
@ExtendWith({SpringExtension.class})
public abstract class BaseIt {

  @Autowired
  protected WebApplicationContext wac;

  protected MockMvc mockMvc;

  public static KafkaContainer kafkaContainer = CustomerApiKafkaContainer.getInstance();

  @DynamicPropertySource
  static void registerKafkaProperties(DynamicPropertyRegistry registry) {
    kafkaContainer.start();
    logger.info("Property spring.kafka.bootstrap-servers: " + kafkaContainer.getBootstrapServers());
    registry.add("spring.kafka.bootstrap-servers", () -> kafkaContainer.getBootstrapServers());
  }


/*  // @Bean
  public ConsumerFactory<Integer, String> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
  }

  // @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaContainer.getBootstrapServers());
    //   props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    //   props.put(ConsumerConfig.GROUP_ID_CONFIG, "baeldung");
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "customerGroup");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    return props;
  }

  //@Bean
  ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }*/

}
