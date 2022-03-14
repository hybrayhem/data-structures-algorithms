package test_complexity;

import java.util.Scanner;

// In an array of numbers (positive or negative), find pairs of numbers with the given sum.

class Main {

    static int[] generateNumbers(int length) {
        length += 1;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = i - ((length - 1) / 2);
        }
        return numbers;
    }

    static boolean findSumPair(int[] numbers, int sum) {
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == sum) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean recFindSumPair(int[] numbers, int sum, int length, int i, int j) {
        if (i < length) {
            if (j < length) {
                if (numbers[i] + numbers[j] == sum) {
                    return true;
                }
                return recFindSumPair(numbers, sum, length, i, j + 1);
            } else {
                return recFindSumPair(numbers, sum, length, i + 1, i + 2);
            }
        }
        return false;
    }

    /* i for outer loop, j for inner loop, both going 0 to n-1 */
    static void recursion(int n, int i, int j) {
        if (i < n) {
            if (j < n) {
                // inner loop when j < n
                System.out.printf("(%d, %d)", i, j); // inner loop body
                recursion(n, i, j + 1); // increment inner counter only!
            } else { // when j has reached n...
                // outer loop, which restarts inner loop
                System.out.printf("\n");
                recursion(n, i + 1, i + 2); // increment outer counter, reset inner
                                            // since we're starting a new inner loop
            }
        }
    }

    public static void main(String[] args) {
        int sum = 2;
        int length = 100;

        // System.out.println("\nIterative\n");

        // for (int i = 0; i < 10; i++) {
        //     long startTime = System.nanoTime();
        //     findSumPair(generateNumbers(length), sum);
        //     long stopTime = System.nanoTime();
        //     System.out.println(
        //             "array lenght = " + length + ", T(n) = " + ((stopTime - startTime) / 1000) + " microsecond");
        //     length += 100;
        // }

        System.out.println("\nRecursive\n");
        length = 5;

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            recFindSumPair(generateNumbers(length), sum, length, 0, 1);
            long stopTime = System.nanoTime();
            System.out.println(
                    "array lenght = " + length + ", T(n) = " + ((stopTime - startTime) / 1000) + "." + (((stopTime - startTime) / 100)%10) +
                            " microsecond");
            length += 5;

            // try {
            //     Thread.sleep(100);
            // } catch (InterruptedException ie) {
            //     Thread.currentThread().interrupt();
            // }
        }
    }
}

/*
 * array lenght = 100, T(n) = 13 microsecond
 * array lenght = 200, T(n) = 19 microsecond
 * array lenght = 300, T(n) = 27 microsecond
 * array lenght = 400, T(n) = 34 microsecond
 * array lenght = 500, T(n) = 44 microsecond
 * array lenght = 600, T(n) = 51 microsecond
 * array lenght = 700, T(n) = 59 microsecond
 * array lenght = 800, T(n) = 70 microsecond
 * array lenght = 900, T(n) = 79 microsecond
 * array lenght = 1000, T(n) = 89 microsecond
 */