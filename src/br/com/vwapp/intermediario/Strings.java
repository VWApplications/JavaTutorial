package br.com.vwapp.intermediario;

import java.util.Arrays;

/**
 * String nada mais é que um conjunto de caracteres.
 */
public class Strings {

    public static void main(String[] args) {

        construcao();
        localizacao();
        comparacao();
        extracao();
        modificacao();
        tokens();
        bufferEbuilder();

    }

    static void construcao() {
        // Criar uma string vazia
        String string1 = "";

        // Criar uma string
        String string2 = "Ola mundo!";

        // Contatenar 2 strings
        String string3 = string2 + " tudo bom!";

        // Construir uma string por meio de um array de caracteres
        char[] array = {'o', 'l', 'a'};
        String string4 = new String(array);

        // Verificar o tamanho da string
        System.out.println(string3.length()); // 20

        // Localizar um caracter em um string pelo seu indice
        System.out.println(string3.charAt(2)); // a

        // Retornar a representação da string
        System.out.println(string3.toString()); // Ola mundo! tudo bom!
    }


    static void localizacao() {
        String string = "Ola mundo! tudo bom!";

        // Encontra a primeira ocorrencia de uma determinada letra dentro da string e retorna o indice
        System.out.println(string.indexOf("mundo")); // 4

        // Encontra a ultima ocorrencia de uma determinada letra dentro da string e retorna o indice
        System.out.println(string.lastIndexOf("d")); // 13

        // Informa se a string ta vazia
        System.out.println(string.isEmpty()); // false
    }

    static void comparacao() {
        String string = "XTI";

        // Compara se duas string são iguais
        System.out.println(string.equals("xti")); // false
        System.out.println(string.equals("XTI")); // true

        // Compara duas string ignorando maiusculo de minusculo
        System.out.println(string.equalsIgnoreCase("xti")); // true

        // Verifica se seu texto começa ou termina com uma determinada string ou caracter
        System.out.println(string.startsWith("XT")); // true
        System.out.println(string.endsWith("TI")); // true

        // Compara se uma string é maior ou menor que outra
        System.out.println("amor".compareTo("bola")); // -1 (vem antes)
        System.out.println("bola".compareTo("amor")); // 1 (vem depois)
        System.out.println("bola".compareTo("bola")); // 0 (são iguais)

        // Descobrir se a string "oleo" é substring da string "alho e oleo" sem casesensitive, iniciando na posição 7
        // passando o tamanho da string "oleo" = 4 começando da posição 0 dessa string "oleo"
        System.out.println("alho e oleo".regionMatches(true, 7, "oleo", 0, "oleo".length())); // true


    }

    static void extracao() {
        String string1 = "O Brasil é Lindo!";

        // Pegar uma substring dentro da string a partir de uma determinada posição
        String string2 = string1.substring(11);
        System.out.println(string2); // Lindo!
        String string3 = string1.substring(2, 8);
        System.out.println(string3); // Brasil
    }

    static void modificacao() {
        String string1 = "O Brasil é Lindo";

        // Concatenar strings
        String string2 = string1.concat(" que maravilha");
        System.out.println(string2); // O Brasil é Lindo que maravilha

        // Trocar uma string por outra
        System.out.println(string2.replace("s", "z")); // O Brazil é Lindo que maravilha
        System.out.println(string2.replace("Brasil", "EUA")); // O EUA é lindo que maravilha
        System.out.println(string2.replaceFirst(" ", "-")); // O-Brazil é Lindo que maravilha
        System.out.println(string2.replaceAll(" ", "-")); // O-Brazil-é-Lindo-que-maravilha

        // Converter a string para letras maiusculas e minusculas
        System.out.println(string1.toUpperCase()); // O BRASIL É LINDO
        System.out.println(string1.toLowerCase()); // o brasil é lindo

        // Limpa os caracteres em branco antes e depois da string
        System.out.println("   olaaa mundo  ".trim()); // olaaa mundo
    }

    static void tokens() {

        // Tokenização é pegar grandes pedaços de dados e dividi-los em pedaços pequenos
        // os dados são compostos de tokens e delimitadores, por exemplo, "HTML; CSS; JAVA"
        // Os tokens são HTML, CSS e JAVA e o delimitadores é o ponto e virgula (;) é o que
        // separa os tokens

        String string = "XHTML; CSS; JAVA";

        // O metodo split recebe uma espressão regular que é nosso delimitador.
        String[] array = string.split(";");
        System.out.println(Arrays.toString(array)); // [XHTML, CSS, JAVA]
    }

    static void bufferEbuilder() {
        // Uma string não muda, ou seja, não tem como pegar o indice de uma string e modifica-lo,
        // já uma stringBuffer sim, eles fazem tudo que uma String faz.

        // Isso gera várias string temporárias o que não é bom para o desempenho da aplicação
        String x = "a";
        x += "b";
        x += "c";

        // Sempre quando precisar fazer manipulações complexas de string, utilize a classe string buffer
        // ou a classe string builder, a unica diferença entre as duas é que os métodos da string buffer
        // são sincronizados, eles são muito uteis em ambientes multi processados (threads acessando os
        // mesmos objetos StringBuffers).
        StringBuffer s1 = new StringBuffer();
        StringBuilder s2 = new StringBuilder("Ola mundo!");

        System.out.println(s2.toString()); // Ola mundo
        System.out.println(s2.length()); // 10

        // Informar a capacidade de armazenamento de novos caracteres sem alocar mais memória
        System.out.println(s2.capacity()); // capacidade para receber 26 caracteres

        // Inverte a ordem dos caracteres
        System.out.println(s2.reverse()); // !odnum alO

        // concatenar novos conteudos a string
        s2.append(" muito doido!");
        System.out.println(s2.toString()); // Ola mundo muito doido
        s2.append(" oloko").append(" meu!");
        System.out.println(s2.toString()); // Ola mundo muito doido oloko meu

        // String builder e concatenação de string na inicialização é a mesma coisa
        // ou seja, sua JVM vai transformar o s3 no s3builder
        // Se tiver trabalhando com muitas concatenações o ideal é usar o stringbuilder
        String s3 = "Ola" + " mundo!";
        String s3builder = new StringBuilder("Ola").append(" mundo!").toString();

        // Podemos também remove conteudos
        s2.delete(0, 11);
        System.out.println(s2.toString()); // muito doido! oloko meu!

    }
}
