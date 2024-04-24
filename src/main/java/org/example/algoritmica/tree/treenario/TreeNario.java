package org.example.algoritmica.tree.treenario;

/**
 * TreeNario
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TreeNario {

    private Node root;
    private int size;

    public TreeNario() {
        root = null;
        size = 0;
    }

    public Node getNode(int value) {
        return getNode(root, value);
    }
    private Node getNode(Node node, int valueToSearch) {
        if (node == null)
            return null;

        if (node.getValue() == valueToSearch)
            return node;

        for (Node child : node.getChildren()) {
            Node resultChild = getNode(child, valueToSearch);
            if (resultChild != null)
                return resultChild;
        }
        return null;
    }

    public void putRoot(int value) {
        root = new Node(value);
    }
    public void putChild(int valueParent, int value) {
        Node parent = getNode(valueParent);
        if (parent == null)
            return;

        parent.getChildren().add(new Node(value));
    }
    public void putChildAll(int valueParent, int ...values) {
        for (int value : values) {
            putChild(valueParent, value);
        }
    }

    public void printInOrden(Node node) {
        if (node == null)
            return;
        System.out.println(node.getValue());
        for (Node child : node.getChildren()) {
            printInOrden(child);
        }
    }

    public int sum(Node node) {
        if (node == null)
            return 0;
        int suma = node.getValue();
        for (Node child : node.getChildren()) {
            int sumaChild = sum(child);
            suma += sumaChild;
        }
        return suma;
    }

    // 1. funcion que retorne el mayor elemento del arbol
    // 2. retornar la cantidad de nodos padres
    // 3. eliminen los nodos hojas

    public static void main(String[] args) {
        TreeNario tn = new TreeNario();

        //        tn.putRoot(1);
//        tn.putChildAll(1, 10, 20, 30);
//        tn.putChildAll(10, 11, 14, 17);
//        tn.putChildAll(30, 33, 39);
//        tn.printInOrden(tn.root);
        System.out.println("sum: " + tn.sum(tn.root));

        tn.putRoot(40);
        tn.putChildAll(40, 30, 10, 20);
        tn.putChildAll(30, 15, 11);
        tn.putChildAll(15, 2);
        tn.putChildAll(2, 3, 1, 5);
        tn.putChildAll(10, 12);
        tn.printInOrden(tn.root);
    }
}
