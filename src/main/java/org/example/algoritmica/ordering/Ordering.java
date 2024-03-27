package org.example.algoritmica.ordering;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Ordering
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Ordering {

    //region [Bubble Sort] --------------------------------------------------------------------------
    public void bubbleSort(int[] values) {
        for (int limit = values.length - 2; limit > 0 ; limit--) {
            for (int i = 0; i <= limit; i++) {
                if (values[i] > values[i + 1])
                    swap(values, i, i + 1);
            }
        }
    }

    public void bubbleSortImproved(int[] values) {

    }

    // funcion que permite intercambiar elementos de un array
    private void swap(int[] values, int i, int j) {
        int aux = values[i];
        values[i] = values[j];
        values[j] = aux;
    }
    //endregion

    //region [Radix Sort] --------------------------------------------------------------------------
    public static int max(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > max)
                max = value;
        }
        return max;
    }

    public static int countDigits(int nro) {
        int length = 0;
        while (nro > 0) {
            nro = nro / 10;
            length++;
        }
        return length;
    }

    public static void radixSort(int[] values) {

    }
    //endregion

    public static void main(String[] args) {
        Ordering ordering = new Ordering();
        int[] values;

        values = new int[] {3, 0, 1, 4, 2, 5, 1};
        //values = new int[] {0, 1, 1, 2, 3, 4, 5};
        ordering.bubbleSort(values);
        System.out.println(Arrays.toString(values));

        // -----------------------------------------------

        values = new int[] {352, 62, 56, 3, 16, 353};
        radixSort(values);
        System.out.println(Arrays.toString(values));
    }
}
