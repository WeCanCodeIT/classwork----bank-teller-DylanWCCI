package teller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void openNewAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void closeAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }
}
