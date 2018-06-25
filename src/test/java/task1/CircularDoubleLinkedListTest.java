package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircularDoubleLinkedListTest {

    static ICircularDoubleLinkedList<Integer> linkedList;

    @BeforeEach
    void beforeEach() {
        linkedList = new CircularDoubleLinkedList<>();
    }

    @Test
    @DisplayName("Test adding element")
    public void addTest() {
        assertEquals(true, linkedList.add(10));
        assertEquals(true, linkedList.add(20));
        assertEquals(2, linkedList.length());
        assertEquals(Integer.valueOf(10), linkedList.getAt(0));
        assertEquals(Integer.valueOf(20), linkedList.getAt(1));
    }

    @Test
    @DisplayName("Test getting length")
    public void lengthTest() {
        assertEquals(linkedList.length(), 0);
    }

    @Test
    @DisplayName("Test getting element by index")
    public void getAtTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAt(0));
        linkedList.add(10);
        linkedList.add(20);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAt(-1));
        assertEquals(Integer.valueOf(10), linkedList.getAt(0));
        assertEquals(Integer.valueOf(20), linkedList.getAt(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAt(3));
    }

    @Test
    @DisplayName("Test for head and tail methods")
    void testHeadTailMethods() {
        linkedList.add(10);
        linkedList.add(30);
        linkedList.add(2);
        assertEquals(linkedList.head(), new Integer(10));
        assertEquals(linkedList.tail(), new Integer(2));
    }

    @Test
    @DisplayName("Test for delete method")
    void testDeleteMethod() {
        linkedList.add(10);
        linkedList.add(20);
        assertEquals(true, linkedList.delete(0));
        assertEquals(1, linkedList.length());
        assertEquals(Integer.valueOf(20), linkedList.getAt(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAt(1));

        assertEquals(true, linkedList.delete(0));
        assertEquals(0, linkedList.length());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAt(0));

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.delete(0));

        linkedList.add(10);
        assertEquals(Integer.valueOf(10), linkedList.getAt(0));
        assertEquals(true, linkedList.delete(0));
        assertEquals(0, linkedList.length());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAt(0));

    }
}