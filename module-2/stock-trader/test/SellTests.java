package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.*;
import models.Trade.*;

public class SellTests {
    
    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] { new Personal(1000), new TFSA(1000)};
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        }
    }

    @Test
    public void personalShares() {
        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_SELL, 15.649286, 3));
        assertEquals(2, accounts[0].getShares(Stock.AAPL));
    }

    @Test
    public void tfsaShares() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_SELL, 15.649286, 5));
        assertEquals(0, accounts[1].getShares(Stock.AAPL));
    }

    @Test
    public void personalInsuffientShares() {
        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_SELL, 15.649286, 6));
        assertEquals(5, accounts[0].getShares(Stock.AAPL));
    }

    @Test
    public void tfsaInsuffientShares() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_SELL, 15.649286, 6));
        assertEquals(5, accounts[1].getShares(Stock.AAPL));
    }

    @Test
    public void personalFunds() {
        double currentBalance = accounts[0].getFunds();

        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_SELL, 15.649286, 5));
        assertEquals(currentBalance + (15.649286 * 5) - (15.649286 * 5 * Personal.SELL_FEE), accounts[0].getFunds());
    }

    @Test
    public void TFSAFunds() {
        double currentBalance = accounts[1].getFunds();

        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_SELL, 15.649286, 5));
        assertEquals(currentBalance + (15.649286 * 5) - (15.649286 * 5 * TFSA.TRADE_FEE), accounts[1].getFunds());
    }
}
