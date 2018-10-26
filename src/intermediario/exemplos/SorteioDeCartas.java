package intermediario.exemplos;

import java.util.Random;

public class SorteioDeCartas {

    public static void main(String[] args) {

        String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei"};
        String[] nipes = {"Espadas", "Paus", "Copas", "Ouros"};

        Random random = new Random();

        int indiceAleatorioFace = random.nextInt(faces.length);
        String face = faces[indiceAleatorioFace];

        int indiceAleatorioNipe = random.nextInt(nipes.length);
        String nipe = nipes[indiceAleatorioNipe];

        String carta = face + " de " + nipe;
        System.out.println(carta);
    }
}
