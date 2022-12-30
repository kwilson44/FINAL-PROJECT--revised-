

public class Player {
    // public ArrayList<String> inventory;
    private String name;
    protected int classYear;
    private String playerHouse;

    /* Full constructor for a player. */
    /**
     * All the player's chosen personal information
     * @param name
     * @param classYear
     * @param playerHouse
     */
    public Player(String name, int classYear, String playerHouse) {
        // this.inventory = new ArrayList<String>();
        this.name = name;
        this.classYear = classYear;
        this.playerHouse = playerHouse;
    }


    //       ** Accessor methods for the player **
    // get player name
    public String getName() {
        return this.name;
    }

    // get player's class year
    public int getClassYear() {
        return this.classYear;
    }

    // get player's Smith house
    public String getPlayerHouse() {
        return this.playerHouse;
    }

    //       ** Manipulator methods for the player **
    // set player name
    public void setName(String name) {
        this.name = name;
    }

    // set player's class year
    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    // set player's Smith house
    public void setPlayerHouse(String playerHouse) {
        this.playerHouse = playerHouse;
    }
}
