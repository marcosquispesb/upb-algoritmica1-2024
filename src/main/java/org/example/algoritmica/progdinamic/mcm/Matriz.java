package org.example.algoritmica.progdinamic.mcm;

import lombok.Data;
import lombok.ToString;

/**
 * Matriz
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@ToString
@Data
public class Matriz {
    public String nombre;
    public int nroFilas;
    public int nroColumnas;

    public Matriz(String nombre, int nroFilas, int nroColumnas) {
        this.nombre = nombre;
        this.nroFilas = nroFilas;
        this.nroColumnas = nroColumnas;
    }
}
