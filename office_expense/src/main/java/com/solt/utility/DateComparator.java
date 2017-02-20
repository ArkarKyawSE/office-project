package com.solt.utility;

import java.util.Comparator;

import com.solt.entities.Home;

public class DateComparator implements Comparator<Home>{

	@Override
	public int compare(Home o1, Home o2) {
		return o1.getDate().compareTo(o2.getDate());
	}
	
}
