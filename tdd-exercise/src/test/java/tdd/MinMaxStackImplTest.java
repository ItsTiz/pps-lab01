package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int SAMPLE_VALUE = 5;
    private MinMaxStack stack;

    private static final List<Integer> SAMPLE_LIST = List.of(1,2,3,4,5);

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

        SAMPLE_LIST.forEach((e) -> stack.push(e));

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
        SAMPLE_LIST.forEach((e) -> stack.push(e));
        assertEquals(Collections.min(SAMPLE_LIST),stack.getMin());
    }

    @Test
    public void testMaxValue() {
        SAMPLE_LIST.forEach((e) -> stack.push(e));
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


}