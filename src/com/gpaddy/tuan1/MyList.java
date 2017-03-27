package com.gpaddy.tuan1;

import java.util.*;

public class MyList {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main (String args[]) {
		//ArrayList - Bất đồng bộ
		List mArrayList = new ArrayList();
		System.out.println("Thêm phần tử vào ArrayList: ");
		mArrayList.add("a");
		mArrayList.add("b");
		mArrayList.add("c");
		System.out.println(mArrayList);
		System.out.println("Xóa phần tử khỏi ArrayList: ");
		if (mArrayList.size() > 0) {
			mArrayList.remove(0);
		}
		System.out.println(mArrayList);
		System.out.println("Chèn phần tử vào ArrayList: ");
		mArrayList.add(0, "x");
		System.out.println(mArrayList);
		
		//Vector - Đồng bộ - Sử dụng trong đa luồng truy cap thay doi du lieu
		List mVector = new Vector();
		System.out.println("\nThêm phần tử vào Vector: ");
		mVector.add("a");
		mVector.add("b");
		mVector.add("c");
		System.out.println(mVector);
		System.out.println("Xóa phần tử khỏi Vector: ");
		if (mVector.size() > 0) {
			mVector.remove(0);
		}
		System.out.println(mVector);
		System.out.println("Chèn phần tử vào Vector: ");
		mVector.add(0, "x");
		System.out.println(mVector);
		
		//LinkedList - Danh sách liên kết - mối phần tử lưu địa chỉ của phần tử trước và sau nó
		//Chèn và xóa nhanh - truy cập dữ liệu lâu - so với arraylist và vector
		List mLinkedList = new LinkedList();
		System.out.println("\nThêm phần tử vào LinkedList: ");
		mLinkedList.add("a");
		mLinkedList.add("b");
		mLinkedList.add("c");
		System.out.println(mLinkedList);
		System.out.println("Xóa phần tử khỏi LinkedList: ");
		if (mLinkedList.size() > 0) {
			mLinkedList.remove(0);
		}
		System.out.println(mLinkedList);
		System.out.println("Chèn phần tử vào LinkedList: ");
		mLinkedList.add(0, "x");
		System.out.println(mLinkedList);
	}
}
