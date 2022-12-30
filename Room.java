
/** A class Location
 * 
 */
public class Room {

    //      Identifying information
    protected String name; // the name of this room, ex. "lounge area"
    protected String description; // the description of this room, provides information on adjacent rooms and which direction they are from here

    //      Booleans indicating whether there is an exit present in a direction n, e, s, w. An "exit" is a room that can be moved into from this one.
    private boolean isNorth; // true when there is a room north of this room
    private boolean isEast; // true when there is a room east of this room
    private boolean isWest; // true when there is a room west of this room
    private boolean isSouth; // true when there is a room south of this room

    //      Strings that identify which room the exit is in the direction n, e, s, w.
    String exitNorth;
    String exitEast;
    String exitWest;
    String exitSouth;


    /* Default constructor for a location of unspecified name, description, and exits. */
    public Room() {
        this("<Undefined Name", "<Empty Description>", false, false, false, false, "N1", "E1", "W1", "S1");
    }

    public Room(String name) {
        this.name = name;
    }

    /**
    /* Complete constructor for a location of specified name, description, and exits.
    * @param name
     * @param description
     * @param isNorth
     * @param isEast
     * @param isWest
     * @param isSouth
     * @param exitNorth
     * @param exitEast
     * @param exitWest
     * @param exitSouth
     */
    public Room (String name, String description, boolean isNorth, boolean isEast, boolean isWest, boolean isSouth, String exitNorth, String exitEast, String exitWest, String exitSouth) {
        // Constructor for a Location
        this.name = name;
        this.description = description;
        this.isNorth = isNorth;
        this.isEast = isEast;
        this.isWest = isWest;
        this.isSouth = isSouth;
        this.exitNorth = exitNorth;
        this.exitEast = exitEast;
        this.exitWest = exitWest;
        this.exitSouth = exitSouth;
    }

    //         ** Accessor methods **
    // location name
    public String getName() {
        return name;
    }

    // location description
    public String getDesc() {
        return description;
    }

    /**
    /* Accessor for different direction typ booleanss, indicating whether or not the player can move in this direction. 
    * @param direction
    * @return the location 
    */
    public boolean isExit(String direction) {
        switch(direction) {
            case "N":
                return this.isNorth;
            case "E":
                return this.isEast;
            case "W":
                return this.isWest;
            case "S":
                return this.isSouth;
            default:
                return false;
        }
    }

}

