package prj5;

import java.util.*;
import list.ListInterface;

// -------------------------------------------------------------------------
/**
 * the linked list class that holds and sorts the data. it will be doubly linked
 * with sentinel nodes
 * 
 * @author aanchalp
 * @version 12/6/24
 * @author jackw
 * @version Nov 20, 2024
 * @param <T>
 *            the type of data being held
 */
public class DoublyLinkedList<T>
    implements ListInterface<T>
{
    private static class Node<E>
    {
        private Node<E> next;
        private Node<E> previous;
        private E data;

        /**
         * Creates a new Node with the given entry
         *
         * @param entry
         *            the data to put inside the node
         */
        public Node(E entry)
        {
            this(entry, null, null);
        }


        public Node(E entry, Node<E> next, Node<E> prev)
        {
            this.next = next;
            this.data = entry;
            this.previous = prev;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData()
        {
            return data;
        }


        /**
         * sets new value for the data field
         * 
         * @param entry
         *            the new data object
         */
        public void setData(E entry)
        {
            data = entry;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> getNextNode()
        {
            return next;
        }


        /**
         * Sets the node after this node
         *
         * @param node
         *            the node after this one
         */
        public void setNextNode(Node<E> node)
        {
            next = node;
        }


        /**
         * return the previous node
         * 
         * @return the previous field
         */
        public Node<E> getPreviousNode()
        {
            return previous;
        }


        /**
         * sets new previous node
         * 
         * @param node
         *            the node that will be assigned to the previous spot
         */
        public void setPreviousNode(Node<E> node)
        {
            previous = node;
        }

    }

    private int size;
    private Node<T> head;
    private Node<T> rear;

    // ----------------------------------------------------------
    /**
     * Creates a new list object
     */
    public DoublyLinkedList()
    {
        head = new Node<T>(null);
        rear = new Node<T>(null);
        size = 0;
        head.setNextNode(rear);
        rear.setPreviousNode(head);
    }


    @Override
    /**
     * Checks if the method is empty
     * 
     * @return true or false if it is empty or not
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    @Override
    /**
     * Adds a new element to the list
     * 
     * @param newEntry
     *            T the new element being added
     */
    public void add(T newEntry)
    {
        add(size, newEntry);
    }


    @Override
    /**
     * Adds a new element to the list
     * 
     * @param index
     *            int the index of the new element being added
     * @param newEntry
     *            T the new element being added
     */
    public void add(int index, T newEntry)
    {
        if (index < 0 || size < index)
        {
            throw new IndexOutOfBoundsException();
        }
        if (newEntry == null)
        {
            throw new IllegalArgumentException("object is null");
        }

        Node<T> nodeAfter;
        if (index == size)
        {
            nodeAfter = rear;
        }
        else
        {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<T> addition = new Node<T>(newEntry);
        addition.setPreviousNode(nodeAfter.getPreviousNode());
        addition.setNextNode(nodeAfter);
        nodeAfter.getPreviousNode().setNextNode(addition);
        nodeAfter.setPreviousNode(addition);
        size++;

    }


    /**
     * Returns the node at the specified index
     * 
     * @param index
     *            int the index of the node at the specified index
     * @return currNode Node<T> the node at the specified index
     */
    private Node<T> getNodeAtIndex(int index)
    {
        Node<T> currNode = head.getNextNode();
        for (int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode;
    }


    @Override
    /**
     * Clears the list and resets all the field values
     */
    public void clear()
    {
        head = new Node<T>(null);
        rear = new Node<T>(null);
        size = 0;
        head.setNextNode(rear);
        rear.setPreviousNode(head);
    }


    @Override
    /**
     * Checks if the element is present in the list
     * 
     * @param entry
     *            T the element being checked if its present in the list
     * @return true or false if the element is present in the list
     */
    public boolean contains(T entry)
    {
        Node<T> currNode = head.getNextNode();
        while (!currNode.equals(rear))
        {
            if (currNode.getData().equals(entry))
            {
                return true;
            }
            currNode = currNode.getNextNode();
        }
        return false;
    }


    @Override
    /**
     * Returns the node at the given index
     * 
     * @param index
     *            int the index for which the data is getting retrieved
     * @return the node at the given index
     */
    public T getEntry(int index)
    {
        Node<T> currNode = head.getNextNode();
        for (int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getData();
    }


    @Override
    /**
     * Gets the size of the list
     * 
     * @return size int the size of the list
     */
    public int getLength()
    {
        return size;
    }


    @Override
    /**
     * Removes a specified element from the list
     * 
     * @param index
     *            int the index of the element that is being removed
     * @return the data of the node that was removed
     */
    public T remove(int index)
    {
        Node<T> currNode = head.getNextNode();
        for (int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        Node<T> prev = currNode.getPreviousNode();
        Node<T> next = currNode.getNextNode();
        prev.setNextNode(next);
        next.setPreviousNode(prev);
        currNode.setNextNode(null);
        currNode.setPreviousNode(null);
        size--;
        return currNode.getData();
    }


    @Override
    /**
     * Replaces a specified index with the entry given when the method is called
     * 
     * @param index
     *            int the index of the element being replaced
     * @param entry
     *            T the data that the previous entry is going to be changed to
     * @return data T the data that the element was replaced with
     */
    public T replace(int index, T entry)
    {
        Node<T> currNode = head.getNextNode();
        for (int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        T data = currNode.getData();
        currNode.setData(entry);
        return data;
    }


    @Override
    /**
     * Converts the array list is converted to a object array
     * 
     * @return array Object[] the array of objects
     */
    public Object[] toArray()
    {
        Object[] array = new Object[size];
        Node<T> currNode = head.getNextNode();
        for (int i = 0; i < size; i++)
        {
            array[i] = currNode.getData();
            currNode = currNode.getNextNode();
        }
        return array;
    }
}
