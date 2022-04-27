package question;

import java.util.Arrays;
import java.util.Scanner;

import question.Q1;
import question.Q2;

class Main {
    static final double micro2nano = 1000;

    /**
     * @param msg
     * @param lower
     * @param upper
     * @return int
     */
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

    public static void testQ2(int[] array, int iteration) {
        Q2 q2 = new Q2();

        long mergeTime = 0;
        long quickTime = 0;
        long newTime = 0;

        for (int i = 0; i < iteration; i++) {
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
        mergeTime /= iteration * micro2nano;
        quickTime /= iteration * micro2nano;
        newTime /= iteration * micro2nano;

        System.out.printf(
                "\nSample: %d, Array Size: %d\n(average time costs)\nMerge Sort: %d microseconds\nQuick Sort: %d microseconds\nNew Sort: %d microseconds\n\n",
                iteration, array.length, mergeTime, quickTime, newTime);
        System.out.println("");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");

        /* ----------------------------------- Q1 ----------------------------------- */

        /* ----------------------------------- Q2 ----------------------------------- */
        int[] smallArray = new int[100];
        int[] medArray = new int[1000];
        int[] largeArray = new int[10000];

        testQ2(smallArray, 100);
        testQ2(medArray, 100);
        testQ2(largeArray, 100);

        // int[] minMax = {0,0};
        // q2.findMinMax(smallArray, 0, smallArray.length-1, minMax);
        // System.out.println("result: " + smallArray[minMax[0]] + ", " +
        // smallArray[minMax[1]]);
        // System.out.println(", T(n) = " + ((stopTime - startTime) / 1000) + "." +
        // (((stopTime - startTime) / 100) % 10) + " microsecond");
    }
}
