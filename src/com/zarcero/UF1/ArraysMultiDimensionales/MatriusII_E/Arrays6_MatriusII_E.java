package com.zarcero.UF1.ArraysMultiDimensionales.MatriusII_E;

import java.util.Scanner;

public class Arrays6_MatriusII_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array size (nxn): ");
        int n = scanner.nextInt();
        boolean[][] arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = i % 2 == 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
