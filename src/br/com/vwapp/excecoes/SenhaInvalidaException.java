package br.com.vwapp.excecoes;

/**
 * HIERARQUIA DAS CLASSES DE EXCEPTION:
 *
 * Object
 *  - Throwable (Checked)
 *    - Exception (Checked)
 *      - SQLException
 *      - ClassNotFoundException
 *      - IOException (EOFException, FileNotFoundException, UnknownHostException)
 *      - CriarSuaPropriaException
 *      - Runtime Exception (Unchecked)
 *        - IllegalArgumentException (NumberFormatException)
 *        - ArithmeticException
 *        - IndexOutOfBoundsException (ArrayIndexOutOfBoundsException)
 *        - ClassCastException
 *        - NullPointerException
 *        - NoSuchElementException (NumberFormatException)
 *    - Error (Unchecked)
 *
 * CHECKED: Quando você torna verificada uma exceção, você ta documentando a existência da exceção e assegurando que
 * o invocador do seu método, ou seja, quando seu programa chamar aquele método, ele vai de alguma forma tratar aquela
 * exceção.
 *
 * UNCHECKED: Durante a execução representam condições que refletem erros na lógica do seu programa e não podem ser
 * razoavelmente recuperadas durante a execução. Erros que devem ser corrigidos no código do seu programa.
 *
 * ERROR (Unchecked): São erros que indicam que algo falhou na própria JVM, java virtual machine, ou em uma tentativa da JVM de
 * executar sua aplicação.
 *
 * EXCEPTION (Checked): Classe responsável por criar novas classes de exceções. Ou seja, todas as exceções que vc criar
 * devem herdar de Exception.
 *
 * EXCEÇÔES COMUNS (Unchecked):
 *
 *  - InputMismatchException: Erros de input com tipagem errada, por exemplo, uma string em um inteiro
 *
 *  - ArithmeticException: Divisão por zero
 *
 *  - NullPointerExcetion: Acessar um atributo ou método de um objeto que não existe, por exemplo, o atributo length de
 *  um array.
 *
 *  - ArrayIndexOutOfBoundsException: Tentar acessar uma posição que não existe dentro de um array.
 *
 *  - ClassCastException: Quanto tentar realizar uma conversão de tipos de um objeto para outro e esse objeto não
 *  tem relacionamento de herança (é um) com o outro.
 *  Por exemplo: Animal a = new Galinha() -> OK
 *               Galinha a = new Cachorro() -> FAIL
 *
 *  - NumberFormatException: Quando tenta converter números incompativeis. Por exemplo: int i = Double.parseDouble("a")
 *
 */
public class SenhaInvalidaException extends Exception {

    SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }

}
