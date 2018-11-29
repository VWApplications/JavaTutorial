package br.com.vwapp.collections;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Futebol");
        list.add("Taekwondo");
        list.add("Box");
        list.add("Natação");
        list.add("Volei");
        list.add("Futebol");

        System.out.println(list); // [Futebol, Taekwondo, Box, Natação, Volei, Futebol]

        // Pega o primeiro elemento do array e coloca em uppercase
        list.set(0, list.get(0).toUpperCase());
        System.out.println(list); // [FUTEBOL, Taekwondo, Box, Natação, Volei, Futebol]

        // Localizar um elemento na lista
        System.out.println(list.indexOf("Box")); // 2

        // Encontre uma sublista dentro da lista
        List<String> sublista = list.subList(2, 4);
        System.out.println(sublista); // [Box, Natação]

        // Remove uma sublista da lista principal
        list.subList(2, 4).clear();
        System.out.println(list); // [FUTEBOL, Taekwondo, Volei, Futebol]
    }

}
