package org.example.algoritmica.tree.treebinary;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TreeHeap
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TreeHeap implements TBPrint {

    private Node root;

    @Getter
    private int size;

    private boolean flag;

    public TreeHeap() {
        root = null;
        size = 0;
    }

    public void add(int value) {
        if (isEmpty()) {
            root = new Node(value);
            size = 1;
            return;
        }
        int nivelFinal = depth() - 1;
        if (isPerfect())
            nivelFinal++;

        flag = false;
        addMaxHeap(root, value, nivelFinal, 0, null);
    }

    private void addMaxHeap(Node node, int value, int nivelFinal, int nivelActual, Node parent) {
        if (flag)
            return;
        if (nivelActual == nivelFinal) {
            if (node == null) { // inserta nuevo nodo
                if (parent.getLeft() == null) {
                    parent.setLeft(new Node(value));
                } else {
                    parent.setRight(new Node(value));
                }
                size++;
                flag = true;
            } else {
                return;
            }
        }

        addMaxHeap(node.getLeft(), value, nivelFinal, nivelActual + 1, node);
        swapHeap(node, node.getLeft());

        addMaxHeap(node.getRight(), value, nivelFinal, nivelActual + 1, node);
        swapHeap(node, node.getRight());
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
        int aux = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(aux);
    }
    private void swapHeap(Node nodeParent, Node nodeChild) {
        if (nodeChild != null && nodeChild.getValue() > nodeParent.getValue()) {
            int aux = nodeParent.getValue();
            nodeParent.setValue(nodeChild.getValue());
            nodeChild.setValue(aux);
        }
    }

    public static void main(String[] args) {
        TreeHeap tb = new TreeHeap();
//        tb.putRoot(10);
//        tb.putLeft(10, 20);
//        tb.putRight(10, 30);
//
//        tb.putRight(20, 15);
////        tb.putLeft(30, 25);
////        tb.putLeft(30, 35);
//        tb.putLeft(20, 28);
        //tb.print();

        for (int i = 1; i < 10; i++) {
            tb.add(i * 10);
        }
        TBPrintUtil.print(tb);
        //System.out.println(tb.depth(tb.root));
        //System.out.println(tb.isFull(tb.root));

        System.out.println();
        //tb.postOrden(tb.root);
        //tb.bfs();
//        System.out.println(tb.getSize2(tb.root));
//        System.out.println(tb.areSiblings(tb.root, 30, 28));

    }
}
