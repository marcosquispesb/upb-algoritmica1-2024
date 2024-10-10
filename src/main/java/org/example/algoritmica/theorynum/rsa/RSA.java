package org.example.algoritmica.theorynum.rsa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RSA
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RSA {
    private int p;
    private int q;
    private int n;
    private int fiN;
    private int e;
    private int d;
}
