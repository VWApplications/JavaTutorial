package br.com.vwapp.avancado;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

/**
 * Quando você precisa ter uma iteração maior com o sistema operacional, tem essas 2 classes System e Runtime.
 */
public class SistemaOperacional {

    public static void main(String[] args) throws IOException {
        // Recuperar informaçôes do seu sistema operacional
        Properties properties = System.getProperties();

        // Versão do java
        System.out.println(properties.getProperty("java.version")); // 1.8.0_191

        // Definir uma nova versão sua
        properties.setProperty("curso.java.version", "1.0.0");
        System.out.println(properties.getProperty("curso.java.version")); // 1.0.0

        imprimeComandoPrompt("ls");
        executaComandoPrompt("gedit");

        // Verificar todas as propriedades disponiveis
        Set<Object> keys = properties.keySet();
        for (Object key: keys) {
            System.out.println(key + " = " + properties.get(key));
        }
        /* user.country, os.name, file.encoding, java.library.path, os.version, user.home, user.timezone,
        java.class.path, user.name, java.home, user.language, file.separator, line.separator, path.separator,
        os.arch, ...
        */

    }

    static void imprimeComandoPrompt(String comando) throws IOException {
        Process process = Runtime.getRuntime().exec(comando);
        String result = null;

        BufferedReader input = new BufferedReader(
            new InputStreamReader(process.getInputStream())
        );

        BufferedReader error = new BufferedReader(
            new InputStreamReader(process.getErrorStream())
        );

        while ((result = input.readLine()) != null) {
            System.out.println(result); // javadoc, JavaTutorial.iml, out, src
        }

        while ((result = error.readLine()) != null) {
            System.out.println(result);
        }
    }

    static void executaComandoPrompt(String comando) throws IOException {
        Runtime.getRuntime().exec(comando);
    }
}
