package task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListStackTest {

    static ILinkedListStack<Integer> stack;

    @BeforeEach
    void beforeEach() {
        stack = new LinkedListStack<>();
        for (int i = 0; i < 10 ; i++) {
            stack.push(i);
        }
    }

    @Test
    @DisplayName("Stack methods test")
    public void stackTest() {
        assertFalse(stack.isEmpty());
        assertEquals(10, stack.size());
        for (int i = 9; i >= 0; i--) {
            assertEquals(new Integer(i), stack.pop());
        }
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
}
