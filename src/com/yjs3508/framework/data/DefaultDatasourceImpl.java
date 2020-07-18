package com.yjs3508.framework.data;

import com.yjs3508.framework.exceptions.BadDatabaseCredentialsException;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DefaultDatasourceImpl implements Datasource {

    private String datasourceUrl;
    private String datasourceUsername;
    private String datasourcePassword;

    public DefaultDatasourceImpl withDatasourceUrl(String datasourceUrl){
        this.datasourceUrl = datasourceUrl;
        return this;
    }

    public DefaultDatasourceImpl withDatasourceUsername(String datasourceUsername){
        this.datasourceUsername = datasourceUsername;
        return this;
    }

    public DefaultDatasourceImpl withDatasourcePassword(String datasourcePassword){
        this.datasourcePassword = datasourcePassword;
        return this;
    }


    @Override
    public Connection getConnection() throws SQLException {
        if(datasourceUrl == null || datasourceUsername == null || datasourcePassword == null) throw new BadDatabaseCredentialsException();
        Connection connection = DriverManager.getConnection(datasourceUrl,datasourceUsername,datasourcePassword);
        System.out.println("Connected");
       return  connection;
    }

    @Override
    public Connection getConnection(String userName, String password) throws SQLException {
        return null;
    }
}
