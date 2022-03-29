public abstract class Account {
    private int id;
    private String name;
    private double balance;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getBalance() {
        return this.balance;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // public String toString() {
    //     return "\nAccount ID: " + this.id +
    //            "\nAccount name: " + this.name +
    //            "\nBalance: " + this.balance; 
    // }

    public abstract void withdraw(double amount);

    public abstract void deposit (double amount);
     
}
