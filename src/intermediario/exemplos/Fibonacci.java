package intermediario.exemplos;

import java.util.Scanner;

/*
 * Começa-se a série com 0 (zero) e 1 (um)
 * Obtem-se o próximo número de Fibonacci
 * somando-se os dois anteriores e, assim,
 * sucessivamente e infinitamente.
 *
 * Ex: 1+2=3, 2+3=5, 3+5=8, 5+8=13, ...
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
 */
public class Fibonacci {

    public static void main(String[] args) {

        System.out.print("Insira a quantidade de elementos do fibonacci: ");
        Scanner entrada = new Scanner(System.in);
        Integer qtd = entrada.nextInt();

        int anterior = 0;
        int proximo = 1;

        // 0, 1
        System.out.print(anterior + ", ");
        System.out.print(proximo);

        while(proximo <= qtd) {
            System.out.print(", " + proximo);
            proximo += anterior; // 1 = 1 + 0, ...
            anterior = proximo - anterior; // 1 = 1 - 0, ...
        }
        System.out.println();

    }
}
