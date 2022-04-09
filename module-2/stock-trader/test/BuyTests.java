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
        assertEquals(5, accounts[0].getShares(Stock.AAPL));
    }

    @Test
    public void tfsaShares() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        assertEquals(5, accounts[1].getShares(Stock.AAPL));
    }

    @Test
    public void personalInsuffientFunds() {
        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 1000));
        assertEquals(0, accounts[0].getShares(Stock.AAPL));
    }

    @Test
    public void tfsaInsuffientFunds() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 1000));
        assertEquals(0, accounts[1].getShares(Stock.AAPL));
    }

    @Test
    public void personalFunds() {
        accounts[0].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        assertEquals(1000 - 15.649286 * 5, accounts[0].getFunds());
    }

    @Test
    public void TFSAFunds() {
        accounts[1].makeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 15.649286, 5));
        assertEquals(1000 - 15.649286 * 5 - 15.649286 * 5 * TFSA.TRADE_FEE, accounts[1].getFunds());
    }
}
