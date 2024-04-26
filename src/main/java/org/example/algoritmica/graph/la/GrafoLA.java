package org.example.algoritmica.graph.la;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GrafoLA
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class GrafoLA<T> {
    public final int MAX_VERTICES = 10000;

    private Vertice<T>[] vertices;
    private List<Arista>[] vlAristas;
    private int cantVertices;

    public GrafoLA() {
        vertices = new Vertice[MAX_VERTICES];
        vlAristas = new ArrayList[MAX_VERTICES];
        cantVertices = 0;

        // vlAristas.length;             // size del arreglo
        // vlAristas[0]                  // lista de aristas
        // vlAristas[0].add(...);        // usando metodo de lista
        // vlAristas[0].get(0)           // es una arista
        // vlAristas[2].get(0).getPosVDestino() // obteniendo posVDestino
    }

    public void insertarVertice(T vertice) {
        vertices[cantVertices] = new Vertice<T>(vertice);
        vlAristas[cantVertices] = new ArrayList<>();
        cantVertices++;
    }
    public void insertarVertices(T ...vertices) {
        for (T vertice : vertices) {
            insertarVertice(vertice);
        }
    }

    public int getPosVertice(T vertice) {
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i].getValor().equals(vertice))
                return i;
        }
        return -1;
    }

    public void insertarArista(T verticeOrigen, T verticeDestino) {
        int posVOrigen = getPosVertice(verticeOrigen);
        int posVDestino = getPosVertice(verticeDestino);
        if (posVOrigen == -1 || posVDestino == -1) {
            System.err.println("No existe alguno de los vertices");
            return;
        }
        vlAristas[posVOrigen].add(new Arista(posVDestino));
    }

    public void insertarAristas(T verticeOrigen, T ...verticeDestinos) {
        for (T verticeDestino : verticeDestinos) {
            insertarArista(verticeOrigen, verticeDestino);
        }
    }

    public void print() {
        for (int i = 0; i < cantVertices; i++) { // iterar vertices
            String aristasSrt = "";
            for (Arista arista : vlAristas[i]) {
                aristasSrt += vertices[arista.getPosVDestino()].getValor() + " -> ";
            }
            System.out.println("["+vertices[i].getValor()+"] -> " + aristasSrt);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < cantVertices; i++) { // iterar vertices
            String aristasSrt = "";
            for (Arista arista : vlAristas[i]) {
                aristasSrt += vertices[arista.getPosVDestino()].getValor() + " -> ";
            }
            result+="["+vertices[i].getValor()+"] -> " + aristasSrt + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        GrafoLA<String> g = new GrafoLA();
        g.insertarVertices("A", "B", "C", "D");
        g.insertarAristas("A", "B", "C");
        g.insertarAristas("B", "C", "A");
        g.insertarAristas("D", "A", "D");
        //g.print();
        System.out.println(g);
    }
}
