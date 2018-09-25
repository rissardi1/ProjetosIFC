package questionario.web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bddados2.Crud2;
import questionario.getandset.Dados2;

@WebServlet("/arquivos1")
public class pegaarquivos2 extends HttpServlet {
	Dados2 d = new Dados2();
	Crud2 c = new Crud2();
	
 String nomedoador,rgcpfdoador,fonedoador,emaildoador;
	protected void doPost(HttpServletRequest requisicao,
			HttpServletResponse resposta) throws ServletException, IOException {

		resposta.setCharacterEncoding("utf-8");
		nomedoador  =	requisicao.getParameter("nomedoador");
		rgcpfdoador =	requisicao.getParameter("rgcpfdoador");
		fonedoador  =	requisicao.getParameter("fonedoador");
		emaildoador =	requisicao.getParameter("emaildoador");

		
		d.setNomedoador(nomedoador);
		d.setRgcpfdoador(rgcpfdoador);
		d.setFonedoador(fonedoador);
		d.setEmaildoador(emaildoador);
		
		 System.out.println("oiii2");
	     c.inserir(d);
	
			resposta.sendRedirect("folder.html");
		}
		

}
