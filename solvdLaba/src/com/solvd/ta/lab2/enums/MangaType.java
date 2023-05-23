package com.solvd.ta.lab2.enums;

public enum MangaType {
	SHONEN("Manga targeted towards teen boys"), SHOJO("Manga targeted towards teen girls"),
	SEINEN("Manga targeted towards adult men"), JOSEI("Manga targeted towards adult women");

	private String desc;

	MangaType(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
