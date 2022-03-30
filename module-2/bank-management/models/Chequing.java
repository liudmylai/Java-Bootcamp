package models;

import java.util.Objects;

import interfaces.Taxable;

public class Chequing extends Account implements Taxable {

    static final double FEE = 5.50;

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }


    @Override
    public void withdraw(double amount) {
        if ((amount - super.getBalance()) > 200) {
            System.out.println("\nOverdraft limit is $200.00");
        } else if (amount > super.getBalance()) {
            super.setBalance(super.getBalance() - amount - FEE);
        } 
        else {
            super.setBalance(super.getBalance() - amount);
        }
    }

    @Override
    public double calculateTax(double num) {
        return num * 0.15;
    }

    @Override
    public void deposit (double amount) {
        double income = super.getBalance() + amount; 
        if(income > 3000) {
            super.setBalance(income - calculateTax(income));
        } else {
            super.setBalance(income);
        }
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
