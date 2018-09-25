<?php
     class Doacao extends Connection{
          var $iduser;
          var $idanimal;
          var $telefone;
          var $pdo;

          function cadDoacao(){
               $buscasegura = $this->pdo->prepare("INSERT INTO doacao(iduser,idanimal,Telefone) VALUES (:iduser,:idanimal,:telefone)");
               $buscasegura->bindValue(":iduser", $this->iduser);
               $buscasegura->bindValue(":idanimal", $this->idanimal); 
               $buscasegura->bindValue(":telefone", $this->telefone);
               $buscasegura->execute();
          }

     }




?>