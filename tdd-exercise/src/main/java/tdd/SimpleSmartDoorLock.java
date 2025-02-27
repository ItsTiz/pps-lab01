package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock{

    private String pin;

    private LockStates lockState;

    private static final int PIN_LENGTH = 4;

    private enum LockStates {
        LOCKED,
        UNLOCKED,
        BLOCKED
    }

    SimpleSmartDoorLock(){
        this.pin = "";
        this.lockState = LockStates.UNLOCKED;
    }

    @Override
    public void setPin(String pin) throws IllegalStateException, IllegalArgumentException {
        if(lockState != LockStates.UNLOCKED) throw new IllegalStateException();
        if(pin.length() != PIN_LENGTH) throw new IllegalArgumentException();
        this.pin = pin;
    }

    @Override
    public void unlock(String pin) {

    }

    @Override
    public void lock() throws IllegalStateException {
        if(this.pin.isEmpty()) throw new IllegalStateException();
        this.lockState = LockStates.LOCKED;
    }

    @Override
    public boolean isLocked() {
        return this.lockState == LockStates.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
