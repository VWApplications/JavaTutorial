package br.com.vwapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Neste caso vamos aproveitar a mesma conexão para executar vários inserts de uma vez
 * utilizando o Batch ao inves do Update.
 *
 * Quanto menos conexões você abrir com o seu banco de dados melhor.
 */
public class BATCH {

    public static void main(String[] args) throws Exception {

        // URL de conexão é jdbc:nomedobanco://host:porta/database
        String url = "jdbc:postgresql://localhost:5432/jdbc";

        // Fazer a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(url, "postgres", "postgres");

        // Comando de execução no banco de dados
        String sql = "INSERT INTO PESSOA VALUES (?, ?, ?, ?)";
        String[] pessoas = {"Beatriz", "Juliana", "Bia", "Duda"};

        // Encaminhar requisições para o servidor
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Cada número (1, 2, 3, 4) representa (?, ?, ?, ?)
        for (int i = 0; i < pessoas.length; i++) {
            preparedStatement.setInt(1, i+2);
            preparedStatement.setString(2, pessoas[i]);
            preparedStatement.setString(3, "F");
            preparedStatement.setString(4, pessoas[i].toLowerCase() + "@gmail.com");
            preparedStatement.addBatch();
        }

        // CUD (executeUpdate) - Create, Update and Delete
        preparedStatement.executeBatch();

        // Fechar conexão
        preparedStatement.close();
        connection.close();

    }

}
