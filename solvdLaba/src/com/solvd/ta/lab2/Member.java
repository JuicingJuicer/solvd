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

	public void addPreference(String genre) {
		String temp = genre;
		preferences.addGenre(temp.toUpperCase());
	}

	public void removePreference(String genre) {
		String temp = genre;
		preferences.removeGenre(temp.toUpperCase());
	}

	public void addRemoveSwitch(int selection) {
		String temp;
		if (selection == 1) {
			System.out.println("Input the genre to add!");
			temp = sc.nextLine();
			try {
				this.addPreference(temp);
			} catch (Exception e) {
				System.out.println("Input the genre correctly!");
			}
		} else if (selection == 2) {
			System.out.println("Input the genre to remove!");
			temp = sc.nextLine();
			try {
				this.removePreference(temp);
			} catch (Exception e) {
				System.out.println("Input the genre correctly!");
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
