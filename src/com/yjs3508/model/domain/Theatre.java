package com.yjs3508.model.domain;

import com.yjs3508.model.domain.core.AbstractEntity;

public class Theatre extends AbstractEntity {

    private String theatreName;
    private int capacity;
    private Movie movie;


    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getCapacity() {
        return capacity;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTheatreName() {
        return theatreName;
    }


    @Override
    public String toString() {
        return "Theatre{" +
                "theatreName='" + theatreName + '\'' +
                ", capacity=" + capacity +
                ", movie=" + movie +
                '}';
    }
}
