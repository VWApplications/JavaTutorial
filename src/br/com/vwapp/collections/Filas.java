package br.com.vwapp.collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Filas de espera, é inserida sempre no final, por exemplo, fila de banco
 * FIFO - First In First Out, ou seja, o primeiro a entrar é o primeiro a sair
 */
public class Filas {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("Ricardo");
        queue.add("Maria");
        queue.add("Pedro");

        System.out.println(queue); // [Ricardo, Maria, Pedro]

        // Qual a próxima pessoa a ser atendida na fila?
        System.out.println(queue.peek()); // Ricardo
        System.out.println(queue); // [Ricardo, Maria, Pedro]

        // Remove o próximo elemento da fila.
        System.out.println(queue.poll()); // Ricardo
        System.out.println(queue); // [Maria, Pedro]


        // Metodos disponiveis em linkedlist
        LinkedList<String> fila = (LinkedList<String>) queue;
        fila.addFirst("Kaio"); // Adiciona o elemento no inicio da fila
        System.out.println(fila); // [Kaio, Maria, Pedro]
        fila.addLast("Pedro"); // Adiciona o elemento no fim da fila
        System.out.println(fila); // [Kaio, Maria, Pedro, Pedro]
        System.out.println(fila.peekFirst()); // Pega a primeira pessoa da fila (Kaio)
        System.out.println(fila.peekLast()); // Pega a ultima pessoa da fila (Pedro)
        fila.pollLast(); // Remove a ultima pessoa da fila (pedro)
        fila.pollFirst(); // Remove a primeira pessoa da fila (kaio)
        System.out.println(fila); // [Maria, Pedro]


    }

}
