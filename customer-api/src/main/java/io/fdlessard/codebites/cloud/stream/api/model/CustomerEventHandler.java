package io.fdlessard.codebites.cloud.stream.api.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Slf4j
@AllArgsConstructor
@RepositoryEventHandler
public class CustomerEventHandler {

    private CustomerPublisher customerPublisher;

    @HandleAfterCreate
    public void handleAfterCreate(Customer customer) {
        logger.info("CustomerEventHandler.handleAfterCreate() - {} ", customer);
        customerPublisher.publishCreate(customer);
    }

    @HandleAfterSave
    public void handleAfterSave(Customer customer) {
        logger.info("CustomerEventHandler.handleAfterSave() - {} ", customer);
        customerPublisher.publishUpdate(customer);
    }

}
