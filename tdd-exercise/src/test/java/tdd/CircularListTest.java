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
    private static final List<Integer> SECOND_LIST = List.of(9,8,7,3,5,1);

    private void fillQueue(List<Integer> list) {
        if(list == null ) throw new IllegalArgumentException();
        for(Integer element: list){
            cQueue.enqueue(element);
        }
    }

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
        fillQueue(TEST_LIST);
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
        fillQueue(TEST_LIST);

        assertTrue(cQueue.isFull());

    }

    @Test
    public void testEnqueueIfFull(){
        fillQueue(TEST_LIST);

        cQueue.enqueue(SINGLE_VALUE);
        assertAll(
                () -> assertEquals(TEST_LIST.get(1), cQueue.peek())
        );

    }

    @Test
    public void testEnqueueDequeueUntilEmpty() {
        fillQueue(TEST_LIST);
        while (!cQueue.isEmpty()) {
            cQueue.dequeue();
        }
        assertTrue(cQueue.isEmpty());
    }

    @Test
    public void testRotateWholeQueue(){
        fillQueue(TEST_LIST);
        fillQueue(SECOND_LIST);
        assertEquals(SECOND_LIST.get(0), cQueue.peek());

    }

    @Test
    public void testSizeAfterFullRotation(){
        fillQueue(TEST_LIST);
        fillQueue(SECOND_LIST);
        assertEquals(CAPACITY, cQueue.size());

    }
}
