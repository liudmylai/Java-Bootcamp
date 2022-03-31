package models;

import java.util.Objects;


public class Loan extends Account {

    private static final double RATE = 0.02;
    private static final double MAX_DEBT = 10000;


    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }
    public Loan(Loan source) {
        super(source);
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.getBalance() + amount > MAX_DEBT) {
            return false;
        }
            super.setBalance(super.round(super.getBalance() + amount + (amount * RATE)));
        return true;


    }

    @Override
    public void deposit (double amount) {
        super.setBalance(super.round(super.getBalance() - amount));
    }
    
    // @Override
    // public double calculateTax(double num) {
    //     return num * 0.02;
    // }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Loan)) {
            return false;
        }
        Loan loan = (Loan) o;
        return super.getId() == loan.getId() &&
               super.getName().equals(loan.getName()) &&
               super.getBalance() == loan.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), super.getName(), super.getBalance());
    }
}
