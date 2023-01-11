package com.zarcero.UF1.Strings;

import java.util.Scanner;

public class StringsII_E_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una string: ");
        String str = scanner.nextLine();
        int count = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            count = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && chars[i] != ' ' && chars[i] != '0') {
                    count++;
                    chars[j] = '0';
                }
            }
            if (count > 0 && chars[i] != '0') {
                System.out.print(chars[i] + ": " + count + ", ");
            }
        }
    }
}
