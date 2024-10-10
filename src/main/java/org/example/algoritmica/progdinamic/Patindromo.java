package org.example.algoritmica.progdinamic;

/**
 * Patindromo
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Patindromo {

    public static String patindromo(String value) {
        //String result = patindromo(value, 0, value.length() - 1, "");
        String maxPatrindromo = "";
        for (int i = value.length() - 1; i > -1 ; i--) {
            String caso = patindromo(value, 0, i, "");
            if (caso != null && caso.length() > maxPatrindromo.length())
                maxPatrindromo = caso;
        }

        return maxPatrindromo;
    }

    public static String patindromo(String value, int from, int to, String acumulado) {
        System.out.println("value: " + value.substring(from, to + 1));
        //System.out.println("from: " + from + ", to: " + to);
        if (from == to)
            return ""+value.charAt(to);

        if (from + 1 == to && value.charAt(from) == value.charAt(to))
            return ""+value.charAt(from) + value.charAt(to);

        String maxPatrindromo = "";
        for (int i = from; i < to; i++) {
            if (value.charAt(i) == value.charAt(to)) {
                String caso = patindromo(value, i + 1, to - 1, acumulado + value.charAt(i));
                if (caso.length() > maxPatrindromo.length())
                    maxPatrindromo = caso;
            }
        }

        if (maxPatrindromo.isEmpty())
            return ""+value.charAt(to);

        return value.charAt(to) + maxPatrindromo + value.charAt(to);
    }

    public static void main(String[] args) {
//        System.out.println(patindromo("MERODEADOR"));
//        System.out.println(patindromo("RECONOCER"));
//        System.out.println(patindromo("ARADAROSOSOMI"));
//        System.out.println(patindromo("OSORASODAR"));
//        System.out.println();
//        System.out.println(patindromo("MERODEADORAR"));
//        System.out.println(patindromo("ARADAROSOOSOMI"));
//        System.out.println(patindromo("ARADAROSOIROSOMI"));
//        String s = "ABCDE";
//        System.out.println(s.substring(1, 3));
    }
}
