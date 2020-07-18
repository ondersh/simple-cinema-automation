package com.yjs3508.view;

import com.yjs3508.model.domain.Movie;
import com.yjs3508.model.domain.Seance;
import com.yjs3508.model.domain.Ticket;
import com.yjs3508.view.utils.SeanceComboBoxModel;
import com.yjs3508.view.utils.SeatButton;
import com.yjs3508.view.utils.WidgetFactory;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.List;

public class GetTicketFrame extends JPanel {

    private Movie movie;
    private JButton buyButton;
    private JComboBox<Seance> seancesComboBox;
    private SeanceComboBoxModel seanceComboBoxModel;
    private JPanel seancePanel;
    private SeatPanel seatsPanel;
    private JPanel buttonPanel;
    private List<Ticket> tickets;

    public GetTicketFrame(Movie movie,List<Seance> seances) {
        this.movie = movie;
        setLayout(new BorderLayout());

        seancePanel = new JPanel(new BorderLayout());
        seancePanel.setBorder(new TitledBorder("SELECT SEANCE"));
        {
            seanceComboBoxModel = new SeanceComboBoxModel();
            seancesComboBox = new JComboBox<Seance>(seanceComboBoxModel);
            seancePanel.add(seancesComboBox, BorderLayout.CENTER);
        }
        setSeances(seances);
        add(seancePanel, BorderLayout.NORTH);

        seatsPanel = new SeatPanel();
        add(seatsPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new BorderLayout());
        {
            buyButton = WidgetFactory.createButton("Buy Ticket");
            buttonPanel.add(buyButton);
        }
        add(buttonPanel, BorderLayout.SOUTH);
    }


    public void addBuyButtonListener(ActionListener listener) {
        buyButton.addActionListener(listener);
    }

    public void addComboboxListener(ItemListener listener) {
        seancesComboBox.addItemListener(listener);
    }

    public JComboBox<Seance> getSeances(){
        return seancesComboBox;
    }

    public void updateSeatsForTickets(List<Ticket> tickets) {
        seatsPanel.setCapacity(movie.getTheatre().getCapacity());
        seatsPanel.setTickets(tickets);
        seatsPanel.removeAll();
        seatsPanel.revalidate();
        seatsPanel.createSeats();
    }

    private void setSeances(List<Seance> allSeances) {
        for (Seance seance : allSeances) {
            seanceComboBoxModel.addElement(seance);
        }
    }

}
