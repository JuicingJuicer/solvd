package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.enums.Genre;
import com.solvd.ta.lab2.interfaces.FormatterFunction;
import com.solvd.ta.lab2.interfaces.StorageSystem;
import com.solvd.ta.lab2.items.Book;
import com.solvd.ta.lab2.items.Media;
import com.solvd.ta.lab2.items.Movie;

public class Storage implements StorageSystem {
	Scanner sc = new Scanner(System.in);
	protected ArrayList<Media> master = new ArrayList<Media>();
	protected ArrayList<Media> local = new ArrayList<Media>();
	protected ArrayList<Media> filteredArr = new ArrayList<Media>();
	private static final Logger LOGGER = LogManager.getLogger(Storage.class.getName());

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

	// lambda augument to format how the items are printed
	public void printer(FormatterFunction<Media> format) {
		format.apply(filteredArr);
	}

	public void cloneItems(ArrayList<Media> arr) {
		this.master = (ArrayList<Media>) arr.clone();
		this.local = (ArrayList<Media>) arr.clone();
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
			for (int i = 0; i < local.size(); i++) {
				if (local.get(i).getGenre().contains(genre)) {
					set.add(local.get(i));
				}
			}
		}
		filteredArr.addAll(set);
	}

	public void removeFromBoth(Media media) {
		local.remove(media);
		filteredArr.remove(media);
	}

	public void search(int input) {
		List<Media> searched = null;
		int temp;
		String temp2;
		double temp3;
		switch (input) {
		case 1:
			LOGGER.info("Enter serial number: ");
			temp = sc.nextInt();
			sc.nextLine();
			searched = master.stream().filter(a -> a.getSerialNumber() == temp).collect(Collectors.toList());
			break;
		case 2:
			LOGGER.info("Enter title: ");
			temp2 = sc.nextLine();
			searched = master.stream().filter(a -> a.getTitle().equalsIgnoreCase(temp2)).collect(Collectors.toList());
			break;
		case 3:
			LOGGER.info("Enter the type (the types are BOOK, MOVIE, MANGA)");
			temp2 = sc.nextLine();
			searched = master.stream().filter(a -> a.getClass().getSimpleName().equalsIgnoreCase(temp2))
					.collect(Collectors.toList());
			break;
		case 4:
			LOGGER.info("Enter the author: ");
			temp2 = sc.nextLine();
			searched = master.stream().filter(
					a -> a.getClass().getSimpleName().equals("Book") || a.getClass().getSimpleName().equals("Manga"))
					.filter(a -> ((Book) a).getAuthor().equalsIgnoreCase(temp2)).collect(Collectors.toList());
			break;
		case 5:
			LOGGER.info("Enter the number of pages: ");
			temp = sc.nextInt();
			sc.nextLine();
			searched = master.stream().filter(
					a -> a.getClass().getSimpleName().equals("Book") || a.getClass().getSimpleName().equals("Manga"))
					.filter(a -> ((Book) a).getPages() > temp).collect(Collectors.toList());
			break;
		case 6:
			LOGGER.info("Enter the rating: ");
			temp3 = sc.nextDouble();
			sc.nextLine();
			searched = master.stream().filter(a -> a.getClass().getSimpleName().equals("Movie"))
					.filter(a -> ((Movie) a).getRating() > temp3).collect(Collectors.toList());
			break;
		case 7:
			LOGGER.info("Enter the number of minutes: ");
			temp = sc.nextInt();
			sc.nextLine();
			searched = master.stream().filter(a -> a.getClass().getSimpleName().equals("Movie"))
					.filter(a -> ((Movie) a).getRuntime() > temp).collect(Collectors.toList());
			break;
		default:
			LOGGER.info("Invalid input");
		}

		if (searched.size() == 0) {
			LOGGER.info("NO RESULTS!");
		} else {
			LOGGER.info(searched);
		}
	}

	public void stats(int input) {
		Optional<Media> searched = null;
		double average;
		int num;
		switch (input) {
		case 1:
			average = master.stream()
					.filter(a -> a.getClass().getSimpleName().equals("Book")
							|| a.getClass().getSimpleName().equals("Manga"))
					.mapToInt(a -> ((Book) a).getPages()).average().getAsDouble();
			LOGGER.info("Average: " + average);
		case 2:
			searched = master.stream().filter(a -> a.getClass().getSimpleName().equals("Movie"))
					.max(Comparator.comparing(a -> ((Movie) a).getRating()));
			LOGGER.info(searched);
		case 3:
			num = master.stream().filter(a -> a.getClass().getSimpleName().equals("Movie"))
					.map(a -> ((Movie) a).getRuntime()).reduce(0, (a, b) -> a + b);
			LOGGER.info("Total runtime of all movies is " + num + " minutes");
		}
	}
}
