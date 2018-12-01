package br.com.vwapp.avancado;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * É usada para examinar os detalhes de uma classe, ou seja, usa reflexão para descobrir tod0 o tipo de informação
 * sobre uma classe, seus atributos, pacotes, interfaces e etc...
 *
 * Também é chamada de introspecção
 *
 * Você também pode construir objetos com o reflexion
 */
public class Reflexao {

    public static void main(String[] args) throws Exception {

        // Construir uma classe a partir do nome
        String nomeDaClasse = "br.com.vwapp.avancado.ClasseAninhada";

        Class classe = Class.forName(nomeDaClasse);

        System.out.println(classe.getSimpleName()); // ClasseAninhada

        // Pega os campos públicos da sua classe
        Field[] fields = classe.getFields();
        for (Field field: fields) {
            System.out.println(field.getName()); // texto
        }

        // Pega os métodos dessa classe
        Method[] methods = classe.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println(method.getName()); // pegaAninhado, pegaAnonimo e main
        }

        // Pega os construtores
        Constructor[] constructors = classe.getConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor.getName()); // ClasseAninhada
        }

        // Pega outro construtor da classe, se tiver, só especificar os parâmetros, por exemplo: String.class
        Constructor constructor = classe.getConstructor();
        Object obj = constructor.newInstance();

        // Construindo objetos com construtor padrão
        ClasseAninhada classeAninhada = (ClasseAninhada) classe.newInstance();
        System.out.println(classeAninhada.texto); // Ola Mundo!

        // Pega um método da classe (nome do método, parametros, por exemplo, double.class)
        Method method = classe.getMethod("imprimeTexto", String.class);
        method.invoke(classeAninhada, "Texto muito doido!"); // Texto muito doido!


    }

}
