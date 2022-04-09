package models;

import models.Trade.Type;

public class TFSA extends Account {
    
    public static final double TRADE_FEE = 0.01;

    public TFSA (double funds) {
        super(funds);
    }
    public TFSA (TFSA source) {
        super(source);
    }
    
    @Override
    public boolean makeTrade(Trade trade) {
        if (Type.MARKET_BUY.equals(trade.getType())) {
            return executeBuy(trade, TRADE_FEE);
        }
        if (Type.MARKET_SELL.equals(trade.getType())) {
            return executeSell(trade, TRADE_FEE);
        }
        return false;
    } 
}
