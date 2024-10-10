package org.example.algoritmica.tree.trie;

import org.example.algoritmica.tree.treenariogeneric.Node;
import org.example.algoritmica.tree.treenariogeneric.TreeNario;

import java.util.List;

public class Trie {
    private TreeNario<Character> tn;

    public Trie() {
        tn = new TreeNario<>();
        tn.putRoot('#');
    }

    public void add(String word) { // DEDO
        Node<Character> node = tn.getRoot();

        for (Character c : word.toCharArray()) {
            if (!node.hasChildren())
                tn.putChildrenNull(node, 26);

            int index = c - 'A';
            if (node.getChildren().get(index) == null)
                node.getChildren().set(index, new Node(c));

            node = node.getChildren().get(index);
        }
        node.setChecked(true);
    }

    public void printInOrden() {
        printInOrden(tn.getRoot());
    }
    private void printInOrden(Node<Character> node) {
        if (node == null)
            return;

        System.out.println(node.getValue());
        for (Node child : node.getChildren()) {
            printInOrden(child);
        }
    }

    public List<String> getPalabras() {
        return null;
    }

    public static void main(String[] args) {
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
        Trie t = new Trie();
        t.add("DEDO");
        t.add("DEBER");
        t.add("DEBAJO");
        t.add("PAR");
        t.add("PRADO");
        t.add("DE");
        t.printInOrden();
    }
}
