package org.example.algoritmica.theorynum.rsa;

import org.example.algoritmica.theorynum.Primos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class EncriptacionRSA {

    public static Map<Character, Integer> codesMap = defineMapCodes();

    private static Map<Character, Integer> defineMapCodes() {
        Map<Character, Integer> codesMap = new HashMap<Character, Integer>();

        // Mayusculas
        for (int i = 65; i < 91; i++) {
            codesMap.put((char) i, i - 65);
        }

        // Espacio
        codesMap.put(' ', codesMap.size());

        return codesMap;
    }

    private static int getE(int fiN) {
        List<Integer> primos = Primos.primosMenoresA(fiN).stream()
                .map(x -> Integer.parseInt("" + x)).collect(Collectors.toList());

        primos = primos.stream().filter(x -> fiN % x != 0).collect(Collectors.toList());
        return primos.get(new Random().nextInt(primos.size()));
    }

    private static int getD(int fiN, int e) {
        int k = 0;
        while (true) {
            int numerador = 1 + (k * fiN);
            if (numerador % e == 0) {
                System.out.println("k: " + k);
                return numerador / e;
            }
            k++;
        }
    }

    public static RSA getDatosRSA(int p, int q) {
        int n = p * q;
        int fiN = (p - 1) * (q - 1);

        int e = getE(fiN);
        int d = getD(fiN, e);

        return RSA.builder()
                .p(p)
                .q(q)
                .n(n)
                .fiN(fiN)
                .e(e)
                .d(d)
                .build();
    }

    public static String cifrar(String input, RSA rsa) {
        StringBuilder result = new StringBuilder();

        // Cada caracter a su entrada
        for (char c : input.toUpperCase().toCharArray()) {
            // C = M^e mod n
//            int M = codesMap.get(c);
            // Manejar la operacion pow con integers hara que se desborden los numeros, por eso lo conveniente son bigdecimals
//            int C = (int) Math.pow(M, llavePublica.getKey() % llavePublica.getN();
//            System.out.println("M: " + M + " e: " + llavePublica.getKey() + ", C: " + C);
//            result.append(C).append(" ");
            BigDecimal M = new BigDecimal(codesMap.get(c));
            BigDecimal C = M.pow(rsa.getE()).remainder(new BigDecimal(rsa.getN()));
            result.append(C.toPlainString()).append(" ");
        }

        return result.toString().trim();
    }

    public static String decifrar(String input, RSA rsa) {
        StringBuilder result = new StringBuilder();

        // Cada caracter a su entrada
        for (String codCifrado : input.split(" ")) {
            // M = C^d mod n
            // Manejar la operacion pow con integers hara que se desborden los numeros, por eso lo conveniente son bigdecimals
//            int M = (int) Math.pow(Integer.parseInt(codCifrado), llavePrivada.getKey()) % llavePrivada.getN();
            BigDecimal C = new BigDecimal(codCifrado);
            BigDecimal M = C.pow(rsa.getD()).remainder(new BigDecimal(rsa.getN()));

            Character letra ='0';
            for (Map.Entry<Character, Integer> entry : codesMap.entrySet()) {
                if (entry.getValue() == M.intValue()) {
                    letra = entry.getKey();
                    break;
                }
            }
            //System.out.println("M: " + M + ", C: " + C);
            result.append(""+letra);
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        RSA rsa = getDatosRSA(5, 11);
        System.out.println(rsa);
        System.out.println();
        String mensaje = "HOLA MUNDO XYZ";
        String codificado = cifrar(mensaje, rsa);
        System.out.println(codificado);
        String descifrado = decifrar(codificado, rsa);
        System.out.println(descifrado);
    }

}
