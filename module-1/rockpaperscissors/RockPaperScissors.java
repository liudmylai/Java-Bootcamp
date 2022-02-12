import java.util.Scanner;

public class RockPaperScissors {
    /**
     * Function name: computerChoice 
     * @return a choice (String)
     * 
     * Inside the function:
     * 1. Picks a random number between 0 and 2.
     * 2. if 0: return the choice 'rock'
     *    if 1: return the choice 'paper'
     *    if 2: return the choice 'scissors'
     */
    public static String computerChoice() {
        int randomNumber = (int)(Math.random() * 3);
        
        switch (randomNumber) {
            case 0:
                return "rock"; 
            case 1:
                return "paper";
            case 2:
                return "scissors";   
            default:
                return "";
        }
    }
        /**
         * Function name: result         
         * 
         * @param choice
         * @param computerChoice
         * @return
         * 
         * Inside the function:
         * 1. result is "You win!" if:
         *  You: "rock"      Computer "scissors"
         *  You: "paper"     Computer "rock"
         *  You: "scissors"  Computer "paper"
         * 
         * 2. result is "You lose" if:
         *  Computer "rock"      You: "scissors"
         *  Computer "paper"     You: "rock"
         *  Computer "scissors"  You: "paper"
         *  
         * 3. result is "It's a tie" if:
         *  your choice equals computer choice
         */
    public static String result(String choice, String computerChoice) {
        String result ="";
        if ("rock".equalsIgnoreCase(choice) && "scissors".equalsIgnoreCase(computerChoice)) {
            result = "You win!";
        } else if ("rock".equalsIgnoreCase(computerChoice) && "scissors".equalsIgnoreCase(choice)) {
            result = "You lose!";
        } else if ("paper".equalsIgnoreCase(choice) && "rock".equalsIgnoreCase(computerChoice)) {
            result = "You win!";
        } else if ("paper".equalsIgnoreCase(computerChoice) && "rock".equalsIgnoreCase(choice)) {
            result = "You lose!";
        } else if ("scissors".equalsIgnoreCase(choice) && "paper".equalsIgnoreCase(computerChoice)) {
            result = "You win!";
        } else if ("scissors".equalsIgnoreCase(computerChoice) && "paper".equalsIgnoreCase(choice)) {
            result = "You lose!";  
        } else {
            result = "It's a tie";
        }
        return result;
    }
    /**
     * Function name: printResult
     * 
     * @param choice
     * @param computerChoice
     * @param result
     * 
     * Inside the function:
     * 1. prints everything:
     *  - prints: You chose:             <your choice>
     *  - prints: The computer chose:    <computer choice>
     *  - prints: <result>
     */
    public static void printResult(String choice, String computerChoice, String result) {
        System.out.println("\nYou chose:        " + choice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's play Rock Paper Scissors. \nWhen I say 'shoot', Choose: rock, paper, or scissors. \nAre you ready? Write 'yes' if you are.");
        String answer = scan.nextLine();
            if ("yes".equalsIgnoreCase(answer)) {
                System.out.println("\nGreat!");
                System.out.println("rock - paper - scissors, shoot!");
                String choice = scan.nextLine();
                String computerChoice = computerChoice();
                scan.close();
                String result = result(choice, computerChoice);
                printResult(choice, computerChoice, result);
            } else {
                System.out.println("Darn, some other time...!");
            }
    }
}