package com.gpaddy.tuan1;

import java.util.*;

public class TimeTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main (String args[]) {
		ArrayList mArrayList = new ArrayList();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			mArrayList.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time Add ArrayList: " + (end - begin));
		
		Vector mVector = new Vector();
		long begin1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			mVector.add(i);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("Time Add Vector: " + (end1 - begin1));
	}
}
