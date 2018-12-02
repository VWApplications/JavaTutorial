package br.com.vwapp.redes;

import java.io.*;
import java.net.Socket;

public class ChatCliente implements Runnable {

    Socket cliente;
    DataOutputStream escritor;
    DataInputStream leitor;
    BufferedReader entrada;
    String txt;
    Thread thread;

    ChatCliente() {
        try {
            cliente = new Socket("127.0.0.1", 3001);
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
        new ChatCliente();
    }

}
