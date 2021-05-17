package io.fdlessard.codebites.cloud.stream;

import io.fdlessard.codebites.cloud.stream.model.Address;
import io.fdlessard.codebites.cloud.stream.model.Customer;
import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCloudStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCloudStreamApplication.class, args);
    }

    @Bean
    Consumer<Customer> receiveCustomer() {
        return customer -> System.out.println("Received Customer: " + customer);
    }

    @Bean
    Consumer<Address> receiveAddress() {
        return address -> System.out.println("Received Address: " + address);
    }

}
