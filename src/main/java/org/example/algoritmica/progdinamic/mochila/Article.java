package org.example.algoritmica.progdinamic.mochila;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Article {

    private String nombre;
    private int beneficio;
    private int espacio;

    @Override
    public String toString() {
        return "Article{" +
                "nombre='" + nombre + '\'' +
                ", beneficio=" + beneficio +
                ", espacio=" + espacio +
                '}';
    }
}
