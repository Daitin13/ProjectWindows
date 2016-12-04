package com.levelup.services.impl;

import com.levelup.dao.ClientDao;
import com.levelup.dao.impl.ClientDaoImpl;
import com.levelup.dto.Client;
import com.levelup.services.ClientService;

import java.sql.SQLException;

/**
 * Created by Daitin on 01.12.2016.
 */
public class ClientServiceImpl implements ClientService{
    ClientDao clientsDao;

    public ClientServiceImpl() throws SQLException{
        clientsDao = new ClientDaoImpl();
    }

    @Override
    public Client create(Client client) throws Exception {
        Client resClient=clientsDao.create(client);
        return resClient;
    }
}
