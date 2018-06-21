package linked_list;

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
}