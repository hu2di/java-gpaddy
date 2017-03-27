package com.gpaddy.tuan1;

import java.util.Stack;

public class MyStack {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {
		//Stack hoạt động theo cơ chế LIFO - vào sau ra trước.
		Stack mStack = new Stack();
		System.out.println("is Empty: " + mStack.isEmpty());
		System.out.println("Thêm phần tử vào Stack: ");
		for (int i = 1; i < 10; i++) {
			//Thêm phần tử vào đỉnh stack
			mStack.push(i);
			System.out.println(mStack);
		}
		System.out.println("Peek: " + mStack.peek());
		System.out.println("Xóa phần tử khỏi Stack: ");
		for (int i = 1; i < 10; i++) {
			//Trả về phần tử ở đỉnh stack và xóa nó
			mStack.pop();
			System.out.println(mStack);
		}
	}
}
