package com.phase.endProject;
import java.util.ArrayList;
import java.util.Scanner;
public class MyCameraMenu {
	public static void showMenu(Scanner sc, String currentUser, ArrayList<CameraDetails> cameras, int nextCameraId) {
		while (true) {
			sc =new Scanner(System.in);
			System.out.println("My Cameras Menu:");
			System.out.println("1. Add Camera");
			System.out.println("2. Remove Camera");
			System.out.println("3. View My Cameras");
			System.out.println("4. Go to previous menu");
			System.out.print("Enter your choice: ");

			int myCamerasChoice = sc.nextInt();
			sc.nextLine(); // Consume the newline

			switch (myCamerasChoice) {
			case 1:
				//Call the addCamera method from CameraManager
				CameraManager.addCamera(sc, cameras, nextCameraId);
				break;
			case 2:
				// Call the removeCamera method from CameraManager
				CameraManager.removeCamera(cameras);
				break;
			case 3:
				//Call the viewMyCameras method from Camera Manager
				CameraManager.viewMyCameras(cameras, currentUser);
				break;
			case 4:
				// Go back to the main menu
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}
