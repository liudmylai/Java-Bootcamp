package models;

public class Trade {
    public enum Stock {AAPL, FB, GOOG, TSLA};
    public enum Type {MARKET_BUY, MARKET_SELL};
    private Type type;
    private Stock stock;
    private int shares;
    private double price;

    public double getPrice() {
        return this.price;
    }
    public int getShares() {
        return this.shares;
    }
    public Stock getStock() {
        return this.stock;
    }
    public Type getType() {
        return this.type;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setShares(int shares) {
        this.shares = shares;
    }
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public Trade(Stock stock, Type type, int shares, double price) {
        this.stock = stock;
        this.type = type;
        this.shares = shares;
        this.price = price;
    }
    public Trade(Trade source) {
        this.stock = source.stock;
        this.type = source.type;
        this.shares = source.shares;
        this.price = source.price;
    }
}
