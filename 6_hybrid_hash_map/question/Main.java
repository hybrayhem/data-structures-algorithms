package question;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import question.HashTableHybrid;
import question.Q2;

class Main {
    static final double micro2nano = 1000;

    // secure input function that gets the int selection for menu with a
    // bullet-proof
    // error handling
    public static int get_selection(String msg, int lower, int upper) {
        boolean flag = false;
        int selection = 0;

        Scanner scanner = new Scanner(System.in);
        while (!flag) {
            if (!msg.isEmpty())
                System.out.printf("%s", msg);
            selection = scanner.nextInt();
            // System.out.println(scanner.next()); // remove unnecessary characters
            if (selection < lower || selection > upper) {
                System.out.printf("Invalid!%n");
                continue;
            }
            flag = true;
        }
        scanner.close();
        return selection;
    }

    /**
     * @param array
     * @param sampleNum
     */
    public static void testQ2(int[] array, int sampleNum) {
        Q2 q2 = new Q2();

        long mergeTime = 0;
        long quickTime = 0;
        long newTime = 0;

        for (int i = 0; i < sampleNum; i++) {
            q2.fillRandomArray(array);

            int[] arrayCopy = Arrays.copyOf(array, array.length);

            long mergeStartTime = System.nanoTime();
            q2.mergeSort(arrayCopy);
            long mergeDuration = System.nanoTime() - mergeStartTime;
            mergeTime += mergeDuration; // total merge sort time

            arrayCopy = Arrays.copyOf(array, array.length); // reset array

            long quickStartTime = System.nanoTime();
            q2.quickSort(arrayCopy);
            long quickDuration = System.nanoTime() - quickStartTime;
            quickTime += quickDuration; // total quick sort time

            arrayCopy = Arrays.copyOf(array, array.length); // reset array

            long newStartTime = System.nanoTime();
            q2.newSort(arrayCopy);
            long newDuration = System.nanoTime() - newStartTime;
            newTime += newDuration; // total new sort time
        }
        // get average times
        mergeTime /= sampleNum * micro2nano;
        quickTime /= sampleNum * micro2nano;
        newTime /= sampleNum * micro2nano;

        System.out.printf(
                "\nSample: %d, Array Size: %d\n(average time costs)\nMerge Sort: %d microseconds\nQuick Sort: %d microseconds\nNew Sort: %d microseconds\n\n",
                sampleNum, array.length, mergeTime, quickTime, newTime);
        System.out.println("");
    }

    /**
     * @param hTable
     * @param size
     */
    public static void fillRandomTable(HashTableHybrid<Integer, Integer> hTable, int size) {
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int num = random.nextInt(size);
            hTable.put(num, num);
        }
    }

    /**
     * @param size
     */
    public static void testQ1(int size) {
        HashTableHybrid<Integer, Integer> hTable = new HashTableHybrid<>();
        long insertTime = 0;
        int sampleNum = 100;

        for (int i = 0; i < sampleNum; i++) {
            long startTime = System.nanoTime();
            fillRandomTable(hTable, size);
            long duration = System.nanoTime() - startTime;
            insertTime += duration; // total insert time
        }
        // get average times
        insertTime /= sampleNum * micro2nano;
        System.out.printf("\nSample: %d, Array Size: %d\n(average time costs)\nHashTable Insert: %d microseconds\n",
                sampleNum,
                size, insertTime);
        System.out.println("");

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");

        /* ----------------------------------- Q1 ----------------------------------- */
        try {
            testQ1(100);
            testQ1(1000);
            testQ1(10000);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        /* ----------------------------------- Q2 ----------------------------------- */
        int[] smallArray = new int[100];
        int[] medArray = new int[1000];
        int[] largeArray = new int[10000];

        try {
            testQ2(smallArray, 100);
            testQ2(medArray, 100);
            testQ2(largeArray, 100);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
