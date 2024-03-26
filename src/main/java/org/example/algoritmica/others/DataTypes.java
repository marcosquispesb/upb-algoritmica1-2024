package org.example.algoritmica.others;

import java.util.Arrays;
import java.util.List;

/**
 * DataTypes
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class DataTypes {
    public static void aux(int nro) {
        System.out.println(nro);
    }

    public static void main(String[] args) {
        // primitivos: no tienen metodos, no aceptan null
        // boolean, int, long, double, char
        int n1 = 7;
        System.out.println(n1);
        boolean state = true;
        System.out.println(state);

        // Wrappers: tienen metodos, aceptan valores nulos, sus clases tienen constantes
        // Boolean, Integer, Long, Double, Character
        Integer n2 = 7;
        System.out.println(n1);
        n2 = null;
        Boolean state2 = true;
        System.out.println(state2);

        n2 = 6;
        aux(n2);
        // ------------------------------------------------------
        // String: es inmutable, tienen metodos, aceptan valores nulos

        String s = "Hola mundo";
        s = null;
        s = "Hola mando";
        System.out.println(s);

        // ------------------------------------------------------
        // array: se usa new, acepta primitivos|wrappers|Otras Clases.

        int[] array0 = new int[5];
        array0[0] = 1;
        System.out.println(Arrays.toString(array0));

        int[] arrayPrim = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(arrayPrim));

        Integer[] arrayWrap = new Integer[5];
        System.out.println(Arrays.toString(arrayWrap));

        boolean[] arrayBoolP = new boolean[5];
        System.out.println(Arrays.toString(arrayBoolP));

        Boolean[] arrayBoolW = new Boolean[5];
        System.out.println(Arrays.toString(arrayWrap));

        //User user = new User();
        User[] arrayUsers = new User[]{
                new User("Omar", 17)
                , new User("Ariana", 15)
        };
        System.out.println(Arrays.toString(arrayUsers));

        //List<int> list;
        //List<Arrays> list;
    }
}
