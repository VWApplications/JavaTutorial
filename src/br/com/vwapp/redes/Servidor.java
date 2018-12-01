package br.com.vwapp.redes;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Seu programa java pode se conectar com programas de outras máquinas que estão rodando na rede ou na internet.
 * É um relacionamento cliente-servidor.
 *
 * Para se conectar na rede precisamos saber de 3 coisas:
 *  1. Como se conectar a um servidor rodando em outra máquina.
 *  2. Como enviar mensagens para esse servidor
 *  3. Como receber mensagens desse servidor.
 *
 * Para se conectar a outra máquina precisamos de uma conexão via Socket.
 * Um Socket é um objeto que representa uma conexão de rede entre 2 máquinas
 * Uma conexão é um relacionamento entre essas duas máquinas, onde os 2 sabem da existência um do outro e como
 * se conectar entre si.
 *
 * Para criar uma conexão via Socket você precisa saber 2 coisas sobre o servidor: A porta e o IP da máquina.
 *
 * Portas de 0 a 1023 não devem ser usadas, pois já são reservadas para alguns serviços
 */
public class Servidor {

    public static void main(String[] args) throws Exception {

        // Objeto que representa nosso servidor, passando sua porta
        ServerSocket server = new ServerSocket(5000);

        while(true) {
            // Espera uma resposta/socket do cliente e o armazena
            Socket socket =  server.accept();

            // Escrever uma resposta para o cliente
            try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
                writer.println("Aprenda Java e seja contratado!");
            }
        }
    }

}
