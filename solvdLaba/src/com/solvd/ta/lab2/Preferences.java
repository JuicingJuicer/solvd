package com.solvd.ta.lab2;

import java.util.EnumSet;

public class Preferences {
	EnumSet<Genre> prefs;

	public void addGenre(Genre genre) {
		prefs.add(genre);
	}

	public void removeGenre(Genre genre) {
		prefs.remove(genre);
	}
}
