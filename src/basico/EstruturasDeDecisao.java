package basico;

/*
 * Estruturas de decisão servem para executar algo dependendo de uma condição passada.
 */
public class EstruturasDeDecisao {

    public static void main(String[] args) {

        // If Else
        int idade = 16;
        if (idade <= 11) {
            System.out.println("Criança");
            if (idade < 5) { System.out.println("Bebê"); }
        } else if (idade > 11 && idade <= 18) {
            System.out.println("Adolecente"); // Entra aqui
        } else if (idade > 18 && idade <= 60) {
            System.out.println("Adulto");
        } else {
            System.out.println("Velho");
        }


        // Velocidade superior ao do if
        // Porém só faz comparação de ==
        // Switch
        char sexo = 'M';
        switch (sexo) {
            case 'F':
                System.out.println("Feminino");
                break;
            case 'M':
                System.out.println("Masculino"); // Entra aqui
                break;
            default:
                System.out.println("Indeciso");
        }
    }
}
