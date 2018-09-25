package bddados2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao2 {
	
	public static Connection connection;
	private final String NOMEDB = "";
	private final String URL = "";
	private final String USUARIO = "";
	private final String SENHA = "";
	
	
	
	
	public boolean gerarConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conectou!");
			return true;
		} catch(Exception e) {
			System.out.println("Ocorreu um erro!" + e.getMessage());
			return false;
		}
	}
	
	public void fechar() {
		try {
			connection.close();
			System.out.println("Fechou conexão!");
		} catch (Exception e) {
			System.out.println("Erro ao tentar fechar!" + e.getMessage());
		}
		
	}
	
}
