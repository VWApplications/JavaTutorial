package br.com.vwapp.threads.compartilhado;

/**
 * Se tivermos threads que executam N métodos, ao finalizar um método deveriamos começar esse mesmo método em
 * outra thread ao inves de esperar a primeira thread finalizar todos o processo.
 *
 * Imagine que você tenha um conjunto de threads que executam vários métodos onde para executar um método, outro
 * método totalmente diferente precisa ser bloqueado. Aqui temos um nível de sincronização bem mais complexo que
 * aparece nos relacionamentos entre classes produtoras (escreve dados na ponte) e consumidoras (lê dados da ponte).
 *
 * Neste tipo de relacionamento as classes produtoras armazenam dados em uma ponte (objeto compartilhado) que é
 * compartilhado com as classes consumidoras, a classe consumidora lê esses dados do objeto compartilhado e os
 * processa.
 */
public interface ObjetoCompartilhado {

    public void set(int valor) throws InterruptedException;

    public int get() throws InterruptedException;
}
