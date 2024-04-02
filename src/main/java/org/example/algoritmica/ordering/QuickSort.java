package org.example.algoritmica.ordering;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class QuickSort {

    // funcion que permite intercambiar elementos de un array
    public void swap(int[] values, int i, int j) {
        int aux = values[i];
        values[i] = values[j];
        values[j] = aux;
    }

    public void sort(int[] values, int iStart, int iEnd) {
        if (iStart >= iEnd)
            return;

        int i = iStart;
        int j = iEnd;
        int indexPivote = i; // inicialmente 0
        boolean leftToRight = false;

        while (i < j) {
            if (leftToRight) {
                while (values[indexPivote] > values[i])
                    i++;

                swap(values, indexPivote, i);
                indexPivote = i;
                j--;
                leftToRight = false;
            } else {
                while (values[indexPivote] < values[j])
                    j--;

                swap(values, indexPivote, j);
                indexPivote = j;
                i++;
                leftToRight = true;
            }
        }

        sort(values, iStart, indexPivote - 1);
        sort(values, indexPivote + 1, iEnd);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        //int[] values = new int[] {3, 0, 1, 4, 2, 5};
        //int[] values = new int[] {4, 3, 0, 1, 5, 7, 2, 9, 6};
        int[] values = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 9};
        quickSort.sort(values, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
    }
}
