package br.com.vwapp.arquivos;

public class Conta {

    private double saldo;
    private String cliente;

    public Conta(String cliente, double saldo) {
        this.setSaldo(saldo);
        this.setCliente(cliente);
    }

    void exibeSaldo() {
        System.out.println("Saldo da conta de " + this.getCliente() + " é de " + this.getSaldo() + " reais");
    }

    public double getSaldo() { return this.saldo; }

    public void setSaldo(double valor) { this.saldo = valor; }

    public String getCliente() { return this.cliente; }

    public void setCliente(String cliente) { this.cliente = cliente; }
}
