package org.example.algoritmica.tree.treebinary;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Test
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class Test {

    public static Map<Integer, String> getIndexWordsMap(String value) {
        Map<Integer, String> resultMap = new LinkedHashMap<>();
        if (value == null || value.trim().isEmpty())
            return resultMap;

        boolean concatChars = false;
        Integer indexInitWord = null;
        String word = "";
        for (int i = 0; i < value.length(); i++) {
            if (concatChars) {
                if (value.charAt(i) == ' ') {
                    concatChars = false;
                    resultMap.put(indexInitWord, word);
                } else {
                    word += value.charAt(i);
                    if (i == value.length() - 1) {
                        resultMap.put(indexInitWord, word);
                    }
                }
            } else {
                if (value.charAt(i) != ' ') {
                    concatChars = true;
                    indexInitWord = i;
                    word = "" + value.charAt(i);
                    if (i == value.length() - 1) {
                        resultMap.put(indexInitWord, word);
                    }
                }
            }
        }

        return resultMap;
    }

    public static int getIndex(String line, String valueToSearch) {
        Map<Integer, String> indexWordsMap = getIndexWordsMap(line);
        //System.out.println(indexWordsMap);
        Integer index = -1;
        if (valueToSearch.trim().contains(" ")) {
            index = line.indexOf(valueToSearch);
        } else {
            for (Map.Entry<Integer, String> entry : indexWordsMap.entrySet()) {
                if (entry.getValue().equals(valueToSearch.trim())) {
                    index = entry.getKey();
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String line = " 1 5 5 ";
        String valueToSearch = "5";
        System.out.println("["+line+"]");
        System.out.println(getIndex(line, valueToSearch));
    }
}
