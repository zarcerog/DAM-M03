package com.zarcero.UF2.Recursion;

public class ZarceroNicolás_Exercici5 {
    public static void main(String[] args) {
        int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(sumaMatriz(matriz, 0, 0));
    }

    public static int sumaMatriz(int[][] matriz, int i, int j) {
        if (i == matriz.length) {
            return 0;
        } else if (j == matriz[i].length) {
            return sumaMatriz(matriz, i + 1, 0);
        } else {
            return matriz[i][j] + sumaMatriz(matriz, i, j + 1);
        }
    }
}
