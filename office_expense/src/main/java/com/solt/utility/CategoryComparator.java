package com.solt.utility;

import java.util.Comparator;

import com.solt.entities.Home;

public class CategoryComparator implements Comparator<Home> {

	@Override
	public int compare(Home o1, Home o2) {
		return o1.getCategory().compareTo(o2.getCategory());
	}

}
