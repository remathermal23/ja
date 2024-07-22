package com.thealgorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.thealgorithms.bitmanipulation.SingleBitOperations;
import com.thealgorithms.maths.LeonardoNumber;

/**
 * Wikipedia: https://en.wikipedia.org/wiki/Smoothsort
 */
public class LeonardoHeap<T extends Comparable<T>> {

    private int levelTracker = 0;
    private final List<T> heap = new ArrayList<T>();

    public LeonardoHeap() {
    }

    private void decreaseLevelTracker() {
        final int lastTreeLevel = getRightMostTree();
        levelTracker = SingleBitOperations.clearBit(levelTracker, lastTreeLevel);
        if (lastTreeLevel != 0 && lastTreeLevel != 1) {
            levelTracker = SingleBitOperations.setBit(levelTracker, lastTreeLevel - 1);
            levelTracker = SingleBitOperations.setBit(levelTracker, lastTreeLevel - 2);
        }
    }

    private void increaseLevelTracker() {
        final ArrayList<Integer> consecutiveTreeIndices = findConsecutiveTreeIndices(levelTracker);
        if (consecutiveTreeIndices.get(0) != -1) {
            // if 0th or 1st index is -1 that implies there are no concequtive trees
            levelTracker = SingleBitOperations.clearBit(levelTracker, consecutiveTreeIndices.get(0));
            levelTracker = SingleBitOperations.clearBit(levelTracker, consecutiveTreeIndices.get(1));
            levelTracker = SingleBitOperations.setBit(levelTracker, consecutiveTreeIndices.get(1) + 1);
        } else if ((levelTracker & 2) == 0) {
            levelTracker = SingleBitOperations.setBit(levelTracker, 1);
        } else {
            levelTracker = SingleBitOperations.setBit(levelTracker, 0);
        }
    }

    private void maxHeapifyTree(int rootNodeIndex, int currentLevel) {
        // A leonardo tree of level n is just 1 node(the root) plus the leonardo tree of n-1 level(left child) plus leonardo tree of n-2 level(right child)
        // To maxheapify a leonardo tree we need to compare the current root and roots of it's left and right subtree
        // We recursively hepify the left and right subtrees using the currentLevel

        // BASE CASE
        if (currentLevel == 0 || currentLevel == 1) {
            return; // Trees with one node are in already max-heapified.
        }

        final int currentRootNodeIndex = rootNodeIndex;
        final int rightChildIndex = rootNodeIndex - 1;
        final int leftChildIndex = rootNodeIndex - LeonardoNumber.leonardoNumber(currentLevel - 2) - 1;
        final int childIndexForSwap = (heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) >= 0) ? rightChildIndex : leftChildIndex;

        if (heap.get(childIndexForSwap).compareTo(heap.get(currentRootNodeIndex)) > 0) {
            swap(currentRootNodeIndex, childIndexForSwap);
            if (childIndexForSwap == rightChildIndex) {
                maxHeapifyTree(rightChildIndex, currentLevel - 2);
            } else { // swap happened with the left child
                maxHeapifyTree(leftChildIndex, currentLevel - 1);
            }
        }
    }

    private void shiftRootAndRestoreHeap() {

        if (heap.isEmpty()) {
            return;
        }

        final Integer[] currentTreeLevels = findAllTreeIndices(levelTracker);
        int previousTreeSizeCumulative = 0;
        ArrayList<Integer> rootNodeIndices = new ArrayList<Integer>();

        // The number of roots are going to be same the the number of levels
        // iterate over the currentTreeLevels and get roots

        for (int i = 0; i < currentTreeLevels.length; i++) {
            rootNodeIndices.add(previousTreeSizeCumulative + LeonardoNumber.leonardoNumber(currentTreeLevels[i]) - 1);
            previousTreeSizeCumulative = previousTreeSizeCumulative + LeonardoNumber.leonardoNumber(currentTreeLevels[i]);
        }

        int rootNodeIndexForHeapify = rootNodeIndices.getLast();
        int treeLevelforHeapify = currentTreeLevels[currentTreeLevels.length - 1];

        for (int i = 1; i < rootNodeIndices.size(); i++) {

            int currentRootNodeIndex = rootNodeIndices.get(i);
            int prevRootNodeIndex = rootNodeIndices.get(i - 1);
            int j = i;
            boolean swapped = false;

            while (heap.get(prevRootNodeIndex).compareTo(heap.get(currentRootNodeIndex)) > 0) {
                final int currentLevel = currentTreeLevels[j];
                if (currentLevel > 1) {
                    // compare child and swap

                    final int rightChildIndex = rootNodeIndices.get(j) - 1; // right child is of level n-2
                    final int leftChildIndex = rootNodeIndices.get(j) - 1 - LeonardoNumber.leonardoNumber(currentLevel - 2);
                    if (heap.get(prevRootNodeIndex).compareTo(heap.get(rightChildIndex)) > 0 && heap.get(prevRootNodeIndex).compareTo(heap.get(leftChildIndex)) > 0) {
                        swap(prevRootNodeIndex, currentRootNodeIndex);
                        rootNodeIndexForHeapify = prevRootNodeIndex;
                        treeLevelforHeapify = currentTreeLevels[j - 1];
                        swapped = true;
                    } else {
                        maxHeapifyTree(currentRootNodeIndex, currentLevel);
                        swapped = false;
                    }
                } else {
                    swap(prevRootNodeIndex, currentRootNodeIndex);
                    rootNodeIndexForHeapify = prevRootNodeIndex;
                    treeLevelforHeapify = currentTreeLevels[j - 1];
                    swapped = true;
                }
                j = j - 1;
                if (j > 0) {
                    currentRootNodeIndex = rootNodeIndices.get(j);
                    prevRootNodeIndex = rootNodeIndices.get(j - 1);
                } else {
                    // j = 0 reached the left most tree
                    break;
                }
            }

            if (swapped) {
                maxHeapifyTree(rootNodeIndexForHeapify, treeLevelforHeapify);
            }
        }

        maxHeapifyTree(rootNodeIndexForHeapify, treeLevelforHeapify); // In case of insert and no swap.
    }

    private int getRightMostTree() {
        // Isolate the rightmost set bit
        int isolatedBit = levelTracker & -levelTracker;
        int position = 0;

        while (isolatedBit > 1) {
            isolatedBit >>= 1;
            position++;
        }

        return position;
    }

    private void swap(int i, int j) {
        Collections.swap(heap, i, j);
    }

    public void addElement(T element) {
        increaseLevelTracker();
        heap.add(element);
        shiftRootAndRestoreHeap();
    }

    public T removeElement() {
        decreaseLevelTracker();
        final T element = heap.removeLast();
        shiftRootAndRestoreHeap();

        return element;
    }

    private static ArrayList<Integer> findConsecutiveTreeIndices(int num) {
        int prevOneIndex = -1;
        int currentLevel = 0;

        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(-1);
        answer.add(-1);

        for (int i = 0; num > 0; i++) {
            currentLevel = num & 1;
            if (currentLevel == 1) {
                if (prevOneIndex != -1) {
                    answer.set(0, prevOneIndex);
                    answer.set(1, i);
                }
                prevOneIndex = i;
            } else {
                prevOneIndex = -1;
            }
            num >>>= 1;
        }
        return answer;
    }

    private static Integer[] findAllTreeIndices(int num) {
        List<Integer> setBitIndexes = new ArrayList<>();
        for (int i = Integer.SIZE - 1; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                setBitIndexes.add(i);
            }
        }
        return setBitIndexes.toArray(new Integer[0]);
    }
}
