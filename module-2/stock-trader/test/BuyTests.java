package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.*;
import models.Trade.*;

public class BuyTests {
    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] { new Personal(1000), new TFSA(1000)};
    }

    @Test
    public void personalShares() {
        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        assertEquals(accounts[0].getShares(Stock.AAPL), 5);
    }

    @Test
    public void tfsaShares() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        assertEquals(accounts[1].getShares(Stock.AAPL), 5);
    }

    @Test
    public void personalInsuffientFunds() {
        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 1000));
        assertEquals(accounts[0].getShares(Stock.AAPL), 0);
    }

    @Test
    public void tfsaInsuffientFunds() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 1000));
        assertEquals(accounts[1].getShares(Stock.AAPL), 0);
    }

    @Test
    public void personalFunds() {
        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        assertEquals(accounts[0].getFunds(), 1000 - 15.649286 * 5);
    }

    @Test
    public void TFSAFunds() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        assertEquals(accounts[1].getFunds(), 1000 - 15.649286 * 5 - 15.649286 * 5 * TFSA.TRADE_FEE);
    }
}
