package com.zarcero.UF2.Recursion;

import java.util.Scanner;

public class ZarceroNicolás_Exercici2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();
        System.out.println("La suma de los dígitos es: " + sumarDigitos(numero));
    }

    public static int sumarDigitos(int numero) {
        if (numero < 10) {
            return numero;
        } else {
            return numero % 10 + sumarDigitos(numero / 10);
        }
    }
}
