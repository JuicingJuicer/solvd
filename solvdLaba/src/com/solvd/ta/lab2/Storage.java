package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.enums.Genre;
import com.solvd.ta.lab2.interfaces.StorageSystem;
import com.solvd.ta.lab2.items.Media;

public class Storage implements StorageSystem {
	Scanner sc = new Scanner(System.in);
	protected ArrayList<Media> arr = new ArrayList<Media>();
	protected ArrayList<Media> filteredArr = new ArrayList<Media>();
	protected int capacity;
	private static final Logger LOGGER = LogManager.getLogger(Storage.class.getName());

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
			LOGGER.info(i + 1 + ". " + filteredArr.get(i).getTitle() + " ["
					+ filteredArr.get(i).getClass().getSimpleName() + "]");
		}
		System.out.println();
	}

	public void cloneItems(ArrayList<Media> arr) {
		this.arr = (ArrayList<Media>) arr.clone();
		this.filteredArr = (ArrayList<Media>) arr.clone();
	}

	public void selectionMenu(int i) {
		LOGGER.info("\n" + filteredArr.get(i - 1).getTitle() + " selected");
		LOGGER.info("Pick an action");
		LOGGER.info("1. View details");
		LOGGER.info("2. Add to cart");
		LOGGER.info("3. Cancel");
	}

	public void printDetails(int i) {
		LOGGER.info("\nDetails\n" + filteredArr.get(i - 1) + "\n");
	}

	public void filterItems(Preferences preferences) {
		EnumSet<Genre> prefs = preferences.getPrefs();
		Set<Media> set = new HashSet<Media>();

		this.filteredArr.clear();
		for (Genre genre : prefs) {
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getGenre().contains(genre)) {
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
