package br.com.vwapp.threads;

import br.com.vwapp.threads.compartilhado.*;

/**
 * Em tese quando um produtor colocar um produto ele tem que ser consumida pelo consumidor, ou seja,
 * no final o total dos dois tem que ser igual
 */
public class ObjetoCompartilhadoTeste {

    public static void main(String[] args) {

       // naoSincronizado();
       sincronizado();

    }

    static void sincronizado() {
        ObjetoCompartilhado objetoCompartilhado = new ObjetoCompartilhadoSincronizado();

        new Thread(new Produtora(objetoCompartilhado)).start();
        new Thread(new Consumidora(objetoCompartilhado)).start();
    }

    static void naoSincronizado() {
        ObjetoCompartilhado objetoCompartilhado = new ObjetoCompartilhadoNaoSincronizado();

        new Thread(new Produtora(objetoCompartilhado)).start();
        new Thread(new Consumidora(objetoCompartilhado)).start();
    }

}
