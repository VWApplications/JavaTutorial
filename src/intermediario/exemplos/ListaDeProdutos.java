package intermediario.exemplos;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Lista de produtos com do while
 */
public class ListaDeProdutos {

    public static void main(String[] args) {

        ArrayList<String> produtos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Liste seu produtos e no final digite FIM");

        String produto;

        do {
            System.out.print("Insira o produto: ");
            produto = entrada.nextLine();

            if (!produto.toUpperCase().equals("FIM")) {
                produtos.add(produto);
            }
        } while (!produto.toUpperCase().equals("FIM"));

        System.out.println(produtos.toString());

    }
}
