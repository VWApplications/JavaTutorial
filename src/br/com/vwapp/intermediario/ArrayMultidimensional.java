package br.com.vwapp.intermediario;

/*
 * Arrays multidimensionais ou matrizes
 * Arrays bidirecionais são os mais usados,
 * os multidimensionais são usandos mais em cálculos cientificos e gráficos
 */
public class ArrayMultidimensional {

    public static void main(String[] args) {
        // Array bidimensional
        String[][] pessoas = {
            {"Ricardo", "Sandra", "Beatriz"},
            {"M", "F", "F"},
            {"DF", "MG", "DF"}
        };
        // Array tridimensional vazio
        Integer[][][] tridimensional = {{{}, {}}, {{}, {}}};


        // Acessando os elementos
        System.out.println(pessoas[0][2]); // Beatriz (Linha 1, Coluna 3)
        System.out.println(pessoas[1][2]); // F (Linha 2, Coluna 3)
        System.out.println(pessoas[2][2]); // DF (Linha 3, Coluna 3)
        System.out.println(pessoas[0].length);

        // Modificando um elemento
        pessoas[2][2] = "GO";
        System.out.println(pessoas[2][2]); // GO (Linha 3, Coluna 3)
    }
}
