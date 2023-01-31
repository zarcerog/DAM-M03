package com.zarcero.UF2.Recursion;

public class ZarceroNicolás_Exercici3 {
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sumaVector(vector, 0));
    }

    public static int sumaVector(int[] vector, int i){
        if (i == vector.length){
            return 0;
        } else {
            return vector[i] + sumaVector(vector, i+1);
        }
    }
}
