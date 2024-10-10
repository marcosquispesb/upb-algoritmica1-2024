package org.example.algoritmica.progdinamic;

import java.util.Arrays;

/**
 * AnalisisCombinatorio
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class AnalisisCombinatorio {

    // Función de utilidad para intercambiar dos caracteres en una array de caracteres
    private static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    // Función recursivo para generar todas las permutaciones de una string
    private static void permutaciones(int[] values) {
        permutaciones(values, 0);
    }
    private static void permutaciones(int[] values, int currentIndex) {
        if (currentIndex == values.length - 1) {
            System.out.println("permutacion: " + Arrays.toString(values));
            return;
        }

        for (int i = currentIndex; i < values.length; i++) {
            //System.out.println(Arrays.toString(values) + " ci="+currentIndex + " i="+i);
            swap(values, currentIndex, i);
            permutaciones(values, currentIndex + 1);
            swap(values, currentIndex, i);
        }
    }

//    public static void permutaciones2(int[] values, int positionOriginal, Integer[] permutation) {
//        for (int i = 0; i < values.length; i++) {
//            if (permutation[i] == null) {
//                System.out.println(Arrays.toString(permutation));
//                permutation[i] = values[positionOriginal];
//                permutaciones2(values, positionOriginal + 1, permutation);
//
//                if (positionOriginal == values.length - 1) { // permutacion lograda
//                    System.out.println("permutacion2: " + Arrays.toString(permutation));
//                }
//
//                permutation[i] = null;
//            }
//        }
//    }

    public static void combinaciones(int[] values, int k) {
        combinaciones(values, k, 0, 0, new int[k]);
    }
    public static void combinaciones(int[] values, int k, int ki, int vi, int[] result) {
        if (ki == k) {
            System.out.println("combinacion: " + Arrays.toString(result));
            return;
        }

        for (int i = vi; i < values.length; i++) {
            result[ki] = values[i];
            combinaciones(values, k, ki + 1, i + 1, result);
            result[ki] = 0;
        }
    }

    public static void variaciones(int[] values, int k) {
        variaciones(values, k, 0, 0, new int[k]);
    }
    public static void variaciones(int[] values, int k, int ki, int vi, int[] result) {
        if (ki == k) {
            permutaciones(result);
            System.out.println();
            return;
        }

        for (int i = vi; i < values.length; i++) {
            result[ki] = values[i];
            variaciones(values, k, ki + 1, i + 1, result);
            result[ki] = 0;
        }
    }

    public static void main(String[] args) {
        int[] values;

        //int[] values = {10, 20, 30, 40, 50, 60};
        values = new int[] {10, 20, 30, 40};
//        permutaciones(values);
//        combinaciones(values, 2);
        variaciones(values, 3);
    }
}
