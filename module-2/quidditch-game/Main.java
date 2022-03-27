import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.*;


public class Main {
    static Game game;
    static final String TEAMS_FILE = "teams.txt";
    static final String PLAYS_FILE = "plays.txt";

     /**
     * Function name: getData
     * @return (String[][])
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *   1. Returns data from TEAMS_FILE as a String[][] array.
     */
    public static String[][] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TEAMS_FILE);
        Scanner scan =  new Scanner(fis);
        String[] lines = new String[] {scan.nextLine(), scan.nextLine()};
        scan.close();
        return new String[][] {lines[0].split(","), lines[1].split(",")}; 
    }

    public static void main(String[] args) {

        try {
            String[][] data = getData();
            game = new Game(
                new Team(data[0][0], data[0][1], data[0][2], new String[] {data[0][3], data[0][4], data[0][5]}),
                new Team(data[1][0], data[1][1], data[1][2], new String[] {data[1][3], data[1][4], data[1][5]})
            );
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
     

    

}
    
    
