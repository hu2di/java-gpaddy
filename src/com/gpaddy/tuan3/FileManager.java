package com.gpaddy.tuan3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManager {
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

	public static void createFile(String path, String name) {
		File f = new File(path, name);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void copyFile(String oldFile, String newFile)
			throws FileNotFoundException {
		File fileToCopy = new File(oldFile);
		FileInputStream input = new FileInputStream(fileToCopy);
		File fileCopy = new File(newFile);
		FileOutputStream output = new FileOutputStream(fileCopy);

		byte[] buffer = new byte[1024];
		int length;
		try {
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void moveFile(String oldPath, String newPath) {
		File f = new File(oldPath);
		if (f.renameTo(new File(newPath + f.getName()))) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
	}

	public static void deleteFile(String path) {
		File f = new File(path);
		f.delete();
	}

	public static void insert(String path, int pos, String string)
			throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		br.close();
		fr.close();
	}
	
	public static void randomInsert(String path, long pos, String content) throws IOException {
		RandomAccessFile f = new RandomAccessFile(new File(path), "rw");
		f.seek(pos);
		f.write(content.getBytes());
		f.close();
	}

	public static void main(String args[]) throws IOException {
		String path = "F";
		File dir = new File(path);
		browser(dir);

		System.out.println("\nTạo file: text2.txt");
		createFile(path, "text2.txt");
		browser(dir);

		System.out.println("\nCopy file text1.txt vào thư mục F1");
		copyFile(path + "\\text1.txt", path + "\\F1\\text1.txt");
		browser(dir);

		System.out.println("\nDi chuyển file text2.txt vào thư mục F2");
		moveFile(path + "\\text2.txt", path + "\\F2\\");
		browser(dir);

		System.out
				.println("\nXóa file text1.txt trong F1 và text2.txt trong F2");
		deleteFile(path + "\\F1\\text1.txt");
		deleteFile(path + "\\F2\\text2.txt");
		browser(dir);
		
		System.out.println("\nChèn vào vị trí i trong file n bytes cho trước.");
		randomInsert(path + "\\text.txt", 0, "việtnam");
		browser(dir);
	}
}
