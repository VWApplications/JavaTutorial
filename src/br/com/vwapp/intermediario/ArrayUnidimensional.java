package br.com.vwapp.intermediario;

import java.util.Arrays;

/*
 * Arrays unidimensionais ou vetores
 */
public class ArrayUnidimensional {

    /**
     *
     * Método principal para executar um programa
     * @param args dados passados como parâmetro (java arquivo.class meuArgumento1 "meu argumento 2")
     */
    public static void main(String[] args) {

        if (args.length > 0) System.out.println(args[0]);

        // Criação
        String[] paises = {"Brasil", "China", "Arabia"}; // Array de strings com 2 elementos
        Integer[] idades = {1, 2, 3, 4, 5}; // Array de inteiros com 5 elementos
        Double[] precos = {}; // Array de doubles vazio
        int[] impares = new int[5]; // Arrays de inteiros indicando tamanho do array


        // Acesso a Elementos
        System.out.println(paises[0]); // Brasil
        System.out.println(paises.length); // 2 elementos
        System.out.println(paises[0].replace('a', 'o')); // Brosil

        // 1 2 3 4 5
        for (Integer idade: idades) {
            System.out.print(idade);
            System.out.print(" ");
        }
        System.out.println();

        // Modificando valores de um array
        idades[0] = 10;
        System.out.println(idades[0]); // 10


        // Classe Array
        System.out.println(Arrays.toString(paises)); // [Brasil, China, Arabia]

        // Pesquisa
        int posicao = Arrays.binarySearch(paises, "Brasil");
        System.out.println(posicao); // 0

        // Ordenação
        Arrays.sort(paises, 0, paises.length);
        System.out.println(Arrays.toString(paises)); // [Arabia, Brasil, China]
    }
}
