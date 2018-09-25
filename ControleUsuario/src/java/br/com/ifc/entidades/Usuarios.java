/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fabricio
 */
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String email;
    private String usuario;
    private String senha;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nome, String email, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", usuario=" + usuario + ", senha=" + senha + '}';
    }

}
