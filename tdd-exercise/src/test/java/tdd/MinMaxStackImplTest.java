package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStack stack;

    @BeforeEach
    public void init(){
        stack = new MinMaxStackImpl();
    }

    @Test
    public void testSimplePushAndPop() {
        stack.push(5);
        assertEquals(5,stack.pop());
    }

    @Test
    public void testPopFromEmptyStack() {
        assertThrows(
                IllegalStateException.class,
                () -> stack.pop()
        );
    }

    @Test
    public void testPeek() {
        stack.push(5);
        assertEquals(5,stack.peek());
    }

    @Test
    public void testPeekFromEmptyStack() {
        assertThrows(
                IllegalStateException.class,
                () -> stack.peek()
        );
    }
}