package com.gpaddy.tuan4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DownloadInfo {
	private String downloadUrl;

	private String fileName;

	private String fileExtension;

	private URL nonStringUrl;

	private HttpURLConnection connection;

	private int fileSize;

	private int filePart;

	private final int numPart = 16;

	private int remainingByte;

	private File outputFile;

	private long begin, end;

	public DownloadInfo(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public void initiateInformation() {
		fileName = downloadUrl.substring(downloadUrl.lastIndexOf('/') + 1,
				downloadUrl.length());

		fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1,
				fileName.length());

		begin = System.currentTimeMillis();

		try {
			nonStringUrl = new URL(downloadUrl);
			connection = (HttpURLConnection) nonStringUrl.openConnection();

			fileSize = ((connection.getContentLength()));
			remainingByte = fileSize % numPart;

			System.out.printf("File Size is : %d \n", fileSize);
			System.out.printf("Remain File Size is : %d \n", remainingByte);

			filePart = fileSize / numPart;
		} catch (MalformedURLException ex) {
			Logger.getLogger(DownloadInfo.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DownloadInfo.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		System.out.printf("File Name is : %s\n", fileName);
		System.out.printf("File Extension is : %s\n", fileExtension);
		System.out.printf("Partition Size is : %d bytes\n", filePart);

		int first = 0, last = filePart - 1;

		ExecutorService thread_pool = Executors.newFixedThreadPool(numPart);

		for (int i = 1; i <= numPart; i++) {
			if (i != numPart) {
				thread_pool
						.submit(new Downloader(nonStringUrl, first, last, i));
			} else {
				thread_pool.submit(new Downloader(nonStringUrl, first, last
						+ remainingByte, i));
			}
			first = last + 1;
			last += filePart;
		}
		thread_pool.shutdown();

		try {
			thread_pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
			System.out.println("Download complete!");
			joinFile();
		} catch (InterruptedException ex) {
			Logger.getLogger(DownloadInfo.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public void joinFile() {
		System.out.println("Joining file...");
		outputFile = new File("F\\" + fileName);
		ArrayList<File> files = new ArrayList<>();
		for (int i = 1; i <= numPart; i++) {
			File f = new File("F\\Part" + i);
			files.add(f);
		}
		BufferedOutputStream boss = null;
		try {
			boss = new BufferedOutputStream(new FileOutputStream(outputFile));
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
		for (File file : files) {
			file.delete();
		}
		files.clear();
		end = System.currentTimeMillis();
		System.out.println("Success Download! Time = " + (end - begin));
	}
}
