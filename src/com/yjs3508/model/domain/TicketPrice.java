package com.yjs3508.model.domain;

import com.yjs3508.model.domain.core.AbstractEntity;

public class TicketPrice extends AbstractEntity {

    private String description;
    private float price;


    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public int getId() {
        return 0;
    }
}
