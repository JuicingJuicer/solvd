package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.Interfaces.StorageSystem;

public class Storage implements StorageSystem {
	Scanner sc = new Scanner(System.in);
	protected ArrayList<Media> arr = new ArrayList<Media>();
	protected ArrayList<Media> filteredArr = new ArrayList<Media>();
	protected int capacity;
	private static final Logger logger = LogManager.getLogger(Storage.class.getName());

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

	final public void printInventory() {
		for (int i = 0; i < filteredArr.size(); i++) {
			logger.info(i + 1 + ". " + filteredArr.get(i).title + " [" + filteredArr.get(i).getClass().getSimpleName()
					+ "]");
		}
		System.out.println();
	}

	public void cloneItems(ArrayList<Media> arr) {
		this.arr = (ArrayList<Media>) arr.clone();
		this.filteredArr = (ArrayList<Media>) arr.clone();
	}

	public void selectionMenu(int i) {
		logger.info("\n" + filteredArr.get(i - 1).title + " selected");
		logger.info("Pick an action");
		logger.info("1. View details");
		logger.info("2. Add to cart");
		logger.info("3. Cancel");
	}

	public void printDetails(int i) {
		logger.info("\nDetails\n" + filteredArr.get(i - 1) + "\n");
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
