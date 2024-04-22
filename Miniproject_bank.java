//The program is a simple banking system written in Java.
//Account Creation:
//It allows the user to create multiple bank accounts by specifying an initial balance for each account.
//Transactions:
//Users can perform transactions (deposits or withdrawals) on their accounts.
//They choose the account number, transaction type (deposit or withdrawal), and the amount.
//If the withdrawal amount exceeds the account balance, it displays an “Insufficient funds” message.
//Display Balances:
//After each transaction, it shows the updated balance for the account involved.
//Finally, it displays the balances of all created accounts.

import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds. Withdrawal cancelled.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Miniproject_bank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter the number of accounts you want to create: ");
        int numAccounts = input.nextInt();

        for (int i = 0; i < numAccounts; i++) {
            System.out.print("Enter initial balance for account " + (i + 1) + ": $");
            double initialBalance = input.nextDouble();
            accounts.add(new BankAccount(initialBalance));
        }

        boolean continueTransaction = true;
        while (continueTransaction) {
            System.out.print("Do you want to perform a transaction? (1 for YES, 0 for NO): ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter the account number (1-" + numAccounts + "): ");
                int accountNumber = input.nextInt();

                System.out.print("Enter 1 for deposit or 0 for withdrawal: ");
                int transactionType = input.nextInt();

                System.out.print("Enter the amount: $");
                double amount = input.nextDouble();

                BankAccount account = accounts.get(accountNumber - 1);
                if (transactionType == 1) {
                    account.deposit(amount);
                    System.out.println("Updated balance: $" + account.getBalance());
                } else if (transactionType == 0) {
                    account.withdraw(amount);
                    System.out.println("Updated balance: $" + account.getBalance());
                } else {
                    System.out.println("Invalid transaction type. Please enter 1 for deposit or 0 for withdrawal.");
                }
            } else {
                continueTransaction = false;
            }
        }

        System.out.println("\nAccount balances:");
        for (int i = 0; i < numAccounts; i++) {
            System.out.println("Account " + (i + 1) + ": $" + accounts.get(i).getBalance());
        }
    }
}
