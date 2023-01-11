package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroVentas;
        float precioFinal = 0, salarioBase;

        System.out.print("Indica tu salario: ");
        salarioBase = scanner.nextFloat();

        System.out.print("Num de ventas: ");
        numeroVentas = scanner.nextInt();

        for (int i = 0; i < numeroVentas; i++) {
            System.out.println("Escribe el coste del " + (i + 1) + " coche");
            float precioCoche = scanner.nextFloat();
            precioFinal += precioCoche * 0.1;
        }

        salarioBase += precioFinal;

        System.out.println("Total en comisiones: " + precioFinal);
        System.out.println("Total sueldo: " + salarioBase);
    }
}
