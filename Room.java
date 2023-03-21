public class Room{

        private Puzzle puzzle;
        private Door door;

        public Room(int roomNumber) {
            // Generate a random puzzle for the room
            puzzle = new Puzzle();

            // Create the door object
            door = new Door(puzzle);
        }

        public void displayRoomView(int current){
            //TODO: shows the user the room on there screen
        }

        public boolean isRoomComplete(){
            if(puzzle.checkIfSolved()){
                return true;
            }
            return false;
        }

        public void unlockDoor(){
            door.unlockDoor();
        }




}
