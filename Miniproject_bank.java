import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void depositMoney(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdrawMoney(Account account, double amount) {
        account.withdraw(amount);
    }

    public void displayAccounts() {
        System.out.println("Accounts in the bank:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}

public class Miniproject_bank {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        // Create and add some accounts
        Account account1 = new Account("12345");
        Account account2 = new Account("67890");
        myBank.addAccount(account1);
        myBank.addAccount(account2);

        // Deposit and withdraw money
        myBank.depositMoney(account1, 1000.0);
        myBank.withdrawMoney(account2, 200.0);

        // Display all accounts
        myBank.displayAccounts();
    }
}