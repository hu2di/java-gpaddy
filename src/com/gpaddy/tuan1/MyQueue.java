package com.gpaddy.tuan1;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {
		//Queue hoạt động theo cơ chế FIFO - vào trước ra trước
		Queue mQueue = new LinkedList();
		System.out.println("is Empty: " + mQueue.isEmpty());
		System.out.println("Thêm phần tử vào Queue: ");
		for (int i = 1; i < 10; i++) {
			//Thêm phần tử vào cuối queue
			mQueue.add(i);
			System.out.println(mQueue);
		}
		
		System.out.println("Peek: " + mQueue.peek());
		
		System.out.println("Xóa phần tử khỏi Queue: ");
		for (int i = 1; i < 10; i++) {
			//Trả về phần tử ở đầu queue và xóa nó
			mQueue.poll();
			System.out.println(mQueue);
		}
	}
}
