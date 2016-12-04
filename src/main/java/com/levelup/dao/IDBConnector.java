package com.levelup.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Daitin on 01.12.2016.
 */
public interface IDBConnector {

    Connection getConnection() throws SQLException;
}
