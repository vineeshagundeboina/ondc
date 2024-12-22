package com.twg.dairy.mydairy.service;




import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Example of a nested array structure
        Object[] nestedArray = {1, new Object[]{1, 2, new Object[]{3, new Object[]{4, 5}}}};

        // Convert the nested array to a single array
        List<Integer> resultList = new ArrayList<>();
        flattenArray(nestedArray, resultList);

        // Convert the list to an array
        int[] singleArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            singleArray[i] = resultList.get(i);
        }

        // Print the single array
        for (int i : singleArray) {
            System.out.print(i + " ");
        }
    }

    public static void flattenArray(Object[] nestedArray, List<Integer> resultList) {
        for (Object element : nestedArray) {
            if (element instanceof Integer) {
                resultList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flattenArray((Object[]) element, resultList);
            }
        }
    }
}