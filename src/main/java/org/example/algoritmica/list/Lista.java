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

    public void add(int pos, int value) {
        Node actual = first;
        int i = 0;
        while (actual != null) {
            if (i == pos)
                break;
            i++;
            if (i == size) // lego al ultimo
                break;
            actual = actual.getNext();
        }

        Node n = new Node(value);
        if (pos == 0) {
            n.setNext(actual);
            actual.setPrev(n);
            first = n;
            size++;
        } else if (pos < size) {
            Node anterior = actual.getPrev();
            anterior.setNext(n);
            n.setNext(actual);
            actual.setPrev(n);
            n.setPrev(anterior);
            size++;
        } else {
            actual.setNext(n);
            n.setPrev(actual);
            size++;
        }
    }

    public void delete(int value) {
        Node node = getNodeByValue(value);
        if (node == null)
            return;

        if (size == 1) {
            size--;
            first = null;
            return;
        }

        if (node.getPrev() == null) { // primero
            first = node.getNext();
            node.getNext().setPrev(null);
            node.setNext(null);
        } else if (node.getNext() == null) { // ultimo
            node.getPrev().setNext(null);
            node.setPrev(null);
        } else { // intermedio
            Node anterior = node.getPrev();
            Node siguiente = node.getNext();
            anterior.setNext(siguiente);
            siguiente.setPrev(anterior);
            node.setPrev(null);
            node.setNext(null);
        }
        size--;
    }

    public Lista clone() {
        Lista listaClone = new Lista();
        Node actual = first;
        while (actual != null) {
            listaClone.add(actual.getValue());
            actual = actual.getNext();
        }
        return listaClone;
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
    private Node getNodeByIndex(int index) {
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

    private Node getNodeByValue(int value) {
        int i = 0;
        Node aux = first;
        while (aux != null) {
            if (aux.getValue() == value)
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
        Node node = getNodeByIndex(index);
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

    /**
     * Metodo que dado un value, reemplaza al valor que se envuentra en la posicion pos
     * No crea un nuevo nodo, sino que actualiza el ya existente en la posicion pos
     * @param pos
     * @param value
     */
    public void set(int pos, int value) {
        // implement
    }

    /**
     * Metodo que inserta value de forma ordenada en la lista
     * Manteniendo asi una lista siempre ordenada
     * @param value
     */
    public void insertarOrdenado(int value) {
        // implement
    }

    /**
     * Funcion que retorna una Lista Enlazada con los elementos pares del a lista original
     * @return
     */
    public Lista getListNumerosPares() {
        Lista listaNumPares = new Lista();

        // implement

        return listaNumPares;
    }

    public void print() {
        String s = "";
        Node aux = first;
        while (aux != null) {
            //System.out.println(aux);
            s += (s.isEmpty() ? "" : " -> ") + aux.getValue();
            //s = s + aux.getValue() + " -> ";
            aux = aux.getNext();
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        Lista l = new Lista();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        //l.print();
        l.add(0, 5);
        l.add(3, 25);
        l.add(6, 45);
        l.print();
        l.delete(5);
        l.delete(45);
        l.delete(25);
        System.out.println("deleted");
        l.print();

        System.out.println("clone:");
        Lista clone = l.clone();
        clone.delete(40);
        clone.print();

        //System.out.println(l.getSize());
//        System.out.println(l.getSize2());
//        System.out.println(l.suma());
//        System.out.println(l.getNode(3));
//        System.out.println(l.get(3));
    }
}
