package org.example.algoritmica.graph.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GrafoM
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class GrafoM {
    public final int MAX_VERTICES = 10000;

    private String[] vertices;
    private Integer[][] mAdyacentes;
    private int cantVertices;

    public GrafoM() {
        vertices = new String[MAX_VERTICES];
        mAdyacentes = new Integer[MAX_VERTICES][MAX_VERTICES];
        cantVertices = 0;
    }

    public void insertarVertice(String vertice) {
        vertices[cantVertices] = vertice;
        cantVertices++;
    }
    public void insertarVertices(String ...vertices) {
        for (String vertice : vertices) {
            insertarVertice(vertice);
        }
    }

    public int getPosVertice(String vertice) {
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i].equals(vertice))
                return i;
        }
        return -1;
    }

    public void insertarArista(String verticeOrigen, String verticeDestino) {
        int posVOrigen = getPosVertice(verticeOrigen);
        int posVDestino = getPosVertice(verticeDestino);
        if (posVOrigen == -1 || posVDestino == -1) {
            System.err.println("No existe alguno de los vertices");
            return;
        }
        mAdyacentes[posVOrigen][posVDestino] = 1;
    }
    public void insertarAristas(String verticeOrigen, String ...verticeDestinos) {
        for (String verticeDestino : verticeDestinos) {
            insertarArista(verticeOrigen, verticeDestino);
        }
    }

    /**
     *
     * @param verticeOrigen
     * @param verticeDestinos vertices separados por coma o espacios
     */
    public void insertarAristas2(String verticeOrigen, String verticeDestinos) {

    }

    public void print() {
        System.out.println("vertices: " + Arrays.toString(vertices));
        for (int f = 0; f < cantVertices; f++) {
            String filaValues = "[";
            for (int c = 0; c < cantVertices; c++) {
                if (mAdyacentes[f][c] == null)
                    filaValues += "- ";
                else
                    filaValues += mAdyacentes[f][c] + " ";
            }
            System.out.println(filaValues + "\b]"); // \b borra el ultimo caracter
        }
    }

    public int cantAristas() {
        int cant = 0;
        for (int f = 0; f < cantVertices; f++) {
            for (int c = 0; c < cantVertices; c++) {
                if (mAdyacentes[f][c] != null)
                    cant++;
            }
        }
        return cant;
    }

    public List<String> getAdyacentesA(String vertice) {
        List<String> adyacentes = new ArrayList<>();
        int posVertice = getPosVertice(vertice);
        if (posVertice == -1) {
            System.err.println("No existe el vertice");
            return adyacentes;
        }
        for (int c = 0; c < cantVertices; c++) {
            if (mAdyacentes[posVertice][c] != null)
                adyacentes.add(vertices[c]);
        }
        return adyacentes;
    }

    /**
     * Funcion que retorna true si existe una arista de verticeOrigen a verticeDestino
     * @param verticeOrigen
     * @param verticeDestino
     * @return
     */
    public boolean hayArista(String verticeOrigen, String verticeDestino) {
        // implement
        return false;
    }

    /**
     * Algoritmo que elimina una arista de verticeOrigen a verticeDestino
     * @param verticeOrigen
     * @param verticeDestino
     */
    public void eliminarArista(String verticeOrigen, String verticeDestino) {
        // implement
    }

    /**
     * Metodo que obtiene la matriz de incidencia y la imprime en consola
     */
    public void printMatrizIncidencia() {
        // implement
    }

    public static void main(String[] args) {
        GrafoM g = new GrafoM();
        g.insertarVertices("0", "1", "2", "3");
        g.insertarAristas("0", "1", "2");
        g.insertarAristas("1", "2", "0");
        g.insertarAristas("3", "0", "3");
        g.print();

        g.insertarAristas("0", "1,2, 3");
        System.out.println(g.cantAristas());
        System.out.println(g.getAdyacentesA("2"));
    }

}
