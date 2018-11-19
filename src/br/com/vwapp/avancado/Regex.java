package br.com.vwapp.avancado;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex ou expressões regulares são padrões de pesquisa e substituição de textos.
 * São muito uteis para validar dados do seu programa e assegurar que esses dados
 * estejam em um determinado formato.
 */
public class Regex {

    public static void main(String[] args) {

        metodosJava();
        modificadores();
        metacaracteres();
        quantificadores();
        agrupadores();
        substituicoes();

    }

    static void metodosJava() {
        String padrao = "";
        String texto = "Java";

        // para validar se no texto existe o padrão Java você utiliza a palavra Java como padrão
        padrao = "Java";
        boolean ocorrencia = texto.matches(padrao);
        System.out.println(ocorrencia); // true
    }

    /**
     * Modificadores:
     * (?i) - Ignora maiúsculas e minusculas
     * (?x) - Reconhece comentários
     * (?m) - Trabalha com várias linhas
     * (?s) - Dottal
     */
    static void modificadores() {
        // Procurar a palavra "Java" independente de ser maiusculo ou minusculo
        // e considerando várias linhas
        System.out.println("Java".matches("(?im)java")); // true
    }

    /**
     * .   Qualquer caractere
     * \d  Dígitos [0-9]
     * \D  Não é um dígito [^0-9]
     * \s  Espaço [ \t\n\x0B\f\r]
     * \S  Não é um espaço [^\s]
     * \w  Letras e números [a-zA-Z_0-9]
     * \W  Não é uma letra [^\w]
     * ^   Inicia
     * $   Termina
     * |   OU
     */
    static void metacaracteres() {
        // Encontrar a ocorrencia de um caracter a
        System.out.println("@".matches(".")); // true

        // Encontrar a ocorrencia de um digito
        System.out.println("2".matches("\\d")); // true
        System.out.println("22".matches("\\d")); // false
        System.out.println("a".matches("\\d")); // false
        System.out.println("a".matches("\\D")); // true

        // Encontrar a ocorrencia de letras e números
        System.out.println("2".matches("\\w")); // true
        System.out.println("a".matches("\\w")); // true
        System.out.println("#".matches("\\w")); // false
        System.out.println("#".matches("\\W")); // true

        // Encontrar a ocorrencia de espaços
        System.out.println(" ".matches("\\s")); // true
        System.out.println("\n".matches("\\s")); // true
        System.out.println("a".matches("\\s")); // false
        System.out.println("a".matches("\\S")); // true

        // Validar algo que começa com a e termina com z
        System.out.println("arroz".matches("^a\\w+z$")); // true
        System.out.println("arros".matches("^a\\w+z$")); // false
        System.out.println("erroz".matches("^a\\w+z$")); // false
        System.out.println("Arroz doce".matches("^Arroz \\w*")); // true
        System.out.println("Pier21".matches("\\w*21$")); // true

        // Validar se algo começa com a ou e
        System.out.println("sim".matches("sim|não")); // true
        System.out.println("não".matches("sim|não")); // true
    }

    /**
     * Quantificadores servem para especificar mais de um caracter na busca da regex
     *
     * X{n}     X, exatamente n vezes
     * X{n,}    X, pelo menos n vezes (no mínimo n vezes)
     * X{n, m}  X, pelo menos n vezes, mas não mais do que m vezes
     * X?       X, 0 ou 1 vez
     * X*       X, 0 ou + vezes
     * X+       X, 1 ou + vezes
     */
    static void quantificadores() {
        // buscar 2 digitos
        System.out.println("22".matches("\\d\\d")); // true

        // Avaliar uma string vazia
        System.out.println("".matches(".?")); // true

        // vamos criar uma validação de cep
        System.out.println("70294-070".matches("\\d{5}-\\d{3}")); // true

        // Vamos validar um cpf
        System.out.println("011.283.923-23".matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")); // true

        // Vamos validar um telefone
        System.out.println("+55 (61) 99938-4059".matches(".\\d{2}\\s\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}")); // true
        System.out.println("+55 (61) 9938-4059".matches(".\\d{2}\\s\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}")); // true

        // Vamos validar uma data
        System.out.println("21/08/1993".matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")); // true
        System.out.println("3/8/93".matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")); // true
    }

    /**
     * Agrupadores agrupam conjuntos de validações.
     * [abc]            Agrupamento (quero os caracteres abc)
     * [a-z]            Alcance (quero todos os caracteres entre a e z)
     * [a-e][i-o]       União (a,b,c,d,e,i,j,k,l,m,n,o)
     * [a-z&&[aeiou]]   Interseção (quero de a até z incluindo aeiou)
     * [^abc]           Exceção (quero tudo menos abc)
     * [a-z&&[^m-p]]    Subtração (quero de a até z removendo de m até p)
     * \x               Fuga literal
     */
    static void agrupadores() {
        // O método matches vai converter essas regex em um algoritmo que vai validar
        // o texto em tempo de execução
        System.out.println("true".matches("[tT]rue")); // true
        System.out.println("True".matches("[tT]rue")); // true
        System.out.println("vrue".matches("[tT]rue")); // false
        System.out.println("crau".matches("cr[ae]u")); // true
        System.out.println("creu".matches("cr[ae]u")); // true

        System.out.println("Beatriz".matches("[A-Z][a-zA-Z]*")); // true

        System.out.println("a".matches("[a-z]")); // true
        System.out.println("2".matches("[0-9]")); // true
        System.out.println("2".matches("[a-z]")); // false

        System.out.println("olho".matches("[^abc]lho")); // true
        System.out.println("alho".matches("[^abc]lho")); // false

        // Validação de email
        System.out.println("rh@gmail.com".matches("\\w+@\\w+\\.\\w{2,3}")); // true
    }

    static void substituicoes() {
        // Vamos encontrar todas as ocorrencias da palavra doce
        String doce = "Qual é o Doce mais DoCe que o doce de batata DOCE?";
        // Pattern vai preparar a expressão regular para depois ser utilizada várias vezes no texto doce
        Matcher matcher = Pattern.compile("(?i)doce").matcher(doce);

        // find encontra a ocorrencia dentro do texto e o group retorna essa ocorrencia
        while (matcher.find()) {
            System.out.println(matcher.group()); // Doce DoCe doce DOCE
        }

        String txt = doce.replaceAll("(?i)doce", "doce");
        System.out.println(txt); // Qual é o doce mais doce que o doce de batata doce?



        // Transformar para: http://www.xti.com.br/2011/clientes.jsp
        String url = "www.xti.com.br/clientes-2011.html";

        String padrao = "www.xti.com.br/\\w{2,}-\\d{4}.html";
        System.out.println(url.matches(padrao)); // true

        // Crie uma variavel utilizando parenteses
        padrao = "(www.xti.com.br)/(\\w{2,})-(\\d{4}).html";

        // A variavel pode ser recuperada com ($posição da variavel), no caso $1, $2 e $3
        // já no formato da nova url http://www.xti.com.br/2011/clientes.jsp
        String resultado = url.replaceAll(padrao,"http://$1/$3/$2.jsp");
        System.out.println(url); // www.xti.com.br/clientes-2011.html
        System.out.println(resultado); // http://www.xti.com.br/2011/clientes.jsp

    }
}
