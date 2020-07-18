package com.yjs3508.framework.data;

import com.yjs3508.framework.exceptions.DatabaseAccessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOTemplate implements DatabaseOperations {


    private Datasource datasource;

    public DAOTemplate(Datasource datasource){
        this.datasource = datasource;
    }

    public Datasource getDatasource() {
        return datasource;
    }

    @Override
    public <T> T execute(StatementTask<T> task) throws DatabaseAccessException {
        Connection connection = DatasourceUtils.getConnection(getDatasource());
        Statement statement = null;
        try{
            statement = connection.createStatement();
            return task.doInStatement(statement);
        }catch (SQLException exception){
            // TODO : return to connection pool
            statement = null;
            connection = null;
            throw new DatabaseAccessException();
        }finally {
            JDBCUtils.closeStatement(statement);
            // TODO: give the connection to pool (releaseConnection)
        }
    }

    @Override
    public <T> T execute(ConnectionTask<T> task) throws DatabaseAccessException {
        Connection connection = DatasourceUtils.getConnection(getDatasource());

        try{
            return task.doInConnection(connection);
        }catch (SQLException exception){
            // TODO: give the connection to pool
            connection = null;
            throw new DatabaseAccessException();
        }finally {
            // TODO: give the connection to pool
        }
    }

    @Override
    public void execute(String sql) {

    }
}
