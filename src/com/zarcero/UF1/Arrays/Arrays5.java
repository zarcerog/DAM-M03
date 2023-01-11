package com.zarcero.UF1.Arrays;

import java.util.Scanner;

public class Arrays5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = new int[10];
        int temp;

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal array: ");
        for (int num : numArr) {
            System.out.print(num + " ");
        }

        temp = numArr[numArr.length - 1];

        for (int i = numArr.length - 1; i > 0; i--) {
            numArr[i] = numArr[i - 1];
        }

        numArr[0] = temp;

        System.out.println("\nNueva array: ");
        for (int num : numArr) {
            System.out.print(num + " ");
        }
    }
}
