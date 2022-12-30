import java.util.HashMap;

/** A class Commands that contains methods for user commands called during the game
 * 
 */
public class Commands {
    
    public Commands() {

    }

/**
 * Shows the user their options
 */
    public void showOptions() {
        System.out.println("\nAvailable game commands:" +
        "\n + 'HELP' - print a list of available commands. \n + 'LOOK AROUND' - print out a description of the current surroundings." + 
        "\n + 'GRAB x' - add the item x to your inventory, typed as the item is spelled between asterisks (**item name**). \n + 'DROP x' - remove the item x from your inventory. " +
        "\n + 'N' - go north on the map. \n + 'E' - go east on the map. \n + 'S' - go south on the map. \n + 'W' - go west on the map. \n + 'CHECK SCORE' - check how many points you currently have. \n + 'CHECK INVENTORY' - check what items you currently have in your inventory. \n + 'QUIT' - exit the game. \n");
    }

        // ** NAVIGATION METHODS **
        /**
         * Allows players to move to the north side of the room
         * @param currentRoom
         * @param currentMap
         * @return currentRoom
         */
    public Room goNorth(Room currentRoom, HashMap<String, Room> currentMap) {
        // Check which map we are in, then check which room this is, then change current room to the room north of this one
        if(currentRoom.isExit("N")) {
            System.out.print("\n> You moved north into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitNorth);
            System.out.println(currentRoom.name + currentRoom.description);
            
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }
        /**
        * Allows players to move to the east side of the room
        * @param currentRoom
        * @param currentMap
        * @return currentRoom
        */
    public Room goEast(Room currentRoom, HashMap<String, Room> currentMap) {
        if(currentRoom.isExit("E")) {
            System.out.print("\n> You moved east into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitEast);
            System.out.println(currentRoom.name + currentRoom.description);
            // add conditional for e1 or e2
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }

        /**
        * Allows players to move to the west side of the room
         * @param currentRoom
         * @param currentMap
         * @return currentRoom
         */

    public Room goWest(Room currentRoom, HashMap<String, Room> currentMap) {
        if(currentRoom.isExit("W")) {
            System.out.print("\n> You moved west into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitWest);
            System.out.println("You are now in " + currentRoom.name + currentRoom.description);
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }

    /**
    * Allows players to move to the south side of the room
     * @param currentRoom
     * @param currentMap
     * @return currentRoom
     */
    public Room goSouth(Room currentRoom, HashMap<String, Room> currentMap) {
        if(currentRoom.isExit("S")) {
            System.out.print("\n> You moved south into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitSouth);
            System.out.println(currentRoom.name + currentRoom.description);
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }

}
