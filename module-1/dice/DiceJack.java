import java.util.Scanner;
//rules:
//the user needs to pick three numbers (4 3 5) sum: 12
//the user needs to roll the dice three times (3 4 4) sum: 11
// the user wins if:
//- the sum of dice is smoller than the sum of numbers you chose
// AND the difference between the two numbers is less than three
//Tasks:
//1.Roll the dice
//2.Check if the user won
public class DiceJack {
    // create a rundom number
    public static int rollDice() {
        double randomNumber = Math.random() * 6;
        randomNumber += 1;
        return (int)randomNumber;
    }
    // check whether user win 
    public static boolean checkWin(int sumDiceRolls, int sumOfNumbers) {
        return (sumOfNumbers > sumDiceRolls && sumOfNumbers - sumDiceRolls < 3); 
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // generate three random numbers
        int roll1 = rollDice();
        int roll2 = rollDice();
        int roll3 = rollDice();
        // take three numbers from user
        System.out.println("Enter three numbers between 1 and 6");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        // check whether user's numbers between 1 and 6
        if (num1 < 1 || num2 < 1 || num3 < 1) {
            System.out.println("Numbers cannot be less than 1. Shutting game down");
            System.exit(0);
        } else if (num1 > 6 || num2 > 6 || num3 > 6) {
            System.out.println("Numbers cannot be greater than 6. Shutting game down");
            System.exit(0);
        }

        int sumOfNumbers = num1 + num2 + num3;
        int sumDiceRolls = roll1 + roll2 + roll3;
        System.out.println("Dice sum = " + sumDiceRolls + ". Numbers sum = " + sumOfNumbers);
        // display the message regarding if user win or lose
        if (checkWin(sumDiceRolls, sumOfNumbers)) {
            System.out.println("Congrats, you win!");
        } else {
            System.out.println("Sorry! You lose.");
        }

        scan.close();

    }

}