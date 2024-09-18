package org.example.grabacion.list.doublel;

import lombok.Getter;

/**
 * LinkedList
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class LinkedList {

    private Node first;

    private Node last;

    @Getter
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }
}
