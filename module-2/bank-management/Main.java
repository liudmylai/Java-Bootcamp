import java.util.concurrent.TimeUnit;

import models.*;


public class Main {

    static String ACCOUNTS_FILE = ".\\data\\accounts.txt";            
    static String TRANSACTIONS_FILE = ".\\data\\transactions.txt";
    static Bank bank = new Bank();

    public static void main(String[] args) {
    

    }

    /**
     * Function name: wait
     * @param milliseconds
     * 
     * Inside the function:
     *  1. Makes the code sleep for X milliseconds.
     */

     public static void wait(int milliseconds) {
         try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
         } catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }
     }
    /**
     * Name: createObject
     * @param values (String[] values)
     * @return Account
     * 
     * Inside the function:
     *   1. Dynamically creates a Chequing, Loan, or Savings object based on the values array. 
     */
    public static Account createObject(String[] values) {
            try {
            return (Account)Class.forName("models." + values[0])
            .getConstructor(String.class, String.class, double.class)
            .newInstance(values[1], values[2], Double.parseDouble(values[3]));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}