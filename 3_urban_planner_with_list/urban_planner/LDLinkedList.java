package urban_planner;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LDLinkedList<E> extends AbstractList<E> implements List<E> {
    public class Node {
        private E item;
        private Node next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }

        public E getData() {
            return item;
        }

        public void setData(E item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    /** the nodes containing removed elements */
    private Node lazyHead = null;
    private int size = 0;

    /**
     * Constructs an empty list.
     */
    public LDLinkedList() {
    }

    
    /** 
     * @param index
     * @return E
     */
    @Override
    public E get(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.getNext();
        return x.getData();
    }

    
    /** 
     * @return int
     */
    @Override
    public int size() {
        int res = 0;

        Node x = head;
        while (x != null) {
            x = x.next;
            res++;
        }
        return res;
    }

    
    /** 
     * @param e
     * @return boolean
     */
    @Override
    public boolean add(Object e) {
        Node tempNode = new Node((E) e);
        // if (sizeLazy(lazyHead) > 0) {
        //     tempNode = lazyHead;
        //     popLazy(lazyHead);   
        // }

        if (this.head == null) {
            head = tempNode;
        } else {
            Node x = head;
            while (x.getNext() != null) // go to end
                x = x.getNext();

            x.setNext(tempNode); // add to end
        }
        size++;
        return false;
    }

    
    /** 
     * @param e
     */
    public void addLazy(Node e) {
        Node tempNode = e;

        if (this.lazyHead == null) {
            lazyHead = tempNode;
        } else {
            Node x = lazyHead;
            while (x.getNext() != null) // go to end
                x = x.getNext();

            x.setNext(tempNode); // add to end
        }
    }

    
    /** 
     * @param e
     */
    public void popLazy(Node e) {
        Node tempHead = e;
        if (tempHead == null) {
            return;
        }
        tempHead = tempHead.next;
    }

    
    /** 
     * @param e
     * @return int
     */
    public int sizeLazy(Node e) {
        int res = 0;

        Node x = e;
        while (x != null) {
            x = x.next;
            res++;
        }
        return res;
    }

    
    /** 
     * @param index
     * @return E
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size)
            return null;

        Node x = head;
        if (index == 0) {
            head = head.getNext();
            // x.setNext(null);
            // addLazy(x);
        } else {
            for (int i = 0; i < index - 1; i++) {
                x = x.getNext();
            }
            Node atIndex = x.getNext();
            Node next = x.getNext().getNext();

            // atIndex.setNext(null);
            // addLazy(atIndex);

            x.next = next; // remove deleted node from list
        }
        size--;
        return null;
    }

    
    /** 
     * @return boolean
     */
    /* -------------------------------------------------------------------------- */
    /* not used methods, will be implemented later */
    /* -------------------------------------------------------------------------- */
    @Override
    public boolean isEmpty() {
        // TODO not used in Street so not implemented
        return false;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean contains(Object o) {
        // TODO not used in Street so not implemented
        return false;
    }

    
    /** 
     * @return Iterator
     */
    @Override
    public Iterator iterator() {
        // TODO not used in Street so not implemented
        return null;
    }

    
    /** 
     * @return Object[]
     */
    @Override
    public Object[] toArray() {
        // TODO not used in Street so not implemented
        return null;
    }

    
    /** 
     * @param a
     * @return Object[]
     */
    @Override
    public Object[] toArray(Object[] a) {
        // TODO not used in Street so not implemented
        return null;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean remove(Object o) {
        // TODO not used in Street so not implemented
        return false;
    }

    
    /** 
     * @param c
     * @return boolean
     */
    @Override
    public boolean containsAll(Collection c) {
        // TODO not used in Street so not implemented
        return false;
    }

    
    /** 
     * @param c
     * @return boolean
     */
    @Override
    public boolean addAll(Collection c) {
        // TODO not used in Street so not implemented
        return false;
    }

    
    /** 
     * @param index
     * @param c
     * @return boolean
     */
    @Override
    public boolean addAll(int index, Collection c) {
        // TODO not used in Street so not implemented
        return false;
    }

    
    /** 
     * @param c
     * @return boolean
     */
    @Override
    public boolean removeAll(Collection c) {
        // TODO not used in Street so not implemented
        return false;
    }

    
    /** 
     * @param c
     * @return boolean
     */
    @Override
    public boolean retainAll(Collection c) {
        // TODO not used in Street so not implemented
        return false;
    }

    @Override
    public void clear() {
        // TODO not used in Street so not implemented

    }

    
    /** 
     * @param index
     * @param element
     * @return Object
     */
    @Override
    public Object set(int index, Object element) {
        // TODO not used in Street so not implemented
        return null;
    }

    
    /** 
     * @param index
     * @param element
     */
    @Override
    public void add(int index, Object element) {
        // TODO not used in Street so not implemented

    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int indexOf(Object o) {
        // TODO not used in Street so not implemented
        return 0;
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int lastIndexOf(Object o) {
        // TODO not used in Street so not implemented
        return 0;
    }

    
    /** 
     * @return ListIterator
     */
    @Override
    public ListIterator listIterator() {
        // TODO not used in Street so not implemented
        return null;
    }

    
    /** 
     * @param index
     * @return ListIterator
     */
    @Override
    public ListIterator listIterator(int index) {
        // TODO not used in Street so not implemented
        return null;
    }

    
    /** 
     * @param fromIndex
     * @param toIndex
     * @return List
     */
    @Override
    public List subList(int fromIndex, int toIndex) {
        // TODO not used in Street so not implemented
        return null;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // TODO not used in Street so not implemented
        return super.equals(o);
    }

}
