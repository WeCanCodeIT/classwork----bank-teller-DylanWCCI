package teller;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account1 = new Account("1111", "Checking", 500.0);
        Account account2 = new Account("2222", "Savings", 100.0);
        bank.openNewAccount(account1);
        bank.openNewAccount(account2);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What would you like to do next?");
            System.out.println("Press 1 to deposit");
            System.out.println("Press 2 to withdrawal");
            System.out.println("Press 3 to check balance");
            System.out.println("Press 4 to close an account");
            System.out.println("Press 0 to exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You want to deposit.");
                    System.out.println("Type the account number to choose an account to deposit to.");
                    String accountNumber = scanner.nextLine();
                    Account accountToDeposit = bank.getAccount(accountNumber);
                    if (accountToDeposit != null) {
                        System.out.println("Enter the amount to deposit:");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        accountToDeposit.deposit(amount);
                        System.out.println("You deposited " + amount);
                        System.out.println("Your updated balance on account " + accountNumber + " is now " + accountToDeposit.getAccountBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                    case 2:
                    System.out.println("You want to withdraw.");
                    System.out.println("Type the account number to choose an account to withdraw from.");
                    String accountNumberWithdraw = scanner.nextLine();
                    Account accountToWithdraw = bank.getAccount(accountNumberWithdraw);
                    if (accountToWithdraw != null) {
                        System.out.println("Enter the amount to withdraw:");
                        double amountWithdraw = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline left-over
                        accountToWithdraw.withdraw(amountWithdraw);
                        System.out.println("You withdrew " + amountWithdraw);
                        System.out.println("Your updated balance on account " + accountNumberWithdraw + " is now " + accountToWithdraw.getAccountBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("You want to check balance.");
                    System.out.println("Type the account number to choose an account to check balance.");
                    String accountNumberBalance = scanner.nextLine();
                    Account accountToCheckBalance = bank.getAccount(accountNumberBalance);
                    if (accountToCheckBalance != null) {
                        System.out.println("The balance of account " + accountNumberBalance + " is " + accountToCheckBalance.getAccountBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;                
                case 4:
                    System.out.println("You would like to close an account.");
                    System.out.println("Enter the account number of the account you would like to close:");
                    String accountNumberToClose = scanner.nextLine();
                    if (bank.getAccount(accountNumberToClose) != null) {
                        bank.closeAccount(accountNumberToClose);
                        System.out.println("You are closing account # " + accountNumberToClose);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

