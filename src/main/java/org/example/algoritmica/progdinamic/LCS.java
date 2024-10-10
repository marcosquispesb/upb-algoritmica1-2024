package org.example.algoritmica.progdinamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCS
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class LCS {

    public static List<String> lcs(String cadena1, String cadena2) {
        int[][] mat = new int [cadena1.length() + 1][cadena2.length() + 1];
        System.out.println("nroFil: " + mat.length);
        System.out.println("nroCol: " + mat[0].length);
        for (int f = 1; f < cadena1.length() + 1; f++) {
            for (int c = 1; c < cadena2.length() + 1; c++) {
                if (cadena1.charAt(f - 1) == cadena2.charAt(c - 1)) { // iguales
                    mat[f][c] = mat[f - 1][c - 1] + 1;
                } else {
                    int max = Math.max(mat[f - 1][c], mat[f][c - 1]);
                    mat[f][c] = max;
                }
            }
        }

        printMatriz(mat);
        return getResultsLcs(cadena1, cadena2, mat, cadena1.length(), cadena2.length(), "");
    }

    private static List<String> getResultsLcs(String cadena1, String cadena2, int[][] mat, int f, int c, String acumulado) {
        if (f == 0 || c == 0)
            return new ArrayList(1){{add(acumulado);}};

        if (cadena1.charAt(f - 1) == cadena2.charAt(c - 1)) { // iguales
            return getResultsLcs(cadena1, cadena2, mat, f - 1, c - 1, "" + cadena1.charAt(f - 1) + acumulado);
        } else {
            if (mat[f][c - 1] == mat[f - 1][c]) {
                List<String> resultList = getResultsLcs(cadena1, cadena2, mat, f, c - 1, acumulado);
                resultList.addAll(getResultsLcs(cadena1, cadena2, mat, f - 1, c, acumulado));
                return resultList;
            } else if (mat[f][c - 1] > mat[f - 1][c]) {
                return getResultsLcs(cadena1, cadena2, mat, f, c - 1, acumulado);
            } else {
                return getResultsLcs(cadena1, cadena2, mat, f - 1, c, acumulado);
            }
        }
    }

    public static void printMatriz(int[][] mat) {
        for (int v = 0; v < mat.length; v++) {
            System.out.print('[');
            for (int h = 0; h < mat[v].length; h++) {
                System.out.print(mat[v][h]);
                if (mat[v].length - 1 == h)
                    System.out.println(']');
                else
                    System.out.print(",");
            }
        }
    }

    public static void main(String[] args) {
        String cadena1;
        String cadena2;

        cadena1 = "ABCBDAB";
        cadena2 = "BDCABA";
        System.out.println(lcs(cadena1, cadena2));
    }
}
