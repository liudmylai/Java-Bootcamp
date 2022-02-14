import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");

        //store the value
        int userResponse = scan.nextInt();

        //watch out for the nextLine() pitfall. 
        scan.nextLine();

        //create a 2D array with a variable number of rows, and 3 values per row.         
        String[][] database = new String[userResponse][3]; 

        //create a for loop that runs through every row in the database
        for (int i = 0; i < database.length; i++) {
            System.out.println("\n\tFigure " + (i + 1)); 

            //pick up and store figure's name   
            System.out.print("\t - Name: ");
            database[i][0] = scan.nextLine();;

            //pick up and store figure's birthday.
            System.out.print("\t - Date of birth: ");
            database[i][1] = scan.nextLine();

            //pick up and store figure's occupation. 
            System.out.print("\t - Occupation: ");
            database[i][2] = scan.nextLine();
        }

        //print the contents of database
        System.out.println("\nThese are the values you stored:\n"); 
        print2DArray(database);

        //let the user search the database by name
        System.out.print("\nWho do you want information on? ");  
        String name = scan.nextLine();
        for (int i = 0; i < database.length; i++) {
            
            //if there's a match:
            if (database[i][0].equalsIgnoreCase(name)) {
                System.out.println("\tName: " + database[i][0]);
                System.out.println("\tDate of birth: " + database[i][1]);
                System.out.println("\tOccupation: " + database[i][2]);
            }
        }
        scan.close();
    }

    /**
     * 
     * Function name: print2DArray
     * 
     * @param array (String[][])
     * 
     * Inside the function
     *  1. print the database
     *     • a tab of space precedes each row.
     *     • each value in database has one space from the other value. 
     *     • print a new line.
     */
    public static void print2DArray(String[][] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
