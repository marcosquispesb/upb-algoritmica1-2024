package org.example.algoritmica.ordering;

import java.util.ArrayList;
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
        for (int limit = values.length - 2; limit > 0 ; limit--) { // define limite
            for (int i = 0; i <= limit; i++) { // burbujeando
                //System.out.println("bs normal");
                if (values[i] > values[i + 1])
                    swap(values, i, i + 1);
            }
        }
    }

    public void bubbleSortImproved(int[] values) {
        int limit = values.length - 2;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= limit; i++) { // burbujeando
                //System.out.println("bs improved 1");
                if (values[i] > values[i + 1]) {
                    swap(values, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public void bubbleSortImproved2(int[] values) {
        int limit = values.length - 2;
        int nextLimit;
        do {
            nextLimit = 0;
            for (int i = 0; i <= limit; i++) { // burbujeando
                //System.out.println("bs improved 2");
                if (values[i] > values[i + 1]) {
                    swap(values, i, i + 1);
                    nextLimit = i;
                }
            }
            limit = nextLimit;
        } while (limit > 0);
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
//        int max = Integer.MIN_VALUE;
//        for (int value : values) {
//            if (value > max)
//                max = value;
//        }
//        return max;
        return Arrays.stream(values).max().orElseThrow(NoSuchElementException::new);
    }

    public static int countDigits(int nro) {
//        int length = 0;
//        while (nro > 0) {
//            nro = nro / 10;
//            length++;
//        }
//        return length;
        return (int)(Math.log10(nro) + 1);
    }

    // 1. definir buckets
    // 2. definir valor k (cantidad digitos maximo elemento)
    // 3. paso de valores al bucket
    // 4. paso de valores al arreglo original
    public static void radixSortPositive(int[] values) {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        int k = countDigits(max(values));
        int multiplo10 = 1;
        for (int i = 0; i < k; i++) {
            // paso de valores al bucket
            for (int j = 0; j < values.length; j++) {
                int digit = (values[j] / multiplo10) % 10;
                buckets[digit].add(values[j]);
            }

            // paso de valores al arreglo original
            int pos = 0;
            for (int j = 0; j < buckets.length; j++) {
                for (Integer value : buckets[j]) {
                    values[pos] = value;
                    pos++;
                }
                buckets[j].clear();
            }

            multiplo10 = multiplo10 * 10;
        }
    }

    public static void radixSort(int[] values) {
        int[] positives = Arrays.stream(values).filter(x -> x >= 0).toArray();
        int[] negatives = Arrays.stream(values).filter(x -> x < 0).map(x -> (-1) * x).toArray();

        radixSortPositive(positives);
        radixSortPositive(negatives);

        // UNIFICACION
        int pos = 0;
        for (int i = negatives.length; i > 0; i--) {
            //values[negatives.length - i] = negatives[i - 1] * (-1);
            values[pos] = negatives[i - 1] * (-1);
            pos++;
        }
        for (int i = 0; i < positives.length; i++) {
            //values[negatives.length + i] = positives[i];
            values[pos] = positives[i];
            pos++;
        }
    }

    public static int countCharsMax(String[] values) {
        int max = Integer.MIN_VALUE;
        for (String value : values) {
            if (value.length() > max)
                max = value.length();
        }
        return max;
    }

    public static void radixSortStr(String[] values) {
        ArrayList<String>[] buckets = new ArrayList[27];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        int k = countCharsMax(values);
        for (int i = 0; i < k; i++) {
            // paso de valores al bucket
            for (int j = 0; j < values.length; j++) {
                // TODO modificar logica para que funcione correctamente
                int pos = values[j].length();
                buckets[pos].add(values[j]);
            }

            // paso de valores al arreglo original
            int pos = 0;
            for (int j = 0; j < buckets.length; j++) {
                for (String value : buckets[j]) {
                    values[pos] = value;
                    pos++;
                }
                buckets[j].clear();
            }
        }
    }
    //endregion

    public static void main(String[] args) {
        Ordering ordering = new Ordering();
        int[] values;

        //values = new int[] {3, 0, 1, 4, 2, 5, 1};
        //values = new int[] {0, 1, 1, 2, 3, 4, 5};
        //values = new int[] {2, 1, 3, 4, 5, 6};
        values = new int[] {3, 2, 1, 4, 5, 6, 7, 8, 9};
        ordering.bubbleSort(values);
        //values = new int[] {2, 1, 3, 4, 5, 6};
        values = new int[] {3, 2, 1, 4, 5, 6, 7, 8, 9};
        ordering.bubbleSortImproved(values);

        values = new int[] {3, 2, 1, 4, 5, 6, 7, 8, 9};
        ordering.bubbleSortImproved2(values);
        System.out.println(Arrays.toString(values));

        // -----------------------------------------------

        System.out.println();
        values = new int[] {1234, 65, 63, 1245};
        values = new int[] {352, 62, 56, 3, 16, 353};
        radixSortPositive(values);
        System.out.println(Arrays.toString(values));

        values = new int[] {352, 62, 56, 3, 16, 353, -10, -11, -1};
        radixSort(values);
        System.out.println(Arrays.toString(values));

        System.out.println("a - z: " + ((int)'a') + " - " + ((int)'z'));
        System.out.println("A - Z: " + ((int)'A') + " - " + ((int)'Z'));
        System.out.println('A' - 'A');

        String[] valuesStr;
        valuesStr = new String[] {"ab", "c", "a", "ba"};
        valuesStr = new String[] {"a", "c", "h", "bec","alo"};
        System.out.println(Arrays.toString(valuesStr));
        radixSortStr(valuesStr);
        System.out.println(Arrays.toString(valuesStr));

        valuesStr = new String[] {"a", "c", "h", "bec","alo"};
        System.out.println(countCharsMax(valuesStr));
    }
}
