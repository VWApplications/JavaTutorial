package br.com.vwapp.arquivos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Saída de dados do programa (Write)
 * programa escreve os dados (OutputStream)
 * Biblioteca: I/O (vários tipos de streams)
 *
 * Permite armazenar os dados nas unidades de armazenamento de longo prazo de seu computador, por exemplo, seu HD.
 * Preserva essas informações mesmo depois que seu pc for desligado
 * O seu programa escreve/ler streams de dados nessas unidades de armazenamento, ou seja, sequências ordenadas de dados
 * que possui uma origem e/ou um destino
 * Buffer = Repositório de dados na memória do pc
 */
public class Saida {

    public static void main(String[] args) {
        String path = "src/br/com/vwapp/arquivos/IO/";

        Path path1 = Paths.get(path + "texto.txt");
        escreverArquivoComplexo(path1);

        Path path2 = Paths.get(path + "contas.txt");
        escreverArquivoDeContas(path2);
    }

    static void escreverArquivoComplexo(Path path) {
        Charset charset = StandardCharsets.UTF_8;

        // Inicializa o buffer no própria try, isso permite que o buffer seja fechado automaticamente (Java 7+)
        // Isso se da em qualquer classe que implemente a interface Closeable (BufferedWriter, Writer, Closeable)
        try(BufferedWriter buffer = Files.newBufferedWriter(path.toAbsolutePath(), charset)) {
            // Escreve no arquivo
            buffer.write("Ola mundo muito doido!\n");
            buffer.write("Meu nome é zé pequeno\n");
            buffer.write("Vim para causar discordia entre os coleguinhas.");
            // Pega todos os textos da memória e grava no HD (só usar se escrever muitas linhas)
            // pq ao fechar ele salva automaticamente.
            buffer.flush();
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    static void escreverArquivoDeContas(Path path) {
        ArrayList<Conta> contas = new ArrayList<>();
        Conta c1 = new Conta("Pedro", 1500);
        contas.add(c1);
        Conta c2 = new Conta("Mario", 3000);
        contas.add(c2);
        Conta c3 = new Conta("João", 5750);
        contas.add(c3);

        Charset charset = StandardCharsets.UTF_8;

        try(BufferedWriter buffer = Files.newBufferedWriter(path.toAbsolutePath(), charset)) {
            for (Conta conta: contas) {
                buffer.write(conta.getCliente() + ": " + conta.getSaldo() + "\n");
            }
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    static void escreverArquivoSimples(Path path) {
        byte[] texto = "Ola mundo!".getBytes();
        try {
            // Criar um arquivo, abre ele, escreve nele e fecha o arquivo (write).
            Files.write(path.toAbsolutePath(), texto);
        } catch(IOException error) {
            System.out.println("Não conseguiu criar o arquivo!");
        }
    }

    static void escreverArquivoComplexoModoSujo(Path path) {
        Charset charset = StandardCharsets.UTF_8;
        BufferedWriter buffer = null;

        try {
            // Cria um repositório de dados em memória
            buffer = Files.newBufferedWriter(path.toAbsolutePath(), charset);
            // Escreve no arquivo
            buffer.write("Ola mundo muito doido!\n");
            buffer.write("Meu nome é zé pequeno\n");
            buffer.write("Vim para causar discordia entre os coleguinhas.");
            buffer.flush(); // Pega todos os textos da memória e grava no HD
        } catch(IOException error) {
            error.printStackTrace();
        } finally {
            if(buffer != null) {
                try {
                    buffer.close(); // Fecha o buffer mesmo que der erro.
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        }
    }
}
