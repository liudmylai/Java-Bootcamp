import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    static final String SALES = "data\\sales.csv";

    public static void main(String[] args) {
        
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
            Thread thread2 = new Thread(() -> average(path, "Furniture"));
            Thread thread3 = new Thread(() -> average(path, "Technology"));
            Thread thread4 = new Thread(() -> average(path, "Office Supplies"));
            Thread thread5 = new Thread(() -> totalAverage(path));
            thread2.start();
            System.out.println(thread2.getState()); 
            thread2.interrupt();

            thread3.start();
            thread4.start();
            thread5.start();

            Thread.sleep(10);
            System.out.println(thread2.getState());

            // Scanner scan = new Scanner(System.in);
            // System.out.print("Please enter your name to access the Global Superstore dataset: ");
            // String name = scan.nextLine();
            // System.out.println("Access Denied. We apologize for the inconvenience. Have a good day " + name + ".");
            // scan.close();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function name: average
     * @param path (Path)
     * @param category (String)
     * @return Double
     * 
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three String values.
     *   3. Filters every value by the @param category
     *   4. Maps every element in the stream to a double (price * quantity).
     *   5. Applies the terminal operation average.
     *   6. Returns the average as double.
     * 
     */
    public static Double average(Path path, String category) {
        if (Thread.currentThread().isInterrupted()) {
            return 0.0;
        }
        try {
            return Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(arr -> arr[0].equals(category))
                    .mapToDouble(arr -> Double.parseDouble(arr[1]) * Double.parseDouble(arr[2]))
                    .average()
                    .getAsDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }

    /**
     * Function name: totalAverage
     * @param path (Path)
     * @return Double
     * 
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three values.
     *   3. Maps every element in the stream to a double: (price * quantity).
     *   4. Applies the terminal operation average.
     *   5. Returns the average as double.
     */
    public static Double totalAverage(Path path) {
        try {
            return Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .mapToDouble(arr -> Double.parseDouble(arr[1]) * Double.parseDouble(arr[2]))
                    .average()
                    .getAsDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }

}