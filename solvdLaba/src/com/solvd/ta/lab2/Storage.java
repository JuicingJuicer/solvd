package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Storage {
	Scanner sc = new Scanner(System.in);
	protected ArrayList<Media> arr = new ArrayList<Media>();
	protected ArrayList<Media> filteredArr = new ArrayList<Media>();
	protected int capacity;

	public Storage(int capacity) {
		this.capacity = capacity;
	}

	public Storage() {
		this.capacity = 100;
	}

	public void addMedia(Media media) {
		filteredArr.add(media);
	}

	public void removeMedia(Media media) {
		filteredArr.remove(media);
	}

	public void printInventory() {
		for (int i = 0; i < filteredArr.size(); i++) {
			System.out.println(i + 1 + ". " + filteredArr.get(i).title);
		}
		System.out.println();
	}

	public void cloneItems(ArrayList<Media> arr) {
		this.arr = (ArrayList<Media>) arr.clone();
		this.filteredArr = (ArrayList<Media>) arr.clone();
	}

	public void selectionMenu(int i) {
		System.out.println("\n" + filteredArr.get(i - 1).title + " selected");
		System.out.println("Pick an action");
		System.out.println("1. View details");
		System.out.println("2. Add to cart");
		System.out.println("3. Cancel");
	}

	public void printDetails(int i) {
		System.out.println("\nDetails");
		System.out.println(filteredArr.get(i - 1) + "\n");
	}

	public void filterItems(Preferences preferences) {
		EnumSet<Genre> prefs = preferences.getPrefs();
		Set<Media> set = new HashSet<Media>();

		this.filteredArr.clear();
		for (Genre genre : prefs) {
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).genre.contains(genre)) {
					set.add(arr.get(i));
				}
			}
		}
		filteredArr.addAll(set);
	}

	public void removeFromBoth(Media media) {
		arr.remove(media);
		filteredArr.remove(media);
	}
}
