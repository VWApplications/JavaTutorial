package br.com.vwapp.basico.exemplos;

import java.util.Random;
import java.util.Scanner;

/*
 * Jogo de palpites para acertar o número aleatório do dado
 */
public class JogoDeDados {

    public static void main(String[] args) {
        System.out.print("Qual o seu palpite? ");
        Scanner entrada = new Scanner(System.in);
        Integer palpite = entrada.nextInt();

        Random random = new Random();
        Integer dado = random.nextInt(6) + 1; // 1 até 6

        if (palpite == dado) {
            System.out.println("Você Acertou!");
        } else {
            System.out.println("Você Errou!");
            System.out.println("O valor do dado era " + dado);
        }
    }
}
