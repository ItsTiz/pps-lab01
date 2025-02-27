package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final String TEST_PIN = "7529";
    private static final String WRONG_PIN = "2149";
    private static final String ILLEGAL_PIN = "14975";

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

    @Test
    public void testIllegalPin(){
        assertThrows(
                IllegalArgumentException.class,
                () -> doorLock.setPin(ILLEGAL_PIN));
    }

    @Test
    public void testUnlockWithCorrectPin(){
        doorLock.setPin(TEST_PIN);
        doorLock.lock();
        doorLock.unlock(TEST_PIN);
        assertFalse(doorLock.isLocked());
    }

    @Test
    public void testUnlockWithWrongPin(){
        doorLock.setPin(TEST_PIN);
        doorLock.lock();
        doorLock.unlock(WRONG_PIN);
        assertTrue(doorLock.isLocked());
    }

    @Test
    public void testBlockedAfterWrongPinMultipleTimes(){
        doorLock.setPin(TEST_PIN);
        doorLock.lock();
        while(doorLock.getFailedAttempts() < doorLock.getMaxAttempts()) {
            doorLock.unlock(WRONG_PIN);
        }
        assertTrue(doorLock.isBlocked());
    }

    //@Test


}
