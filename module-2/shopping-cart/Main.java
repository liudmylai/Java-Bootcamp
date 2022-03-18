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
    * 1. loads items from <fileName>.
    *    - while loop runs through every line in <fileName>
    *    - scan.nextLine() picks up the entire line.
    *    - splits each String using the ";" separator.
    *    - splits both fields in each String using the "=" separator.
    *    - Parse each price into a Double.
    * 2. adds all items to the store object's items field.
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
    /**
    * Name: manageItems 
    * Inside the function:
    * 1. Starts a new instance of Scanner;
    * 2. Creates an infinite loop:
    * The user can choose to a) add or b) remove c) checkout.
    *   case a: asks for the aisle and item number. Then, adds item to cart.
    *   case b: asks for the name. Then, removes item from cart.
    *   case c: prints the receipt and closes Scanner.
    * Prints the updated shopping cart.
    */
    public static void manageItems() {
        Scanner scanResponse = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String response = scanResponse.nextLine();
            switch (response) {
                case "a" :
                    System.out.print("\nChoose an aisle number between: 1 - 7: ");
                    int row = scanResponse.hasNextInt() ? scanResponse.nextInt() - 1 : 404;
                    scanResponse.nextLine();
                    System.out.print("Choose an item number between: 1 - 3: ");
                    int column = scanResponse.hasNextInt() ? scanResponse.nextInt() - 1 : 404;
                    scanResponse.nextLine();
                    // InputMismatchException
                    if (row == 404 || column == 404) {
                        continue;                      // restart the while loop
                    //  ArrayIndexOutOfBoundsException   
                    } else if (row < 0 || row > 6 || column < 0 || column > 2) {
                        continue;
                    }

                    Item item = store.getItem(row, column);
                    if (cart.add(item)) {
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    } else {
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }
                    break;
                case "b" :
                    // IllegalStateException
                    if (cart.isEmpty()) {
                        continue;
                    }
                    System.out.print("Enter the item you'd like to remove: ");
                    String name = scanResponse.nextLine();
                    cart.remove(name);
                    break;
                case "c" : 
                     // IllegalStateException
                     if (cart.isEmpty()) {
                        continue;
                    }
                    System.out.println(cart.checkOut());
                    scanResponse.close();
                    return;
                default: 
                    continue;
            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            scanResponse.nextLine();
        }
    }

    public static void main(String[] args) {
        try{
            loadItems("products.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            manageItems();
        }

    }


}
