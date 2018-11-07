package br.com.vwapp.excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TRATAMENTO DE EXCEÇÕES:
 *
 * MULTI CATCH: Possibilidade de tratar vários tipos de exceções no mesmo bloco.
 *
 */
public class MultiCatch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        do {
            try {
                System.out.print("Insira o dividor: ");
                int y = scanner.nextInt();
                System.out.println(10 / y);
                continua = false; // se der tudo certo sai do loop
            } catch (InputMismatchException | ArithmeticException error) {
                System.err.println("Tipo de entrada invalida, insira um número inteiro maior que zero!");
                scanner.nextLine(); // descarta a entrada que deu erro e libera novamente para o usuario
            } finally {
                System.out.println("Obrigado por utilizar nosso software!");
            }
        } while (continua);

    }
}
