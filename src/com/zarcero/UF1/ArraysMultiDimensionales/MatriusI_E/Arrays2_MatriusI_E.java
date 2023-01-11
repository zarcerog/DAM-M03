package com.zarcero.UF1.ArraysMultiDimensionales.MatriusI_E;

import java.util.Scanner;

public class Arrays2_MatriusI_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Size of the array (nxm): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sumColumn, max = 0, min = 0;

        int[][] arr = new int[n][m];
        int[][] arrSum = new int[3][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            sumColumn = 0;
            for (int j = 0; j < n; j++) {
                sumColumn += arr[j][i];

                if (j == 0) {
                    max = arr[j][i];
                    min = arr[j][i];
                }

                if (arr[j][i] > max) {
                    max = arr[j][i];
                }
                if (arr[j][i] < min) {
                    min = arr[j][i];
                }
            }
            arrSum[0][i] = sumColumn;
            arrSum[1][i] = min;
            arrSum[2][i] = max;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arrSum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
