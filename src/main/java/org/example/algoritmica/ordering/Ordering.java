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
