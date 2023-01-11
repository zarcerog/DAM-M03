package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int litros;
        boolean abrirCompuertas = false;
        System.out.println("Cuantos litros de agua por metro cuadrado?");
        litros = scanner.nextInt();

        if (litros > 90) {
            abrirCompuertas = true;
        }

        if (abrirCompuertas) {
            System.out.println("Compuertas abiertas");
        } else {
            System.out.println("Compuertas cerradas");
        }
    }
}
