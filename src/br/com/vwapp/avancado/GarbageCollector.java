package br.com.vwapp.avancado;

import java.util.ArrayList;
import java.util.List;

/**
 * Garbage Collector é o coletor de lixos do java.
 *
 * Objetos são criados com a palavra chave (new) mas não existe nenhuma operação de delete para apaga-los da memória
 * quando voce termina de usar um objeto, vc simplesmente para de acessa-lo ou atribui null a esse objeto.
 *
 * Neste momento o coletor de lixo ou GC realiza a limpeza dos seus dados e essa é dividido em 2 partes, a primeira
 * separa os objetos vivos dos mortos e depois limpa a memória usada pelos objetos mortos. Os objetos vivos são
 * aqueles alcançaveis por um código de execução, os mortos são o lixo a ser coletado.
 *
 * Métodos da classe (Runtime) para iteragir com o garbage collector:
 *
 * - gc(): Solicita a máquina virtual para se esforçar na reciclagem de objetos que não estão sendo mais usados
 * de modo que sua memória possa ser reutilizada.
 *
 * - runFinalization(): Solicita a JVM para se esforçar na execução de finalizadores de objetos que ela constatou
 * serem inalcançaveis, mas que ainda não tiveram seus finalizadores executados.
 *
 * - freeMemory(): Retorna uma estimativa de bytes livres na memória do sistema
 *
 * - totalMemory(): Retorna o total de bytes na memória do sistema.
 *
 * - maxMemory(): Retorna a quantidade máxima de memória em bytes que a jvm sempre tentará utilizar.
 */
public class GarbageCollector {

    public static long sobrecarregarMemoria() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }

        return Runtime.getRuntime().freeMemory();
    }

    public static void main(String[] args) {

        // Instancia a classe Runtime
        Runtime runtime = Runtime.getRuntime();

        int MB = 1_048_576; // total de bytes em 1 MB
        double total = runtime.maxMemory() / MB;
        System.out.println(total + " MB"); // 3540 MB de memória

        System.out.println(sobrecarregarMemoria() / MB); // 234 MB

        // total de memória utilizada quando sobrecarregamos a memória
        double inicio = total - (sobrecarregarMemoria() / MB);
        System.out.println(inicio); // 3306.0 MB

        runtime.runFinalization();
        runtime.gc();

        double fim = total - (runtime.freeMemory() / MB);
        System.out.println(fim); // 3301.0 MB

        System.out.println(inicio - fim); // 5 MB de memória foram coletados pelo garbage collector

    }

}
