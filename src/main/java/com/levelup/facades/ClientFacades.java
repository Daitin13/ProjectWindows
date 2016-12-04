package com.levelup.facades;

import com.levelup.dto.Client;

import java.util.List;
import java.util.Map;

public interface ClientFacades {

    List<Client> getClients();

    Client findById(int id);

    List<Client> findByParams(Map<String, String> queryParams);

    boolean delete(Client client);

    boolean update(Client client);

    Client create(Client client) throws Exception;

}
