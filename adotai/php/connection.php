<?php
	class Connection extends PDO{
		var $host= "127.0.0.1";
		var $usuario = "root";
		var $senhadb = "";
		var $banco = "adotai";
		var $pdo;

		function __construct(){
			try {
				var_dump($this);
				$this->pdo = new PDO("mysql:host=".$this->host.";dbname=".$this->banco,$this->usuario,$this->senhadb);
			} catch(PDOException $e){
				throw new PDOException($e);
			}
		}

	}

?>