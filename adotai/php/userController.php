<?php
	include("connection.php");
	include("userModel.php");
	$usuario = new Usuario();
	$pag = isset($_GET['pag']) ? $_GET['pag'] : NULL;
	switch ($pag) {
		case "cadUser": 
			$usuario->login=isset($_POST['login']) ? $_POST['login'] : NULL;
			$usuario->senha=isset($_POST['senha']) ? $_POST['senha'] : NULL;
			$usuario->email=isset($_POST['email']) ? $_POST['email'] : NULL;
			$usuario->data=isset($_POST['data']) ? $_POST['data'] : NULL;

			$validacao = $usuario->verificarCampos();
			if ($validacao == null) {
				$usuario->cadUser();
				$loc="../index.php";
				header("location:$loc");
			} else {
				echo $validacao;
			}

			break;
		
		case "checkLogin": 
			$usuario = new usuario();
			$usuario->login=isset($_POST['input_User']) ? $_POST['input_User'] : NULL;
			$usuario->senha=isset($_POST['input_Pass']) ? $_POST['input_Pass'] : NULL;
			$usuario->checkLogin();
			break;
		
		default:
			break;
	}

?>