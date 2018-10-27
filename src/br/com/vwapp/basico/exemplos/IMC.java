package br.com.vwapp.basico.exemplos;

import javax.swing.JOptionPane;

/*
 * Calula o indice de massa corporal (IMC)
 * IMC = peso / (altura * altura) kg/m
 */
public class IMC {

    public static void main(String[] args) {
        System.out.println("Calculo do IMC");

        String entradaPeso = JOptionPane.showInputDialog("Qual o seu peso em kg?");
        String entradaAltura = JOptionPane.showInputDialog("Qual o sua altura em metros?");

        double peso = Double.parseDouble(entradaPeso);
        double altura = Double.parseDouble(entradaAltura);
        double imc = peso / (altura * altura);

        System.out.println("IMC = " + imc + " kg/m");

        String mensagem = "Fora do peso";
        if (imc >= 20 && imc <= 25) {
            mensagem = "Peso ideal";
        }

        JOptionPane.showMessageDialog(null, mensagem);

    }
}
