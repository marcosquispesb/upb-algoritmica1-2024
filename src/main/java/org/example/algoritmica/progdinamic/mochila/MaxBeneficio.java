package org.example.algoritmica.progdinamic.mochila;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class MaxBeneficio {
    private int beneficios;
    private List<Article> solucion;
}
