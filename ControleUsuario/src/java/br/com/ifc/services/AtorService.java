/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.services;

import br.com.ifc.entidades.Atores;
import br.com.ifc.entidades.Atores;
import java.util.List;

/**
 *
 * @author fabricio
 */
public interface AtorService {

    public List<Atores> listar() throws Exception;
    public boolean salvar(Atores ator) throws Exception;
    public boolean atualizar(Atores ator) throws Exception;
    public boolean excluir(Integer id) throws Exception;
    public Atores getById(Integer id) throws Exception;
}
