package models;

import models.Trade.Type;

public class Personal extends Account {

    public Personal(double funds) {
        super(funds);
    }
    public Personal(Personal source) {
        super(source);
    }

    @Override
    public boolean makeTrade(Trade trade) {
        if (Type.MARKET_BUY.equals(trade.getType())) {
            return executeBuy(trade);
        }
        return false;
    }

}
