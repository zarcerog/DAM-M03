package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int salarioInicial = 1250;
        int nHoras;
        boolean expuesto;

        System.out.println("Cuantas horas has trabajado extra? ");
        nHoras = scanner.nextInt();
        System.out.println("Ha estado expuesto alcobi? ");
        expuesto = scanner.nextBoolean();

        salarioInicial = expuesto ? salarioInicial + 250 : salarioInicial;

        if (expuesto) {
            if (nHoras <= 5) {
                salarioInicial += nHoras * 20;
            } else {
                int finalHoras = nHoras - 5;
                salarioInicial += (20 * 5) + (finalHoras * 17);
            }
        } else {
            if (nHoras <= 5) {
                salarioInicial += nHoras * 15;
            } else {
                int finalHoras = nHoras - 5;
                salarioInicial += (15 * 5) + (finalHoras * 12);
            }
        }

        System.out.printf("\nSueldo final %s€", salarioInicial);
    }
}
