package com.gpaddy.tuan4;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Downloader implements Runnable {

	private URL downloadURL;

	private int startByte;

	private int endByte;

	private int threadNum;

	private RandomAccessFile outputFile;

	private InputStream stream;

	public Downloader(URL downloadURL, int startByte, int endByte, int threadNum) {
		this.downloadURL = downloadURL;
		this.startByte = startByte;
		this.endByte = endByte;
		this.threadNum = threadNum;
	}

	@Override
	public void run() {
		download();
		System.out.printf("Thread %d is finish!\n", threadNum);
	}

	private void download() {
		try {

			System.out.printf("Thread %d is working...\n", threadNum);

			HttpURLConnection httpURLConnection = (HttpURLConnection) downloadURL
					.openConnection();

			httpURLConnection.setRequestProperty("Range", "bytes=" + startByte
					+ "-" + endByte);

			httpURLConnection.connect();

			stream = httpURLConnection.getInputStream();

			int read = 0;
			byte[] bytes = new byte[1024];
			outputFile = new RandomAccessFile("F\\" + "Part" + threadNum, "rw");

			while ((read = stream.read(bytes)) != -1) {
				outputFile.write(bytes, 0, read);
			}

		} catch (IOException ex) {
			Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			try {
				outputFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
