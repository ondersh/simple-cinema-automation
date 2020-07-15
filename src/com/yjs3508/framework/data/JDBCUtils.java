package com.yjs3508.framework.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class JDBCUtils {


    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

    }

}
