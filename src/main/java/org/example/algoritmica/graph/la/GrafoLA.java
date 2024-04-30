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
public class GrafoLA {
    public final int MAX_VERTICES = 10000;

    private Vertice[] vertices;
    private List<Arista>[] vlAristas; // vlAdyacentes
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

    public void insertarVertice(String vertice) {
        vertices[cantVertices] = new Vertice(vertice);
        vlAristas[cantVertices] = new ArrayList<>();
        cantVertices++;
    }
    public void insertarVertices(String ...vertices) {
        for (String vertice : vertices) {
            insertarVertice(vertice);
        }
    }

    public int getPosVertice(String vertice) {
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i].getValor().equals(vertice))
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
        // TODO validar si existe arista
        vlAristas[posVOrigen].add(new Arista(posVDestino));
    }

    public void insertarAristaBI(String verticeOrigen, String verticeDestino) {
        insertarArista(verticeOrigen, verticeDestino);
        insertarArista(verticeDestino, verticeOrigen);
    }

    public void insertarAristas(String verticeOrigen, String ...verticeDestinos) {
        for (String verticeDestino : verticeDestinos) {
            insertarArista(verticeOrigen, verticeDestino);
        }
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
     * Elimina las aristas con el vertice destino recibido como parametro
     * @param verticeDestino
     */
    public void eliminarAristasConVDestino(String verticeDestino) {
        int posVDestino = getPosVertice(verticeDestino);
        if (posVDestino == -1) {
            System.err.println("No existe el vértice destino: " + verticeDestino);
            return;
        }

        for (int i = 0; i < cantVertices; i++) {
            for (int j = 0; j < vlAristas[i].size(); j++) {
                if (vlAristas[i].get(j).getPosVDestino() == posVDestino) {
                    vlAristas[i].remove(j);
                    j--;
                }
            }
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

    public int cantidadAristas() {
        int cantidad = 0;
        for (int i = 0; i < cantVertices; i++) { // para recorrer los vertices
            //System.out.println("vertice: " + i);
            for (Arista arista : vlAristas[i]) { // for de aristas
                //System.out.println("arista: " + arista);
                cantidad++;
            }
        }
        return cantidad;
    }

    public List<String> getVerticesAdyacentes(String verticeOrigen) {
        List<String> result = new ArrayList<>();
        int posVOrigen = getPosVertice(verticeOrigen);
//        for (int i = 0; i < vlAristas[posVOrigen].size(); i++) {
//            Arista arista = vlAristas[posVOrigen].get(i);
//            String valor = vertices[arista.getPosVDestino()].getValor();
//            result.add(valor);
//        }
        for (Arista arista : vlAristas[posVOrigen]) {
            String valor = vertices[arista.getPosVDestino()].getValor();
            result.add(valor);
        }
        return result;
    }

    public boolean hayAristaPos(int posVOrigen, int posVDestino) {
        for (Arista arista : vlAristas[posVOrigen]) {
            if (arista.getPosVDestino() == posVDestino)
                return true;
        }
        return false;
    }

    public boolean esGrafoNoDirigido() {
        for (int i = 0; i < cantVertices; i++) {
            for (Arista arista : vlAristas[i]) {
                // i -> arista.getPosVDestino()
                if (!hayAristaPos(arista.getPosVDestino(), i))
                    return false;
            }
        }
        return true;
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
        GrafoLA g = new GrafoLA();
        g.insertarVertices("A", "B", "C", "D");
        g.insertarAristas("A", "B", "C");
        g.insertarAristas("B", "C", "A");
        g.insertarAristas("D", "A", "D");
        //g.print();
        System.out.println(g);

        System.out.println();
        System.out.println("cant aristas: " + g.cantidadAristas());
        System.out.println(g.getVerticesAdyacentes("B"));

        System.out.println();
        g = new GrafoLA();
        g.insertarVertices("A", "B", "C", "D");
        g.insertarAristaBI("A", "B");
        g.insertarAristaBI("A", "C");
        g.insertarAristaBI("B", "C");
        g.insertarArista("B", "D");
        System.out.println(g.esGrafoNoDirigido());
    }
}
