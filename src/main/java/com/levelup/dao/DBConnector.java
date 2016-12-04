package com.levelup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Daitin on 19.11.2016.
 */
public class DBConnector implements IDBConnector{
    private static DBConnector instance;
    private DBConnector() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static DBConnector getInstance() throws SQLException {
        if(instance!=null){
            return instance;
        }
        synchronized (DBConnector.class){
            if(instance!=null){
                return instance;
            }
            instance = new DBConnector();
            return instance;
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres",
                "546317290");
    }
}
