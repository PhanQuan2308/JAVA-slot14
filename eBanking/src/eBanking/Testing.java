package eBanking;

import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input account information
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter account holder name:");
        String accountHolderName = scanner.nextLine();

        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();

        // Create AccountBank object
        AccountBank account = new AccountBank(accountNumber, accountHolderName, balance);

        // Display account information
        account.displayAccountInfo();

        // Loop for transaction menu
        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    Transaction.deposit(account, depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    Transaction.withdraw(account, withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter recipient account number: ");
                    String recipientAccountNumber = scanner.next();

                    System.out.println("Enter recipient holder name: ");
                    String recipientHolderName = scanner.nextLine();

                    System.out.println("Enter transfer amount:");
                    double transferAmount = scanner.nextDouble();

                    AccountBank recipientAccount = new AccountBank(recipientAccountNumber, recipientHolderName, 0);
                    Transaction.transfer(account, recipientAccount, transferAmount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        // Display final account information
        account.displayAccountInfo();

        scanner.close();
    }
}
