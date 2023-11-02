package com.phase.endProject;
import java.util.ArrayList;
import java.util.Scanner;

public class CameraRentalMain {
	private static boolean isValidUser(ArrayList<User> users, String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<>();
		ArrayList<CameraDetails> cameras = new ArrayList<>();
		ArrayList<Wallet> wallets = new ArrayList<>();
		// Hardcoded user credentials
		users.add(new User("admin", "admin@123"));
		// Hardcoded initial wallet balances
		wallets.add(new Wallet("admin", 1000.00));
		// Add some initial cameras
		cameras.add(new CameraDetails(1,"Canon EOS", "EOS 5D Mark IV", 500.00,true));
		cameras.add(new CameraDetails(2,"Nikon", "D850", 400.00,true));
		cameras.add(new CameraDetails(3,"Nikon", "D850", 600.00,true));
		cameras.add(new CameraDetails(4,"Nikon", "D850", 300.00,true));
		cameras.add(new CameraDetails(5,"Nikon", "D850", 800.00,true));
		cameras.add(new CameraDetails(6,"Nikon", "D850", 1000.00,true));

		String currentUser = null;

		while (true) {
			if (currentUser == null) {
				System.out.println("Please log in:");
				System.out.print("Username: ");
				String username = sc.nextLine();
				System.out.print("Password: ");
				String password = sc.nextLine();

				if (isValidUser(users,username,password)) {
					currentUser = username;
					System.out.println("Login successful.");
				} else {
					System.out.println("Login failed. Please try again.");
				}
			} else {
				System.out.println("Welcome, " + currentUser + "!");
				System.out.println("Menu options:");
				System.out.println("1. My Camera");
				System.out.println("2. Rent Camera");
				System.out.println("3. View All Camera");
				System.out.println("4. My Wallet");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");

				int choice = sc.nextInt();
				sc.nextLine(); // Consume the newline

				switch (choice) {
				case 1:
					//call showMenu method from MyCameraMenu Class
					MyCameraMenu.showMenu(sc, currentUser, cameras, choice);
					break;
				case 2:
					//call rentCamera method from CameraManager Class
					CameraManager.rentCamera(cameras, wallets, currentUser);
					break;
				case 3:
					//call viewCameras method from CameraManager Class
					CameraManager.viewCameras(cameras);
					break;
				case 4:
					//call showMenu method from WalletManager class
					WalletManager.showMenu(sc, currentUser, wallets);
					break;
				case 5:
					System.out.println("GoodBye!");
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		}
	}
}
