package com.yjs3508.dal;

import com.yjs3508.framework.ApplicationContext;
import com.yjs3508.framework.data.ConnectionTask;
import com.yjs3508.model.domain.Seance;
import com.yjs3508.model.domain.Theatre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

public class TheatreDAOImpl extends AbstractDAO<Theatre> implements TheatreDAO {

    private static final String FIND_THEATRE_BY_ID_SQL = "SELECT  * FROM cinema.t_theatres WHERE theatre_id = ?";

    @Override
    public Theatre save(Theatre entity) {
        return null;
    }

    @Override
    public Theatre update(Theatre entity) {
        return null;
    }

    @Override
    public Theatre findById(int id) {
        return  ApplicationContext.getDAOTemplate().execute(new ConnectionTask<Theatre>() {
            @Override
            public Theatre doInConnection(Connection connection) throws SQLException {
                Theatre theatre = null;
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_THEATRE_BY_ID_SQL);
                preparedStatement.setInt(1,id);
                ResultSet theatreResult = preparedStatement.executeQuery();
                while (theatreResult.next()){
                    theatre = new Theatre();
                    theatre.setId(theatreResult.getInt("theatre_id"));
                    theatre.setCapacity(theatreResult.getInt("theatre_capacity"));
                    theatre.setTheatreName(theatreResult.getString("theatre_name"));
                }
                return theatre;
            }
        });
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<Theatre> getAll() {
        return null;
    }
}
