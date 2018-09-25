create table usuarios(IDusuario int PRIMARY KEY AUTO_INCREMENT, Usuario text, Senha text, Email text, DataNasc text, Permissao int);
create table animal(IDanimal int PRIMARY KEY AUTO_INCREMENT, Raca text, Idade int, Peso float);
create table doacao(IDdoacao int PRIMARY KEY AUTO_INCREMENT, iduser int, idanimal int, Telefone text,
                   FOREIGN KEY(iduser) references usuarios(IDusuario),
                   FOREIGN KEY(idanimal) references animal(IDanimal));
