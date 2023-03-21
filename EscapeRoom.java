import java.lang.String;
import java.util.Locale;

public class EscapeRoom{
        private Room currentRoom;
        private int currentRoomNumber;

        public EscapeRoom() {
            currentRoomNumber = 1;
            currentRoom = new Room(currentRoomNumber);
        }

        public void play() {
            while (currentRoomNumber <= 3) {
                // Display the room view
                currentRoom.displayRoomView(currentRoomNumber);

                // Check if the player has solved all the puzzles
                if (currentRoom.isRoomComplete()) {
                    // Unlock the door and move to the next room
                    currentRoom.unlockDoor();
                    currentRoomNumber++;
                    currentRoom = new Room(currentRoomNumber);
                }
            }
        }
    }
