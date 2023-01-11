package com.zarcero.UF2.Methods;

import java.util.Scanner;

public class ZarceroNicolás_PVP {
    public static void main(String[] args) {
        System.out.println(calculateIVA(askPrice()));
    }

    /**
     * Lee un float por la terminal y hace un control de errores.
     * @return Devuelve el float.
     */

    public static float getFloat() {
        Scanner scanner = new Scanner(System.in);
        float num = 0;
        boolean isFloat;

        do {
            System.out.print("Introduce el precio del producto: ");
            isFloat = scanner.hasNextFloat();
            if (isFloat) {
                num = scanner.nextFloat();
                if (num < 0) {
                    System.out.println("El valor no puede ser menor a 0");
                    isFloat = false;
                } else {
                    return num;
                }
            } else {
                System.out.println("El valor introducido no es un float válido.");
                scanner.next();
            }
        } while (!isFloat);

        return num;
    }

    /**
     * Pregunta por el precio de un producto.
     * @return Devuelve el precio del mismo.
     */

    public static float askPrice() {
        return getFloat();
    }

    /**
     * Calcula el IVA de un precio dado.
     * @param price El precio del producto.
     * @return El precio del producto con el IVA aplicado.
     */

    public static float calculateIVA(float price) {
        return price * 1.21f;
    }
}
