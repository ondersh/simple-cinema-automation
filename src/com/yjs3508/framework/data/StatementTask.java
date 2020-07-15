package com.yjs3508.framework.data;

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementTask<E> {

   E doInStatement(Statement statement) throws SQLException;
}
