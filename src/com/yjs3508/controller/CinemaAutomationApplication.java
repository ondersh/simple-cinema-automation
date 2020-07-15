package com.yjs3508.controller;

import com.yjs3508.framework.Application;
import com.yjs3508.model.domain.Movie;
import com.yjs3508.services.ServiceContext;
import com.yjs3508.view.MainFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class CinemaAutomationApplication extends Application implements ActionListener, ListSelectionListener, ItemListener {

    private MainFrame mainFrame;


    @Override
    public void start() {
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        mainFrame = new MainFrame();
        createMainFrame(mainFrame);
        mainFrame.setMovies(ServiceContext.getMovieService().getAll());
        mainFrame.addGetTicketButtonListener(this);
        mainFrame.addListSelectionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");
    }

    public void createMainFrame(JFrame frame){
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stopApplication();
            }
        });
    }

    @Override
    public void beforeApplicationStop() {
        System.out.println("BYEEE !!");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()){
            Movie movie = mainFrame.getSelectedMovie();
//            System.out.println(movie.getMovieName());
            mainFrame.updateMovieValues(movie);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

}
