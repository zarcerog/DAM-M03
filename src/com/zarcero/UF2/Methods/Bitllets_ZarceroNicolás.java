package com.zarcero.UF2.Methods;

import java.util.Scanner;

public class Bitllets_ZarceroNicolás {
    private static int numBilletes = 0; // Variable para guardar el número de billetes que se van a entregar
    private final static float[][] ARR_BILLETES = new float[3][3]; // Array para guardar el tipo de billete, el valor y el número de zonas
    private final static String[] ARR_NOMBRE_BILLETES = {"Billete sencillo", "TCasual", "TUsual", "TFamiliar", "TJoven"}; // Array para guardar los nombres de los billetes
    private final static float[] arrPrecios = {2.40f, 11.35f, 40.00f, 10.00f, 80.00f}; // Array para guardar los precios de los billetes
    private static boolean isTrue = true;

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
        mainMenu();
    }

    /**
     * Mostrar menu principal
     */

    public static void mainMenu() {
        int option;

        do {
            if (numBilletes != 0) {
                String respuesta = isString(ANSI_CYAN + "¿Quieres seguir comprando? (S/N)" + ANSI_BLUE + "\n> " + ANSI_RESET);

                if (respuesta.equalsIgnoreCase("N")) {
                    pagar();
                }
            }
            if (numBilletes < 3) {
                System.out.println(ANSI_BLUE + "--------------------" + ANSI_RESET);
                System.out.println("¿Qué billete desea adquirir?");
                for (int i = 0; i < ARR_NOMBRE_BILLETES.length; i++) {
                    System.out.println("\t[" + (i + 1) + "] " + ARR_NOMBRE_BILLETES[i] + " ");
                }
                option = isInt(ANSI_BLUE + "> " + ANSI_RESET);

                if (option != 4321) {
                    if (option < 1 || option > 5) {
                        System.out.println(ANSI_RED + "Opción no válida" + ANSI_RESET);
                    } else {
                        compraBillete(option);
                    }
                } else {
                    System.out.println(ANSI_YELLOW + "Panel administrador" + ANSI_RESET);
                    option = isInt("¿Qué quieres hacer?\n\t[1] Apagar máquina\n\t[2] Tickets gratis" + ANSI_BLUE + "\n> " + ANSI_RESET);

                    if (option > 2 || option < 1) {
                        System.out.println(ANSI_RED + "Opción no válida" + ANSI_RESET);
                    } else {
                        adminPanel(option);
                    }
                }
            } else {
                System.out.println(ANSI_YELLOW + "Has alcanzado el número máximo de billetes que puedes comprar." + ANSI_RESET);
                pagar();
            }
        } while (isTrue);
    }

    /**
     * Comprar billetes
     * @param tipo Tipo de billete (1 - 5)
     */

    public static void compraBillete(int tipo) {
        float precio;
        float precioZonas;
        int zonas = numZonas();

        float[] arrPrecioZonas = {1.00f, 1.3125f, 1.8443f}; // Array para guardar los precios de las zonas*


        precioZonas = arrPrecioZonas[zonas - 1];

        precio = arrPrecios[tipo - 1] * precioZonas;

        precio = (float) (Math.round(precio * 100.0) / 100.0);

        System.out.println("Has escogido la opción: " + ARR_NOMBRE_BILLETES[tipo - 1] + ", " + zonas + " zonas");
        System.out.println("El precio del billete es de " + precio + "€");
        String respuesta = isString(ANSI_CYAN + "¿Desea añadirlo al carrito? (S/N)"+ ANSI_BLUE + "\n> " + ANSI_RESET);

        if (respuesta.equalsIgnoreCase("S")) {
            numBilletes++;
            addTicket(tipo, precio, zonas);
            System.out.println(ANSI_GREEN + "Billete añadido con éxito" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Compra cancelada" + ANSI_RESET);
        }
    }

    /**
     * Comprobar el numero de zonas a recorrer
     * @return Numero de zonas
     */

    public static int numZonas() {
        int zonas;
        do {
            zonas = isInt("¿Cuántas zonas desea recorrer?\n\t1\n\t2\n\t3" + ANSI_BLUE + "\n> " + ANSI_RESET);
            if (zonas < 1 || zonas > 3) {
                System.out.println(ANSI_RED + "ERROR: Valor no válido." + ANSI_RESET);
            }
        } while (zonas < 1 || zonas > 3);
        return zonas;
    }

    /**
     * Añadir billete a la lista
     * @param tipo Tipo de billete
     * @param precio Precio del billete
     * @param zonas Numero de zonas
     */

    public static void addTicket(int tipo, float precio, int zonas) {
        for (int i = 0; i < 3; i++) {
            if (ARR_BILLETES[i][0] == 0) {
                ARR_BILLETES[i][0] = tipo;
                ARR_BILLETES[i][1] = precio;
                ARR_BILLETES[i][2] = zonas;
                break;
            }
        }
    }

    /**
     * Pagar billetes
     */

    public static void pagar() {
        float total = 0;
        for (int i = 0; i < 3; i++) {
            if (ARR_BILLETES[i][0] != 0) {
                total += ARR_BILLETES[i][1];
            }
        }

        System.out.println("Has comprado " + numBilletes + " billetes, con un total de " + total + "€");
        String respuesta = isString(ANSI_CYAN + "¿Desea pagar? (S/N)" + ANSI_BLUE + "\n> " + ANSI_RESET);
        if (respuesta.equalsIgnoreCase("S")) {
            float pago = introducirDinero("Introduce monedas o billetes validos de EURO: ");

            while (pago < total) {
                System.out.println("Has introducido " + pago + "€, faltan " + (total - pago) + "€");
                pago += introducirDinero("Introduce monedas o billetes validos de EURO: ");
            }

            if (pago > total) {
                System.out.println("Su cambio es de " + (pago - total) + "€");
            }

            respuesta = isString(ANSI_CYAN + "¿Quieres ticket de compra? (S/N)" + ANSI_BLUE + "\n> " + ANSI_RESET);
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.println(ANSI_YELLOW + "_____TICKET_____" + ANSI_RESET);
                for (int i = 0; i < 3; i++) {
                    if (ARR_BILLETES[i][0] != 0) {
                        int tipo = (int) ARR_BILLETES[i][0];
                        System.out.println(ARR_NOMBRE_BILLETES[tipo - 1] + " zona " + (int) ARR_BILLETES[i][2] + " - Precio: " + ARR_BILLETES[i][1] + "€");
                    }
                }
                System.out.println("Total: " + total + "€");
                System.out.println(ANSI_YELLOW + "----------------" + ANSI_RESET);
                System.out.println("Recoge tu ticket");
            }
            System.out.println("Gracias por su compra\n");
        } else {
            System.out.println(ANSI_RED + "Pago cancelado\n" + ANSI_RESET);
        }

        returnToDefault();
    }

    /**
     * Devolver a los valores por defecto
     */

    public static void returnToDefault() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ARR_BILLETES[i][j] = 0;
            }
        }

        numBilletes = 0;
    }

    public static void adminPanel(int option) {
        switch (option) {
            case 1:
                isTrue = false;
                break;
            case 2:
                for (int i = 0; i < arrPrecios.length; i++) {
                    arrPrecios[i] = 0.00f;
                }
                break;
        }
    }

    /**
     * Método para introducir dinero y comprobar que es válido
     * @param message Mensaje a mostrar
     * @return Dinero introducido
     */

    public static float introducirDinero(String message) {
        Scanner scanner = new Scanner(System.in);
        float x = 0;
        boolean isFloat;
        float[] arrDinero = {0.05f, 0.10f, 0.20f, 0.50f, 1.00f, 2.00f, 5.00f, 10.00f, 20.00f, 50.00f, 100.00f, 200.00f, 500.00f};

        do {
            System.out.print(message);
            isFloat = scanner.hasNextFloat();

            if (!isFloat) {
                System.out.println(ANSI_RED + "ERROR: Valor no válido." + ANSI_RESET);
                scanner.nextLine();
            } else {
                x = scanner.nextFloat();

                for (float v : arrDinero) {
                    if (x == v) {
                        isFloat = true;
                        break;
                    } else {
                        isFloat = false;
                    }
                }

                scanner.nextLine();
            }
        } while (!isFloat);

        return x;
    }

    /**
     * Comprobar si el valor introducido es un entero
     * @param message Mensaje a mostrar
     * @return Valor entero
     */

    public static int isInt(String message) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        boolean isInt ;

        do {
            System.out.print(message);
            isInt = scanner.hasNextInt();

            if (!isInt) {
                System.out.println(ANSI_RED + "ERROR: Valor no entero." + ANSI_RESET);
                scanner.nextLine();
            } else {
                x = scanner.nextInt();
                scanner.nextLine();
            }
        } while (!isInt);

        return x;
    }

    /**
     * Comprobar si el valor introducido es un String
     * @param message Mensaje a mostrar
     * @return Valor String
     */

    public static String isString(String message) {
        Scanner scanner = new Scanner(System.in);
        String x = "";
        boolean isString;

        do {
            System.out.print(message);
            isString = scanner.hasNext();

            if (!isString) {
                System.out.println(ANSI_RED + "ERROR." + ANSI_RESET);
                scanner.nextLine();
            } else {
                x = scanner.next();
                scanner.nextLine();
            }
        } while (!isString);

        return x;
    }
}
