package com.softserve.edu.collect;

import java.util.Comparator;

public class Employer {
	private int tabnom;
	private String name;

	public Employer(int tabnom, String name) {
		this.tabnom = tabnom;
		this.name = name;
	}

	public int getTabnom() {
		return tabnom;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "tabnom=" + tabnom + " name=" + name;
	}
	
	public static Comparator<Employer> getNameComparator() {
		return new NameComparator();
	}

	public static Comparator<Employer> getTabComparator() {
		return new TabComparator();
	}

	private static class NameComparator implements Comparator<Employer> {
		public int compare(Employer o1, Employer o2) {
			return o1.name.compareTo(o2.name);
		}
	}

	private static class TabComparator implements Comparator<Employer> {
		public int compare(Employer o1, Employer o2) {
			return o1.tabnom - o2.tabnom;
		}
	}

}
