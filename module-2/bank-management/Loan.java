import java.util.Objects;

public class Loan extends Account implements Taxable {


    public Loan(int id, String name, double balance) {
        super(id, name, balance);
    }
    public Loan(Loan source) {
        super(source);
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBalance() <= 10000) {
            super.setBalance(super.getBalance() - amount - calculateTax(amount));
        } else {
            System.out.println("The withdrawal can't be made");
        }

    }

    @Override
    public void deposit (double amount) {
        super.setBalance(super.getBalance() + amount);
    }
    
    @Override
    public double calculateTax(double num) {
        return num * 0.02;
    }
    
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
