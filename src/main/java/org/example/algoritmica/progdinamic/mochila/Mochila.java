package org.example.algoritmica.progdinamic.mochila;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mochila {

    /**
     * Tarea1: Modificar el algoritmo countWays para que dada una suma, retorne la mejor opcion donde se tomen las monedas mas grandes
     * 
     * // 1 2 3
     * // sum: 4, retornar: 3 1
     * // sum: 5, retornar: 3 2
     * // sum: 6, retornar: 3 3
     * // sum: 7, retornar: 3 3 1
     * // sum: 8, retornar: 3 3 2
     *
     * // 2, 3, 10
     * // sum: 14, retornar: 10 2 2
     *
     * // 2, 3, 5, 6
     * // suma: 11, retornar: 6 5
     * // suma: 13, retornar: 6 5 2
     */
    
    /**
     * Tarea2: Modificar el algoritmo mochila para poder imprimir los casos validos donde se logra completar el espacio
     */
    public static MaxBeneficio mochila(List<Article> articles, int espacio, int pos, int benefAcumulado, List<Article> solucion) {
        //solucion.add(new Article("x", 1, 2));
        if (espacio == 0) {
            return new MaxBeneficio(benefAcumulado, new ArrayList<>(solucion));
        }
        if (espacio < 0)
            return null;

        MaxBeneficio maxBeneficio = null;
        for (int i = pos; i < articles.size(); i++) {
            solucion.add(articles.get(i));

            MaxBeneficio beneficio = mochila(articles, espacio - articles.get(i).getEspacio(), i + 1
                    , benefAcumulado + articles.get(i).getBeneficio(), solucion);
            if (beneficio != null) {
                if (maxBeneficio == null)
                    maxBeneficio = beneficio;
                if (beneficio.getBeneficios() > maxBeneficio.getBeneficios())
                    maxBeneficio = beneficio;
            }

            solucion.remove(articles.get(i));
        }

        return maxBeneficio;
    }

    public static void printArticles(List<Article> articles) {
        for (Article article : articles) {
            System.out.println(String.format("esp: %s, ben: %s, %s", article.getEspacio(), article.getBeneficio(), article.getNombre()));
        }
    }

    public static void main(String[] args) {

        List<Article> articles = Arrays.asList(
                new Article("Aseo", 10, 5)
                , new Article("Osito", 4, 3)
                , new Article("Alimentos", 20, 15)
                , new Article("Video Juegos", 6, 3)
                , new Article("Platos y Cubiertos", 8, 4)
                , new Article("Abrelatas", 1, 1)
                , new Article("Libro", 15, 9)
                , new Article("Telefono", 2, 2)
                , new Article("Encendedor", 6, 3)
                , new Article("Reloj", 5, 3)
                , new Article("Navaja", 10, 4)
                , new Article("Ropa", 10, 7)
        );
        
        //int maxBeneficio = mochila(articles, 30, 0, 0, new ArrayList<>());
        List<Article> solucion = new ArrayList<>();
        MaxBeneficio maxBeneficio = mochila(articles, 30, 0, 0, solucion);
        printArticles(solucion);
        if (maxBeneficio != null) {
            System.out.println("solucion:");
            printArticles(maxBeneficio.getSolucion());
            System.out.println("maxBeneficio: " + maxBeneficio.getBeneficios());
        }
    }
}
