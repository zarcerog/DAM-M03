package com.zarcero.UF1.ZarceroNicolás_M03_UF1_Examen;

import java.util.Scanner;

public class ZarceroNicolás_Exercici3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] grupoE = new int[4][7];
        boolean salir = false, valid = false;
        int opcion = 0;

        grupoE[0][0] = 2;
        grupoE[1][0] = 2;
        grupoE[2][0] = 2;
        grupoE[3][0] = 2;

        grupoE[0][1] = 1;
        grupoE[1][1] = 1;
        grupoE[2][1] = 1;
        grupoE[3][1] = 0;

        grupoE[0][2] = 1;
        grupoE[1][2] = 0;
        grupoE[2][2] = 0;
        grupoE[3][2] = 1;

        grupoE[0][3] = 0;
        grupoE[1][3] = 1;
        grupoE[2][3] = 1;
        grupoE[3][3] = 1;

        grupoE[0][4] = 4;
        grupoE[1][4] = 3;
        grupoE[2][4] = 3;
        grupoE[3][4] = 1;

        grupoE[0][5] = 8;
        grupoE[1][5] = 2;
        grupoE[2][5] = 1;
        grupoE[3][5] = 2;

        grupoE[0][6] = 1;
        grupoE[1][6] = 2;
        grupoE[2][6] = 7;
        grupoE[3][6] = 3;

        do {
            do {
                System.out.println("\nQue vols fer?\n\t1. Mostrar punts d'un equip\n\t2. Gol average de cada equip\n\t3. Mostrar recompte de gols a favor marcats en total entre tots els equips\n\t4. Sortir");
                valid = scanner.hasNextInt();

                if (valid) {
                    opcion = scanner.nextInt();
                } else {
                    System.out.println("ERROR! Has d'introduir un numero entre 1 i 4!\n");
                }

                scanner.nextLine();
            } while (!valid);

            switch (opcion) {
                case 1:
                    opcion = 0;
                    valid = false;

                    do {
                        System.out.println("\nDe quin equip vols mirar els punts?\n\t0. Spain\n\t1. Japan\n\t2. Costa Rica\n\t3. Germany");
                        valid = scanner.hasNextInt();

                        if (valid) {
                            opcion = scanner.nextInt();
                        } else {
                            System.out.println("ERROR! Has d'introduir un numero entre 0 i 3!\n");
                        }
                    } while (!valid);

                    System.out.println("L'equip " + opcion + " té " + grupoE[opcion][4] + " punts.\n");
                    break;
                case 2:
                    System.out.println("\nMostrant gol average de cada equip:");
                    System.out.println("Spain: " + (float) (grupoE[0][5] + grupoE[0][6]) / 2);
                    System.out.println("Japan: " + (float) (grupoE[1][5] + grupoE[1][6]) / 2);
                    System.out.println("Costa Rica: " + (float) (grupoE[2][5] + grupoE[2][6]) / 2);
                    System.out.println("Germany: " + (float) (grupoE[3][5] + grupoE[3][6]) / 2);
                    break;
                case 3:
                    System.out.println("\nMostrant recompte de gols a favor marcats en total entre tots els equips:");
                    System.out.println("Spain: " + grupoE[0][5]);
                    System.out.println("Japan: " + grupoE[1][5]);
                    System.out.println("Costa Rica: " + grupoE[2][5]);
                    System.out.println("Germany: " + grupoE[3][5]);
                    System.out.println("Total: " + (grupoE[0][5] + grupoE[1][5] + grupoE[2][5] + grupoE[3][5]));
                    break;
                case 4:
                    System.out.println("\nSortint...");
                    salir = true;
                    break;
                default:
                    System.out.println("ERROR! Has d'introduir un numero entre 1 i 4!\n");
            }
        } while (!salir);
    }
}
