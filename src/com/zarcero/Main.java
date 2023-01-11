package com.zarcero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce int: ");
        int loqsea = scanner.nextInt();

        devolverEntero(loqsea);
    }
    public static void devolverEntero(int x) {
        System.out.println(x);
    }
}