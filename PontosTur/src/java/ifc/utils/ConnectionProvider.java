/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public class ConnectionProvider {

    private static ConnectionProvider instance;
    private static Connection connection = null;

    private String url = "jdbc:mysql://localhost:3300/ponto";

    private ConnectionProvider() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, "luiz", "ifc123");
        } catch (Exception classNotFoundException) {
            throw new Exception(classNotFoundException);
        }
    }

    public static ConnectionProvider getInstance() throws Exception {
        if (instance == null) {
            instance = new ConnectionProvider();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {

        try {
            this.closeConnection();
            connection = DriverManager.getConnection(this.url, "luiz", "ifc123");
            connection.setAutoCommit(false);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
        return connection;
    }

    public void closeConnection() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    public void rollback() throws Exception {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }
}
