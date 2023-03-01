package com.zarcero.UF4.Classes;

import java.util.Scanner;

public class CalculateArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----Área de un cuadrado----");
        System.out.print("Introduce el lado del cuadrado: ");
        float side = scanner.nextInt();
        System.out.println("El área del cuadrado es: " + Math.pow(side, 2));

        System.out.println("----Área de un triangulo----");
        System.out.print("Introduce la base del triángulo: ");
        float base = scanner.nextInt();
        System.out.print("Introduce la altura del triángulo: ");
        float height = scanner.nextInt();
        System.out.println("El área del triángulo es: " + (base * height) / 2);

        System.out.println("----Área de un círculo----");
        System.out.print("Introduce el radio del círculo: ");
        float radius = scanner.nextInt();
        System.out.println("El área del círculo es: " + (Math.PI * Math.pow(radius, 2)));
    }
}
