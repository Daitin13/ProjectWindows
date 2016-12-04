package com.levelup.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daitin on 01.12.2016.
 */
public interface GenericDAO<T> {
    void setDbConnector(IDBConnector dbConnector);

    IDBConnector getDbConnector();

    boolean remove(T obj) throws SQLException;

    boolean update(T obj) throws SQLException;

    T create(T obj) throws Exception;

    List<T> get() throws SQLException;

}
