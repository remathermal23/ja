package com.thealgorithms.maths;

/**
 * A utility class for computing the average of numeric arrays.
 * This class provides static methods to calculate the average of arrays
 * of both {@code double} and {@code int} values.
 */
public final class Average {

    // Prevent instantiation of this utility class
    private Average() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * Computes the average of a {@code double} array.
     *
     * @param numbers an array of {@code double} values
     * @return the average of the given numbers
     * @throws IllegalArgumentException if the input array is {@code null} or empty
     */
    public static double computeAverage(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    /**
     * Computes the average of an {@code int} array.
     *
     * @param numbers an array of {@code int} values
     * @return the average of the given numbers
     * @throws IllegalArgumentException if the input array is {@code null} or empty
     */
    public static int computeAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (int) (sum / numbers.length);
    }
}
