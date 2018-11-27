package br.com.vwapp.intermediario;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Mathematics {

    public static void main(String[] args) {
        // formatacaoDeNumeros();
        math();
    }

    static void formatacaoDeNumeros() {
        double saldo = 123_456.789;
        System.out.println(saldo); // 123456.789

        // Formata qualquer tipo de número de acordo com sua localização
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(3); // seta o número de casas decimais
        System.out.println(numberFormat.format(saldo)); // 123.456,789

        // Formata número inteiro de acordo com sua localização
        numberFormat = NumberFormat.getIntegerInstance();
        System.out.println(numberFormat.format(saldo)); // 123.456

        // Formata números percentuais de acordo com sua localização
        numberFormat = NumberFormat.getPercentInstance();
        System.out.println(numberFormat.format(0.25)); // 25%

        // Formata dinheiro de acordo com sua localização
        numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println(numberFormat.format(saldo)); // R$ 123.456,79

        // Formata dinheiro de acordo com sua localização (EUA)
        numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(numberFormat.format(saldo)); // $123,456.79

        // Converter número
        NumberFormat numberFormatParser = NumberFormat.getCurrencyInstance();
        try {
            System.out.println(numberFormatParser.parse("R$ 1.100,25")); // 1100.25
        } catch (ParseException e) {}

    }

    static void math() {
        // Constantes
        System.out.println(Math.PI); // PI - 3.141592653589793
        System.out.println(Math.E); // Euler - 2.718281828459045

        System.out.println(Math.sin(10)); // Seno(10) = -0.5440211108893698
        System.out.println(Math.cos(10)); // Coseno(10) = -0.8390715290764524
        System.out.println(Math.tan(45)); // Tangente(45) = 1.6197751905438615
        System.out.println(Math.asin(1)); // Arcoseno(1) = 1.5707963267948966
        System.out.println(Math.acos(1)); // Arcocoseno(1) = 0.0
        System.out.println(Math.atan(10)); // Arcotangente(10) = 1.4711276743037347
        System.out.println(Math.sinh(10)); // SenoHiperbolico() = 11013.232874703393
        System.out.println(Math.cosh(10)); // Coseno Hiperbolico() = 11013.232920103324
        System.out.println(Math.tanh(10)); // Tangente Hiperbolico() = 0.9999999958776927
        System.out.println(Math.exp(2)); // e^2 = 7.38905609893065
        System.out.println(Math.log(10)); // logaritmo natural de 10 = 2.302585092994046
        System.out.println(Math.pow(9, 2)); // 9 ao quadrado = 81
        System.out.println(Math.cbrt(27)); // Raiz cubica de 27 = 3
        System.out.println(Math.sqrt(81)); // Raiz quadrada de 81 = 9
        System.out.println(Math.hypot(6, 8)); // Comprimento da Hipotenuza  de um triangulo retangulo de lados 6 e 8 = 10
        System.out.println(Math.signum(10)); // Sinal de X (1: positivo, -1: negativo e 0:0) = 1
        System.out.println(Math.ceil(10)); // Maior número inteiro próximo de 10 = 10
        System.out.println(Math.floor(10)); // Menor número inteiro próximo de 10 = 10
        System.out.println(Math.round(10.35)); // Número arredondado de 10.35 = 10
        System.out.println(Math.max(10, 5)); // Maior entre os dois números = 10
        System.out.println(Math.min(10, 5)); // Menor entre os dois números = 5
    }
}
