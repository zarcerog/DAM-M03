package com.zarcero.UF1.ConditionalsAndLoops;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Num chicas aula");
        int numChicas = scanner.nextInt();
        System.out.println("Num chicos aula");
        int numChicos = scanner.nextInt();
        int totalAula = numChicas + numChicos;
        float porChicos = (float) numChicos * 100 / totalAula;
        float porChicas = (float) numChicas * 100 / totalAula;
        System.out.printf("\nPorcentaje mujeres aula %.2f%%", porChicas);
        System.out.printf("\nPorcentaje hombres aula %.2f%%", porChicos);
    }
}
