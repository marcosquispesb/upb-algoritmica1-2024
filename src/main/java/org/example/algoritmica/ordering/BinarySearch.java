package org.example.algoritmica.ordering;

import java.util.Arrays;

/**
 * BinarySearch
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class BinarySearch {

    public static boolean busquedaBin(int[] values, int nro) {
        int iStart = 0;
        int iEnd = values.length - 1;

        return false;
    }

    public static void main(String[] args) {
        int[] values = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(busquedaBin(values, 6));
        System.out.println(busquedaBin(values, 1));
        System.out.println(busquedaBin(values, -1));
        System.out.println(busquedaBin(values, 11));
    }
}
