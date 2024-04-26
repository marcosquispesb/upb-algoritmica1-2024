package org.example.algoritmica.graph.la;

import lombok.Data;

/**
 * Vertice
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@Data
public class Vertice<T> {
    private T valor;
    private int x;
    private int y;
    private boolean marcado;

    public Vertice(T valor) {
        this.valor = valor;
    }

    public Vertice(T valor, int x, int y) {
        this.valor = valor;
        this.x = x;
        this.y = y;
    }
}
