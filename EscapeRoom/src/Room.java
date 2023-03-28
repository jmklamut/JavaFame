public class Room{

        private Door door;

        public Room(int roomNumber) {
           Puzzle puzzle = new Puzzle();

            // Create the door object
            door = new Door();
        }

        public void displayRoomView(int current){
            //TODO: shows the user the room on there screen
        }

        public boolean isRoomComplete(){
            //TODO
            return false;
        }

        public void unlockDoor(){
            door.unlockDoor();
        }




}
