package task2.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {
    static IQueue<Integer> queue;

    @BeforeEach
    void beforeEach() {
        queue = new LinkedListQueue<>();
        for (int i = 0; i < 10 ; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    public void linkedListQueueTest() {
        assertFalse(queue.isEmpty());
        assertEquals(10, queue.size());
        for (int i = 0; i < 10 ; i++) {
            assertEquals(new Integer(i), queue.dequeue());
        }
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertThrows(EmptyStackException.class, queue::dequeue);
    }
}