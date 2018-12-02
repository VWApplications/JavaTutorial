package br.com.vwapp.jdbc;

import java.sql.*;

public class SELECT {

    public static void main(String[] args) throws Exception {

        // URL de conexão é jdbc:nomedobanco://host:porta/database
        String url = "jdbc:postgresql://localhost:5432/jdbc";

        // Fazer a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(url, "postgres", "postgres");

        // Comando de execução no banco de dados
        String sql = "SELECT codigo, nome, sexo, email FROM PESSOA";

        // Encaminhar requisições para o servidor
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Consulta (executeQuery)
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            System.out.println(
                resultSet.getString("codigo") + ": " +
                resultSet.getString("nome") + " " +
                resultSet.getString("sexo") + " " +
                resultSet.getString("email")
            );
        }

        // Fechar conexão
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

}
