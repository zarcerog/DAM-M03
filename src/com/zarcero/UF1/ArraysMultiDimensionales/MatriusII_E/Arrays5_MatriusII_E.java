package com.zarcero.UF1.ArraysMultiDimensionales.MatriusII_E;

import java.util.Scanner;

public class Arrays5_MatriusII_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array size (nxn): ");
        int n = scanner.nextInt();
        int num = n * n + 1;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num--;
                arr[i][j] = num;
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
