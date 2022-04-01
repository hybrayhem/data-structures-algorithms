package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import question.Q1;
import question.Q2;
import question.Q3;
import question.Q4;
import question.Q5;

class Main {

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

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");

        /* ----------------------------------- Q1 ----------------------------------- */
        Q1 question1 = new Q1();
        String q1String = "Recursion occurs when a thing is defined in terms of itself or of its type";
        String q1Key = "of";
        int q1Occurence = 2;
        System.out.printf("Q1: search %dth occurence's index of '%s' in '%s' = %d %n%n", q1Occurence, q1Key, q1String,
                question1.rOccurenceSearch(q1String, q1Key, q1Occurence, 0));
        q1Occurence = 5;
        System.out.printf("Q1: search %dth occurence's index of '%s' in '%s' = %d %n%n%n", q1Occurence, q1Key, q1String,
                question1.rOccurenceSearch(q1String, q1Key, q1Occurence, 0));

        /* ----------------------------------- Q2 ----------------------------------- */
        Q2 question2 = new Q2();
        List<Integer> q2List = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 7, 8, 8, 8, 9);

        int q2Start = 2;
        int q2End = 4;
        try {
            System.out.printf("Q2: number of items between %d-%d = %d %n%n%n", q2Start, q2End,
                    question2.itemsBetween(q2List, q2Start, q2End, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: can't search items in range.");
        }

        q2Start = 1;
        q2End = 4;
        try {
            System.out.printf("Q2: number of items between %d-%d = %d %n%n%n", q2Start, q2End,
                    question2.itemsBetween(q2List, q2Start, q2End, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: can't search items in range.");
        }
        /* ----------------------------------- Q3 ----------------------------------- */
        Q3 question3 = new Q3();
        int q3Sum = 13;
        List<Integer> q3List = new ArrayList<Integer>(Arrays.asList(4, 6, 8, 4, 1, 3, 6, 4, 9));
        List<Integer> q3Result = new ArrayList<Integer>(Arrays.asList());

        // UnsupportedOperationException
        try {
            List<Integer> q3SubList = question3.contiguousSubarray(q3List, q3Sum, q3Result);
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: can't extract subarray.");
        }
        System.out.println("Q3: Contiguous sub array = " + q3SubList.toString());
        /* ----------------------------------- Q4 ----------------------------------- */
        /* ----------------------------------- Q5 ----------------------------------- */
    }
}
