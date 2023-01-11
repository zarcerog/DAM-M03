package com.zarcero.UF1.Strings;

import java.util.Scanner;

public class StringII_E_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de palabras: ");
        int n = scanner.nextInt();
        String[] palabras = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Introduce la palabra " + (i + 1) + ": ");
            palabras[i] = scanner.next();
        }

        int max = 0;
        String palabra = "";

        for (int i = 0; i < n; i++) {
            if (palabras[i].length() > max) {
                max = palabras[i].length();
                palabra = palabras[i];
            }
        }

        System.out.println("La paraula més llarga és " + palabra + " amb " + max + " caràcters.");
    }
}
