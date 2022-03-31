package models;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Transaction implements Comparable<Transaction>{
    
    public enum Type {WITHDRAW, DEPOSIT};
    private Type type;
    private long timestamp;
    private String id;
    private double amount;

    public Transaction(long timestamp, Type type, String id, double amount) {
        if(id == null || id.isBlank() || amount < 0) {
            throw new IllegalArgumentException("INVALID PARAMS");
        }
        this.timestamp = timestamp;
        this.type = type;
        this.id = id;
        this.amount = amount;
    }
    public Transaction(Transaction source) {
        this.timestamp = source.timestamp;
        this.type = source.type;
        this.id = source.id;
        this.amount = source.amount;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
    public Type getType() {
        return this.type;
    }
    public String getId() {
        return this.id;
    }
    public double getAmount() {
        return this.amount;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setId(String id) {
        if(id == null || id.isBlank()) {
            throw new IllegalArgumentException("INVALID ID");
        }
        this.id = id;
    }
    public void setAmount(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("INVALID AMOUNT");
        }
        this.amount = amount;
    }

    public String returnDate() {
        Date date = new Date(this.timestamp * 1000);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    @Override
    public boolean equals(Object o) {
        if ( o == this)
            return true;
        if (!(o instanceof Transaction))
            return false;
        Transaction transaction = (Transaction) o;
        return Objects.equals(type, transaction.type) && 
                              timestamp == transaction.timestamp &&
                              Objects.equals(id, transaction.id) &&
                              amount == transaction.amount;                      
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }

    @Override
    public String toString() {
        return (type) + "    " +
        "\t" + this.returnDate() + "" +
        "\t" + this.getId() + "" +
        "\t$" + this.getAmount() + "";
    }

}
