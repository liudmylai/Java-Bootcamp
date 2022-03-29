import java.util.Objects;

public class Savings extends Account {

    static final double FEE = 5.00;
    double totalFee = 0;
    
    public Savings(int id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Savings source) {
        super(source);
    }

    @Override
    public String toString() {
        return "\nAccount ID: " + super.getId() +
               "\nAccount name: " + super.getName() +
               "\nBalance: " + super.getBalance() +
               "\nFee: " + totalFee; 
    }

    @Override
    public void deposit (double amount) {
        super.setBalance(super.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        super.setBalance(super.getBalance() - amount - FEE);
        totalFee += FEE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Savings)) {
            return false;
        }
        Savings savings = (Savings) o;
        return super.getId() == savings.getId() &&
               super.getName().equals(savings.getName()) &&
               super.getBalance() == savings.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), super.getName(), super.getBalance());
    }

}
