package com.yjs3508.framework.data;

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
        Connection connection = DriverManager.getConnection(datasourceUrl,datasourceUsername,datasourcePassword);
        System.out.println("Connected");
       return  connection;
    }

    @Override
    public Connection getConnection(String userName, String password) throws SQLException {
        return null;
    }
}
