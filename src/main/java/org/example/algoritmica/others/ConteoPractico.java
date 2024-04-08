package org.example.algoritmica.others;

import java.util.Arrays;

/**
 * ConteoPractico
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class ConteoPractico {

    private void swap(int[] values, int i, int j) {
        int aux = values[i];
        values[i] = values[j];
        values[j] = aux;
    }

    // Calcular T[n]
    public void pro4(int n) {
        int x = n;
        int a = 4;
        while (a < n) {
            int i = 1;
            while (i <= a + 2) {
                i++;
            }
            int j = 0;
            while (j < 7) {
                j++;
            }
            a++;
        }
    }

    // Calcular T[n]
    public int pro5(int n) {
        int a = 0;
        int c = 0;
        while (a < n) {
            int b = n - a;
            while (b > 0) {
                b--;
                c++;
            }
            a++;
        }
        return c;
    }

    // Calcular T[n]
    public int complex3(int n) {
        int a = 0; int r = 0;
        while (a <= n) {
            int b = 0;
            while (b < n) {
                int c = n + 1;
                while (c >= 0) {
                    c--;
                    r = r + 2;
                }
                b++;
            }
            a++;
        }
        return r;
    }

    // Calcular T[n] para mejor y peor caso
    public void selectionSort(int[] v) {
        int posMenor;
        int i = 0;
        while (i < v.length - 1) {
            posMenor = i;
            int j = i + 1;
            while (j < v.length) {
                if (v[j] < v[posMenor])
                    posMenor = j;
                j++;
            }
            swap(v, i, posMenor);
            i++;
        }
    }
    
    public static void main(String[] args) {
        ConteoPractico c = new ConteoPractico();

        int[] values;
        values = new int[]{0, 1, 2, 3, 4};
        values = new int[]{3, 1, 0, 2, 4};
        c.selectionSort(values);
        System.out.println(Arrays.toString(values));

        c.pro4(5);
        c.pro5(5);
    }

}
