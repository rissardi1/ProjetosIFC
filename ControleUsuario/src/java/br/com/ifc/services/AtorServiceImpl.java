/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.services;

import br.com.ifc.entidades.Atores;
import br.com.ifc.utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author fabricio
 */
public class AtorServiceImpl implements AtorService {

    private FilmeService filmeService;

    public AtorServiceImpl() {
        filmeService = new FilmeServiceImpl();
    }

    @Override
    public List<Atores> listar() throws Exception {
        PreparedStatement ps
                = Conexao.getConnection().prepareStatement(
                        "select * from atores"
                );
        ResultSet rs = ps.executeQuery();

        List<Atores> atores = new ArrayList<>();
        while (rs.next()) {
            Atores ator = new Atores();
            ator.setSexo(rs.getString("sexo").charAt(0));
            ator.setId(rs.getInt("id"));
            ator.setNome(rs.getString("nome"));
            ator.setFoto(rs.getString("foto"));
            ator.setDataNascimento(rs.getDate("data_nascimento"));
            ator.setFilme( filmeService.getById(rs.getInt("filme_id")));
            atores.add(ator);//Adiciona na lista
        }
        return atores;
    }

    @Override
    public boolean salvar(Atores ator) throws Exception {
        String sql = "insert into atores (nome, data_nascimento, sexo, foto, filme_id) values (?,?,?,?, ?)";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, ator.getNome());
            ps.setDate(i++, new java.sql.Date(ator.getDataNascimento().getTime()), Calendar.getInstance(Locale.PRC));
            ps.setString(i++, ator.getSexo().toString());
            ps.setString(i++, ator.getFoto());
            ps.setInt(i++, ator.getId());
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

    @Override
    public Atores getById(Integer id) throws Exception {
        PreparedStatement ps
                = Conexao.getConnection().prepareStatement(
                        "select * from atores where id = ?"
                );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Atores ator = new Atores();
            ator.setSexo(rs.getString("sexo").charAt(0));
            ator.setId(rs.getInt("id"));
            ator.setNome(rs.getString("nome"));
            ator.setFoto(rs.getString("foto"));
            ator.setDataNascimento(rs.getDate("data_nascimento"));
            ator.setFilme(filmeService.getById(rs.getInt("filme_id")));
            return ator;
        }
        return null;
    }

    @Override
    public boolean atualizar(Atores ator) throws Exception {
        String sql = "update atores set nome = ?, sexo = ?, foto = ?, data_nascimento = ?, filme_id = ? where id = ?";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, ator.getNome());
            ps.setString(i++, ator.getSexo().toString());
            ps.setString(i++, ator.getFoto());
            ps.setDate(i++, new java.sql.Date(ator.getDataNascimento().getTime()), Calendar.getInstance(Locale.PRC));
            ps.setInt(i++, ator.getFilme().getId());

            ps.setInt(i++, ator.getId()); //id do filme que será atualizado
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

    @Override
    public boolean excluir(Integer id) throws Exception {
        String sql = "delete from atores where id = ?";
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
