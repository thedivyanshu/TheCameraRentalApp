package com.phase.endProject;
import java.util.ArrayList;
import java.util.Scanner;

public class CameraManager {
	static class CameraPrinter {
		public static void printCameraDetails(ArrayList<CameraDetails> cameras) {
			System.out.println("All Cameras:");
			System.out.format("%-4s %-20s %-20s %-15s %-12s%n", "ID", "Name", "Model", "Rental Price", "Availability");
			System.out.println("---------------------------------------------------------------------------");

			for (CameraDetails camera :cameras) {

				System.out.format("%-4d %-20s %-20s RS %-15s %-12s%n", camera.getId(), camera.getName(), camera.getModel(), camera.getRentalPrice(), camera.isAvailable() ? "Available" : "Rented");
			}
		}
	}
	//Method to add camera
	public static void addCamera(Scanner sc,ArrayList<CameraDetails> cameras,int nextCameraId) {

		sc = new Scanner(System.in);
		System.out.print("Enter camera name: ");
		String name = sc.nextLine();
		System.out.print("Enter camera model: ");
		String model = sc.nextLine();
		System.out.print("Enter rental price: ");
		double rentalPrice = sc.nextDouble();

		int newId = generateUniqueId(cameras);
		CameraDetails newCamera = new CameraDetails(newId, name, model, rentalPrice, true);
		cameras.add(newCamera);
		CameraPrinter.printCameraDetails(cameras);
	}
	//Method to generateUniqueId
	private static int generateUniqueId(ArrayList<CameraDetails> cameras) {
		int id = 1;
		while (cameraExists(cameras,id)) {
			id++;
		}
		return id;
	}
	private static boolean cameraExists(ArrayList<CameraDetails> cameras, int id) {
		for (CameraDetails camera : cameras) {
			if (camera.getId() == id) {
				return true;
			}
		}
		return false;
	}
	//method to remove camera
	public static void removeCamera(ArrayList<CameraDetails> cameras) {
		Scanner sc = new Scanner(System.in);
		CameraPrinter.printCameraDetails(cameras);
		System.out.print("Enter the ID of the camera to remove: ");
		int cameraId = sc.nextInt();
		boolean removed = false;
		for (CameraDetails camera : cameras) {
			if (camera.getId() == cameraId) {
				cameras.remove(camera);
				removed = true;
				break;
			}
		}
		if (removed) {
			System.out.println("Camera with ID " + cameraId + " removed.");
		} else {
			System.out.println("Camera with ID " + cameraId + " not found.");
		}
	}
	//method to rent a camera
	public static void rentCamera(ArrayList<CameraDetails> cameras, ArrayList<Wallet> wallets, String currentUser) {
		Scanner sc = new Scanner(System.in);

		CameraPrinter.printCameraDetails(cameras);

		System.out.print("Enter the ID of the camera to rent: ");
		int cameraId = sc.nextInt();
		boolean cameraRented = false;
		for (CameraDetails camera : cameras) {
			if (camera.getId() == cameraId) {
				if (camera.isAvailable()) {
					double rentalCost = camera.getRentalPrice();
					for (Wallet wallet : wallets) {
						if (wallet.getUsername().equals(currentUser)) {
							if (wallet.getBalance() >= rentalCost) {
								wallet.setBalance(wallet.getBalance() - rentalCost);
								// Mark the camera as rented
								camera.setAvailable(false);
								camera.setRenter(currentUser);
								System.out.println("Camera rented successfully. Rental cost: Rs " + rentalCost);
								cameraRented = true;
							} else {
								System.out.println("Failed Transaction: Insufficient funds in wallet.");
							}
						} else {
							System.out.println("Camera with ID " + cameraId + " is already rented.");
						}
						break;
					}
				}
				break;
			}
			else {
				System.out.println("Camera with ID " + cameraId + " not found.");
				cameraRented = true;
			}
		}
	}
	//method to view all cameras
	public static void viewCameras(ArrayList<CameraDetails> cameras) {
		CameraPrinter.printCameraDetails(cameras);
	}
	//method to view my cameras
	public static void viewMyCameras(ArrayList<CameraDetails> cameras, String currentUser) {
		System.out.println("Cameras rented by " + currentUser + ":");
		System.out.format("%-4s %-20s %-20s %-15s %-12s%n", "ID", "Name", "Model", "Rental Price", "Availability");
		System.out.println("---------------------------------------------------------------------------");

		for (CameraDetails camera :cameras) {
			String renter = camera.getRenter();
			if (!camera.isAvailable() && renter != null && renter.equals(currentUser)) {
				System.out.format("%-4d %-20s %-20s RS %-15s %-12s%n", camera.getId(), camera.getName(), camera.getModel(), camera.getRentalPrice(), "Rented by " + currentUser);
			}
		}
	}
}
