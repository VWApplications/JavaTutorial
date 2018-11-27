package br.com.vwapp.arquivos;

import java.io.*;

/**
 * Serialização são normalmente usados para armazenar objetos compostos de outros objetos,
 * o que é muito comum dentro da orientação a objeto. Ele é armazenado em formato byte code.
 *
 * Só pode ser utilizado em objetos que implementa a interface serializable.
 *
 * O que é serializado são as instâncias das variáveis do objeto, as variáveis de classe (static) não são serializadas.
 *
 * Você pode armazenar um array list completo também com o writeObject e readObject.
 *
 * Transient não armazena uma variável na serialização do objeto, por exemplo, transient private double saldo.
 * Um excelente exemplo é a senha do usuário, não é interessante deixar serializar isso.
 */
public class Serializacao {

    public static void main(String[] args) {
        String path = "src/br/com/vwapp/arquivos/IO/";

        try {
            escritaDeObjectos(path);
            leituraDeObjetos(path);
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    static void escritaDeObjectos(String path) throws Exception {
        Conta conta1 = new Conta("João", 111_222_333);
        Conta conta2 = new Conta("Pedro", 333_293_444);
        Conta conta3 = new Conta("Maria", 123_456_789);

        // .ser indica que é um objeto serializavel
        FileOutputStream fileOutputStream = new FileOutputStream(path + "objeto.ser");

        // utiliza o FileoOutputStream para realizar as operações de gravar objetos
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        // Grava o objeto serializavel no endereço especificado
        objectOutputStream.writeObject(conta1);
        objectOutputStream.writeObject(conta2);
        objectOutputStream.writeObject(conta3);

        // Fechar a conecção
        objectOutputStream.close();
    }

    static void leituraDeObjetos(String path) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(path + "objeto.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for (int i=0; i<3; i++) {
            Conta retorno = (Conta) objectInputStream.readObject();
            System.out.println(retorno.getSaldo()); // 1.11222333E8
        }

        objectInputStream.close();
    }

}
