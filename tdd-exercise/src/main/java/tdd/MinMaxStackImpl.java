package tdd;
import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack{

    private final List<Integer> stack;

    private Integer minValue = 0;
    private Integer maxValue = 0;

    MinMaxStackImpl() {
        this.stack = new ArrayList<>();
    }

    private int lastElementIndex() throws IllegalStateException{
        if(isEmpty()) throw new IllegalStateException();
        return this.stack.size()-1;
    }

    @Override
    public void push(int value) {
        if(isEmpty()){ this.minValue = this.maxValue = value;}
        if(value < minValue){ this.minValue = value;}
        if(value > maxValue){ this.maxValue = value;}
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
    public int getMin() throws IllegalStateException{
        if(!isEmpty())
            return this.minValue;
        throw new IllegalStateException();
    }

    @Override
    public int getMax() {
        if(!isEmpty())
            return this.maxValue;
        throw new IllegalStateException();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
