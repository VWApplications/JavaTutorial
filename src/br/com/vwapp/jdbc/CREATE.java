package br.com.vwapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Banco de dados é um conjunto de dados relacionados e organizados.
 * Programas criados para criar e gerenciar banco de dados são chamados de Sistemas de Gerenciamento de Banco de Dados
 * ou SGBD. Ex: MySQL, PostgreSQL, SQLServer, Oracle, ...
 * SQL é a linguagem para manipular (CRUD) as informações do banco de dados relacional.
 * Um banco de dados relacional armazena os dados em tabelas, essas tabelas são compostas de linhas e as linhas de
 * colunas que é onde a gente armazena os nossos valores.
 *
 * Programas java eles se comunicam e manipulam dados de um banco de dados por meio de um driver JDBC.
 * JDBC é Java DataBase Connectivity - Biblioteca java para se conectar com o banco de dados.
 *
 * Para que funcione você precisa baixar o driver .JAR do seu banco de dados, no caso postgresql.
 *
 * O que varia de um banco para o outro é a url de conexão e o drive.jar
 *
 * DB2         jdbc:db2:host:porta/banco
 * Oracle      jdbc:oracle:thin:@host:porta:banco
 * PostgreSQL  jdbc:postgresql://host:porta/banco
 * SQL Server  jdbc:sqlserver://host:porta;databaseName=banco
 * MySQL       jdbc:mysql://host:porta/banco
 */
public class CREATE {

    public static void main(String[] args) throws Exception {

        // URL de conexão é jdbc:nomedobanco://host:porta/database
        String url = "jdbc:postgresql://localhost:5432/jdbc";

        // Fazer a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(url, "postgres", "postgres");

        // Comando de execução no banco de dados
        String sql = "CREATE TABLE PESSOA (codigo int not null, nome varchar(15), sexo char(1), email varchar(30), primary key(codigo))";

        // Encaminhar requisições para o servidor
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // CUD (executeUpdate) - Create, Update and Delete
        preparedStatement.executeUpdate();

        // Fechar conexão
        preparedStatement.close();
        connection.close();

    }

}
