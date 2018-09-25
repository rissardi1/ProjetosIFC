/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Ponto;
import ifc.utils.ConnectionProvider;
import ifc.utils.Transacao;
import ifc.utils.TransacaoJdbcImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class PontoDaoImpl implements PontoDao {

    @Override
    public void inserir(Ponto objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into Ponto (nome, pais, cidade) values (?, ?, ?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setString(2, objeto.getPais());
            statement.setString(3, objeto.getCidade());
            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public void remover(Integer objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "delete from Ponto where id = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, objeto);

            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public void atualizar(Ponto objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update Ponto set nome = ?"
                    + "where id = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setLong(2, objeto.getId());
            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public Ponto buscarPorId(Integer id) throws Exception {
        Ponto ponto = new Ponto();
        try {
            String query = "select * from Ponto where id = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ponto = new Ponto();
                ponto.setId(resultSet.getInt("id"));
                ponto.setNome(resultSet.getString("nome"));
                ponto.setPais(resultSet.getString("pais"));
                ponto.setCidade(resultSet.getString("cidade"));
                
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return ponto;
    }

    @Override
    public List<Ponto> buscarTodos() throws Exception {
        List<Ponto> lista = new LinkedList<>();
        Ponto ponto = new Ponto();
        try {
            String query = "select * from Ponto";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ponto = new Ponto();
                ponto.setId(resultSet.getInt("id"));
                ponto.setNome(resultSet.getString("nome"));
                ponto.setPais(resultSet.getString("pais"));
                ponto.setCidade(resultSet.getString("cidade"));
                
                lista.add(ponto);
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return lista;
    }

}
