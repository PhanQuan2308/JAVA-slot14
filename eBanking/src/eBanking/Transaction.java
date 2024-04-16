package eBanking;



public class Transaction {
    // Method to deposit money
    public static void deposit(AccountBank account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    // Method to withdraw money
    public static void withdraw(AccountBank account, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("Invalid amount for withdrawal or insufficient balance.");
        }
    }

    // Method to transfer money to another account
    public static void transfer(AccountBank sender, AccountBank recipient, double amount) {
        if (amount > 0 && amount <= sender.getBalance()) {
            sender.setBalance(sender.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
            System.out.println("Transfer successful. Current balance: $" + sender.getBalance());
        } else {
            System.out.println("Invalid amount for transfer or insufficient balance.");
        }
    }
}

