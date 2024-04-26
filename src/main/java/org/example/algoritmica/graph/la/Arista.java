package org.example.algoritmica.graph.la;

import lombok.Data;

/**
 * Arista
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@Data
public class Arista {
    private int posVDestino;
    private Double peso;

    public Arista(int posVDestino) {
        this.posVDestino = posVDestino;
    }
}
