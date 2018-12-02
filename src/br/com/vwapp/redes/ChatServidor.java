package br.com.vwapp.redes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServidor implements Runnable {

    ServerSocket servidor;
    Socket cliente;
    DataOutputStream escritor;
    DataInputStream leitor;
    BufferedReader entrada;
    String txt;
    Thread thread;

    ChatServidor() {
        try {
            servidor = new ServerSocket(3001);
            cliente = servidor.accept();
            escritor = new DataOutputStream(cliente.getOutputStream());
            leitor = new DataInputStream(cliente.getInputStream());
            entrada = new BufferedReader(new InputStreamReader(System.in));

            thread = new Thread(this);
            thread.start();

            while(true) {
                System.out.print("> ");
                System.out.println(leitor.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                txt = entrada.readLine();
                System.out.print("> ");
                escritor.writeUTF(txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ChatServidor();
    }
}
