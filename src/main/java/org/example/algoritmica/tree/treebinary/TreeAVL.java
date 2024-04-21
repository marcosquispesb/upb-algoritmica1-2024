package org.example.algoritmica.tree.treebinary;

import lombok.Getter;

/**
 * TreeBST
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TreeAVL implements TBPrint {

    private Node root;

    @Getter
    private int size;

    private boolean flag;

    public TreeAVL() {
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
        System.out.println("adicionando " + value);
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
                    balanceTree(root, null);
                    return;
                }
                node = node.getRight();
            } else { // voy por la izq
                if (node.getLeft() == null) {
                    node.setLeft(new Node(value));
                    size++;
                    balanceTree(root, null);
                    return;
                }
                node = node.getLeft();
            }
        }
    }

    public int balanceTree(Node node, Node parent) {
        if (node == null)
            return 0;
        if (node.isLeaf())
            return 1;

        int izq = balanceTree(node.getLeft(), node);
        int der = balanceTree(node.getRight(), node);
        int fe = der - izq;
        if (Math.abs(fe) > 1) {
            System.out.println("El nodo " + node.getValue() + " esta desbalanceado fe: " + fe);
        }
        if (Math.abs(fe) > 1 && fe < 0) { // desbalanceo izq
            if (isOneDirectionLeft(node)) { // lineal por izq
                // completar
            } else {
                rotarIzq(node.getLeft(), node);
                rotarDer(node, parent);
            }
        } else { // desbalanceo der
            if (isOneDirectionRight(node)) {
                rotarIzq(node, parent);
            }
        }

        return Math.max(izq, der) + 1;
    }

    public boolean isOneDirectionRight(Node node) {
        if (node.hasOneSon() && node.getRight() != null) {
            node = node.getRight();
            if (node.hasOneSon() && node.getRight() != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isOneDirectionLeft(Node node) {
        if (node.hasOneSon() && node.getLeft() != null) {
            node = node.getLeft();
            if (node.hasOneSon() && node.getLeft() != null) {
                return true;
            }
        }
        return false;
    }

    public void rotarIzq(Node node, Node parent) {
        System.out.println("rotarIzq: node: " + node.getValue() + ", parent: " + (parent != null ? parent.getValue() : null));
        boolean isParentRoot = parent == null;
        boolean isNodeLeft = !isParentRoot && parent.getLeft().getValue() == node.getValue();
        Node child = node.getRight();

        child.setLeft(node);
        node.setRight(null);

        // parent
        if (isParentRoot) {
            root = child;
        } else {
            if (isNodeLeft)
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
    }

    public void rotarDer(Node node, Node parent) {
        System.out.println("rotarDer: node: " + node.getValue() + ", parent: " + (parent != null ? parent.getValue() : null));
        boolean isParentRoot = parent == null;
        boolean isNodeRight = !isParentRoot && parent.getRight().getValue() == node.getValue();
        Node child = node.getLeft();

        child.setRight(node);
        node.setLeft(null);

        // parent
        if (isParentRoot) {
            root = child;
        } else {
            if (isNodeRight)
                parent.setRight(child);
            else
                parent.setLeft(child);
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
        TreeAVL tb = new TreeAVL();
//        for (int i = 1; i < 10; i++) {
//            tb.add(i * 10);
//        }

        tb.add(33);
        tb.add(25);
        tb.add(28);
        tb.add(40);
        tb.add(66);
        TBPrintUtil.print(tb);

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
