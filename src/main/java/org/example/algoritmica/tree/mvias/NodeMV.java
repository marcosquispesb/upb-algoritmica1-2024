package org.example.algoritmica.tree.mvias;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

@ToString
public class NodeMV {
    public static final int M_VIAS = 3;

    @Getter
    private Integer[] values;
    private NodeMV[] vias;

    public NodeMV() {
        vias = new NodeMV[M_VIAS];
        values = new Integer[M_VIAS - 1];
    }

    public NodeMV(Integer firstValue) {
        vias = new NodeMV[M_VIAS];
        values = new Integer[M_VIAS - 1];
        values[0] = firstValue;
    }

    public Integer getValue(int pos) {
        return values[pos];
    }

    public void setValue(int pos, Integer value) {
        values[pos] = value;
    }

    public NodeMV getVia(int pos) {
        return vias[pos];
    }

    public void setVia(int pos, NodeMV node) {
        vias[pos] = node;
    }

    public boolean isFull() {
        for (Integer value : values) {
            if (value == null)
                return false;
        }
        return true;
    }

    public int sumValues() {
//        int sum = 0;
//        for (Integer value : values) {
//            if (value != null)
//                sum += value;
//        }
//        return sum;

//        return Arrays.stream(values)
//                .filter(x -> x != null)
//                .reduce(0, (x, y) -> x + y);

        return Arrays.stream(values)
                .filter(Objects::nonNull)
                .reduce(0, Integer::sum);
    }

//    public boolean isLeaf() {
//        return false;
//    }

    public static void main(String[] args) {
        NodeMV node1 = new NodeMV();
        node1.setValue(0, 40);
        node1.setValue(1, 80);

        NodeMV node2 = new NodeMV();
        node2.setValue(0, 10);

        node1.setVia(0, node2);
    }
}
