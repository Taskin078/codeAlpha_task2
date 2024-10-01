
import java.util.Scanner;

class BankAccount {
    private double balance;
    private String customerName;

    // Constructor
    public BankAccount(String customerName, double initialBalance) {
        this.customerName = customerName;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Simple Banking Application!");

        // Get customer name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Initialize account with zero balance
        BankAccount account = new BankAccount(name, 0);

        int choice;
        do {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Deposit money
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    // Withdraw money
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    // Check balance
                    account.checkBalance();
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
