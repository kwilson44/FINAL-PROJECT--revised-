import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class FordHall {

    //    Visited Room Trackers: hasBeen boolean variables that indicate whether or not the player has been in this room before.
    boolean hasBeenTE; // has been in the "terrace edge" room
    boolean hasBeenT; // has been in the "terrace" room
    boolean hasBeenL; // has been in the "lounge" room
    boolean hasBeenH; // has been in the "hallway" room
    boolean hasBeenBB; // has been in the "bulletin board" room
    boolean funQuestion; // a boolean that stores whether or not Portabella likes your question

    //  Take in input from the user to make choices during certain events.
    Scanner userInput = new Scanner(System.in);
    String userResponse = ""; // Storage for user's responses
    
    /**
     * Starting values for places that the user can go in Ford Hall
     */
    public FordHall() {
        hasBeenTE = false;
        hasBeenT = false;
        hasBeenL = false;
        hasBeenH = false;
        hasBeenBB = false;
    }

    /**
     * The player's terrace edge sequence and options
     * @param gamePoints
     * @return gamePoints
     */
    public int terraceEdge(int gamePoints) {
        if (hasBeenTE) {
            System.out.println("You sit on the bench by the terrace. There isn't much to see here.");
        } else {
            System.out.println("You look off into the distance and see Mendenhall in all it's glory. There seems to be an ominous trembling coming from it... that's weird??? \n");
            hasBeenTE = true;
        } return gamePoints;
    }

    /**
     * The player's terrace sequence and choices 
     * @param gamePoints
     * @param inventory
     * @return gamePoints
     */
    public int terrace(int gamePoints, ArrayList<String> inventory) {
        if(hasBeenT) {
            // not much
        } else {
            hasBeenT = true;
            //Smithie on a balcony that wants a cookie
            int funQuestionReactionRandomizer = (int)(Math.random() * (2 - 1 + 1) + 1); // Use a random to determine whether the character will have a positive or negative reaction to the question.
            System.out.println("You head up to the balcony in Fordhall. There's a lone Smithie looking into the horizon. \n There are cherry blossoms swaying in the wind even though we're in MA... just don't think about it \n " +
            "'Oh! You scared me.'Says Portabella (she/her pronouns). She's friends with Katie and Erin and Pre-Med :D but also she's an Aries and from Ohio :( . She's wearing gothic cottagecore clothes. Quick!! Pick something cool to say, first impressions matter! \n ** Honest explanation (type 'H')** \n **LIE??? (type 'L')** \n ** Compliment??? (type C)**");
            userResponse = userInput.nextLine().toUpperCase();

            switch (userResponse) {
                case "H":
                    System.out.println(" 'I.. uh, wanted to see what was up there, I didn't mean to startle you' You say to her. She seems to be impressed by your honesty and likes your awkwardness *** +10 POINTS *** \n");
                    gamePoints += 10;
                break;
                case "L":
                    System.out.println("You say 'I... wanted to... see if there were any ghosts up here. Yeah, that's it, ~ghosts~'. She seems to know you're lying but don't care enough... Success, I guess, but lying isn't good! *** +1 POINTS *** \n");
                    gamePoints += 1;
                break;
                case "C":
                    System.out.println("'Woah!' You say 'Those are cool socks!' The said socks are green and have corgis on them. Your crush is so flattered you noticed and blushes!! *** +15 POINTS *** \n");
                    gamePoints += 15;
                break;
                default: 
                    System.out.println("OH NO! You fail to say anything and now she's having a pretend phone with her friend because you scared her so much :((((. *** -10 POINTS *** \n");
                    gamePoints -= 10;
             } 

             if (userResponse.equals("H") || (userResponse.equals("C")) || (userResponse.equals("L"))) {
                System.out.println("'I'm Portabella but everyone calls me Porty' she says. Okay, here's your chance! What do you do next??? \n ** Smooth Talk (type 'S')** \n ** Ask Fun Question (type 'Q')** \n ** Ask why she's up here (type A)**");
           
                userResponse = userInput.nextLine().toUpperCase();
    
                if (userResponse.equals("S")) {
                    
                    System.out.println("You start sweating profusely and think about all those TikToks you watched. Nervously, you bite your lower lip, squint your eyes, and say 'Heyyyyyy, would you wanna, Compass Cafe... I mean, if you're not, not to say, uhhhhh, you seem nice... coffee? :D' Well... it's not like you've offended her *** +5 POINTS *** ");
                    gamePoints += 5;
                } else if (userResponse.equals("Q")) {
                    System.out.println("You smile nervously and say'Are you a cat person or a dog person?' ");
                    if (funQuestionReactionRandomizer % 2 == 1) {
                        System.out.println(" 'I love both! Thanks for asking... cutie ;)' *** +10 POINTS *** \n");
                        funQuestion = true;
                        gamePoints += 10;
                    } else {
                        System.out.println(" 'DOGS AND CATS ARE ALWAYS MEAN TO ME... God, you ruined my day!!' *** -10 POINTS ***\n");
                        funQuestion = false;
                        gamePoints -= 10;
                    }
                } else if (userResponse.equals("A")) {
                    System.out.println(" 'Oh, I'm just killing time... I ordered a snack at the Compass Cafe but I'm like 534 in line :(  I just wish I had a cookie or something' *** +5 POINTS ***\n");
                    gamePoints+=5;
                    if (inventory.contains("Smith Cookie")){
                        System.out.println(" 'Hey... I think you're really neat! I have this Smith Cookie, do you want it?' \n Your crush smiles at you'WOW! THANK YOU SO MUCH!!'  *** +15 POINTS *** \n");
                        inventory.remove("Smith cookie");
                        gamePoints += 15;
                    } else {
                        System.out.println("'Gee, that sucks' you say sheepishly, wishing you could help. Because of your empathy: *** +5 POINTS ***");
                        gamePoints += 5;
    
                    }
                } else {
                    System.out.println("Well, now Portabella is calling CAMPO. Good job. \n");
                }
             } 
         }  return gamePoints;
    }

    /**
     *The player's lounge sequence and choices 
     * @param gamePoints
     * @return gamePoints
     */
    public int lounge(int gamePoints) {
        if(hasBeenL) {
            System.out.println("The lounge area is empty now.");
        } else {
            System.out.println("You approach the lounge area by the entrance of Ford, noticing that several students have set up camp on the sofas. \n There is a lone Smithie sitting by the window, staring at their computer with a thousand-yard stare. As an empath, you get the sense that they may be stressed. \n'I am so stressed.', they say. 'My CS homework is due in 5 minutes, but I forgot how to write javadoc comments!! What should I do?' \n ** Helpful Answer (type 'H') \n ** Pair programming? (type 'P') \n ** Unsolicited Pep Talk ('U')");
            userResponse = userInput.nextLine().toUpperCase();
            switch(userResponse) {
                case "H":
                    System.out.println("You puff out your chest and smile cooly. Finally, you know something useful! 'Here, I have a template to help with that,' you say, lifting your arm up to show them the notes written on your wrist. A little weird, but okay - they seem too desperate to care anyways! *** +10 POINTS *** ");
                    gamePoints += 10;
                break;
                case "P":
                    System.out.println("You sit down on the tabletop and take their laptop into your hands, beginning to type on the keyboard frantically. They stare at you with a wide-eyed look of horror. Yeah no, that's not pair programming...and now your grubby hands have been all over their computer. Whoops. *** -10 POINTS ***");
                    gamePoints -= 10;
                break;
                case "U":
                    System.out.println("'It's fine, who even cares about documentation? Just chill, you'd feel better if you drank some water!' \n They've already begun shoving their things into their bag before you've even finished talking. Nice job. *** -15 POINTS ***");
                    gamePoints -= 15;
                break;
                default:
                    System.out.println("YIKES, you were too slow to react and are now staring at them silently. The slight smile on your face is enough to scare them off completely. *** -15 POINTS *** \n");
                    gamePoints -= 15;
            } System.out.println("Well, that happened.");
            hasBeenL = true;
        } return gamePoints;
    }

    /**
     * The player's hallway sequence
     * @param gamePoints
     * @return gamePoints
     */

    public int hallway(int gamePoints) {
        if(hasBeenH) {
            System.out.println("You stand in the middle of the hallway again, glancing around. There's not much to see here.");
        } else {
            System.out.println("You wander aimlessly into the hallway on the first floor of Ford. To the (W)est, you see someone hanging up a missing cat poster at the bulletin board. Suddenly you hear a whispering in your ear: \n 'Psst, it's me, Sophia Smith! That's Bicheal (he/him pronouns), he has a cool taste in music and likes nature :D but he's also kind of cringe and an art major :(((' \n'He's single, so feel free to approach him! Okay bye!");
            hasBeenH = true;
        } return gamePoints;
    }

    /**
     * The player's bulletin board sequence and choices
     * @param gamePoints
     * @return gamePoints
     */
    public int bulletinBoard(int gamePoints) {
        if(hasBeenBB) {
            System.out.println("You stand before the bulletin board, scanning the various posters and notices pinned up. \nIt looks like there are some performances from student groups coming up, and some guest lectures happening around ford. \nOne of the posters is a deep red color and contains no information except a crpytic black bull symbol. \n You yawn.");
        } else {
            System.out.println("You approach Bicheal and begin to panic! What's your opener?  \n ** Ask about name (type 'A')** \n ** Wink Agressively(type 'W')** \n ** Say Hi (type H)**");
            userResponse = userInput.nextLine().toUpperCase();
            switch(userResponse) {
                case "A":
                    System.out.println(" 'So... Bicheal?' You say nervously with a smile. Bicheal smiles back at you! 'Yeah, it's a family name. I go by Bike for short'  *** +5 POINTS *** \n");
                    gamePoints += 5;
                break;
                case "W":
                    System.out.println("You wink agressively and Bicheal who is throughly confused. Although, he thinks it's silly (in a good way!) *** +15 POINTS *** \n");
                    gamePoints += 15;
                break;
                case "H":
                    System.out.println(" You say hi... Bicheal says hi back and then goes back to what he was doing *** +10 POINTS *** \n");
                    gamePoints += 10;
                break;
                default:
                    System.out.println("OH NO! You fail to say anything and now he's shuffling around and uncomfy :((((. *** -10 POINTS *** \n");
                    gamePoints -= 10;
            }
            if (userResponse.equals("A") || (userResponse.equals("W")) || (userResponse.equals("H"))) {
                System.out.println("'Bicheal (or Bike) steps closer with a little smile. Okay, here's your chance! What do you do next??? \n ** Just say it (type 'J')** \n ** Compliment (type 'C')** \n ** Break it down~ (type B)**");
                userResponse = userInput.nextLine().toUpperCase();
    
                if (userResponse.equals("J")) {
                    
                    System.out.println("You take a deep breath and just say it 'Hey, I think you're cool and I'd like to hangout with you or something. Are you on Instagram?' \n * PAUSE *\n BIKE GAVE YOU HIS INSTA :D *** +20 POINTS *** \n ");
                    gamePoints += 20;
                } else if (userResponse.equals("C")) {
                    System.out.println("You compliment Bike's doc martens and he's really flattered! :D *** +10 POINTS *** ");
                    gamePoints += 10;
    
                } else if (userResponse.equals("B")) {
                    System.out.println("You ~break it down~ by having a nervous breakdown because you're so nervous. Even if Bike is really worried/confused now, your feelings are valid *** +5 POINTS *** \n");
                    gamePoints += 5;
                } else {
                    System.out.println("Well, now he's pretending to read a text messsage because you didn't say anything. Good job. \n");
                }
            }
            hasBeenBB = true;
        } return gamePoints;
    }

    /**
     * The player's entrance sequence
     */
    public void entrance() {
        System.out.println("There isn't much to do here.");
    }

    /**
     * The player's options in regards to leaving Ford Hall
     * @param houseMap
     * @param fordMap
     * @param mendenhallMap
     * @return currentRoom
     */
    //public Room fordExit(HashMap<String, Room> houseMap, HashMap<String, Room> fordMap, HashMap<String, Room> mendenhallMap) {
        // This room is the same whether or not you have visited it, since there are no events here, so there is just one branch.

    public ArrayList<String> fordExit(HashMap<String, Room> houseMap, HashMap<String, Room> fordMap, HashMap<String, Room> mendenhallMap) {
        System.out.println("Pick a new location.");

        // This room is the same whether or not you have visited it, since there are no events here
        System.out.println("Where would you like to go from the exit? (n, e, s, w)");
        userResponse = userInput.nextLine().toUpperCase();
        Room currentRoom = fordMap.get("S2");
        ArrayList<String> newLocation = new ArrayList<String>();
        switch (userResponse) {
            case "N":
                System.out.println("You move north back into Ford.");
                newLocation.add("fordMap");
                newLocation.add("S1");
            break;
            case "W":
                System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
            break;
            case "E":
                System.out.println("You move east into your house.");
                newLocation.add("houseMap");
                newLocation.add("S1");
            break;
            case "S":
                System.out.println("You move south towards Mendenhall Center.");
                newLocation.add("mendenhallMap");
                newLocation.add("N1");
            break;
            default:
                newLocation.add("fordMap");
                newLocation.add("S2");

        } 
        return newLocation;
    }
}
