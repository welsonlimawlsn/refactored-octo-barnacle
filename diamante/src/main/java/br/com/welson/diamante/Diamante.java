package br.com.welson.diamante;

import java.util.Arrays;
import java.util.List;

public class Diamante {

    static List<String> letras = Arrays.asList("a", "b", "c", "d", "e", "f");

    public static void main(String[] args) {

        diamante("d");
    }

    private static void diamante(String letra) {
        int letraInicial = letras.indexOf(letra);

        int espacosAposLetra = 0;

        for (int proximaLetra = letraInicial; proximaLetra >= 0; proximaLetra--) {
            imprimeLinha(letraInicial, espacosAposLetra, proximaLetra);
            espacosAposLetra = espacosAposLetra == 0 ? 1 : espacosAposLetra + 2;
        }
        espacosAposLetra -= 2;
        for (int proximaLetra = 0; proximaLetra <= letraInicial; proximaLetra++) {
            imprimeLinha(letraInicial, espacosAposLetra, proximaLetra);
            espacosAposLetra = espacosAposLetra == 1 ? 0 : espacosAposLetra - 2;
        }
    }

    private static void imprimeLinha(int letraInicial, int espacosAposLetra, int proximaLetra) {
        for (int i = 0; i <= proximaLetra; i++) {
            System.out.print(i == proximaLetra ? letras.get(proximaLetra) : " ");
        }
        if (letraInicial != proximaLetra) {
            for (int e = 0; e < espacosAposLetra; e++) {
                System.out.print(" ");
            }
            System.out.print(letras.get(proximaLetra));
        }
        System.out.println();
    }

}
