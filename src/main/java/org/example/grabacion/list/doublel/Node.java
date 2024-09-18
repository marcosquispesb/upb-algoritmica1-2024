package org.example.grabacion.list.doublel;

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

    private int value;

    private Node next;

    private Node prev;

    public Node(int value) {
        this.value = value;
    }

    public static void main(String[] args) {

        Node p = new Node(10);

        Node q = new Node(20);

        Node r = new Node(30);

        p.setNext(q);   q.setPrev(p);

        q.setNext(r);   r.setPrev(q);

        r.setNext(new Node(40));

        r.getNext().setPrev(r);
    }
}
