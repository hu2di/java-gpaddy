package com.gpaddy.tuan2;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class KhuDeQuy {
	@SuppressWarnings("unchecked")
	public static void browser(File dir) {
		@SuppressWarnings("rawtypes")
		Stack mStack = new Stack();
		mStack.push(dir);
		while (!mStack.isEmpty()) {
			File[] listFile = ((File) mStack.pop()).listFiles();
			if (listFile.length > 0) {
				boolean flag = true;
				for (int i = 0; i < listFile.length; i++) {
					System.out.println(listFile[i].getName());
					if (listFile[i].isDirectory()) {
						mStack.push(listFile[i]);
						flag = false;
					}
				}
				if (flag) {
					mStack.pop();
				}
			}
		}
	}

	public static void main(String args[]) {
		@SuppressWarnings("resource")
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
