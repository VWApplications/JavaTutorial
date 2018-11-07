package br.com.vwapp.intermediario;

import java.util.Scanner;

/**
 * - Assertions são verificações feitas no seu sistema em tempo de desenvolvimento (Testes em tempo de desenvolvimento).
 *
 * - Normalmente utilizada para assegurar que coisas que não podem acontecer sejam
 * notificadas quando elas acontecerem.
 *
 * - Não deve usar assertions para testar coisas que na realidade devem acontecer,
 * para isso que existe as exceções.
 *
 * - Elas são feitas para testar coisas que nunca deveria acontecer, em um programa que funciona adequadamente
 * nenhuma assertion vai falhar.
 *
 * - As assertions não devem ir para produção, deve ser utilizadas somente em tempo de desenvolvimento.
 *
 * - Se uma assertion falhar o programa irá fechar e mostrar uma erro, caso contrario o programa
 * continuará rodando como se nada tivesse acontecido.
 *
 * - Para que as assertions funcione você precisa liga-las, elas estão desligas para que o ambiente vá para produção.
 *
 * - Elas tem o proposito de auxiliar verificações enquanto o programado está construindo um programa.
 *
 * - Para ligar a assertion digite no prompt de comando um parametro para sua JVM (-ea = -enableassertions ou -da = -desabledassertions):
 * java -ea br.com.vwapp.intermediario.Assertions (habilitar)
 * java -da br.com.vwapp.intermediario.Assertions (desabilitar)
 * java -ea:br.com.vwapp... (habilitar para todos os pacotes dentro do pacote vwapp)
 * java -da:br.com.vwapp... (desabilitar para todos os pacotes dentro do pacote vwapp)
 */
public class Assertions {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com um número de 0 a 10: ");
        int numero = scanner.nextInt();

        assert (numero >= 0 && numero <= 10): "Número invalido " + numero;
        System.out.println("Você entrou com o número: " + numero);
    }

}
