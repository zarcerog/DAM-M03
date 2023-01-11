package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dias, precioFinal;
        boolean tarde, desayuno;

        System.out.println("Num de dias");
        dias = scanner.nextInt();
        System.out.println("+ tarde de las 12h?");
        tarde = scanner.nextBoolean();
        System.out.println("Quieres desayunar y comer?");
        desayuno = scanner.nextBoolean();

        if (tarde) {
            precioFinal = desayuno ? ((dias - 1) * 20) + 15 + dias * 20 : ((dias - 1) * 20) + 15;
        } else {
            precioFinal = desayuno ? dias * 20 : dias * 20 + dias * 20;
        }

        System.out.println("Precio final " + precioFinal);
    }
}
