package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final String TEST_PIN = "7529";
    private static final String WRONG_PIN = "2149";
    private static final String ILLEGAL_PIN = "1#49c?75";

    private SmartDoorLock doorLock;

    private void setPinAndLock(SmartDoorLock doorLock){
        doorLock.setPin(SmartDoorLockTest.TEST_PIN);
        doorLock.lock();
    }


    private void blockLock(SmartDoorLock doorLock){
        setPinAndLock(doorLock);
        while(doorLock.getFailedAttempts() < doorLock.getMaxAttempts()) {
            doorLock.unlock(WRONG_PIN);
        }
    }

    private void tryWrongPinOneTime(SmartDoorLock doorLock){
        setPinAndLock(doorLock);
        doorLock.unlock(WRONG_PIN);
    }

    @BeforeEach
    public void init(){
        doorLock = new SimpleSmartDoorLock();
    }

    @Test
    public void testLock() {
        setPinAndLock(doorLock);
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
        setPinAndLock(doorLock);
        doorLock.unlock(TEST_PIN);
        assertFalse(doorLock.isLocked());
    }

    @Test
    public void testUnlockWithOpenLock(){
        doorLock.setPin(TEST_PIN);
        assertThrows(IllegalStateException.class,
                () -> doorLock.unlock(TEST_PIN));
    }

    @Test
    public void testLockAlreadyLocked(){
        setPinAndLock(doorLock);
        assertThrows(IllegalStateException.class,
                () -> doorLock.lock());
    }

    @Test
    public void testUnlockWithWrongPin(){
        tryWrongPinOneTime(doorLock);
        assertTrue(doorLock.isLocked());
    }

    @Test
    public void testUnlockOneFailedAttempt(){
        tryWrongPinOneTime(doorLock);
        doorLock.unlock(TEST_PIN);
        assertFalse(doorLock.isLocked());
    }

    @Test
    public void testBlocked(){
        blockLock(doorLock);
        assertTrue(doorLock.isBlocked());
    }

    @Test
    public void testLockAfterBlocked(){
        blockLock(doorLock);
        assertThrows(IllegalStateException.class, () -> doorLock.lock());
    }

    @Test
    public void testUnlockAfterBlocked(){
        blockLock(doorLock);
        assertThrows(IllegalStateException.class, () -> doorLock.unlock(TEST_PIN));
    }

    @Test
    public void testReset(){
        tryWrongPinOneTime(doorLock);
        doorLock.reset();
        assertAll(
                () -> assertThrows(IllegalStateException.class, () -> doorLock.lock()),
                () -> assertFalse(doorLock.isLocked()),
                () -> assertEquals(0, doorLock.getFailedAttempts())
        );

    }


}
