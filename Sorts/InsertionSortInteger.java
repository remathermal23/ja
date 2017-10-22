package Sorts;

/**
 * This is my implementation of an insertion sort.
 * <p>
 * I decided to do this when i didn't feel comfortable enough about implementing
 * different types of sorts, so this is my trial and error to try and get myself to implement
 * the various sorts correctly.
 *
 * @author Kody C. Kendall
 */
public class InsertionSortInteger {

    /**
     * This method implements insertion sort by integer
     *
     * @param initialArray array to be sorted
     * @return sorted array
     */
    public static int[] insertionIntArraySort(int[] initialArray) {

        int[] sortedArray = new int[initialArray.length];

        //Marking first element as sorted.
        sortedArray[0] = initialArray[0];

        //For each element in the initialArray
        for (int index = 1; index < initialArray.length; index++) {

            //Extracting the next element to be compared w/ other sorted elements from initial array
            int extractedElement = initialArray[index];

            //Compare the values of the sorted index to the current extractedElement
            for (int lastSortedIndex = index; lastSortedIndex > 0; lastSortedIndex--) {

                //If our extracted element is smaller than element to the right, switch them.
                if (sortedArray[lastSortedIndex - 1] > extractedElement) {
                    //move the element to the left of extractedElement to the right in sortedArray
                    sortedArray[lastSortedIndex] = sortedArray[lastSortedIndex - 1];
                    //And move the current extractedElement to the left one (since it's smaller).
                    sortedArray[lastSortedIndex - 1] = extractedElement;
                } else {
                    //insert element where it is.
                    sortedArray[lastSortedIndex] = extractedElement;
                    //Terminating loop since element is in the right spot.
                    break;
                }
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        // Integer Input
        int[] array = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        int[] result = insertionIntArraySort(array);

        // Output => 1 4 6 9 12 23 54 78 231
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}