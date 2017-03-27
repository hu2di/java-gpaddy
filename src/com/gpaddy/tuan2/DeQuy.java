package com.gpaddy.tuan2;

import java.io.File;
import java.util.Scanner;

public class DeQuy {
	public static void browser(File dir) {
		File[] listFile = dir.listFiles();
		if (listFile.length > 0) {
			for (int i = 0; i < listFile.length; i++) {
				System.out.println(listFile[i].getName());
				if (listFile[i].isDirectory()) {
					browser(listFile[i]);
				}
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String command;

		while (true) {
			System.out.print("\nNhập đường dẫn: ");
			command = sc.nextLine();
			try {
				File dir = new File(command);
				browser(dir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
