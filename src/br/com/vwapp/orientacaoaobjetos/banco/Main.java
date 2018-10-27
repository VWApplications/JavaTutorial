package br.com.vwapp.orientacaoaobjetos.banco;

public class Main {

    public static void main(String[] args) {
        conta();
        // matematica();
        // enumerate();
    }

    private static void conta() {
        Cliente ricardo = new Cliente("Ricardo", 23, 12345);
        Cliente kaio = new Cliente("Kaio", 26, 23304, new ContaBB());


        ricardo.setConta(new ContaITAU(100_000.00, "ricardo1234"));
        Conta conta = ricardo.getConta(0, "ricardo1234");
        conta.setSenha("ricardo1234", "xucabala");
        conta.saca(1_000.00);
        conta.deposita(350.40);

        Conta destino = kaio.getConta(0, "admin1234");
        destino.setSaldo(8_000.00);

        conta.transferePara(destino, 1500);

        System.out.print(ricardo.getNome() + " ");
        conta.exibeSaldo(); // 97_784.4
        System.out.print(kaio.getNome() + " ");
        destino.exibeSaldo(); // 9_500.00

        Conta.getSaldoTotalDoBanco();
    }

//    private static void matematica() {
//        Matematica matematica = new Matematica();
//        System.out.println(matematica.soma(0,1, 5, 6, 7, 29.40, 33.20));
//        double[] numeros = {1, 5, 6, 7, 29.40, 33.20};
//        System.out.println(matematica.soma(numeros));
//    }
//
//    private static void enumerate() {
//        System.out.println(Enumeracao.X);
//        System.out.println(Enumeracao.X.valor);
//        Enumeracao.imprimeNumeroCardinal(Enumeracao.X, Enumeracao.X, Enumeracao.I);
//    }

}
