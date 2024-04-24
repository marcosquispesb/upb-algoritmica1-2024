package org.example.algoritmica.tree.treebinary;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TreeBinary
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TreeBinary implements TBPrint {

    private Node root;

    @Getter
    private int size;

    public TreeBinary() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node getNode(Node node, int valueToSearch) {
        if (node == null)
            return null;

        if (node.getValue() == valueToSearch)
            return node;

        Node izq = getNode(node.getLeft(), valueToSearch);
        if (izq != null) {
            return izq;
        } else {
            Node der = getNode(node.getRight(), valueToSearch);
            return der;
        }
    }

    public void putRoot(int value) {
        root = new Node(value);
        size = 1;
    }

    public void putLeft(int valueParent, int value) {
        Node parent = getNode(root, valueParent);
        if (parent == null)
            return;

        Node node = new Node(value);
        parent.setLeft(node);
        size++;
    }

    public void putRight(int valueParent, int value) {
        Node parent = getNode(root, valueParent);
        if (parent == null)
            return;

        Node node = new Node(value);
        parent.setRight(node);
        size++;
    }

    public int getSize2(Node node) {
        if (node == null)
            return 0;

        int countIzq = getSize2(node.getLeft());
        int countDer = getSize2(node.getRight());
        return countIzq + countDer + 1;
    }

    public void print() {
        print(root);
    }
    private void print(Node node) { // metodo mascara
        if (node == null)
            return;
        System.out.println(node.getValue());
        print(node.getLeft());
        print(node.getRight());
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public int depth() {
        return depth(root);
    }

    /**
     * Retorna la suma de los elementos del arbol
     * @param node
     * @return
     */
    public int sum(Node node) {
        // implement
        return 0;
    }

    /**
     * Retorna la cantidad de nodos hojas que hay en el arbol
     * @param node
     * @return
     */
    public int quantityLeaves(Node node) {
        // implement
        return 0;
    }

    /**
     * Retorna true si los nodos con los valores value1 y value2 son hermanos, caso contrario retorna false
     * Se debe buscar en el arbol los dos valores si son hijos de un mismo padre, entonces son hermanos
     * @param value1
     * @param value2
     * @return
     */
    public boolean areSiblings(Node node, int value1, int value2) {
        if (node == null || node.isLeaf())
            return false;
        if (node.areHisChildren(value1, value2))
            return true;

        return areSiblings(node.getLeft(), value1, value2)
                || areSiblings(node.getRight(), value1, value2);
    }

    /**
     * Retorna la longitud del camino mas largo
     * @param node
     * @return
     */
    public int depth(Node node) {
        if (node == null)
            return 0;
        if (node.isLeaf())
            return 1;

        int izq = depth(node.getLeft());
        int der = depth(node.getRight());
        return Math.max(izq, der) + 1;
    }

    /**
     * Retorna true si el arbol es lleno
     * Un arbol es lleno si cada nodo tiene 0 o 2 hijos
     * @return
     */
    public boolean isFull(Node node) {
        if (node.isLeaf())
            return true;
        if (node.hasOneSon())
            return false;

        boolean izq = isFull(node.getLeft());
        boolean der = isFull(node.getRight());
        return izq && der;
    }

    /**
     * Retorna true si el arbol es perfecto
     * Un arbol es perfecto si todos sus niveles estan llenos
     * @return
     */
    public boolean isPerfect() {
       return Math.pow(2d, depth()) - 1 == size;
    }

    /**
     * Intercambia los valores de los nodos node1 y node2
     * @param node1
     * @param node2
     */
    private void swap(Node node1, Node node2) {
        // implement
    }

    /**
     * Retorna true si el arbol es lineal
     * Un arbol es lineal si hay un solo camino desde la raiz hasta el final
     * @return
     */
    public boolean isLineal() {
        // implement
        return false;
    }

    /**
     * Elimina los nodos hojas del arbol
     */
    public void deleteLeaves() {
        // implement
    }

    public void preOrden(Node node) {
        if (node == null)
            return;

        System.out.println(node.getValue());
        preOrden(node.getLeft());
        preOrden(node.getRight());
    }

    public void inOrden(Node node) {
        if (node == null)
            return;

        inOrden(node.getLeft());
        System.out.println(node.getValue());
        inOrden(node.getRight());
    }

    public void postOrden(Node node) {
        if (node == null)
            return;

        postOrden(node.getLeft());
        postOrden(node.getRight());
        System.out.println(node.getValue());
    }

    /**
     * Recorrido por niveles
     */
    public void bfs() {
        if (isEmpty())
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node;
        do {
            node = queue.poll(); // sacar
            System.out.println(node.getValue());
            queue.addAll(node.getChildren());
        } while (!queue.isEmpty());
    }

    // ver
    public void insertarPorNivel(int value) {
        if (isEmpty()) {
            root = new Node(value);
            size = 1;
            return;
        }
        int nivelFinal = depth() - 1;
        if (isPerfect())
            nivelFinal = nivelFinal + 1;
        insertarPorNivel(root, value, nivelFinal, 0, null);
    }

    public boolean insertarPorNivel(Node node, int value, int nivelFinal, int nivelActual, Node parent) {
        if (nivelActual == nivelFinal) { // insertar
            if (node == null) {
                if (parent.getLeft() == null) {
                    parent.setLeft(new Node(value));
                    size++;
                } else if (parent.getRight() == null) {
                    parent.setRight(new Node(value));
                    size++;
                }
                return true;
            } else {
                return false;
            }
        }

        boolean izq = insertarPorNivel(node.getLeft(), value, nivelFinal, nivelActual + 1, node);
        if (izq)
            return izq;
        boolean der = insertarPorNivel(node.getRight(), value, nivelFinal, nivelActual + 1, node);
        return der;
    }

    /**
     * Retorna la cantidad de nodos que se encuentran en el nivel: level
     * @param level: nivel del cual se deben contar la cantidad de nodos
     * @return
     */
    public int quantityNodesByLevels(int level) {
        return quantityNodesByLevels(root, 0, level);
    }
    private int quantityNodesByLevels(Node node, int level, int levelToSearch) {
        if (level == levelToSearch) {
            return node != null ? 1 : 0;
        }
        int izq = quantityNodesByLevels(node.getLeft(), level + 1, levelToSearch);
        int der = quantityNodesByLevels(node.getRight(), level + 1, levelToSearch);
        return izq + der;
    }

    /**
     * Retorna la lista de valores que se encuentran en el nivel: level
     * @param level: nivel del cual se deben obtener los valores a retornar
     * @return
     */
    public List<Integer> getValuesByLevel(int level) {
        List<Integer> result = new ArrayList<>();
        fillValuesByLevel(root, 0, level, result);
        return result;
    }

    private void fillValuesByLevel(Node node, int level, int levelToSearch, List<Integer> result) {
        if (level == levelToSearch) {
            if (node != null) {
                result.add(node.getValue());
            } else {
                result.add(null);
            }
            return;
        }
        fillValuesByLevel(node.getLeft(), level + 1, levelToSearch, result);
        fillValuesByLevel(node.getRight(), level + 1, levelToSearch, result);
    }
    /**
     * Funcion que a partir de un nodo base que tiene dos hijos, partiendo de ese nodo retorna el siguiente nodo inOrden
     * @param node
     * @return
     */
    public Node getNextInOrden(Node node) {
        // implement
        return null;
    }

    /**
     * A partir de value realizar una rotacion hacia la derecha
     * Nota: Antes de realizar la rotacion validar que a partir de value, que sea lineal en una sola direccion hacia la izquierda
     * @param value
     */
    public void rotateRight(int value) {
       // implement
    }

    /**
     * A partir de value realizar una rotacion hacia la izquierda
     * Nota: Antes de realizar la rotacion validar que a partir de value, que sea lineal en una sola direccion hacia la derecha
     * @param value
     */
    public void rotateLeft(int value) {
        // implement
    }

    // 1. llamada al mismo metodo
    // 2. caso base
    // 3. recorrido o parcial
    // 4. si es una funcion, se debe considerar el resultado de las llamadas recursivas
    public boolean isMaxHeap(Node node, Node parent) {
        if (node == null)
            return true;
        if (parent != null && node.getValue() > parent.getValue())
            return false;

        boolean izq = isMaxHeap(node.getLeft(), node);
        if (izq) { // es heap por izq
            return isMaxHeap(node.getRight(), node);
        } else { // NO es heap por izq
            return false;
        }
    }

    public static void main(String[] args) {
        TreeBinary tb = new TreeBinary();
//        tb.putRoot(10);
//        tb.putLeft(10, 20);
//        tb.putRight(10, 30);
//
//        tb.putRight(20, 15);
////        tb.putLeft(30, 25);
////        tb.putLeft(30, 35);
//        tb.putLeft(20, 28);
        //tb.print();

//        for (int i = 1; i < 10; i++) {
//            tb.insertarPorNivel(i * 10);
//        }
//        TBPrintUtil.print(tb);
        //System.out.println(tb.depth(tb.root));
        //System.out.println(tb.isFull(tb.root));

        System.out.println();
        //tb.postOrden(tb.root);
        //tb.bfs();
//        System.out.println(tb.getSize2(tb.root));
//        System.out.println(tb.areSiblings(tb.root, 30, 28));

        tb.putRoot(40);
        tb.putLeft(40, 30);
        tb.putRight(40, 25);
        tb.putLeft(30, 15);
        tb.putRight(30, 5);
        tb.putLeft(15, 10);
        //tb.putRight(15, 12);
        tb.putLeft(25, 8);
        tb.putRight(25, 22); // solo hasta aqui imprime mal el nodo 15
        tb.putLeft(5, 1);
        TBPrintUtil.print(tb);
        System.out.println(tb.getValuesByLevel(3));
        System.out.println(tb.isMaxHeap(tb.root, null));

    }
}
