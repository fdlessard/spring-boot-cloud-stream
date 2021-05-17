package io.fdlessard.codebites.cloud.stream.model;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class CustomerEventHandler {

    @HandleAfterCreate
    public void handleAfterCreate(Customer customer) {
        System.out.println("CUSTOMER CREATE EVENT : " + customer);
    }

    @HandleAfterSave
    public void handleAfterSave(Customer customer) {
        System.out.println("CUSTOMER SAVE EVENT : " + customer);

    }

}
