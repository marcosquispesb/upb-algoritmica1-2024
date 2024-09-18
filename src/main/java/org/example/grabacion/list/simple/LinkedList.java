package org.example.grabacion.list.simple;

import lombok.Getter;

/**
 * LinkedList
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class LinkedList {

    private Node first;

    @Getter
    private int size;

    public LinkedList() {
        first = null;
        size = 0;
    }

    /**
     * Método que inserta un nuevo nodo con el valor value al final de la lista
     * @param value: valor del nuevo nodo que se creara
     */
    public void add(int value) {
        Node node = new Node(value);

        if (size == 0) { // lista vacia
            first = node;
            size++;
            return;
        }

        Node aux = first;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        aux.setNext(node);
        size++;
    }

    /**
     * Imprime los elementos de la lista
     */
    public void print() {
        String s = "";
        Node aux = first;
        while (aux != null) {
            s +=  (s.isEmpty() ? "" : " -> ") + aux.getValue();
            aux = aux.getNext();
        }
        System.out.println(s);
    }

    /**
     * Imprime los elementos de la lista
     */
//    public void print() {
//        Node aux = first;
//        while (aux != null) {
//            System.out.println("node: " + aux.getValue());
//            aux = aux.getNext();
//        }
//    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(10);  l.add(20);
        l.add(30);  l.add(40);

        l.print();
    }
}
