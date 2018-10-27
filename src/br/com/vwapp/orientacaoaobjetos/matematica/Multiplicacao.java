package br.com.vwapp.orientacaoaobjetos.matematica;

public class Multiplicacao implements OperacoesBasicas {

    @Override
    public double calcula(double ... numeros) {
        double total = 1;

        for (double numero: numeros) {
            total *= numero;
        }

        return total;
    }
}
