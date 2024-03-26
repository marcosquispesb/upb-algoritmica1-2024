package org.example.algoritmica.others;

import java.util.Arrays;

/**
 * ParameterPass
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class ParameterPass {

    public static void passValuePrim(int nro) {
        nro++;
        System.out.println("passValuePrim: nro " + nro);
    }

    public static void passValueWrapp(Integer nro) {
        nro += 2;
        System.out.println("passValueWrapp: nro " + nro);
    }

    public static void passValueString(String s) {
        s = s + " nuevo";
        System.out.println("passValueString: " + s);
    }

    public static void passValueArrayInt(int[] values) {
        values[0] = 150;
        System.out.println("passValueArrayInt: " + Arrays.toString(values));
    }

    public static void passValueArrayBool(Boolean[] values) {
        values[0] = true;
        System.out.println("passValueArrayBool: " + Arrays.toString(values));
    }

    public static void passValueObject(User user) {
        user.setName("Marco Aurelio");
        System.out.println("passValueObject: " + user);
    }

    public static void main(String[] args) {

    }
}
