import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.*;

public class Main {

    static Store store = new Store();
    static Cart cart = new Cart();

    /**
    * Name: loadItems
    * @param fileName (String)
    * @throws FileNotFoundException
    *
    * Inside the function:
    *   1. loads items from <fileName>.
    *      - while loop runs through every line in <fileName>
    *      - scan.nextLine() picks up the entire line.
    *      - splits each String using the ";" separator.
    *      - splits both fields in each String using the "=" separator.
    *      - Parse each price into a Double.
    *   2. adds all items to the store object's items field.
    */
    public static void loadItems(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);
        for (int i = 0; scan.hasNextLine(); i++) {
            String line = scan.nextLine();
            String[] items = line.split(";");
            
            for (int j = 0; j < items.length; j++) {
                String[] fields = items[j].split("=");
                store.setItem(i, j, new Item(fields[0], Double.parseDouble(fields[1])));
            }
    }
    scan.close();
}


    public static void main(String[] args) {
        try{
            loadItems("products.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            // System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            // System.out.println(store);
        }

    }


}
