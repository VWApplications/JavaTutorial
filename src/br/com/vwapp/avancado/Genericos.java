package br.com.vwapp.avancado;

import java.util.ArrayList;

/**
 * Object é o tipo mais genêrico de dado dentro do java.
 *
 * Temos vários problemas com essa tipagem generica, pq você nunca sabe oq tem dentro
 * e não consegue acessar os métodos do tipo diretamente, pq estou acessando um tipo Object.
 *
 * Para conseguir acessar seus métodos precisaria de um (Cast).
 *
 * Os genericos vieram para resolver esses problemas.
 * Os tipos genericos são tipos que são especificados apenas em seu método construtor.
 *
 * O caracter coringa (?) permite especificar parâmetros que atuam como supertipos ou subtipos parametrizados,
 * por exemplo, o método soma especificado.
 */
public class Genericos<Tipo> {

    Tipo elemento;

    public void setElemento(Tipo elemento) {
        this.elemento = elemento;
    }

    public Tipo getElemento() {
        return this.elemento;
    }

    // Quero passar uma lista de qualquer tipo de elemento que extenda Number, ou ele mesmo.
    // Com isso consigo passar um arraylist de inteiros, doubles, floats e etc...
    // Substituindo o extends por super você vai pegar qualquer tipo que seja pai de Number.
    public double soma(ArrayList<? extends Number> lista) {
        double total = 0;

        for (Number number: lista) {
            total += number.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {

        Genericos<Integer> generico1 = new Genericos<>();

        generico1.setElemento(2345);
        System.out.println(generico1.getElemento()); // 2345

        Genericos<String> generico2 = new Genericos<>();

        generico2.setElemento("Lago Paranoa!");
        System.out.println(generico2.getElemento()); // Lago Paranoa!

        String obj = generico2.getElemento();
        System.out.println(obj.toUpperCase()); // LAGO PARANOA!

    }

}
