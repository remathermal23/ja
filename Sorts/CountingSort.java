package Sorts;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Youssef Ali (https://github.com/youssefAli11997)
 */

class CountingSort {

    /**
     * This method implements the Generic Counting Sort. Sorts the array in increasing order
     * It uses array elements as keys in the frequency map
     *
     * @param array The array to be sorted
     * @param last  The count of total number of elements in array
     **/

    public static <T extends Comparable<T>> void countingSort(T[] array, int last) {

        Map<T, Integer> frequency = new TreeMap<>();
        // The final output array
        ArrayList<T> sortedArray = new ArrayList<>();

        // Counting the frequency of @param array elements
        for (T t : array) {
            try {
                frequency.put(t, frequency.get(t) + 1);
            } catch (Exception e) { // new entry
                frequency.put(t, 1);
            }
        }

        // Filling the sortedArray
        for (Map.Entry<T, Integer> element : frequency.entrySet()) {
            for (int j = 0; j < element.getValue(); j++)
                sortedArray.add(element.getKey());
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = sortedArray.get(i);
        }
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] arr1 = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        System.out.println("Before Sorting:");
        for (Integer anArr1 : arr1) {
            System.out.print(anArr1 + " ");
        }
        System.out.println();

        countingSort(arr1, arr1.length);

        // Output => 1 4 6 9 12 23 54 78 231
        System.out.println("After Sorting:");
        for (Integer anArr1 : arr1) {
            System.out.print(anArr1 + " ");
        }
        System.out.println();

        System.out.println("------------------------------");

        // String Input
        String[] array1 = {"c", "a", "e", "b", "d"};

        System.out.println("Before Sorting:");
        for (String anArray1 : array1) {
            System.out.print(anArray1 + " ");
        }
        System.out.println();

        countingSort(array1, array1.length);

        //Output => a b c d e
        System.out.println("After Sorting:");
        for (String str : array1) {
            System.out.print(str + " ");
        }

    }
}
