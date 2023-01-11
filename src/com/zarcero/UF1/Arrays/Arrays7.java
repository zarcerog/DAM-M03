package com.zarcero.UF1.Arrays;

import java.util.Scanner;

public class Arrays7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = new int[10];
        int num, positionN = 0;
        boolean valorEncontrado = false;

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = scanner.nextInt();
        }

        System.out.print("Num: ");
        num = scanner.nextInt();

        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] == num) {
                positionN = i;
                valorEncontrado = true;
                break;
            }
        }

        if (valorEncontrado) {
            System.out.println("El valor se encuentra en el index: " + positionN);
        } else {
            System.out.println("No se ha encontrado el valor especificado en la array");
        }
    }
}
