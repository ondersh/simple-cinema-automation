package com.yjs3508.framework.data;

interface DatabaseOperations {

    <T> T execute(StatementTask<T> task);

    <T> T execute(ConnectionTask<T> task);

    void execute(String sql);

}
