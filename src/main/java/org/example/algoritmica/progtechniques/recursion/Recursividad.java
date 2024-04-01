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
        return -1;
    }

    long factorialRec(long n) {
        return -1;
    }

    long fibonacciRec(int n) {
        return -1;
    }

    public static void main(String[] args) {
        Recursividad rec = new Recursividad();
    }

}
