package com.solvd.ta.lab2;

import java.util.EnumSet;

public class Preferences {
	private EnumSet<Genre> prefs;

	public Preferences(EnumSet<Genre> prefs) {
		this.setPreferences(prefs);
	}

	public Preferences() {
		prefs = EnumSet.noneOf(Genre.class);
	}

	public void setPreferences(EnumSet<Genre> prefs) {
		this.prefs = prefs;
	}

	public EnumSet<Genre> getPreferences() {
		return prefs;
	}

	public void addGenre(Genre genre) {
		prefs.add(genre);
	}

	public void removeGenre(Genre genre) {
		prefs.remove(genre);
	}

	public static void main(String[] args) {
		Preferences prep = new Preferences();
		prep.addGenre(Genre.ACTION);
		System.out.print(prep.getPreferences());
	}
}
