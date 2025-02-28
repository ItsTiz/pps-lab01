package tdd;
import java.util.Stack;
import java.util.function.BiPredicate;

public class MinMaxStackImpl implements MinMaxStack{

    private final Stack<Integer> stack;

    private final Stack<Integer> minStack;
    private final Stack<Integer> maxStack;

    MinMaxStackImpl() {

        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.maxStack = new Stack<>();

    }

    private void pushOntoStack(Stack<Integer> stack, int value, BiPredicate<Integer, Integer> condition) {
        if(stack == null) {
            throw new IllegalArgumentException();
        }
        if (stack.isEmpty() || condition.test(value, stack.peek())) {
            stack.push(value);
        }
    }

    public void push(int value) {
        stack.push(value);
        pushOntoStack(minStack, value, (v, top) -> v < top);
        pushOntoStack(maxStack, value, (v, top) -> v > top);
    }


    @Override
    public int pop() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException();
        int poppedValue = this.stack.pop();
        if(poppedValue == minStack.peek()) {
            minStack.pop();
        }
        if(poppedValue == maxStack.peek()) {
            maxStack.pop();
        }
        return poppedValue;
    }

    @Override
    public int peek() {
        if(isEmpty()) throw new IllegalStateException();
        return this.stack.peek();
    }

    @Override
    public int getMin() throws IllegalStateException{
        if(!isEmpty())
            return this.minStack.peek();
        throw new IllegalStateException();
    }

    @Override
    public int getMax() {
        if(!isEmpty())
            return this.maxStack.peek();
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
