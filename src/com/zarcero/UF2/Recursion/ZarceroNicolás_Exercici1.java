package com.zarcero.UF2.Recursion;

import java.util.Scanner;

public class ZarceroNicolás_Exercici1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el dividendo: ");
        int dividendo = scanner.nextInt();
        System.out.print("Introduce el divisor: ");
        int divisor = scanner.nextInt();
        System.out.println("El resultado de la división es: " + division(dividendo, divisor));
    }

    public static int division(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + division(dividendo - divisor, divisor);
        }
    }
}
