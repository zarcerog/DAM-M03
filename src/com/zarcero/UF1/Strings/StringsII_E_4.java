package com.zarcero.UF1.Strings;

import java.util.Scanner;

public class StringsII_E_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una string: ");
        String str = scanner.next();

        if (str.length() < 3) {
            System.out.println(str);
        } else {
            if (str.substring(str.length() - 3).equals("ing")) {
                System.out.println(str + "ly");
            } else {
                System.out.println(str + "ing");
            }
        }
    }
}
