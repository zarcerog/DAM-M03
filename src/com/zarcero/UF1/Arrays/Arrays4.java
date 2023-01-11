package com.zarcero.UF1.Arrays;

import java.util.Scanner;

public class Arrays4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] numArr1 = new float[10];
        float[] numArr2 = new float[10];
        float[] finalArr = new float[20];
        int j = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce el float para el index: " + i + " del array 1: ");
            numArr1[i] = scanner.nextFloat();
        }

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce el float para el index: " + i + " del array 2: ");
            numArr2[i] = scanner.nextFloat();
        }

        for (int i = 0; i < finalArr.length; i++) {
            finalArr[i] = numArr1[j];
            i++;
            finalArr[i] = numArr2[j];
            j++;
        }

        for (float num : finalArr) {
            System.out.println("Array num " + num);
        }
    }
}
