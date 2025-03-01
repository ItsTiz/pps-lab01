package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackTest {
    private static final List<Integer> SAMPLE_LIST = List.of(1,2,3,4,5);

    public static final int SAMPLE_VALUE = 5;

    private MinMaxStack stack;


    private void pushAllOntoStack(List<Integer> list) {
        if(stack == null) {
            throw new IllegalArgumentException();
        }
        list.forEach(this.stack::push);
    }

    @BeforeEach
    public void init(){
        stack = new MinMaxStackImpl();
    }

    @Test
    public void testSimplePushAndPop() {
        stack.push(SAMPLE_VALUE);
        assertEquals(SAMPLE_VALUE,stack.pop());
    }

    @Test
    public void testPopFromEmptyStack() {
        assertThrows(
                IllegalStateException.class,
                () -> stack.pop()
        );
    }

    @Test
    public void testLifoStructure(){
        List<Integer> poppedValues = new ArrayList<>();
        List<Integer> reversedValues = new ArrayList<>(SAMPLE_LIST);
        Collections.reverse(reversedValues);

        pushAllOntoStack(SAMPLE_LIST);

        while(!stack.isEmpty()){
            poppedValues.add(stack.pop());
        }

        assertEquals(reversedValues, poppedValues);
    }

    @Test
    public void testPeek() {
        stack.push(SAMPLE_VALUE);
        assertEquals(SAMPLE_VALUE,stack.peek());
    }

    @Test
    public void testPeekFromEmptyStack() {
        assertThrows(
                IllegalStateException.class,
                () -> stack.peek()
        );
    }

    @Test
    public void testMinValue() {
        pushAllOntoStack(SAMPLE_LIST);
        assertEquals(Collections.min(SAMPLE_LIST),stack.getMin());
    }

    @Test
    public void testMaxValue() {
        pushAllOntoStack(SAMPLE_LIST);
        assertEquals(Collections.max(SAMPLE_LIST),stack.getMax());
    }

    @Test
    public void testMinValueFromEmptyStack() {
        assertThrows(
                IllegalStateException.class,
                () -> stack.getMin());
    }

    @Test
    public void testMaxValueFromEmptyStack() {
        assertThrows(
                IllegalStateException.class,
                () -> stack.getMax());
    }

    @Test
    public void testMinValueAfterMinValuePopped(){
        List<Integer> sampleListCopy = new ArrayList<>(SAMPLE_LIST);
        Collections.reverse(sampleListCopy);
        pushAllOntoStack(sampleListCopy);
        sampleListCopy.remove(Collections.min(sampleListCopy));

        stack.pop();
        assertEquals(
                Collections.min(sampleListCopy),
                stack.getMin()
        );

    }

    @Test
    public void testMaxValueAfterMaxValuePopped(){
        pushAllOntoStack(SAMPLE_LIST);

        List<Integer> sampleListCopy = new ArrayList<>(SAMPLE_LIST);
        sampleListCopy.remove(Collections.max(sampleListCopy));

        stack.pop();
        assertEquals(
                Collections.max(sampleListCopy),
                stack.getMax());

    }


}