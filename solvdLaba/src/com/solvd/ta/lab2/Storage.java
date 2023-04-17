package com.solvd.ta.lab2;

import java.util.ArrayList;

public class Storage {
	ArrayList<Media> arr = new ArrayList<Media>();

	public void addMedia(Media m) {
		arr.add(m);
	}

	public void removeMedia(Media m) {
		arr.remove(m);
	}

	public void printInventory() {
		System.out.println(arr);
	}
}
