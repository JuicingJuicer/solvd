package com.solvd.ta.lab2;

import java.util.EnumSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.Interfaces.GenreList;

public class Preferences implements GenreList {
	private EnumSet<Genre> prefs;
	private static final Logger logger = LogManager.getLogger(Preferences.class.getName());

	public Preferences(EnumSet<Genre> prefs) {
		this.setPrefs(prefs);
	}

	public Preferences() {
		prefs = EnumSet.allOf(Genre.class);
	}

	public void setPrefs(EnumSet<Genre> prefs) {
		this.prefs = prefs;
	}

	public EnumSet<Genre> getPrefs() {
		return prefs;
	}

	public void addGenre(String genre) {
		prefs.add(Genre.valueOf(genre));
	}

	public void removeGenre(String genre) {
		prefs.remove(Genre.valueOf(genre));
	}

	public void clearGenres() {
		prefs.clear();
	}

	public void printGenres() {
		logger.info(prefs);
	}

	public void printGenrePool() {
		EnumSet<Genre> pool = EnumSet.complementOf(prefs);
		logger.info(pool);
	}

	public boolean containsInPool(String genre) {
		try {
			EnumSet<Genre> pool = EnumSet.complementOf(prefs);
			return pool.contains(Genre.valueOf(genre));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean containsInPersonal(String genre) {
		try {
			return prefs.contains(Genre.valueOf(genre));
		} catch (Exception e) {
			return false;
		}
	}

}
