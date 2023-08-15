package teller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void testDeposit() {
        Account account = new Account("1111", "Checking", 500.0);
        account.deposit(500.0);
        assertEquals(1000.0, account.getAccountBalance());
    }

    @Test
    void testWithdraw() {
        Account account = new Account("1111", "Checking", 500.0);
        account.withdraw(200.0);
        assertEquals(300.0, account.getAccountBalance());
    }
}
