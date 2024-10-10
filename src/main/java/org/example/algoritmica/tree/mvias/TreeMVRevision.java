package org.example.algoritmica.tree.mvias;

import java.util.Arrays;

public class TreeMVRevision {

    private NodeMV root;
    private int size;

    public TreeMVRevision() {
        root = null;
        size = 0;
    }

    public void insertAll(Integer ...values) {
        for (Integer value : values) {
            insert(value);
        }
    }

    // validar si el root es null
    // partimos de la raiz
    // nodo que se revisa, verificar si esta lleno
    // si esta lleno validar por cual via seguir
    // si no esta lleno insertar ordenadamente
    public void insert(Integer value) {
        if (root == null) {
            root = new NodeMV(value);
            size = 1;
            return;
        }

        NodeMV node = root;
        while (true) {
            if (!node.isFull()) {
                insertSorted(node, value);
                return;
            } else {
                int posVia = NodeMV.M_VIAS - 1;
                for (int i = 0; i < NodeMV.M_VIAS - 1; i++) {
                    if (value == node.getValue(i))
                        return;
                    if (value < node.getValue(i)) {
                        posVia = i;
                        break;
                    }
                }
                if (node.getVia(posVia) == null) {
                    node.setVia(posVia, new NodeMV(value));
                    size++;
                    return;
                }

                node = node.getVia(posVia);
            }
        }
    }

//    private void insertSorted(NodeMV node, Integer value) {
//        for (int i = 0; i < NodeMV.M_VIAS - 1; i++) {
//            if (node.getValue(i) == null) {
//                node.setValue(i, value);
//                return;
//            }
//        }
//        // modificar para insertar ordenadamente
//    }

    private void insertSorted(NodeMV node, Integer value) { // de omar no funciona
        int i;
        for (i = NodeMV.M_VIAS - 2; i >= 0; i--) {
            if (node.getValue(i) != null && value == node.getValue(i)) {
                return;
            } if (node.getValue(i) != null && value < node.getValue(i)) {
                node.setValue(i + 1, node.getValue(i));
            } else if (node.getValue(i) != null) {
                break;
            }
        }
        node.setValue(i + 1, value);
    }

//    private void insertSorted(NodeMV node, Integer value) {
//        int i = 0;
//        while (i < NodeMV.M_VIAS - 1 && node.getValue(i) != null && value > node.getValue(i)) {
//            i++;
//        }
//        for (int j = NodeMV.M_VIAS - 2; j > i; j--) {
//            node.setValue(j, node.getValue(j - 1));
//        }
//        node.setValue(i, value);
//    }

    public void print(NodeMV node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < NodeMV.M_VIAS - 1; i++) {
            print(node.getVia(i));
            if (node.getValue(i) != null) {
                System.out.print(node.getValue(i) + " ");
            }
        }
        print(node.getVia(NodeMV.M_VIAS - 1));
    }

    public int depth(NodeMV node) {
        if (node == null) {
            return 0;
        }
        int maxDepth = 0;
        for (int i = 0; i < NodeMV.M_VIAS; i++) {
            maxDepth = Math.max(maxDepth, depth(node.getVia(i)));
        }
        return maxDepth + 1;
    }

    //1. Realizar algoritmo que retorne el valor maximo del árbol.
    //2. Realizar algoritmo que dado dos valores de entrada retorne true si tienen el mismo padre, caso contrario false.
    //3. Realizar algoritmo que eliminé los nodos hojas.

    public static void main(String[] args) {
        TreeMVRevision treeMV = new TreeMVRevision();
        treeMV.insertAll(40, 80, 10, 20, 70, 60, 15); // 295
        treeMV.print(treeMV.root);
        System.out.println("depth: " + treeMV.depth(treeMV.root));
        //System.out.println("sum: " + treeMV.sum(treeMV.root));
    }
}
