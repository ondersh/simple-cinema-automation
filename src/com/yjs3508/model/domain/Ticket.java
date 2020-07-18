package com.yjs3508.model.domain;

import com.yjs3508.model.domain.core.AbstractEntity;

import java.time.LocalDate;

public class Ticket extends AbstractEntity {

    private int seatNumber;
    private LocalDate ticketDate;
    private Seance seance;
    private Theatre theatre;

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public Seance getSeance() {
        return seance;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber=" + seatNumber +
                ", ticketDate=" + ticketDate +
                ", seance=" + seance +
                ", theatre=" + theatre +
                '}';
    }
}
