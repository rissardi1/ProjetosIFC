/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.services;

import br.com.ifc.entidades.Filmes;
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
public class FilmeServiceImpl implements FilmeService {

    @Override
    public List<Filmes> listar() throws Exception {
        PreparedStatement ps
                = Conexao.getConnection().prepareStatement(
                        "select * from filmes"
                );
        ResultSet rs = ps.executeQuery();

        List<Filmes> usuarios = new ArrayList<>();
        while (rs.next()) {
            Filmes filme = new Filmes();
            filme.setGenero(rs.getString("genero"));
            filme.setId(rs.getInt("id"));
            filme.setNome(rs.getString("nome"));
            filme.setImagem(rs.getString("imagem"));
            usuarios.add(filme);//Adiciona na lista
        }
        return usuarios;
    }

    @Override
    public boolean salvar(Filmes usuario) throws Exception {
        String sql = "insert into filmes (nome, genero, imagem) values (?,?,?)";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, usuario.getNome());
            ps.setString(i++, usuario.getGenero());
            ps.setString(i++, usuario.getImagem());
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

    @Override
    public Filmes getById(Integer id) throws Exception {
        PreparedStatement ps
                = Conexao.getConnection().prepareStatement(
                        "select * from filmes where id = ?"
                );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Filmes filme = new Filmes();
            filme.setGenero(rs.getString("genero"));
            filme.setId(rs.getInt("id"));
            filme.setNome(rs.getString("nome"));
            filme.setImagem(rs.getString("imagem"));
            return filme;
        }
        return null;
    }

    @Override
    public boolean atualizar(Filmes usuario) throws Exception {
        String sql = "update filmes set nome = ?, genero = ?, imagem = ? where id = ?";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, usuario.getNome());
            ps.setString(i++, usuario.getGenero());
            ps.setString(i++, usuario.getImagem());
            
            ps.setInt(i++, usuario.getId()); //id do filme que será atualizado
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }
    
    @Override
    public boolean excluir(Integer id) throws Exception {
        String sql = "delete from filmes where id = ?";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setInt(i++, id); //id do filme que será excluido
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

}
