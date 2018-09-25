/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import br.com.ifc.entidades.Usuarios;
import br.com.ifc.services.UsuarioService;
import br.com.ifc.services.UsuarioServiceImpl;
import br.com.ifc.utils.Criptografia;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Registrar", urlPatterns = "/Registrar")
public class RegistrarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String REGISTRAR = "/registrar.jsp";
    private static String EFETUAR_LOGIN = "/login.jsp";
    private UsuarioService service;

    public RegistrarServlet() {
        super();
        service = new UsuarioServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = "";
            String action = request.getParameter("acao");

            if (action.equalsIgnoreCase("registrar")) {
                forward = REGISTRAR;
            } else if (action.equalsIgnoreCase("login")) {
                forward = EFETUAR_LOGIN;
            } else {
                forward = REGISTRAR;
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            Usuarios usuario = new Usuarios();
            usuario.setNome(request.getParameter("nome"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setUsuario(request.getParameter("usuario"));
            
            usuario.setSenha(Criptografia.criptografar(request.getParameter("senha")));
            
            if (!request.getParameter("senha").equals(request.getParameter("confirmacao"))) {
                throw new Exception("Os dois campos de senha devem ter o mesmo valor!");            
            }
            
            if (service.getByUsuario(usuario.getUsuario()) !=null) {
                throw new Exception("Usuario " + usuario.getUsuario() + " já existe!");
            }
            
            service.salvar(usuario);
            
            RequestDispatcher view = request.getRequestDispatcher(EFETUAR_LOGIN);
            request.getSession().setAttribute("mensagens", "Usuário registrado com sucesso!");
            view.forward(request, response);
        } catch (Exception ex) {
            RequestDispatcher view = request.getRequestDispatcher(REGISTRAR);
            request.getSession().setAttribute("mensagens", ex.getMessage());
            view.forward(request, response);
        } finally {
            request.getSession().removeAttribute("mensagens");
        }
    }

}
