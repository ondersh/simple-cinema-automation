package com.yjs3508.model.domain;

import com.yjs3508.model.domain.core.AbstractEntity;

import java.util.List;

public class Movie  extends AbstractEntity {

    private String movieName;
    private String type;
    private List<Actor> actors;


    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getMovieName() {
        return movieName;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getId() {
        return 0;
    }
}
