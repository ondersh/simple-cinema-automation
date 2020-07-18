package com.yjs3508.dal;

import com.yjs3508.framework.ApplicationContext;
import com.yjs3508.framework.data.ConnectionTask;
import com.yjs3508.model.domain.Seance;
import com.yjs3508.model.domain.Theatre;
import com.yjs3508.model.domain.Ticket;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl extends AbstractDAO<Ticket> implements TicketDAO {

    private static final String GET_TICKETS_SQL = "SELECT * FROM cinema.t_tickets WHERE theatre_id = ? AND seance_id = ?";
    private static final String INSERT_TICKET_SQL = "INSERT INTO cinema.t_tickets (seance_id,theatre_id,seat_number) VALUES (?,?,?)";


    private TheatreDAOImpl theatreDAO;
    private SeanceDAOImpl seanceDAO;

    public TicketDAOImpl() {
        theatreDAO = new TheatreDAOImpl();
        seanceDAO = new SeanceDAOImpl();
    }


    @Override
    public Ticket save(Ticket entity) {
        return ApplicationContext.getDAOTemplate().execute(new ConnectionTask<Ticket>() {
            @Override
            public Ticket doInConnection(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(INSERT_TICKET_SQL);
                statement.setInt(1, entity.getSeance().getId());
                statement.setInt(2, entity.getTheatre().getId());
                statement.setInt(3, entity.getSeatNumber());
                int affectedRowCount = statement.executeUpdate();
                if(affectedRowCount > 0 ) return entity;
                return null;
            }
        });
    }

    @Override
    public Ticket update(Ticket entity) {
        return null;
    }

    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public List<Ticket> getTickets(int theatreId, int seanceId) {
        return ApplicationContext.getDAOTemplate().execute(new ConnectionTask<List<Ticket>>() {

            @Override
            public List<Ticket> doInConnection(Connection connection) throws SQLException {
                Theatre theatre = theatreDAO.findById(theatreId);
                Seance seance = seanceDAO.findById(seanceId);
                List<Ticket> tickets = new ArrayList<>();
                PreparedStatement statement = connection.prepareStatement(GET_TICKETS_SQL);
                statement.setInt(1, theatreId);
                statement.setInt(2, seanceId);
                ResultSet ticketsResult = statement.executeQuery();
                while (ticketsResult.next()) {
                    Ticket ticket = new Ticket();
                    ticket.setId(ticketsResult.getInt("ticket_id"));
                    ticket.setSeance(seance);
                    ticket.setTheatre(theatre);
                    ticket.setSeatNumber(ticketsResult.getInt("seat_number"));
                    tickets.add(ticket);
                }
                return tickets;
            }
        });

    }
}
