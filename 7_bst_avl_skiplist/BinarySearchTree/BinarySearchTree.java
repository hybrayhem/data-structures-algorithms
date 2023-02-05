package BinarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryTree<E>
        implements SearchTree<E> {

    // parent = n;
    // left_child = (2*n)+1;
    // right_child = (2*n)+2;

    // Data Fields
    // protected boolean addReturn;
    // protected E deleteReturn;
    private ArrayList<E> elements = new ArrayList<>(50);

    public BinarySearchTree() {
        System.out.printf("%n/* ---------------------------- BinarySearchTree ---------------------------- */%n%n");
    }

    // Methods
    /**
     * Starter method add
     * pre: The object to be inserted must implement the Comparable interface
     * 
     * @param item The item being inserted
     * @return true if the object is inserted, false if the object already exists in
     *         the tree
     */
    public boolean add(E item) {
        int n = 0;
        while (n < elements.size()) {
            int compare = item.compareTo(elements.get(n));
            if (compare == 0) {
                break;
            }

            if ((2 * n) + 2 < elements.size()) {
                int compareLeft = item.compareTo(elements.get((2 * n) + 1));
                int compareRight = item.compareTo(elements.get((2 * n) + 2));
                if (compareLeft < 0 && compareRight > 0) {
                    elements.add((2 * n) + 1, item);
                } else if (compareLeft > 0 && compareRight < 0) {
                    elements.add((2 * n) + 2, item);
                }
            }

            if (compare < 0)
                n = (2 * n) + 1;
            else
                n = (2 * n) + 2;

        }

        return false;
    }

    
    /** 
     * @param target
     * @return boolean
     */
    public boolean contains(E target) {
        return elements.contains(target);
    }

    /**
     * Starter methmod remove
     * post: The object is not in the tree
     * 
     * @param target The object to be deleted
     * @return The object deleted from the tree or null if the object was not in the
     *         tree
     * @throws ClassCast Exception if target does not implement Comparable
     */
    public boolean remove(E target) {
        return elements.remove(target);
    }
    

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
      return this.elements.toString();
    }


}