package questionario.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bddados1.Crud1;
import questionario.getandset.Dados1;

@WebServlet("/arquivos")
public class pegaarquivos1 extends HttpServlet {
	Dados1 d = new Dados1();
	Crud1 c = new Crud1();
	
	String nome, rg, cpf, fone, email, endereco,num,bairro,cidade,uf,cep;

	protected void doPost(HttpServletRequest requisicao,
			HttpServletResponse resposta) throws ServletException, IOException {

		resposta.setCharacterEncoding("utf-8");
		 nome 	=	requisicao.getParameter("nome");
		 rg 		=   requisicao.getParameter("rg");
		 cpf 		=   requisicao.getParameter("cpf"); 
		 fone 	=   requisicao.getParameter("fone"); 
		 email 	=   requisicao.getParameter("email");
		 endereco =   requisicao.getParameter("endereco");
		 num     	=   requisicao.getParameter("num"); 
		 bairro	=   requisicao.getParameter("bairro"); 
		 cidade 	=   requisicao.getParameter("cidade"); 
		 uf =   requisicao.getParameter("uf"); 
		 cep =   requisicao.getParameter("cep");

		 d.setNome(nome);
		 d.setRg(rg);
		 d.setCpf(cpf);
		 d.setFone(fone);
		 d.setEmail(email);
		 d.setEndereco(endereco);
		 d.setNum(num);
		 d.setBairro(bairro);
		 d.setCidade(cidade);
		 d.setUf(uf);
		 d.setCep(cep);
		 System.out.println("oiii");
		
		  c.inserir(d);
	
			resposta.sendRedirect("folder.html");
		}
		

	}

