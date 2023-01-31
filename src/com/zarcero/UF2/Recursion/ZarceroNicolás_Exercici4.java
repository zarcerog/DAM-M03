package com.zarcero.UF2.Recursion;

public class ZarceroNicolás_Exercici4 {
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(multiplicacionVector(vector, 0));
    }

    public static int multiplicacionVector(int[] vector, int i) {
        if (i == vector.length) {
            return 1;
        } else {
            return vector[i] * multiplicacionVector(vector, i + 1);
        }
    }
}
