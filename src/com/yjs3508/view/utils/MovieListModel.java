package com.yjs3508.view.utils;

import com.yjs3508.model.domain.Movie;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class MovieListModel extends AbstractTableModel {

    private final String[] COLUMN_NAMES = {"MOVIE NAMES"};
    private List<Movie> movies = new ArrayList<>();


    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = null;
        Movie movie = movies.get(rowIndex);
        result = movie.getMovieName();
        return result;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
