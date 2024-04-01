package org.example.algoritmica.progtechniques.recursion;

import java.util.Arrays;

/**
 * Iterativos
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Iterativos {

    int max(int[] values) {
        int result = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > result)
                result = value;
        }

        return result;
    }

    int max2(int[] values) {
        return Arrays.stream(values).max().getAsInt();
    }

    long factorial(long n) {
        if (n == 0)
            return 1;

        long result = 1;
        for (int i = 1; i < n + 1; i++) {
            result = result * i;
        }

        return result;
    }

    long fibo(long[] values) {
        long f2 = 1;
        long f1 = 0;
        long f = 0;
        for (int i = 0; i < values.length; i++) {
            f = f1 + f2;

            values[i] = f;
            f2 = f1;
            f1 = f;
        }

        return f;
    }

    public static void main(String[] args) {
        Iterativos ite = new Iterativos();
        long timeMillis;

        int number = 25;
        timeMillis = System.currentTimeMillis();
        System.out.println("" + number + "!: " + ite.factorial(number) + " time: " + (System.currentTimeMillis() - timeMillis) + " ms");

        long[] fiboValues;

        timeMillis = System.currentTimeMillis();
        fiboValues = new long[92];
        ite.fibo(fiboValues);
        System.out.println(String.format("fibo: %s time: %s ms", Arrays.toString(fiboValues), System.currentTimeMillis() - timeMillis));

        //int[] numbers = new int[] {10, 5};
        //int[] numbers = new int[] {10, 5, 2, 4, 1, 8, 3};
        int[] numbers = new int[] {100, 5, 2, 4, 1, 8, 3, 0, 10, 20, 30, 25, 80, 90, 15, 56, 70, 98, 99};

        timeMillis = System.currentTimeMillis();
        System.out.printf("max: %s time: %s ms", ite.max(numbers), System.currentTimeMillis() - timeMillis);
    }

}
