/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.entidades;

import java.util.Date;

/**
 *
 * @author alana
 */
public class Atores {

    private Integer id;
    private String nome;
    private Date dataNascimento;
    private Character sexo;
    private String foto;
    private Filmes filme;

    public Atores() {
    }

    public Atores(Integer id, String nome, Date dataNascimento, Character sexo, String foto, Filmes filme) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.foto = foto;
        this.filme = filme;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Filmes getFilme() {
        return filme;
    }

    public void setFilme(Filmes filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Atores{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", foto=" + foto + ", filme=" + filme + '}';
    }

}
