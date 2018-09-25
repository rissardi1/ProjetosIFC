/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.controller;

import ifc.dao.PontoDaoImpl;
import ifc.model.Ponto;
import ifc.utils.MensagemUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import ifc.dao.PontoDao;

@ManagedBean
@ViewScoped
public class PontoBean implements Serializable {

    private Ponto ponto;
    private List<Ponto> pontos;
    private final PontoDao dao;

    @ManagedProperty("#{msg['mensagem.salvar']}")
    private String mensagemSalvar;
    @ManagedProperty("#{msg['mensagem.excluir']}")
    private String mensagemExcluir;
    @ManagedProperty("#{msg['mensagem.prepararAlterar']}")
    private String mensagemPrepararAlterar;

    public PontoBean() {
        ponto = new Ponto();
        dao = new PontoDaoImpl();
    }

    @PostConstruct
    public void init() {
        try {
            buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void prepararAlterar() throws Exception {
        try {
            this.ponto = dao.buscarPorId(ponto.getId());
            MensagemUtils.adicionarMensagemDeSucesso(mensagemPrepararAlterar);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void buscarTodos() throws Exception {
        try {
            pontos = dao.buscarTodos();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }

    }

    public void salvar() throws Exception {
        try {
            if (ponto.getId() == null) {
                dao.inserir(ponto);
            } else {
                dao.atualizar(ponto);
            }
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso(mensagemSalvar);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void remover() throws Exception {
        try {
            dao.remover(ponto.getId());
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso(mensagemExcluir);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Ponto buscarPorId(Integer id) throws Exception {
        try {
            return dao.buscarPorId(id);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void limparCampos() {
        try {
            this.ponto = new Ponto();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public String getMensagemSalvar() {
        return mensagemSalvar;
    }

    public void setMensagemSalvar(String mensagemSalvar) {
        this.mensagemSalvar = mensagemSalvar;
    }

    public String getMensagemExcluir() {
        return mensagemExcluir;
    }

    public void setMensagemExcluir(String mensagemExcluir) {
        this.mensagemExcluir = mensagemExcluir;
    }

    public String getMensagemPrepararAlterar() {
        return mensagemPrepararAlterar;
    }

    public void setMensagemPrepararAlterar(String mensagemPrepararAlterar) {
        this.mensagemPrepararAlterar = mensagemPrepararAlterar;
    }

}
