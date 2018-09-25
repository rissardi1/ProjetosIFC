
package br.com.ifc.servlets;

import br.com.ifc.entidades.Usuarios;
import br.com.ifc.services.UsuarioService;
import br.com.ifc.services.UsuarioServiceImpl;
import br.com.ifc.utils.Criptografia;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabricio
 */
@WebServlet("/Autenticador")
public class LoginServlet extends HttpServlet {

    private UsuarioService service;

    public LoginServlet() {
        super();
        service = new UsuarioServiceImpl();
    }
    
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           HttpSession sessao = request.getSession();
           
           Usuarios usuario = null;
           String login = request.getParameter("usuario");
           String senha = request.getParameter("senha");
                   
           usuario = service.autenticar(login, Criptografia.criptografar(senha));
           
           if (usuario == null) {
               sessao.invalidate();
               request.getRequestDispatcher("login.jsp").forward(request, response);    
           } else {
               sessao.setAttribute("usuarioLogado", usuario);
               sessao.setMaxInactiveInterval(60*2);
               request.getRequestDispatcher("index.jsp").forward(request, response);
           }
       }catch (Exception e) {
           e.printStackTrace();
       }
   }

}
