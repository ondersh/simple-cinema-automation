package com.yjs3508.framework.exceptions;

public class JDBCConnectionException extends  RuntimeException {

    public JDBCConnectionException(String message){
        super(message);
    }
}
