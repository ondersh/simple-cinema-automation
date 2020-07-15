package com.yjs3508.framework.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionTask<E> {

    E doInConnection(Connection connection) throws SQLException;
}
