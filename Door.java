import java.util.Locale;

public class Door {

    private Puzzle puz;
    private boolean isLocked;

    public Door(Puzzle pu){
        puz = pu;
        isLocked = true;
    }

    public Puzzle getPuz() {
        return puz;
    }

    public void setPuz(Puzzle puz) {
        this.puz = puz;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void unlockDoor(){
        isLocked = false;
    }
}
