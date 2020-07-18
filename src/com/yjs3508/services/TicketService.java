package com.yjs3508.services;

import com.yjs3508.dal.TicketDAOImpl;
import com.yjs3508.model.domain.Ticket;

import java.util.List;

public class TicketService extends AbstractService<Ticket>{

    public TicketService() {
        super(new TicketDAOImpl());
    }

    public List<Ticket> getTickets(int theatreId,int seanceId){
        return ((TicketDAOImpl)getDao()).getTickets(theatreId,seanceId);
    }
}
