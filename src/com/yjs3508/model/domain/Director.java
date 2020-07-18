package com.yjs3508.model.domain;

import com.yjs3508.model.domain.core.AbstractEntity;

public class Director extends AbstractEntity {

    private String firstName;
    private String lastName;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
