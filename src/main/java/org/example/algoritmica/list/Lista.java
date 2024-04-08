package org.example.algoritmica.list;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isEmpty() {
        return  size == 0;
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
        int s = 0;
        Node aux = first;
        while (aux != null) {
            s = s + aux.getValue();
            aux = aux.getNext();
        }
        return s;
    }

    /**
     * Funcion que retorna el nodo en la posicion index, si no existe retorna null
     * @param index
     * @return
     */
    private Node getNode(int index) {
        int i = 0;
        Node aux = first;
        while (aux != null) {
            if (i == index)
                return aux;
            aux = aux.getNext();
            i++;
        }
        return null;
    }

    /**
     * Metodo que obtiene el valor que se encuentra en la posicion index
     * @param index
     * @return
     */
    public Integer get(int index) {
        Node node = getNode(index);
        return node != null ? node.getValue() : null;
    }

    /**
     * Funcion que retorna el indice donde se encuentra value en la lista
     * @param value
     * @return
     */
    public int getIndex(int value) {
        // implement
        return 0;
    }

    /**
     * Funcion que retorna el elemento mayor de la lista
     * @return
     */
    public int max() {
        // implement
        return 0;
    }

    /**
     * Funcion que retorna la cantidad de veces se encuentra value en la lista
     * @param value
     * @return
     */
    public int frequency(int value) {
        // implement
        return 0;
    }

    /**
     * Metodo que intercambia los valores de dos nodos
     * @param p
     * @param q
     */
    public void swap(Node p, Node q) {
        // implement
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
        System.out.println(l.getNode(3));
        System.out.println(l.get(3));
    }
}
