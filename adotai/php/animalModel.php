<?php
     class Animal extends Connection{
          var $raca;
          var $idade;
          var $peso;
          var $idusuario;
          var $idanimal;
          var $telefone;
          var $pdo;

          function cadAnimal(){
               $buscasegura = $this->pdo->prepare("INSERT INTO animal (Raca,Idade,Peso) VALUES (:raca,:idade,:peso)");
               $buscasegura->bindValue(":raca", $this->raca);
               $buscasegura->bindValue(":idade", $this->idade); 
               $buscasegura->bindValue(":peso", $this->peso);
               $buscasegura->execute();
               
          }

     }




?>