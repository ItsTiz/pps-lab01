package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock{

    private String pin;

    private LockStates lockState;

    private int currentFailedAttempts;

    private static final int PIN_LENGTH = 4;

    private static final String PIN_PATTERN = "[0-9]{"+PIN_LENGTH+"}";

    private static final int MAX_ATTEMPTS = 3;

    private enum LockStates {
        LOCKED,
        UNLOCKED,
        BLOCKED
    }

    SimpleSmartDoorLock(){
       reset();
    }

    @Override
    public void setPin(String pin) throws IllegalStateException, IllegalArgumentException {
        if(lockState != LockStates.UNLOCKED){ throw new IllegalStateException();}
        if(!pin.matches(PIN_PATTERN)){ throw new IllegalArgumentException();}
        this.pin = pin;
    }

    @Override
    public void unlock(String pin) throws IllegalStateException {
        if(isBlocked()) throw new IllegalStateException();
        if(this.pin.equals(pin)){ this.lockState = LockStates.UNLOCKED;}
        else { this.currentFailedAttempts++;}
        if(this.currentFailedAttempts >= MAX_ATTEMPTS && this.lockState != LockStates.BLOCKED) {
            this.lockState = LockStates.BLOCKED;
        }
    }

    @Override
    public void lock() throws IllegalStateException {
        if(this.pin.isEmpty()) {throw new IllegalStateException();}
        this.lockState = LockStates.LOCKED;
    }

    @Override
    public boolean isLocked() {
        return this.lockState == LockStates.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return this.lockState == LockStates.BLOCKED;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.currentFailedAttempts;
    }

    @Override
    public void reset() {
        this.pin = "";
        this.lockState = LockStates.UNLOCKED;
        this.currentFailedAttempts = 0;
    }
}
