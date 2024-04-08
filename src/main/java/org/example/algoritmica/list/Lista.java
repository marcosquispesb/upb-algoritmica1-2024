package org.example.algoritmica.list;

/**
 * Lista
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Lista {
    private Node first;
    private int size;

    public Lista() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

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
        node.setPrev(aux);
        size++;
    }

    public void print() {
        String s = "";
        Node aux = first;
        while (aux != null) {
            System.out.println(aux);
            s += (s.isEmpty() ? "" : " -> ") + aux.getValue();
            //s = s + aux.getValue() + " -> ";
            aux = aux.getNext();
        }
        System.out.println(s);
    }

    private int getSize2() {
        int count = 0;
        Node aux = first;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    private int suma() {
        int a = 0;
        Node aux = first;
        while (aux != null) {
            a = a + aux.getValue();
            aux = aux.getNext();
        }
        return a;
    }

    public static void main(String[] args) {
        Lista l = new Lista();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(10);
        l.print();
        //System.out.println(l.getSize());
        System.out.println(l.getSize2());
        System.out.println(l.suma());
    }
}
