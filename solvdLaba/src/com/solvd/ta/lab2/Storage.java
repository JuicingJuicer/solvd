package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
	Scanner sc = new Scanner(System.in);
	protected ArrayList<Media> arr = new ArrayList<Media>();
	protected int capacity;

	public Storage(int capacity) {
		this.capacity = capacity;
	}

	public Storage() {
		this.capacity = 100;
	}

	public void addMedia(Media media) {
		arr.add(media);
	}

	public void removeMedia(Media media) {
		arr.remove(media);
	}

	public void printInventory() {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(i + 1 + ". " + arr.get(i).title);
		}
		System.out.println();
	}

	public void cloneItems(ArrayList<Media> arr) {
		this.arr = (ArrayList<Media>) arr.clone();
	}

	public void selectionMenu(int i) {
		System.out.println("\n" + arr.get(i - 1).title + " selected");
		System.out.println("Pick an action");
		System.out.println("1. View details");
		System.out.println("2. Add to cart");
		System.out.println("3. Cancel");
	}

	public void printDetails(int i) {
		System.out.println("\nDetails");
		System.out.println(arr.get(i - 1) + "\n");
	}
}
