package com.zarcero.UF1.ArraysMultiDimensionales;

import java.util.Scanner;

public class HorarioEscolar {
    public static void main(String[] args) {
        final String BLACK = "\033[40m";
        final String WHITE_TEXT = "\033[37m";
        final String RED = "\033[41m";
        final String GREEN = "\033[42m";
        final String YELLOW = "\033[43m";
        final String BLUE = "\033[44m";
        final String PURPLE = "\033[45m";
        final String CYAN = "\033[46m";
        final String WHITE = "\033[47m";
        final String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);

        String[][] horari = {{"Mates","Català","Castellà","Anglès","Educació Física"},
                {"Socials", "Naturals","Tecnologia","Educació Plàstica"}
        };

        String[] torn = {"Matí", "Tarda"};
        String[] diesSetmana = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres"};

        // Matí
        horari[0][0] = RED+"Mates"+RESET;
        horari[0][1] = "Català";
        horari[0][2] = WHITE+"Castellà"+RESET;
        horari[0][3] = YELLOW+"Anglès"+RESET;
        horari[0][4] = GREEN+"Educació Física"+RESET;

        // Tarda
        horari[1][0] = BLUE+"Socials"+RESET;
        horari[1][1] = GREEN+"Naturals"+RESET;
        horari[1][2] = WHITE_TEXT+BLACK+"Tecnologia"+RESET;
        horari[1][3] = PURPLE+"Educació Plàstica"+RESET;
        //horari[1][4] = "";

        int opcio = 0;
        int opcion;
        boolean valorCorrecto = false;
        System.out.println("Benvingut/da al programa");

        do {
            do {
                System.out.println("Tria una opció:"
                        + "\n\t1. Mostrar horari complet"
                        + "\n\t2. Mostrar horari de torn"
                        + "\n\t3. Mostrar horari d'un dia"
                        + "\n\t4. Modificar horari"
                        + "\n\t5. Sortir"
                        + "");
                // TODO: Aplicar control d'errors

                valorCorrecto = scanner.hasNextInt();

                if (valorCorrecto) {
                    opcio = scanner.nextInt();
                } else {
                    System.out.println(RED + "Error" + RESET);
                }
                scanner.nextLine();
            } while (!valorCorrecto);

            switch (opcio) {
                case 1:
                    for (String s : diesSetmana) {
                        System.out.printf("%15s", s);
                    }
                    System.out.println();

                    for (int fila = 0; fila < horari.length; fila++) {
                        System.out.print(torn[fila] + "\t");
                        for (int col = 0; col < horari[fila].length; col++) {
                            System.out.print(horari[fila][col] + "\t\t");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    opcion = 0;

                    do {
                        System.out.println("Elige una opcion: \n\t1. Mañana\n\t2. Tarde\n\t3.Salir");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.print(torn[0] + "\t");
                                for (int i = 0; i < 1; i++) {
                                    for (int j = 0; j < 5; j++) {
                                        System.out.print(horari[i][j] + "\t\t");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.print(torn[1] + "\t");
                                for (int i = 1; i < 2; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        System.out.print(horari[i][j] + "\t\t");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println(RED + "ERROR: Valor no valido" + RESET);
                                break;
                        }
                    } while (opcion != 3);
                    break;
                case 3:
                    // TODO: Implementar que permeti mostrar horari d'un dia concret
                    opcion = 0;

                    do {
                        System.out.println("Elige un dia de la semana (1-5) o 6 para salir:");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                showPerDay(1, horari);
                                break;
                            case 2:
                                showPerDay(2, horari);
                                break;
                            case 3:
                                showPerDay(3, horari);
                                break;
                            case 4:
                                showPerDay(4, horari);
                                break;
                            case 5:
                                showPerDay(5, horari);
                                break;
                            case 6:
                                System.out.println("Returning to main menu...");
                                break;
                            default:

                                break;
                        }
                    } while (opcion != 6);
                    break;
                case 4:
                    int dia = 0;
                    int turno = 0;

                    System.out.println("Elige un dia d la semana: ");
                    dia = scanner.nextInt();
                    System.out.println("1.Mañana 2.tarde");
                    turno = scanner.nextInt();
                    scanner.nextLine();

                    horari[turno - 1][dia - 1] = scanner.nextLine();

                    break;
                case 5:
                    System.out.println("Adéu i gràcies");
                    break;
                default:
                    System.out.println(RED + "ERROR: Valor no vàlid" + RESET);
                    break;
            }
        } while (opcio != 5);
    }


    public static void showPerDay(int day, String[][] horario) {
        if (day != 5) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    System.out.print("Matí\t");
                } else {
                    System.out.print("Tarda\t");
                }

                for (int j = day - 1; j < day; j++) {
                    System.out.println(horario[i][j]);
                }
            }
        } else {
            System.out.print("Matí\t");

            System.out.println(horario[0][day - 1]);
        }
    }

    public static void showBoth(String[][] horario) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.format("%-20s", horario[i][j]);
            }
            System.out.println();
        }
    }

    public static void showMorning(String[][] horario) {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.format("%-20s", horario[i][j]);
            }
        }
    }

    public static void showAfternoon(String[][] horario) {
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.format("%-20s", horario[i][j]);
            }
        }
    }
}
