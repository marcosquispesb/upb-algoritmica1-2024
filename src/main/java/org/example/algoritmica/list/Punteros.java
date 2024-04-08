package org.example.algoritmica.list;

import org.example.algoritmica.others.User;

/**
 * Punteros
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Punteros {

    public static void main(String[] args) {
//        int p = 1;
//        int q = 2;
//        p = q;
//
//        User u = new User("Abel", 18);
//        User v = new User("Joel", 19);
//        v = u;
//
//        u = new User("Pedro", 20);
//        v.setName("Juan");
//        System.out.println(u);
//        System.out.println(v);

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.setNext(n2);
        n2.setNext(n3);
        n2.setPrev(n1);
        n3.setPrev(n2);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        System.out.println();
        System.out.println(n1.getNext().getNext());
    }
}
