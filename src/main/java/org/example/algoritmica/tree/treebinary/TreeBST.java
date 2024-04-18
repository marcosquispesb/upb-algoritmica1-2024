package org.example.algoritmica.tree.treebinary;

import lombok.Getter;

import java.util.Arrays;

/**
 * TreeBST
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TreeBST implements TBPrint {

    private Node root;

    @Getter
    private int size;

    private boolean flag;

    public TreeBST() {
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

    public void addAll(int ...values) {
        for (int value : values) {
            add(value);
        }
    }
    public void add(int value) {
        if (isEmpty()) {
            root = new Node(value);
            size = 1;
            return;
        }
        // implement
        Node node = root;
        while (node != null) {
            if (value > node.getValue()) { // voy por la derecha
                if (node.getRight() == null) {
                    node.setRight(new Node(value));
                    size++;
                    return;
                }
                node = node.getRight();
            } else { // voy por la izq
                if (node.getLeft() == null) {
                    node.setLeft(new Node(value));
                    size++;
                    return;
                }
                node = node.getLeft();
            }
        }
    }

    /**
     * Elimina el nodo correspondiente al value del arbol bst
     * Considerar que hay 3 escenarios:
     *   1. si el nodo a eliminar es hoja
     *   2. si el nodo a eliminar tiene un solo hijo
     *   3. si el nodo a eliminar tiene dos hijos
     * @param value
     */
    public void delete(int value) {
        // implement
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
     * Intercambia los valores de los nodos node1 y node2
     * @param node1
     * @param node2
     */
    private void swap(Node node1, Node node2) {
        int aux = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(aux);
    }

    public static void main(String[] args) {
        TreeBST tb = new TreeBST();
//        for (int i = 1; i < 10; i++) {
//            tb.add(i * 10);
//        }
        // TODO revisar para el sig escenario, TB PRINT falla
//        tb.add(21);
//        tb.add(15);
//        tb.add(18);
//        tb.add(10);
//        tb.add(32);
//        tb.add(5);
//        tb.add(1);
//        tb.add(2);
//        tb.add(3);

        tb.addAll(21, 15, 18, 10, 32, 5);
        TBPrintUtil.print(tb);
        // TODO explicar luego el beneficio de usar la interfaz TBPrint
        //System.out.println(tb.depth(tb.root));
        //System.out.println(tb.isFull(tb.root));

//        tb.deleteHeap();
//        tb.deleteHeap();
//        System.out.println();
//        TBPrintUtil.print(tb);
        //tb.postOrden(tb.root);
        //tb.bfs();
//        System.out.println(tb.getSize2(tb.root));
//        System.out.println(tb.areSiblings(tb.root, 30, 28));

    }
}
