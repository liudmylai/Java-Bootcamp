package models;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.stream.Collectors;

import models.Trade.Stock;

public abstract class Account {

    private double funds;
    private HashMap<Stock, Integer> portfolio;

    public double getFunds() {
        return this.funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public Integer getShares(Stock stock) {
        return this.portfolio.get(stock);
        // return this.portfolio.entrySet().stream()
        //        .filter(entry -> entry.getKey().equals(stock))
        //        .findFirst()
        //        .orElse(null)
        //        .getValue(); 
    }

    public void setShares(Stock stock, int shares) {
        this.portfolio.put(stock, shares);
    }

    public Account(double funds) {
        this.funds = funds;
        this.portfolio = new HashMap<Stock, Integer>();
        this.portfolio.put(Stock.AAPL, 0);
        this.portfolio.put(Stock.FB, 0);
        this.portfolio.put(Stock.GOOG, 0);
        this.portfolio.put(Stock.TSLA, 0); 
    }

    public Account(Account source) {
        this.funds = source.funds;
        this.portfolio = (HashMap<Stock, Integer>)source.portfolio.entrySet().stream()
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }

    public abstract boolean makeTrade(Trade trade);

    public boolean executeBuy(Trade trade, double fee) {
        double amount = trade.getPrice() * trade.getShares();
        if ((amount + amount * fee) > this.funds) {
            return false;
        }
        setFunds(this.funds - amount - amount * fee);
        setShares(trade.getStock(), getShares(trade.getStock()) + trade.getShares());
        return true;
    }

    public boolean executeBuy(Trade trade) {
        return executeBuy(trade, 0);
    }

    public boolean executeSell(Trade trade, double fee) {
        if (getShares(trade.getStock()) < trade.getShares()) {
            return false;
        }
        double amount = trade.getPrice() * trade.getShares();
        setFunds(getFunds() + amount - amount * fee);
        setShares(trade.getStock(), getShares(trade.getStock()) - trade.getShares());
        return true;
    }

    public double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }
}