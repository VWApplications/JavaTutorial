package br.com.vwapp.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD - create, read, update e delete
 *
 * Transação entende que um conjunto de operações no banco de dados deve ser tratada como se fosse uma única operação
 * e se uma dessas operações falhar então todas as outras vão ser desfeitas e a transação deve ser revertida.
 * Porém se todas as operações forem bem sucedidas, então a transação tem que ser confirmada.
 *
 * Para iniciar uma transação nos precisamos definir que a nossa conexão não será autocommitada, ou seja,
 * a nossa conexão começa a tratar as operações em conjunto. A confirmação é usada com o método commit(),
 * porém se algum problema ocorrer quero cancelar a transação e voltar ao estado anterior (rollback).
 */
public class ContaCRUD {

    // Transação
    private void transferir(Connection connection, Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {

            try {
                connection.setAutoCommit(false);

                origem.saca(valor);
                this.atualizaConta(connection, origem);

                // int x = 1/0;

                destino.deposita(valor);
                this.atualizaConta(connection, destino);

                connection.commit();
            } catch (Exception e) {
                try { connection.rollback(); } catch (SQLException error) { error.printStackTrace(); }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        // URL de conexão é jdbc:nomedobanco://host:porta/database
        String url = "jdbc:postgresql://localhost:5432/jdbc";

        // Fazer a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(url, "postgres", "postgres");

        ContaCRUD crud = new ContaCRUD();

        if (!crud.tabelaExiste(connection, "conta")) {
            crud.criarTabela(connection);
        }

        crud.deletarContas(connection);

        Conta conta1 = new Conta(1, "Pedro", 100_302.30);
        if (!crud.contaExiste(connection, 1)) {
            crud.criarConta(connection, conta1);
        }
        conta1.setCliente("Victor");
        crud.atualizaConta(connection, conta1);

        for (int i = 2; i <= 5; i++) {
            if (!crud.contaExiste(connection, i)) {
                Conta conta = new Conta(i, "Fulano" + i, 100_000 + i);
                crud.criarConta(connection, conta);
            }
        }

        List<Conta> contas = crud.pegarContas(connection);
        for (Conta conta: contas) {
            System.out.println(conta.getId() + ": " + conta.getCliente() + " " + conta.getSaldo());
        }


        crud.deletarConta(connection, conta1.getId());

        contas = crud.pegarContas(connection);
        for (Conta conta: contas) {
            System.out.println(conta.getId() + ": " + conta.getCliente() + " " + conta.getSaldo());
        }

        Conta origem = contas.get(0);
        System.out.println(origem);
        Conta destino = contas.get(1);
        System.out.println(destino);

        crud.transferir(connection, origem, destino, 100);
        contas = crud.pegarContas(connection);

        origem = contas.get(2);
        System.out.println(origem);
        destino = contas.get(3);
        System.out.println(destino);

        connection.close();

    }

    private boolean tabelaExiste(Connection connection, String tabela) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, null, new String[] {"TABLE"});

        while(resultSet.next()) {
            if (resultSet.getString("TABLE_NAME").equals(tabela.toLowerCase())) {
                resultSet.close();
                return true;
            }
        }

        resultSet.close();
        return false;
    }

    private boolean contaExiste(Connection connection, int contaID) throws SQLException {
        String sql = "SELECT id FROM CONTA WHERE id=" + contaID;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            resultSet.close();
            preparedStatement.close();
            return true;
        }

        resultSet.close();
        preparedStatement.close();

        return false;
    }

    private void criarTabela(Connection connection) throws SQLException {
        String sql = "CREATE TABLE CONTA (" +
            "id int not null," +
            "cliente varchar(15)," +
            "saldo float," +
            "primary key(id))";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeUpdate();

        System.out.println("Tabela criada com sucesso!");

        preparedStatement.close();
    }

    private void criarConta(Connection connection, Conta conta) throws SQLException {
        String sql = "INSERT INTO CONTA VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, conta.getId());
        preparedStatement.setString(2, conta.getCliente());
        preparedStatement.setDouble(3, conta.getSaldo());
        preparedStatement.executeUpdate();

        System.out.println("Conta cadastrada com sucesso!");

        preparedStatement.close();
    }

    private List<Conta> pegarContas(Connection connection) throws SQLException {
        String sql = "SELECT id, cliente, saldo FROM CONTA";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Conta> contas = new ArrayList<>();

        while(resultSet.next()) {
            contas.add(new Conta(
                resultSet.getInt("id"),
                resultSet.getString("cliente"),
                resultSet.getDouble("saldo")
            ));
        }

        System.out.println("Query realizado com sucesso!");

        resultSet.close();
        preparedStatement.close();

        return contas;
    }

    private void atualizaConta(Connection connection, Conta conta) throws SQLException {
        String sql = "UPDATE CONTA SET cliente=?, saldo=? WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, conta.getCliente());
        preparedStatement.setDouble(2, conta.getSaldo());
        preparedStatement.setInt(3, conta.getId());
        preparedStatement.executeUpdate();

        System.out.println("Conta atualizada com sucesso!");

        preparedStatement.close();
    }

    private void deletarConta(Connection connection, int contaID) throws SQLException {

        String sql = "DELETE FROM CONTA WHERE id=" + contaID;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeUpdate();

        System.out.println("Conta deletada com sucesso!");

        preparedStatement.close();
    }

    private void deletarContas(Connection connection) throws SQLException {

        String sql = "DELETE FROM CONTA";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeUpdate();

        System.out.println("Contas deletadas com sucesso!");

        preparedStatement.close();
    }

}
