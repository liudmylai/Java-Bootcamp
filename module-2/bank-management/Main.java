import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import models.*;


public class Main {

    static String ACCOUNTS_FILE = ".\\data\\accounts.txt";            
    static String TRANSACTIONS_FILE = ".\\data\\transactions.txt";
    static Bank bank = new Bank();

    public static void main(String[] args) {
        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t"+ account +"\n\n");
                transactionHistory(account.getId());
            }
            
         } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
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

    /**
     * Name: returnAccounts()
     * @return ArrayList<Account>
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *    1. Creates a Scanner object and reads the data from accounts.txt.
     *    2. Creates an Account object for every line in accounts.txt.
     *    3. Returns an ArrayList of Account objects.
     */
    public static ArrayList<Account> returnAccounts() throws FileNotFoundException {
        ArrayList<Account> accounts = new ArrayList<Account>();
        FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            accounts.add(createObject(line.split(",")));
        }
        scan.close();
        return accounts;
    }

    /**
     * Name: loadAccounts
     * @param accounts (ArrayList<Account>)
     * 
     * Inside the function:
     *   1. Loads every account into the Bank object.
     *  
     */
    public static void loadAccounts(ArrayList<Account> accounts) {
        accounts.stream().forEach(account -> bank.addAccount(account));
    }

    /**
     * Name: returnTransactions()
     * @return ArrayList<Transaction>
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *    1. Creates a Scanner object and reads the data from transactions.txt.
     *    2. Populates an ArrayList with transaction objects.
     *    3. Sorts the ArrayList.
     */
    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            String[] values = scan.nextLine().split(",");
            transactions.add(new Transaction(Transaction.Type.valueOf(values[1]), Long.parseLong(values[0]), values[2], Double.parseDouble(values[3])));
        }
        Collections.sort(transactions);
        scan.close();
        return transactions;
    }

    /**
     * Name: runTransactions
     * @param transactions ArrayList<Transaction>
     * 
     * Inside the function:
     *  1. Executes every transaction using bank.execute.
     */
    public static void runTransactions(ArrayList<Transaction> transactions) {
        transactions.stream().forEach(transaction -> bank.executeTransaction(transaction));
    }

    /**
     * Name: transactionHistory
     * @param id (String)
     * 
     * Inside the function
     *   1. Print: \t\t\t\t   TRANSACTION HISTORY\n\t
     *   2. Print every transaction that corresponds to the id. (Waits 300 milliseconds before printing the next one)
     *             - Use this format "\t"+transaction+"\n"
     *   3. Print: \n\t\t\t\t\tAFTER TAX\n
     *   4. Print: "\t" + account that corresponds to id +"\n\n\n\n"
     */
    public static void transactionHistory(String id) {
        System.out.println("\t\t\t\t   TRANSACTION HISTORY\n\t");
        for (Transaction transaction : bank.getTransactions(id)) {
            wait(300);
            System.out.println("\t"+ transaction +"\n");      
        }
        System.out.println("\n\t\t\t\t\tAFTER TAX\n");
        System.out.println("\t" + bank.getAccount(id) +"\n\n\n\n");
    }
}