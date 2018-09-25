/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Ponto;



public interface PontoDao {

    public void inserir(Ponto objeto) throws Exception;

    public void remover(Integer objeto) throws Exception;

    public void atualizar(Ponto objeto) throws Exception;

    public Ponto buscarPorId(Integer id) throws Exception;

    public java.util.List<Ponto> buscarTodos() throws Exception;
}
