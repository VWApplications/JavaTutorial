package br.com.vwapp.excecoes;

/**
 * TRATAMENTO DE EXCEÇÕES:
 *
 * STACK TRACE: É a pilha de erros, um erro pode começar em uma determinada classe e se propagar para outras classes,
 * com isso você pode tratar o error em outros locais e pode ver todas as mensagens de erro pela qual passou a exceção
 *
 */
public class StackTrace {

    public static void main(String[] args) {

        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException error) {
            error.printStackTrace(); // imprime e pilha de erro encontrada nesse exceção até a linha onde aconteceu o erro.
            System.err.println(error); // java.lang.ArithmeticException: / by zero
            System.err.println(error.getMessage()); // Retorna uma mensagem com a lista de erros no formato string (/ by zero)
        }

    }

}
