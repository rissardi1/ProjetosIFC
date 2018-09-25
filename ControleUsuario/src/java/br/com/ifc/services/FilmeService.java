/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.services;

import br.com.ifc.entidades.Filmes;
import java.util.List;

/**
 *
 * @author fabricio
 */
public interface FilmeService {

    public List<Filmes> listar() throws Exception;
    public boolean salvar(Filmes filme) throws Exception;
    public boolean atualizar(Filmes filme) throws Exception;
    public boolean excluir(Integer id) throws Exception;
    public Filmes getById(Integer id) throws Exception;
}
