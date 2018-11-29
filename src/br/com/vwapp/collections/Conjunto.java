package br.com.vwapp.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe que não permite duplicatas
 */
public class Conjunto {

    public static void main(String[] args) {

        // Lista com duplicatas
        String[] cores = {"verde", "amarelo", "azul", "branco", "azul", "verde"};
        List<String> list = Arrays.asList(cores);
        System.out.println(list); // [verde, amarelo, azul, branco, azul, verde]

        // Lista sem duplicatas, ou seja, um conjunto
        Set<String> conjunto = new HashSet<>(list);
        System.out.println(conjunto); // [amarelo, branco, verde, azul]
    }

}
