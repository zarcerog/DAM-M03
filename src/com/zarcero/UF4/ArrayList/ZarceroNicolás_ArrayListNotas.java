package com.zarcero.UF4.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ZarceroNicolás_ArrayListNotas {
    final static String MENU_PRINCIPAL = "Escoge una opción\n\t[1] Introducir nota\n\t[2] Consultar nota\n\t[3] Eliminar nota\n\t[4] Modificar nota\n\t[5] Consultar todas las notas\n\t[6] Salir";
    static ArrayList<Float> grades = new ArrayList<>();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int option = 0;

        do {
            System.out.println("------ Notas ------");
            System.out.println(MENU_PRINCIPAL);

            option = isInt("> ", 1, 6);

            switch (option) {
                case 1:
                    addGrade(grades);
                    break;
                case 2:
                    consultGrade(grades);
                    break;
                case 3:
                    deleteGrade(grades);
                    break;
                case 4:
                    modifyGrade(grades);
                    break;
                case 5:
                    consultAllGrades(grades);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (option != 6);
    }

    private static void addGrade(ArrayList<Float> grades) {
        float grade = isFloat("Introduce la nota: ", 0, 10);
        grades.add(grade);
    }

    private static void consultGrade(ArrayList<Float> grades) {
        System.out.println("Tienes " + grades.size() + " notas");
        int position = isInt("Introduce la posición de la nota: ", 1, grades.size());
        System.out.println("La nota es: " + grades.get(position - 1));
    }

    private static void deleteGrade(ArrayList<Float> grades) {
        System.out.println("Tienes " + grades.size() + " notas");
        int position = isInt("Introduce la posición de la nota: ", 1, grades.size());
        grades.remove(position - 1);
    }

    private static void modifyGrade(ArrayList<Float> grades) {
        System.out.println("Tienes " + grades.size() + " notas");
        int position = isInt("Introduce la posición de la nota: ", 1, grades.size());
        float grade = isFloat("Introduce la nota: ", 0, 10);
        grades.set(position - 1, grade);
    }

    private static void consultAllGrades(ArrayList<Float> grades) {
        for (int i = 0; i < grades.size(); i++) {
            System.out.println("Nota " + (i + 1) + ": " + grades.get(i));
        }
    }

    private static int isInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean isInt = false;

        do {
            System.out.print(message);

            isInt = scanner.hasNextInt();

            if (isInt) {
                number = scanner.nextInt();

                if (number < min || number > max) {
                    System.out.println("El número debe estar entre " + min + " y " + max);
                    isInt = false;
                }
            } else {
                System.out.println("El valor introducido no es un número");
            }

            scanner.nextLine();
        } while (!isInt);

        return number;
    }

    private static float isFloat(String message, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        boolean isFloat = false;

        do {
            System.out.print(message);

            isFloat = scanner.hasNextFloat();

            if (isFloat) {
                number = scanner.nextFloat();

                if (number < min || number > max) {
                    System.out.println("El número debe estar entre " + min + " y " + max);
                    isFloat = false;
                }
            } else {
                System.out.println("El valor introducido no es un número");
            }

            scanner.nextLine();
        } while (!isFloat);

        return number;
    }
}
