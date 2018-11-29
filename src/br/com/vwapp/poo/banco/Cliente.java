package br.com.vwapp.poo.banco;

import java.util.ArrayList;

/**
 * ASSOCIAÇÃO: É quando dois objetos se relacionam de forma completamente independentes. Por exemplo: uma relação
 * entre professor e aluno, professor pode ter N alunos e alunos podem ter N professores, ambos podem existir
 * independente do outro.
 *
 * AGREGAÇÃO: É uma associação em que é utilizada para indicar todoo-parte, se o objeto todoo morrer o objeto parte continuará existindo,
 * a parte existe independente do todoo, ou seja, o objeto parte pode fazer parte de vários objetos todoo. Por
 * exemplo: Pedido e Item, independente do pedido (todoo) morrer o objeto item continuará existindo.
 *
 * COMPOSIÇÃO: É uma agregação em que os objetos parte só podem pertencer a um único objeto todoo e têm seu tempo
 * de vida coincidente com o dele, ou seja, quando o todoo morre todas as suas partes também morrem. Por exemplo:
 * Notebook e Teclado, se o notebook morrer o teclado morre junto. (1xN)
 *
 */
public class Cliente {

    private String nome;
    private int idade;
    private int cpf;
    private ArrayList<Conta> contas = new ArrayList<>(); // Composição (se o cliente morrer as contas morrem)

    Cliente(String nome, int idade, int cpf) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setCpf(cpf);
    }

    Cliente(String nome, int idade, int cpf, Conta conta) {
        this(nome, idade, cpf); // chamando o construtor acima
        this.setConta(conta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Conta getConta(int ID, String senha) {
        if (this.contas.size() < ID) return null;

        Conta conta = this.contas.get(ID);
        if (conta.verificaSenha(senha)) return conta;

        return null;
    }

    public void setConta(Conta conta) {
        this.contas.add(conta);
    }
}
