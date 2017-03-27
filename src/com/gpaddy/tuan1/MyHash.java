package com.gpaddy.tuan1;

import java.util.*;

public class MyHash {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main (String args[]) {
		//HashSet
		HashSet mHashSet = new HashSet();
		System.out.println("Thêm phần tử và HashSet: ");
		mHashSet.add("A");
		mHashSet.add("B");
		mHashSet.add("C");
		mHashSet.add("C");
		mHashSet.add("C"); //HashSet không cho phép phần tử trùng nhau
		System.out.println(mHashSet);
		System.out.println("Xóa phẩn tử khỏi HashSet: ");
		mHashSet.remove("A"); //Trả về true hoặc false
		System.out.println(mHashSet);
	
		//HashMap - Bất đồng bộ
		//HashMap cho phép lưu khóa và giá trị là null
		HashMap mHashMap = new HashMap();
		System.out.println("\nThêm phần tử vào HashMap: ");
		mHashMap.put("Lan", 8);
		//mHashMap.put(null, null);
		mHashMap.put("Điệp", 9);
		mHashMap.put("Dương", 10);
		System.out.println(mHashMap);
		System.out.println("Xóa phần tử khỏi HashMap: ");
		mHashMap.remove("Điệp");
		mHashMap.remove("Lan", 8);
		System.out.println(mHashMap);
		
		//Hashtable - Đồng bộ
		//Hashtable không cho phép lưu khóa và giá trị là null
		Hashtable mHashTable = new Hashtable();
		System.out.println("\nThêm phần tử vào Hashtable: ");
		mHashTable.put("An", 18);
		mHashTable.put("Nam", 19);
		mHashTable.put("Bình", 20);
		System.out.println(mHashTable);
		System.out.println("Xóa phần tử khỏi Hashtable: ");
		mHashTable.remove("Nam");
		mHashTable.remove("An", 18);
		System.out.println(mHashTable);
		
	}
}
