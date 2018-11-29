package br.com.vwapp.poo.matematica;

/**
 * Enumerações são constantes que
 */
public enum Enumeracao {

    // Constantes de números romanos
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

    public Integer valor;

    Enumeracao(Integer valor) {
        this.valor = valor;
    }

    // Enumeracao.imprimeNumeroCardinal(Enumeracao.X, Enumeracao.X, Enumeracao.I) -> 21
    public static void imprimeNumeroCardinal(Enumeracao ... numeroRomano) {
        Integer total = 0;
        for (Enumeracao romano: numeroRomano) {
            total += romano.valor;
        }

        System.out.println(total);
    }

}
