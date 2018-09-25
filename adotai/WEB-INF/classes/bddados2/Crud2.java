package bddados2;

import java.sql.PreparedStatement;

import questionario.getandset.Dados2;



public class Crud2 {

		public void inserir(Dados2 dados) {
		Conexao2 conexao = new Conexao2();
		conexao.gerarConexao();
	
		
		PreparedStatement instrucao = null;
		String sql = "INSERT INTO dadosbd(nomedoador,rgcpfdoador,fonedoador,emaildoador;) VALUES (?,?,?,?)";

		try {
			instrucao = conexao.connection.prepareStatement(sql);
			instrucao.setString(1, dados.getNomedoador());
			instrucao.setString(2, dados.getRgcpfdoador());
			instrucao.setString(3, dados.getFonedoador());
			instrucao.setString(4, dados.getEmaildoador());
			instrucao.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao tentar incluir Erro: "
					+ e.getMessage());
		} finally {
			try {
				instrucao.close();
				conexao.fechar();
			} catch (Exception e) {
				System.out.println("Erro ao tentar fechar conexao Erro: "
						+ e.getMessage());
			}
		}
	
}}
