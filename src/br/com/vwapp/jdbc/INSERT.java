package br.com.vwapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class INSERT {

    public static void main(String[] args) throws Exception {

        // URL de conexão é jdbc:nomedobanco://host:porta/database
        String url = "jdbc:postgresql://localhost:5432/jdbc";

        // Fazer a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(url, "postgres", "postgres");

        // Comando de execução no banco de dados
        String sql = "INSERT INTO PESSOA VALUES (1, 'Pedro', 'M', 'pedro@gmail.com')";

        // Encaminhar requisições para o servidor
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // CUD (executeUpdate) - Create, Update and Delete
        preparedStatement.executeUpdate();

        // Fechar conexão
        preparedStatement.close();
        connection.close();

    }

}
