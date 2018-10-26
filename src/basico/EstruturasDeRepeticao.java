package basico;

/*
 * Estruturas de repetição serve para executar um ou mais comandos N vezes
 */
public class EstruturasDeRepeticao {

    public static void main(String[] args) {

        // FOR INCREMENTAR
        // inicialização (i=0); verificação i<3; { ação }; atualização (i++)
        for (int i=1; i<=3; i++) {
            System.out.print(i);
        }
        System.out.println(); // 123




        // FOR DECREMENTAR
        for (int i=3; i>=1; i--) {
            System.out.print(i);
        }
        System.out.println(); // 321




        // FOR ANINHADO
        for (int x=0; x<5; x++) {
            for(int y=0; y<5; y++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *




        // FOREACH (só percorre para frente e não tem acesso ao indice)
        Integer[] idades = {1, 2, 3, 4, 5};
        for (Integer idade: idades) {
            System.out.print(idade);
        }
        System.out.println(); // 12345




        // WHILE INCREMENTAR (executa 0 ou mais vezes: 0-N)
        int i = 0;
        while (i <= 3) {
            System.out.print(i);
            i++;
        }
        System.out.println(); // 0123




        // WHILE DECREMENTAR
        int j = 3;
        while (j >= 0) {
            System.out.print(j);
            j--;
        }
        System.out.println(); // 3210




        // WHILE ANINHADO
        int x = 0;
        while (x < 5) {
            int y = 0;
            while (y < 5) {
                System.out.print("* ");
                y++;
            }
            System.out.println();
            x++;
        }
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *




        // DO WHILE (executa 1 ou mais vezes: 1-N)
        i = 4;
        do {
            System.out.println(i);
            i++;
        } while (i <= 3); // 4




        // BREAK
        i = 1;
        while(true) {
            System.out.print("* ");
            if (i == 4) break;
            i++;
        }
        System.out.println(); // * * * *




        // CONTINUE (numeros pares)
        for (int k = 0; k<10; k++) {
            if (k % 2 != 0) continue;
            System.out.print(k);
        } // 02348
    }
}
