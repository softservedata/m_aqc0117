package com.softserve.edu.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDups {
	public static void main(String[] args) {
		//Set<String> s1 = new HashSet<String>();
		List<String> s = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) {
			System.out.println("adding element: " + args[i]);
			if (!s.add(args[i]))
				System.out.println("Duplicate detected: " + args[i]);
		}
		System.out.println("count=" + s.size() + " distinct words detected: " + s);
	}
}
