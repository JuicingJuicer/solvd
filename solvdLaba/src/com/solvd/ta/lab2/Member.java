package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.collections.LinkedList;
import com.solvd.ta.lab2.exceptions.AlreadyRegisteredException;
import com.solvd.ta.lab2.exceptions.InvalidGenreException;
import com.solvd.ta.lab2.exceptions.NotRegisteredException;
import com.solvd.ta.lab2.items.Media;

public class Member {
	Random rando = new Random();
	final long id = System.currentTimeMillis();
	private String name;
	private boolean isRegistered = false;
	private boolean isSetup = false;
	private Preferences preferences = new Preferences();
	private static final Logger logger = LogManager.getLogger(Member.class.getName());
	private LinkedList<Media> myItems = new LinkedList<>();

	Scanner sc = new Scanner(System.in);

	public Member(String name) {
		this.setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public void setIsSetup(boolean isSetup) {
		this.isSetup = isSetup;
	}

	public String getName() {
		return this.name;
	}

	public long getId() {
		return this.id;
	}

	public boolean getIsRegistered() {
		return this.isRegistered;
	}

	public boolean getIsSetup() {
		return this.isSetup;
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public void clearPreferences() {
		preferences.clearGenres();
	}

	public void printPreferences() {
		logger.info("My Preferences: ");
		preferences.printGenres();
	}

	public void printPreferencePool() {
		logger.info("Preference Pool: ");
		preferences.printGenrePool();
	}

	public void printBothSets() {
		this.printPreferences();
		this.printPreferencePool();
	}

	public void firstTimeSetup() {
		if (!isSetup) {
			this.clearPreferences();
			this.setIsSetup(true);
		}
	}

	public boolean checkNewMember() throws AlreadyRegisteredException {
		if (!(this.isRegistered)) {
			return true;
		} else {
			throw new AlreadyRegisteredException("You are already registered!");
		}
	}

	public void addPreference(String genre) throws InvalidGenreException {
		String temp = genre;
		if (preferences.containsInPool(temp.toUpperCase())) {
			preferences.addGenre(temp.toUpperCase());
		} else {
			throw new InvalidGenreException("Invalid genre");
		}
	}

	public void removePreference(String genre) throws InvalidGenreException {
		String temp = genre;
		if (preferences.containsInPersonal(temp.toUpperCase())) {
			preferences.removeGenre(temp.toUpperCase());
		} else {
			throw new InvalidGenreException("Invalid genre");
		}
	}

	public void addRemoveSwitch(int selection) {
		String temp;
		logger.info("Input the genre");
		temp = sc.nextLine();
		if (selection == 1) {
			try {
				this.addPreference(temp);
			} catch (InvalidGenreException e) {
				logger.error(e);
			}
		} else if (selection == 2) {
			try {
				this.removePreference(temp);
			} catch (InvalidGenreException e) {
				logger.error(e);
			}
		}
	}

	public boolean checkRegistration() throws NotRegisteredException {
		if (this.isRegistered) {
			return true;
		} else {
			throw new NotRegisteredException("You must be registered in order to do this!");
		}
	}

	public void addMyItems(ArrayList<Media> purchased) {
		for (Media m : purchased) {
			myItems.add(m);
		}
	}

	public void printMyItems() {
		logger.info(myItems);
	}
}
