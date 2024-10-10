package org.example.algoritmica.tree.treenariogeneric;

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
public class Node<T> {

    private T value;
    private List<Node> children;
    private boolean checked; // marcado

    public Node(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

}
