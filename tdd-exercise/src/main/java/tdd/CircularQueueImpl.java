package tdd;
import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> queue;

    private final int capacity;

    CircularQueueImpl(int capacity){
        queue = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public void enqueue(int value) {
        queue.add(value);
    }

    @Override
    public int dequeue() throws IllegalStateException{
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        return queue.remove(0);
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.size() == capacity;
    }
}
