package com.zarcero.UF1.ArraysMultiDimensionales.MatriusI_E;

import java.util.Scanner;

public class Arrays1_MatriusI_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Size of the array (nxm): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sumColumn;

        int[][] arr = new int[n][m];
        int[] arrSum = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            sumColumn = 0;
            for (int j = 0; j < n; j++) {
                sumColumn += arr[j][i];
            }
            arrSum[i] = sumColumn;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int num : arrSum) {
            System.out.print(num + " ");
        }

        int numABuscar = scanner.nextInt();
        boolean numEncontrado = false;
        int[][] numPos = new int[2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == numABuscar) {
                    numEncontrado = true;
                    numPos[0][0] = i;
                    numPos[0][1] = j;
                }
            }
        }

        if (numEncontrado) {
            System.out.println("The number " + numABuscar + " is in the position: " + numPos[0][0] + " " + numPos[0][1]);
        } else {
            System.out.println("The number " + numABuscar + " is not in the array");
        }
    }
}
