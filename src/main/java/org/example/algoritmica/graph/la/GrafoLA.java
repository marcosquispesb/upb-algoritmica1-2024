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

    // region [Marcado Vertices]-------------------------------------------------
    /**
     * Desmarca todos los vertices
     */
    private void desmarcarTodos() {
        for (int i = 0; i < cantVertices; i++) {
            vertices[i].setMarcado(false);
        }
    }

    /**
     * Retorna true si el vertice con pos i esta marcado
     * @param i
     * @return
     */
    private boolean estaMarcado(int i) {
        return vertices[i].isMarcado();
    }

    /**
     * Marca el vertice con pos i
     * @param i
     */
    private void marcar(int i) {
        vertices[i].setMarcado(true);
    }

    /**
     * Desmarca el vertice con pos i
     * @param i
     */
    private void desmarcar(int i) {
        vertices[i].setMarcado(false);
    }
    //endregion

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

    /**
     * Elimina un vertice completamente
     * @param vertice
     */
    public void eliminarVertice(String vertice) {
        // elimina aristas
        eliminarAristasConVDestino(vertice);

        // recorremos cada elemento desde posV + 1
        int posV = getPosVertice(vertice);
        for (int i = posV + 1; i < cantVertices; i++) {
            vertices[i - 1] = vertices[i];
        }
        for (int i = posV + 1; i < cantVertices; i++) {
            vlAristas[i - 1] = vlAristas[i];
        }

        // descartamos el ultimo
        vertices[cantVertices - 1] = null;
        vlAristas[cantVertices - 1] = null;
        cantVertices--;

        // restamos pos Destinos > a posV de todas las aristas
        for (int i = 0; i < cantVertices; i++) {
            for (Arista arista : vlAristas[i]) {
                if (arista.getPosVDestino() > posV) {
                    arista.setPosVDestino(arista.getPosVDestino() - 1);
                }
            }
        }
    }

    /**
     * Retorna los valores de los vertices a quienes es adyacente w
     * @param vertice
     * @return
     */
    public List<String> aqsAdyancente(String vertice) {
        List<String> result = new ArrayList<>();
        int posVDestino = getPosVertice(vertice);
        for (int i = 0; i < cantVertices; i++) {
            for (Arista arista : vlAristas[i]) {
                if (arista.getPosVDestino() == posVDestino) {
                    result.add(vertices[i].getValor());
                }
            }
        }
        return result;
    }

    public List<Integer> aqsAdyancentePos(Integer posVDestino) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cantVertices; i++) {
            for (Arista arista : vlAristas[i]) {
                if (arista.getPosVDestino() == posVDestino) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    /**
     * Obtiene los valores de los vertices solitarios
     * @return
     */
    public List<String> obtenerSolitarios() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < cantVertices; i++) { // iterar vertices
            String aristasSrt = "";
            for (Arista arista : vlAristas[i]) {
                aristasSrt += " -> " + vertices[arista.getPosVDestino()].getValor();
            }
            result+="["+vertices[i].getValor()+"]" + aristasSrt + "\n";
        }
        return "\n"+result;
    }

    public String toStringPosV() {
        String result = "";
        for (int i = 0; i < cantVertices; i++) { // iterar vertices
            String aristasSrt = "";
            for (Arista arista : vlAristas[i]) {
                aristasSrt += " -> " + arista.getPosVDestino();
            }
            result+="["+i+"]" + aristasSrt + "\n";
        }
        return result;
    }

    public List<String> mapToVerticesStr(List<Integer> posVertices) {
        List<String> result = new ArrayList<>();
        for (Integer posVertex : posVertices) {
            if (vertices[posVertex] != null)
                result.add(vertices[posVertex].getValor());
            else
                result.add(null);
        }
        return result;
    }

    public void eliminarBucles() {
        for (int i = 0; i < cantVertices; i++) {
            for (Arista arista : vlAristas[i]) {
                if (arista.getPosVDestino() == i) {
                    vlAristas[i].remove(arista);
                    break;
                }
            }
        }
    }

    public void DFS() {
        desmarcarTodos();
        for (int i = 0; i < cantVertices; i++) {
            if (!estaMarcado(i))
                DFS(i);
        }
    }
    private void DFS(int v) {
        //System.out.println("DFS: " + v);
        marcar(v);

        for (Arista arista : vlAristas[v]) {
            if (!estaMarcado(arista.getPosVDestino())) {
                DFS(arista.getPosVDestino());
            }
        }
    }

    /**
     * Devuelve true si desde u se puede llegar a w, caso contrario false
     * Es decir si partiendo de u, hay algun camino que a través de las aristas se pueda llegar a w
     * Ejemplos: u -> w,     u -> x -> w,     u -> x -> y -> w
     * @param u: indice del vertice origen
     * @param w: indice del vertice destino
     * @return
     */
    public boolean hayCamino(int u, int w) {
        desmarcarTodos();
        DFS(u);
        return vertices[w].isMarcado();
    }

    /**
     * Retorna true si todos los vertices estan conectados, caso contrario false
     * Nota: El algoritmo debe aplicar para un grafo no dirigido
     * @return
     */
    public boolean estanTodosConectados() { // grafo conexo
        desmarcarTodos();
        DFSConectados(0);
        for (int i = 0; i < cantVertices; i++) {
            if (!vertices[i].isMarcado())
                return false;
        }
        return true;
    }

    private void DFSConectados(int v) {
        //System.out.println("DFS: " + v);
        marcar(v);

        for (Arista arista : vlAristas[v]) {
            if (!estaMarcado(arista.getPosVDestino())) {
                DFSConectados(arista.getPosVDestino());
            }
        }

        // iterar a quienes es adyacente v
        for (Integer posV : aqsAdyancentePos(v)) {
            if (!estaMarcado(posV)) {
                DFSConectados(posV);
            }
        }
    }

    public static void main(String[] args) {
        GrafoLA g = new GrafoLA();

        g.insertarVertices("0", "1", "2", "3", "4", "5", "6");
        g.insertarAristas("0", "1", "3");
        g.insertarAristas("2", "0");
        g.insertarAristas("3", "2");
        g.insertarAristas("4", "3", "6");
        g.insertarAristas("5", "6");
        g.insertarAristas("6", "4");
        System.out.println(g.estanTodosConectados());

//        System.out.println();
//        System.out.println(g.hayCamino(g.getPosVertice("0"), g.getPosVertice("5")));

//        g.insertarVertices("0", "1", "2", "3", "4", "5", "6");
//        g.insertarAristaBI("0", "1");
//        g.insertarAristaBI("0", "3");
//        g.insertarAristaBI("2", "3");
//        g.insertarAristaBI("4", "6");
//        System.out.println(g);
//        g.DFS();

//        g.insertarVertices("A", "B", "C", "D", "E", "F", "G");
//        g.insertarAristas("A", "A", "B", "C", "D");
//        g.insertarAristas("B", "C", "A");
//        g.insertarAristas("D", "B", "D", "F");
//        System.out.println(g);
//        System.out.println(g.toStringPosV());
//
//        System.out.println(g.aqsAdyancente("B"));

        //System.out.println(g.toStringPosV());
        //g.eliminarAristasConVDestino("B");
        //g.eliminarVertice("B");
        //System.out.println(g.toStringPosV());
        //System.out.println(g);
//        System.out.println();
//        System.out.println(g.toStringPosV());


//        System.out.println();
//        System.out.println("cant aristas: " + g.cantidadAristas());
//        System.out.println(g.getVerticesAdyacentes("B"));

//        System.out.println();
//        g = new GrafoLA();
//        g.insertarVertices("A", "B", "C", "D");
//        g.insertarAristaBI("A", "B");
//        g.insertarAristaBI("A", "C");
//        g.insertarAristaBI("B", "C");
//        g.insertarArista("B", "D");
//        System.out.println(g.esGrafoNoDirigido());
    }
}
