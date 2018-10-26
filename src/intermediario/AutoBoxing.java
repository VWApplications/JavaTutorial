package intermediario;

/*
 * Empacota e Desempacota um código - teoria de versões do java
 */
public class AutoBoxing {

    public static void main(String[] args) {

        // Antes da versão 5 do java
        Integer x = new Integer(555); // Empacotar
        int y = x.intValue(); // Desempacotar
        y++; // Incrementar
        x = new Integer(y); // Re-empacotar
        System.out.println(x.intValue()); // Desempacotar e Imprimir - 556

        // Versão atual
        Integer a = 555; // Empacotar
        a++; // Desempacotar, Incrementar, Re-empacotar
        System.out.println(a); // Desempacotar e Imprimir - 556

    }
}
