package br.com.vwapp.threads;

import br.com.vwapp.threads.conta.ContaConjuntaNaoSincronizada;
import br.com.vwapp.threads.conta.ContaConjuntaSincronizada;

/**
 * Você foi contratado por um banco para construir um sistema de saques em contas conjuntas,
 * ou seja, várias pessoas podem mexer na mesma conta ao mesmo tempo.
 *
 * Para que 10 pessoas não saque ao mesmo tempo de uma conta com saldo de 100 reais valores que ultrapassem esse saldo
 * precisa de alguma forma bloquear a thread que está executando o processo de saque para que só ela realize
 * o saque naquele momento e assim que ela terminar o processo de saque ela desbloqueia para que outras threads possam
 * realizar também o saque.
 *
 * Todas as threads deverão aguardar o desbloqueio da thread em execução para poder realizar sua operação.
 *
 * syncronized fará esse papel de bloqueio e desbloqueio, no exemplo está na classe ContaConjunta no método de sacar().
 */
public class Sincronizacao implements Runnable {

    ContaConjuntaSincronizada contaSincronizada = new ContaConjuntaSincronizada();
    ContaConjuntaNaoSincronizada contaNaoSincronizada = new ContaConjuntaNaoSincronizada();

    @Override
    public void run() {
        // Fazer 5 compras cada um
        for (int i = 0; i < 5; i++) {
            String cliente = Thread.currentThread().getName();
            contaSincronizada.sacar(20, cliente);

            if (contaSincronizada.getSaldo() < 0) {
                System.out.println("Estourou!!!");
            }
        }
    }

    // Compras em família
    public static void main(String[] args) {

        Sincronizacao compras = new Sincronizacao();

        new Thread(compras, "Pai").start();
        new Thread(compras, "Mãe").start();
        new Thread(compras, "Filha").start();
        new Thread(compras, "Filho").start();

    }
}
