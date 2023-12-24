import java.util.Scanner;

// Class to represent the users bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Successful withdrawal
        } else {
            return false; // Insufficient funds
        }
    }
}
/////Class to represent the ATM machine
class ATM {
    private BankAccount userAccount;
    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                break;

            case 3:
                System.out.println("Current Balance: " + userAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                scanner.close();
                System.exit(0);

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATMinterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the user's bank account with a balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // Initialize the ATM with the user's bank account
        ATM atmMachine = new ATM(userAccount);

        while (true) {
            System.out.println("\nWelcome to the ATM");
            atmMachine.displayOptions();
            System.out.print("Choose an option (1-4): ");
            int option = scanner.nextInt();
            atmMachine.processOption(option);
        }
       
    } 
}