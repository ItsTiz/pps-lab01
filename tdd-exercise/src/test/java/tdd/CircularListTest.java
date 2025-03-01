package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularQueue cQueue;

    private static final int SINGLE_VALUE = 5;
    private static final int CAPACITY = 6;
    private static final List<Integer> TEST_LIST = List.of(4,7,2,0,5,3);

    @BeforeEach
    public void init(){
        cQueue = new CircularQueueImpl(CAPACITY);
    }

    @Test
    public void testEnqueue() {
        cQueue.enqueue(SINGLE_VALUE);
        assertEquals(SINGLE_VALUE, cQueue.peek());
    }

    @Test
    public void testDequeue() {
        for(Integer element: TEST_LIST){
            cQueue.enqueue(element);
        }
        cQueue.dequeue();
        assertEquals(TEST_LIST.get(1), cQueue.peek());
    }

    @Test
    public void testDequeueFromEmptyQueue() {
        assertThrows(
                IllegalStateException.class,
                () -> cQueue.dequeue()
        );
    }

    @Test
    public void testPeekFromEmptyQueue() {
        assertThrows(
                IllegalStateException.class,
                () -> cQueue.peek()
        );
    }

    @Test
    public void testIsFull(){
        for(Integer element: TEST_LIST){
            cQueue.enqueue(element);
        }

        assertTrue(cQueue.isFull());

    }
}
