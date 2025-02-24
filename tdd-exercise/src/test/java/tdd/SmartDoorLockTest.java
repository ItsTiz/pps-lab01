package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final String TEST_PIN = "7529";

    private SmartDoorLock doorLock;

    @BeforeEach
    public void init(){
        doorLock = new SimpleSmartDoorLock();
    }

    @Test
    public void testLock() {
        doorLock.setPin(TEST_PIN);
        doorLock.lock();
        assertTrue(doorLock.isLocked());
    }

    @Test
    public void testLockWithoutPin() {
        assertThrows(IllegalStateException.class, () -> doorLock.lock());
    }


}
