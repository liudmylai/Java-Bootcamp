import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
 
    static String[] files = new String[] { "data\\sales1.txt", "data\\sales2.txt", "data\\sales3.txt"};
   
    static int sampleSize = 0;
    static int quantitySold = 0;


    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);
            ExecutorService executor = Executors.newFixedThreadPool(3);
            for (String string : files) {
                executor.submit(() -> increment(string, latch));
            }

        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name to access the Global Superstore data: ");
        String name = scan.nextLine();
        System.out.println("\nThank you " + name + ".\n");
        scan.close();

        latch.await();
        executor.shutdown();

        System.out.println("Sample size: " + sampleSize);
        System.out.println("Quantity sold: " + quantitySold);

        // Sample size: 1522889
        // Quantity sold: 8818065
     
    }

    /**
     * Function name: increment
     * @param file
     * 
     * Inside the function:
     *   1. Runs through every line in the file.
     *   2. Maps each element in the stream to a quantity value.
     *   3. Increments sampleSize and quantitySold.
     */
    public static void increment(String file, CountDownLatch latch) {
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(file).toURI());
            Files.lines(path)
                .skip(1)
                .mapToInt(line -> Integer.parseInt(line.split(",")[2]))
                .forEach(quantity -> {
                    sampleSize++;
                    quantitySold += quantity;
                });
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        latch.countDown();
    }


}