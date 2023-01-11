package com.zarcero.UF1.ArraysMultiDimensionales.MatriusI_E;

public class Arrays3_MatriusI_E {
    public static void main(String[] args) {
        char[][] arr = new char[5][5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0 || i == arr.length - 1) {
                    arr[i][j] = 'X';
                } else if (j == i) {
                    arr[i][j] = 'X';
                }
            }
        }

        for (char[] chars : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}
