package com.zarcero.UF2.ZarceroNicolás_M03_UF2_Examen;

import java.util.Scanner;

public class ZarceroNicolás_exercici2 {

    public static int[][] arrReparaciones = new int[10][3];
    public static int[][] arrTrabajadores = new int[10][2];

    public static void main(String[] args) {
        start();
    }

    /**
     * Este método se encarga de inicializar el programa.
     */

    public static void start() {
        System.out.println("Que quieres hacer?\n\t[1] Dar de alta una nueva reparación\n\t[2] Dar de alta a un nuevo trabajador\n\t[3] Consultar reparaciones\n\t[4] Consultar trabajadores\n\t[5] Salir");
        int option = isInt("> ", 1, 5);

        switch (option) {
            case 1:
                arrReparaciones = agregarReparacion(arrReparaciones);
                start();
                break;
            case 2:
                arrTrabajadores = agregarTrabajador(arrTrabajadores, arrReparaciones);
                start();
                break;
            case 3:
                consultarMatriz(arrReparaciones);
                start();
                break;
            case 4:
                consultarMatriz(arrTrabajadores);
                start();
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
        }
    }

    /**
     * Este método se encarga de permitir al usuario agregar reparaciones al array de reparaciones.
     * @param arrReparaciones El array de reparaciones, donde se almacenarán los datos descritos por el usuario.
     * @return El array de reparaciones.
     */

    public static int[][] agregarReparacion(int[][] arrReparaciones) {
        int reparacionActual = -1;

        for (int i = 0; i < arrReparaciones.length; i++) {
            if (arrReparaciones[i][0] == 0) {
                reparacionActual = i;
                break;
            }
        }

        if (reparacionActual == -1) {
            System.out.println("ERROR: Se han excedido el numero de reparaciones que se pueden almacenar.");
        } else {
            System.out.println("Número de reparación: " + (reparacionActual + 1));
            int imeiRep = isInt("IMEI: ", 1, 99999999);
            int dniCliente = isInt("DNI cliente: ", 1, 99999999);

            arrReparaciones[reparacionActual][0] = reparacionActual + 1;
            arrReparaciones[reparacionActual][1] = imeiRep;
            arrReparaciones[reparacionActual][2] = dniCliente;
        }

        return arrReparaciones;
    }

    /**
     * Este método se encarga de permitir al usuario agregar un nuevo trabajador al array de trabajadores.
     * @param arrTrabajadores la matriz de trabajadores.
     * @param arrReparaciones la matriz de reparaciones.
     * @return la matriz de trabajadores.
     */

    public static int[][] agregarTrabajador(int[][] arrTrabajadores, int[][] arrReparaciones) {
        int trabajadorActual = -1;

        for (int i = 0; i < arrTrabajadores.length; i++) {
            if (arrTrabajadores[i][0] == 0) {
                trabajadorActual = i;
                break;
            }
        }

        if (trabajadorActual == -1) {
            System.out.println("ERROR: Se han excedido el numero de trabajadores que se pueden almacenar.");
        } else {
            boolean esReparacion = false;

            System.out.println("Número del empleado: " + (trabajadorActual + 1));
            int numReparacion = isInt("Número reparación asignado: ", 0, 10);

            if (numReparacion != 0) {
                for (int i = 0; i < arrReparaciones.length; i++) {
                    if (numReparacion == arrReparaciones[i][0]) {
                        esReparacion = true;
                        break;
                    }
                }
            }

            if (esReparacion || numReparacion == 0) {
                arrTrabajadores[trabajadorActual][0] = trabajadorActual + 1;
                arrTrabajadores[trabajadorActual][1] = numReparacion;
            } else {
                System.out.println("ERROR: El número de la reparación no se ha podido encontrar en el array de reparaciones.");
            }
        }

        return arrTrabajadores;
    }

    /**
     * Permite al usuario consultar la matriz indicada.
     * @param matriz La matriz.
     */

    public static void consultarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Este método se encarga de de confirmar que la entrada por teclado es un int.
     * @param message El mensaje a mostrar.
     * @param min El entero mínimo que se puede indicar.
     * @param max El entero máximo que se puede indicar.
     * @return El entero.
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
