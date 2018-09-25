<?php
	include("connection.php");
	include("animalModel.php");
	include("doacaoModel.php");
	$animal = new Animal();
	$doacao = new Doacao();
	$pag = isset($_GET['pag']) ? $_GET['pag'] : NULL;
	switch ($pag) {
		case "cadAnimal": 
			session_start();
			echo $_SESSION['idusuariologado'];
			$animal->raca=isset($_POST['racaanimal']) ? $_POST['racaanimal'] : NULL;
			$animal->idade=isset($_POST['idadeanimal']) ? $_POST['idadeanimal'] : NULL;
			$animal->peso=isset($_POST['pesoanimal']) ? $_POST['pesoanimal'] : NULL;
			$animal->cadAnimal();
			
			$link = mysqli_connect("127.0.0.1", "root", "", "adotai");
			$sql="SELECT IDanimal FROM animal ORDER BY IDanimal ASC";
			$result= mysqli_query($link,$sql);
			while($escrever=mysqli_fetch_array($result)){
			   $cdanimal=$escrever;
			}
			$idanimal=implode('|',$cdanimal);
			$idusuariologado=$_SESSION['idusuariologado'];
			$doacao->iduser=$idusuariologado;
			$doacao->idanimal=$idanimal;
			$doacao->telefone=isset($_POST['telefonedoacao']) ? $_POST['telefonedoacao'] : NULL;
			$doacao->cadDoacao();
		break;
		default:
		break;
	}

?>