package com.levelup.dao.impl;

import com.levelup.dao.AbstractDao;
import com.levelup.dao.ClientDao;
import com.levelup.dao.DBConnector;
import com.levelup.dto.Client;
import com.levelup.services.impl.ClientServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daitin on 01.12.2016.
 */
public class ClientDaoImpl extends AbstractDao implements ClientDao {

    public ClientDaoImpl() throws SQLException {

    }

    @Override
    public Client findByID(int id) throws SQLException {
        Client client = new Client();
        try (Connection connection = DBConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Clients WHERE id_client=?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            client.setIdClient(rs.getInt("id_client"));
            client.setFirstName(rs.getString("first_name"));
            client.setLastName(rs.getString("last_name"));
            client.setPhoneNumber(rs.getString("phone_number"));
        }
        return client;
    }

    @Override
    public boolean remove(Client obj) throws SQLException {
        try (Connection connection = DBConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Clients WHERE id_client=?")) {
            preparedStatement.setInt(1, obj.getIdClient());
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            obj.setIdClient(rs.getInt("id_client"));
            obj.setFirstName(rs.getString("first_name"));
            obj.setLastName(rs.getString("last_name"));
            obj.setPhoneNumber(rs.getString("phone_number"));
            if (preparedStatement.executeUpdate() > 0)
                return true;
            return false;
        }
    }

    @Override
    public boolean update(Client obj) throws SQLException {
        try (Connection connection = DBConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE clients SET " +
                     "first_name = ?, last_name = ?, phone_number = ?" +
                     "WHERE id_client =?")) {
            preparedStatement.setString(1, obj.getFirstName());
            preparedStatement.setString(2, obj.getLastName());
            preparedStatement.setString(3, obj.getPhoneNumber());
            preparedStatement.setInt(4, obj.getIdClient());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("update success");
                return true;
            }
        }
        return false;
    }

    @Override
    public Client create(Client obj) throws Exception {
        try (Connection connection = DBConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into clients " +
                     "values(?,?,?,?)")) {
            preparedStatement.setInt(1, obj.getIdClient());
            preparedStatement.setString(2, obj.getFirstName());
            preparedStatement.setString(3, obj.getLastName());
            preparedStatement.setString(4, obj.getPhoneNumber());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Add success");
                return obj;
            }
            throw new Exception();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Client> get() throws SQLException {
        List<Client> clientsList = new ArrayList<>();
        try (Connection connection = DBConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Clients");
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Client client = new Client();
                //client.setPhoneNumber("55");
                client.setIdClient(rs.getInt("id_client"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setPhoneNumber(rs.getString("phone_number"));
                clientsList.add(client);
            }
        }
        return clientsList;
    }

    public static void main(String[] args) throws Exception {
        ClientDaoImpl client = new ClientDaoImpl();
        //client.create(new Client("Artur","Ser","050505"));


        System.out.println(client.get());

    }
}
