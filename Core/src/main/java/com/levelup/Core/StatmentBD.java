package com.levelup.Core;

import com.levelup.Core.Hz.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daitin on 19.11.2016.
 */
public class StatmentBD {
    private static void AllKlients() throws SQLException {
        List<Client> clientsList = new ArrayList<>();
        try (Connection connection = ConnectionBD.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Clients");
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Client client = new Client();
                client.setPhoneNumber("55");
                client.setIdClient(rs.getInt("id_client"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setPhoneNumber(rs.getString("phone_number"));
                clientsList.add(client);
            }
        }
        System.out.println(clientsList.toString());
    }

    private static Client findKlientByID(int id) throws SQLException {
        Client client = new Client();
        try (Connection connection = ConnectionBD.getInstance().getConnection();
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


    private static boolean createClient(Client client) throws SQLException {
        try (Connection connection = ConnectionBD.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into clients " +
                     "values(?,?,?,?)")) {
            preparedStatement.setInt(1, client.getIdClient());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setString(4, client.getPhoneNumber());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        }
        return false;
    }


    private static boolean deleteClientByID(int id) throws SQLException {
        try (Connection connection = ConnectionBD.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from clients where id_client = " + id)) {
            if (preparedStatement.executeUpdate() > 0)
                return true;
            return false;
        }
    }


    private static boolean updateClient(Client client) throws SQLException {
        try (Connection connection = ConnectionBD.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE clients SET " +
                     "first_name = ?, last_name = ?, phone_number = ?" +
                     "WHERE id_client =?")) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setInt(4, client.getIdClient());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("update success");
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws SQLException {
        StatmentBD.updateClient(new Client(1, "Dima", "Pan","05050"));
    }
    /*

    public static int[] addPeople(List<Person> people) throws SQLException {
        Connection conn = null;
        PreparedStatement pc = null;
        try {
            conn = StatmentBD.getInstance().getConnection();
            conn.setAutoCommit(false);
            pc = conn.prepareStatement("INSERT INTO person " + "values(?,?,?,?,?)");
            for (Person person : people) {
                pc.setInt(1, person.getPersonID());
                pc.setString(2, person.getFirstName());
                pc.setString(3, person.getLastName());
                pc.setString(4, person.getAdress());
                pc.setString(5, person.getCity());
                pc.addBatch();
            }
            int[] res = pc.executeBatch();
            conn.commit();
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (pc != null && !pc.isClosed()) {
                    pc.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new int[]{};*/

    }


