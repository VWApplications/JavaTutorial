package basico;

/*
 * Apresentar os conceitos de variáveis
 *
 * Variável de referencia é toda aquela variável que aponta para um objeto.
 *
 * Variáveis primitivas são aquelas que armazenam um valor
 * Classes Wrappers são empacotadores de (tipos primitivos) e oferecem alguns recursos de conversão para serem
 * utilizados na linguagem java.
 * Tipos primitivos:
 *  - Binarios: byte (Bytes)
 *  - Números inteiros: short (Short), int (Integer), long (Long)
 *  - Números de ponto flutuante: float (Float), double (Double)
 *  - Caracteres: char (Character)
 *  - Nada: void (Void)
 *  - Booleanos: boolean (Boolean)
 *
 *  Documentação: https://docs.oracle.com/javase/10/docs/api/java/lang/package-summary.html
 */
public class Variaveis {

    public static void main(String[] args) {

        char sexo = 'M'; // 16 bit
        boolean verdadeiro = true; // 1 bit
        boolean falso = false; // 1 bit
        byte binario = 127; // 8 bits, 127
        short inteiroPequeno = 32767; // 16 bits, 32 mil
        int inteiro = 2_147_483_647; // 32 bits, 2 bilhões
        long inteiroGrande = 9_223_372_036_854_775_807L; // 64 bits, 9 quiquelhoes
        float pontoFlutuante = 1.203F; // 32 bits
        double pontoFlutuantePrecisaoDupla = 1.7976931348623157E+308D; // 64 bits, padrão IEEE 754

        // Representação na forma binária
        binario = 0b00000011; // 8 bits ou 1 byte de informação
        System.out.println(binario);


        // Cast implícito
        inteiro = inteiroPequeno;
        System.out.println(inteiro);

        // Cast explícito (cuidado para não estourar a memória)
        // int só pode 32 bits enquanto o long pode 64 bits
        inteiroGrande = 10000;
        inteiro = (int) inteiroGrande;
        System.out.println(inteiro);

        // Variável de referencia que aponta para um objeto String.
        String titulo = "Variáveis e Sintaxe";
        // A partir do momento que a variável aponta para outro objeto
        // o Garbage Collector irá remover a string acima que não está
        // mais sendo referenciada por nenhuma variável.
        // muito bom para liberar memória.
        titulo = "Variáveis de referência";
        // Para limpar a variável, ou seja, não apontar para nenhum objeto.
        titulo = null;

        // Criar constantes (não pode ser modificado)
        final double PI = 3.141592;
        final char SEXO_MASCULINO = 'M';
        final char SEXO_FEMININO = 'F';

        // Conversão
        Double wrapper = 200.5;
        System.out.println(wrapper);
        System.out.println(wrapper.intValue());

        pontoFlutuantePrecisaoDupla = Double.parseDouble("695.33");
        System.out.println(pontoFlutuantePrecisaoDupla);

        inteiro = Integer.parseInt("695");
        System.out.println(inteiro);

        // Converte binário para inteiro
        inteiro = Integer.valueOf("101011", 2);
        System.out.println(inteiro); // 43
    }
}
