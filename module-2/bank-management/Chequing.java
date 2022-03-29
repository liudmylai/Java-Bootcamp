import java.util.Objects;

public class Chequing extends Account implements Taxable {

    static final double FEE = 5.50;
    static double tax = 0;

    public Chequing(int id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }

    @Override
    public String toString() {
        return "\nAccount ID: " + super.getId() +
               "\nAccount name: " + super.getName() +
               "\nBalance: " + super.getBalance() +
               "\nTax: " + tax; 
    }

    @Override
    public void withdraw(double amount) {
        if(amount > this.getBalance() && (amount - this.getBalance()) < 200) {
             this.setBalance(this.getBalance() - amount - FEE);
        } else if (amount > this.getBalance() && (amount - this.getBalance()) >= 200) {
            System.out.println("Overdraft limit is $200.00");
        }
        else {
            this.setBalance(this.getBalance() - amount);
        }
    }

    @Override
    public double calculateTax(double num) {
        return num * 0.15;
    }

    @Override
    public void deposit (double amount) {
        double income = this.getBalance() + amount; 
        if(income > 3000) {
            tax = calculateTax(income);
            this.setBalance(income - tax);
        } else {
            this.setBalance(income);
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
