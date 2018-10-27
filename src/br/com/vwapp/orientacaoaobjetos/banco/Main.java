package br.com.vwapp.orientacaoaobjetos.banco;

public class Main {

    public static void main(String[] args) {
        conta();
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

}
