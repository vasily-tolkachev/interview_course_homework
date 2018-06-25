package task2.has_loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static task2.has_loop.ListUtility.hasLoop;

class ListUtilityTest {
    @Test
    void hasLoopTest() {
        Node nodeForLoop = new Node();
        Node firstNode = new Node();
        firstNode.setNext(new Node())
                .setNext(new Node())
                .setNext(new Node())
                .setNext(nodeForLoop);
        assertFalse(hasLoop(firstNode));
        nodeForLoop.setNext(new Node())
                .setNext(new Node())
                .setNext(new Node())
                .setNext(nodeForLoop);
        assertTrue(hasLoop(firstNode));
    }

}