package com.zarcero.UF1.Strings;

import java.util.Scanner;

public class StringsII_E_3 {
    public static void main(String[]  args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una string: ");
        String str = scanner.next();

        if (str.length() < 2) {
            System.out.println("Cadena vacia");
        } else {
            System.out.println(str.substring(0, 2) + str.substring(str.length() - 2));
        }
    }
}
