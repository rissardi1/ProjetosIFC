<!DOCTYPE html>
<html>
	<head>	
		<meta charset="utf-8">
		<title>Adotaí</title>
		<link rel="stylesheet" type="text/css" href="styles/reset.css">
		<link rel="stylesheet" type="text/css" href="styles/style.css">
	</head>
		<body>
			<header>
		
			</header>
			<section id="container">
				<form action="php/userController.php?pag=checkLogin" method="POST">
					<fieldset>
						<legend>Faça seu Login</legend>
						<label>Usuário</label>
						<input name="input_User" type="text">
						<label>Senha</label>
						<input name="input_Pass" type="password">
						<button type="submit">Login</button>
						<button type="button" onClick="ircadastrar();">Cadastrar</button>
					</fieldset>
				</form>
			</section>
			<script type="text/javascript">
				function ircadastrar(){
					window.location.href="cadastrousuario.html";
				}
			</script>
			
	</body>
	
</html>
