package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.Taxable;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<Account>();
        this.transactions = new ArrayList<Transaction>();
    }

    /**
     * Name: addAccount
     * @param account (Account)
     * 
     * Inside the function:
     *   1. adds an account to the accounts ArrayList
     */
    public void addAccount(Account account) {
        this.accounts.add(account.clone());
    }

    /**
     * Name: addTransaction
     * @param transaction
     * 
     * Inside the function:
     *   1. adds a new transaction object to the array list.
     */
    private void addTransaction(Transaction transaction) {
        this.transactions.add(new Transaction(transaction));
    }

    /**
     * Name: getTransactions
     * @param accoundId (String)
     * @return (Transaction[])
     * 
     * 1. returns an array of transactions whose id matches the accountId 
     */
    public Transaction[] getTransactions(String accoundId) {
        List<Transaction> list = this.transactions.stream()
        .filter(transaction -> transaction.getId().equals(accoundId))
        .collect(Collectors.toList());
       
        return list.toArray(new Transaction[list.size()]);
    }
    /**
     * Name: getAccount()
     * @param transactionId (String)
     * @return (Account)
     * 
     * 1. returns an account whose id matches a transaction. 
     */
    public Account getAccount(String transactionId) {
        return accounts.stream()
        .filter(account -> account.getId().equals(transactionId))
        .findFirst()
        .orElse(null);
    }

    private void withdrawTransaction(Transaction transaction) {
        if (getAccount(transaction.getId()).withdraw(transaction.getAmount())) {
            addTransaction(transaction);
        }
    }

    private void depositTransaction (Transaction transaction) {
        getAccount(transaction.getId()).deposit(transaction.getAmount());
        addTransaction(transaction);
    }

    /**
     * Name: executeTransaction
     * @param transaction
     * 
     * Inside the function:
     *  1. calls withdrawTransaction if transaction type is WITHDRAW
     *  2. calls depositTransaction if transaction type is DEPOSIT
     * 
     */
    public void executeTransaction(Transaction transaction) {
        switch (transaction.getType()) {
            case WITHDRAW: 
                withdrawTransaction(transaction);
                break;
            case DEPOSIT:
                depositTransaction(transaction);
                break;
        }
    }
    /**
     * Name: getIncome
     * @param account (Taxable)
     * @return double
     * 
     * Inside the function:
     *   1. Gets every transaction that matches the account's id.
     *   2. Maps every transaction to a double.
     *       - Transactions of type WITHDRAW are mapped to negative numbers.
     *       - Transactions of type DEPOSIT are mapped to positive numbers.
     *   3. Takes the sum of every number and returns the income.
     * 
     */
    private double getIncome(Taxable account) {
        return transactions.stream()
        .filter(transaction -> transaction.getId().equals(((Chequing)account).getId()))
        .mapToDouble(transaction -> {
            switch(transaction.getType()) {
                case WITHDRAW:
                    return -transaction.getAmount();
                case DEPOSIT:
                    return transaction.getAmount();
                default:
                    return 0;
            }
        })
        .sum(); 
    }

    public void deductTaxes() {
        accounts.stream()
        .filter(account -> Taxable.class.isAssignableFrom(account.getClass()))
        .forEach(account -> {
            Taxable taxable = (Taxable) account;
            taxable.tax(getIncome(taxable));
        });
        // for (Account account: accounts) {
        //     if(Taxable.class.isAssignableFrom(account.getClass())) {
        //         Taxable taxable = (Taxable) account;
        //         taxable.tax(getIncome(account));
        //     }
        // }
    }




}
