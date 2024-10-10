package org.example.algoritmica.progdinamic;

import java.util.*;

public class Por3Mas5 {

    public static boolean por3omas5(int actual, int objetivo, Map<Integer, Boolean> memoryMap) {
        System.out.println("por3omas5: " + actual);
        if (actual == objetivo)
            return true;

        if (actual > objetivo)
            return false;

        if (memoryMap.containsKey(actual))
            return memoryMap.get(actual);

        boolean resultado = por3omas5(actual * 3, objetivo, memoryMap)
                || por3omas5(actual + 5, objetivo, memoryMap);
        memoryMap.put(actual, resultado);

        return resultado;
    }

    public static void main(String[] args) {
        Map<Integer, Boolean> memoryMap = new HashMap<>();
        System.out.println(por3omas5(1,18000, memoryMap));
    }
}
