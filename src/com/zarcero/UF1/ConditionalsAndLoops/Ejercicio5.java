package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float precioVW, precioFinal;
        final float PORCENTAJE_KM = 0.00001f;
        int km;
        boolean tipo;

        System.out.println("VW Full Equip? ");
        tipo = scanner.nextBoolean();

        precioVW = tipo ? 93490 : 73490;

        System.out.println("Num KM?");
        km = scanner.nextInt();

        precioFinal = precioVW - (km * PORCENTAJE_KM);
        System.out.printf("\nPrecio final de la VW: %.2f", precioFinal);
    }
}
