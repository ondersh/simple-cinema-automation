package com.yjs3508.dal;

import com.yjs3508.framework.data.ConnectionTask;
import com.yjs3508.framework.ApplicationContext;
import com.yjs3508.model.domain.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAOImpl extends AbstractDAO<Director> implements DirectorDAO {

    private static final String INSERT_DIRECTOR_SQL = "INSERT INTO t_directors VALUES(?,?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM t_directors";

    @Override
    public Director save(Director entity) {
        return ApplicationContext.getDAOTemplate().execute(new ConnectionTask<Director>() {
            @Override
            public Director doInConnection(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(INSERT_DIRECTOR_SQL);
                statement.setString(1,entity.getFirstName());
                statement.setString(2,entity.getLastName());
                int affectedRowCount = statement.executeUpdate();
                if(affectedRowCount > 0) return entity;
                return null;
            }
        });
    }

    @Override
    public Director update(Director entity) {
        return null;
    }

    @Override
    public Director findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<Director> getAll() {
       return ApplicationContext.getDAOTemplate().execute(new ConnectionTask<List<Director>>() {
            @Override
            public List<Director> doInConnection(Connection connection) throws SQLException {
                List<Director> directorList = new ArrayList<>();
                Statement statement = connection.createStatement();
                ResultSet directorResultSet = statement.executeQuery(SELECT_ALL_SQL);
                while(directorResultSet.next()){
                    Director director = new Director();
                    director.setFirstName(directorResultSet.getString("first_name"));
                    director.setLastName(directorResultSet.getString("last_name"));
                    directorList.add(director);
                }
                return directorList;
            }
        });
    }
}
