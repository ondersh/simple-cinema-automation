package com.yjs3508.framework.data;

import com.yjs3508.framework.exceptions.JDBCConnectionException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * All Connection utilities
 */

abstract class DatasourceUtils {


    /**
     *
     *
     *
     * @param datasource
     * @return
     * @throws SQLException
     */


    public static Connection getConnection(Datasource datasource) throws JDBCConnectionException {
        try{
            return datasource.getConnection();
        }catch (SQLException exception){
            throw new JDBCConnectionException("Database Connection Fail");
        }
    }

    // close connection ...
    // release connection ...
}
