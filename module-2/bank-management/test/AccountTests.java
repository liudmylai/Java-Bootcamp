package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.Account;
import models.Chequing;
import models.Loan;
import models.Savings;

public class AccountTests {

    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] {
            new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", 1524.51),
            new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", 2241.60),
            new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5", "Phoebe Buffay", 2537.31)
        };
    }

    @Test
    public void withdrawal() {
        accounts[0].withdraw(1440);
        assertEquals(84.51, accounts[0].getBalance());
    }

    @Test
    public void overdraft() {
        accounts[0].withdraw(1534.43);
        assertEquals(-15.42, accounts[0].getBalance());
    }

    @Test
    public void overdraftLimit() {
        accounts[0].withdraw(1726);
        assertEquals(1524.51, accounts[0].getBalance());

    }

    @Test
    public void deposit() {
        accounts[0].deposit(5000);
        assertEquals(6524.51, accounts[0].getBalance());
    }


    
}
