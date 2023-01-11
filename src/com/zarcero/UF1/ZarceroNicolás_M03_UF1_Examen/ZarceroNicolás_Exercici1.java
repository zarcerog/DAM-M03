package com.zarcero.UF1.ZarceroNicolás_M03_UF1_Examen;

import java.util.Scanner;

public class ZarceroNicolás_Exercici1 {
    public static void main(String[] args) {
        int pantaPle, plou, opcion = 0;
        Scanner scanner = new Scanner(System.in);
        boolean controlErrores = false, salir = false, compuertaAbierta = false;

        do {
            do {
                System.out.println("Que vols fer?\n\t1. OBRIR COMPORTES\n\t2. TANCAR COMPORTES\n\t3.ESTAT COMPORTES\n\t4. SORTIR");
                controlErrores = scanner.hasNextInt();

                if (!controlErrores) {
                    System.out.println("ERROR! Has d'indicar un número del 1 al 4.");
                } else {
                    opcion = scanner.nextInt();
                }

                scanner.nextLine();

            } while (!controlErrores);

            pantaPle = (int) (Math.random() * 2);
            plou = (int) (Math.random() * 2);

            switch (opcion) {
                case 1:
                    if (pantaPle == 1 || plou == 1) {
                        System.out.println("Obrint comportes...\n");
                        compuertaAbierta = true;
                    } else {
                        System.out.println("Les comportes únicament es poden obrir si el pantà està obert o està plovent.\n");
                    }
                    break;
                case 2:
                    System.out.println("Tancant comportes...\n");
                    compuertaAbierta = false;
                    break;
                case 3:
                    String estadoCompuerta = null;
                    if (compuertaAbierta) {
                        estadoCompuerta = "obertes";
                    } else {
                        estadoCompuerta = "tancades";
                    }
                    System.out.println("Les comportes es troben " + estadoCompuerta + "\n");
                    break;
                case 4:
                    System.out.println("Sortint...\n");
                    salir = true;
                    break;
                default:
                    System.out.println("ERROR! El valor a introduir ha d'estar entre el 1 i el 4.");
            }
        } while (!salir);
    }
}
