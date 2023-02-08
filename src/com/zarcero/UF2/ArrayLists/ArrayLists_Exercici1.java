package com.zarcero.UF2.ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists_Exercici1 {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        ArrayList<Float> grades = new ArrayList<>();
        int option;

        do {
            System.out.println("Que quieres hacer?");
            System.out.println("\t[1] Añadir una nota\n\t[2] Consultar nota\n\t[3] Eliminar una nota\n\t[4] Modificar una nota\n\t[5] Salir");
            option = isInt("> ", 1, 5);

            switch (option) {
                case 1:
                    addGrade(grades);
                    break;
                case 2:
                    searchGrade(grades);
                    break;
                case 3:
                    removeGrade(grades);
                    break;
                case 4:
                    modifyGrade(grades);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (option != 5);
    }

    public static void addGrade(ArrayList<Float> grades) {
        float grade = isFloat("Introduce la nota: ", 0, 10);
        grades.add(grade);
    }

    public static void searchGrade(ArrayList<Float> grades) {
        int index = isInt("Introduce el índice de la nota a consultar (min - " + 0 + " / max - " + (grades.size() - 1) + "): ", 0, grades.size() - 1);
        System.out.println("La nota en el index " + index + " es: " + grades.get(index));
    }

    public static void removeGrade(ArrayList<Float> grades) {
        int index = isInt("Introduce el índice de la nota a eliminar (min - " + 0 + " / max - " + (grades.size() - 1) + "): ", 0, grades.size() - 1);
        System.out.println("La nota en el index " + index + " es: " + grades.get(index));
        System.out.println("Estas seguro de que quieres eliminarla? (s/n)");
        String answer = isString("> ");

        if (answer.equalsIgnoreCase("s")) {
            grades.remove(index);
        } else {
            System.out.println("No se ha eliminado la nota.");
        }
    }

    public static void modifyGrade(ArrayList<Float> grades) {
        int index = isInt("Introduce el índice de la nota a modificar (min - " + 0 + " / max - " + (grades.size() - 1) + "): ", 0, grades.size() - 1);
        System.out.println("La nota en el index " + index + " es: " + grades.get(index));
        System.out.println("Estas seguro de que quieres modificarla? (s/n)");
        String answer = isString("> ");

        if (answer.equalsIgnoreCase("s")) {
            float grade = isFloat("Introduce la nueva nota: ", 0, 10);
            grades.set(index, grade);
        } else {
            System.out.println("No se ha modificado la nota.");
        }
    }

    public static int isInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean isInt = false;

        do {
            System.out.print(message);

            isInt = scanner.hasNextInt();

            if (isInt) {
                number = scanner.nextInt();
                scanner.nextLine();

                if (number > max || number < min) {
                    System.out.println("Error: Debes introducir un número entre " + min + " y " + max + ".");
                    isInt = false;
                }
            } else {
                System.out.println("Error: Debes introducir un número entero.");
                scanner.nextLine();
            }
        } while (!isInt);

        return number;
    }

    public static float isFloat(String message, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        boolean isFloat = false;

        do {
            System.out.print(message);

            isFloat = scanner.hasNextFloat();

            if (isFloat) {
                number = scanner.nextFloat();
                scanner.nextLine();

                if (number > max || number < min) {
                    System.out.println("Error: Debes introducir un número entre " + min + " y " + max + ".");
                    isFloat = false;
                }
            } else {
                System.out.println("Error: Debes introducir un número.");
                scanner.next();
            }
        } while (!isFloat);

        return number;
    }

    public static String isString(String message) {
        Scanner scanner = new Scanner(System.in);
        String x = "";
        boolean isString;

        do {
            System.out.print(message);
            isString = scanner.hasNext();

            if (!isString) {
                System.out.println("ERROR.");
                scanner.nextLine();
            } else {
                x = scanner.next();
                scanner.nextLine();
            }
        } while (!isString);

        return x;
    }
}
