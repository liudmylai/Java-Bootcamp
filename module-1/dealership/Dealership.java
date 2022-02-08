import java.util.Scanner;

public class Dealership {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Java Dealership");
        System.out.println(" - Select option 'a' to buy a car");
        System.out.println(" - Select option 'b' to sell a car");
        String option = scan.nextLine(); 
            switch (option) {
                case "a" :
                    System.out.println("\nWhat is your budget?");
                    int budget = scan.nextInt();
                    if (budget >= 10000) {
                        System.out.println("\nGreat! A Nissan Altima is available");
                        System.out.println("\nDo you have an insurance? Write 'yes' or 'no'");
                        scan.nextLine();
                        String insurance = scan.nextLine();
                        System.out.println("\nDo you have a driver license? Write 'yes' or 'no'");
                        String license = scan.nextLine();
                        System.out.println("\nWhat is your credit score?");
                        int creditScore = scan.nextInt();
                        if (insurance.equals("yes") && license.equals("yes") && creditScore > 660) {
                            System.out.println("\nSold! Pleasure doing business with you!");
                        } else {
                            System.out.println("\nWe're sorry. You are not eligible.");
                        }
                    } else {
                        System.out.println("\nWe don't sell cars under $10,000. Sorry!");
                    }
                    break;
                case "b":
                    System.out.println("\nWhat is your car valued at?");  
                    int value = scan.nextInt();
                    System.out.println("\nWhat is your selling price?");  
                    int price = scan.nextInt();
                    if (price < value && price < 30000) {
                        System.out.println("\nWe will buy your car. Pleasure doing business with you!");
                    } else {
                        System.out.println("\nSorry, we are not interested.");
                    }
                    break;
                default:
                    System.out.println("Invalid option");  
            }
        scan.close();    
    }
}