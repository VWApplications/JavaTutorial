package basico;

/*
 * Operador unário: -5
 * Operador binário: 2 + 3
 * Operador ternário: true ? "sim" : "não"
 */
public class Operadores {

    public static void main(String[] args) {

        // Operador unário + e -
        System.out.println(10); // +10
        System.out.println(-10); // -10
        System.out.println(-(-10)); // 10
        System.out.println();


        // Operadores matemáticos
        System.out.println(10 + 20); // 30 (adição)
        System.out.println(10 - 2); // 8 (subtração)
        System.out.println(10 * 2); // 20 (multiplicação)
        System.out.println(10 / 2); // 5 (divisão)
        System.out.println(10 % 3); // 1 (resto da divisão ou modulo)
        System.out.println(-5 - 10); // -15 (subtração de negativos)
        System.out.println(7 - 4 + 3 * 2); // 9 (ordem: parenteses, multiplicação, divisão, adição, subtracao)
        System.out.println();


        // Operadores ternários
        int idade = 15;
        System.out.println(idade > 18 ? "Maior de idade" : "Menor de idade"); // Menor de idade


        // Concatenar Strings
        System.out.println("Ola" + " " + "Mundo"); // Ola mundo
        System.out.println();


        // Operadores de Atribuição
        int b = 10;
        System.out.println(b += 5); // b = b + 5 = 15
        System.out.println(b -= 2); // b = b - 2 = 13
        System.out.println(b *= 3); // b = b * 3 = 39
        System.out.println(b %= 7); // b = b % 7 = 4
        System.out.println(b /= 2); // b = b / 2 = 2
        System.out.println();


        // Incremento
        int a = 0;
        System.out.println(a); // 0
        System.out.println(a++); // 0 - imprimiu depois incrementou (a = a + 1)
        System.out.println(a); // 1
        System.out.println(++a); // 2 - incrementou depois imprimiu (a = a + 1)
        System.out.println(a); // 2
        System.out.println(a--); // 2 - imprimiu depois decrementou (a = a - 1)
        System.out.println(a); // 1
        System.out.println(--a); // 0 - decrementou depois imprimiu (a = a - 1)
        System.out.println();


        // Operadores de Comparação
        System.out.println(10 > 3); // true (maior)
        System.out.println(5 < 9); // true (menor)
        System.out.println(10 >= 10); // true (maior ou igual)
        System.out.println(10 <= 9); // false (menor ou igual)
        System.out.println(10 == 10); // true (igual)
        System.out.println(10 != 8); // true (diferente)
        System.out.println("oii" instanceof String); // true (é instance de)
        System.out.println();


        // Operadores Lógicos
        System.out.println(10 > 3 && 5 < 9); // true (AND ou E)
        System.out.println(10 > 3 || 5 == 9); // true (OR ou OU)
        System.out.println(!true); // false (NOT ou NEGAÇÃO)
        System.out.println();


        // Operadores bit-a-bit (bitwise)
        // & &= (AND)
        // | |= (OR)
        // ^ ^| (XOR)
        // ~ (NOT)
        // <<= >>= >>>= (Movimentação de bits)


        // Operadores especiais
        // ?:       Operador Ternário
        // ,        Separação de Expressão
        // ()       Chamada de método
        // (cast)   Coerção Unária
    }
}
