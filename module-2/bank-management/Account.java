
public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public Account(String id, String name, double balance) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("INVALID PARAMS");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getBalance() {
        return this.balance;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()) {
            throw new IllegalArgumentException("INVALID ID");
        }
        this.id = id;
    }
    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("INVALID NAME");
        }
        this.name = name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "    " +
            "\t" + this.getId() + "" +
            "\t" + this.getName() + "" +
            "\t$" + this.getBalance() + "";
    }

    public abstract void withdraw(double amount);

    public abstract void deposit (double amount);
     
}
