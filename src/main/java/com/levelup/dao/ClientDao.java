package com.levelup.dao;

import com.levelup.dto.Client;

import java.sql.SQLException;

/**
 * Created by Daitin on 01.12.2016.
 */
public interface ClientDao extends GenericDAO<Client> {
    Client findByID(int id) throws SQLException;
}
