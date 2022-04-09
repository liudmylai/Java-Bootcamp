package models;

import models.Trade.Type;

public class Personal extends Account {

    public static final double SELL_FEE = 0.05;

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
        if (Type.MARKET_SELL.equals(trade.getType())) {
            return executeSell(trade, SELL_FEE);
        }
        return false;
    }

}
