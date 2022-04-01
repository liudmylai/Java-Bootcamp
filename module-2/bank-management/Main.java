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

}