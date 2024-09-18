package org.example.grabacion.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Test
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,2,1,2));
        System.out.println(list);
        list.remove(new Integer(2));
        System.out.println(list);

        //list.subList()
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(1, 3, 5, 7));
        //System.out.println(st);
    }
}
