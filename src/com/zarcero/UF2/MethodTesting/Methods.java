package com.zarcero.UF2.MethodTesting;

import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        printName();
    }

    public static String returnName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce your name: ");

        return scanner.nextLine();
    }

    public static void printName() {
        System.out.println(returnName());
    }
}
