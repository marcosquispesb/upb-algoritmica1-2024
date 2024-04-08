package org.example.algoritmica.progtechniques.divideandconquer;

import java.util.Arrays;

/**
 * MergeSort
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class MergeSort {

    public static void mergeSort(int[] values) {
        System.out.println(Arrays.toString(values));
        if (values.length == 1)
            return;

        int medio = values.length / 2;
        if (values.length % 2 == 1) // impar
            medio = (values.length / 2) + 1;

        int[] left = Arrays.copyOfRange(values, 0, medio);
        int[] right = Arrays.copyOfRange(values, medio, values.length);
        mergeSort(left);
        mergeSort(right);

        int menor = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < values.length; i++) {
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    menor = left[l];
                    l++;
                } else {
                    menor = right[r];
                    r++;
                }
            } else if (l < left.length) {
                menor = left[l];
                l++;
            } else if (r < right.length) {
                menor = right[r];
                r++;
            }
            values[i] = menor;
        }
    }

    public static void main(String[] args) {
        int[] values = {7, 6, 1, 5, 4, 3};
        mergeSort(values);
        System.out.println(Arrays.toString(values));

        //System.out.println(6 % 2);
        //System.out.println(5 % 2);
    }
}
