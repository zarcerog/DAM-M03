package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eres cliente VIP? ");
        boolean isVip = scanner.nextBoolean();
        System.out.println("Valor compra? ");
        float value = scanner.nextFloat();

        if (isVip || value > 200) {
            value = value * 0.8f;
        }

        System.out.printf("\nTotal compra: %.2f€", value);
    }
}
