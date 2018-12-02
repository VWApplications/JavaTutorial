package br.com.vwapp.jdbc;

public class Conta {

    private int id;
    private double saldo;
    private String cliente;

    public Conta(int id, String cliente, double saldo) {
        this.setId(id);
        this.setSaldo(saldo);
        this.setCliente(cliente);
    }

    public String toString() {
        return this.id + ", " + this.cliente + ", " + this.saldo;
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public double getSaldo() { return this.saldo; }

    public void setSaldo(double valor) { this.saldo = valor; }

    public String getCliente() { return this.cliente; }

    public void setCliente(String cliente) { this.cliente = cliente; }

    void saca(double valor) {
        this.saldo -= valor;
    }

    void deposita(double valor) {
        this.saldo += valor;
    }
}
