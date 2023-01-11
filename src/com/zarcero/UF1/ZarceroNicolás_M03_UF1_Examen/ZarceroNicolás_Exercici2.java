package com.zarcero.UF1.ZarceroNicolás_M03_UF1_Examen;

import java.util.Scanner;

public class ZarceroNicolás_Exercici2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false, salir = false, existe = false;
        int numMatriculas = 0, opcion = 0;

        do {
            System.out.println("Quantes matrícules vols introduir?");
            valid = scanner.hasNextInt();

            if (valid) {
                numMatriculas = scanner.nextInt();
            } else {
                System.out.println("ERROR! Has d'introduir un número enter de matricules!\n");
            }

            scanner.nextLine();
        } while (!valid);

        int[] arr = new int[numMatriculas];
        valid = false;

        do {
            do {
                System.out.println("Que vols fer?\n\t1. Inscriure una matrícula nova\n\t2. Comprovar si una matrícula existeix\n\t3. Sortir");
                valid = scanner.hasNextInt();

                if (valid) {
                    opcion = scanner.nextInt();
                } else {
                    System.out.println("ERROR! Has d'introduir un número entre 1 i 3!\n");
                }

                scanner.nextLine();
            } while (!valid);

            switch (opcion) {
                case 1:
                    valid = false;
                    int matricula = 0;
                    do {
                        System.out.println("Introdueix la matrícula:");
                        valid = scanner.hasNextInt();

                        if (valid) {
                            matricula = scanner.nextInt();
                        } else {
                            System.out.println("ERROR! Has d'introduir un número enter!\n");
                        }

                        scanner.nextLine();
                    } while (!valid);

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == 0) {
                            arr[i] = matricula;
                            break;
                        }
                    }
                    break;
                case 2:
                    valid = false;
                    int matriculaABuscar = 0;
                    do {
                        System.out.println("Introdueix la matrícula a buscar:");
                        valid = scanner.hasNextInt();

                        if (valid) {
                            matriculaABuscar = scanner.nextInt();
                        }
                    } while (!valid);

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == matriculaABuscar) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("La matrícula " + matriculaABuscar + " existeix.\n");
                    } else {
                        System.out.println("La matrícula no existeix!\n");
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("ERROR! Has d'introduir un número entre 1 i 3!\n");
                    break;
            }
        } while (!salir);
    }
}
