import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};
   
    /**
     * Function name: randomWord
     * 
     * @param words
     * @return clue (String)
     * 
     * Inside the function:
     * 1. Returns a random word from the list of random words.
     */
    public static String randomWord(String[] words) {
        int index = (int)(Math.random() * words.length);
        String clue = words[index];
        return clue;
    }

    public static void main(String[] args) {

        String word = randomWord(words);
        
        char[] clueWord = word.toCharArray();
        System.out.println(Arrays.toString(clueWord));

        int counter = 0;
        String misses = "";
        char guess; 
        char[] hidenWord = new char[clueWord.length];
        
        for(int i=0; i < hidenWord.length; i++) {
            hidenWord[i] = '_';
        }



        System.out.println(gallows[counter]);
        System.out.print("Word:    ");
        for (char i : hidenWord) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        System.out.println("Misses: " + misses + "\n");
        System.out.print("Guess: ");
        guess = scan.next().charAt(0);



        scan.close();
    }
}