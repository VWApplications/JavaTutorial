package br.com.vwapp.poo.banco;

/**
 * HERANÇA: Quando você precisa dos atributos e métodos de outra classe você pode herdar esses atributos e métodos,
 * por exemplo, uma conta do banco do brasil (ContaBB) é uma Conta, ou seja, tudo que tem em Conta tem em ContaBB.
 * Para que você possa usar a herança precisa que o construtor tenha acesso ao construtor da classe PAI com o super()
 *
 * POLIMORFISMO - SOBRESCRITA DE MÈTODO: quando uma subclasses (FILHA) precisam ter comportamentos diferentes
 * em relação a classe PAI, podemos sobrescreve-la (@Override()) e utilizar o super() se precisar consultar a
 * implementação da classe pai.
 *
 */
public final class ContaBB extends Conta {

    public ContaBB() { super(); }
    public ContaBB(double saldo, String senha) { super(saldo, senha); }

    /**
     * Método responsável por transferir um determinado valor
     * para a conta de outro cliente.
     *
     * @param destino conta destino da transferencia
     * @param valor valor da transferencia
     */
    public void transferePara(Conta destino, double valor) {
        System.out.print("Transferencia: ");
        if (destino instanceof ContaBB) {
            System.out.println("Banco do Brasil -> Banco do Brasil");
            this.saca(valor);
        } else {
            System.out.println("Banco do Brasil -> Banco do ITAU");
            this.saca(valor + 40.00);
        }

        destino.deposita(valor);
    }

    /**
     * Verifica o saldo bancário do cliente
     *
     * Matematica de método:
     */
    @Override
    public void exibeSaldo() {
        System.out.println("bem vindo ao Banco do Brasil");
        super.exibeSaldo();
    }
}
