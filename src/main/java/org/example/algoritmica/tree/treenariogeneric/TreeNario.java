package org.example.algoritmica.tree.treenariogeneric;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * TreeNario
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TreeNario<T> {

    private Node<T> root;
    private int size;

    public TreeNario() {
        root = null;
        size = 0;
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<T> getNode(T value) {
        return getNode(root, value);
    }
    private Node<T> getNode(Node<T> node, T valueToSearch) {
        if (node == null)
            return null;

        if (node.getValue() == valueToSearch) // TODO revisar
            return node;

        for (Node child : node.getChildren()) {
            Node resultChild = getNode(child, valueToSearch);
            if (resultChild != null)
                return resultChild;
        }
        return null;
    }

    public void putRoot(T value) {
        root = new Node(value);
    }
    public void putChild(T valueParent, T value) {
        Node<T> parent = getNode(valueParent);
        if (parent == null)
            return;

        parent.getChildren().add(new Node(value));
    }
    public void putChildAll(T valueParent, T ...values) {
        for (T value : values) {
            putChild(valueParent, value);
        }
    }

    public void putChildrenNull(Node<T> node, int sizeChildren) {
        if (node == null) return;

        for (int i = 0; i < sizeChildren; i++) {
            node.getChildren().add(null);
        }
    }

    public void printInOrden(Node<T> node) {
        if (node == null)
            return;
        System.out.println(node.getValue());
        for (Node child : node.getChildren()) {
            printInOrden(child);
        }
    }

    public static void main(String[] args) {
//        TreeNario<Integer> tn = new TreeNario();

        //        tn.putRoot(1);
//        tn.putChildAll(1, 10, 20, 30);
//        tn.putChildAll(10, 11, 14, 17);
//        tn.putChildAll(30, 33, 39);
//        tn.printInOrden(tn.root);
        //System.out.println("sum: " + tn.sum(tn.root));

//        tn.putRoot(40);
//        tn.putChildAll(40, 30, 10, 20);
//        tn.putChildAll(30, 15, 11);
//        tn.putChildAll(15, 2);
//        tn.putChildAll(2, 3, 1, 5);
//        tn.putChildAll(10, 12);
        //tn.printInOrden(tn.root);

        TreeNario<String> tns = new TreeNario<>();
        tns.putRoot("A");
        tns.putChildAll("A", "C", "D");
        tns.putChildAll("D", "E");
        tns.printInOrden(tns.root);

    }
}
