<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Adotaí</title>
		
		<style>
			.news{
				float: left;
				
				background: #00BFFF;
				padding: 20px;
				box-sizing: border-box;

				-moz-box-sizing: border-box;
				-webkit-box-sizing: border-box;
				margin-bottom: 50px;
				margin: 5px;
				outline: 10px solid #00BFFF;
				border: 5px solid #fff;
			}
			header{float: left;}
			p{float: left; width: 100%;}

			.clear{clear: both;}
			.tabeladoacao{
				font-size: 30px;
				background: #00BFFF;
				border-color: white;
				border-collapse: collapse;
				text-align: center;
			}
			.tabeladoacao th{
				border: 1px solid white;
				padding: 0.5vw;
			}
			.tabeladoacao td{
				border: 1px solid white;
				padding: 0.5vw;
			}
		</style>
	</head>
	<body>
		


		<section>
			<?php
				session_start();
				$link = mysqli_connect("127.0.0.1", "root", "", "adotai");
				$codigousuariocadastro=$_SESSION['idusuariologado'];
				$sql="SELECT IDdoacao,Raca,Idade,Peso FROM animal INNER JOIN doacao ON (doacao.idanimal=animal.IDanimal) WHERE doacao.iduser=".$codigousuariocadastro;
				$result= mysqli_query($link,$sql);
				echo
				"<table class='tabeladoacao'>
					<thead>
						<tr>
							<th>Código da Adoção</th>
							<th>Raca</th>
							<th>Idade</th>
							<th>Peso</th>
						</tr>
					</thead>
					";
				while($escrever=mysqli_fetch_array($result)){
					//Escreve cada linha da tabela
					echo 
						"<tbody>
							<tr>
								<td>" .$escrever['IDdoacao']."</td>
								<td>" .$escrever['Raca']."</td>
								<td>" .$escrever['Idade']  ."</td>
								<td>" .$escrever['Peso'] ."</td>";	
								$verificar=$escrever['Raca'];
					echo "
							</tr>
						</tbody>";			
														
					}
					if(empty($verificar)){
						echo "<tr><td colspan='6'>Nenhum Cadastro</td></tr>";
					}
				echo "</table>";
				
			?>
		</section>



	
	</body>
</html>
