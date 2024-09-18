package org.example.grabacion.list.simple;

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

    private int value;

    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public static void main(String[] args) {

        Node p = new Node(10);

        Node q = new Node(20);

        Node r = new Node(30);

        p.setNext(q);

        q.setNext(r);

        r.setNext(new Node(40));
    }
}
