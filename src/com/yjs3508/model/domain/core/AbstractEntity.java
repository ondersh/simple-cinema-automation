package com.yjs3508.model.domain.core;

import com.yjs3508.model.domain.core.GenericEntity;

public abstract class AbstractEntity implements GenericEntity {

    private int id;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
