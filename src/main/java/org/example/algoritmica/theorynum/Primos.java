package org.example.algoritmica.theorynum;

import java.util.ArrayList;
import java.util.List;

public class Primos {

    // solucion no optima
    public static boolean esPrimoMalo(long numero) {
        if (numero <= 1)
            return false;

        long i = 2;
        while (i < numero) {
            if (numero % i == 0)
                return false;
            i++;
        }
        return true;
    }

    // solucion optima
    public static boolean esPrimo(long numero) {
        if (numero <= 1)
            return false;
        if (numero == 2)
            return true;
        if (numero % 2 == 0) // es par
            return false;

        long i = 3;
        //long limite = numero / 2;
        long limite = (long) Math.sqrt(numero);
        while (i <= limite) {
            System.out.println("esPrimo2");
            if (numero % i == 0)
                return false;
            i += 2;
        }
        return true;
    }

    public static boolean esPrimo(long numero, List<Long> primosEncontrados) {
        if (numero < 2)
            return false;
        if (numero == 2)
            return true;
        if (numero % 2 == 0) // es par
            return false;

        long limite = (long) Math.sqrt(numero);
        for (int i = 1; i < primosEncontrados.size(); i++) {
            //System.out.println("esPrimo3");
            if (numero % primosEncontrados.get(i) == 0)
                return false;
            if (primosEncontrados.get(i) > limite)
                break;
        }
        return true;
    }

    public static List<Long> primosMenoresA(long numero) {
        List<Long> resultList = new ArrayList<>();
        for (long i = 1; i <= numero ; i++) {
            if (esPrimo(i, resultList))
                resultList.add(i);
            // TODO se puede mejorar considerando solo los impares
        }
        return resultList;
    }

    public static void main(String[] args) {
//        int nro = 7;
//        System.out.println(nro / 2);
//        System.out.println(nro % 2);
        //System.out.println(esPrimo(997)); // 995 resultados
//        System.out.println(esPrimoMalo(1));
//        System.out.println(esPrimoMalo(2));
//        System.out.println(esPrimoMalo(3));
//        System.out.println(esPrimoMalo(5));
//        System.out.println(esPrimoMalo(6));
//        System.out.println(esPrimoMalo(7));
//        System.out.println(esPrimoMalo(9));

        List<Long> primos = primosMenoresA(997); // 2350 esPrimo2
        System.out.println(primos);
        System.out.println("size: " + primos.size());
    }
}
