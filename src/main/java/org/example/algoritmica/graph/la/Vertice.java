package org.example.algoritmica.graph.la;

import lombok.Data;

/**
 * Vertice
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@Data
public class Vertice {
    private String valor;
    private boolean marcado;

    private Double dijPesoAcumulado; // aux para dijkstra
    private Integer dijPosVPredecesor; // aux para dijkstra

    public Vertice(String valor) {
        this.valor = valor;
    }
}
