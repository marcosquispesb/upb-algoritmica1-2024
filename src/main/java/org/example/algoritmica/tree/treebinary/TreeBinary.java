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
        return 3;
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
        // implement
        return false;
    }

    public static void main(String[] args) {
        TreeBinary tb = new TreeBinary();
        tb.putRoot(10);
        tb.putLeft(10, 20);
        tb.putRight(10, 30);

        tb.putRight(20, 15);
        tb.putLeft(30, 25);
        //tb.print();
        TBPrintUtil.print(tb);

        System.out.println(tb.getSize2(tb.root));
    }
}
