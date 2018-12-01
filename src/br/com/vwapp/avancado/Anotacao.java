package br.com.vwapp.avancado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
 * Essa anotação irá representar a estrutura de cabeçalho padrão de todas as classes.
 * É um tipo especial de interface
 *
 * Anotaçôes serve para documentar dados que serão processados automaticamente, elas apresentam a informação
 * de uma forma padronizada e estruturada que é mais acessivel pelo processamento automatico de ferramentas.
 *
 * Só pode utilizar tipos primitivos
 *
 * Para que a anotação só funcione em classes é só inserir a anotação:
 * @Target(ElementType.TYPE)
 *
 * Para que funcione em métodos tb:
 * @Target({ElementType.TYPE, ElementType.METHOD})
 *
 * Documentar a anotação no javadoc:
 * @Documented
 *
 * Para elementos deprequeted use a anotação (normalmente usado em métodos):
 * @Deprecated
 *
 * Quando se sobrescreve um método da classe mãe:
 * @Override
 *
 * Remove o erro de seu compilador, por exemplo, o serial quando você implementa a interface Serializable
 * @SuppressWarnings("nome do erro")
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Anotacao {

    String instituicao();
    String projeto();
    String dataCriacao();
    String criador();
    int revisao() default 1;
    String[] errosCorrigidos();

}
