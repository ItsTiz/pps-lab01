package tdd;
import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> queue;

    private int head;
    private int tail;

    private final int capacity;

    CircularQueueImpl(int capacity){
        queue = new ArrayList<>();
        head = tail = 0;
        this.capacity = capacity;
    }

    @Override
    public void enqueue(int value) {
        if(isFull()){
            queue.set(tail, value);
            head = (head + 1) % capacity;
        }else {
            queue.add(value);
        }
        tail = (tail + 1) % capacity;

    }

    @Override
    public void dequeue() throws IllegalStateException{
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        queue.remove(head);
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        return queue.get(head);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.size() == capacity;
    }

    @Override
    public int size() {
        return queue.size();
    }
}
