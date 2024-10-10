package org.example.algoritmica.tree.mvias;

public class TreeMV {

    private NodeMV root;
    private int size;

    public TreeMV() {
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

    private void insertSorted(NodeMV node, Integer value) {
        for (int i = 0; i < NodeMV.M_VIAS - 1; i++) {
            if (node.getValue(i) == null) {
                node.setValue(i, value);
                return;
            }
        }
        // modificar para insertar ordenadamente
    }

    public int sum(NodeMV node) {
        if (node == null)
            return 0;

        int result = 0;
        for (int i = 0; i < NodeMV.M_VIAS; i++) {
            result += sum(node.getVia(i));
        }
        result += node.sumValues();
        return result;
    }

    //1. Realizar algoritmo que retorne el valor maximo del árbol.
    //2. Realizar algoritmo que dado dos valores de entrada retorne true si tienen el mismo padre, caso contrario false.
    //3. Realizar algoritmo que eliminé los nodos hojas.

    public boolean mismoPadre(int v1, int v2) {
        return false;
    }

    public static void main(String[] args) {
        TreeMV treeMV = new TreeMV();
        treeMV.insertAll(40, 80, 10, 20, 60, 70, 15); // 295
        System.out.println("sum: " + treeMV.sum(treeMV.root));
    }
}
