package bddados1;

import java.sql.PreparedStatement;

import questionario.getandset.Dados1;



public class Crud1 {

		public void inserir(Dados1 dados) {
		Conexao1 conexao = new Conexao1();
		conexao.gerarConexao();

		
		PreparedStatement instrucao = null;
		String sql = "INSERT INTO dadosbd(nome,rg,cpf,fone,email,endereco,num,bairro,cidade,uf,cep) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			instrucao = conexao.connection.prepareStatement(sql);
			instrucao.setString(1, dados.getNome());
			instrucao.setString(2, dados.getRg());
			instrucao.setString(3, dados.getCpf());
			instrucao.setString(4, dados.getFone());
			instrucao.setString(5, dados.getEmail());
			instrucao.setString(6, dados.getEndereco());
			instrucao.setString(7, dados.getNum());
			instrucao.setString(8, dados.getBairro());
			instrucao.setString(9, dados.getCidade());
			instrucao.setString(10, dados.getUf());
			instrucao.setString(11, dados.getCep());
			

			

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
