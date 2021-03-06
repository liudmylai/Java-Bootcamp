package models;

import java.util.Objects;

import interfaces.Taxable;

public class Chequing extends Account implements Taxable {

    static final double FEE = 5.50;
    static final double LIMIT = 200;
    static final double TAXABLE_INCOME = 3000;
    static final double TAX_RATE = 0.15;
   

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Chequing(this);
    }


    @Override
    public boolean withdraw(double amount) {
        if ((amount - super.getBalance()) > LIMIT) {
            System.out.println("\nOverdraft limit is $200.00");
            return false;
        } else if (amount > super.getBalance()) {
            super.setBalance(super.round(super.getBalance() - amount - FEE));
        } 
        else {
            super.setBalance(super.round(super.getBalance() - amount));
        }
        return true;
    }

    @Override
    public void tax (double income) {
        double tax = Math.max(0, income - TAXABLE_INCOME) * TAX_RATE;
        super.setBalance(super.round(super.getBalance() - tax));
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() + amount));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Chequing)) {
            return false;
        }
        Chequing chequing = (Chequing) o;
        return super.getId() == chequing.getId() &&
               super.getName().equals(chequing.getName()) &&
               super.getBalance() == chequing.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), super.getName(), super.getBalance());
    }

  


}
