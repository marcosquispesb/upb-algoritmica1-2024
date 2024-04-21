package org.example.algoritmica.tree.treebinary;

import java.util.*;

/**
 * TreeBinaryUtil
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TBPrintUtil {

    public static void print(TBPrint tbPrint) {
        if (tbPrint.getRoot() == null) {
            System.out.println("(Arbol vario)");
            return;
        }

        setViewedFalse(tbPrint.getRoot());

        int dpt = dpt(tbPrint.getRoot());
        setViewedFalse(tbPrint.getRoot());

        String[] edgesLevels = new String[dpt];
        String[] dataLevels = new String[dpt];
        Arrays.fill(edgesLevels, "");
        Arrays.fill(dataLevels, "");

        Map<String, String> childrenMap = new HashMap<>();
        String spacesChildren = printRec(tbPrint.getRoot(), 0, dataLevels, edgesLevels, null, childrenMap, tbPrint.getRoot());
        dataLevels[0] += spacesChildren;

        for (int i = 0; i < dataLevels.length; i++) {
            //System.out.println("level " + i + ": " + dataLevels[i]);
            if (i > 0)
                System.out.println(edgesLevels[i]);
            System.out.println(dataLevels[i]);
        }
    }

    private static String printRec(Node node, int level, String[] dataLevels, String[] edgesLevels, Node parent, Map<String, String> childrenMap, Node root) {
        if (node == null)
            return "";

        if (node.isViewed()) {
            if (node.equals(root)) {
                System.err.println("WARN La raiz " + node.getValue() + " esta siendo apuntada por un descendiente");
                System.err.println("WARN Cayo en un bucle infinito, revise los punteros de: " + parent.getValue());
            } else {
                System.err.println("WARN El nodo " + node.getValue() + " tiene varios nodos que lo apuntan");
                System.err.println("WARN Podria caer en un bucle infinito, revise los punteros de: " + parent.getValue());
            }
            return "";
        }

        node.setViewed(true);
        if (node.isLeaf())
            return "" + node.getValue();

        String spaceLeft = printRec(node.getLeft(), level + 1, dataLevels, edgesLevels, node, childrenMap, root);
        String spaceRight = printRec(node.getRight(), level + 1, dataLevels, edgesLevels, node, childrenMap, root);
        String childrenStr = spaceLeft + (spaceLeft.endsWith(" ") || spaceRight.startsWith(" ") ? "" : " ") + spaceRight;

        boolean childrenUniqueValueRight = false;
        boolean childrenUniqueValueLeft = false;
        if (node.getLeft() == null && node.getRight() != null) { // nodo tiene solo hijo derecho
            //System.out.println(node.getValue());
            childrenUniqueValueRight = true;
        } else if (node.getRight() == null && node.getLeft() != null) { // nodo tiene solo hijo izquierdo
            //System.out.println(node.getValue());
            childrenUniqueValueLeft = true;
        } else if (node.hasTwoSon()) {
            if (node.getLeft().isLeaf()) { // hijo izq es hoja
                addSpacesGoDown(spaceLeft, level, dataLevels, edgesLevels);
                if (node.getRight().getLeft() != null) {
                    //System.out.println("aaa:" + node.getRight().getValue());
                    addSpacesGoDown(spaceLeft, level, dataLevels, edgesLevels);

                    int index = childrenStr.indexOf(spaceRight);
                    childrenStr = childrenStr.substring(0, index) + " " + childrenStr.substring(index);
                }
            }
            if (node.getRight().isLeaf()) { // hijo der es hoja
                if (node.getLeft().getRight() != null) {
                    //System.out.println("bbb:" + node.getRight().getValue());

                    int index = childrenStr.indexOf(spaceRight);
                    childrenStr = childrenStr.substring(0, index) + " " + childrenStr.substring(index);
                }
            }
        }

        String result = ""+node.getValue();
        try {
            //System.out.println("childrenStr:" + childrenStr);
            String addSpace = (!dataLevels[level + 1].endsWith(" ") && !childrenStr.startsWith(" ") ? " " : "");
            addSpace = dataLevels[level + 1].isEmpty() ? "" : addSpace;
            childrenStr = addSpace + childrenStr;
            dataLevels[level + 1] += childrenStr;
            childrenMap.put(node.getId(), childrenStr);

            result = spaces(childrenStr.length() / 2) + node.getValue();
            result = result + spaces(childrenStr.length() - result.length());

            if (childrenUniqueValueRight) {
                //System.out.println("childrenStr:" + childrenStr);

                //System.out.println("rr:" + result);
                if (result.startsWith(" ")) {
                    int index2 = result.indexOf(result.trim());
                    String spaces2 = result.substring(0, index2);
                    result = result.substring(index2) + spaces2;
                }
                //System.out.println("rr:" + result);

                // recorriendo hijos
                if (parent != null && parent.getRight() != null && Objects.equals(parent.getRight().getValue(), node.getValue())) {
                    //System.out.println("rh:" + result);
                    //System.out.println("childrenStr:" + childrenStr);
                    recorrerHijos(node, level, dataLevels, edgesLevels, childrenMap);
                }

            } else if (childrenUniqueValueLeft) {
                //System.out.println("childrenStr:" + childrenStr);
                int indexChild = childrenStr.indexOf(childrenStr.trim());
                int indexResult = result.indexOf(result.trim());
                if (indexResult <= indexChild) {
                    String spacesToAdd = spaces(indexChild - indexResult + 1);
                    result = result.substring(0, indexResult) + spacesToAdd + result.substring(indexResult);
                }

            } else if (node.hasTwoSon()) {
                // reajuste result solo si hijos son dos o mas elementos, para que dicho valor quede lo mejor centrado posible
                int index2 = childrenStr.indexOf(childrenStr.trim());
                String spacesInitial = childrenStr.substring(0, index2);

                int countSpacesInitial = 0;
                if (childrenStr.trim().length() % 2 == 0 && ("" + node.getValue()).length() % 2 == 0) { // ambos pares
                    countSpacesInitial = (childrenStr.trim().length() - ("" + node.getValue()).length()) / 2;

                } else if (childrenStr.trim().length() % 2 == 1 && ("" + node.getValue()).length() % 2 == 1) { // ambos impares
                    countSpacesInitial = (childrenStr.trim().length() - ("" + node.getValue()).length()) / 2;

                } else if (childrenStr.trim().length() % 2 == 1 && ("" + node.getValue()).length() % 2 == 0) { // hijos impar, padre par
                    countSpacesInitial = (childrenStr.trim().length() + 1 - ("" + node.getValue()).length()) / 2;

                } else if (childrenStr.trim().length() % 2 == 0 && ("" + node.getValue()).length() % 2 == 1) { // hijos par, padre impar
                    countSpacesInitial = (childrenStr.trim().length() + 1 - ("" + node.getValue()).length()) / 2;
                }
                result = spacesInitial + spaces(countSpacesInitial) + node.getValue();
                result = result + spaces(childrenStr.length() - result.length());
            }

            // ARISTAS
            int acumulated = edgesLevels[level + 1].length();
            edgesLevels[level + 1] += spaces(childrenStr.length());
            int indexResult = result.indexOf(result.trim());

            if (node.getLeft() != null) { // arista izq
                int indexLeft = childrenStr.indexOf(childrenStr.trim());
                int indexEdgeLeft = acumulated + indexLeft + ((indexResult - indexLeft) / 2);
                edgesLevels[level + 1] = edgesLevels[level + 1].substring(0, indexEdgeLeft) + "/" + edgesLevels[level + 1].substring(indexEdgeLeft + 1);

                if (node.getRight() != null) { // arista der
                    int indexRight = indexLeft + childrenStr.trim().length();
                    int indexEdgeRight = acumulated + indexRight - ((indexRight - indexResult) / 2);
                    edgesLevels[level + 1] = edgesLevels[level + 1].substring(0, indexEdgeRight) + "\\" + edgesLevels[level + 1].substring(indexEdgeRight + 1);
                }
            }

            if (node.getLeft() == null && node.getRight() != null) { // arista solo der
                int indexRight = childrenStr.indexOf(childrenStr.trim()) + ("" + node.getRight().getValue()).length() - 1;
                int indexEdgeRight = acumulated + indexRight - ((indexRight - indexResult) / 2);
                edgesLevels[level + 1] = edgesLevels[level + 1].substring(0, indexEdgeRight) + "\\" + edgesLevels[level + 1].substring(indexEdgeRight + 1);
            }

            // igualando espacios finales hacia abajo
            for (int i = level + 2; i < dataLevels.length; i++) {
                if (dataLevels[level + 1].length() > dataLevels[i].length()) {
                    int dif = dataLevels[level + 1].length() - dataLevels[i].length();
                    dataLevels[i] += spaces(dif);
                }
                if (edgesLevels[level + 1].length() > edgesLevels[i].length()) {
                    int dif = edgesLevels[level + 1].length() - edgesLevels[i].length();
                    edgesLevels[i] += spaces(dif);
                }
            }

//        if (childrenUniqueValueLeft) {
//            System.out.println("result:" + result);
//            System.out.println();
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void recorrerHijos(Node node, int level, String[] dataLevels, String[] edgesLevels, Map<String, String> childrenMap) {
        if (node == null)
            return;
        if (node.isLeaf())
            return;

        String childrenStr = childrenMap.get(node.getId());
        int indexStr = dataLevels[level + 1].indexOf(childrenStr);
        dataLevels[level + 1] = dataLevels[level + 1].substring(0, indexStr) + " " + dataLevels[level + 1].substring(indexStr);
        edgesLevels[level + 1] = edgesLevels[level + 1].substring(0, indexStr) + " " + edgesLevels[level + 1].substring(indexStr);

        recorrerHijos(node.getLeft(), level + 1, dataLevels, edgesLevels, childrenMap);
        recorrerHijos(node.getRight(), level + 1, dataLevels, edgesLevels, childrenMap);
    }

    private static void addSpacesGoDown(String spaceLeft, int level, String[] dataLevels, String[] edgesLevels) {
        int lengthLeft = spaceLeft.trim().length();
        //System.out.println("gd:"+spaceLeft);
        for (int i = level + 2; i < dataLevels.length; i++) {
            if (dataLevels[i].length() < dataLevels[level + 1].length()) {
                //System.out.println("yyy");
                //System.out.println(dataLevels[i]);
                dataLevels[i] += spaces(dataLevels[level + 1].length() - dataLevels[i].length());
                dataLevels[i] += spaces(lengthLeft);

                edgesLevels[i] += spaces(edgesLevels[level + 1].length() - edgesLevels[i].length());
                edgesLevels[i] += spaces(lengthLeft);
            } else {
                //System.out.println("xxx");
                //System.out.println(dataLevels[i]);
                dataLevels[i] = dataLevels[i].substring(0, dataLevels[level + 1].length())
                        + spaces(lengthLeft)
                        + dataLevels[i].substring(dataLevels[level + 1].length());

                edgesLevels[i] = edgesLevels[i].substring(0, edgesLevels[level + 1].length())
                        + spaces(lengthLeft)
                        + edgesLevels[i].substring(edgesLevels[level + 1].length());
            }
        }
    }

    private static String spaces(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += " ";
        }
        return result;
    }

    public static void setViewedFalse(Node root) {
        if (root == null)
            return;

        List<String> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node node;
        do {
            node = queue.poll(); // sacar
            node.setViewed(false);
            visited.add(node.getId());

            List<Node> children = node.getChildren();
            for (Node child : children) {
                if (!visited.contains(child.getId()))
                    queue.add(child);
            }
        } while (!queue.isEmpty());
    }

    private static void assignIds(Node node, int[] id) { // Falla cuando el arbol tiene algun bucle infinito
        if (node == null)
            return;

        if (node.isViewed())
            return;

        id[0] = id[0] + 1;
        //node.setId(id[0]);
        node.setViewed(true);

        assignIds(node.getLeft(), id);
        assignIds(node.getRight(), id);
    }

    public static int dpt(Node node) {
        if (node == null)
            return 0;

        if (node.isViewed())
            return 0;

        if (node.isLeaf())
            return 1;

        node.setViewed(true);

        int izq = dpt(node.getLeft());
        int der = dpt(node.getRight());
        return Math.max(izq, der) + 1;
    }
}
