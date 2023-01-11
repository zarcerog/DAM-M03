package com.zarcero.UF1.ArraysMultiDimensionales.PalabraEncriptada;

import java.util.Scanner;

public class POU03_ParaulaNicoZarcero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la palabra a encripta: ");
        String word = scanner.next();
        word = word.toUpperCase();
        int wordLength = word.length();

        int[][] matrixInt = new int[wordLength][wordLength];
        char[][] matrix = new char[wordLength][wordLength];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = word.charAt(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = (char) (Math.random() * 26 + 65);
                }
                matrixInt[i][j] = matrix[i][j];
            }
        }

        System.out.println("Matriz de enteros");

        for (int[] numbers : matrixInt) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        System.out.println("Matriz de caracteres");

        for (char[] letters : matrix) {
            for (char letter : letters) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }


        /* Ejercicio Inical
        final char N = 78;
        final char I = 73;
        final char C = 67;
        final char O = 79;
        int[][] arrInt = new int[4][4];
        char[][] arr = new char[4][4];

        arrInt[3][3] = N;
        arrInt[2][2] = I;
        arrInt[1][1] = C;
        arrInt[0][0] = O;

        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[i].length; j++) {
                if (arrInt[i][j] == 0) {
                    arrInt[i][j] = (int) (Math.random() * 26 + 65);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (char) arrInt[i][j];
            }
        }

        for (int[] numbers : arrInt) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (char[] letters : arr) {
            for (char letter : letters) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
         */
    }
}
