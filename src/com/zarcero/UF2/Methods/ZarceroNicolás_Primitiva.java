package com.zarcero.UF2.Methods;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Programa de simulació de La Primitiva
 * @auhor Nicolás Zarcero
 * @version 1.0
 * @date 25/01/2023
 */

public class ZarceroNicolás_Primitiva {
    /**
     * Mètode main executable
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Éste método muestra el menú principal y ejecuta las opciones
     * @since 1.0
     */
    private static void menuPrincipal(){
        System.out.println("***** PRIMITIVA ******");

        int opcion;

        int[][] apuestas = new int[8][7];

        do {
            System.out.println("\t[1] Hacer apuesta\n\t[2] Girar el bombo\n\t[3] Juego nuevo\n\t[4] Salir");
            opcion = llegirInt("> ", 1, 4);
            int premi = 0;

            switch (opcion) {
                case 1:
                    int[] aposta = introduirAposta();

                    for (int i = 0; i < apuestas.length; i++) {
                        if (comprobarDuplicados(aposta, apuestas)) {
                            if (apuestas[i][0] == 0) {
                                apuestas[i] = aposta;
                                break;
                            }
                        } else {
                            System.out.println("ERROR: Aquesta aposta ja ha estat introduïda.");
                            break;
                        }
                    }

                    break;
                case 2:
                    int[] combinacioGuanyadora = calcularCombinacioGuanyadora();

                    System.out.println("La combinació ganadora és: ");

                    for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                        System.out.print(combinacioGuanyadora[i] + " ");
                    }

                    System.out.println("Reintegrament " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);

                    for (int[] apuesta : apuestas) {
                        if (apuesta[0] == 0) {
                            break;
                        }
                        premi += comprovarEncerts(apuesta, combinacioGuanyadora);
                    }

                    System.out.println("El teu premi és: " + premi + " €");
                    break;
                case 3:
                    for (int i = 0; i < apuestas.length; i++) {
                        for (int j = 0; j < apuestas[i].length; j++) {
                            apuestas[i][j] = 0;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion != 4);
    }

    /**
     * Éste método pide al usuario los números de su apuesta
     * @return Retorna un array de enteros con la apuesta del usuario
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = new int[7];

        for (int i = 0; i < aposta.length - 1; i++) {
            int num = llegirInt("Número " + (i + 1) + " de la teva aposta\n> ", 1, 49);

            for (int j = 0; j < i; j++) {
                if (num == aposta[j]){
                    System.out.println("ERROR: El número " + num + " ja ha estat introduït.");
                    i--;
                    break;
                }
            }

            aposta[i] = num;
        }

        aposta[aposta.length - 1] = llegirInt("Reintegrament\n> ", 0, 9);

        return aposta;
    }

    /**
     * Éste método calcula la combinación ganadora
     * @return Retorna un array de enteros con la combinación ganadora
     * @since 1.0
     */
    private static int[] calcularCombinacioGuanyadora(){
        int[] combinacio = new int[7];

        for (int i = 0; i < combinacio.length - 1; i++) {
            int min = 1;
            int max = 49;

            int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);

            for (int j = 0; j < i; j++) {
                if (randomInt == combinacio[j]){
                    i--;
                    break;
                }
            }

            combinacio[i] = randomInt;
        }

        combinacio[combinacio.length - 1] = (int) Math.floor(Math.random() * (9 + 1) + 0);

        return combinacio;
    }

    /**
     * Éste método comprueba los aciertos de la apuesta con la combinación ganadora, el reintegro y calcula el premio
     * @param aposta Array de enteros con la apuesta del usuario
     * @param combinacioGuanyadora Array de enteros con la combinación ganadora
     * @return Retorna un entero con el premio
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació

        for (int i = 0; i < aposta.length - 1; i++) {
            for (int j = 0; j < combinacioGuanyadora.length - 1; j++) {
                if (aposta[i] == combinacioGuanyadora[j]){
                    encerts++;
                }
            }
        }

        //Comprobar reintegrament

        if (aposta[aposta.length - 1] == combinacioGuanyadora[combinacioGuanyadora.length - 1]){
            reintregrament = true;
        }

        //Calcular premi

        int premiApostaGanadora = 20;
        int premiReintegrament = 6;

        premi = premiApostaGanadora * encerts + premiReintegrament * (reintregrament ? 1 : 0);

        return premi;
    }

    /**
     * Éste método comprueba si la apuesta es duplicada
     * @param aposta Array de enteros con la apuesta del usuario
     * @param apuestas Array de enteros con las apuestas de los usuarios
     * @return Retorna un booleano con el resultado de la comprobación
     */

    private static boolean comprobarDuplicados(int[] aposta, int[][] apuestas){
        for (int[] aposta1 : apuestas) {
            if (aposta1[0] == 0) {
                break;
            }
            if (Arrays.equals(aposta, aposta1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min valor min acceptat
     * @param max valor max acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        int x = 0;
        boolean valorCorrecte;

        do {
            System.out.print(missatge);
            valorCorrecte = scanner.hasNextInt();

            if (!valorCorrecte) {
                System.out.println("ERROR: Valor no enter.");
                scanner.nextLine();
            } else { // Tengo un entero
                x = scanner.nextInt();
                scanner.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        } while(!valorCorrecte);

        return x;
    }

    /**
     * Aquest mètode serveix per capturar floats des de teclat amb control d'errors
     * @param missatge
     * @return
     * @since 1.0
     */
    private static float llegirFloat(String missatge){
        Scanner scanner = new Scanner(System.in);

        float x = 0;
        boolean valorCorrecte;

        do {
            System.out.print(missatge);
            valorCorrecte = scanner.hasNextFloat();

            if (!valorCorrecte) {
                System.out.println("ERROR: Valor no float.");
            } else {
                x = scanner.nextFloat();
            }

            scanner.nextLine();
        } while(!valorCorrecte);

        return x;
    }
}
