package org.example.algoritmica.progdinamic.mcm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * MCM
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class MCM {

    public static List<String> getNombres(List<Matriz> matrices, int posInicio, int posFin) {
        return matrices.subList(posInicio, posFin).stream()
                .map(Matriz::getNombre)
                .collect(Collectors.toList());
    }

    public static String getNombresStr(List<Matriz> matrices, int posInicio, int posFin) {
        matrices = matrices.subList(posInicio, posFin);
        String res = "";
        for (Matriz matriz : matrices) {
            res += matriz.getNombre() + " ";
        }
        return res.trim();
    }

    public static int mcm1(List<Matriz> matrices, int from, int to) {
        System.out.println("from: " + from + ", to: " + to);
        System.out.println(getNombresStr(matrices, from, to + 1));
        if (from == to)
            return 0;
        if (from + 1 == to)
            return matrices.get(from).getNroFilas() * matrices.get(from).getNroColumnas() * matrices.get(to).getNroColumnas();
        if (from > to)
            return 0;

        int minimoOperaciones = Integer.MAX_VALUE;
        for (int k = from; k < to; k++) {
            int minOpIzq = mcm1(matrices, from, k);
            int minOpDer = mcm1(matrices, k + 1, to);

            int nroOp = matrices.get(from).getNroFilas() * matrices.get(k).getNroColumnas() * matrices.get(to).getNroColumnas();
            int res = minOpIzq + minOpDer + nroOp;
            //System.out.println("res: " + res);
            minimoOperaciones = Math.min(res, minimoOperaciones);
        }
        return minimoOperaciones;
    }

    public static int mcm2(List<Matriz> matrices, int from, int to, Map<String, Integer> memoryMap) {
        //System.out.println("from: " + from + ", to: " + to);
        System.out.println("mcm2: " + getNombresStr(matrices, from, to + 1));
        if (from == to)
            return 0;
        if (from + 1 == to)
            return matrices.get(from).getNroFilas() * matrices.get(from).getNroColumnas() * matrices.get(to).getNroColumnas();
        if (from > to)
            return 0;

        String key = "" + from + "-" + to;
        if (memoryMap.containsKey(key))
            return memoryMap.get(key);

        int minimoOperaciones = Integer.MAX_VALUE;
        for (int k = from; k < to; k++) {
            int minOpIzq = mcm2(matrices, from, k, memoryMap);
            int minOpDer = mcm2(matrices, k + 1, to, memoryMap);

            int nroOp = matrices.get(from).getNroFilas() * matrices.get(k).getNroColumnas() * matrices.get(to).getNroColumnas();
            int res = minOpIzq + minOpDer + nroOp;
            //System.out.println("res: " + res);
            minimoOperaciones = Math.min(res, minimoOperaciones);
        }

        memoryMap.put(key, minimoOperaciones);

        return minimoOperaciones;
    }

    public static void main(String[] args) {
        List<Matriz> matrices;

//        matrices = Arrays.asList(
//                new Matriz("A", 2, 3)
//                , new Matriz("B", 3, 4)
//                , new Matriz("C", 4, 2)
//        ); // 4500
        //System.out.println(getNombresStr(matrices, 0, 3));

        matrices = Arrays.asList(
                new Matriz("A", 2, 3)
                , new Matriz("B", 3, 3)
                , new Matriz("C", 3, 4)
                , new Matriz("D", 4, 2)
                , new Matriz("E", 2, 5)
                , new Matriz("F", 5, 4)
                , new Matriz("G", 4, 3)
        ); // 54

//        Map<String, Integer> map1= new HashMap<>();
//        map1.put("B", 10);
//        map1.put("A", 15);
//        map1.put("C", 20);
//        System.out.println(map1);

//        Map<String, Integer> map2= new LinkedHashMap<>();
//        map2.put("B", 10);
//        map2.put("A", 15);
//        map2.put("C", 20);
//        System.out.println(map2);

        Map<String, Integer> memoryMap = new HashMap<>();
        int minOp = mcm2(matrices, 0, matrices.size() - 1, memoryMap);
        System.out.println();
        System.out.println("minOp: " + minOp);
    }


}
