package com.levelup.webservices;

import com.levelup.dao.ClientDao;
import com.levelup.dao.impl.ClientDaoImpl;
import com.levelup.dto.Client;
import com.levelup.facades.ClientFacades;
import com.levelup.facades.impl.ClientFacadesImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daitin on 27.11.2016.
 */
@Path("/client")
public class ClientWebController {
    private ClientDao clientDao = new ClientDaoImpl();

    private ClientFacades clientFacades = new ClientFacadesImpl();

    public ClientWebController() throws SQLException {
        System.out.println("Init person web controller");
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientByID(@PathParam("id") int id) throws SQLException {
        System.out.println("asdf");
        return clientDao.findByID(id);

    }
    @GET
    //@Path("{all}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getClient() throws SQLException {
        System.out.println("asdf");
        return clientDao.get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Client addClient(Client client) throws Exception {
        return clientFacades.create(client);
    }
}
