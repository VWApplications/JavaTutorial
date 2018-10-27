package br.com.vwapp.orientacaoaobjetos.matematica;

/**
 *  MÉTODOS SOBRECARREGADOS: são métodos que tem o mesmo nome, porém com assinaturas diferentes, ou seja,
 *  tem o mesmo nome, mas tem parâmetros diferentes.
 */
public final class Soma implements OperacoesBasicas {

    /**
     * Método de soma com argumentos variaveis.
     * esses números são convertidos em um Array
     * chamado números.
     *
     * Ex:
     *
     *      soma.calcula(1, 5, 6, 7, 29.40, 33.20); -> 81.6
     *
     * @param numeros quantidade N de números
     * @return soma desses números
     */
    @Override
    public double calcula(double ... numeros) {
        double total = 0;

        for (double numero: numeros) {
            total += numero;
        }

        return total;
    }

    /**
     * Método de soma passando 2 valores como parâmetro
     *
     * Ex:
     *      soma.calcula(1, 5); -> 6
     *
     * @param valor1 valor da soma 1
     * @param valor2 valor da soma 2
     * @return soma desses valores
     */
    public double calcula(double valor1, double valor2) {
        System.out.println("calcula(valor1, valor2)");
        return valor1 + valor2;
    }
}
