package br.com.vwapp.avancado;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Recursividade são métodos que chama a si próprio.
 *
 * 10 + soma(9) = 10 + 45 = 55 (resultado final)
 * 9 + soma(8) = 9 + 36 = 45
 * 8 + soma(7) = 8 + 28 = 36
 * 7 + soma(6) = 7 + 21 = 28
 * 6 + soma(5) = 6 + 15 = 21
 * 5 + soma(4) = 5 + 10 = 15
 * 4 + soma(3) = 4 + 6 = 10
 * 3 + soma(2) = 3 + 3 = 6
 * 2 + soma(1) = 2 + 1 = 3
 * 1 + soma(0) = 1 + 0 = 1
 * 0
 */
public class Recursividade {

    private static int soma(int x) {
        // Critério de parada
        if (x == 0) return 0;

        // Recursividade
        return x + soma(x - 1);
    }

    public static void listar(Path path) {
        // Critério de parada
        if (Files.isRegularFile(path)) {
            System.out.println(path.toAbsolutePath());
        } else {
            String dir = "\n" + path.toAbsolutePath();
            System.out.println(dir.toUpperCase());
            try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path caminho: stream) {
                    listar(caminho); // Recursividade
                }
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        System.out.println(soma(10)); // 55

        Path caminho = Paths.get("src/br/com/vwapp/arquivos");
        listar(caminho);
    }
}
