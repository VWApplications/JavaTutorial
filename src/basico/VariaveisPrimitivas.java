package basico;

/*
 * Apresentar os conceitos de variáveis
 * Variável de referencia é toda aquela variável que aponta para um objeto.
 * Variáveis primitivas são aquelas que armazenam um valor
 * Tipos primitivos:
 *  - Bytes: byte
 *  - Números inteiros: short int long
 *  - Números de ponto flutuante: float double
 *  - Caracteres: char
 *  - Nada: void
 *  - Booleanos: boolean
 */
public class VariaveisPrimitivas {

    public static void main(String[] args) {

        char sexo = 'M'; // 16 bit
        boolean x = true; // 1 bit
        boolean y = false; // 1 bit
        byte a = 127; // 8 bits, 127
        short b = 32767; // 16 bits, 32 mil
        int c = 2_147_483_647; // 32 bits, 2 bilhões
        long d = 9_223_372_036_854_775_807L; // 64 bits, 9 quiquelhoes
        float e = 1.203F; // 32 bits
        double f = 1.7976931348623157E+308D; // 64 bits, padrão IEEE 754

        // Representação na forma binária
        byte bb = 0b00000011; // 8 bits ou 1 byte de informação
        System.out.println(bb);


        // Cast implícito
        c = b;
        System.out.println(c);

        // Cast explicito
        long n = 10000;
        c = (int) n;
        System.out.println(c);

        // Variável de referencia que aponta para um objeto String.
        String titulo = "Variáveis e Sintaxe";
        // A partir do momento que a variável aponta para outro objeto
        // o Garbage Collector irá remover a string acima que não está
        // mais sendo referenciada por nenhuma variável.
        // muito bom para liberar memória.
        titulo = "Variáveis de referência";
        // Para limpar a variável, ou seja, não apontar para nenhum objeto.
        titulo = null;

    }
}
