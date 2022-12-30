import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MendenhallCenter {
        //    Visited Room Trackers: hasBeen boolean variables that indicate whether or not the player has been in this room before.
        boolean hasBeenB; // has been in the "YourDorm" room
    
        //   A boolean that stores whether or not the user's roommate likes them.
        boolean roommateFriendship;
        boolean winOrLose;
        public ArrayList<String> inventory;
    
        //  Take in input from the user to make choices during certain events.
        Scanner userInput = new Scanner(System.in);
        String userResponse = ""; // Storage for user's responses
        
        public MendenhallCenter() {
            this.inventory = new ArrayList<String>();
        }
    
        public void mendenhallLobby() {
            System.out.println("There is a deep rumbling sound growing louder now as you pace the red carpet of Mendenhall's atrium, coming from below.");
        }

        /**
         * Options for the player to pick a location on the map
         * @param houseMap
         * @param fordMap
         * @param mendenhallMap
         * @return
         */
        public ArrayList<String> mendenhallExit(HashMap<String, Room> houseMap, HashMap<String, Room> fordMap, HashMap<String, Room> mendenhallMap) {
            // This room is the same whether or not you have visited it, since there are no events here, so there is just one branch.
            System.out.println("Pick a new location.");
            userResponse = userInput.nextLine().toUpperCase();
            Room currentRoom = mendenhallMap.get("N1");
            ArrayList<String> newLocation = new ArrayList<String>();
            switch (userResponse) {
                case "N":
                    System.out.println("You move north over to Ford Hall.");
                    newLocation.add("fordMap");
                    newLocation.add("S1");
                break;
                case "W":
                    System.out.println("You move west back over to your house.");
                    newLocation.add("houseMap");
                    newLocation.add("S1");
                break;
                case "E":
                    System.out.println("Sorry, you can't go that way. Try moving in another direction.");
                break;
                case "S":
                    System.out.println("You go south back into Mendenhall.");
                    newLocation.add("mendenhallMap");
                    newLocation.add("S1");
                break;
                default:
                    newLocation.add("mendenhallMap");
                    newLocation.add("N1");
    
            } 
            return newLocation;
        }
    /**
     * Basement minotaur battle
     * @param gamePoints
     * @return
     */
        public int basement(int gamePoints) {
            // Each room has two branches when called, one for when this is your first time here and another for when you've already been to this place.
            if (hasBeenB) {
                System.out.println("The basement is empty now...");
            } else {
                System.out.println("You enter Mendenhall's basement feeling pretty weird... all of a sudden, a MINOTAUR emerges from the shadows...\n And oh no! They're bullying your crush. YOU MUST DEFEAT THEM. Pick your wits or the things around you: \n ** Hurt their ego (type 'E')** \n ** Sword!! (type 'S')** \n ** Reference The Little Mermaid the musical??? (type M)**");
                hasBeenB = true;
                userResponse = userInput.nextLine().toUpperCase();

                switch (userResponse) {
                    case "E":
                        System.out.println(" 'Eh Minotaur!', You shout at the top of your lungs, 'You look stupid'. Simple, but effective! Now they feel bad. *** +10 POINTS *** \n");
                        gamePoints += 10;
                    break;
                    case "S":
                        System.out.println("You grab a prop sword you see on the ground and charge at them! But it's a prop so it snaps in 1/2 on impact ://// Also violence is never the answer *** -5 POINTS *** \n");
                        gamePoints -= 5;
                    break;
                    case "M":
                        System.out.println(" For some inexplicable reason, you reference The Little Mermaid the musical. You referencing it has distracted them for some reason! :D  *** +15 POINTS *** \n");
                        gamePoints += 15;
                    break;
                    default: 
                        System.out.println("OH NO! You don't say anything and now your crush is in danger... or catching feelings for the Minotaur??? *** -10 POINTS *** \n");
                        gamePoints -= 10;
                 } 

                 System.out.println("This is your last chance to win over your crush and defeat the Minotaur. What's your final move???  \n ** DANCE? (type 'D')** \n ** CRY? (type 'C')** \n ** FLIRT? (type F)**");
                 userResponse = userInput.nextLine().toUpperCase();

                 switch (userResponse) {
                     case "D":
                        System.out.println(" You starting dancing like your life depends on it, which distracts the Minotaur giving your crush a chance to escape. But what about you? *** +15 POINTS *** \n ");
                        gamePoints += 15;
                     break;
                     case "C":
                        System.out.println("You start crying and the Minotaur is really invested in what you're doing, giving your crush a chance to escape. But what about you?*** +10 POINTS *** ");
                        gamePoints += 10;
                     break;
                     case "F":
                        System.out.println("You flirt with the Minotaur, who was confused at first but is now cool with it, giving your crush time to escape. But what about you? *** +5 POINTS *** \n");
                        gamePoints += 5;
                     break;
                     default: 
                         System.out.println("OH NO! You don't do anything and now your crush can't get away. *** -10 POINTS *** \n");
                         gamePoints -= 10;
                  } 
                  System.out.println("The minotaur jumps at you suddenly--");

                   //50/50 chance of success
                    int fightSuccess = (int)(Math.random() * (2 - 1 + 1) + 1);
                    if (fightSuccess % 2 == 1) {
                        System.out.println("As the minotaur lurches forward, its legs begin to wobble, and you see its midsection start to shake back and forth as its head sways wildly. The monster suddenly collapses to the floor in a heap of grey and brown, falling apart to reveal...3 smithies stacked on top of each other? Well, you won the fight! CONGRATS \n");
                        winOrLose = true;
                        gamePoints += 10;
                    } else {
                        System.out.println("The minotaur lands its stride and lunges right towards you, arcing a long cardboard tube down onto your head. Ow, that hurt and made you feel pretty stupid and silly. \n Panting, you step back, completely exhausted from your efforts. The Minotaur begins laughing now, its deep rumble like the sound of 2 to 3 college students laughing under their breaths from beneath a costume. Uh oh. It looks like this fight is over. \n");
                        winOrLose = false;
                        gamePoints -= 10;
                    }
                    if (winOrLose == true) {
                        System.out.println("As the 'Minotaur' scrapes themsel(ves?) together and trudges away down the hall towards the costume shop, your Crush reappears and runs up to you, looking a bit flustered. They give you a grin and begin laughing, seeming to share in your incredulity at the situation. \n 'Hey, thanks for helping me out back there. I'm not sure how I'd have handled all that if you weren't around'. Nice! You kept them safe from the theater students' antics!! \n" +
                        "'You're a pretty cool person, PLAYERNAME. We should get coffee together sometime :)' YAYY!! Looks like this could be the start of something special...or at least a nice healthy friendship!");
                    }
                    if (winOrLose == false) {
                        System.out.println("You hunch over, trembling, nerves frayed with the hope that your crush will come back for you, but they're now nowhere to be seen. You stand frozen and left behind as the Minotaur points at laughs at you for being such a complete and utter loser. Better luck next time... GAME OVER! \n");
                    }


            } return gamePoints;
    
        }
}
