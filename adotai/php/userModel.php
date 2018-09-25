<?php
 
     class Usuario extends Connection{
        
          var $login;
          var $senha;
          var $email;
          var $data;
          var $idusuariologado;
          var $pdo;
          function checkLogin(){
               $buscasegura=$this->pdo->prepare("SELECT IDusuario,Permissao FROM usuarios WHERE Usuario=:login AND Senha=:senha");
               $buscasegura->bindValue(":login", $this->login); 
               $buscasegura->bindValue(":senha", $this->senha);
               $buscasegura->execute();
               if($buscasegura->rowCount() == 1){
                    while ($linha = $buscasegura->fetch(PDO::FETCH_ASSOC)) {
                         $idusuariologado=$linha['IDusuario'];
                    }
                    $loc="../home.php";
                    header("location:$loc");
                    session_start();
                    $_SESSION['idusuariologado']=$idusuariologado;
                    
               } else {
                   header("location:../index.php");
               }
          }

          function verificarCampos(){
               if (
                    $this->login == null ||
                    $this->senha == null ||
                    $this->email == null ||
                    $this->data == null
               ) {
                    return "Informe todos os campos!";
               }
               return null;
          }

          function cadUser(){
               $buscasegura = $this->pdo->prepare("INSERT INTO usuarios (Usuario,Senha,Email,DataNasc,Permissao) VALUES (:login,:senha,:email,:data,2)");
               $buscasegura->bindValue(":login", $this->login);
               $buscasegura->bindValue(":senha", $this->senha); 
               $buscasegura->bindValue(":email", $this->email);
               $buscasegura->bindValue(":data", $this->data);
               $buscasegura->execute();
          }

     }




?>