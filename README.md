# avaliacao
Avaliação Liax
Fazer Request do tipo get No Postman através da seguinte 
url http://localhost:8080/arquivo 
com o seguinte corpo: 
{
    "caminho":"pasta que deseja ir e gravar",
    "profundidade": numeroqualquer
    
}

Para gravar no banco de dados

Executar o seguinte script no seu SGBD: 

CREATE DATABASE AVALIACAO;

CREATE TABLE TAB_HIERARQUIA(

codigo int (1) AUTO_INCREMENT,
nome varchar (30) not null,
profundidade int (3),
tipo varchar (10),
PRIMARY KEY (codigo) 
);

SELECT * FROM TAB_HIERARQUIA;

Configurar seu usuario e senha para conectar com o banco de dados.


