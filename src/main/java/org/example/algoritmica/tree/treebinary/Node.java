package org.example.algoritmica.tree.treebinary;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    public boolean hasOneSon() {
        if (hasTwoSon())
            return false;
        return left != null || right != null;
    }

    public boolean areHisChildren(int value1, int value2) {
        if (left != null && right != null) {
            if (left.getValue() == value1 && right.getValue() == value2) {
                return true;
            } else if (left.getValue() == value2 && right.getValue() == value1) {
                return true;
            }
        }
        return false;
    }

    public List<Node> getChildren() {
        List<Node> children = new ArrayList<>(2);
        if (left != null)
            children.add(left);
        if (right != null)
            children.add(right);

        return children;
    }

    public Node getChildMaxValue() {
        if (isLeaf())
            return null;
        if(hasOneSon())
            return left != null ? left : right;

        if (left.getValue() > right.getValue())
            return left;
        else
            return right;
    }
}
