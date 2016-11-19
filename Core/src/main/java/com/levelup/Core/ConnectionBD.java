package com.levelup.Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Daitin on 19.11.2016.
 */
public class ConnectionBD {
    private static ConnectionBD instance;
    private ConnectionBD() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static ConnectionBD  getInstance() throws SQLException {
        if(instance!=null){
            return instance;
        }
        synchronized (ConnectionBD.class){
            if(instance!=null){
                return instance;
            }
            instance = new ConnectionBD();
            return instance;
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres",
                "546317290");
    }
}
