package com.zarcero.UF2.Methods;

import java.util.Scanner;

public class ZarceroNicolás_ParellSenar {
    public static void main(String[] args) {
        System.out.println(isPair(getInt()));
    }

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        boolean isInt;
        int num = 0;

        do {
            System.out.print("Introduce un número entero: ");
            isInt = scanner.hasNextInt();

            if (isInt) {
                num = scanner.nextInt();
            } else {
                System.out.println("No has introducido un número entero.");
            }

            scanner.nextLine();
        } while (!isInt);

        return num;
    }

    public static boolean isPair(int num) {
        if (num % 2 == 0) {
            return true;
        }

        return false;
    }
}
