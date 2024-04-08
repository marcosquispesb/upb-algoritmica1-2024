package org.example.algoritmica.list;

import lombok.Data;

/**
 * Node
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@Data
public class Node {
    private Integer value;
    private Node prev;
    private Node next;

    public Node(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", prev=" + (prev != null ? prev.value : null) +
                ", next=" + (next == null ? null : next.value) +
                '}';
    }
}
