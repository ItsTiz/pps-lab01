package tdd;
import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack{

    private final List<Integer> stack;

    MinMaxStackImpl() {
        this.stack = new ArrayList<>();
    }

    private int lastElementIndex() throws IllegalStateException{
        if(isEmpty()) throw new IllegalStateException();
        return this.stack.size()-1;
    }

    @Override
    public void push(int value) {
        this.stack.add(value);
    }

    @Override
    public int pop() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException();
        return this.stack.remove(lastElementIndex());
    }

    @Override
    public int peek() {
        if(isEmpty()) throw new IllegalStateException();
        return this.stack.get(lastElementIndex());
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return 0;
    }
}
