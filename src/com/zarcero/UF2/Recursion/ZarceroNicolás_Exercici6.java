package com.zarcero.UF2.Recursion;

public class ZarceroNicolás_Exercici6 {
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5,6,7,8,9};
        System.out.println(minArr(vector, 0));
    }

    public static int minArr(int[] vector, int i) {
        if (i == vector.length - 1) {
            return vector[i];
        } else {
            return Math.min(vector[i], minArr(vector, i + 1));
        }
    }
}
