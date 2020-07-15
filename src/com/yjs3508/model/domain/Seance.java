package com.yjs3508.model.domain;

import com.yjs3508.model.domain.core.AbstractEntity;

import java.time.LocalTime;

public class Seance extends AbstractEntity {

    private String description;
    private LocalTime beginTime;
    private LocalTime endTime;


    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int getId() {
        return 0;
    }
}
