package io.fdlessard.codebites.cloud.stream.model;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class AddressEventHandler {

    @HandleAfterCreate
    public void handleAfterCreate(Address address) {
        System.out.println("ADDRESS CREATE EVENT : " + address);
    }

    @HandleAfterSave
    public void handleAfterSave(Address address) {
        System.out.println("ADDRESS SAVE EVENT : " + address);
    }

}
