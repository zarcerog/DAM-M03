package com.zarcero.UF1.Arrays;

import java.util.Scanner;

public class Arrays6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = new int[10];
        int[] tempArr = new int[numArr.length];
        int positionN, j = 0;

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = scanner.nextInt();
        }

        System.out.print("Posicion elemento: ");
        positionN = scanner.nextInt();

        for (int i = 0; i < numArr.length; i++) {
            if (i != positionN) {
                tempArr[j] = numArr[i];
                j++;
            } else {
                tempArr[tempArr.length - 1] = -1;
            }
        }

        for (int num : tempArr) {
            if (num != -1)
                System.out.print(num + ", ");
        }
    }
}
