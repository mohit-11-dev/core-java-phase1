package program.jav.com;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaProject1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//// Take user Option from the below mentioned Menu
		Scanner input = new Scanner(System.in);
		System.out.println("****************************************************************");
		System.out.println("*********************  LOCKED ME. COM  ********************");
		System.out.println("*********************   Mohit Sindal     ************************");
		System.out.println();
		//
		int num = -1;
		do {
			System.out.println(" 1. Display all files in ascending order");
			System.out.println(" 2. Add, delete or search files");
			System.out.println(" 3. Exit");

			System.out.println("Enter Your Choice:");
			if (input.hasNextInt())
				num = input.nextInt();
	        else {
	            input.next();
	            System.out.println("Oops!!! wrong value, please provide right values");
	            continue;
	        }
			
			String currentDir = System.getProperty("user.dir");

			switch (num) {
			case 1:
				System.out.println("All files in your current working directory " + currentDir + "is");
				System.out.println(getAllSortedFiles(currentDir));
				break;
			case 2:
				performOperations();
				break;
			case 3:
				break;
			default:
				System.out.println("Oops!!! wrong option selected, please choose correct option");
				break;
			}
		} while (num != 3);

	}

	public static List<String> getAllSortedFiles(String currentDir) {
		List<String> allFiles = null;
		File file = new File(currentDir);
		allFiles = Arrays.asList(file.list());
		Collections.sort(allFiles);
		;
		return allFiles;
	}

	public static void performOperations() {
		Scanner input = new Scanner(System.in);
		String choice = "";
		do {
			System.out.println(" a. Add a file to the existing directory list");
			System.out.println(" b. Delete a user specified file from the existing directory list");
			System.out.println(" c. Search a user specified file from the main directory list");
			System.out.println(" d. Navigate back to the main context");

			System.out.println("Enter Your Choice:");
			choice = input.next();
			String currentDir = System.getProperty("user.dir");

			switch (choice) {
			case "a":
				System.out.println("enter file name to add");
				String filename = input.next();
				addFile(currentDir, filename);
				break;
			case "b":
				System.out.println("enter file name to delete");
				String filenametoBedeleted = input.next();
				deleteFile(currentDir, filenametoBedeleted);
				break;
			case "c":
				System.out.println("enter file name to search");
				String filenametoBeSearched = input.next();
				System.out.println(exists(new File(currentDir), filenametoBeSearched) ? "File found successfully" : "File not found");
				break;
			case "d":
				break;
			default:
				System.out.println("Oops!!! wrong option selected, please choose correct option");
				break;
			}
		} while (!choice.equals("d"));
	}

	public static void addFile(String currentDir, String filename) {
		try {
			File file = new File(filename);
			if (file.createNewFile()) {
				System.out.println("New file created successfully");
			} else {
				System.out.println("file already exists");
			}

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	public static void deleteFile(String currentDir, String filename) {
		try {
			File file = new File(filename);

			if (exists(new File(currentDir), filename) && file.delete()) {
				System.out.println("file deleted successfully");
			} else {
				System.out.println("file not found");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static boolean exists(File dir, String filename) {
		String[] files = dir.list();
		for (String file : files)
			if (file.equals(filename))
				return true;
		return false;
	}

}
