package br.com.vwapp.excecoes;

/**
 * TRATAMENTO DE EXCEÇÕES:
 *
 * THROWS: Especifica todas as exceções que um método pode lançar para que esse método possa ser tratado
 * dentro de um Try Catch. Muito usado quando cria novas exceções que não existe e você precisa disparar ele
 * em alguma situação.
 *
 */
public class Throws {

    static void autenticar(String senha) throws SenhaInvalidaException {
        if ("12345".equals(senha)) {
            System.out.println("Usuário autenticado!");
        } else {
            throw new SenhaInvalidaException("Senha Incorreta!");
        }
    }

    public static void main(String[] args) {

        try {
            autenticar("errado");
        } catch (SenhaInvalidaException error) {
            error.printStackTrace();
            System.err.println(error.getMessage()); // Senha Incorreta!
        }

    }
}
