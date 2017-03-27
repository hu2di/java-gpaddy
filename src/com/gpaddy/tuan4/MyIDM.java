package com.gpaddy.tuan4;

public class MyIDM {

	public static void main(String[] args) {
//		String url = "http://data16.chiasenhac.com/downloads/1028/5/1027835-b54fd373/320/Cay%20Bang%20-%20Buc%20Tuong%20[MP3%20320kbps].mp3";
		String url = "http://web.cs.iastate.edu/~lumpe/CS229/DesignPattern.pdf";
		DownloadInfo information = new DownloadInfo(url);
		information.initiateInformation();
	}
}
