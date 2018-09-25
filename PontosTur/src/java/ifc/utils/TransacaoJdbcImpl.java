/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransacaoJdbcImpl implements Transacao {

    private static TransacaoJdbcImpl instance = null;

    private Connection connection = null;

    private TransacaoJdbcImpl() {

    }

    public static TransacaoJdbcImpl getInstance() {
        if (TransacaoJdbcImpl.instance == null) {
            TransacaoJdbcImpl.instance = new TransacaoJdbcImpl();
        }
        return TransacaoJdbcImpl.instance;
    }

    @Override
    public Connection getConnection() throws Exception {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                this.connection = ConnectionProvider.getInstance().getConnection();
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return this.connection;
    }

    @Override
    public void begin() throws Exception {
        try {
            this.getConnection().setAutoCommit(false);
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
    }

    @Override
    public void commit() throws Exception {
        try {
            this.connection.commit();
        } catch (SQLException sqlCommitException) {
            throw new Exception(sqlCommitException);
        } finally {
            this.close();
        }
    }

    @Override
    public void rollback() throws Exception {
        try {
            this.connection.rollback();
        } catch (SQLException sqlRollbackException) {
            throw new Exception(sqlRollbackException);
        } finally {
            this.close();
        }
    }

    private void close() throws Exception {
        try {
            if (this.connection != null
                    && !this.connection.isClosed()) {
                ConnectionProvider.getInstance().closeConnection();
                this.connection = null;
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
    }

}
