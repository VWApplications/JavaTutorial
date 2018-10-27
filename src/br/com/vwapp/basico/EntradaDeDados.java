package br.com.vwapp.basico;

import java.util.Scanner;

/*
 * Como recuperar informações do usuário do seu programa.
 */
public class EntradaDeDados {

    public static void main(String[] args) {

        // Entrada de dados pelo usuário
        System.out.print("Entre com seu nome: ");
        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();
        System.out.println(nome);

        System.out.print("Entre com sua idade: ");
        entrada = new Scanner(System.in);
        int idade = entrada.nextInt();
        System.out.println(idade);

        // Entrada de dados por uma janela
        // String sobrenome = JOptionPane.showInputDialog("Qual o seu nome?");
        // JOptionPane.showMessageDialog(null, "Bem vindo " + sobrenome);
    }
}
