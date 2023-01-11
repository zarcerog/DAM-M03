package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class ZarceroNicolas_Problema12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int QUOTA_FIXA = 6;
        float quotaVariable = 0, costFinal;
        int litresConsumits;

        System.out.print("Num de litres consumits aquest mes? ");
        litresConsumits = scanner.nextInt();

        if (litresConsumits < 50) {
            quotaVariable = 0;
        } else if (litresConsumits <= 200) {
            quotaVariable = 0.15f;
        } else {
            quotaVariable = 0.3f;
        }

        costFinal = litresConsumits * quotaVariable + QUOTA_FIXA;
        System.out.printf("El cost de la teva factura de l'aigua serà de: %.2f €", costFinal);
    }
}
