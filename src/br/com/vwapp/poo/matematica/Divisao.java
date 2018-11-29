package br.com.vwapp.poo.matematica;

public class Divisao implements OperacoesBasicas {
    @Override
    public double calcula(double ... valores) {
        if (valores.length > 2 || valores[1] == 0) {
            return 0;
        };

        return valores[0]/valores[1];
    }
}
