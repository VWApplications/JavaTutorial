package br.com.vwapp.excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TRATAMENTO DE EXCEÇÕES:
 *
 * Exceção é uma indicação de um problema que ocorre durante a execução de um programa.
 * Com o tratamento de exceções o programa pode continuar executando ao inves de encerrar.
 * Isso torna os programas robustos e tolerantes a falhas, ou seja, ele lida com os problemas
 * que surgem e continua e executar.
 *
 * TRY: É onde você insere o código que você deseja executar, normalmente são códigos que possivelmente
 * pode disparar alguma exceção indesejada, como divisão por 0, input invalido e etc...
 *
 * CATCH: Captura o erro gerado dentro do bloco try de acordo com o tipo passado como parametro
 * e aqui você pode fazer o tratamento do erro.
 *
 * FINALLY: É executado sempre, independente se teve ou não erro, normalmente usado para fechar conecções, arquivos
 * e etc.
 *
 */
public class TryCatch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        do {
            try {
                System.out.print("Insira o dividor: ");
                int y = scanner.nextInt();
                System.out.println(10 / y);
                continua = false; // se der tudo certo sai do loop
            } catch (InputMismatchException error) {
                System.err.println("Tipo de entrada invalida, insira um número inteiro!");
                scanner.nextLine(); // descarta a entrada que deu erro e libera novamente para o usuario
            } catch (ArithmeticException error) {
                System.err.println("Não se pode dividir um número por zero!");
            } finally {
                System.out.println("Obrigado por utilizar nosso software!");
            }
        } while (continua);
    }
}
