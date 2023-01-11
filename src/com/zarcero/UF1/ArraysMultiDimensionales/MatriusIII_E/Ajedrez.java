package com.zarcero.UF1.ArraysMultiDimensionales.MatriusIII_E;

public class Ajedrez {
    public static void main(String[] args) {
        char blancas = 'O', negras = 'X';
        char[][] tablero = new char[9][9];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    tablero[i][j] = blancas;
                } else {
                    tablero[i][j] = negras;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            tablero[i][8] = (char) ('8' - i);
        }

        for (int i = 0; i < 8; i++) {
            tablero[8][i] = (char) ('A' + i);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            //System.out.print(8 - i);
            System.out.println();
        }
    }
}
