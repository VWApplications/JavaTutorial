package br.com.vwapp.threads.conta;

public class ContaConjuntaNaoSincronizada {

    private int saldo = 100;

    public int getSaldo() {
        return saldo;
    }

    public void sacar(int valor, String cliente) {
        if (saldo >= valor) {
            int saldoOriginal = saldo;
            try {
                System.out.println(cliente + " aguardando processamento de dados!");
                Thread.sleep(1000); // simular processamento
            } catch (InterruptedException e) {}
            saldo -= valor;
            System.out.println(cliente + " sacou R$ " + valor);
            System.out.println("Saldo original = " + saldoOriginal);
            System.out.println("Saldo final = " + saldo);
        } else {
            System.out.println("Saldo insuficiente para " + cliente);
        }
    }
}
