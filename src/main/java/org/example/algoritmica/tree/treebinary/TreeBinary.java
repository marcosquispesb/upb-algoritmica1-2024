package org.example.algoritmica.tree.treebinary;

import lombok.Getter;

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
     * Retorna true si el arbol es lineal
     * Un arbol es lineal si hay un solo camino desde la raiz hasta el final
     * @return
     */
    public boolean isLineal() {
       // implement
       return false;
    }

    /**
     * Retorna true si el arbol es perfecto
     * Un arbol es perfecto si todos sus niveles estan llenos
     * @return
     */
    public boolean isPerfect() {
       //implement
       return false;
    }

    /**
     * Intercambia los valores de los nodos node1 y node2
     * @param node1
     * @param node2
     */
    private void swap(Node node1, Node node2) {
        // implement
    }

    public static void main(String[] args) {
        TreeBinary tb = new TreeBinary();
        tb.putRoot(10);
        tb.putLeft(10, 20);
        tb.putRight(10, 30);

        tb.putRight(20, 15);
//        tb.putLeft(30, 25);
//        tb.putLeft(30, 35);
        tb.putLeft(20, 28);
        //tb.print();
        TBPrintUtil.print(tb);
        //System.out.println(tb.depth(tb.root));
        System.out.println(tb.isFull(tb.root));

//        System.out.println(tb.getSize2(tb.root));
//        System.out.println(tb.areSiblings(tb.root, 30, 28));

    }
}
