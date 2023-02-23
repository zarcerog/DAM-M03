package com.zarcero.UF2.ZarceroNicolás_M03_UF2_Examen;

import java.util.Scanner;

public class ZarceroNicolás_exercici1 {
    public static void main(String[] args) {
        start();
    }

    /**
     * Este método se encarga de inicializar el programa.
     */

    public static void start() {
        int option;
        String[] arr = new String[2];

        do {
            System.out.println("Que quieres hacer?\n\t[1] Introducir cadenas de texto\n\t[2] Consultar cadenas de texto\n\t[3] Salir");
            option = isInt("> ", 1, 3);

            switch (option) {
                case 1:
                    arr = introducirCadenas();
                    break;
                case 2:
                    consultarCadenas(arr);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (option != 3);
    }

    /**
     * Este método se encarga de almacenar las cadenas de texto introducidas por el usuario en la matriz.
     * @return La matriz con las cadenas de texto.
     */

    public static String[] introducirCadenas() {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[2];
        String text;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Introduce una cadena de texto:");
            text = scanner.nextLine();
            arr[i] = text;
        }

        return arr;
    }

    /**
     * Este método se encarga de consultar las cadenas de texto introducidas por el usuario.
     * @param arr La matriz con las cadenas de texto a consultar.
     */

    public static void consultarCadenas(String[] arr) {
        boolean cadenas = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.println("ERROR: Introduce las cadenas de carácteres primero!");
                cadenas = false;
                break;
            }
        }

        if (cadenas) {
            String a = arr[0];
            String b = arr[1];

            if (a.equals(b)) {
                System.out.println("La cadena " + a + " y la cadena " + b + " son iguales.");
            } else {
                System.out.println("Las cadenas " + a + " y " + b + " son diferentes.");
            }
        }
    }

    /**
     * Este método se encarga de confirmar que la entrada por teclado es un int
     * @param message El mensaje a mostrar
     * @param min El entero mínimo que se puede indicar
     * @param max El entero máximo que se puede indicar
     * @return El entero
     */
    public static int isInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean isInt;

        do {
            System.out.print(message);
            isInt = scanner.hasNextInt();

            if (!isInt) {
                System.out.println("ERROR: Introduce un valor entero!");
                scanner.nextLine();
            } else {
                number = scanner.nextInt();

                if (number < min || number > max) {
                    System.out.println("ERROR: Introduce un valor entre " + min + " y " + max);
                    scanner.nextLine();
                    isInt = false;
                }
            }
        } while (!isInt);

        return number;
    }
}
