package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock{

    private String pin;

    private LockStates lockState;

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
    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {

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
