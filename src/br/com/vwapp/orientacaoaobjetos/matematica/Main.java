package br.com.vwapp.orientacaoaobjetos.matematica;

public class Main {

    public static void main(String[] args) {
        matematica();
        enumerate();
    }

    private static void matematica() {
        calcula(new Soma(), 1, 5, 6, 7, 29.40, 33.20); // 81.6
        double[] numeros = {1, 5, 6, 7, 29.40, 33.20};
        calcula(new Soma(), numeros); // 81.6
        calcula(new Multiplicacao(), 2, 3, 4); // 24
        calcula(new Divisao(), 10, 2); // 5
        calcula(new Subtracao(), 100, 50, 30); // 20

        Soma soma = new Soma();
        System.out.println(soma.calcula(5, 5, 5)); // calcula(double ... numeros)
        System.out.println(soma.calcula(5, 5)); // calcula(valor1, valor2)
    }

    public static void calcula(OperacoesBasicas operacaoMatematica, double ... valores) {
        System.out.println(operacaoMatematica.calcula(valores));
    }

    private static void enumerate() {
        System.out.println(Enumeracao.X);
        System.out.println(Enumeracao.X.valor);
        Enumeracao.imprimeNumeroCardinal(Enumeracao.X, Enumeracao.X, Enumeracao.I);
    }

}
