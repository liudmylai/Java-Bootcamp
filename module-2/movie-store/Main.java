import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.*;

public class Main {

    static Store store = new Store();

    /**
     * Name: loadMovies
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     * 
     * Inside the function:
     * 1. loads movies from <fileName>.txt
     * 2. adds all movies to the store object's movie field
     */
    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            String[] data = scan.nextLine().split("--");
            Movie movie = new Movie(data[0], data[1], Double.parseDouble(data[2]));
            store.addMovie(movie);
        }
        scan.close();
    }

    /**
     * Name: manageMovies
     * Inside the function:
     * 1. Starts a new instance of Scanner
     * 2. In an infinite loop, the user can choose to a) purchase or b) rent c) return.
     *    case a: ask for the name and sell them the movie.
     *    case b: ask for the name and rent them the movie.
     *    case c: ask for the name and return the movie.
     * 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scanResponse = new Scanner(System.in);
        while (true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return.");
            String response = scanResponse.nextLine();

            if (!(response.equals("a") || response.equals("b") || response.equals("c"))) {
                scanResponse.close();
                break;
            }

            System.out.print("Enter the name of the movie: ");
            String name = scanResponse.nextLine();
            if(name.isBlank()) {
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }
            switch (response) {
                case "a":
                    if (!(store.getMovie(name).getIsAvailable())) {
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                        continue;
                    }
                    store.action(name, "sell");
                    break;
                case "b":
                    store.action(name, "rent");
                    break;
                case "c":
                    store.action(name, "return");
                    break;
            }
            System.out.println("\n\nUPDATED MOVIES\n\n" + store);
        }
    }

    public static void main(String[] args) {
        try {
            loadMovies("./movies.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("MOVIES LOADED\n\n" + store);
        }

        manageMovies();

    }
}
