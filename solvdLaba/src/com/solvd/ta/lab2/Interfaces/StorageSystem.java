package com.solvd.ta.lab2.Interfaces;

import com.solvd.ta.lab2.Media;
import com.solvd.ta.lab2.Preferences;

public interface StorageSystem {
	public void addMedia(Media media);

	public void removeMedia(Media media);

	public void filterItems(Preferences preferences);
}
