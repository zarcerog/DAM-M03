package com.zarcero.UF1.Arrays;

import java.util.Scanner;

public class Arrays1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect, isFinished = false;
        int number, i = 0, sizeArray = 0;

        System.out.println("Size de la array");
        do {
            isCorrect = scanner.hasNextInt();

            if (!isCorrect) {
                System.out.println("Oh nO! t has equivocao... ");
            } else {
                sizeArray = scanner.nextInt();
                isFinished = true;
            }
            scanner.nextLine();
        } while (!isFinished);

        int[] arrNum = new int[sizeArray];
        isFinished = false;

        do {
            isCorrect = scanner.hasNextInt();

            if (!isCorrect) {
                System.out.println("Oh nO! t has equivocao... ");
            } else {
                arrNum[i] = scanner.nextInt();
                i++;
            }

            if (i == sizeArray) {
                isFinished = true;
            }
            scanner.nextLine();
        } while (!isFinished);

        for (int num : arrNum) {
            System.out.println(num);
        }
    }
}
