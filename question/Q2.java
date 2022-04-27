package question;

import java.util.Random;

public class Q2 {
    private Random random = new Random();

    public Q2() {
        System.out.printf("%n/* ----------------------------------- Q2 ----------------------------------- */%n%n");
    }

    public void fillRandomArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
    }

    public void printArray(int[] array) {
        System.out.printf("%n[");
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }

    /**
     * Merge two sequences.
     * 
     * @pre leftSequence and rightSequence are sorted.
     * @post outputSequence is the merged result and is sorted.
     * @param outputSequence The destination
     * @param leftSequence   The left input
     * @param rightSequence  The right input
     */
    private void merge(int[] outputSequence, int[] leftSequence, int[] rightSequence) {
        int i = 0;
        // Index into the left input sequence.
        int j = 0;
        // Index into the right input sequence.
        int k = 0;
        // Index into the output sequence.
        // While there is data in both input sequences
        while (i < leftSequence.length && j < rightSequence.length) {
            // Find the smaller and
            // insert it into the output sequence.
            if (leftSequence[i] < rightSequence[j]) {
                outputSequence[k++] = leftSequence[i++];
            } else {
                outputSequence[k++] = rightSequence[j++];
            }
        }
        // assert: one of the sequences has more items to copy.
        // Copy remaining input from left sequence into the output.
        while (i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
        }
        // Copy remaining input from right sequence into output.
        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
        }
    }

    /**
     * Sort the array using the merge sort algorithm.
     * pre: table contains Comparable objects.
     * post: table is sorted.
     * 
     * @param table The array to be sorted
     */
    public void mergeSort(int[] table) {
        // A table with one element is sorted already.
        if (table.length > 1) {
            // Split table into halves.
            int halfSize = table.length / 2;
            int[] leftTable = new int[halfSize];
            int[] rightTable = new int[table.length - halfSize];
            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);

            // Sort the halves.
            mergeSort(leftTable);
            mergeSort(rightTable);
            // Merge the halves.
            merge(table, leftTable, rightTable);
        }
    }

    /**
     * Sort the table using the quicksort algorithm.
     * 
     * @pre table contains Comparable objects.
     * @post table is sorted.
     * @param table The array to be sorted
     */
    public void quickSort(int[] table) {
        // Sort the whole table.
        rQuickSort(table, 0, table.length - 1);
    }

    /**
     * Sort a part of the table using the quicksort algorithm.
     * 
     * @post The part of table from first through last is sorted.
     * @param table The array to be sorted
     * @param first The index of the low bound
     * @param last  The index of the high bound
     */
    private void rQuickSort(int[] table, int first, int last) {
        if (first < last) { // There is data to be sorted.
            // Partition the table.
            int pivIndex = partition(table, first, last);
            // Sort the left half.
            rQuickSort(table, first, pivIndex - 1);
            // Sort the right half.
            rQuickSort(table, pivIndex + 1, last);
        }
    }

    /**
     * Partition the table so that values from first to pivIndex
     * are less than or equal to the pivot value, and values from
     * pivIndex to last are greater than the pivot value.
     * 
     * @param table The table to be partitioned
     * @param first The index of the low bound
     * @param last  The index of the high bound
     * @return The location of the pivot value
     */
    private int partition(int[] table, int first, int last) {
        // Select the first item as the pivot value.
        int pivot = table[first];
        int up = first;
        int down = last;
        do {
            /*
             * Invariant:
             * All items in table[first . . . up - 1] <= pivot
             * All items in table[down + 1 . . . last] > pivot
             */
            while ((up < last) && (pivot >= table[up])) {
                up++;
            }
            // assert: up equals last or table[up] > pivot.
            while (pivot < table[down]) {
                down--;
            }
            // assert: down equals first or table[down] <= pivot.
            if (up < down) {
                // if up is to the left of down.
                // Exchange table[up] and table[down].
                swap(table, up, down);
            }
        } while (up < down); // Repeat while up is left of down.
        // Exchange table[first] and table[down] thus putting the
        // pivot value where it belongs.
        swap(table, first, down);
        // Return the index of the pivot value.
        return down;
    }

    private void swap(int[] table, int up, int down) {
        int temp = table[up];
        table[up] = table[down];
        table[down] = temp;
    }

    public void newSort(int[] table) {
        // Sort the whole table.
        rNewSort(table, 0, table.length - 1);
    }

    private int[] rNewSort(int[] array, int head, int tail) {
        // printArray(array);
        if (head > tail) {
            return array;
        } else {
            int[] minMax = { 0, 0 };
            findMinMax(array, head, tail, minMax);
            swap(array, head, minMax[0]);
            swap(array, tail, minMax[1]);
            return rNewSort(array, head + 1, tail - 1);
        }
    }

    // find the indices of minimum and maximum items between the given head and tail
    /* private */public void findMinMax(int[] array, int head, int tail, int[] result) {
        if (head == tail) {
            return;
        }

        // System.out.println(array[head] + ", " + array[tail]);
        if (array[head] > array[tail]) {
            result[0] = minIndex(array, result[0], tail);
            result[1] = maxIndex(array, result[1], head);
        } else {
            result[0] = minIndex(array, result[0], head);
            result[1] = maxIndex(array, result[1], tail);
        }

        int mid = (head + tail) / 2;
        // Traverse the left half.
        findMinMax(array, head, mid, result);
        // Traverse the right half.
        findMinMax(array, mid + 1, tail, result);

    }

    private int minIndex(int[] array, int first, int second) {
        if (array[first] > array[second])
            return second;
        return first;
    }

    private int maxIndex(int[] array, int first, int second) {
        if (array[first] < array[second])
            return second;
        return first;
    }

}
