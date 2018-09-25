/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import br.com.ifc.entidades.Atores;
import br.com.ifc.entidades.Filmes;
import br.com.ifc.services.AtorService;
import br.com.ifc.services.AtorServiceImpl;
import br.com.ifc.services.FilmeService;
import br.com.ifc.services.FilmeServiceImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Atores")
public class AtorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERIR_OU_EDITAR = "/restrito/ator.jsp";
    private static String LISTA_ATORES = "/restrito/atores.jsp";
    private AtorService service;
    private FilmeService filmeService;

    public AtorServlet() {
        super();
        service = new AtorServiceImpl();
        filmeService = new FilmeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = null;
            String acao = request.getParameter("acao");

            if (acao.equalsIgnoreCase("listar")) {
                request.setAttribute("atores", service.listar());
                forward = LISTA_ATORES;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            } else if (acao.equalsIgnoreCase("editar")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("ator", service.getById(id));
                request.setAttribute("filmes", filmeService.listar());
                forward = INSERIR_OU_EDITAR;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            } else if (acao.equalsIgnoreCase("excluir")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                service.excluir(id);
                request.setAttribute("atores", service.listar());
                response.sendRedirect("Atores?acao=listar");
            } else {
                request.setAttribute("filmes", filmeService.listar());
                forward = INSERIR_OU_EDITAR;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensagens", ex.getMessage());
            request.getRequestDispatcher(INSERIR_OU_EDITAR).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");

            Atores ator = new Atores();
            if (!request.getParameter("id").equals("")) {
                ator.setId(Integer.parseInt(request.getParameter("id")));
            }
            ator.setNome(request.getParameter("nome"));
            ator.setFoto(request.getParameter("foto"));
            ator.setSexo(request.getParameter("sexo").charAt(0));

            ator.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_nascimento")));
            
            ator.setFilme(filmeService.getById(Integer.parseInt(request.getParameter("filme_id"))));

            System.out.println(ator.toString());

            if (ator.getId() == null) {
                service.salvar(ator);
            } else {
                service.atualizar(ator);
            }

            response.sendRedirect("Atores?acao=listar");

        } catch (Exception ex) {
            ex.printStackTrace();
//            response.sendRedirect(request.getHeader("Referer"));
            request.setAttribute("mensagens", ex.getMessage());
            request.getRequestDispatcher(INSERIR_OU_EDITAR).forward(request, response);
        }
    }

}
