package br.com.vwapp.avancado;

/**
 * BREAKPOINTS: Ao dar um clique na lateral esquerda do seu código (onde está o número das linhas) irá criar
 * um ponto vermelho, esse ponto é um breakpoint na qual irá iniciar o debug do código. Ou seja, é o ponto de
 * partida é por onde começamos a análisar o código da nossa aplicação.
 *
 * Para entrar no modo debug clica no icone de uma joaninha ao lado do icone de executar.
 *
 * Se clicar com o botão direito do mouse sobre o breakpoint você pode mexer nas propriedades do breakpoints,
 * por exemplo, criar condições e etc...
 *
 * EXCEPTION BREAKPOINT: É uma propriedade do breakpoint para monitorar um exceção
 *
 * ABA VARIABLES: Apresenta a relação de variáveis dentro do método que você está analisando.
 * STEP OVER: Percorre linha a linha, independente da instrução dentro do seu código.
 * STEP INTO: Entra dentro de um método
 * STEP OUT: Sai de dentro de um método
 */
public class Debug {

    public int raiz(int numero) {
        int raiz = 0, impar = 1;

        while(numero >= impar) {
            numero -= impar;
            impar += 2;
            ++raiz;
        }

        return raiz;
    }

    public static void main(String[] args) {

        int numero = 16;
        Debug exemplo = new Debug();
        int raiz = exemplo.raiz(numero);

        if (raiz == 4) {
            System.out.println("Raiz correta!");
        }
    }
}
