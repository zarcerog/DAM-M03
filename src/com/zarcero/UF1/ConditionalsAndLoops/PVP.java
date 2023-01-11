package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class PVP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final float PVP = 1.21f;
        boolean isType = false;
        float precio = 0;

        do {
            System.out.print("Introduce un precio: ");
            if (!scanner.hasNextFloat()) {
                scanner.nextLine();
                System.out.println("Num incorrecto");
            } else {
                precio = scanner.nextFloat();
                isType = true;
            }
        } while (!isType);

        precio *= PVP;

        System.out.printf("Precio con PVP %.2f", precio);
    }
}
