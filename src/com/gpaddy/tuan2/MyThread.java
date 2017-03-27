package com.gpaddy.tuan2;

public class MyThread extends Thread{
	private Thread t;
	private String threadName;
	
	public MyThread(String name) {
		threadName = name;
		System.out.println("Creating... " + threadName);
	}
	
	public void run() {
		System.out.println("Running... " + threadName);
		 try {
	         for(int i = 5; i > 0; i--) {
	            System.out.println(threadName + " count: " + i);
	            Thread.sleep(50);
	         }
	     } catch (InterruptedException e) {
	         System.out.println(threadName + " interrupted.");
	     }
		 System.out.println(threadName + " exit!");
	}
	
	public void start() {
		System.out.println("Starting... " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
	public static void main(String args[]) {
		MyThread t1 = new MyThread("Thread 1");
		t1.start();
		MyThread t2 = new MyThread("Thread 2");
		t2.start();
	}
}
