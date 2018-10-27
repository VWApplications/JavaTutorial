package br.com.vwapp.intermediario.exemplos;

import static java.lang.Math.sqrt;

public class Raiz {

    public static void main(String[] args) {
        System.out.println(raiz(99));
        System.out.println(sqrt(99));
    }

    /**
     * De acordo com a equação de Pell's para obter a raiz quadrada de um número
     * é só subtrair números ímpares até zerar e obter a quantidade de passos
     *
     * Ex: sqrt(27)
     *      27 - 1 = 26
     *      26 - 3 = 23
     *      23 - 5 = 18
     *      18 - 7 = 11
     *      11 - 9 = 2
     *
     * 5 passos foram tomados e isso nos leva que a parte inteira da raiz quadrada de 27 é 5
     *
     * @param numero número que será extraido a raiz
     * @return raiz quadrada do número em inteiro
     */
    public static int raiz(int numero) {
        int quantidadeDePassos = 0;

        for (int i=1; i<=numero; i+=2) {
            numero -= i;
            quantidadeDePassos++;
        }

        return quantidadeDePassos;
    }
}
