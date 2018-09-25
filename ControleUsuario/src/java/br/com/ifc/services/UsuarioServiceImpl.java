/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.services;

import br.com.ifc.entidades.Usuarios;
import br.com.ifc.utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public List<Usuarios> listar() throws Exception {
        String sql = "select * from usuarios order by id";
        ResultSet rs = null;
        List<Usuarios> lista = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConnection().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Usuarios u = new Usuarios(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("usuario"), rs.getString("senha"));
                lista.add(u);
            }
            return lista;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

    @Override
    public boolean salvar(Usuarios usuario) throws Exception {
        String sql = "insert into usuarios (nome, email, usuario, senha) values (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, usuario.getNome());
            ps.setString(i++, usuario.getEmail());
            ps.setString(i++, usuario.getUsuario());
            ps.setString(i++, usuario.getSenha());
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

    @Override
    public boolean atualizar(Usuarios usuario) throws Exception {
        String sql = "update usuarios set nome = ?, email = ?, usuario = ?, senha = ? where id = ?";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, usuario.getNome());
            ps.setString(i++, usuario.getEmail());
            ps.setString(i++, usuario.getUsuario());
            ps.setString(i++, usuario.getSenha());

            ps.setInt(i++, usuario.getId());
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

    @Override
    public boolean deletar(Integer id) throws Exception {
        String sql = "delete from usuarios where id=?";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setInt(i++, id);
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

    @Override
    public Usuarios getById(Integer id) throws Exception {
        Usuarios user = new Usuarios();
        try {
            PreparedStatement preparedStatement = Conexao.getConnection().
                    prepareStatement("select * from usuarios where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

//    @Override
//    public Usuarios autenticar(String usuario, String senha) throws Exception {
//        
//    }

    @Override
    public Usuarios getByUsuario(String usuario) throws Exception {
        Usuarios user = new Usuarios();
        try {
            PreparedStatement preparedStatement = Conexao.getConnection().
                    prepareStatement("select * from usuarios where usuario=?");
            preparedStatement.setString(1, usuario);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    
   
    public Usuarios autenticar(String usuario, String senha) throws Exception {
        String sql = "select * from usuarios where usuario=? and senha=?";
        ResultSet rs= null;
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.next()) {
                Usuarios u = new Usuarios(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("usuario"),
                    rs.getString("senha"));
                return u;
            }
            return null;
        } finally{
    }
}
}
