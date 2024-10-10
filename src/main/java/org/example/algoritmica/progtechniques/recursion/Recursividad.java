package org.example.algoritmica.progtechniques.recursion;

import java.util.Arrays;

/**
 * Recursividad
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Recursividad {

    void voidRecursivo(int valor) {
        if (valor == 0) // caso base
            return;

        voidRecursivo(valor - 1);
    }

    int funcionRecursiva(int valor) {
        if (valor == 0) // caso base
            return 1;

        return funcionRecursiva(valor - 1);
    }

    int maxRec(int[] values, int i) {
        if (i == 0)
            return Integer.MIN_VALUE;

        return Math.max(values[i - 1], maxRec(values, i - 1));
    }

    long factorialRec(long n) {
        if (n == 0)
            return 1;

        return n * factorialRec(n -1);
    }

    long fibonacciRec(int n) {
        if (n == -1)
            return 0;
        if (n == -2)
            return 1;

        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    long fibonacciRec(int n, long[] values) {
        System.out.println("fibonacciRec");
        if (n == -1)
            return 0;
        if (n == -2)
            return 1;

        if (values[n] != 0)
            return values[n];

        values[n] = fibonacciRec(n - 1, values) + fibonacciRec(n - 2, values);
        return values[n];
    }

    public static void main(String[] args) {
        Recursividad rec = new Recursividad();

        //System.out.println(rec.factorialRec(4));

        // --------------------------------------------

//        System.out.println(rec.fibonacciRec(6));

        long[] values2 = new long[45];
        rec.fibonacciRec(values2.length - 1, values2);
        System.out.println(Arrays.toString(values2));
    }

}
