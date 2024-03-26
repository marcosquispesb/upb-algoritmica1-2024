package org.example.algoritmica.ordering;

import java.util.Arrays;

/**
 * Ordering
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Ordering {

    public void bubbleSort(int[] values) {
        for (int limit = values.length - 2; limit > 0 ; limit--) {
            for (int i = 0; i <= limit; i++) {
                if (values[i] > values[i + 1])
                    swap(values, i, i + 1);
            }
        }
    }

    // funcion que permite intercambiar elementos de un array
    private void swap(int[] values, int i, int j) {
        int aux = values[i];
        values[i] = values[j];
        values[j] = aux;
    }

    public static void main(String[] args) {
        Ordering ordering = new Ordering();
        int[] values;

        values = new int[] {3, 0, 1, 4, 2, 5, 1};
        ordering.bubbleSort(values);
        System.out.println(Arrays.toString(values));
    }
}
