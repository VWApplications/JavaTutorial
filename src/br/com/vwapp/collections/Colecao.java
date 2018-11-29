package br.com.vwapp.collections;

import java.util.*;

/**
 * Collections ou coleções são estruturas de dados padrões do java.
 *
 * Hierarquia:
 *
 * - Collection
 *   - Set (Sem duplicação)
 *     - SortedSet
 *       - HashSet
 *     - TreeSet
 *     - LinkedHashSet
 *   - List (Ordenados)
 *     - Vector
 *     - ArrayList
 *     - LinkedList
 *   - Queue (Filas)
 *     - PriorityQueue
 *   - Map (chave-valor)
 *     - SortedMap
 *       - TreeMap
 *     - HashMap
 *     - HashTable
 *     - LinkedHashMap
 *  - Arrays (classe de manipulação de array)
 *  - Collections (classe de manipulação de collection)
 *
 *  Abaixo será mostrada as operações que pode fazer com todas as coleções
 */
public class Colecao {

    public static void main(String[] args) {

        // Cria uma coleção do tipo array list
        Collection<String> collection = new ArrayList<>();

        // Adiciona elementos a sua coleção
        collection.add("Ola");
        collection.add("Mundo");
        collection.add("Doido");

        // Apresenta a coleção no formato string
        System.out.println(collection.toString()); // [Ola, Mundo, Doido]

        // Verifica se sua coleção esta vazia
        System.out.println(collection.isEmpty()); // false

        // Pesquisa pela ocorrencia de um determinado elemento
        System.out.println(collection.contains("Doido")); // true

        // Remove elementos da coleção
        collection.remove("Mundo");
        System.out.println(collection.toString()); // [Ola, Doido]

        // Adiciona vários elementos dentro da coleção
        Collection<String> nova_colecao = Arrays.asList("Eita", "Mundo", "Louco"); // converte array em collections
        collection.addAll(nova_colecao);
        System.out.println(collection.toString()); // [Ola, Doido, Eita, Mundo, Louco]

        // Verificar se existe um grupo de elementos dentro de outro
        System.out.println(collection.containsAll(nova_colecao)); // true

        // Remove um grupo de elementos da coleção
        collection.removeAll(nova_colecao);
        System.out.println(collection.toString()); // [Ola, Doido]

        // Converter uma colação em um array de string do tamanho da coleção
        String[] strings = collection.toArray(new String[collection.size()]);
        System.out.println(Arrays.toString(strings)); // [Ola, Doido]

        // Limpa a coleção
        collection.clear();
        System.out.println(collection.toString());  // []

        utilitario();
    }

    static void utilitario() {
        List<String> list = new ArrayList<>();
        list.add("Guarana");
        list.add("Uva");
        list.add("Banana");
        list.add("Açai");
        System.out.println(list); // [Guarana, Uva, Banana, Açai]

        // Ordenar em ordem alfabética a lista
        Collections.sort(list);
        System.out.println(list); // [Açai, Banana, Guarana, Uva]

        // Inverter a ordem da lista
        Collections.reverse(list);
        System.out.println(list); // [Uva, Guarana, Banana, Açai]

        // Embaralhar os dados da coleção
        Collections.shuffle(list);
        System.out.println(list); // [Guarana, Uva, Banana, Açai], ...

        // Colocar outros elementos na lista
        Collections.addAll(list, "Manga", "Banana");
        System.out.println(list); // [Uva, Açai, Guarana, Banana, Manga, Banana]

        // Verificar quantas vezes uma palavra aparece na lista
        System.out.println(Collections.frequency(list, "Banana")); // 2

        // Verificar se existe uma sublista dentro da lista
        List<String> list1 = Arrays.asList("Acerola", "Amexa");
        System.out.println(Collections.disjoint(list, list1)); // false

        // Fazer uma pesquisa na coleção e volta onde ela está  (indice)
        Collections.sort(list);
        System.out.println(list); // [Açai, Banana, Banana, Guarana, Manga, Uva]
        int indice = Collections.binarySearch(list, "Uva");
        System.out.println(indice);

        // Preencher toda a colação com algo
        Collections.fill(list1, "Açai");
        System.out.println(list1); // [Açai, Açai]

        // Criar uma coleção imutavel
        Collection<String> constante = Collections.unmodifiableCollection(list1);
        System.out.println(constante); // [Açai, Açai]

    }

}
