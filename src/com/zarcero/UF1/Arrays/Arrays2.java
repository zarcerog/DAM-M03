package com.zarcero.UF1.Arrays;

import java.util.Scanner;

public class Arrays2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = new int[5];

        for (int i = 0; i < 5; i++) {
            int num = scanner.nextInt();
            numArr[i] = num;
        }

        for (int i = numArr.length - 1; i >= 0; i--) {
            System.out.println(numArr[i]);
        }
    }
}
