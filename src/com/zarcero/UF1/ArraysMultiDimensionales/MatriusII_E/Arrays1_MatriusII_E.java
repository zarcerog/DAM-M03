package com.zarcero.UF1.ArraysMultiDimensionales.MatriusII_E;

import java.util.Scanner;

public class Arrays1_MatriusII_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array size (nxn): ");
        int n = scanner.nextInt();
        int num;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            num = i + 1;
            for (int j = 0; j < n; j++) {
                arr[j][i] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
