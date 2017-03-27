package com.gpaddy.tuan4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class MyDownload extends Thread {
	private Thread t;

	public MyDownload() {
		System.out.println("Creating download...");
	}

	public void run() {
		System.out.println("Downloading...");

		URL website;
		try {
			website = new URL("http://data16.chiasenhac.com/downloads/1028/5/1027835-b54fd373/320/Cay%20Bang%20-%20Buc%20Tuong%20[MP3%20320kbps].mp3");
			ReadableByteChannel rbc;
			rbc = Channels.newChannel(website.openStream());
			@SuppressWarnings("resource")
			FileOutputStream fos = new FileOutputStream(
					"F\\Caybang.mp3");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error Download!");
		}

		System.out.println("Finish!");
	}

	public void start() {
		System.out.println("Starting...");
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

	public static void main(String[] args) throws IOException {
		MyDownload mDownload = new MyDownload();
		mDownload.start();
	}
}
