package com.solvd.ta.lab2;

import java.util.Random;
import java.util.Scanner;

public class Member {
	Random rando = new Random();
	final int id = rando.nextInt(1000);
	private String name;
	private boolean isRegistered = false;
	private boolean isSetup = false;
	private Preferences preferences = new Preferences();

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

	public void isSetup(boolean isSetup) {
		this.isSetup = isSetup;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
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
		System.out.println("My Preferences: ");
		preferences.printGenres();
	}

	public void printPreferencePool() {
		System.out.println("Preference Pool: ");
		preferences.printGenrePool();
	}

	public void printBothSets() {
		this.printPreferences();
		this.printPreferencePool();
	}

	public void firstTimeSetup() {
		if (!isSetup) {
			this.clearPreferences();
			this.isSetup(true);
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
		System.out.println("Input the genre");
		temp = sc.nextLine();
		if (selection == 1) {
			try {
				this.addPreference(temp);
			} catch (InvalidGenreException e) {
				System.out.println(e);
			}
		} else if (selection == 2) {
			try {
				this.removePreference(temp);
			} catch (InvalidGenreException e) {
				System.out.println(e);
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
}
