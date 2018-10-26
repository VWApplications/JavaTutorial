package intermediario;

import java.util.ArrayList;

public class ArrayListCollection {

    public static void main(String[] args) {

        // Criar
        ArrayList<String> cores = new ArrayList<>();

        // Adicionar
        cores.add("Verde");
        cores.add("Branco");
        cores.add("Azul");
        cores.add(1, "Preto");
        System.out.println(cores.toString()); // [Verde, Preto, Branco, Azul]
        cores.addAll(cores);
        System.out.println(cores.toString()); // [Verde, Preto, Branco, Azul, Verde, Preto, Branco, Azul]
        System.out.println(cores.size()); // 8

        // Acessar um elemento
        System.out.println(cores.get(0)); // Verde
        System.out.println(cores.indexOf("Branco")); // 2

        // Pesquisar
        System.out.println(cores.contains("Branco")); // true
        System.out.println(cores.contains("Amarelo")); // false
        System.out.println(cores.isEmpty()); // false

        // Remover
        cores.remove("Verde");
        cores.remove("Preto");
        cores.remove("Branco");
        cores.remove("Azul");
        System.out.println(cores.toString()); // [Verde, Preto, Branco, Azul]
        cores.clear();
        System.out.println(cores.toString()); // []
        System.out.println(cores.isEmpty()); // true
    }
}
