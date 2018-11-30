package br.com.vwapp.poo.banco;

/**
 * <b>ORIENTAÇÃO A OBJETOS</b> é o paradigma de programação que mais
 * chega perto da representação do mundo real.<br />
 *
 * <b>CLASSES</b>: representa o tipo de objeto que você constroi a partir dela, é como se fosse
 * um template ou modelo de criação de objetos, e esses objetos são compostos de atributos e ações.<br />
 *
 * <b>ATRIBUTOS</b>: são representados pelas nossas variáveis.<br />
 *
 * <b>AÇÔES</b>: são representadas pelos nossos métodos.<br />
 *
 * <b>INSTÂNCIAS</b>: São objetos na forma concreta, por exemplo, uma classe cachorro pode ter
 * tamanho, nome, raça, olhos, patas, rabos, etc... e realiza ações como latir, cagar, morder,
 * e etc... com isso uma instancia dessa classe é o objeto com nome Rex de tamanho 30 Cm, raça
 * vira-lata e por ai vai.<br />
 *
 * <b>PACOTES</b>: estrutura de diretorios onde é colocada todas as classe de um determinado assunto, usado
 * para modularizar os programas. Todos os pacotes criados por uma empresa deve ser criados com o dominio
 * da empresa invertido, por exemplo: www.xti.com.br - import br.com.xti.nomedopacote.NomeDaClasse<br />
 *
 * <b>CONSTRUTORES</b>: como o próprio nome já diz é o construtor da classe, os construtores tem o mesmo nome da classe.<br />
 *
 * <b>MODIFICADORES DE ACESSO</b> faz com que a visibilidade de classes, métodos e atributos seja controlado<br /><br />
 *
 * <ul>
 *   <li><b>PRIVATE</b>: visibilidade na própria classe</li>
 *   <li><b>PROTECTED</b>: visibilidade na classe e suas subclasses</li>
 *   <li><b>PUBLIC</b>: visibilidade total</li>
 *   <li><b>SEM MODIFICADOR</b>: visibilidade dentro do mesmo pacote</li>
 *</ul><br />
 *
 * <b>ENCAPSULAMENTO</b> é você encapsular seus atributos como privado e criando métodos GETs e SETs para que você tenha
 * o controle de como os outros acessam e modificam seus atributos.<br />
 *
 * <b>ATRIBUTOS E MÉTODOS ESTÁTICOS</b>: são métodos e atributos da classe e não ao objeto da classe, por exemplo,
 * toda vez que eu realizar um deposito ou um saque o saldo total do banco deve decrementar ou incrementar,
 * independente do objeto que realize a operação.<br />
 *
 * <b>CONSTANTE</b>: para criar atributos constantes é só utilizar o final para nunca ser modificado com o static para tornar
 * esse atributo único na classe. Se colocar o modificador final em uma classe ela não poderá mais ser herdada
 * e se colocar em um método ele não poderá ser modificado/sobrescrito por suas subclasses.<br />
 *
 * <b>CLASSE ABSTRATA</b>: quando você quer especificar que essa classe é apenas um template e não gera objetos,
 * não pode ser instanciada, normalmente usada quando se tem classes filhas que herdam dela.<br />
 *
 * <b>JAVADOC</b>: Documentação java - Tools -> Generate Javadoc
 *
 * @author victor e XTI
 * @version 1.0
 * @see ContaBB
 * @see ContaITAU
 *
 */
public abstract class Conta {

    // ATRIBUTOS

    private double saldo;
    private static double saldoTotalDoBanco = 0.0;
    private static final int ID = 12345; // constante da classe
    protected String senha;

    // CONSTRUTORES

    Conta() {
        this.senha = "admin1234";
        this.setSaldo(0);
    }

    Conta(double saldo, String senha) {
        this.setSaldo(saldo);
        this.senha = senha;
    }

    // Método abstrato deve ser implementado por seus filhos obrigatóriamente
    abstract void transferePara(Conta destino, double valor);

    // AÇÔES

    /**
     * Verifica o saldo bancário do cliente
     */
    void exibeSaldo() {
        System.out.println("Seu saldo é de " + this.getSaldo());
    }

    /**
     * Método responsável por sacar um determinado valor
     * da conta
     *
     * @param valor valor a ser sacado.
     */
    void saca(double valor) {
        this.saldo -= valor;
        Conta.saldoTotalDoBanco -= valor;
    }

    /**
     * Método responsável por depositar um determinado valor
     * na conta
     *
     * @param valor valor a ser depositado.
     */
    void deposita(double valor) {
        this.saldo += valor;
        Conta.saldoTotalDoBanco += valor;
    }

    // GETTERS e SETTERS (encapsulamento)

    /**
     * Mostra o saldo total do banco
     *
     * @return saldo total do banco
     */
    public static void getSaldoTotalDoBanco() {
        System.out.println("O banco de ID " + Conta.ID + " tem o saldo total de " + Conta.saldoTotalDoBanco);
    }

    /**
     *  Método GET de encapsulamento para o saldo da conta
     *
     * @return saldo da conta
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Método SET de encapsulamento para o saldo da conta
     *
     * @param valor valor do saldo
     */
    public void setSaldo(double valor) {
        this.saldo = valor;
        Conta.saldoTotalDoBanco += valor;
    }

    /**
     * Método SET de encapsulamento para a senha da conta
     *
     * @param senhaAntiga senha antiga de acesso
     * @param novaSenha nova senha de acesso
     */
    public final void setSenha(String senhaAntiga, String novaSenha) {
        if(this.verificaSenha(senhaAntiga)) {
            this.senha = novaSenha;
            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Senha incorreta!");
        }
    }

    /**
     * Verifica se a senha da conta bate com a senha passada
     *
     * @param senha senha passada
     * @return true se as senhas forem iguais e false caso contrários
     */
    public final boolean verificaSenha(String senha) {
        if (senha.equals(this.senha)) return true;

        return false;
    }

}
