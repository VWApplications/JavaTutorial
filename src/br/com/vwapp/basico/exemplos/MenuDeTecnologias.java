package br.com.vwapp.basico.exemplos;

import java.util.Scanner;

/*
 * Utilização do switch para criar um pesquisa de tecnologias
 */
public class MenuDeTecnologias {

    public static void main(String[] args) {

        System.out.print("Insira o nome da tecnologia: ");
        Scanner entrada = new Scanner(System.in);
        String tecnologia = entrada.nextLine();

        switch (tecnologia) {
            case "java":
            case "javascript":
            case "python":
                System.out.println("Linguagem de Programação");
                break;
            case "mysql":
            case "oracle":
            case "mongoDB":
            case "postgresql":
                System.out.println("Banco de dados");
                break;
            default:
                System.out.println("Tecnologia desconhecida");
        }
    }
}
