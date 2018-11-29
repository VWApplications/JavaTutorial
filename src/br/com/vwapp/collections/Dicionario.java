package br.com.vwapp.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Conjunto chave-valor em que as chaves são únicas e o valor pode ser qualquer coisa.
 */
public class Dicionario {

    public static void main(String[] args) {

        Map<String, String> paises = new HashMap<>();

        // Inserir chave-valor
        paises.put("BR", "Brasil");
        paises.put("RU", "Rússia");
        paises.put("IN", "Índia");
        paises.put("CN", "China");

        System.out.println(paises); // {BR=Brasil, RU=Rússia, IN=Índia, CN=China}


        // Verificar se existe uma determinada chave ou valor
        System.out.println(paises.containsKey("RU")); // true
        System.out.println(paises.containsValue("Brasil")); // true

        // Recuperar um conteudo pela chave
        System.out.println(paises.get("CN")); // China

        // Remover um conteudo do seu mapa
        paises.remove("RU");
        System.out.println(paises); // {BR=Brasil, IN=Índia, CN=China}

        // Recupera todas as chaves do mapa
        System.out.println(paises.keySet()); // [BR, IN, CN]

        // Percorrer um dicionario (map)
        for (String key: paises.keySet()) {
            System.out.println(key + ": " + paises.get(key)); // BR: Brasil, ...
        }


    }

}
