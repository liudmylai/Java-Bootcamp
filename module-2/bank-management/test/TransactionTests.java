package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.Transaction;

public class TransactionTests {
    Transaction transaction;

    @Before
    public void setup() {
        transaction = new Transaction(1546905600, Transaction.Type.WITHDRAW , "6b8dd258-aba3-4b19-b238-45d15edd4b48", 624.99);
    }

    @Test
    public void correctDateTest() {
        assertEquals("07-01-2019",transaction.returnDate());
    }
}
