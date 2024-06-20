package com.thealgorithms.sorts;

import java.util.Arrays;

/**
 * BitonicSort class implements the SortAlgorithm interface using the bitonic sort technique.
 */
public class BitonicSort implements SortAlgorithm {

    /**
     * Sorts the given array using the Bitonic Sort algorithm.
     *
     * @param <T> the type of elements in the array, which must implement the Comparable interface
     * @param arr the array to be sorted
     * @return the sorted array
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        final int paddedSize = nextPowerOfTwo(arr.length);
        T[] paddedArray = Arrays.copyOf(arr, paddedSize);

        // Fill the padded part with a maximum value
        final T maxValue = SortUtils.max(arr);
        Arrays.fill(paddedArray, arr.length, paddedSize, maxValue);

        bitonicSort(paddedArray, 0, paddedSize, true);
        return Arrays.copyOf(paddedArray, arr.length);
    }

    private <T extends Comparable<T>> void bitonicSort(T[] arr, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            final int k = cnt / 2;

            // Sort first half in ascending order
            bitonicSort(arr, low, k, true);

            // Sort second half in descending order
            bitonicSort(arr, low + k, cnt - k, false);

            // Merge the whole sequence in ascending order
            bitonicMerge(arr, low, cnt, dir);
        }
    }

    /**
     * Merges the bitonic sequence in the specified direction.
     *
     * @param <T> the type of elements in the array, which must be Comparable
     * @param arr the array containing the bitonic sequence to be merged
     * @param low the starting index of the sequence to be merged
     * @param cnt the number of elements in the sequence to be merged
     * @param dir the direction of sorting: true for ascending, false for descending
     */
    private <T extends Comparable<T>> void bitonicMerge(T[] arr, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            final int k = cnt / 2;

            for (int i = low; i < low + k; i++) {
                if (dir == (arr[i].compareTo(arr[i + k]) > 0)) {
                    SortUtils.swap(arr, i, i + k);
                }
            }

            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, cnt - k, dir);
        }
    }

    /**
     * Finds the next power of two greater than or equal to the given number.
     *
     * @param n the number
     * @return the next power of two
     */
    private static int nextPowerOfTwo(int n) {
        int count = 0;

        // First n in the below condition is for the case where n is 0
        if ((n & (n - 1)) == 0) {
            return n;
        }

        while (n != 0) {
            n >>= 1;
            count += 1;
        }

        return 1 << count;
    }
}
