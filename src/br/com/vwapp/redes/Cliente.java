package br.com.vwapp.redes;

import java.net.Socket;
import java.util.Scanner;

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
public class Cliente {

    public static void main(String[] args) throws Exception {

        // Objeto que representa uma conexão de rede (IP e PORTA)
        Socket socket = new Socket("127.0.0.1", 5000);

        // Ler a mensagem recebida do servidor
        Scanner scanner = new Scanner(socket.getInputStream());
        System.out.println("Mensagem: " + scanner.nextLine()); // Mensagem: Aprenda Java e seja contratado
        scanner.close();

    }

}
