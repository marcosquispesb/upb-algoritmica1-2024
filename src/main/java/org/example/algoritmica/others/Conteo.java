package org.example.algoritmica.others;

/**
 * Conteo
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Conteo {

    // T[n] --------------------------------------------------------
    private void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public int otro(int n) {
        int c;
        int b = 5;
        int a = 1;
        while (a <= b) {
            c = a + b;
            a++;
        }
        return n * a;
    }

    public long fibo(int n) {
        long f2 = 1;
        long f1 = 0;
        long actual = 0;
        int i = 0;
        while (i < n) {
            actual = f1 + f2;
            f2 = f1;
            f1 = actual;
            i++;
        }

        return actual;
    }

    public int pro1(int n) {
        int a = 1;
        int c = 0;
        while (a <= n) {
            int b = 0;
            while (b < n - 1) {
                b++;
                c++;
            }
            a++;
        }
        return c;
    }

    public int pro2(int n) {
        int a = 0;
        int c = 0;
        while (a <= n + 1) {
            int b = 0;
            while (b < a) {
                b++;
                c++;
            }
            a++;
        }
        return c;
    }

    public int pro3(int n) { // para practica en clase
        int a = 0; int c = 0;
        while (a < n + 1) {
            int b = a;
            while (b <= 2 * n) {
                b++;
                c++;
            }
            a++;
        }
        return c * n;
    }

    public int complex1(int n) {
        int a = 0; int c = 0;
        while (a < n) {
            int b = 0;
            while (b < n) {
                c = b;
                while (c < n) {
                    c++;
                }
                b++;
            }
            a++;
        }
        return c;
    }

    public void complex2(int n) {
        int a = 1; int m = 1;
        while (a <= n - 1) {
            int b = a + 1;
            while (b <= n) {
                int c = 1;
                while (c <= b) { // variante c < n
                    System.out.println("c impresed");
                    m = m * 2;
                    c++;
                }
                b++;
            }
            a++;
        }
    }

    // T[n] mejor y peor caso --------------------------------------
    public int max(int[] v) {
        int max = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > max)
                max = v[i];
        }
        return max;
    }

    public void bubbleSort(int[] v) {
        int limit = v.length - 2;
        while (limit > 0) {
            int i = 0;
            while (i <= limit) {
                if (v[i] > v[i + 1])
                    swap(v, i, i + 1);
                i++;
            }
            limit--;
        }
    }

    public boolean busBin(int[] v, int nro) {
        int i = 0;
        int f = v.length - 1;
        boolean hallado = false;
        while (i <= f && !hallado) {
            int m = (i + f) / 2;
            if (v[m] == nro) {
                hallado = true;
            } else if (nro < v[m]) {
                f = m - 1;
            } else {
                i = m + 1;
            }
        }
        return hallado;
    }

    public static void main(String[] args) {
        Conteo c = new Conteo();
//        c.otro(10);
//
//        System.out.println(c.fibo(7));

        //int[] values = {0, 1, 2, 3, 4};
        //System.out.println(c.max(values));
        c.complex1(7);

    }
}
