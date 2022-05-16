package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import BinarySearchTree.BinarySearchTree;
import BinarySearchTree.BinaryTree;

class Main {
    /**
     * @param array
     * @param sampleNum
     */
    public static void Q1(BinarySearchTree<Integer> binarySearchTree, BinaryTree<Integer> binaryTree,
            ArrayList<Integer> array) {
        if (binaryTree == null || array.isEmpty())
            return;

        binarySearchTree.add(array.remove(0));
        Q1(binarySearchTree, binaryTree.getRightSubtree(), array);
        Q1(binarySearchTree, binaryTree.getLeftSubtree(), array);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");

        /* ----------------------------------- Q1 ----------------------------------- */
        ArrayList<Integer> array = new ArrayList<>(List.of(1,5,3,7,8));
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.setRootData(0);
        binaryTree.setLeft(0);
        binaryTree.setRight(0);
        binaryTree.getLeftSubtree().setLeft(0);
        binaryTree.getLeftSubtree().setRight(0);

        System.out.println("Array = " + array.toString());
        System.out.printf("Initial BinaryTree\n%s\n", binaryTree.toString());
        
        Q1(binarySearchTree, binaryTree, array);
        binarySearchTree.add(5);
        System.out.printf("BinarySearchTree\n%s\n", binarySearchTree.toString());
    }
}
