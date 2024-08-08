package task;

import java.util.Scanner;

//Class to represent the User's Bank Account
class BankAccount {
private double balance;

public BankAccount(double initialBalance) {
   this.balance = initialBalance;
}

public double getBalance() {
   return balance;
}

public void deposit(double amount) {
   if (amount > 0) {
       balance += amount;
       System.out.println("Successfully deposited: $" + amount);
   } else {
       System.out.println("Invalid deposit amount.");
   }
}

public boolean withdraw(double amount) {
   if (amount > 0 && amount <= balance) {
       balance -= amount;
       System.out.println("Successfully withdrew: $" + amount);
       return true;
   } else {
       System.out.println("Insufficient balance or invalid withdrawal amount.");
       return false;
   }
}
}

//Class to represent the ATM Machine
class ATM {
private BankAccount account;

public ATM(BankAccount account) {
   this.account = account;
}

public void displayMenu() {
   System.out.println("ATM Menu:");
   System.out.println("1. Check Balance");
   System.out.println("2. Deposit");
   System.out.println("3. Withdraw");
   System.out.println("4. Exit");
}

public void start() {
   Scanner scanner = new Scanner(System.in);
   int choice;
   do {
       displayMenu();
       System.out.print("Choose an option: ");
       choice = scanner.nextInt();
       switch (choice) {
           case 1:
               checkBalance();
               break;
           case 2:
               System.out.print("Enter deposit amount: ");
               double depositAmount = scanner.nextDouble();
               deposit(depositAmount);
               break;
           case 3:
               System.out.print("Enter withdrawal amount: ");
               double withdrawalAmount = scanner.nextDouble();
               withdraw(withdrawalAmount);
               break;
           case 4:
               System.out.println("Thank you for using the ATM. Goodbye!");
               break;
           default:
               System.out.println("Invalid option. Please try again.");
       }
   } while (choice != 4);
   scanner.close();
}

private void checkBalance() {
   System.out.println("Current balance: $" + account.getBalance());
}

private void deposit(double amount) {
   account.deposit(amount);
}

private void withdraw(double amount) {
   account.withdraw(amount);
}
}

//Main class to run the ATM simulation
public class example1 {
public static void main(String[] args) {
   BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
   ATM atm = new ATM(userAccount);
   atm.start();
}
}