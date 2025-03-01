package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Adds an integer in the queue.
     *
     * @param value The integer to be added.
     */
    void enqueue(int value);

    /**
     * Removes an integer from the queue.
     *
     * @return The element to be removed.
     * @throws IllegalStateException if the queue is empty.
     */
    int dequeue();

    /**
     * Retrieves, but does not remove, the first element of the queue.
     *
     * @return The first element of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int peek();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise.
     */
    boolean isFull();
}