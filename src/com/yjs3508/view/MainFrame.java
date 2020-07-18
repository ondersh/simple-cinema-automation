package com.yjs3508.view;

import com.yjs3508.framework.ApplicationConstants;
import com.yjs3508.model.domain.Movie;
import com.yjs3508.view.utils.MovieListModel;
import com.yjs3508.view.utils.WidgetFactory;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class MainFrame extends JFrame {

    private MovieListModel movieListModel;
    private JTable movieList;
    private JTextField txtMovieName;
    private JTextField txtMovieType;
    private JButton button;

    public MainFrame() {
        setLayout(new BorderLayout());
        add(constructMoviesPanel(), BorderLayout.WEST);
        add(constructMovieDetailPanel(), BorderLayout.EAST);
    }

    private JPanel constructMoviesPanel() {
        JPanel moviesPanel = new JPanel(new BorderLayout());
        moviesPanel.setBorder(new TitledBorder(ApplicationConstants.VIEW_CONSTANTS.MOVIES_BORDER_TITLE));
        movieListModel = new MovieListModel();
        movieList = new JTable(movieListModel);
        movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane movieListScroller = new JScrollPane(movieList);
        moviesPanel.add(movieListScroller, BorderLayout.CENTER);
        movieListScroller.setPreferredSize(new Dimension(250, 400));
        return moviesPanel;
    }

    private JPanel constructMovieDetailPanel() {
        JPanel movieDetailPanel = new JPanel(new BorderLayout());
        {
            JPanel movieInfoPanel = new JPanel(new GridLayout(2, 2, 5, 5));
            movieInfoPanel.setBorder(new TitledBorder(ApplicationConstants.VIEW_CONSTANTS.MOVIE_DETAIL_TITLE));
            {

                {
                    movieInfoPanel.add(WidgetFactory.createLabel("MOVIE NAME"));
                    txtMovieName = WidgetFactory.createTextField();
                    txtMovieName.setEnabled(false);
                    movieInfoPanel.add(txtMovieName);
                }
                {
                    movieInfoPanel.add(WidgetFactory.createLabel("MOVIE TYPE"));
                    txtMovieType = WidgetFactory.createTextField();
                    txtMovieType.setEnabled(false);
                    movieInfoPanel.add(txtMovieType);
                }

                movieDetailPanel.add(movieInfoPanel, BorderLayout.CENTER);
            }
            JPanel buttonPanel = new JPanel();
            {
                button = WidgetFactory.createButton("GET TICKET");
                buttonPanel.add(button);
                movieDetailPanel.add(buttonPanel, BorderLayout.SOUTH);
            }

        }

        return movieDetailPanel;
    }

    public void setMovies(List<Movie> movies){
        movieListModel.setMovies(movies);
    }

    public Movie getSelectedMovie(){
        int index = movieList.getSelectedRow();
        return movieListModel.getMovies().get(index);
    }

    public void addGetTicketButtonListener(ActionListener listener){
        button.addActionListener(listener);
    }

    public void addListSelectionListener(ListSelectionListener listener){
        movieList.getSelectionModel().addListSelectionListener(listener);

    }

    public void updateMovieValues(Movie movie){
        txtMovieName.setText(movie.getMovieName());
        txtMovieType.setText(movie.getType());
        // TODO
    }
}
