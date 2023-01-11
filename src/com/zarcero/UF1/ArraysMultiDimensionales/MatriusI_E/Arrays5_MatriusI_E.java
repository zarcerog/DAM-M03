package com.zarcero.UF1.ArraysMultiDimensionales.MatriusI_E;

import java.util.Scanner;

public class Arrays5_MatriusI_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] arr = new float[20][3];
        float minClase = 0, maxClase = 0;

        for (int i = 0; i < 20; i++) {
            float parcial1 = scanner.nextFloat();
            float parcial2 = scanner.nextFloat();
            float parcial3 = scanner.nextFloat();

            float min = parcial1, max = parcial1;

            float totalParciales = (parcial1 + parcial2 + parcial3) / 3;

            if (parcial2 < min) {
                min = parcial2;
            } else if (parcial3 < min) {
                min = parcial3;
            }

            if (parcial2 > max) {
                max = parcial2;
            } else if (parcial3 > max) {
                max = parcial3;
            }

            arr[i][0] = totalParciales;
            arr[i][1] = max;
            arr[i][2] = min;
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                minClase = arr[i][0];
                maxClase = arr[i][0];
            }

            if (arr[i][0] > maxClase) {
                maxClase = arr[i][0];
            }

            if (arr[i][0] < minClase) {
                minClase = arr[i][0];
            }
        }
    }
}
