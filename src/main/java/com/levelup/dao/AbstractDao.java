package com.levelup.dao;

import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;

/**
 * Created by Daitin on 01.12.2016.
 */
@Getter
@Setter
public abstract class AbstractDao {
    protected IDBConnector dbConnector = DBConnector.getInstance();

    protected AbstractDao() throws SQLException {
    }
}
