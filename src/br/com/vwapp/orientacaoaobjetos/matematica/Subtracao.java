package br.com.vwapp.orientacaoaobjetos.matematica;

public class Subtracao implements OperacoesBasicas {
    @Override
    public double calcula(double... valores) {
        double total = valores[0];

        for (int i=1; i<valores.length; i++) {
            total -= valores[i];
        }

        return total;
    }
}
