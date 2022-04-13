package question;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import question.BinaryHeap;
import question.BinarySearchTree;

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

        /* ------------------------------- BinaryTree ------------------------------- */
        BinaryTree<String> test = new BinaryTree("Root",
                new BinaryTree("Left",
                        null,
                        null),
                new BinaryTree("Right",
                        null,
                        null));

        System.out.println(test.toString()); // print out initial tree

        // Write out the initial tree to a file
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Binary Tree Test"));
            out.writeObject(test);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        // Read the file back in
        BinaryTree<String> redux = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Binary Tree Test"));
            redux = (BinaryTree<String>) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        System.out.println(redux.toString());// prove that the file was read back in correctly

        /* ------------------------------- BinaryHeap ------------------------------- */

        /* ---------------------------- BinarySearchTree ---------------------------- */
        BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
		final int MAX_INT = 500;
		final int START_SIZE = 10;
		
		//create a random number generator.
		Random random = new Random();
		for (int i = 0; i < START_SIZE; i++) {
			int anInteger = random.nextInt(MAX_INT);
			testTree.add(anInteger);
		}
		
		//Add to beginning and end of list.
		testTree.add(-1);
		testTree.add(MAX_INT + 1);
        System.out.println(testTree.toString());
    }
}
