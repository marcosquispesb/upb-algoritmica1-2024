package org.example.algoritmica.progdinamic;

/**
 * Varillas
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Varillas {

    public static int corteVarillas(int[] longitudes, int[] precios, int longVarilla, int pos, int precioAcumulado) {
        if (longVarilla == 0) {
            //System.out.println("way: " + way);
            return precioAcumulado;
        }
        if (longVarilla < 0) {
            //System.out.println("way: " + way);
            return 0;
        }

        int maxPrecio = 0;
        for (int i = pos; i < longitudes.length; i++) {
            int precio = corteVarillas(longitudes, precios, longVarilla - longitudes[i], i, precioAcumulado + precios[i]);
            maxPrecio = Math.max(maxPrecio, precio);
        }
        return maxPrecio;
    }

    public static void main(String[] args) {
        int[] longitudes = {1, 2, 3, 4};
        int[] precios = {1, 5, 8, 9};

        int maxPrecio = corteVarillas(longitudes, precios, 5, 0, 0);
        System.out.println("maxPrecio: " + maxPrecio);
    }
}
