import java.util.Scanner;

public class Blackjack {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see...");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        
        // deal two random cards and print them
        int userCard1 = drawRandomCard();
        int userCard2 = drawRandomCard();
        System.out.println("You get a \n" + printCard(userCard1) + "\n and a \n" + printCard(userCard2));

        // calculate and print the hand value
        // the face cards (Jack, Queen, and King) have values of 10
        int userTotal = Math.min(userCard1, 10) + Math.min(userCard2, 10);
        System.out.println("Your total is: " + userTotal);

        // dealer gets two cards as well
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();

        // print the dealer's first card, and print the next one facedown.
        System.out.println("\nThe dealer shows\n" + printCard(dealerCard1) + "\n and has a card facing down\n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");

        while (true) {
            // asking the player to hit or stay
            String option = hitOrStay();
            // every time the player hits, draw a new card and calculate a new total, and then, print
            if ("hit".equalsIgnoreCase(option)) {
                int nextCard = drawRandomCard();
                userTotal += Math.min(nextCard, 10);
                System.out.println("\nYou get a\n" + printCard(nextCard));
                System.out.println("Your new total is " + userTotal);
                // if total exceeds 21 shut down the game
                if (userTotal > 21) {
                    System.out.println("Bust! Player loses!");
                    System.exit(0);
                }
            // once the player 'stays', break the loop.
            } else {
                break;
            }
        }

        // after the player chooses to stay, it becomes the dealer's turn
        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are\n" + printCard(dealerCard1) + "\nand a\n" + printCard(dealerCard2));
        int dealerTotal = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);
        System.out.println("\nDealer's total is " + dealerTotal);

        // the dealer keeps "hitting" until their total gets to 17
        while (dealerTotal < 17) {
            int nextCard = drawRandomCard();
            dealerTotal += Math.min(nextCard, 10);
            System.out.println("\nDealer gets\n" + printCard(nextCard));
            System.out.println("\nDealer's total is " + dealerTotal);
        }

        // if the dealer's total is higher than 21 end the game 
        if (dealerTotal > 21) {
            System.out.println("Bust! Dealer loses!");
            System.exit(0);
        }
        
        // otherwise compare the dealer and player's hand values
        if (userTotal > dealerTotal) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }

        scan.close();
    }

    /**
     * 
     * Function name: drawRandomCard
     * 
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */
    public static int drawRandomCard() {
        int randomNumber = (int)(Math.random() * 13) + 1;
        return randomNumber;
    }
    
    /**
     * 
     * Function name: drawCard
     * 
     * @param randomNumber
     * @return (String)
     * 
     * Inside the function:
     *  1. Receives a card number between 1 and 13.
     *  2. Returns the String drawing.
     */
    public static String printCard(int randomNumber) {
        switch (randomNumber) {
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";
   
            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";
           
            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";

            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";

            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";

            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";

            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";
   
            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";
      
            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";

            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";
     
            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";
     
            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";
       
            case 13: return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n"; 

            default: return "";
        }
    }

    /** 
     * 
     * Function name: faceDown
     * 
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String for a facedown card.
     */
    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }

    /**
     * 
     * Function name: hitOrStay
     * 
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *
     *   2. If the user doesn't enter "hit" or "stay"
     *       Run a while loop
     *       During each run, println: Please write 'hit' or 'stay'
     *
     *   3. Returns the user's option
     */
    public static String hitOrStay() {
        System.out.println("Would you like to hit or stay?");
        while (true) {
           String userOption = scan.nextLine();
           if ("hit".equalsIgnoreCase(userOption) || "stay".equalsIgnoreCase(userOption)) {
               return userOption;
           } else {
               System.out.println("Please write 'hit' or 'stay'");
           }
        }
    }
}