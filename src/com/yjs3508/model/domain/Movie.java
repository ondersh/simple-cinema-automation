package com.yjs3508.model.domain;

import com.yjs3508.model.domain.core.AbstractEntity;

import java.util.List;

public class Movie  extends AbstractEntity {

    private String movieName;
    private String type;
    private List<Actor> actors;
    private Theatre theatre;


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

    public Theatre getTheatre() {
        return theatre;
    }
    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

}
