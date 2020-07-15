package com.yjs3508.services;

import com.yjs3508.dal.MovieDAOImpl;
import com.yjs3508.model.domain.Movie;

public class MovieService  extends  AbstractService<Movie>{

    public MovieService() {
        super(new MovieDAOImpl());
    }
}
