package intermediario;

/*
 * Rotulo quebra o fluxo aninhado que desejar com break ou continue
 */
public class Rotulo {

    public static void main(String[] args) {

        boolean[][] matrix = {
            {false, true, false, false, false},
            {false, false, false, false, false}
        };




        // SEM ROTULO
        for (int a = 0; a < matrix.length; a++) {
            System.out.print("A ");
            for (int b = 0; b < matrix[a].length; b++) {
                if (matrix[a][b] == true) {
                    System.out.print("TRUE ");
                    break;
                }
                System.out.print("B ");
            }
        }
        System.out.println(); // A B TRUE B B B A B B B B B




        // COM ROTULO
        linha:
        for (int a = 0; a < matrix.length; a++) {
            System.out.print("A ");
            for (int b = 0; b < matrix[a].length; b++) {
                if (matrix[a][b] == true) {
                    System.out.print("TRUE ");
                    break linha;
                }
                System.out.print("B ");
            }
        } // A B TRUE
    }
}
