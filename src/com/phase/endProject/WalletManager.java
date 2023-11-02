package com.phase.endProject;
import java.util.ArrayList;
import java.util.Scanner;

public class WalletManager {
	
	//method to view balance
	public static void viewWalletBalance(String currentUser,ArrayList<Wallet> wallets) {
		for(Wallet walletobj:wallets) {
			if (walletobj.getUsername().equals(currentUser)) {
				double balance = walletobj.getBalance();
				System.out.println("Current Wallet Balance for " + currentUser + ": Rs " + balance);
			} 
		}
		System.out.println("User not found in the wallet.");

	}
	//method to add money
	public static void addMoney(String currentUser, double amount, ArrayList<Wallet> wallets) {
		for(Wallet walletobj:wallets)
			if (walletobj.getUsername().equals(currentUser)) {
				double currentBalance = walletobj.getBalance();
				currentBalance += amount;
				walletobj.setBalance(currentBalance);
				System.out.println("Added Rs " + amount + " to the wallet Current Balance is Rs " + currentBalance);
				return;
			} else {
				System.out.println("User not found in the wallet.");
			}
	}

	public static void showMenu(Scanner sc, String currentUser, ArrayList<Wallet> wallets) {
		while (true) {
			System.out.println("Wallet Menu:");
			System.out.println("1. View Wallet Balance");
			System.out.println("2. Add Money to Wallet");
			System.out.println("3. Go to previous menu");
			System.out.print("Enter your choice: ");

			int walletChoice = sc.nextInt();
			sc.nextLine(); // Consume the newline

			switch (walletChoice) {
			case 1:
				WalletManager.viewWalletBalance(currentUser, wallets);
				break;
			case 2:
				System.out.print("Enter the amount to add to your wallet: Rs ");
				double amount = sc.nextDouble();
				sc.nextLine(); 
				WalletManager.addMoney(currentUser, amount, wallets);
				break;
			case 3:
				return; // Go back to the previous menu
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}


