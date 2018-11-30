package br.com.vwapp.threads;

/**
 * Normalmente criamos programas que executam 1 passo de cada vez em sequência
 * Essa sequência de passos executadas uma de cada vez é chamada de threads.
 *
 * Todos programa roda sobre uma thread.
 *
 * Na vida real várias atividades são feitas ao mesmo tempo, ou seja, em paralelo.
 * Programas que utilizam várias Threads são chamados de multi threads.
 *
 * Nos gerenciamos essas várias atividades simultaneas através de objetos threads.
 * As classes Thread implementam uma interface chamada Runnable que define um objeto executável.
 * Todos os objetos executáveis tem um método run().
 *
 * Quem executa o run() é sua JVM e não seu código.
 */
public class MyRunnable implements Runnable {

    String palavra; // paravra que será impressa.
    long tempo; // tempo em milisegundos

    public MyRunnable(String palavra, long tempo) {
        this.palavra = palavra;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.palavra);

            try {
                Thread.sleep(this.tempo);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        // Inicializa os runnables
        Runnable ping = new MyRunnable("Ping", 1500);
        Runnable pong = new MyRunnable("Pong", 2000);

        // Cria e executa as threads
        new Thread(ping, "Ping").start();
        new Thread(pong, "Pong").start();

        // Ambas são impressas 5 vezes em paralelo o Ping em cada 1.5 segundos e o pongo em cada 2 segundos

    }

}
