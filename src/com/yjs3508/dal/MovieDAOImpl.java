package com.yjs3508.dal;

import com.yjs3508.framework.data.ConnectionTask;
import com.yjs3508.framework.ApplicationContext;
import com.yjs3508.model.domain.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl extends AbstractDAO<Movie> implements MovieDAO {

    private static final String INSERT_MOVIE_SQL = "INSERT INTO t_movies VALUES (?,?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM cinema.t_movies";


    @Override
    public Movie save(Movie entity) {
        return null;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    public Movie findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<Movie> getAll() {
        return ApplicationContext.getDAOTemplate().execute(new ConnectionTask<List<Movie>>() {
            @Override
            public List<Movie> doInConnection(Connection connection) throws SQLException {
                List<Movie> movieList = new ArrayList<>();
                Statement statement = connection.createStatement();
                ResultSet movieResultSet = statement.executeQuery(SELECT_ALL_SQL);
                while(movieResultSet.next()){
                    Movie movie = new Movie();
                    movie.setMovieName(movieResultSet.getString("movie_name"));
                    movie.setType(movieResultSet.getString("movie_type"));
                    movieList.add(movie);
                }
                return movieList;
            }
        });
    }
}
