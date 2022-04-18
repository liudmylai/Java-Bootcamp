import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    static final String SALES = "data\\sales.csv";

    static double furniture = 0;
    static double technology = 0;
    static double supplies = 0;
    static double average = 0;


    public static void main(String[] args) {
        
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
          
            Thread thread2 = new Thread(() -> furniture = average(path, "Furniture"));
            Thread thread3 = new Thread(() -> technology = average(path, "Technology"));
            Thread thread4 = new Thread(() -> supplies = average(path, "Office Supplies"));
            Thread thread5 = new Thread(() -> average = totalAverage(path));
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");
            String name = scan.nextLine();

            try {
                thread2.join();
                thread3.join();
                thread4.join();
                thread5.join();
                
                System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
                System.out.println("Average Furniture Sales: " + furniture);
                System.out.println("Average Technology Sales: " + technology);
                System.out.println("Average Office Supplies Sales: " + supplies);
                System.out.println("Total Average: " + average);
                
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            scan.close();

          
        } catch (URISyntaxException e) {
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