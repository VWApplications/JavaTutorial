package br.com.vwapp.arquivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Entrada de dados no programa (Read)
 * Programa lê os dados (InputStream)
 * Biblioteca: I/O
 *
 * O seu programa escreve/ler streams de dados nessas unidades de armazenamento, ou seja, sequências ordenadas de dados
 * que possui uma origem e/ou um destino
 *
 */
public class Entrada {

    public static void main(String[] args) {
        String path = "src/br/com/vwapp/arquivos/IO/";

        // Pega um arquivo que ta em um determinado caminho (path) - Java 7+
        Path path1 = Paths.get(path + "texto.txt");
        lerArquivoSimples(path1);
        lerArquivoComplexo(path1);

        Path path2 = Paths.get(path + "contas.txt");
        lerArquivoContas(path2);
    }

    static void lerArquivoSimples(Path path) {
        try {
            byte[] arquivo = Files.readAllBytes(path.toAbsolutePath());
            String conteudo = new String(arquivo);
            System.out.println(conteudo); // Imprime todos os textos do arquivo
        } catch(IOException error) {
            System.out.println("Não conseguiu ler o arquivo!");
        }
    }

    static void lerArquivoComplexo(Path path) {
        Charset charset = StandardCharsets.UTF_8;

        // Inicializa o buffer no própria try, isso permite que o buffer seja fechado automaticamente (Java 7+)
        // Isso se da em qualquer classe que implemente a interface Closeable (BufferedReader, Writer, Closeable)
        // Fará a mesma coisa do método acima, porém de forma implicita.
        try(BufferedReader buffer = Files.newBufferedReader(path.toAbsolutePath(), charset)) {
            String line = null;

            // Retorna as linhas do arquivo uma por uma até essa linha ser null
            while ((line = buffer.readLine()) != null) {
                System.out.println(line); // Imprime linha por linha do arquivo
            }
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    static void lerArquivoContas(Path path) {
        Charset charset = StandardCharsets.UTF_8;
        ArrayList<Conta> contas = new ArrayList<>();

        try(BufferedReader buffer = Files.newBufferedReader(path.toAbsolutePath(), charset)) {
            String line = null;

            // Retorna as linhas do arquivo uma por uma até essa linha ser null
            while ((line = buffer.readLine()) != null) {
                String[] dados = line.split(": ");
                Conta conta = new Conta(dados[0], Double.parseDouble(dados[1]));
                contas.add(conta);
            }
        } catch(IOException error) {
            error.printStackTrace();
        }

        for (Conta conta: contas) {
            conta.exibeSaldo();
        }
    }
}
