package io.fdlessard.codebites.cloud.stream.api;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

@Slf4j
public class CustomerApiKafkaContainer {

  private static KafkaContainer kafkaContainer = new KafkaContainer(
      DockerImageName.parse("confluentinc/cp-kafka")
    );
/*      .withEnv("ALLOW_PLAINTEXT_LISTENER", "yes")
      .withEnv("AUTO_CREATE_TOPICS","true")
      .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE","true")
      .withEnv("KAFKA_CREATE_TOPICS","customers:1:1,addresses:1:1");*/

  public static KafkaContainer getInstance() {
    return kafkaContainer;
  }

}
