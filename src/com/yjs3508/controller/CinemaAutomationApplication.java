package com.yjs3508.controller;

import com.yjs3508.framework.Application;
import com.yjs3508.model.domain.Movie;
import com.yjs3508.model.domain.Seance;
import com.yjs3508.model.domain.Ticket;
import com.yjs3508.services.ServiceContext;
import com.yjs3508.view.GetTicketFrame;
import com.yjs3508.view.MainFrame;
import com.yjs3508.view.utils.SeatButton;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.List;

public class CinemaAutomationApplication extends Application implements ActionListener, ListSelectionListener, ItemListener {

    private MainFrame mainFrame;
    private JDialog secondFrame;
    private GetTicketFrame getTicketFrame;
    private Movie selectedMovie;
    private Seance seance;
    private int defaultSeanceIndex;


    @Override
    public void start() {
        SwingUtilities.invokeLater(this);
        defaultSeanceIndex = 0;
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
        createGetTicketFrame();
        seance = ServiceContext.getSeanceService().findEntityById(defaultSeanceIndex + 1);
        List<Ticket> tickets = getTicketsAtTheatreForSeance(selectedMovie.getTheatre().getId(),seance.getId());
        getTicketFrame = new GetTicketFrame(selectedMovie,ServiceContext.getSeanceService().getAll());
        getTicketFrame.addBuyButtonListener(new BuyButtonListener());
        getTicketFrame.addComboboxListener(this);
        getTicketFrame.updateSeatsForTickets(tickets);
        secondFrame.add(getTicketFrame);
    }

    public void createGetTicketFrame(){
        secondFrame = new JDialog();
        secondFrame.setSize(800,600);
        secondFrame.setTitle("GET TICKET");
        secondFrame.setLocationRelativeTo(null);
        secondFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        secondFrame.setVisible(true);
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
        System.out.println("Application is going to shutdown...");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()){
            selectedMovie = mainFrame.getSelectedMovie();
            mainFrame.updateMovieValues(selectedMovie);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                defaultSeanceIndex = getTicketFrame.getSeances().getSelectedIndex();
                seance = ServiceContext.getSeanceService().findEntityById(defaultSeanceIndex + 1);
                List<Ticket> tickets = getTicketsAtTheatreForSeance(selectedMovie.getTheatre().getId(),seance.getId());
                getTicketFrame.updateSeatsForTickets(tickets);
            }
    }

    private List<Ticket> getTicketsAtTheatreForSeance(int theatreId, int seanceId) {
       return ServiceContext.getTicketService().getTickets(theatreId,seanceId);
    }

    class BuyButtonListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            List<SeatButton> seats = SeatButton.getSeatList();
            for(int i = 0; i< seats.size(); i++){
                Ticket ticket = new Ticket();
                ticket.setSeatNumber(seats.get(i).getSeatNumber());
                ticket.setSeance(seance);
                ticket.setTheatre(selectedMovie.getTheatre());
                ServiceContext.getTicketService().save(ticket);
            }
            SeatButton.disableSeatList();
            SeatButton.clearSeatList();
        }
    }


}
