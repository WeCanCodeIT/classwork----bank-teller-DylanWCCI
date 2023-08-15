package teller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    void testOpenNewAccount() {
        Bank bank = new Bank();
        Account account = new Account("1111", "Checking", 500.0);
        bank.openNewAccount(account);
        assertEquals(1, bank.getAllAccounts().size());
    }

    @Test
    void testCloseAccount() {
        Bank bank = new Bank();
        Account account = new Account("1111", "Checking", 500.0);
        bank.openNewAccount(account);
        bank.closeAccount("1111");
        assertEquals(0, bank.getAllAccounts().size());
    }
}
