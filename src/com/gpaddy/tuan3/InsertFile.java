package com.gpaddy.tuan3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class InsertFile {
	public static void joinFile(String path1, String path2) {
		File f1 = new File(path1);
		File f2 = new File(path2);
		ArrayList<File> files = new ArrayList<>();// put your files here
		files.add(f1);
		files.add(f2);
		File output = new File("F\\Join.flv");
		BufferedOutputStream boss = null;
		try {
			boss = new BufferedOutputStream(new FileOutputStream(output));
			for (File file : files) {
				BufferedInputStream bis = null;
				try {
					bis = new BufferedInputStream(new FileInputStream(file));
					boolean done = false;
					while (!done) {
						int data = bis.read();
						boss.write(data);
						done = data < 0;
					}
				} catch (Exception e) {
					// do error handling stuff, log it maybe?
				} finally {
					try {
						bis.close();// do this in a try catch just in case
					} catch (Exception e) {
						// handle this
					}
				}
			}
		} catch (Exception e) {
			// handle this
		} finally {
			try {
				boss.close();
			} catch (Exception e) {
				// handle this
			}
		}
	}

	public static void inRSF(String path1, String path2) throws IOException {
		RandomAccessFile f2 = new RandomAccessFile(new File(path2), "rw");
		byte[] b = new byte[(int) f2.length()];
		f2.readFully(b);

		RandomAccessFile f1 = new RandomAccessFile(new File(path1), "rw");
		f1.seek(f1.length());
		f1.setLength(f1.length() + f2.length());
		f1.write(b);

		f1.close();
		f2.close();
	}
	
	public static void main(String args[]) throws IOException {
		String path1 = "F\\V1.flv";
		String path2 = "F\\V2.flv";
		joinFile(path1, path2);
	}
}
