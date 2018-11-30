package br.com.vwapp.threads.compartilhado;

/**
 * Queremos que o produtor execute primeiro e que cada valor produzido pelo produtor seja consumido
 * exatamente uma vez pelo consumidor.
 *
 * Por exemplo quero que seja enviado várias solicitações para a impressora, mas que ela só imprima cada uma única vez.
 *
 * Queremos que nossas threads além de esperar o desbloqueio esperem também uma determinada condição para executar o método get ou set,
 * no caso de adicionar um objeto (set) nos objetos compartilhados temos que verificar se ele não ta sendo usado e no caso de ler (get)
 * temos que verificar se há objetos compartilhados.
 *
 * Nosso objeto compartilhado e sincronizada precisa avaliar se o nosso valor está ocupado ou disponível.
 * ou seja, se não tiver ocupada quer dizer que o produtor pode inserir um valor no objeto compartilhado,
 * se tiver ocupado quer dizer que o consumidor pode pegar o valor do objeto compartilhado.
 */
public class ObjetoCompartilhadoSincronizado implements ObjetoCompartilhado {

    private int valor = -1;
    private boolean ocupado = false;

    @Override
    public synchronized void set(int valor) throws InterruptedException {
        while(ocupado) {
            System.out.println("Objeto compartilhado cheio. Aguarde!");
            wait(); // faz com que a thread aguarde
        }

        System.out.print("Produziu " + valor);
        this.valor = valor;

        ocupado = true;

        // indicar para todas as threads que estão aguardando para continuar sua execução,
        // já que o status de ocupado mudou.
        notifyAll();
    }

    @Override
    public synchronized int get() throws InterruptedException {
        while(!ocupado) {
            System.out.println("Objeto compartilhado vazio. Aguarde!");
            wait(); // faz com que a thread aguarde
        }

        System.err.print("Consumiu " + valor);

        ocupado = false;
        notifyAll();

        return this.valor;
    }
}
