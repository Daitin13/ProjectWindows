package com.levelup.facades.impl;

import com.levelup.dto.Client;
import com.levelup.facades.ClientFacades;
import com.levelup.services.ClientService;
import com.levelup.services.impl.ClientServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Daitin on 01.12.2016.
 */
public class ClientFacadesImpl implements ClientFacades {
   ClientService clientService;

    public ClientFacadesImpl() throws SQLException {
        clientService = new ClientServiceImpl();
    }

    @Override
    public List<Client> getClients() {
        return null;
    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public List<Client> findByParams(Map<String, String> queryParams) {
        return null;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }

    @Override
    public boolean update(Client client) {
        return false;
    }

    @Override
    public Client create(Client client) throws Exception {
        return null;
    }
}
