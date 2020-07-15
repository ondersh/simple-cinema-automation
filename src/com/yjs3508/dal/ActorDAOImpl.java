package com.yjs3508.dal;

import com.yjs3508.framework.data.ConnectionTask;
import com.yjs3508.framework.ApplicationContext;
import com.yjs3508.model.domain.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAOImpl extends AbstractDAO<Actor> implements ActorDAO {

    private static final String INSERT_ACTOR_SQL = "INSERT INTO cinema.t_actors VALUES (?,?)";
    private static  final String SELECT_ALL_SQL = "SELECT * FROM cinema.t_actors";


    @Override
    public Actor save(Actor entity) {
        return ApplicationContext.getDAOTemplate().execute(new ConnectionTask<Actor>() {
            @Override
            public Actor doInConnection(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(INSERT_ACTOR_SQL);
                statement.setString(1, entity.getFirstName());
                statement.setString(2, entity.getLastName());
                int affectedRow = statement.executeUpdate();
                if (affectedRow > 0) return entity;
                return null;
            }
        });
    }

    @Override
    public Actor update(Actor entity) {
        return null;
    }

    @Override
    public Actor findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<Actor> getAll() {
       List<Actor> actorList = ApplicationContext.getDAOTemplate().execute(new ConnectionTask<List<Actor>>() {
            @Override
            public List<Actor> doInConnection(Connection connection) throws SQLException {
                List<Actor> actorList = new ArrayList<>();
                Statement statement = connection.createStatement();
                ResultSet actorsResultSet = statement.executeQuery(SELECT_ALL_SQL);
                while(actorsResultSet.next()){
                    Actor actor = new Actor();
                    actor.setFirstName(actorsResultSet.getString("first_name"));
                    actor.setLastName(actorsResultSet.getString("last_name"));
                    actorList.add(actor);
                }
                return actorList;
            }
        });
       return actorList;
    }
}
