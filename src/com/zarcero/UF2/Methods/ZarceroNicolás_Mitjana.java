package com.zarcero.UF2.Methods;

import java.util.Scanner;

public class ZarceroNicolás_Mitjana {

    /*
    Colores para la consola
     */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        menu();
    }

    /**
     * Muestra un menú con las opciones de añadir notas, calcular la media, comprobar si está aprobado y salir.
     */

    public static void menu() {

        boolean isTrue = false;

        int num = isInt("¿Cuántas notas quieres introducir?\n" + ANSI_CYAN + "> " + ANSI_RESET);

        float[] grades = new float[num];

        while (!isTrue) {
            System.out.println("--------------------");
            System.out.println(ANSI_GREEN + "\t[1]" + ANSI_RESET + " Añadir notas");
            System.out.println(ANSI_GREEN + "\t[2]" + ANSI_RESET + " Calcular media");
            System.out.println(ANSI_GREEN + "\t[3]" + ANSI_RESET + " Comprobar aprobado");
            System.out.println(ANSI_GREEN + "\t[4]" + ANSI_RESET + " Salir");
            System.out.println("--------------------");

            int option = isInt("Elige una opción\n" + ANSI_CYAN + "> " + ANSI_RESET);

            switch (option) {
                case 1:
                    addGrades(grades);
                    break;
                case 2:
                    System.out.println(average(grades));
                    break;
                case 3:
                    System.out.println(checkApproved(grades));
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    isTrue = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    /**
     * Añade las notas al array.
     * @param grades Array de notas.
     */

    public static void addGrades(float[] grades) {
        for (int i = 0; i < grades.length; i++) {
            float grade = isFloat(ANSI_CYAN + "Introduce la nota " + (i + 1) + ": " + ANSI_RESET);

            if (grade >= 0 && grade <= 10) {
                grades[i] = grade;
            } else {
                System.out.println(ANSI_RED + "La nota debe estar entre 0 y 10." + ANSI_RESET);
                i--;
            }
        }
    }

    /**
     * Calcula la media de las notas.
     * @param grades Array de notas.
     * @return Media de las notas.
     */

    public static float average(float[] grades) {
        float sum = 0;

        for (float grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }

    /**
     * Comprueba si está aprobado o suspendido.
     * @param grades Array de notas.
     * @return Aprobado o suspendido.
     */

    public static String checkApproved(float[] grades) {
        float average = average(grades);

        if (average >= 5) {
            return "Aprobado";
        }

        return "Suspendido";
    }

    /**
     * Comprueba si el valor introducido es un número entero.
     * @param message Mensaje que se muestra al usuario.
     * @return Número entero.
     */

    public static int isInt(String message) {
        Scanner scanner = new Scanner(System.in);

        int num = 0;
        boolean isInt;

        do {
            System.out.print(message);
            isInt = scanner.hasNextInt();

            if (isInt) {
                num = scanner.nextInt();
            } else {
                System.out.println(ANSI_RED + "No has introducido un número entero." + ANSI_RESET);
                scanner.next();
            }
        } while (!isInt);

        return num;
    }

    /**
     * Comprueba si el valor introducido es un número decimal.
     * @param message Mensaje que se muestra al usuario.
     * @return Número decimal.
     */

    public static float isFloat(String message) {
        Scanner scanner = new Scanner(System.in);

        float num = 0;
        boolean isFloat;

        do {
            System.out.print(message);
            isFloat = scanner.hasNextFloat();

            if (isFloat) {
                num = scanner.nextFloat();
            } else {
                System.out.println(ANSI_RED + "No has introducido un número decimal." + ANSI_RESET);
                scanner.next();
            }
        } while (!isFloat);

        return num;
    }

}
