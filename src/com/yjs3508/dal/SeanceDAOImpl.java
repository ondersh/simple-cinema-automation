package com.yjs3508.dal;

import com.yjs3508.framework.ApplicationContext;
import com.yjs3508.framework.data.ConnectionTask;
import com.yjs3508.model.domain.Seance;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAOImpl extends AbstractDAO<Seance> implements SeanceDAO {

    private static final String GET_ALL_SEANCES_SQL = "SELECT * FROM cinema.t_seances";
    private static final String FIND_SEANCE_BY_ID_SQL = "SELECT  * FROM cinema.t_seances WHERE seance_id = ?";


    @Override
    public Seance save(Seance entity) {
        return null;
    }

    @Override
    public Seance update(Seance entity) {
        return null;
    }

    @Override
    public Seance findById(int id) {
      return  ApplicationContext.getDAOTemplate().execute(new ConnectionTask<Seance>() {
            @Override
            public Seance doInConnection(Connection connection) throws SQLException {
                Seance seance = null;
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_SEANCE_BY_ID_SQL);
                preparedStatement.setInt(1,id);
                ResultSet seanceResult = preparedStatement.executeQuery();
                while (seanceResult.next()){
                     seance = new Seance();
                     seance.setId(seanceResult.getInt("seance_id"));
                     seance.setDescription(seanceResult.getString("seance_description"));
                     seance.setBeginTime(LocalTime.parse(seanceResult.getString("seance_begin_time")));
                }
                return seance;
            }
        });
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<Seance> getAll() {
        return ApplicationContext.getDAOTemplate().execute(new ConnectionTask<List<Seance>>() {
            @Override
            public List<Seance> doInConnection(Connection connection) throws SQLException {
                List<Seance> seances = new ArrayList<>();
                Statement statement = connection.createStatement();
                ResultSet seanceResult = statement.executeQuery(GET_ALL_SEANCES_SQL);
                while (seanceResult.next()){
                    Seance seance = new Seance();
                    seance.setId(seanceResult.getInt("seance_id"));
                    seance.setDescription(seanceResult.getString("seance_description"));
                    seances.add(seance);
                }
                return seances;
            }
        });
    }
}
