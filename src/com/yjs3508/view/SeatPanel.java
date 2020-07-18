package com.yjs3508.view;

import com.yjs3508.model.domain.Ticket;
import com.yjs3508.view.utils.SeatButton;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class SeatPanel extends JPanel {

    private int capacity;
    private List<Ticket> tickets;

    public SeatPanel(){
        setLayout(new FlowLayout());
        setBorder(new TitledBorder("SELECT SEATS"));
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void createSeats() {
        boolean isButtonCreate = false;

        if (tickets.isEmpty()) {
            for (Integer i = 1; i <= capacity; i++) {
                add(new SeatButton(i.toString()));
            }
        } else {

            for (Integer i = 1; i <= capacity; i++) {
                for (int ti = 0; ti < tickets.size(); ti++) {
                    if (tickets.get(ti).getSeatNumber() == i) {
                        SeatButton sb = new SeatButton(Integer.toString(tickets.get(ti).getSeatNumber()));
                        sb.setEnabled(false);
                        add(sb);
                        isButtonCreate = true;
                        break;
                    }
                }

                if (isButtonCreate) {
                    isButtonCreate = false;
                    continue;
                } else {
                    add(new SeatButton(i.toString()));
                }
            }
        }
    }
}
