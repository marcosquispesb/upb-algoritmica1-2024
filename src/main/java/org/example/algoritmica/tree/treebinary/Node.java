package org.example.algoritmica.tree.treebinary;

import lombok.Getter;
import lombok.Setter;

/**
 * Node
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@Getter
@Setter
public class Node {
    private int id; // auxiliar para el print del docente

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasTwoSon() {
        return left != null && right != null;
    }
}
