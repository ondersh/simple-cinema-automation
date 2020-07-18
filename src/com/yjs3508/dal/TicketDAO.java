package com.yjs3508.dal;

import com.yjs3508.model.domain.Ticket;

import java.util.List;

public interface TicketDAO {

    List<Ticket> getTickets(int theatreId,int seanceId);
}
