package br.com.vwapp.poo.banco;

/**
 * HERANÇA: Quando você precisa dos atributos e métodos de outra classe você pode herdar esses atributos e métodos,
 * por exemplo, uma conta do banco ITAU (ContaITAU) é uma Conta, ou seja, tudo que tem em Conta tem em ContaITAU.
 * Para que você possa usar a herança precisa que o construtor tenha acesso ao construtor da classe PAI com o super()
 *
 * POLIMORFISMO - SOBRESCRITA DE MÈTODO: quando uma subclasses (FILHA) precisam ter comportamentos diferentes
 * em relação a classe PAI, podemos sobrescreve-la (@Override()) e utilizar o super() se precisar consultar a
 * implementação da classe pai.
 *
 */
public final class ContaITAU extends Conta {

    public ContaITAU() {
        super();
        super.senha = "itau1234";
    }
    public ContaITAU(double saldo, String senha) { super(saldo, senha); }

    /**
     * Método responsável por transferir um determinado valor
     * para a conta de outro cliente.
     *
     * @param destino conta destino da transferencia
     * @param valor valor da transferencia
     */
    public void transferePara(Conta destino, double valor) {
        System.out.print("Transferencia: ");
        if (destino instanceof ContaITAU) {
            System.out.println("Banco do ITAU -> Banco do ITAU");
            this.saca(valor);
        } else {
            System.out.println("Banco do ITAU -> Banco do Brasil");
            this.saca(valor + 66.00);
        }

        destino.deposita(valor);
    }

}
