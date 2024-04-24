package org.example.algoritmica.list;

/**
 * Test
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {
        Node p = new Node(10);
        Node q = new Node(20);
        Node r = new Node(30);

        p.setNext(q);
        q.setNext(r);
    }
}
