package br.com.vwapp.arquivos;

import java.io.IOException;
import java.nio.file.*;

public class Manipulacao {

    public static void main(String[] args) {
        String path = "src/br/com/vwapp/arquivos/IO/";
        Path path1 = Paths.get(path + "simples.txt");
        criarDiretorio(path1);
        criarArquivo(path1);
        printaCaminho(path1);
        copiarArquivo(path);
        removerArquivo(path1);
        moverArquivo(path);
        renomearArquivo(path);

        mostrarRoots();
        mostrarConteudos();
        mostrarParticoes();
    }

    static void printaCaminho(Path path) {
        // Retorna o caminho absoluto (total) do arquivo
        System.out.println(path.toAbsolutePath()); // /home/victorhad/Documents/Codigos/JavaTutorial/src/br/com/vwapp/arquivos/entradas/texto.txt
        // Retorna o diretorio que ta o arquivo
        System.out.println(path.getParent()); // src/br/com/vwapp/arquivos/entradas
        // Retorna a raiz do sistema
        System.out.println(path.getRoot()); // null, porque não especifiquei o / ou C: no path
        // Retorna o nome do arquivo
        System.out.println(path.getFileName()); // texto.txt
        // O caminho existe?
        System.out.println(Files.exists(path)); // true
        // O caminho é um diretorio?
        System.out.println(Files.isDirectory(path)); // false
        // O caminho é um arquivo regular, ou seja, arquivo de texto, imagem, etc...
        System.out.println(Files.isRegularFile(path)); // true
        // O arquivo é legivel pelo usuário da aplicação? (permissões de acesso)
        System.out.println(Files.isExecutable(path)); // false

        try {
            // Qual o tamanho do arquivo?
            System.out.println(Files.size(path)); // 94 bytes

            // Quando foi a ultima modificação?
            System.out.println(Files.getLastModifiedTime(path)); // 2018-11-24T01:48:30.52674Z

            // Quem é o dono do arquivo?
            System.out.println(Files.getOwner(path)); // victorhad

            // Qual o tipo de arquivo?
            System.out.println(Files.probeContentType(path)); // text/plain
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void criarDiretorio(Path path) {
        try {
            Files.createDirectories(path.getParent());
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    static void criarArquivo(Path path) {
        try {
            Files.createFile(path);
            Files.write(path, "Ola mundo!".getBytes());
        } catch(IOException error) { }
    }

    static void copiarArquivo(String path) {
        Path original = Paths.get(path + "simples.txt");
        Path copia = Paths.get(path + "copia.txt");

        try {
            // Copia o arquivo original no copia e substitui caso ele já exista
            Files.copy(original, copia, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    static void moverArquivo(String path) {
        Path origem = Paths.get(path + "copia.txt");
        Path destino = Paths.get(path + "../copia.txt");

        try {
            // Move o arquivo da origem para o destino e substitui caso ele já exista
            Files.move(origem, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    static void renomearArquivo(String path) {
        Path origem = Paths.get(path + "../copia.txt");
        Path destino = Paths.get(path + "copia-renomeada.txt");

        try {
            // Move o arquivo da origem para o destino e substitui caso ele já exista
            Files.move(origem, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    static void removerArquivo(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    // Mostrar as pastas raizes do seu sistema operacional
    static void mostrarRoots() {
        System.out.println();
        Iterable<Path> diretoriosRaiz = FileSystems.getDefault().getRootDirectories();
        for (Path path: diretoriosRaiz) {
            System.out.println(path); // / (Linux)
        }
    }

    // Mostrar os arquivos e diretorios de um determinado caminho
    static void mostrarConteudos() {
        Path path = Paths.get("src/br/com/vwapp/arquivos/");

        try(DirectoryStream<Path> conteudos = Files.newDirectoryStream(path)) {
            for (Path conteudo: conteudos) {
                System.out.println(conteudo.getFileName()); // IO, Conta.java, Entrada.java, Manipulacao.java, Saida.java
            }
        } catch (IOException | DirectoryIteratorException error) {
            error.printStackTrace();
        }
    }

    // Mostrar partições do seu pc
    static void mostrarParticoes() {
        FileSystem fileSystems = FileSystems.getDefault();
        Iterable<FileStore> fileStores = fileSystems.getFileStores();

        System.out.println();
        for (FileStore particao: fileStores) {
            System.out.println("Unidade: " + particao.toString());

            try {
                System.out.println("Total Espaço: " + particao.getTotalSpace() + " bytes");
                System.out.println("Total Espaço Disponível: " + particao.getUsableSpace() + " bytes");
                System.out.println("Total Espaço Utilizado: " + (particao.getTotalSpace() - particao.getUsableSpace()) + " bytes");
            } catch (IOException error) {}
        }
    }
}
