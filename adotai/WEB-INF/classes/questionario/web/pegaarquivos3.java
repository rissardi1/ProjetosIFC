package questionario.web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bddados3.Crud3;
import questionario.getandset.Dados3;

@WebServlet("/arquivos1")
public class pegaarquivos3 extends HttpServlet {
		Dados3 d = new Dados3();
		Crud3 c = new Crud3();
		
	 String nomeanimal,idadeanimal,pelagem,cor,sexo,porte,outra[];
  String msg1;
		protected void doPost(HttpServletRequest requisicao,
				HttpServletResponse resposta) throws ServletException, IOException {
			
			resposta.setCharacterEncoding("utf-8");
			nomeanimal  =	requisicao.getParameter("nomeanimal");
			idadeanimal =	requisicao.getParameter("idadeanimal");
			pelagem  =	requisicao.getParameter("pelagem");
			cor =	requisicao.getParameter("cor");
			sexo =	requisicao.getParameter("sexo");
			porte =	requisicao.getParameter("porte");
			outra =	requisicao.getParameterValues("outra");

			for (int i = 0; i < outra.length; i++) {

				System.out.print(outra[i] + ", ");
				msg1 = outra[i] + msg1 + " ";
			}
			
			d.setNomeanimal(nomeanimal);
			d.setIdadeanimal(idadeanimal);
			d.setPelagem(pelagem);
			d.setCor(cor);
			d.setSexo(sexo);
			d.setPorte(porte);
			d.setOutra(msg1);
		
			 
			
			  c.inserir(d);
			  
			  System.out.println("oiii3");
				resposta.sendRedirect("folder.html");
			}
			
}