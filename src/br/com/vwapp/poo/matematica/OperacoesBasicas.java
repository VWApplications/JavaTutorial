package br.com.vwapp.poo.matematica;

/**
 * INTERFACES: interface são classes 100% abstratas, ou seja, não há implementação, ela serve para padronizar
 * classes que a implemente, fazendo com que elas obrigatoriamente implemente tudo que for definido nessa interface.
 * Variaveis de interface são constantes e não precisa de modificadores e podemos aplicar herança multipla
 * utilizando N interfaces implementadas.
 */
public interface OperacoesBasicas {

    double calcula(double ... valores);
}
