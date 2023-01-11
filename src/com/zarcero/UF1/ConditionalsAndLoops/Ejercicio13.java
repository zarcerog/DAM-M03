package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        final float costCoffee = 0.5f;
        
        while (isTrue) {
            System.out.print("Introduce monedas: ");
            float amount = scanner.nextFloat();
            System.out.print("Escoge una opción: ");
            int answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    if (amount >= costCoffee) {
                        System.out.println("Preparando cafe...");
                        if (amount > costCoffee) {
                            System.out.println("Devolviendo sobrante ... " + (amount - costCoffee));
                        }
                    } else {
                        System.out.println("No has introducido suficientes monedas ...");
                    }
                    isTrue = false;
                    break;
                case 2:
                    if (amount >= costCoffee) {
                        System.out.println("Preparando cortado...");
                        if (amount > costCoffee) {
                            System.out.println("Devolviendo sobrante ... " + (amount - costCoffee));
                        }
                    } else {
                        System.out.println("No has introducido suficientes monedas ...");
                    }
                    isTrue = false;
                    break;
                case 3:
                    if (amount >= costCoffee) {
                        System.out.println("Preparando cafe con leche...");
                        if (amount > costCoffee) {
                            System.out.println("Devolviendo sobrante ... " + (amount - costCoffee));
                        }
                    } else {
                        System.out.println("No has introducido suficientes monedas ...");
                    }
                    isTrue = false;
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    isTrue = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta ...");
                    break;
            }
        }
    }
}
