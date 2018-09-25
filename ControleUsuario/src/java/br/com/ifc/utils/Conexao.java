/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public class Conexao {

    private static Connection connection = null;
    private final static String ADRESS = "jdbc:mysql://localhost";
    private final static String DATABASE = "servlet_login_db";
    private final static String USER = "root";
    private final static String PASSWORD = "";
    private final static String PORT = "3306";
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(ADRESS + ":" + PORT + "/" + DATABASE, USER, PASSWORD);
            }
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Static method that close the connection to the database
     *
     * @return void
     *
     */
    public static void closeConnection() {
        closeConnection(null, null);
    }

    public static void closeConnection(ResultSet rs, PreparedStatement ps) {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
