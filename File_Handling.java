package com.employee.payroll;

import java.nio.file.WatchEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;
import static java.nio.file.StandardWatchEventKinds.*;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;

public class EmployeePayrollService {
	static Scanner sc = new Scanner(System.in);

	public static void addNewFile() {
		try {
			System.out.println("Enter The New Directory Path");
			String path = sc.next();
			File Dir = new File(path);
			if (Dir.exists()) {
				System.out.println("Directory All Ready Present");
			} else {
				System.out.println("Its A New Directory Its Creating now...");
			}
			Dir.mkdir();
			System.out.println("Path has Created...");
			System.out.println("Enter The File Name You Want To Create");
			String file = sc.next();
			File file1 = new File(path, file);
			if (file1.exists()) {

				System.out.println("This File AllReady Present");
			} else {
				System.out.println("Its New File Its Creating...");
				file1.createNewFile();
				System.out.println("New File Has Been Created");
			}

		} catch (Exception e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
		}
	}

	public static void deleteFile() {
		try {
			System.out.println("Enter The Path You Want To delete The File...");
			String path = sc.next();
			File Dir = new File(path);
			if (Dir.exists()) {
				System.out.println("Enter The File You Want To Delete");
			} else {
				System.out.println("Path Does Not Exist");
			}
			System.out.println("Enter The File Name You Want To Delete...");
			String file = sc.next();
			File File1 = new File(Dir, file);
			if (File1.delete()) {

				System.out.println("File Has Been Successfully Deleted....");
			} else {
				System.out.println("File Does Not Exist...");
			}

		} catch (Exception e) {
			System.out.println("An Error Occured...");
			e.printStackTrace();
		}
	}

	public static void listFile() {
		try {
			System.out.println("Enter The Path You Want To List There Files");
			String path = sc.next();
			File Dir = new File(path);
			String[] list1 = Dir.list();
			for (String list2 : list1) {
				System.out.println(list2);

			}

		} catch (NullPointerException e) {
			System.out.println("An Error Occured...");
			e.printStackTrace();
		}
	}

	public static void watchServices() throws IOException, InterruptedException {

		WatchService watchService = FileSystems.getDefault().newWatchService();
		// System.out.println("Enter The Path You Want To Watch Services...");
		// String path1 = sc.next();
		// File Dir = new File(path1);
		Path path = Paths.get("G:\\brigelab\\java\\day27");
		path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
		boolean poll = true;
		while (poll) {
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {

				System.out.println("Event kind : " + event.kind() + " - File : " + event.context());

			}

			poll = key.reset();

		}

	}

	public static void main(String args[]) throws IOException, InterruptedException {

		System.out.println("WelCome To File Handling Programm");
		System.out.println("Enter The Your Choice");
		boolean ans = true;
		while (ans != false) {
			System.out.println("1 For Creating New File");
			System.out.println("2 For Deleteing File");
			System.out.println("3 List The File");
			System.out.println("4 See The Watch Services");
			System.out.println("5 For Exit");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				addNewFile();
				break;
			case 2:
				deleteFile();
				break;
			case 3:
				listFile();
				break;
			case 4:
				watchServices();
				break;

			case 5:
				ans = false;
				break;

			}
		}
	}
}
