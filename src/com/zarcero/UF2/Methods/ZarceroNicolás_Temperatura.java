package com.zarcero.UF2.Methods;

import java.util.Scanner;

public class ZarceroNicolás_Temperatura {
    public static void main(String[] args) {
        mainMenu();
    }

    /**
     * Mostrar menu principal
     */

    public static void mainMenu() {
        int option = 0;

        do {
            System.out.println("1. Convertir de Celsius a Fahrenheit");
            System.out.println("2. Convertir de Fahrenheit a Celsius");
            System.out.println("3. Salir");
            option = isInt("Introduce una opción: ");
            switch (option) {
                case 1:
                    System.out.println("La temperatura en Fahrenheit és: " + celsiusToFahrenheit(isInt("Introduce la temperatura en Celsius: ")));
                    break;
                case 2:
                    System.out.println("La temperatura en Celsius és: " + fahrenheitToCelsius(isInt("Introdueix la temperatura en Fahrenheit: ")));
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no vàlida");
                    break;
            }
        } while (option != 3);
    }

    /**
     * Comprobar si es un numero entero
     * @param message Mensaje a mostrar
     * @return Numero entero
     */

    public static int isInt(String message) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        boolean isInt = false;

        do {
            System.out.println(message);
            isInt = scanner.hasNextInt();

            if (!isInt) {
                System.out.println("ERROR: Valor no entero.");
                scanner.nextLine();
            } else {
                x = scanner.nextInt();
                scanner.nextLine();
            }
        } while (!isInt);

        return x;
    }

    /**
     * Convertir de Celsius a Fahrenheit
     * @param fahrenheit Temperatura en Fahrenheit
     * @return Temperatura en Celsius
     */

    public static float fahrenheitToCelsius(float fahrenheit) {
        float celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }

    /**
     * Convertir de Fahrenheit a Celsius
     * @param celsius Temperatura en Celsius
     * @return Temperatura en Fahrenheit
     */

    public static float celsiusToFahrenheit(float celsius) {
        float fahrenheit = (celsius * 9 / 5) + 32;
        return fahrenheit;
    }
}
