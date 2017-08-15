package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("Lock_1");
		strList.add("Lock_3");
		strList.add("Lock_2");
		strList.add("Lock_4");
		Collections.sort(strList);
		
		System.out.println(strList);
		System.out.println("/Locks".length());
		String sub = "/Locks/Lock_1".substring("/Locks".length() + 1);
		System.out.println(sub);
		int index = strList.indexOf(sub);
		System.out.println(index);
	}
}
