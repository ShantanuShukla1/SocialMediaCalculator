package prj5;

import java.util.Arrays;

// -------------------------------------------------------------------------
/**
 * This is the test class for the DoublyLinkedList class
 * 
 * @author aanchalp
 * @version Nov 20, 2024
 */
public class DoublyLinkedListTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private DoublyLinkedList<String> list;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Initializes the DoublyLinkedList field for testing
     */
    public void setUp()
    {
        list = new DoublyLinkedList<String>();
    }


    /**
     * Tests if the list is empty after calling isEmpty()
     */
    public void testIsEmpty()
    {
        assertEquals(list.isEmpty(), true);
        String first = "first";
        list.add(first);
        assertFalse(list.isEmpty());
    }


    /**
     * Tests if the elements have been accurately added to the list
     */
    public void testAdd()
    {

        assertEquals(list.getLength(), 0);
        String first = "first";
        list.add(first);
        assertEquals(list.getLength(), 1);

        String nullValue = null;
        Exception thrown = null;
        try
        {
            list.add(999, first);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        list.clear();
        list.add("b");
        list.add(0, "a");
        assertEquals(list.getEntry(0), "a");
        assertEquals(list.getLength(), 2);
        list.add(2, "d");
        assertEquals(list.getEntry(2), "d");
        list.add(2, "c");
        assertEquals(list.getEntry(2), "c");

    }


    /**
     * Tests add exception cases for IllegalArgumentException and
     * IndexOutOfBoundsException
     */
    public void testAddException()
    {
        assertEquals(list.getLength(), 0);
        String first = "first";
        list.add(first);
        assertEquals(list.getLength(), 1);

        String nullValue = null;
        Exception thrown = null;
        try
        {
            list.add(1, nullValue);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        try
        {
            list.add(-1, first);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests if the list gets cleared and reset after calling the isClear()
     * method
     */
    public void testClear()
    {
        String first = "first";
        list.add(first);
        assertEquals(list.getLength(), 1);
        list.clear();
        assertEquals(list.getLength(), 0);
    }


    /**
     * Tests if the list contains a particular element
     */
    public void testContains()
    {
        assertEquals(list.contains("something"), false);
        String first = "first";
        list.add(first);
        assertEquals(list.contains(first), true);
        String second = "second";
        list.add(second);
        assertEquals(list.contains(second), true);
    }


    /**
     * Tests if the list retrieves the correct elements when given the index and
     * outputs the data
     */
    public void testGetEntry()
    {
        assertEquals(list.isEmpty(), true);
        String first = "first";
        list.add(first);
        assertEquals(list.getEntry(0), "first");
        String random = "random";
        list.add(1, random);
        assertEquals(list.getEntry(1), "random");
    }


    /**
     * Tests if it gets the correct length of the list when adding an element
     */
    public void testGetLength()
    {
        assertEquals(list.getLength(), 0);
        String first = "first";
        list.add(first);
        assertEquals(list.getLength(), 1);
    }


    /**
     * Tests if the element has been removed and the size decreases after
     * calling the remove() method
     */
    public void testRemove()
    {
        String first = "first";
        list.add(first);
        assertEquals(list.getLength(), 1);
        list.remove(0);
        assertEquals(list.getLength(), 0);
        String second = "second";
        list.add(second);
        String third = "third";
        list.add(third);
        list.remove(1);
        assertEquals(list.getLength(), 1);
    }


    /**
     * Tests if it accurately replaces the element and checks using the index
     */
    public void testReplace()
    {
        String first = "first";
        list.add(first);
        String second = "second";
        list.add(second);
        assertEquals(list.getEntry(1), "second");
        list.replace(1, "third");
        assertEquals(list.getEntry(1), "third");
    }


    /**
     * Tests if the array list is converted to a object array correctly
     */
    public void testToArray()
    {
        String first = "first";
        list.add(first);
        String second = "second";
        list.add(second);
        Object[] array = new Object[] { "first", "second" };
        assertTrue(Arrays.equals(list.toArray(), array));
    }
}
