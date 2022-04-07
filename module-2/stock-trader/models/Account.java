package models;

import java.util.HashMap;
import java.util.stream.Collectors;

import models.Trade.Stock;

public abstract class Account {

    private double funds;
    private HashMap<String, Integer> portfolio;

    public double getFunds() {
        return this.funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public Integer getShares(String stock) {
        return this.portfolio.entrySet().stream()
               .filter(entry -> entry.getKey().equals(stock))
               .findFirst()
               .orElse(null)
               .getValue(); 
    }

    public void setShares(String stock, int shares) {
        this.portfolio.put(stock, shares);
    }

    public Account(double funds) {
        this.funds = funds;
        this.portfolio = new HashMap<String, Integer>();
        this.portfolio.put(Stock.AAPL, 0);
        this.portfolio.put(Stock.FB, 0);
        this.portfolio.put(Stock.GOOG, 0);
        this.portfolio.put(Stock.TSLA, 0); 
    }
    
    public Account(Account source) {
        this.funds = source.funds;
        this.portfolio = (HashMap<String, Integer>)source.portfolio.entrySet().stream()
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }
}